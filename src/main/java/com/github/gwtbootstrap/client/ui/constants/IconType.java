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
package com.github.gwtbootstrap.client.ui.constants;

import com.github.gwtbootstrap.client.ui.base.Style;

//@formatter:off
/**
 * Type of the <a href="http://glyphicons.com/">Glyphicon.</a>
 * 
 * @since 2.0.3.0
 * 
 * @author Carlos Alexandro Becker
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/base-css.html#icons">Bootstrap documentation</a>
 * 
 */
//@formatter:on
public enum IconType implements Style {

	GLASS("glass"),
	MUSIC("music"),
	SEARCH("search"),
	ENVELOPE("envelope"),
	HEART("heart"),
	STAR("star"),
	STAR_EMPTY("star-empty"),
	USER("user"),
	FILM("film"),
	TH_LARGE("th-large"),
	TH("th"),
	TH_LIST("th-list"),
	OK("ok"),
	REMOVE("remove"),
	ZOOM_IN("zoom-in"),
	ZOOM_OUT("zoom-out"),
	OFF("off"),
	SIGNAL("signal"),
	COG("cog"),
	TRASH("trash"),
	HOME("home"),
	FILE("file"),
	TIME("time"),
	ROAD("road"),
	DOWNLOAD_ALT("download-alt"),
	DOWNLOAD("download"),
	UPLOAD("upload"),
	INBOX("inbox"),
	PLAY_CIRCLE("play-circle"),
	REPEAT("repeat"),
	REFRESH("refresh"),
	LIST_ALT("list-alt"),
	LOCK("lock"),
	FLAG("flag"),
	HEADPHONES("headphones"),
	VOLUME_OFF("volume-off"),
	VOLUME_DOWN("volume-down"),
	VOLUME_UP("volume-up"),
	QRCODE("qrcode"),
	BARCODE("barcode"),
	TAG("tag"),
	TAGS("tags"),
	BOOK("book"),
	BOOKMARK("bookmark"),
	PRINT("print"),
	CAMERA("camera"),
	FONT("font"),
	BOLD("bold"),
	ITALIC("italic"),
	TEXT_HEIGHT("text-height"),
	TEXT_WIDTH("text-width"),
	ALIGN_LEFT("align-left"),
	ALIGN_CENTER("align-center"),
	ALIGN_RIGHT("align-right"),
	ALIGN_JUSTIFY("align-justify"),
	LIST("list"),
	INDENT_LEFT("indent-left"),
	INDENT_RIGHT("indent-right"),
	FACETIME_VIDEO("facetime-video"),
	PICTURE("picture"),
	PENCIL("pencil"),
	MAP_MARKER("map-marker"),
	ADJUST("adjust"),
	TINT("tint"),
	EDIT("edit"),
	SHARE("share"),
	CHECK("check"),
	MOVE("move"),
	STEP_BACKWARD("step-backward"),
	FAST_BACKWARD("fast-backward"),
	BACKWARD("backward"),
	PLAY("play"),
	PAUSE("pause"),
	STOP("stop"),
	FORWARD("forward"),
	FAST_FORWARD("fast-forward"),
	STEP_FORWARD("step-forward"),
	EJECT("eject"),
	CHEVRON_LEFT("chevron-left"),
	CHEVRON_RIGHT("chevron-right"),
	PLUS_SIGN("plus-sign"),
	MINUS_SIGN("minus-sign"),
	REMOVE_SIGN("remove-sign"),
	OK_SIGN("ok-sign"),
	QUESTION_SIGN("question-sign"),
	INFO_SIGN("info-sign"),
	SCREENSHOT("screenshot"),
	REMOVE_CIRCLE("remove-circle"),
	OK_CIRCLE("ok-circle"),
	BAN_CIRCLE("ban-circle"),
	ARROW_LEFT("arrow-left"),
	ARROW_RIGHT("arrow-right"),
	ARROW_UP("arrow-up"),
	ARROW_DOWN("arrow-down"),
	SHARE_ALT("share-alt"),
	RESIZE_FULL("resize-full"),
	RESIZE_SMALL("resize-small"),
	PLUS("plus"),
	MINUS("minus"),
	ASTERISK("asterisk"),
	EXCLAMATION_SIGN("exclamation-sign"),
	GIFT("gift"),
	LEAF("leaf"),
	FIRE("fire"),
	EYE_OPEN("eye-open"),
	EYE_CLOSE("eye-close"),
	WARNING_SIGN("warning-sign"),
	PLANE("plane"),
	CALENDAR("calendar"),
	RANDOM("random"),
	COMMENT("comment"),
	MAGNET("magnet"),
	CHEVRON_UP("chevron-up"),
	CHEVRON_DOWN("chevron-down"),
	RETWEET("retweet"),
	SHOPPING_CART("shopping-cart"),
	FOLDER_CLOSE("folder-close"),
	FOLDER_OPEN("folder-open"),
	RESIZE_VERTICAL("resize-vertical"),
	RESIZE_HORIZONTAL("resize-horizontal"),
	BAR("bar");

	private static final String PREFIX = "icon-";

	private String className;

	private IconType(String className) {
		this.className = className;
	}

	/**
	 * {@inheritDoc}
	 */
	public String get() {
		return PREFIX + className;
	}
}
