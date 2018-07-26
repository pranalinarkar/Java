package collection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


public class TestClass4 {
	private static final String DATA_PATH="d:/data/mydata.txt";
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		try(BufferedReader br=new BufferedReader(new FileReader(DATA_PATH))){
			StringBuilder builder=new StringBuilder();
			String temp=br.readLine();
			while(temp!=null){
				
				builder.append(temp).append("\n");	
				temp=br.readLine();
				
				}
			StringTokenizer tokenizer=new StringTokenizer(builder.toString()," ,/;.\n\t");
			while(tokenizer.hasMoreTokens()){
			
				System.out.println(tokenizer.nextToken());
			}
			System.out.println(builder.toString());
			}
			
		
		catch(Exception e){
		e.printStackTrace();	
		}
		
	}

}
