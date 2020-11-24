//Activity-12
public class AppMyThread {

	public static void main(String[] args) {
		new MyThread("ABC", 3.5).start();
		new MyThread("DEF", 2.5).start();
	}

}
class MyThread extends Thread{
	private String name;
	private  double sleep;
	public MyThread(String name, double sleep) {
		super();
		this.name = name;
		this.sleep = sleep;
	}
	public void run() {
		while(true) {
			System.out.println(this.name);
			try {
				Thread.sleep((int)this.sleep*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}