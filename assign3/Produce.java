package assign3;

import java.util.*;

public class Produce implements Runnable {
public  Stack<String> stack=new Stack();


	public Produce(Stack<String> stack) {
	super();
	this.stack = stack;
}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int j=0;j<10;j++){
		    StringBuilder sb = new StringBuilder();
		    String candidateChars="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		    int length=17;
		    Random random = new Random();
		    synchronized(stack){
		    for (int i = 0; i < length; i++) {
		        sb.append(candidateChars.charAt(random.nextInt(candidateChars
		                .length())));
		    }
		    stack.add(sb.toString());
		    System.out.println("Added"+sb);
//		    try {
//		    	Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    if(stack.size()>0){
		    	stack.notify();
		    }}
		    
		}
		}

		}
	


