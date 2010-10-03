package org.deftserver.deftweb.client.tabs.metrics;

import java.util.Date;

import com.google.gwt.http.client.RequestException;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickHandler;

public class CommitCalendar extends Calendar {

	private final DataSource eventDS = new DataSource();

	public CommitCalendar() {
		setWidth(500);  
		setHeight(220);  
		setShowDayView(false);  
		setShowWeekView(false);  
		setShowOtherDays(false);  
		setShowDayHeaders(false);  
		setShowDatePickerButton(false);  
		setShowAddEventButton(false);  
		setDisableWeekends(false);          
		setShowDateChooser(false);  
		setCanCreateEvents(false);  
		setAutoFetchData(true);

		setDataSource();
		addDayBodyClickHandler();
	}

	private void setDataSource() {
		DataSourceSequenceField eventIdField = new DataSourceSequenceField("eventId");  
		eventIdField.setPrimaryKey(true);  

		DataSourceTextField nameField = new DataSourceTextField("name");  
		DataSourceTextField descField = new DataSourceTextField("description");  
		DataSourceDateField startDateField = new DataSourceDateField("startDate");  
		DataSourceDateField endDateField = new DataSourceDateField("endDate");  

		eventDS.setFields(eventIdField, nameField, descField, startDateField, endDateField);  
		eventDS.setClientOnly(true);  
		//eventDS.setTestData(getRecords());

		setDataSource(eventDS);
		try {
			getRecords();
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addDayBodyClickHandler() {
		addDayBodyClickHandler(new DayBodyClickHandler() {  
			public void onDayBodyClick(DayBodyClickEvent event) {  
				String name = "";  
				CalendarEvent[] events = event.getEvents();  
				if(events.length == 0) {  
					name = "No events";  
				} else {  
					for (CalendarEvent calEvent : events) {  
						name += calEvent.getName() + "<br/>";  
					}  
				}  
				SC.say(name);  
			}  
		});		
	}

	@Override   
	protected String getDayBodyHTML(Date date, CalendarEvent[] events, Calendar calendar, int rowNum, int colNum) {  
		String returnStr = date.getDate() + "";  
		if(events != null && events.length > 0) {  
			returnStr += imgHTML("approved.png", 16, 16, "image", "style='margin-top:6px'", null);  
		}  
		return returnStr;
	}

	private static CalendarEvent[] records;  
	private static Date today = new Date();  
	private static int year = today.getYear();  
	private static int month = today.getMonth();  
	private static int start = today.getDate() - today.getDay(); 

	public void getRecords() throws RequestException {  
		//		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, 
		//		URL.encode("http://github.com/api/v2/json/commits/list/rschildmeijer/deft/master"));
		//		builder.sendRequest(null, new RequestCallback() {
		//
		//			@Override
		//			public void onResponseReceived(Request request, Response response) {
		//				String text = response.getText();
		//				int sc = response.getStatusCode();
		//				String headers = response.getHeadersAsString();
		//				String statusTetx = response.getStatusText();
		//				String a = text;
		//				JSONObject jo = new JSONObject(JSON.decode(text));
		//				JSONArray commits = (JSONArray) jo.get("commits");
		//				for (int i = 0; i < commits.size(); i++) {
		//					JSONObject msg = (JSONObject) commits.get(i);
		//					JSONValue value = msg.get("committed_date");
		//					String d = value.isString().stringValue();
		//				}
		//			
		//			}
		//
		//			@Override
		//			public void onError(Request request, Throwable exception) {
		//
		//			}
		//		});
		CalendarEvent[] events = new CalendarEvent[] {   
				new CalendarEvent(
						1, /* event id*/
						"Commits: 1",	/* name */ 
						"# commits",	/* description */
						new Date(year, month, start + 2, 0, 0, 0), 	/* start */
						new Date(year, month, start + 2, 14, 0, 0) /* end */
				),  
		};
		eventDS.setTestData(events);
	}  


}
