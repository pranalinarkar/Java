package assign2;

public class Transaction {
Branch branch=new Branch();

public Transaction(Branch branch) {
	super();
	this.branch = branch;
}
public int withdraw(long accountNumber,float  amount){
	if(branch.people!=null & branch.people.get(accountNumber).getStatus().equals(Status.ACTIVE) & (branch.people.get(accountNumber).getBalance()-amount)>1000){
		branch.people.get(accountNumber).setBalance(branch.people.get(accountNumber).getBalance()-amount);
		return 1;
	}
	else{
		return 0;
	}
}
public int deposit(long accountNumber,float amount){
	if(branch.people!=null & branch.people.get(accountNumber).getStatus().equals(Status.ACTIVE)){
		float temp=branch.people.get(accountNumber).getBalance()+amount;
		branch.people.get(accountNumber).setBalance(temp);
		return 1;
	}
	else{
		return 0;
	}
}
public void transfer(long sourceAccountNumber,long destinationAccountNumber,float amount){
	int check=withdraw(sourceAccountNumber,amount);
	if(check==1){
		deposit(destinationAccountNumber,amount);
	}
}
}
