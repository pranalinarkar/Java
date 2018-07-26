package app;
import java.io.*;


import models.Employee;

public class AppLogic2 {
	
private static final String DATA_PATH="d:/data/emps.dat";
public Employee[] read(){
	Employee []temp=new Employee[100];
	int i=0;
	try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(DATA_PATH))){
		Object line =in.readObject();
		while(line!=null){
			
			temp[i]=(Employee)line;
			i++;
			line =in.readObject();
			
		}
	}
	catch(IOException | ClassNotFoundException e){
		e.printStackTrace();
	}
	return temp;
}

public void write(Employee[] emps) {
	try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(DATA_PATH))){
		for(Employee e:emps){
			out.writeObject(e);
			out.flush();
		}
	}
	catch(IOException e){
		e.printStackTrace();
	}
			
}
}