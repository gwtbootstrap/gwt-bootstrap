package com.github.gwtbootstrap.client.ui.plugin;

import com.github.gwtbootstrap.client.ui.constants.BackdropType;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.plugins.Plugin;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;

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

    /**
     * @param element Modal element
     * @param close Close button
     * @param option Modal options
     * @return Modal Handler
     */
    public Modal.ModalHandler modal(Element element, Element close, Modal.Option option) {
        Modal.ModalHandler handler = null;

        GQuery elem = $(element);

        handler = elem.data(DATA_NAME, Modal.ModalHandler.class);

        if (handler == null) {
            handler = new Modal.ModalHandler(element, close, option);
            elem.data(DATA_NAME, handler);
        }
        return handler;
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
        private GQuery $close;
        private final Modal.Option option;
        private GQuery $backdrop;
        private Function onHide;
        private Function onHidden;
        private Function onShow;
        private Function onShown;

        /**
         * Default Constructor
         *
         * @param element target element
         * @param close close button
         * @param option options
         */
        public ModalHandler(Element element, Element close, Modal.Option option) {
            this.$element = $(element);
            this.$close = $(close);
            this.option = option;
            $close.click(hide);
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
            if (onShow != null) {
                onShow.f();
            }
            
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
                                if (onShown != null) {
                                    onShown.f();
                                }
                                return false;
                            }
                        });
                    } else {
                        if (onShown != null) {
                            onShown.f();
                        }
                    }
                    return false;

                }
            });
        }

        public void hide() {
            hide.f((Event) null);
        }
        
        private Function hide = new Function() {
            @Override
            public boolean f(Event e) {
                if (e != null) {
                    e.preventDefault();
                }
                if (onHide != null) {
                    onHide.f();
                }

                if (!isShown) {
                    return false;
                }

                isShown = false;
                $("body").removeClass("modal-open");

                escape();

                $(document).die("focusin.modal");

                $element.removeClass("in").attr("aria-hidden", true);

                if (trans.isSupported() && $element.hasClass("fade")) {
                    hideWithTransition();
                } else {
                    hideModal();
                }
                return false;
            }
        };

        private void backdrop(Function callback) {
            boolean animate = $element.hasClass("fade");

            if ($backdrop == null && isShown && option.backdropType.ordinal() > BackdropType.NONE.ordinal()) {
                boolean doAnimate = trans.isSupported() && animate;
                $backdrop = $("<div class=\"modal-backdrop " + (animate ? "fade" : "") + "\"/>").appendTo(document.getBody());

                if (option.backdropType != BackdropType.STATIC) {
                    $backdrop.click(new Function() {
                        @Override
                        public boolean f(Event e) {
                            Modal.ModalHandler.this.hide.f(e);
                            return false;
                        }
                    });
                }

                if (doAnimate) {
                    $backdrop.get(0).getOffsetWidth(); // force reflow
                }

                $backdrop.addClass("in");

                if (doAnimate) {
                    $backdrop.one(Event.getTypeInt(trans.end), null, callback);
                } else {
                    if (callback != null) {
                        callback.f();
                    }
                }
            } else if (!isShown && $backdrop != null) {
                $backdrop.removeClass("in");
                if (trans.isSupported() && $element.hasClass("fade")) {
                    $backdrop.one(Event.getTypeInt(trans.end), null, new Function() {
                        @Override
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
            $backdrop.remove();
            $backdrop = null;
        }

        public void enforceFocus() {
            $(document).live("focusin.modal", new Function() {
                @Override
                public boolean f(Event e) {
                    Element target = e.getEventTarget().cast();
                    
                    if ($element.get(0) != target && $element.has(target).length() != 0) {
                        $element.focus();
                    }
                    return false;
                }
                
            });
        }
            
        private void hideWithTransition() {
            final Timer timer = new Timer() {
                @Override
                public void run() {
                    $element.die(trans.end);
                    hideModal();
                }
            };
            timer.schedule(500);

            $element.live(Event.getTypeInt(trans.end), null, new Function() {
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
            backdrop(null);
            if (onHidden != null) {
                onHidden.f();
            }
        }

        /**
         * Install/Remove the event that will close the window if option
         * keyboard is setted
         * <code>true</code> and ESC key is pressed
         */
        private void escape() {
            if (this.isShown && option.keyboard) {
                $(document).bind("keyup.dismiss.modal", new Function() {
                    @Override
                    public boolean f(com.google.gwt.user.client.Event e) {
                        if (e.getKeyCode() == 27) {
                            hide.f(e);
                        }
                        return false;
                    }
                });
            } else if (!this.isShown) {
                $(document).unbind("keyup.dismiss.modal");
            }
        }
        
        public void setOnHide(Function f) {
            onHide = f;
        }
        
        public void setOnHidden(Function f) {
            onHidden = f;
        }
        
        public void setOnShow(Function f) {
            onShow = f;
        }
        
        public void setOnShown(Function f) {
            onShown = f;
        }
    }
}
