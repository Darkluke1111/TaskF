

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
    	
    	if(resSecond < 0 && resMinute == 0 && resHour == 0) {
    		resSecond = 60 + resSecond;
    		resMinute = 59;
    		resHour = 23;
    	}
    	else if(resSecond < 0 || resMinute < 0 || resHour < 0) {
    		resSecond = 60 + resSecond;
    		resMinute = 60 + resMinute;
    		resHour = 24 + resHour;
    	}
    	return new Time(resHour, resMinute, resSecond);
    }
    
    public boolean isBefore (Time other) {
    	boolean b;
    	if(this.hour < other.hour) {
    		b = true;
    	}
    	else if(this.hour == other.hour && this.minute < other.minute) {
    		b = true;
    	}
    	else if(this.hour == other.hour && this.minute == other.minute && this.second < other.second) {
    		b = true;
    	}
    	else {
    		b = false;
    	}
    	return b;
    }
    
    public boolean isEqual (Time other) {
    	boolean b;
    	if(this.hour == other.hour && this.minute == other.minute && this.second == other.second) {
    		b = true;
    	}
    	else {
    		b = false;
    	}
    	return b;
    }
    
    public boolean isAfter (Time other) {
    	boolean b;
    	if(this.hour > other.hour) {
    		b = true;
    	}
    	else if(this.hour == other.hour && this.minute > other.minute) {
    		b = true;
    	}
    	else if(this.hour == other.hour && this.minute == other.minute && this.second > other.second) {
    		b = true;
    	}
    	else {
    		b = false;
    	}
    	return b;
    }
    
}


//package edu.kit.informatik.calendar;
//
///**
// * Represents a specific time in seconds, minutes and hours.
// * 
// * @author  Tobias Bachert
// * @version 1.00, 2016/10/27
// */
//public final class Time {
//    
//    private final int hour;
//    private final int minute;
//    private final int second;
//    
//    public Time(int hour, int minute, int second){
//    	this.hour = hour;
//    	this.minute = minute;
//    	this.second = second;   	
//    }
//    
//    public DateTime atDate(Date date) {
//    	return new DateTime(date, this);
//    }
//    
//    public int getHour() {
//		return hour;
//	}
//    
//    public int getMinute() {
//		return minute;
//	}
//    
//    public int getSecond() {
//		return second;
//	}
//    
//    @Override
//    public String toString() {
//    	char delimiter = ':';
//    	StringBuilder sb = new StringBuilder();
//    	
//    	if(hour<10) sb.append(0);
//    	sb.append(hour);
//    	sb.append(delimiter);
//    	
//    	if(minute<10) sb.append(0);
//    	sb.append(minute);
//    	sb.append(delimiter);
//    	
//    	if(second<10) sb.append(0);
//    	sb.append(second);
//    	
//    	return sb.toString();
//    }
//    
//    public Time plus(Time time) {
//    	int resSecond = (second + time.getSecond())%60;
//    	int resMinute = (minute + time.getMinute() + (second + time.getSecond())/60)%60;
//    	int resHour = (hour + time.getHour() + (minute + time.getMinute() + (second + time.getSecond())/60)/60)%24;
//    	
//    	return new Time(resHour, resMinute, resSecond);
//    }
//    
//    public Time minus(Time time) {
//    	int resSecond = (60 + second - time.getSecond())%60;
//    	int resMinute = (60 + minute - time.getMinute() + (60 + second - time.getSecond())/60)%60;
//    	int resHour = (24 + hour - time.getHour() + (60 + minute - time.getMinute() + (60 + second - time.getSecond())/60)/60)%24;
//    	
//    	return new Time(resHour, resMinute, resSecond);
//    }
//    
//    public boolean isBefore (Time other) {
//    	boolean b;
//    	if(this.hour < other.hour) {
//    		b = true;
//    	}
//    	else if(this.hour == other.hour && this.minute < other.minute) {
//    		b = true;
//    	}
//    	else if(this.hour == other.hour && this.minute == other.minute && this.second < other.second) {
//    		b = true;
//    	}
//    	else {
//    		b = false;
//    	}
//    	return b;
//    }
//    
//    public boolean isEqual (Time other) {
//    	boolean b;
//    	if(this.hour == other.hour && this.minute == other.minute && this.second == other.second) {
//    		b = true;
//    	}
//    	else {
//    		b = false;
//    	}
//    	return b;
//    }
//    
//    public boolean isAfter (Time other) {
//    	boolean b;
//    	if(this.hour > other.hour) {
//    		b = true;
//    	}
//    	else if(this.hour == other.hour && this.minute > other.minute) {
//    		b = true;
//    	}
//    	else if(this.hour == other.hour && this.minute == other.minute && this.second > other.second) {
//    		b = true;
//    	}
//    	else {
//    		b = false;
//    	}
//    	return b;
//    }
//    
//}

