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

	ADJUST("adjust"),
	ALIGN_CENTER("align-center"),
	ALIGN_JUSTIFY("align-justify"),
	ALIGN_LEFT("align-left"),
	ALIGN_RIGHT("align-right"),
	ARROW_DOWN("arrow-down"),
	ARROW_LEFT("arrow-left"),
	ARROW_RIGHT("arrow-right"),
	ARROW_UP("arrow-up"),
	ASTERISK("asterisk"),
	BACKWARD("backward"),
	BAN_CIRCLE("ban-circle"),
	BAR("bar"),
	BARCODE("barcode"),
	BELL("bell"),
	BOLD("bold"),
	BOOK("book"),
	BOOKMARK("bookmark"),
	BRIEFCASE("briefcase"),
	BULLHORN("bullhorn"),
	CALENDAR("calendar"),
	CAMERA("camera"),
	CERTIFICATE("certificate"),
	CHECK("check"),
	CHEVRON_DOWN("chevron-down"),
	CHEVRON_LEFT("chevron-left"),
	CHEVRON_RIGHT("chevron-right"),
	CHEVRON_UP("chevron-up"),
	CIRCLE_ARROW_DOWN("circle-arrow-down"),
	CIRCLE_ARROW_LEFT("circle-arrow-left"),
	CIRCLE_ARROW_RIGHT("circle-arrow-right"),
	CIRCLE_ARROW_UP("circle-arrow-up"),
	COG("cog"),
	COMMENT("comment"),
	DOWNLOAD("download"),
	DOWNLOAD_ALT("download-alt"),
	EDIT("edit"),
	EJECT("eject"),
	ENVELOPE("envelope"),
	EXCLAMATION_SIGN("exclamation-sign"),
	EYE_CLOSE("eye-close"),
	EYE_OPEN("eye-open"),
	FACETIME_VIDEO("facetime-video"),
	FAST_BACKWARD("fast-backward"),
	FAST_FORWARD("fast-forward"),
	FILE("file"),
	FILM("film"),
	FILTER("filter"),
	FIRE("fire"),
	FLAG("flag"),
	FOLDER_CLOSE("folder-close"),
	FOLDER_OPEN("folder-open"),
	FONT("font"),
	FORWARD("forward"),
	GIFT("gift"),
	GLASS("glass"),
	GLOBE("globe"),
	HAND_DOWN("hand-down"),
	HAND_LEFT("hand-left"),
	HAND_RIGHT("hand-right"),
	HAND_UP("hand-up"),
	HDD("hdd"),
	HEADPHONES("headphones"),
	HEART("heart"),
	HOME("home"),
	INBOX("inbox"),
	INDENT_LEFT("indent-left"),
	INDENT_RIGHT("indent-right"),
	INFO_SIGN("info-sign"),
	ITALIC("italic"),
	LEAF("leaf"),
	LIST("list"),
	LIST_ALT("list-alt"),
	LOCK("lock"),
	MAGNET("magnet"),
	MAP_MARKER("map-marker"),
	MINUS("minus"),
	MINUS_SIGN("minus-sign"),
	MOVE("move"),
	MUSIC("music"),
	OFF("off"),
	OK("ok"),
	OK_CIRCLE("ok-circle"),
	OK_SIGN("ok-sign"),
	PAUSE("pause"),
	PENCIL("pencil"),
	PICTURE("picture"),
	PLANE("plane"),
	PLAY("play"),
	PLAY_CIRCLE("play-circle"),
	PLUS("plus"),
	PLUS_SIGN("plus-sign"),
	PRINT("print"),
	QRCODE("qrcode"),
	QUESTION_SIGN("question-sign"),
	RANDOM("random"),
	REFRESH("refresh"),
	REMOVE("remove"),
	REMOVE_CIRCLE("remove-circle"),
	REMOVE_SIGN("remove-sign"),
	REPEAT("repeat"),
	RESIZE_FULL("resize-full"),
	RESIZE_HORIZONTAL("resize-horizontal"),
	RESIZE_SMALL("resize-small"),
	RESIZE_VERTICAL("resize-vertical"),
	RETWEET("retweet"),
	ROAD("road"),
	SCREENSHOT("screenshot"),
	SEARCH("search"),
	SHARE("share"),
	SHARE_ALT("share-alt"),
	SHOPPING_CART("shopping-cart"),
	SIGNAL("signal"),
	STAR("star"),
	STAR_EMPTY("star-empty"),
	STEP_BACKWARD("step-backward"),
	STEP_FORWARD("step-forward"),
	STOP("stop"),
	TAG("tag"),
	TAGS("tags"),
	TASKS("tasks"),
	TEXT_HEIGHT("text-height"),
	TEXT_WIDTH("text-width"),
	TH("th"),
	THUMBS_DOWN("thumbs-down"),
	THUMBS_UP("thumbs-up"),
	TH_LARGE("th-large"),
	TH_LIST("th-list"),
	TIME("time"),
	TINT("tint"),
	TRASH("trash"),
	UPLOAD("upload"),
	USER("user"),
	VOLUME_DOWN("volume-down"),
	VOLUME_OFF("volume-off"),
	VOLUME_UP("volume-up"),
	WARNING_SIGN("warning-sign"),
	WRENCH("wrench"),
	ZOOM_IN("zoom-in"),
	ZOOM_OUT("zoom-out");

	private static final String PREFIX = "icon-";

	private String className;

	private IconType(String className) {
		this.className = className;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String get() {
		return PREFIX + className;
	}
}
