package org.deftserver.deftweb.client.tabs.metrics;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.google.gwt.user.client.ui.HTML;

public class MetricsTab extends TabItem {

	public MetricsTab() {
		super("Metrics");
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(10);
		
		HTML commitText = new HTML("<h1>The latest commits on the 'master' branch</h1>");
		panel.add(commitText);
		//panel.add(new CommitCalendar());
		add(panel);
	}

}


