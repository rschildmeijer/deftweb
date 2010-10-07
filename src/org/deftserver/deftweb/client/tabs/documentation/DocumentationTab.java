package org.deftserver.deftweb.client.tabs.documentation;

import java.util.Arrays;
import java.util.List;

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.model.BarDataProvider;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.Legend;
import com.extjs.gxt.charts.client.model.ScaleProvider;
import com.extjs.gxt.charts.client.model.Text;
import com.extjs.gxt.charts.client.model.Legend.Position;
import com.extjs.gxt.charts.client.model.axis.XAxis;
import com.extjs.gxt.charts.client.model.axis.YAxis;
import com.extjs.gxt.charts.client.model.charts.BarChart;
import com.extjs.gxt.charts.client.model.charts.BarChart.BarStyle;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DocumentationTab extends TabItem {

	private final VerticalPanel content = new VerticalPanel();


	public DocumentationTab() {
		super("Documentation");
		content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		content.setSpacing(10);
		
		HorizontalPanel chartPanel = new HorizontalPanel();
		chartPanel.setSpacing(20);
		chartPanel.add(getChart("Single instance"));
		chartPanel.add(getChart("Nginx, four instances"));
		content.add(chartPanel);

		add(content);
	}
	
	private Chart getChart(String titleText) {
		Chart chart = new Chart("resources/chart/open-flash-chart.swf");
		ListStore<BenchmarkModelData> store = new ListStore<BenchmarkModelData>(); 
		
		chart.setSize("380", "260");

		ChartModel model = new ChartModel(titleText,  
			"font-size: 14px; font-family: Verdana; text-align: center;");  
		model.setBackgroundColour("#fefefe");  
		model.setLegend(new Legend(Position.TOP, true));  
		model.setScaleProvider(ScaleProvider.ROUNDED_NEAREST_SCALE_PROVIDER);  

		YAxis ya = new YAxis();
		model.setYAxis(ya);
		
		XAxis xa = new XAxis();
		xa.setLabels("label");
		model.setXAxis(xa);
		model.setXLegend(new Text("Concurrent requests (keep-alive)", "font-size: 12px; font-family: Verdana; text-align: center;"));
		
		BarChart bar = new BarChart(BarStyle.GLASS);  
		bar.setText("Deft");
		bar.setColour("#00aa00");  
		bar.setTooltip("Deft: #val# requests/sec");
		BarDataProvider barProvider = new BarDataProvider("deft", "c");  
		barProvider.bind(store);  
		bar.setDataProvider(barProvider);  
		model.addChartConfig(bar);  

		bar = new BarChart(BarStyle.GLASS);  
		bar.setText("Tornado");
		bar.setColour("#0000cc");  
		bar.setTooltip("Tornado: #val# requests/sec");
		barProvider = new BarDataProvider("tornado");  
		barProvider.bind(store);  
		bar.setDataProvider(barProvider);  
		model.addChartConfig(bar);  

		chart.setChartModel(model);  
		store.add("Single instance".equals(titleText) ? getSingleFrontendBenchmarkDataModels() : getNginxBenchmarkDataModels());

		return chart;
	}

	private List<BenchmarkModelData> getSingleFrontendBenchmarkDataModels() {
		return Arrays.asList(
				new BenchmarkModelData[] {
						new BenchmarkModelData(23028, 3059, 5),
						new BenchmarkModelData(22878, 3142, 10),
						new BenchmarkModelData(22907, 3194, 15),
						new BenchmarkModelData(22905, 3220, 20),
						new BenchmarkModelData(23246, 3234, 25)
				}
		);
	}
	
	private List<BenchmarkModelData> getNginxBenchmarkDataModels() {
		return Arrays.asList(
				new BenchmarkModelData[] {
						new BenchmarkModelData(9284, 5578, 5),
						new BenchmarkModelData(11955, 6143, 10),
						new BenchmarkModelData(13336, 6393, 15),
						new BenchmarkModelData(13845, 6563, 20),
						new BenchmarkModelData(13730, 6664, 25)
				}
		);
	}

}
