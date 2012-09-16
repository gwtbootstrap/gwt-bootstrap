package com.github.gwtbootstrap.client.ui.plugin;

import com.github.gwtbootstrap.client.ui.constants.BackdropType;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.plugins.Plugin;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Modal plugin
 *
 * @since 2.1.0.0
 * @author Cássio de Freitas e Silva
 */
public class Modal extends GQuery {
    private static Transition trans = $().as(Transition.Transition);

    
    // Register the plugin in GQuery plugin system and
    // set a shortcut to the class
    public static final Class<Modal> Modal = GQuery.registerPlugin(
            Modal.class, new Plugin<Modal>() {
        @Override
        public Modal init(GQuery gq) {
            return new Modal(gq);
        }
    });
    private static final String DATA_NAME = "modal";

    protected Modal(GQuery gq) {
        super(gq);
    }
    
    public Modal.ModalHandler modal(Element element, Modal.Option option) {
        Modal.ModalHandler modalHandler = new Modal.ModalHandler($(element), option);
        return modalHandler;
    }

    public static class Option {

        private String remote;
        private boolean keyboard;
        private BackdropType backdropType;
        private boolean show;

        /**
         * @return The remote URL.
         */
        public String getRemote() {
            return remote;
        }

        /**
         * @param remote If a remote url is provided, content will be loaded in
         * modal body
         */
        public void setRemote(String remote) {
            this.remote = remote;
        }

        /**
         * @return If <code>true</code> closes the modal when escape key is
         * pressed
         */
        public boolean isKeyboard() {
            return keyboard;
        }

        /**
         * @param keyboard <code>true</code> closes the modal when escape key is
         * pressed
         */
        public void setKeyboard(boolean keyboard) {
            this.keyboard = keyboard;
        }

        /**
         * @return Type of backdrop to be showed
         */
        public BackdropType getBackdropType() {
            return backdropType;
        }

        /**
         * @param backdropType Type of backdrop to be showed
         */
        public void setBackdrop(BackdropType backdropType) {
            this.backdropType = backdropType;
        }

        /**
         * @return If <code>true</code>, the modal will be showed when
         * initialized
         */
        public boolean isShow() {
            return show;
        }

        /**
         *
         * @param show <code>true</code> shows the modal when initialized
         */
        public void setShow(boolean show) {
            this.show = show;
        }

        public Option() {
        }

        /**
         * @param keyboard <code>true</code> closes the modal when escape key is
         * pressed
         * @param backdropType Type of backdrop to be showed
         * @param show <code>true</code> shows the modal when initialized
         */
        public Option(boolean keyboard, BackdropType backdropType, boolean show) {
            this.keyboard = keyboard;
            this.backdropType = backdropType;
            this.show = show;
        }

        /**
         *
         * @param remote If a remote url is provided, content will be loaded in
         * modal body
         * @param keyboard <code>true</code> closes the modal when escape key is
         * pressed
         * @param backdropType Type of backdrop to be showed
         * @param show <code>true</code> shows the modal when initialized
         */
        public Option(String remote, boolean keyboard, BackdropType backdropType, boolean show) {
            this.remote = remote;
            this.keyboard = keyboard;
            this.backdropType = backdropType;
            this.show = show;
        }
    }

    /**
     * The Modal plugin functional Class
     */
    public static class ModalHandler {

        private boolean isShown;
        private final GQuery $element;
        private final Modal.Option option;
        private GQuery backdrop;

        /**
         * Default Constructor
         *
         * @param elem target element
         * @param option options
         */
        public ModalHandler(GQuery elem, Modal.Option option) {
            this.$element = elem;
            this.option = option;
            $element.delegate("[data-dismiss=\"modal\"]", "click.dismiss.modal", new Function() {

                @Override
                public void f() {
                    super.f();
                }

                @Override
                public Object f(Element e, int i) {
                    return super.f(e, i);
                }

                @Override
                public Object f(com.google.gwt.user.client.Element e, int i) {
                    return super.f(e, i);
                }

                @Override
                public Object f(Widget w, int i) {
                    return super.f(w, i);
                }

                @Override
                public void f(Object... data) {
                    super.f(data);
                }

                @Override
                public void f(int i, Object... data) {
                    super.f(i, data);
                }

                @Override
                public boolean f(Event e, Object data) {
                    return super.f(e, data);
                }

                @Override
                public void f(Element e) {
                    super.f(e);
                }

                @Override
                public void f(com.google.gwt.user.client.Element e) {
                    super.f(e);
                }

                @Override
                public void f(Widget w) {
                    super.f(w);
                }
                
                @Override
                public boolean f(Event e) {
                    Modal.ModalHandler.this.hide();
                    return false;
                }
            });
        }

