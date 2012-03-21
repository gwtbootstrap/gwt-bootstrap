# GWT-Bootstrap

## Based on Twitter's Bootstrap. ( http://twitter.github.com/bootstrap/index.html ) 

Examples, tutorials and wiki will be avaliable soon.

## Installation

* Download the zip, extract and add the folder as external source to the build path.
* Add `<inherits name="com.geekvigarista.gwt.bootstrap.Bootstrap"/>` to your *.gwt.xml file.

# UiBinder

You can use the widgets in UiBinder. The names of icon and options are the same as in Bootstrap without the preceding "icon-"/"btn-". Examples:

* `<b:Heading size="4" subtext="subtext">Heading</b:Heading>`
* `<b:Button ui:field="button" icon="heart" options="info mini">Testbutton</b:Button>`
* `Hello <b:Abbreviation title="You">u</b:Abbreviation>`, `that's <b:Emphasis>me!</b:Emphasis>`
* `<b:BlockQuote cite="Me" pullright="true">This is a blockquote.</b:BlockQuote>`
* `<b:ButtonGroup><b:Button>1</b:Button><b:Button>2</b:Button></b:ButtonGroup>`
* `<b:ButtonToolbar><b:ButtonGroup>...</b:ButtonGroup><b:ButtonGroup>...</b:ButtonGroup></b:ButtonToolbar>`
* `<b:Icon type="star"/>`, `<b:Icon type="heart" color="white"/>`
* `<b:UnorderedList><b:ListItem><g:Label>Test</g:Label></b:UnorderedList>`
* `<b:Badge type="error" >2</b:Badge>`
* `<b:Well>...</b:Well>`
* Close Icon: `<b:Close />`

## Grid System

    <b:FluidContainer>
      <b:Row>
        <b:Column size="2"><g:Label>I'm a Label inside a fluid container...</g:Label></b:Column>
        <b:Column size="2" offset="2"><g:Label>Me too!</g:Label></b:Column>
      </b:Row>
      <b:Row fluid="true">
        <b:Column size="2"><g:Label>I'm in a Fluid row...</g:Label></b:Column>
        <b:Column size="2" offset="2"><g:Label>Me too!</g:Label></b:Column>
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

## Nav Lists

    <b:NavList>
    	<b:NavHeader>Header</b:NavHeader>
    	<b:NavLink active="true" icon="plane">Test</b:NavLink>
    	<b:Divider />
    	<b:NavLink href="http://www.google.com">Another Test</b:NavLink>
    </b:NavList>

    <b:WellNavList>
    	<b:NavHeader>Header</b:NavHeader>
	    <b:NavLink active="true" icon="plane">Test</b:NavLink>
    	<b:Divider />
    	<b:NavLink href="http://www.google.com">Another Test</b:NavLink>
    </b:WellNavList>

## Hero Unit
    <b:Hero>
    	<b:Heading size="2">Hero Unit</b:Heading>
    	<b:Paragraph>Some Text for the Hero Unit.</b:Paragraph>
    	<b:Paragraph>More text.</b:Paragraph>
    </b:Hero>