package com.github.gwtbootstrap.client.ui.incubator;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.Label;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Usage Example:<br/>
 * <ul><li>
 * Put following code into your ui.xml file:<br/>
 * <code>
 * &lt;bi:PickList ui:field="pickList" /&gt;
 * </code><br/><br/>
 *
 * </li><li>
 * Populate your picklist using {@link NameValuePairImpl}:<br/>
 * <code>
 *     List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();<br/>
 *     nameValuePairs.add(new NameValuePairImpl("item 1", "item_1"));<br/>
 *     nameValuePairs.add(new NameValuePairImpl("item 2", "item_2"));<br/>
 *     nameValuePairs.add(new NameValuePairImpl("item 3", "item_3"));<br/>
 *     pickList.setLeftListElements(nameValuePairs);
 *     pickList.setRightListElements(nameValuePairs);
 * </code><br/>
 * </li></ul>
 *
 * Screenshot:
 * <br/>
 * <img src="http://gamenism.com/gwt/picklist.png"/>
 * <br/>
 *
 * User: Halil Karakose
 * Date: 10/18/13
 * Time: 3:53 PM
 *
 * @see NameValuePairImpl
 */
public class PickList extends Composite {
    @UiField
    VerticalPanel leftPanel;
    @UiField
    VerticalPanel rightPanel;
    @UiField
    VerticalPanel buttonPanel;

    @UiField
    Button toRightButton;
    @UiField
    Button toLeftButton;
    @UiField
    ListBox leftList;
    @UiField
    ListBox rightList;
    @UiField
    Label rightPanelLabel;
    @UiField
    Label leftPanelLabel;

    public void clearLeftList() {
        clear(leftList);
    }

    public void clearRightList() {
        clear(rightList);
    }

    private void clear(ListBox listBox) {
        listBox.clear();
    }

    public void addElementToLeftList(NameValuePair element) {
        addElement(leftList, element);
    }

    public void addElementToRightList(NameValuePair element) {
        addElement(rightList, element);
    }

    private void addElement(ListBox listBox, NameValuePair element) {
        listBox.addItem(element.name(), element.value());
    }

    public List<NameValuePair> getLeftListElements() {
        return getListBoxElements(leftList);
    }

    public void setLeftListElements(List<NameValuePair> elements) {
        populate(elements, leftList);
    }

    public List<NameValuePair> getRightListElements() {
        return getListBoxElements(rightList);
    }

    public void setRightListElements(List<NameValuePair> elements) {
        populate(elements, rightList);
    }

    public String getSelectedLabelText() {
        return rightPanelLabel.getText();
    }

    public void setSelectedLabelText(String selectedLabelText) {
        rightPanelLabel.setText(selectedLabelText);
    }

    public String getCandidateLabelText() {
        return leftPanelLabel.getText();
    }

    public void setCandidateLabelText(String selectedLabelText) {
        leftPanelLabel.setText(selectedLabelText);
    }

    private List<NameValuePair> getListBoxElements(ListBox listBox) {
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        for (int i = 0; i < this.leftList.getItemCount(); i++) {
            NameValuePairImpl nameValuePair = new NameValuePairImpl(this.leftList.getItemText(i), this.leftList.getValue(i));
            nameValuePairs.add(nameValuePair);
        }
        return nameValuePairs;
    }

    private void populate(List<NameValuePair> leftListElements, ListBox listBox) {
        for (NameValuePair element : leftListElements) {
            listBox.addItem(element.name(), element.value());
        }
    }

    @UiHandler("toRightButton")
    public void toRightButtonClicked(ClickEvent event) {
        moveItem(leftList, rightList, event);

        if (leftList.getItemCount() == 0) {
            toRightButton.setEnabled(false);
        }

        if (rightList.getItemCount() >= 1) { // !>= 1! is preferred instead of !== 1! to handle multiple selections
            toLeftButton.setEnabled(true);
        }
    }

    @UiHandler("toLeftButton")
    public void toLeftButtonClicked(ClickEvent event) {
        moveItem(rightList, leftList, event);
        if (rightList.getItemCount() == 0) {
            toLeftButton.setEnabled(false);
        }

        if (leftList.getItemCount() >= 1) { // !>= 1! is preferred instead of !== 1! to handle multiple selections
            toRightButton.setEnabled(true);
        }
    }

    private void moveItem(ListBox from, ListBox to, ClickEvent event) {
        String value = from.getValue();
        if (value == null) {
            Window.alert("Select an item first!");
            return;
        }

        int itemIndex = from.getSelectedIndex();
        String item = from.getItemText(itemIndex);
        GWT.log("value: " + value + "\n"
                + "selected index: " + itemIndex + "\n"
                + "selected text: " + item);

        to.addItem(item, value);
        from.removeItem(itemIndex);

        if (from.getItemCount() > itemIndex) {
            from.setSelectedIndex(itemIndex);
        } else if (from.getItemCount() > 0) {
            from.setSelectedIndex(itemIndex-1); //enters here when last item in the list is removed
        }
    }

    interface PickListUiBinder extends UiBinder<HorizontalPanel, PickList> {
    }

    private static PickListUiBinder ourUiBinder = GWT.create(PickListUiBinder.class);

    public PickList() {
        initWidget(ourUiBinder.createAndBindUi(this));

        //set padding between cells to make the component look better
        this.getElement().setAttribute("cellpadding", "1");
        leftPanel.getElement().setAttribute("cellpadding", "1");
        buttonPanel.getElement().setAttribute("cellpadding", "1");
        rightPanel.getElement().setAttribute("cellpadding", "1");

        setLeftListElements(new ArrayList<NameValuePair>());
        setRightListElements(new ArrayList<NameValuePair>());
    }
}