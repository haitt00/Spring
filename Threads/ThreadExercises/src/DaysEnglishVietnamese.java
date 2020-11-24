//Activity-14
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DaysEnglishVietnamese {

	public int keyIndex = -1;
	private HashMap<String, String> mapOfDays;
	
	public String getKeyByIndex(int index) {
		return (new ArrayList<>(mapOfDays.keySet())).get(index);
	}
	public String getValueByIndex(int index) {
		return mapOfDays.get(getKeyByIndex(index));
	}
	
	void initMap() {
		mapOfDays = new HashMap<String, String>();
		mapOfDays.put("Monday", "Thứ 2");
		mapOfDays.put("Tuesday", "Thứ 3");
		mapOfDays.put("Wednesday", "Thứ 4");
		mapOfDays.put("Thursday", "Thứ 5");
		mapOfDays.put("Friday", "Thứ 6");
		mapOfDays.put("Saturday", "Thứ 7");
		mapOfDays.put("Sunday", "Chủ nhật");
	}
	public static void main(String[] args) {
		DaysEnglishVietnamese object = new DaysEnglishVietnamese();
		object.initMap();
		Thread thread1 = new Selector(object);
		Thread thread2 = new Displayer(object);
		thread1.start();
		thread2.start();
	}
}
class Selector extends Thread{
	private DaysEnglishVietnamese ob;
	
	
	public Selector(DaysEnglishVietnamese ob) {
		super();
		this.ob = ob;
	}
	public void run() {
		while(true) {
			synchronized (ob) {
				while(ob.keyIndex==-1) {
					int keyIndex = new Random().nextInt(7);
					ob.keyIndex = keyIndex;
					System.out.println(ob.getKeyByIndex(keyIndex));
				}
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
class Displayer extends Thread{
	private DaysEnglishVietnamese ob;
	
	
	public Displayer(DaysEnglishVietnamese ob) {
		super();
		this.ob = ob;
	}
	public void run() {
		while(true) {
			synchronized (ob) {
				while(ob.keyIndex != -1) {
					System.out.println(ob.getValueByIndex(ob.keyIndex));
					break;
				}
				ob.keyIndex = -1;
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
