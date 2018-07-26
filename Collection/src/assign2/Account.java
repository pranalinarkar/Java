package assign2;

public class Account implements Comparable<Account> {
private long accountNumber;
private static int branchCode;
private String accountHolder;
private  float balance;
private AccountType accounttype ;
private Status status;

public long getAccountNumber() {
	return accountNumber;
}
 void setAccountNumber(long accountNumber) {
	this.accountNumber = accountNumber;
}
 
public static int getBranchCode() {
	return branchCode;
}
 static void setBranchCode(int branchCode) {
	Account.branchCode = branchCode;
}
 
public String getAccountHolder() {
	return accountHolder;
}
 void setAccountHolder(String accountHolder) {
	this.accountHolder = accountHolder;
}
public float getBalance() {
	return balance;
}
 Account(long accountNumber, String accountHolder, float balance,AccountType accounttype,Status status) {
	super();
	this.accountNumber = accountNumber;
	this.accountHolder = accountHolder;
	this.balance = balance;
	this.accounttype=accounttype;
	this.status=status;
}
void setBalance(float balance) {
	this.balance = balance;
}
public AccountType getAccounttype() {
	return accounttype;
}
 void setAccounttype(AccountType accounttype) {
	this.accounttype = accounttype;
}
public Status getStatus() {
	return status;
}public void setStatus(Status status) {
	this.status = status;
}
@Override
public String toString() {
	return "Account [accountNumber=" + accountNumber + ", accountHolder=" + accountHolder + ", balance=" + balance
			+ ", accounttype=" + accounttype + ", status=" + status + "]";
}
@Override
public int compareTo(Account arg0) {
	// TODO Auto-generated method stub
	return this.accountHolder.compareTo(arg0.accountHolder);
	
}




}
