/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.client.ui;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.KeyboardListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Masked TextBox for Bootstrap form
 * 
 * Mask expressions: 
 *          9 -> numeric digit only
 *          a -> text characteres only
 *          * -> alpha-numeric characteres
 * 
 * Example:
      *          date expression: 99/99/9999
 *      zip code expression (BR): 99999-999
 *              state expression: aa
 * 
 * @author cassio
 */
public class MaskedTextBox extends TextBox implements BlurHandler, FocusHandler,
        KeyPressHandler, KeyDownHandler {

    @Override
    public void onBlur(BlurEvent event) {
        checkVal(false);
    }

    @Override
    public void onFocus(FocusEvent event) {

        focusText = "";

        if (getValue() != null) {
            focusText = getValue();
        }

        int pos = checkVal(false);
        writeBuffer();

        if (pos == mask.length()) {
            cursorBegin = 0;
            cursorEnd = pos;

            setSelectionRange(pos, 0);
        } else {
            cursorBegin = pos;
            cursorEnd = pos;

            setCursorPos(pos);
        }
    }

    @Override
    public void onKeyPress(KeyPressEvent event) {
        int k = event.getUnicodeCharCode();

        if (ignore) {
            // Fixes Mac FF bug on backspace

            if (k == KeyboardListener.KEY_BACKSPACE) {
                cancelKey();
            }

            return;
        }

        if (event.isControlKeyDown() || event.isAltKeyDown()) {// Ignore

            cancelKey();

        } else if (k >= 32 && k <= 125 || k > 186) {// typeable characters

            int p = seekNext(getCursorPos() - 1);

            if (p < len) {

                String c = String.valueOf((char) event.getUnicodeCharCode());

                if (c.matches(tests[p])) {

                    shiftR(p);
                    buffer[p] = c;
                    writeBuffer();
                    int next = seekNext(p);

                    setCursorPos(next);

                    cursorBegin = next;
                    cursorEnd = next;
                }
            }
        }

        cancelKey();
    }

    @Override
    public void onKeyDown(KeyDownEvent event) {

        int k = event.getNativeKeyCode();

        ignore = k < 16 || k > 16 && k < 32 || k > 32 && k < 41;

        // delete selection before proceeding
        if (cursorBegin - cursorEnd != 0 && (!ignore || k == KeyboardListener.KEY_BACKSPACE || k == KeyboardListener.KEY_DELETE)) {
            clearBuffer(cursorBegin, cursorEnd);
        }

        // backspace, delete, and escape get special treatment
        if (k == KeyboardListener.KEY_BACKSPACE || k == KeyboardListener.KEY_DELETE) {

            shiftL(getCursorPos() + (k == KeyboardListener.KEY_DELETE ? 0 : -1));
            cancelKey();
        } else if (k == KeyboardListener.KEY_ESCAPE) {// escape
            setValue(focusText);
            cancelKey();
        }
    }

    public class Settings {

        private String placeHolder;

        public Settings() {
        }

        public Settings(String placeHolder) {
            this.placeHolder = placeHolder;
        }

        public String getPlaceHolder() {
            return placeHolder;
        }

        public void setPlaceHolder(String placeHolder) {
            this.placeHolder = placeHolder;
        }
    }
    private final String mask;
    private int len;
    private Settings settings;
    private int partialPosition;
    private String[] buffer;
    private boolean ignore;
    private String focusText;
    private String[] tests;
    private Integer firstNonMaskPos;
    private int cursorBegin = -1;
    private int cursorEnd = -1;
    private static final Map<String, String> defs;

    static {

        defs = new HashMap<String, String>();
        defs.put("9", "[0-9]");
        defs.put("a", "[A-Za-z]");
        defs.put("*", "[A-Za-z0-9]");

    }

    private static boolean cotainDef(String key) {

        if (defs.get(key) != null) {
            return true;
        } else {
            return false;
        }
    }

    private static String getDef(String key) {
        return defs.get(key);
    }

    /**
     * @param mask Mask expression
     */
    public MaskedTextBox(String mask) {
        this.mask = mask;

        addBlurHandler(this);
        addFocusHandler(this);
        addKeyDownHandler(this);
        addKeyPressHandler(this);

        maskField();
    }

    private void buffer() {

        String[] aux = split(mask);

        buffer = new String[aux.length];

        for (int i = 0; i < aux.length; i++) {

            if (cotainDef(aux[i])) {
                buffer[i] = settings.getPlaceHolder();
            } else {
                buffer[i] = aux[i];
            }

        }

    }

    private int checkVal(boolean allow) {

        String test = "";

        if (getValue() != null) {
            test = getValue();
        }

        int lastMatch = -1;

        int a = 0;

        for (int i = 0, pos = 0; i < len; i++) {

            if (tests[i] != null) {

                buffer[i] = settings.getPlaceHolder();

                while (pos++ < test.length()) {

                    String c = String.valueOf(test.charAt(pos - 1));

                    if (c.matches(tests[i])) {

                        buffer[i] = String.valueOf(c);
                        lastMatch = i;
                        break;
                    }
                }
                if (pos > test.length()) {
                    break;
                }
            } else if (i != partialPosition) {

                try {

                    char d = test.charAt(pos);

                    if (buffer[i].equals(String.valueOf(d))) {

                        pos++;
                        lastMatch = i;
                    }

                } catch (Exception e) {
                    continue;
                }
            }

            a = i;
        }

        if (!allow && lastMatch + 1 < partialPosition) {

            setValue("");
            clearBuffer(0, len);

        } else if (allow || lastMatch + 1 >= partialPosition) {

            writeBuffer();

            if (!allow) {

                if (getValue() != null) {
                    setValue(getValue().substring(0, lastMatch + 1));
                }
            }
        }

        return a;

    }

    private void clearBuffer(int start, int end) {

        for (int i = start; i < end && i < len; i++) {
            if (tests[i] != null) {
                buffer[i] = settings.getPlaceHolder();
            }
        }

    }

    private void each() {

        for (int i = 0; i < tests.length; i++) {

            String c = tests[i];

            if ("?".equals(c)) {

                len--;
                partialPosition = i;

            } else if (cotainDef(c)) {

                tests[i] = getDef(c);

                if (firstNonMaskPos == null) {
                    firstNonMaskPos = tests.length - 1;
                }

            } else {
                tests[i] = null;
            }

        }

    }

    private void maskField() {

        settings = new Settings("_");

        tests = new String[]{};
        partialPosition = mask.length();
        firstNonMaskPos = null;
        len = mask.length();

        tests = split(mask);

        each();
        buffer();

        ignore = false;

        focusText = "";

        if (getValue() != null) {
            focusText = getValue();
        }

        if (!isReadOnly()) {

            checkVal(false);
        }

    }

    private int seekNext(int index) {

        while (++index <= len) {

            try {
                if (tests[index] != null) {
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }

        return index;

    }

    private void shiftL(int index) {

        for (int i = index; i >= 0; i--) {

            if (tests[i] != null) {

                index = i;
                break;
            }
        }

        for (int i = index; i < len; i++) {

            if (tests[i] != null) {

                buffer[i] = settings.getPlaceHolder();

                int j = seekNext(i);

                if (j < len && buffer[j].matches(tests[i])) {
                    buffer[i] = buffer[j];
                } else {
                    break;
                }
            }
        }

        writeBuffer();

        setCursorPos(index);

    }

    private void shiftR(int index) {

        String c = settings.getPlaceHolder();

        for (int i = index; i < len; i++) {

            if (tests[i] != null) {

                int j = seekNext(i);
                String t = buffer[i];
                buffer[i] = c;
                if (j < len && t.matches(tests[j])) {
                    c = t;
                } else {
                    break;
                }
            }
        }

    }

    private String[] split(String text) {

        int length = text.length();

        String[] array = new String[length];

        for (int i = 0; i < length; i++) {
            array[i] = String.valueOf(text.charAt(i));
        }

        return array;
    }

    private void writeBuffer() {

        String valueAux = "";

        for (String element2 : buffer) {

            valueAux += element2;
        }

        setValue(valueAux);

    }
}
