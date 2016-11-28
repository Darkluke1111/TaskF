
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
    	Date d = date.plus(datetime.date);
    	Time t = time.plus(datetime.time);
    	return new DateTime(d, t);
    }
    
    public DateTime minus(DateTime datetime) {
    	Date d = date.minus(datetime.date);
    	Time t = time.minus(datetime.time);
    	
    	return new DateTime(d, t);
    }
    
    public DateTime plus(Date date) {
    	Date d = date.plus(date);
    	
    	return new DateTime(d, this.time);
    }
    
    public DateTime minus(Date date) {
    	Date d = date.minus(date);
    	
    	return new DateTime(d, this.time);
    }
    
    public DateTime plus(Time time) {
    	Time t = time.plus(time);
    	
    	return new DateTime(this.date, t);
    }
    
    public DateTime minus(Time time) {
    	Time t = time.minus(time);
    	
    	return new DateTime(this.date, t);
    }
    
    public DateTime plusYears(int years) {
    	Date d = date.plusYears(years);
    	
    	return new DateTime(d, this.time);
    }
    
    public DateTime minusYears(int years) {
    	Date d = date.minusYears(years);
    	
    	return new DateTime(d, this.time);
    }
    
    public DateTime plusMonths(int months) {
    	Date d = date.plusMonths(months);
    	
    	return new DateTime(d, this.time);
    }
    
    public DateTime minusMonths(int months) {
    	Date d = date.minusMonths(months);
    	
    	return new DateTime(d, this.time);
    }
    
    public DateTime plusDays(int days) {
    	Date d = date.plusDays(days);
    	
    	return new DateTime(d, this.time);
    }
    
    public DateTime minusDays(int days) {
    	Date d = date.minusDays(days);
    	
    	return new DateTime(d, this.time);
    }
    
    public boolean isBefore (DateTime other) {
    	boolean b;
    	
    	if(date.isBefore(other.date) && time.isBefore(other.time)) b = true;
    	else b = false;
    	
    	return b;
    }
    
    public boolean isEqual (DateTime other) {
    	boolean b;
    	
    	if(date.isEqual(other.date) && time.isEqual(other.time)) b = true;
    	else b = false;
    	
    	return b;
    }
    
    public boolean isAfter (DateTime other) {
    	boolean b;
    	
    	if(date.isAfter(other.date) && time.isAfter(other.time)) b = true;
    	else b = false;
    	
    	return b;
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
