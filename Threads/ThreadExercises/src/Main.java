//Activity-15
public class Main {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		WithdrawThread husbandThread = new WithdrawThread("Husband", bankAccount, 15000000);
		husbandThread.start();
		WithdrawThread wifeThread = new WithdrawThread("Wife", bankAccount, 20000000);
		wifeThread.start();
	}

}
class BankAccount{
	private long amount = 20000000;
	synchronized void withdraw(String threadName, long withdrawAmount){
		System.out.println(threadName+" need: "+withdrawAmount);
		if(amount>=withdrawAmount) {
			this.amount -= withdrawAmount;
			System.out.println(threadName+" withdraw success: "+withdrawAmount);
		}
		else {
			System.out.println(threadName+" withdraw error!");
		}
		System.out.println(threadName+" see balance: "+this.amount);
		//check account
		//	if enough: minus, print message
		//  if not enough: print warning
		//print remaining amount
		
	}
}
class WithdrawThread extends Thread{
	private BankAccount bankAccount;
	private long withdrawAmount;
	
	public WithdrawThread(String name, BankAccount bankAccount, long withdrawAmount) {
		super();
		this.setName(name);
		this.bankAccount = bankAccount;
		this.withdrawAmount = withdrawAmount;
	}

	public void run() {
		bankAccount.withdraw(this.getName(), this.withdrawAmount);
	}
}