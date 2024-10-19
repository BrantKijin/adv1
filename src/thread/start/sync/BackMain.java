package thread.start.sync;

public class BackMain {

	public static void main(String[] args) throws InterruptedException {

		BankAccount account = new BankAccountV1(1000);

		Thread t1 = new Thread(new WithdrawTask(account,800), "t1");
		Thread t2 = new Thread(new WithdrawTask(account,800), "t2");

		t1.start();
		t2.start();

		Thread.sleep(500); //

		System.out.println("t1 state: " + t1.getState());
		System.out.println("t2 state: " + t2.getState());


		t1.join();
		t2.join();
		System.out.println("최종 잔액: " + account.getBalance());


	}
}