        /**
         * Toggle visibility
         */
        public void toggle() {
            if (isShown) {
                hide();
            } else {
                show();
            }
        }

        public void show() {
            //TODO: implement event
            if (isShown) {
                return;
            }
            
            $("body").addClass("modal-open");

            isShown = true;

            escape();
            
            backdrop(new Function() {
                @Override
                public void f() {
                    f((Event) null);
                }

                @Override
                public boolean f(final Event e) {
                    boolean transition = trans.isSupported() && $element.hasClass("fade");
                    
                    if ($element.parents().length() == 0) {
                        $element.appendTo(document.getBody());
                    }
                    
                    $element.show();
                    
                    if (transition) {
                        $element.elements()[0].getOffsetWidth(); // force reflow
                    }
                    
                    $element.addClass("in").attr("aria-hidden", false).focus();
                    
                    enforceFocus();
                    
                    if (transition) {
                        $element.one(Event.getTypeInt(trans.end), null, new Function() {
                            @Override
                            public boolean f(Event e) {
                                //TODO: implement event
                                return false;
                            }
                        });
                    } else {
                        //TODO: implement event
                    }
                return false;
                    
                }
            });
        }
        
        public void hide() {
            //TODO: implement event
            
            if (!isShown) {
                return;
            }
            
            isShown = false;
            $("body").removeClass("modal-open");
            
            escape();
            
            $element.die("focusin.modal");
            
            $element.removeClass("in").attr("aria-hidden", true);

            if (trans.isSupported() && $element.hasClass("fade")) {
                hideWithTransition();
            } else {
                hideModal();
            }
        }
        
        private void backdrop(Function callback) {
            boolean animate = $element.hasClass("fade");

            if (isShown && option.backdropType.ordinal() > BackdropType.NONE.ordinal()) {
                boolean doAnimate = trans.isSupported() && animate;
                backdrop = $("<div class=\"modal-backdrop " + (animate ? "fade" : "") + "\"/>").appendTo(document.getBody());

                if (option.backdropType != BackdropType.STATIC) {
                    backdrop.click(new Function() {

                        @Override
                        public boolean f(Event e) {
                            Modal.ModalHandler.this.hide();
                            return false;
                        }
                    });
                }
                
                if (doAnimate) {
                    backdrop.get(0).getOffsetWidth(); // force reflow
                }
                
                backdrop.addClass("in");
                
                if (doAnimate) {
                    backdrop.one(Event.getTypeInt(trans.end), null, callback);
                } else {
                    if (callback != null) {
                        callback.f();
                    }
                }
            } else if (!isShown && backdrop != null) {
                    backdrop.removeClass("in");
                    if (trans.isSupported() && $element.hasClass("fade")) {
                        backdrop.one(Event.getTypeInt(trans.end), null, new Function() {
                            public boolean f(Event e) {
                                removeBackdrop();
                                return false;
                            }
                        });
                    } else {
                        removeBackdrop();
                    }
            } else if (callback != null) {
                callback.f();
            }
        }
        
        private void removeBackdrop() {
            backdrop.remove();
            backdrop = null;
        }
        
        public void enforceFocus(){
            //TODO: implement
        }
        
        private void hideWithTransition() {
            final Timer timer = new Timer() {

                @Override
                public void run() {
                    $element.die(trans.end);
                    Modal.ModalHandler.this.hideModal();
                }
            };
            timer.schedule(500);
            
            $element.one(Event.getTypeInt(trans.end), null, new Function() {
                
                @Override
                public boolean f(Event event) {
                    timer.cancel();
                    hideModal();
                    return false;
                }
            });
        }
        
        private void hideModal() {
            $element.hide();
            //TODO: implement event hide
            backdrop(null);
        }

        /**
         * Install/Remove the event that will close the window if option keyboard is
         * setted <code>true</code> and ESC key is pressed
         */
        private void escape() {
            if (this.isShown && option.keyboard) {
                $element.live("keyup.dismiss.modal", new Function() {
                    @Override
                    public boolean f(com.google.gwt.user.client.Event e) {
                        if (e.getKeyCode() == 27) {
                            hide();
                        }
                        return false;
                    }
                });
            } else if (!this.isShown) {
                $element.die("keyup.dismiss.modal");
            }
        }
    }
}
