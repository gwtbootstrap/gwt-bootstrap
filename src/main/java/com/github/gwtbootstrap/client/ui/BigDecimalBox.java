package com.github.gwtbootstrap.client.ui;

import java.math.BigDecimal;
import java.text.ParseException;

import com.github.gwtbootstrap.client.ui.base.ValueBoxBase;
import com.google.gwt.dom.client.Document;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;

/**
 * A ValueBox that uses {@link BigDecimalParser} and {@link BigDecimalRenderer}. for Bootstrap
 * 
 * @since 2.1.0.0
 * @author Nick Lim
 */
public class BigDecimalBox extends ValueBoxBase<BigDecimal> {
    public BigDecimalBox() {
        super(Document.get().createTextInputElement(), BigDecimalRenderer.instance(),
                BigDecimalParser.instance());
    }

    static class BigDecimalParser implements Parser<BigDecimal> {

        private static BigDecimalParser INSTANCE;

        /**
         * @return the instance of the no-op renderer
         */
        public static Parser<BigDecimal> instance() {
            if (INSTANCE == null) {
                INSTANCE = new BigDecimalParser();
            }
            return INSTANCE;
        }

        protected BigDecimalParser() {}

        public BigDecimal parse(CharSequence object) throws ParseException {
            if (object == null || "".equals(object.toString())) {
                return null;
            }

            try {
                return new BigDecimal(object.toString());
            } catch (NumberFormatException e) {
                throw new ParseException(e.getMessage(), 0);
            }
        }
    }

    static class BigDecimalRenderer extends AbstractRenderer<BigDecimal> {
        private static BigDecimalRenderer INSTANCE;

        /**
         * @return the instance
         */
        public static Renderer<BigDecimal> instance() {
            if (INSTANCE == null) {
                INSTANCE = new BigDecimalRenderer();
            }
            return INSTANCE;
        }

        protected BigDecimalRenderer() {}

        public String render(BigDecimal object) {
            if (object == null) {
                return "";
            }

            return object.toString();
        }
    }
}
