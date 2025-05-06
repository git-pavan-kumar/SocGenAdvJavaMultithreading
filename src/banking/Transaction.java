package banking;

public class Transaction implements Runnable {

	private Bank bank;
	private int fromAccount;
	
	public Transaction(Bank bank, int fromAccount) {
		this.bank = bank;
		this.fromAccount = fromAccount;
	}
	
	@Override
	public void run() {
		while(true) {
			int toAccount = (int) (Math.random() * Bank.MAX_ACCOUNTS);
			if(toAccount == this.fromAccount) continue;
			int amount = (int) (Math.random() * Bank.MAX_AMOUNT);
			if(amount ==0) continue;
			this.bank.transfer(this.fromAccount, toAccount, amount);
			
			try {
				Thread.sleep(50);
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
	}

}
