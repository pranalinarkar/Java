package testthread;

import java.util.Date;

//Create a TASK to be run within a thread 
public class DigitalClock implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
while(true){
	Date dt=new Date();
	try{
		System.out.println("Time:" +dt.toString());
		Thread.sleep(1000);
	}
	catch(Exception e){
		System.out.println("Thread interrupted");
	}
}
	}

}
