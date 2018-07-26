package assign;

import java.util.Scanner;

public class CardFactory {
	static long cardnum;
	static Scanner read=new Scanner(System.in);

public static Cards issueNewCard(CardType CARD){
	System.out.println("Enter ur card details");
	System.out.print("Holder name=");
	String holderName=read.nextLine();
	System.out.print("PAN no=");
	String PAN=read.nextLine();
	System.out.print("Contacts");
	String contacts=read.nextLine();
	
	if(CARD==CardType.CREDIT){
		cardnum=System.currentTimeMillis();
		System.out.println(cardnum);
		System.out.print("Interest rate=");	
		String interestRate=read.nextLine();
		System.out.print("Credit limit=");	
		String creditLimit=read.nextLine();
		System.out.print("Points ACcumulated");	
		String pointsAccumulated=read.nextLine();
		Cards c=new Credit( cardnum,holderName,PAN, contacts,interestRate,creditLimit,pointsAccumulated);
		return c;
	}
	else {
		cardnum=System.currentTimeMillis();
		System.out.print("Account linked=");	
		String accLinked=read.nextLine();
		Debit d=new Debit( cardnum,holderName,PAN, contacts, accLinked);
		return d;
	}

	

	
	
}
}















