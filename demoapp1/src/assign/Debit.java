package assign;

public class Debit extends Cards {
private final int MAXWITHDRAWAL=10000;
private String accLinked;

public Debit(long cardnum,String holderName,String Pan,String contacts,String accLinked){
	super(holderName,Pan,contacts);
	this.accLinked=accLinked;
	
}

}
