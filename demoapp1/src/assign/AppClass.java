package assign;
import java.util.*;
import assign.CardStore;
public class AppClass {
	static Scanner read=new Scanner(System.in);
	static int  num;
public static void main(String[] args){
	CardStore.load();
	int no=0;
	while(1==1){
		System.out.println("MENU");
		System.out.println("1. ADD NEW CARD");
		System.out.println("2. FIND CARD");
		System.out.println("3. LIST OF HOLDER'S CARDS");
		System.out.println("4. QUIT");
		no=read.nextInt();
		
			switch(no){
			case 1:
				 addNewCard();
				 break;
			case 2:
				read.nextLine();
				System.out.println("Enter ur cardNo");
				String cardNo=read.nextLine();
				System.out.println(cardNo);
				findACard(cardNo);
				break;
			case 3:
				System.out.println("enter ur holder name");
				String holderName=read.nextLine();
				listCards(holderName);
				break;
			case 4:
				
					quitApp();
				
				break;
			
	}
	}
} 
static void addNewCard(){
	


	System.out.println("Enter ur card type: debit 2 or credit 1 ?");
	int choice=read.nextInt();
	if(choice==1)
	CardStore.add(CardFactory.issueNewCard(CardType.CREDIT));
	else
	CardStore.add(CardFactory.issueNewCard(CardType.DEBIT));	}

private static void findACard(String cardNo){
	System.out.println(cardNo);
	 CardStore.searchByCardNo(cardNo);
   

}

private static void listCards(String holderName){
	CardStore.findByHolderName(holderName);
}
private static void quitApp(){
	System.out.println("Are you sure? Y/N");
	String temp1=read.nextLine();
	temp1=temp1.toUpperCase();	
	if(temp1.equals("Y")|temp1.equals("YES")){
		CardStore.store();
		System.exit(1);
	}
}


	

}


