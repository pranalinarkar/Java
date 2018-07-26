package assign;

public class Credit extends Cards {

	private String interestRate, creditLimit,pointsAccumulated;

	public Credit(long cardnum,String holderName,String Pan,String contacts,String interestRate, String creditLimit,String pointsAccumulated){
		super(holderName,Pan,contacts);
		this.interestRate=interestRate;
		this.creditLimit=creditLimit;
		this.pointsAccumulated=pointsAccumulated;
		
	}
}
