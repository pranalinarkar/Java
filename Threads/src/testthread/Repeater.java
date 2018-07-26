package testthread;

public class Repeater implements Runnable {
private String message;

	public Repeater(String message) {
	super();
	this.message = message;
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name=Thread.currentThread().getName();

	try{
		for(int i=0;i<10;i++){
	System.out.println("name="+message);}
Thread.sleep(1000);
	}
	catch(InterruptedException e){
		System.out.println(e);
	}
	}

}

