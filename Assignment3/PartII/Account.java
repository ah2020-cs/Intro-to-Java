 
public class Account {
	
	private static int account_count;
	private double balance;
	
	private static int nextId;
    private int id = ++nextId;
	
	public Account() {
	}
	
	public Account(double startingBalance) {
		this.balance = startingBalance;
	}
	
	public boolean withdraw(double amount) {
		
		if (this.balance>= amount) {
			this.balance-=amount;
			return true;
		}
		return false;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void deposit(double amount) {
		this.balance+=amount;
	}
	
	public int getId() {
		return this.id;
	}

}
