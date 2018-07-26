package testthread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Mainlog {
public static void main(String args[])throws IOException{
	 FileOutputStream fout=new FileOutputStream(("d:/data/data2.txt"));

	Logger log=new Logger(System.out);
	Logger log1=new Logger(fout);
	log.write("India");
	log1.write("Australia");
	log.write("Mumbai");
	log1.write("Sydney");
	Thread t1=new Thread(log);
	Thread t2=new Thread(log1);
	t1.start();
	t2.start();
	
	
}
}
