# GWT-Bootstrap

Based on Twitter's Bootstrap. (http://twitter.github.com/bootstrap/index.html) 

## Installation

* Download the zip, extract and add the folder as external source to the build path.
* Add `<inherits name="com.github.gwtbootstrap.Bootstrap"/>` to your *.gwt.xml file.

### Using custom css/js resources

If you need to adapt resources, implement this interface, and add a replace-with tag to your module xml. Example:

1. Create a Resources Interface (extending Resources).
 
 <!-- Avoiding formatting problem -->
 
 	public MyResources extends Resources {
 		@Source("mycss/custom-bootstrap.min.css")
 		TextResource bootstrap_css();
 	}
 
2. Create a ResourceAdapter.

<!-- Avoiding formatting problem -->

 	public MyResourceAdapter implments ResourceAdapter {
 		public Resources getResources() {
 			return GWT.create(MyResources.class);
 		}
 	}
 
3. Add a replace-with tag to your module xml (*.gwt.xml).

<!-- Avoiding formatting problem -->
	
	<replace-with class='userpackage.MyResourceAdapter>
		<when-type-is class="com.github.gwtbootstrap.client.ui.resources.ResourceAdapter">
	</replace-with>

## UiBinder

You can use the widgets in UiBinder. Add the following line to you `*.ui.xml` file:

`xmlns:b="urn:import:com.github.gwtbootstrap.client.ui"`

The names of icon and options are the same as in Bootstrap without the preceding "icon-"/"btn-". Examples:

* `<b:Heading size="4" subtext="subtext">Heading</b:Heading>`
* `Hello <b:Abbreviation title="You">u</b:Abbreviation>`
* `that's <b:Emphasis>me!</b:Emphasis>`
* `<b:BlockQuote cite="Me" pullright="true">This is a blockquote.</b:BlockQuote>`
* `<b:Icon type="star"/>`, `<b:Icon type="heart" color="white"/>`
* `<b:UnorderedList><b:ListItem><g:Label>Test</g:Label></b:UnorderedList>`
* `<b:Badge type="error" >2</b:Badge>`
* `<b:Well>...</b:Well>`
* Close Icon: `<b:Close />`

## Buttons
* `<b:Button ui:field="button" icon="heart" type="info" size="mini">Testbutton</b:Button>`
* `<b:ButtonGroup><b:Button>1</b:Button><b:Button>2</b:Button></b:ButtonGroup>`
* `<b:ButtonToolbar><b:ButtonGroup>...</b:ButtonGroup><b:ButtonGroup>...</b:ButtonGroup></b:ButtonToolbar>`

## Grid System

    <b:FluidContainer>
      <b:Row>
        <b:Column size="2"><g:Label>I'm a Label inside a fluid container...</g:Label></b:Column>
        <b:Column size="2" offset="2"><g:Label>Me too!</g:Label></b:Column>
      </b:Row>
      <b:FluidRow>
        <b:Column size="2"><g:Label>I'm in a Fluid row...</g:Label></b:Column>
        <b:Column size="2" offset="2"><g:Label>Me too!</g:Label></b:Column>
      </b:FluidRow>
    </b:FluidContainer>`

## Sections

You can put parts of your page in Sections and jump to them via NavLinks or anchor tags:
 
	<b:Section target="modal">...</b:Section>

	<b:NavLink href="#modal">Modal</b:NavLink>

## Navigation Entries

### NavWidget
Can contain several widgets. The most obvious example:

	<b:NavWidget icon="star" iconColor="white" text="Inbox">
		<b:Badge>1</b:Badge>
	</b:NavWidget>

### NavLink

Can only contain Text:

	<b:NavLink active="true">2</b:NavLink>`

(Same as `<b:NavWidget text="2" active="true"/>`)

## Navigation Panels
### NavTabs
    <b:NavTabs>
    	<b:NavLink>1</b:NavLink>
    	<b:NavLink active="true">2</b:NavLink>
    </b:NavTabs>

