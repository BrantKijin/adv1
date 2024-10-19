package thread.start.sync;


public class BankAccountV1 implements BankAccount{

	private int balance;
	//volatile private int balance;

	public BankAccountV1(int balance) {
		this.balance = balance;
	}

	@Override
	public boolean withdraw(int amount) throws InterruptedException {

		System.out.println("거래시작:" + getClass().getSimpleName());

		System.out.println("[검증 시작] 출금액 " + amount + ", 잔액: " + balance);

		if(balance < amount){
			System.out.println("[검증 실패] 출금액 " + amount + ", 잔액: " + balance);
			return false;
		}

		System.out.println("[검증 완료] 출금액 " + amount + ", 잔액: " + balance);
		Thread.sleep(1000);

		balance = balance - amount;
		System.out.println("[출금 완료] 출금액 " + amount + ", 변경 잔액: " + balance);
		System.out.println("거래 종료");
		return true;
	}

	@Override
	public int getBalance() {
		return balance;
	}
}
