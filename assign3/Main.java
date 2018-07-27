package assign3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
FileClass file=new FileClass("d:/data/mydata.txt","d:/data/data3.txt");
FileClass file2=new FileClass("d:/data/Desert.jpg","d:/data/Sand.jpg");
Thread t1=new Thread(file);
Thread t2=new Thread(file2);
t1.start();
t2.start();
	}

}
