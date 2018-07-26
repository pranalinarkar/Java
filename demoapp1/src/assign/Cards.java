package assign;

public class Cards {
private static String cardNo;

private static String holderName;

private static String PAN;

private static String contacts;

static int count=0;
Cards(String holderName,String Pan,String contacts){
	
//	this.cardNo=Integer.toString(count);
//	count++;
	this.holderName=holderName;
	this.PAN=PAN;
	this.contacts=contacts;
	
}
public String getHolderName() {
	return holderName;
}
public void setHolderName(String holderName) {
	this.holderName = holderName;
}
public String getCardNo() {
	return cardNo;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}
public static String printNo() {
    return cardNo + ", " + holderName + ", " + PAN + ","+ contacts;
}

}
