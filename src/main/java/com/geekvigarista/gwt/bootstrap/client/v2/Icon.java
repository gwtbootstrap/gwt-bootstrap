/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekvigarista.gwt.bootstrap.client.v2;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author carlos
 */
public class Icon extends Widget {

    public enum Type {

        /**
         * To gen this enum, go to
         * http://twitter.github.com/bootstrap/base-css.html open browser
         * console, and create a prototyped replaceAll function:
         *
         * String.prototype.replaceAll = function(de, para){ return
         *
         * this.replace(new RegExp(de, 'g'), para); } and so, run this shit:          *
         * jQuery('.the-icons li i').each( function(){ var c =
         * $(this).attr("class"); console.log(c.replace('icon-',
         * '').replaceAll('-', '_').toUpperCase() + ' { @Override public String
         * getStyle(){ return "' + c + '";} },'); } );          *
         *
         * and voaláh
         *
         */
        GLASS {

            @Override
            public String getStyle() {
                return "icon-glass";
            }
        },
        MUSIC {

            @Override
            public String getStyle() {
                return "icon-music";
            }
        },
        SEARCH {

            @Override
            public String getStyle() {
                return "icon-search";
            }
        },
        ENVELOPE {

            @Override
            public String getStyle() {
                return "icon-envelope";
            }
        },
        HEART {

            @Override
            public String getStyle() {
                return "icon-heart";
            }
        },
        STAR {

            @Override
            public String getStyle() {
                return "icon-star";
            }
        },
        STAR_EMPTY {

            @Override
            public String getStyle() {
                return "icon-star-empty";
            }
        },
        USER {

            @Override
            public String getStyle() {
                return "icon-user";
            }
        },
        FILM {

            @Override
            public String getStyle() {
                return "icon-film";
            }
        },
        TH_LARGE {

            @Override
            public String getStyle() {
                return "icon-th-large";
            }
        },
        TH {

            @Override
            public String getStyle() {
                return "icon-th";
            }
        },
        TH_LIST {

            @Override
            public String getStyle() {
                return "icon-th-list";
            }
        },
        OK {

            @Override
            public String getStyle() {
                return "icon-ok";
            }
        },
        REMOVE {

            @Override
            public String getStyle() {
                return "icon-remove";
            }
        },
        ZOOM_IN {

            @Override
            public String getStyle() {
                return "icon-zoom-in";
            }
        },
        ZOOM_OUT {

            @Override
            public String getStyle() {
                return "icon-zoom-out";
            }
        },
        OFF {

            @Override
            public String getStyle() {
                return "icon-off";
            }
        },
        SIGNAL {

            @Override
            public String getStyle() {
                return "icon-signal";
            }
        },
        COG {

            @Override
            public String getStyle() {
                return "icon-cog";
            }
        },
        TRASH {

            @Override
            public String getStyle() {
                return "icon-trash";
            }
        },
        HOME {

            @Override
            public String getStyle() {
                return "icon-home";
            }
        },
        FILE {

            @Override
            public String getStyle() {
                return "icon-file";
            }
        },
        TIME {

            @Override
            public String getStyle() {
                return "icon-time";
            }
        },
        ROAD {

            @Override
            public String getStyle() {
                return "icon-road";
            }
        },
        DOWNLOAD_ALT {

            @Override
            public String getStyle() {
                return "icon-download-alt";
            }
        },
        DOWNLOAD {

            @Override
            public String getStyle() {
                return "icon-download";
            }
        },
        UPLOAD {

            @Override
            public String getStyle() {
                return "icon-upload";
            }
        },
        INBOX {

            @Override
            public String getStyle() {
                return "icon-inbox";
            }
        },
        PLAY_CIRCLE {

            @Override
            public String getStyle() {
                return "icon-play-circle";
            }
        },
        REPEAT {

            @Override
            public String getStyle() {
                return "icon-repeat";
            }
        },
        REFRESH {

            @Override
            public String getStyle() {
                return "icon-refresh";
            }
        },
        LIST_ALT {

            @Override
            public String getStyle() {
                return "icon-list-alt";
            }
        },
        LOCK {

            @Override
            public String getStyle() {
                return "icon-lock";
            }
        },
        FLAG {

            @Override
            public String getStyle() {
                return "icon-flag";
            }
        },
        HEADPHONES {

            @Override
            public String getStyle() {
                return "icon-headphones";
            }
        },
        VOLUME_OFF {

            @Override
            public String getStyle() {
                return "icon-volume-off";
            }
        },
        VOLUME_DOWN {

            @Override
            public String getStyle() {
                return "icon-volume-down";
            }
        },
        VOLUME_UP {

            @Override
            public String getStyle() {
                return "icon-volume-up";
            }
        },
        QRCODE {

            @Override
            public String getStyle() {
                return "icon-qrcode";
            }
        },
        BARCODE {

            @Override
            public String getStyle() {
                return "icon-barcode";
            }
        },
        TAG {

            @Override
            public String getStyle() {
                return "icon-tag";
            }
        },
        TAGS {

            @Override
            public String getStyle() {
                return "icon-tags";
            }
        },
        BOOK {

            @Override
            public String getStyle() {
                return "icon-book";
            }
        },
        BOOKMARK {

            @Override
            public String getStyle() {
                return "icon-bookmark";
            }
        },
        PRINT {

            @Override
            public String getStyle() {
                return "icon-print";
            }
        },
        CAMERA {

            @Override
            public String getStyle() {
                return "icon-camera";
            }
        },
        FONT {

            @Override
            public String getStyle() {
                return "icon-font";
            }
        },
        BOLD {

            @Override
            public String getStyle() {
                return "icon-bold";
            }
        },
        ITALIC {

            @Override
            public String getStyle() {
                return "icon-italic";
            }
        },
        TEXT_HEIGHT {

            @Override
            public String getStyle() {
                return "icon-text-height";
            }
        },
        TEXT_WIDTH {

            @Override
            public String getStyle() {
                return "icon-text-width";
            }
        },
        ALIGN_LEFT {

            @Override
            public String getStyle() {
                return "icon-align-left";
            }
        },
        ALIGN_CENTER {

            @Override
            public String getStyle() {
                return "icon-align-center";
            }
        },
        ALIGN_RIGHT {

            @Override
            public String getStyle() {
                return "icon-align-right";
            }
        },
        ALIGN_JUSTIFY {

            @Override
            public String getStyle() {
                return "icon-align-justify";
            }
        },
        LIST {

            @Override
            public String getStyle() {
                return "icon-list";
            }
        },
        INDENT_LEFT {

            @Override
            public String getStyle() {
                return "icon-indent-left";
            }
        },
        INDENT_RIGHT {

            @Override
            public String getStyle() {
                return "icon-indent-right";
            }
        },
        FACETIME_VIDEO {

            @Override
            public String getStyle() {
                return "icon-facetime-video";
            }
        },
        PICTURE {

            @Override
            public String getStyle() {
                return "icon-picture";
            }
        },
        PENCIL {

            @Override
            public String getStyle() {
                return "icon-pencil";
            }
        },
        MAP_MARKER {

            @Override
            public String getStyle() {
                return "icon-map-marker";
            }
        },
        ADJUST {

            @Override
            public String getStyle() {
                return "icon-adjust";
            }
        },
        TINT {

            @Override
            public String getStyle() {
                return "icon-tint";
            }
        },
        EDIT {

            @Override
            public String getStyle() {
                return "icon-edit";
            }
        },
        SHARE {

            @Override
            public String getStyle() {
                return "icon-share";
            }
        },
        CHECK {

            @Override
            public String getStyle() {
                return "icon-check";
            }
        },
        MOVE {

            @Override
            public String getStyle() {
                return "icon-move";
            }
        },
        STEP_BACKWARD {

            @Override
            public String getStyle() {
                return "icon-step-backward";
            }
        },
        FAST_BACKWARD {

            @Override
            public String getStyle() {
                return "icon-fast-backward";
            }
        },
        BACKWARD {

            @Override
            public String getStyle() {
                return "icon-backward";
            }
        },
        PLAY {

            @Override
            public String getStyle() {
                return "icon-play";
            }
        },
        PAUSE {

            @Override
            public String getStyle() {
                return "icon-pause";
            }
        },
        STOP {

            @Override
            public String getStyle() {
                return "icon-stop";
            }
        },
        FORWARD {

            @Override
            public String getStyle() {
                return "icon-forward";
            }
        },
        FAST_FORWARD {

            @Override
            public String getStyle() {
                return "icon-fast-forward";
            }
        },
        STEP_FORWARD {

            @Override
            public String getStyle() {
                return "icon-step-forward";
            }
        },
        EJECT {

            @Override
            public String getStyle() {
                return "icon-eject";
            }
        },
        CHEVRON_LEFT {

            @Override
            public String getStyle() {
                return "icon-chevron-left";
            }
        },
        CHEVRON_RIGHT {

            @Override
            public String getStyle() {
                return "icon-chevron-right";
            }
        },
        PLUS_SIGN {

            @Override
            public String getStyle() {
                return "icon-plus-sign";
            }
        },
        MINUS_SIGN {

            @Override
            public String getStyle() {
                return "icon-minus-sign";
            }
        },
        REMOVE_SIGN {

            @Override
            public String getStyle() {
                return "icon-remove-sign";
            }
        },
        OK_SIGN {

            @Override
            public String getStyle() {
                return "icon-ok-sign";
            }
        },
        QUESTION_SIGN {

            @Override
            public String getStyle() {
                return "icon-question-sign";
            }
        },
        INFO_SIGN {

            @Override
            public String getStyle() {
                return "icon-info-sign";
            }
        },
        SCREENSHOT {

            @Override
            public String getStyle() {
                return "icon-screenshot";
            }
        },
        REMOVE_CIRCLE {

            @Override
            public String getStyle() {
                return "icon-remove-circle";
            }
        },
        OK_CIRCLE {

            @Override
            public String getStyle() {
                return "icon-ok-circle";
            }
        },
        BAN_CIRCLE {

            @Override
            public String getStyle() {
                return "icon-ban-circle";
            }
        },
        ARROW_LEFT {

            @Override
            public String getStyle() {
                return "icon-arrow-left";
            }
        },
        ARROW_RIGHT {

            @Override
            public String getStyle() {
                return "icon-arrow-right";
            }
        },
        ARROW_UP {

            @Override
            public String getStyle() {
                return "icon-arrow-up";
            }
        },
        ARROW_DOWN {

            @Override
            public String getStyle() {
                return "icon-arrow-down";
            }
        },
        SHARE_ALT {

            @Override
            public String getStyle() {
                return "icon-share-alt";
            }
        },
        RESIZE_FULL {

            @Override
            public String getStyle() {
                return "icon-resize-full";
            }
        },
        RESIZE_SMALL {

            @Override
            public String getStyle() {
                return "icon-resize-small";
            }
        },
        PLUS {

            @Override
            public String getStyle() {
                return "icon-plus";
            }
        },
        MINUS {

            @Override
            public String getStyle() {
                return "icon-minus";
            }
        },
        ASTERISK {

            @Override
            public String getStyle() {
                return "icon-asterisk";
            }
        },
        EXCLAMATION_SIGN {

            @Override
            public String getStyle() {
                return "icon-exclamation-sign";
            }
        },
        GIFT {

            @Override
            public String getStyle() {
                return "icon-gift";
            }
        },
        LEAF {

            @Override
            public String getStyle() {
                return "icon-leaf";
            }
        },
        FIRE {

            @Override
            public String getStyle() {
                return "icon-fire";
            }
        },
        EYE_OPEN {

            @Override
            public String getStyle() {
                return "icon-eye-open";
            }
        },
        EYE_CLOSE {

            @Override
            public String getStyle() {
                return "icon-eye-close";
            }
        },
        WARNING_SIGN {

            @Override
            public String getStyle() {
                return "icon-warning-sign";
            }
        },
        PLANE {

            @Override
            public String getStyle() {
                return "icon-plane";
            }
        },
        CALENDAR {

            @Override
            public String getStyle() {
                return "icon-calendar";
            }
        },
        RANDOM {

            @Override
            public String getStyle() {
                return "icon-random";
            }
        },
        COMMENT {

            @Override
            public String getStyle() {
                return "icon-comment";
            }
        },
        MAGNET {

            @Override
            public String getStyle() {
                return "icon-magnet";
            }
        },
        CHEVRON_UP {

            @Override
            public String getStyle() {
                return "icon-chevron-up";
            }
        },
        CHEVRON_DOWN {

            @Override
            public String getStyle() {
                return "icon-chevron-down";
            }
        },
        RETWEET {

            @Override
            public String getStyle() {
                return "icon-retweet";
            }
        },
        SHOPPING_CART {

            @Override
            public String getStyle() {
                return "icon-shopping-cart";
            }
        },
        FOLDER_CLOSE {

            @Override
            public String getStyle() {
                return "icon-folder-close";
            }
        },
        FOLDER_OPEN {

            @Override
            public String getStyle() {
                return "icon-folder-open";
            }
        },
        RESIZE_VERTICAL {

            @Override
            public String getStyle() {
                return "icon-resize-vertical";
            }
        },
        RESIZE_HORIZONTAL {

            @Override
            public String getStyle() {
                return "icon-resize-horizontal";
            }
        };

        public abstract String getStyle();
    }

    public enum COLOR {

        WHITE, BLACK;
    }

    {
        setElement(DOM.createElement("i"));
    }

    public Icon(Type type, COLOR color) {
        setStylePrimaryName(type.getStyle());
        if (color == COLOR.WHITE) {
            addStyleName("icon-white");
        }
    }
    
    public Icon(Type type) {
        setStylePrimaryName(type.getStyle());
    }
}
