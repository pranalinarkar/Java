package testthread;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Thread t1=new Thread(new Repeater("Thread 0"));
Thread t2=new Thread(new Repeater("Thread 1"));
t1.setDaemon(true);
t1.start();
t2.start();
//try {
////t2.join();} catch (Exception e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
for(int i=0;i<10;i++){
	System.out.println("MAIN");
//try {
//		Thread.sleep(100);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}
System.out.println("''''''''''''''''END'''''''''''''''");
	}

}
