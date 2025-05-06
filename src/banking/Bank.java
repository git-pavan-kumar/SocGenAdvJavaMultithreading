package banking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

	public static final int MAX_ACCOUNTS = 10;
	public static final int MAX_AMOUNT = 10;
	public static final int INITIAL_BALANCE = 10;
	
	private Account[] accounts = new Account[MAX_ACCOUNTS];
	
	private Lock bankLock;
	
	public Bank() {
		for(int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(INITIAL_BALANCE);
		}
		this.bankLock = new ReentrantLock();
	}
	
	public void transfer(int from, int to, int amount) {
		this.bankLock.lock();
		try {
			if(amount > accounts[from].getBalance()) {
				System.out.println("Insuffcient funds for transfer !!!");
			} else {
				accounts[from].withdrawal(amount);
				accounts[to].deposit(amount);
				String messageString = "%s transferred %d from %s to %s. Total Bank balance: %d\n";
				String threadName = Thread.currentThread().getName();
				System.out.printf(messageString, threadName, amount, from, to, this.getBankTotalBalance());
			}
		} finally {
			this.bankLock.unlock();
		}
	}
	
	private int getBankTotalBalance() {
		this.bankLock.lock();
		try {
			int bal = 0;
			for(int i = 0; i < this.accounts.length; i++) {
				bal += this.accounts[i].getBalance();
			}
			return bal;
		} finally {
			this.bankLock.unlock();
		}
	}
	
}
