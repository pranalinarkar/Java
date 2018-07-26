package assign;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;




public class CardStore {
	private static final String DATA_PATH="d:/data/cards.dat";
	public static Cards CardsList[]=new Cards[100];
static int i=0;

static Cards[] load(){
	
	
	try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(DATA_PATH))){
		Object line =in.readObject();
		while(line!=null){
			
			CardsList[i]=(Cards)line;
			i++;
			line =in.readObject();
			
		}
	}
	catch(IOException | ClassNotFoundException e){
		e.printStackTrace();
	}
	return CardsList;
}

static void store(){
	try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(DATA_PATH))){
		for(Cards e:CardsList){
			out.writeObject(e);
			out.flush();
		}
	}
	catch(IOException e){
		e.printStackTrace();
	}
}
static int add(Cards c){
	CardsList[i++]=c;
	System.out.println(CardsList[0].getHolderName());
	return i;
}
static void searchByCardNo(String cardNo){
	int len=CardsList.length;
	System.out.println(i);
	for(Cards cr: CardsList){
		System.out.println("Working1");
		if(cr.getCardNo()==null){
			System.out.println("It is null");
			}	
		else{
			if(cardNo.equals(cr.getCardNo())){
				System.out.println("Working2");
				cr.printNo();
				System.out.println("working");
		}
		
	
	
	}
	
}
}

static Cards[] findByHolderName(String holderName){
	int len=CardsList.length;
	int j=0;
	Cards temp[]= new Cards[100];
	while(j<=i){
	if(holderName==CardsList[len].getHolderName()){
		 temp[i]= (Cards)CardsList[len];
		i++;
	}
	len--;
	}
	if(temp!=null){
		return temp;
	}
	else{
		return null;
	}
}
}
