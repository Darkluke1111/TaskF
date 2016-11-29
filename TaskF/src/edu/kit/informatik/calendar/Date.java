
package edu.kit.informatik.calendar;


/**
 * Represents a date consisting of a year, a {@linkplain Month month} and a day.
 * 
 * @author  Tobias Bachert
 * @version 1.00, 2016/10/27
 */
public final class Date {
    
    private final int year;
    private final int month;
    private final int dayOfMonth;
    
    public Date(int year, int month, int dayOfMonth) {
    	this.year = year;
    	this.month = month;
    	this.dayOfMonth = dayOfMonth;
    }
    
    public DateTime atTime(Time time) {
    	return new DateTime(this, time);
    }
    
    public int getDayOfMonth() {
		return dayOfMonth;
	}
    
    public int getMonthValue() {
		return month;
	}
    
    public int getYear() {
		return year;
	}
    
    public Month getMonth() {
    	return Month.ofIndex(month);
    }
    
    public int getDayOfYear() {

    	int temp = 28;
    	if(isLeapYear()) temp = 29;
    	
    	int days[] = {31,temp,31,30,31,30,31,31,30,31,30,31};
    	
    	int count = 0;
    	for(int i = 0 ; i < 12; i++) {
    		if(month > i) {
    			count += days[i];
    		} else {
    			count += dayOfMonth;
    			break;
    		}
    	}
    	return count;
    }
    
    public DayOfWeek getDayOfWeek() {
    	int count = dateToDays(this);
    	int d = count%7;
    	
    	int w = (d+5)%7;   	
    	return DayOfWeek.values()[w];
    }
    
    private static int dateToDays(Date date) {
    	int count = 0;
    	for(int i = 0; i < date.year; i++) {
    		if(isLeapYear(date.year)) count += 366;
    		else count += 365;
    	}
    	count += date.getDayOfYear();
    	return count;
    }
    
    private static Date DaysToDate(int days) {
    	int year = 0;
    	while(days >= 366 || days >= 365) {
    		if(isLeapYear(year) && days >= 366) {
    			days -= 366;
    		}
    		else if(days >= 365) {
    			days -= 365;
    		}
    		year++;		
    	}
    	
    	int temp = 28;
    	if(isLeapYear(year)) temp = 29;
    	
    	int daysMonth[] = {31,temp,31,30,31,30,31,31,30,31,30,31};
    	
    	int month = 0;
    	
    	for(int i = 0 ; i < 12; i++) {
    		while(days >= daysMonth[i]) {
    			month++;
    			days -= daysMonth[i];
    		}
    	}
    	
    	return new Date(year, month, days);
    }
    
    public Date plus(Date date) {
    	int sum = 0;
    	sum = dateToDays(date) + dateToDays(this);
    	Date result =  DaysToDate(sum);
    	
    	return result;
    }
    
    public Date plusYears(int years) {
    	int sum = years + this.year;
    	
    	return new Date(sum, this.month, this.dayOfMonth);
    }
    
    public Date plusMonths(int months) {
    	int year = 0;
    	int sum = months + this.month;
    	while(sum > 12) {
    		year++;
    		sum -= 12;
    	}
    	year += this.year;
    	
    	
    	return new Date(year, sum, this.dayOfMonth);
    }
    
    public Date plusDays(int days) {
    	int sum = days + dateToDays(this);
    	Date result = DaysToDate(sum);
    	
    	return result;
    }
    
    public Date minus(Date date) {
    	int sum = 0;
    	sum = dateToDays(date) - dateToDays(this);
    	Date result =  DaysToDate(sum);
    	
    	return result;
    }
    
    public Date minusYears(int years) {
    	int sum = years - this.year;
    	
    	return new Date(sum, this.month, this.dayOfMonth);
    }
    
    public Date minusMonths(int months) {
    	int year = 0;
    	int sum = this.month - months;
    	while(sum < 0) {
    		year--;
    		sum += 12;
    	}
    	year += this.year;
    	
    	
    	return new Date(year, sum, this.dayOfMonth);
    }
    
    public Date minusDays(int days) {
    	int sum = dateToDays(this) - days;
    	Date result = DaysToDate(sum);
    	
    	return result;
    }

	private static boolean isLeapYear(int year) {
    	if(year%400 == 0) return true;
    	if(year%4 == 0 && year%100 != 0) return true;
    	
    	return false;
    }
    
    public boolean isLeapYear() {
    	if(year%400 == 0) return true;
    	if(year%4 == 0 && year%100 != 0) return true;
    	
    	return false;
    }
    
    public boolean isBefore (Date other) {
    	boolean b;
    	
    	if(dateToDays(this) < dateToDays(other)) b = true;
    	else b = false;
    	
    	return b;
    }
    
    public boolean isEqual (Date other) {
    	boolean b;
    	
    	if(dateToDays(this) == dateToDays(other)) b = true;
    	else b = false;
    	
    	return b;
    }
    
    public boolean isAfter (Date other) {
    	boolean b;
    	
    	if(dateToDays(this) > dateToDays(other)) b = true;
    	else b = false;
    	
    	return b;
    }
    
    @Override
    public String toString() {
    	char delimiter = '-';
    	StringBuilder sb = new StringBuilder();
    	
    	if(dayOfMonth<10) sb.append(0);
    	sb.append(dayOfMonth);
    	sb.append(delimiter);
    	
    	if(month<10) sb.append(0);
    	sb.append(month);
    	sb.append(delimiter);
    	
    	sb.append(year);
    	
    	return sb.toString();
    }
    
    
    
}
