package org.deftserver.deftweb.client.tabs.contact;

import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ContactTab extends TabItem {

	private final VerticalPanel content = new VerticalPanel();

	public ContactTab() {
		super("Contact");

		content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		content.setSpacing(10);
		content.add(new Html(
				"<br><br><br><br>Google group mailing list: deft-web-server@googlegroups.com<br>"+
				"Google group home page: <a href=\"http://groups.google.com/group/deft-web-server\">http://groups.google.com/group/deft-web-server</a><br>" +
				"irc freenode #deft<br>" +
				"Roger Schildmeijer <a href=\"http://twitter.com/rschildmeijer\">(@rschildmeijer)</a><br>" +
				"Jim Petersson <a href=\"http://github.com/jimpetersson\">(jimpetersson)</a><br>")
		);
		
		add(content);
	}
}
