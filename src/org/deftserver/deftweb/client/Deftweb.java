package org.deftserver.deftweb.client;

import org.deftserver.deftweb.client.tabs.metrics.MetricsTab;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
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

		TabItem metricsTab = new MetricsTab("Metrics");  
		metricsTab.addStyleName("pad-text");  
		panel.add(metricsTab);  

		vp.add(panel);  
		RootPanel.get("sendButtonContainer").add(vp);
	}
}
