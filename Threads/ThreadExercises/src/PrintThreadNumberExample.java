//Activity-11
public class PrintThreadNumberExample {

//	public PrintThreadNumberExample() {
//		// TODO Auto-generated constructor stub
//	}
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			new ThreadWithNumber(i).start();
		}
	}
	
}

class ThreadWithNumber extends Thread{
	private int number;
	public ThreadWithNumber(int number) {
		super();
		this.number = number;
	} 
	public void run() {
		System.out.println("Thread "+number+" running");
	}
}