* `<b:NavTabs stacked="true">...</b:NavTabs>`

### NavPills
    <b:NavPills>
    	<b:NavLink>1</b:NavLink>
    	<b:NavLink active="true">2</b:NavLink>
    </b:NavPills>

* `<b:NavPills stacked="true">...</b:NavPills>`

### TabPanel
    <b:TabPanel tabPosition="right">
    	<b:TabPane heading="prost" href="1"><g:Label>Lalala</g:Label></b:TabPane>
    	<b:TabPane heading="test" active="true"><g:Label>Huhu</g:Label></b:TabPane>
    </b:TabPanel>

* `tabPosition` is optional and defaults to `above`. Options: `below`, `left`, `right`. 
* `href` is optional. If none is provided, gwt-bootstrap will generate a random string.

### Navbar

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

### Nav Lists

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

## Page Header
	<b:PageHeader subtext="What this is all about">Title</b:PageHeader>

## Progress Bar
* `<b:ProgressBar percent="20"/>`
* `<b:ProgressBar style="striped" percent="40"/>`
* `<b:ProgressBar style="animated" percent="60"/>`

## Alerts
* `<b:Alert style="success" close="false" animated="true">TestAlert without close</b:Alert>`
* `<b:AlertBlock style="info" heading="Heading">AlertBlock</b:AlertBlock>`

## Labels
* `<b:Label>Default label</b:Label>`
* `<b:Label type="info">Info label</b:Label>`

## Pager
* `<b:Pager left="Left" right="Right"/>`
* `<b:Pager left="&larr; Older" right="Newer &rarr;" aligned="true"/>`

## Pagination
    <b:Pagination>
    	<b:NavLink href="http://www.google.com">1</b:NavLink>
    	<b:NavLink active="true">2</b:NavLink>
    	<b:NavLink disabled="true">3</b:NavLink>
    </b:Pagination>

* `<b:Pagination alignment="right">...</b:Pagination>`
* `<b:Pagination alignment="centered">...</b:Pagination>`

## Code
* `<b:Code>Code</b:Code>`

    <b:CodeBlock>
    	<b>More</b> Text<br/>\n
    	    in here...<br/>\n
    	&lt;p&gt;Sample text here...&lt;/p&gt;
    </b:CodeBlock>

End lines with `\n`. All html tags are automatically escaped. (So the last line of this example looks pretty bad ;-).)
 
## Dropdown

You can use Dropdowns in Navs, NavTabs and NavPills.

    <b:NavPills>
		<b:Dropdown text="Dropdown example">
	    	<b:NavLink>Test 1</b:NavLink>
		    <b:NavLink>Test 2</b:NavLink>
      </b:Dropdown>
    </b:NavPills>

All dropdowns can be converted into dropups by adding `dropup="true"`.

### DropdownButton

	<b:DropdownButton dropup="true" text="Dropup example">
		<b:NavLink>Test 1</b:NavLink>
	    <b:NavLink>Test 2</b:NavLink>
	</b:DropdownButton>
	
### SplitDropdownButton

	<b:SplitDropdownButton text="Dropdown example">
		<b:NavLink>Test 1</b:NavLink>
	    <b:NavLink>Test 2</b:NavLink>
	</b:SplitDropdownButton>
    
## Modal

Modal is very easy to use. 

     <b:Modal title="My Modal" show="false" backdrop="true" keyboard="true" animated="true" ui:field="modal">
		<g:Label>Modal Content!</g:Label>
		<b:ModalFooter>
			<b:Button icon="file white" options="primary">Save</b:Button>
		</b:ModalFooter>
	</b:Modal>
	
As you can see, we have several optional settings. These options are exactly equals the Modal JS plugin from twitter bootstrap. So, you can use it like a boss.
Also, Modal implements the `HasVisibleHandlers` interface, so, it has the `show`, `hide` and `toggle` methods.
The footer is optional.

