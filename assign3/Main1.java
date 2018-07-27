package assign3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;
public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ContactList> list=new LinkedList();
		list.add(new ContactList("Pranali","Narkar","pnarkar19@gmail.com",9833146036L,21));
		list.add(new ContactList("Nikhil","Narkar","nnarkar19@gmail.com",9833146036L,24));
		list.add(new ContactList("Priyal","Narkar","prnarkar19@gmail.com",9833146036L,20));
		list.add(new ContactList("Shreyas","Sawant","snarkar19@gmail.com",9833146036L,21));
		list.add(new ContactList("Diksha","Singh","dnarkar19@gmail.com",9833146036L,21));
		list.add(new ContactList("Megha","Shanbaug","mnarkar19@gmail.com",9833146036L,21));
		list.add(new ContactList("Sonali","Gupta","sonarkar19@gmail.com",9833146036L,21));
		
		ExecutorService service=Executors.newFixedThreadPool(3);
		ContactWriter c1=new ContactWriter("d:/data/data7.txt",list);
		ContactWriter c2=new ContactWriter("d:/data/data8.txt",list);
		ContactWriter c3=new ContactWriter("d:/data/data9.txt",list);
		
		service.submit(c1);
		service.submit(c2);
		service.submit(c3);
	}

}
