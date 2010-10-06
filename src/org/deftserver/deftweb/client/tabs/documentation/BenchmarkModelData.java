package org.deftserver.deftweb.client.tabs.documentation;

import java.util.Collection;
import java.util.Map;

import com.extjs.gxt.ui.client.data.ModelData;

public class BenchmarkModelData implements ModelData {

	private final Integer deft;
	private final Integer tornado;
	private final Integer concurrent;
	
	public BenchmarkModelData(int d, int t, int c) {
		deft = d;
		tornado = t;
		concurrent = c;
	}
	
	@Override
	public <X> X get(String property) {
		if (property.equals("deft")) {
			return (X) deft; 		// y value
		} else if (property.equals("tornado")){
			return (X) tornado;		// y value
		} else {
			return (X) concurrent;	// label
		}
	}

	@Override
	public Map<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getPropertyNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <X> X remove(String property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <X> X set(String property, X value) {
		// TODO Auto-generated method stub
		return null;
	}

}
