package org.deftserver.deftweb.client;

import org.deftserver.deftweb.client.tabs.contact.ContactTab;
import org.deftserver.deftweb.client.tabs.documentation.DocumentationTab;
import org.deftserver.deftweb.client.tabs.metrics.MetricsTab;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.google.gwt.core.client.EntryPoint;
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
		vp.setHorizontalAlign(HorizontalAlignment.CENTER);
		TabPanel panel = new TabPanel();  
		panel.setPlain(true);  
		panel.setSize(850, 2050); 

		TabItem documentationTab = new DocumentationTab();  
		documentationTab.addStyleName("pad-text");  
		//documentationTab.addText("Just a plain old tab");  
		panel.add(documentationTab);  

		TabItem contact = new ContactTab();  
		panel.add(contact);  

		TabItem metricsTab = new MetricsTab();  
		metricsTab.addStyleName("pad-text");  
		panel.add(metricsTab);  

		vp.add(panel);  
		RootPanel.get("sendButtonContainer").add(vp);
	}
}
