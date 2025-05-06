package banking;

public class BankingOperations {

	public static void main(String[] args) {
		Bank bank = new Bank();
		for(int i = 0; i < Bank.MAX_ACCOUNTS; i++) {
			Thread thread = new Thread(new Transaction(bank, i));
			thread.start();
		}
	}

}
