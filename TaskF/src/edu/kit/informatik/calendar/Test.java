package edu.kit.informatik.calendar;

public class Test {


	public static void main(String[] args) {
		timeTest();
		dateTest();
		
	}
	
	public static void dateTest() {
		System.out.println("------------------------");
		System.out.println("Date tests:");

		Date d1,d2,d3;
		
		d1 = new Date(1000, 1, 1);
		d2 = new Date(1000, 1, 1);
		d3 = d1.plus(d2);
		System.out.println(d1 + " + "  + d2 + " = " + d3);
		
		d1 = new Date(1000, 1, 1);
		d2 = new Date(1000, 1, 28);
		d3 = d1.plus(d2);
		System.out.println(d1 + " + "  + d2 + " = " + d3);
		
		d1 = new Date(1000, 1, 1);
		d2 = new Date(1001, 1, 28);
		d3 = d1.plus(d2);
		System.out.println(d1 + " + "  + d2 + " = " + d3);
		
		d1 = new Date(2000, 2, 2);
		d2 = new Date(1000, 1, 1);
		d3 = d1.minus(d2);
		System.out.println(d1 + " + "  + d2 + " = " + d3);
		
		d1 = new Date(2000, 2, 29);
		d2 = new Date(1000, 1, 28);
		d3 = d1.minus(d2);
		System.out.println(d1 + " + "  + d2 + " = " + d3);
		
		d1 = new Date(2001, 3, 1);
		d2 = new Date(1001, 1, 28);
		d3 = d1.minus(d2);
		System.out.println(d1 + " + "  + d2 + " = " + d3);
		
		System.out.println("------------------------");
		System.out.println();
	}
	
	public static void timeTest() {
		System.out.println("------------------------");
		System.out.println("Time tests:");

		Time t1,t2,t3;
		
		t1 = new Time(12, 0, 0);
		t2 = new Time(12, 0, 0);
		t3 = t1.plus(t2);
		System.out.println(t1 + " + "  + t2 + " = " + t3);
		
		t1 = new Time(23, 59, 59);
		t2 = new Time(0, 0, 1);
		t3 = t1.plus(t2);
		System.out.println(t1 + " + "  + t2 + " = " + t3);
		
		t1 = new Time(11, 11, 11);
		t2 = new Time(11, 11, 11);
		t3 = t1.plus(t2);
		System.out.println(t1 + " + "  + t2 + " = " + t3);
		
		t1 = new Time(12, 0, 0);
		t2 = new Time(12, 0, 0);
		t3 = t1.minus(t2);
		System.out.println(t1 + " - "  + t2 + " = " + t3);
		
		t1 = new Time(0, 0, 0);
		t2 = new Time(0, 0, 1);
		t3 = t1.minus(t2);
		System.out.println(t1 + " - "  + t2 + " = " + t3);
		
		t1 = new Time(11, 11, 11);
		t2 = new Time(1, 1, 1);
		t3 = t1.minus(t2);
		System.out.println(t1 + " - "  + t2 + " = " + t3);	
		
		t1 = new Time(00, 00, 00);
		t2 = new Time(2, 3, 1);
		t3 = t1.minus(t2);
		System.out.println(t1 + " - "  + t2 + " = " + t3);
		
		System.out.println("------------------------");
		System.out.println();
	}
}
