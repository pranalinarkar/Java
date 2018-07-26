package testthread;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Stack;

public class Logger implements Runnable {
private OutputStream out;
private boolean doStop=false;
private Stack<String> stack=new Stack<>();
	public Logger(OutputStream out) {
	super();
	this.out=out;
	// TODO Auto-generated constructor stub
	}
	public boolean close(){
		return doStop=true;
	}
	public void write(String msg){
		stack.push(msg);
	}
	@Override
	public void run() {
while(!doStop){		// TODO Auto-generated method stub
if(!stack.isEmpty()){
	System.out.println("Getting stack elements");
	try {
		out.write(stack.pop().getBytes());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
else{
try {
	Thread.sleep(100);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("Nothing to write");
}
}
	}

}
