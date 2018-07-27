package assign3;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.*;
public class ContactWriter implements Runnable {
private String destFileName;
List list=new LinkedList<>();

	public ContactWriter(String destFileName, List<ContactList> list) {
	super();
	this.destFileName = destFileName;
	this.list = list;
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
FileWriter writer=new FileWriter(destFileName,true);
for (int i=0; i<list.size();i++){
String buffer=list.get(i).toString();
writer.write(buffer);
writer.flush();
}	}
		catch(Exception e){
			e.printStackTrace();
		}
}

}
