package org.deftserver.deftweb.client;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Deftweb implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		VerticalPanel vp = new VerticalPanel();  
		vp.setSpacing(10);  

		TabPanel panel = new TabPanel();  
		panel.setPlain(true);  
		panel.setSize(850, 850); 

		TabItem normal = new TabItem("Documentation");  
		normal.addStyleName("pad-text");  
		normal.addText("Just a plain old tab");  
		panel.add(normal);  

		TabItem ajax1 = new TabItem("Contact");  
		ajax1.setScrollMode(Scroll.AUTO);  
		ajax1.addStyleName("pad-text");  
		//ajax1.setAutoLoad(new RequestBuilder(RequestBuilder.GET, GWT.getHostPageBaseURL() + "data/ajax1.html"));  
		panel.add(ajax1);  

		TabItem eventTab = new TabItem("Yet another Tab");  
		eventTab.addListener(Events.Select, new Listener<ComponentEvent>() {  
			public void handleEvent(ComponentEvent be) {  
				Window.alert("Event Tab Was Selected");  
			}  
		});  
		eventTab.addStyleName("pad-text");  
		eventTab.addText("I am tab 4's content. I also have an event listener attached.");  
		panel.add(eventTab);  

		vp.add(panel);  
		RootPanel.get("sendButtonContainer").add(vp);
	}
}
