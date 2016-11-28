
package edu.kit.informatik.calendar;

/**
 * Represents a specific {@linkplain Time} at a specific {@linkplain Date}.
 * 
 * @author  Tobias Bachert
 * @version 1.00, 2016/10/26
 */
public final class DateTime {
    
    private final Date date;
    private final Time time;
    
    public DateTime(Date date, Time time) {
    	this.date = date;
    	this.time = time;
    }
    
    public Date getDate() {
		return date;
	}
    
    public Time getTime() {
		return time;
	}
    
    public DateTime plus(DateTime datetime) {
    	
    }
    
    
    
    
    @Override
    public String toString() {
    	char delimiter = 'T';
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append(date.toString());
    	sb.append(delimiter);
    	
    	sb.append(time.toString());
    	return sb.toString();
    }
    
    public int getYear () {
    	return date.getYear();
    }
    
    public int getMonthValue () {
    	return date.getMonthValue();
    }
    
    public Month getMonth () {
    	return date.getMonth();
    }
    
    public int getDayOfYear () {
    	return date.getDayOfYear();
    }
    
    public int getDayOfMonth () {
    	return date.getDayOfMonth();
    }
    
    public DayOfWeek getDayOfWeek () {
    	return date.getDayOfWeek();
    }
    
    public int getHour () {
    	return time.getHour();
    }
    
    public int getMinute () {
    	return time.getMinute();
    }
    
    public int getSecond () {
    	return time.getSecond();
    }
}
