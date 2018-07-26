package demointerface;

public class Computer {
 public Storage primaryStorage;
 public Display primarydisplay;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Computer comp=new Computer();
comp.primarydisplay=new Projector();
comp.primaryStorage=new Storage(){
	@Override
	public void read(){
		System.out.println("REading");
		
	}
	@Override
	public void write(){
		System.out.println("Writing");
	}
};
comp.primarydisplay.draw();
comp.primaryStorage.read();
comp.primaryStorage.write();
	}

}
