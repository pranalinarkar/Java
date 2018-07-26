package testthread;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
DigitalClock clock=new DigitalClock();
Thread t=new Thread(clock);
System.out.println("About to start a thread");
t.start();
System.out.println("Number of active thread" +Thread.activeCount());
	}

}
