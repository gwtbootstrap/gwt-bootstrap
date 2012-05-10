package com.github.gwtbootstrap.client.ui.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.user.client.ui.UIObject;

/**
 * THe helper for {@link HasSize} interface.
 * 
 * @author ohashi keisuke
 * 
 */
public class SizeHelper {

	private static List<SizeSpan> SIZE_LIST;

	// create SIZE_LIST
	static {

		List<SizeSpan> list = new ArrayList<SizeSpan>();

		for (int i = Constants.MINIMUM_SPAN_SIZE; i <= Constants.MAXIMUM_SPAN_SIZE; i++) {
			list.add(new SizeSpan(i));
		}

		SIZE_LIST = Collections.unmodifiableList(list);
	}

	/**
	 * change size style
	 * 
	 * @param widget
	 *            target widget
	 * @param size
	 *            size
	 */
	public static void setSize(UIObject widget, int size) {
		StyleHelper.changeStyle(widget,
								new SizeSpan(size),
								SIZE_LIST.toArray(new SizeSpan[SIZE_LIST.size()])
						);
	}

	private static class SizeSpan implements Style {

		private static final String SIZE_ERROR_MESSAGE = "The size of the Column has to be between " + Constants.MINIMUM_SPAN_SIZE + " and " + Constants.MAXIMUM_SPAN_SIZE + "!";

		private final int size;

		private SizeSpan(int size) {

			if (size < Constants.MINIMUM_SPAN_SIZE)
				throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);

			if (size > Constants.MAXIMUM_SPAN_SIZE)
				throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);

			this.size = size;
		}

		@Override
		public String get() {
			return Constants.SPAN + size;
		}

	}

}
