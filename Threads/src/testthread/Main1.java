package testthread;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Repeater r=new Repeater("India");
		Repeater s=new Repeater("Australia");
new Thread(r).start();
new Thread(s).start();


	}

}
