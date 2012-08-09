package config;

import java.util.ArrayList;

public class CEP {
	
	ArrayList<String> events;
	String name;
	ArrayList <Rules> rules;
	
	public class Rules{
		String rname;
		ArrayList<String> listeners;
		
		public Rules()
		{
			rname="";
			listeners = new ArrayList<String>();
		}
		public Rules(String name)
		{
			this.rname=name;
			listeners = new ArrayList<String>();
		}
		public String getRName() {
			return rname;
		}
		public void setRName(String name) {
			this.rname = name;
		}
		public ArrayList<String> getListeners() {
			return listeners;
		}
		public void addListener(String listener) {
			this.listeners.add(listener);
		}
		
		public String toString()
		{
			String str = "Rule: " + getRName();
			for(String lis:listeners)
				str = str+ "\nListener: " + lis;
			return str;
		}
		
	}
	
	public ArrayList<String> getEvents() {
		return events;
	}

	public void addEvent(String event) {
		this.events.add(event);
	}
	
	public void addRule(String rule)
	{
		Rules r = new Rules(rule);
		rules.add(r);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public CEP()
	{
		name="";
		rules =new ArrayList<Rules>();
		events = new ArrayList<String>();
	}
	
	public CEP(String name)
	{
		this.name=name;
		rules =new ArrayList<Rules>();
		events = new ArrayList<String>();
	}
	
	public String toString()
	{
		String str = "CEP : " + getName()+"\n";
		for(String ev:events)
		{
			str = str+ "\nEvent: " + ev;
		}
		for(Rules r : rules)
		{
			str = str + "\n" + r;
		}
		return str;
	}
	
	public ArrayList <Rules> getRules()
	{
		return rules;
	}

}
