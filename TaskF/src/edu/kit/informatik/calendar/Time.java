
package edu.kit.informatik.calendar;

/**
 * Represents a specific time in seconds, minutes and hours.
 * 
 * @author  Tobias Bachert
 * @version 1.00, 2016/10/27
 */
public final class Time {
    
    private final int hour;
    private final int minute;
    private final int second;
    
    public Time(int hour, int minute, int second){
    	this.hour = hour;
    	this.minute = minute;
    	this.second = second;   	
    }
    
    public DateTime atDate(Date date) {
    	return new DateTime(date, this);
    }
    
    public int getHour() {
		return hour;
	}
    
    public int getMinute() {
		return minute;
	}
    
    public int getSecond() {
		return second;
	}
    
    @Override
    public String toString() {
    	char delimiter = ':';
    	StringBuilder sb = new StringBuilder();
    	
    	if(hour<10) sb.append(0);
    	sb.append(hour);
    	sb.append(delimiter);
    	
    	if(minute<10) sb.append(0);
    	sb.append(minute);
    	sb.append(delimiter);
    	
    	if(second<10) sb.append(0);
    	sb.append(second);
    	
    	return sb.toString();
    }
    
    public Time plus(Time time) {
    	int resSecond = (second + time.getSecond())%60;
    	int resMinute = (minute + time.getMinute() + (second + time.getSecond())/60)%60;
    	int resHour = (hour + time.getHour() + (minute + time.getMinute() + (second + time.getSecond())/60)/60)%24;
    	
    	return new Time(resHour, resMinute, resSecond);
    }
    
    public Time minus(Time time) {
    	int resSecond = (second - time.getSecond())%60;
    	int resMinute = (minute - time.getMinute() + (second - time.getSecond())/60)%60;
    	int resHour = (hour - time.getHour() + (minute - time.getMinute() + (second - time.getSecond())/60)/60)%24;
    	
    	return new Time(resHour, resMinute, resSecond);
    }
    
    
}
