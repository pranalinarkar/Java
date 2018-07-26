package app;
import models.Employee;
public class TestMain {
public static void main(String[] args){
	AppLogic2 logic=new AppLogic2();
	Employee[] emp1=new Employee[3];
	emp1[0]=new Employee("Rajiv","Bhatia",52,"Assistatnt Director\n");
	emp1[1]=new Employee("Nikhil","Ishrani",24,"Director\n");
	emp1[2]=new Employee("Priyal","Ishrani",20,"Manager\n");
	logic.write(emp1);
	System.out.println("Data is wrtten to file");
	Employee[] emp2=logic.read();
	System.out.println(emp2[1].getFirstName());
}
}
