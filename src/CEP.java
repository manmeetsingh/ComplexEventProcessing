

import java.util.ArrayList;

public class CEP {
	
	ArrayList<String> events;
	String name;
	
	public class Rules{
		String name;
		ArrayList<String> listeners;
		
		public Rules()
		{
			name="";
		}
		public Rules(String name)
		{
			this.name=name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public ArrayList<String> getListeners() {
			return listeners;
		}
		public void addListener(String listener) {
			this.listeners.add(listener);
		}
		
	}
	
	public ArrayList<String> getEvents() {
		return events;
	}

	public void addEvent(String event) {
		this.events.add(event);
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
	}
	
	public CEP(String name)
	{
		this.name=name;
	}
	
	

}
