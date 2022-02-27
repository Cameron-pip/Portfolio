package week2;

public class BankAccount {
	private String ownerName;
	private double balance;

	public BankAccount(String owner, double initialBalance) {
		ownerName = owner;
		balance = initialBalance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}

	public void transferTo(BankAccount acct2, double amount) {
		this.withdraw(amount);
		acct2.deposit(amount);
	}
	
	public String getOwner() {
		return ownerName;
	}
}
