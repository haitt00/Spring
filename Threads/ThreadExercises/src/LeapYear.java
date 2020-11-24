//Activity-13
public class LeapYear {
	public static int year = -1;
	public static void main(String[] args) {
		LeapYear leapYear = new LeapYear();
		Thread generator = new Generator(leapYear);
		generator.setName("generator");
		generator.start();
		Thread checker = new Checker(leapYear);
		checker.setName("checker");
		checker.start();
	}
	//synchronized
	public synchronized void setYear(int year) {
//		System.out.println("1");
		while(LeapYear.year==-1) {
//			System.out.println("2");
			LeapYear.year=year;
//			System.out.println("3");
			System.out.println(year);
//			System.out.println("4");
			break;
		}
//		System.out.println("5");
		return;
	}
	private Boolean checkLeap(int year) {
	    if (year % 400 == 0) 
	        return true; 
	    if (year % 100 == 0) 
	        return false;  
	    if (year % 4 == 0) 
	        return true; 
	    return false; 
	}
	//synchronized
	public synchronized void checkYear() {
//		System.out.println("6");
		while(LeapYear.year!=-1) {
//			System.out.println("7");
			if(checkLeap(LeapYear.year)) {
//				System.out.println("8");
				System.out.println("leap");
//				System.out.println("9");
			}
			else {
//				System.out.println("10");
				System.out.println("not leap");
//				System.out.println("11");
			}
//			System.out.println("12");
			break;
		}
//		System.out.println("13");
		LeapYear.year= -1;
	}

}
class Generator extends Thread{
	private LeapYear leapYear;
	final int MAX = 9999;
	final int MIN = 1000;
	
	public Generator(LeapYear leapYear) {
		super();
		this.leapYear = leapYear;
	}
	public void run() {
		while(true) {
//			generate year
			this.generateYear();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void generateYear() {
		synchronized (leapYear) {
			System.out.println("Thread 1 generate:");
			int year = (int) (MIN+Math.random()*(MAX-MIN));
			leapYear.setYear(year);
		}
//		System.out.println("generate:"+year);
//		return year;
	}
}
class Checker extends Thread{
	private LeapYear leapYear;
	
	public Checker(LeapYear leapYear) {
		super();
		this.leapYear = leapYear;
	}
	public void run() {
		while(true) {
			this.checkYear();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void checkYear() {
		synchronized (leapYear) {
			System.out.println("Thread 2 check:");
			leapYear.checkYear();
		}
	}
}
