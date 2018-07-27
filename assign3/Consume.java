package assign3;

import java.util.Stack;

public class Consume implements Runnable {
	public  Stack<String> stack=new Stack();
	
	
	
	public Consume(Stack<String> stack) {
		super();
		this.stack = stack;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub

System.out.println(stack.size());

try {
	synchronized(stack){
		for(int i=0	;i<10;i++){
	while(stack.size()==0){
		stack.wait();
	}
	
		System.out.println("Deleted"+stack.pop().toString());
		System.out.println(stack.size());
		
	}
	}
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
	}
	


