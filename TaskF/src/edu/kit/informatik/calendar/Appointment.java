package edu.kit.informatik.calendar;

public class Appointment {
	
	private String name;
	private DateTime from;
	private DateTime to;
	private Time duration;
	
	public Appointment(String name, DateTime from, DateTime to) {
		this.name = name;
		this.from = from;
		this.to = to;
	}
	
	public Appointment(String name, DateTime from, Time duration) {
		this.name = name;
		this.from = from;
		this.duration = duration;
	}
	
	public DateTime getFrom() {
		return from;
	}
	
	public DateTime getTo() {
		return to;
	}
	
	public String getName() {
		return name;
	}
	
	public void setTo(DateTime to) {
		this.to = to;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
    	char delimiter = ' ';
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append(name);
    	sb.append(delimiter);
    	
    	sb.append(from.toString());
    	sb.append(delimiter);
    	
    	sb.append(to.toString());
    	return sb.toString();
	}
}
