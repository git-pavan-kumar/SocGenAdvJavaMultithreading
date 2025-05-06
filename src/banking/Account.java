package banking;

public class Account {

	private int balance = 0;
	
	public Account(int balance) {
		this.balance = balance;
	}
	
	public void withdrawal(int amount) {
		this.balance -= amount;
	}
	
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	public int getBalance() {
		return this.balance;
	}
}
