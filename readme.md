# GWT-Bootstrap

## Based on Twitter's Bootstrap. ( http://twitter.github.com/bootstrap/index.html ) 

Examples, tutorials and wiki will be avaliable soon.

## Installation

* Download the zip, extract and add the folder as external source to the build path.
* Add `<inherits name="com.geekvigarista.gwt.bootstrap.BootStrap"/>` to your *.gwt.xml file.

# UiBinder

You can use the widgets in UiBinder. The names of icon and options are the same as in Bootstrap without the preceding "icon-"/"btn-". Examples:

* `<b:Heading size="2">UiBinder Examples</b:Heading>`
* `<b:Button ui:field="button" icon="heart" options="info mini">Testbutton</b:Button>`
* `Hello <b:Abbreviation title="You">u</b:Abbreviation>`, that's <b:Emphasis>me!</b:Emphasis>
* `<b:BlockQuote cite="Me" pullright="true">This is a blockquote.</b:BlockQuote>`
* `<b:ButtonGroup><b:Button>1</b:Button><b:Button>2</b:Button></b:ButtonGroup>`
* `<b:ButtonToolbar><b:ButtonGroup>...</b:ButtonGroup><b:ButtonGroup>...</b:ButtonGroup></b:ButtonToolbar>`
* `<b:Icon type="star"/>`, `<b:Icon type="heart" color="white"/>`
* `<b:UnorderedList><b:ListItem><g:Label>Test</g:Label></b:UnorderedList>`

## Grid System

    <b:FluidContainer>
      <b:Row>
        <b:RowItem size="2"><g:Label>I'm a Label inside a fluid container...</g:Label></b:RowItem>
        <b:RowItem size="2" offset="2"><g:Label>Me too!</g:Label></b:RowItem>
      </b:Row>
      <b:Row fluid="true">
        <b:RowItem size="2"><g:Label>I'm in a Fluid row...</g:Label></b:RowItem>
        <b:RowItem size="2" offset="2"><g:Label>Me too!</g:Label></b:RowItem>
      </b:Row>
    </b:FluidContainer>`

## Navbar

    <b:Navbar fixed="top">
    	<b:Brand>Bootstrap</b:Brand>
    	<b:Nav>
    		<b:NavLink>Test</b:NavLink>
    		<b:DividerVertical />
    		<b:NavLink href="http://www.google.com">Another Test</b:NavLink>
    	</b:Nav>
    	<b:NavForm size="1"/>
    	<b:Nav alignment="right">
    		<b:NavLink>Test</b:NavLink>
    	</b:Nav>
    	<b:NavText alignment="right">Right</b:NavText>
    	<b:NavSearch size="2" placeholder="Search" alignment="right"/>
    </b:Navbar>