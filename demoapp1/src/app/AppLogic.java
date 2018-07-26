package app;
import java.io.*;
import java.io.FileWriter;

import models.Employee;
import models.Employee;
public class AppLogic {
private static final String DATA_PATH="d:/data/emps.txt";
public Employee[] read(){
	Employee []temp=new Employee[100];
	int i=0;
	try(BufferedReader br=new BufferedReader(new FileReader(DATA_PATH))){
		String line =br.readLine();
		while(line!=null&&line.trim().length()>0){
			String[] fields=line.split(",");
			Employee e=convert(fields);
			temp[i]=e;
			i++;
			line=br.readLine();
			
		}
	}
	catch(IOException e){
		e.printStackTrace();
	}
	return temp;
}
Employee convert(String[] values){
	String fname=values[0].trim();
	String lname=values[1].trim();
	String tempAge=values[2].trim();
	int age=Integer.parseInt(tempAge);
	String designation=values[3].trim();
	return new Employee(fname,lname,age,designation);
	
}
public void write(Employee[] emps){
	try(BufferedWriter bw=new BufferedWriter(new FileWriter(DATA_PATH))){
		for(Employee e:emps){
			bw.write(e.getFirstName()+","+e.getLastName()+","+e.getAge()+","+e.getDesignation());
			bw.flush();
		}
	}
	catch(IOException e){
		e.printStackTrace();
	}
			
}
}
