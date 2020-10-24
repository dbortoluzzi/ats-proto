package eu.dbortoluzzi.atms.controller;

import eu.dbortoluzzi.atms.model.AtmIndexable;

import java.util.List;

public class AtmsResponse {
	private List<AtmIndexable> atms;

	public AtmsResponse() { }
	
	public List<AtmIndexable> getAtms() { return atms; }
	public void setAtms(List<AtmIndexable> atms) { this.atms= atms; }
	
	public int getCount() { 
		return atms!= null ? atms.size() : 0;
	}
}
