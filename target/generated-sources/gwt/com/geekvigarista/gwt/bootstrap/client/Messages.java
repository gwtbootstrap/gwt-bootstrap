package com.geekvigarista.gwt.bootstrap.client;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	/home/carlos/workspaces/gwt/gwt-bootstrap/src/main/resources/com/geekvigarista/gwt/bootstrap/client/Messages.properties'.
 */
public interface Messages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Enter your name".
   * 
   * @return translated "Enter your name"
   */
  @DefaultMessage("Enter your name")
  @Key("nameField")
  String nameField();

  /**
   * Translated "Send".
   * 
   * @return translated "Send"
   */
  @DefaultMessage("Send")
  @Key("sendButton")
  String sendButton();
}
