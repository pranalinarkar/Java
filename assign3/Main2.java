package assign3;

import java.util.Stack;

public class Main2 {

	static	Stack<String> stack=new Stack<>();
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
Produce p=new Produce(stack);
Consume c=new Consume(stack);
Thread t1=new Thread(p);
Thread t2=new Thread(c);
Thread t3=new Thread(p);
Thread t4=new Thread(c);
t1.start();
t2.start();
t3.start();
t4.start();
	}

}
