package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Person> set=new HashSet();
Person p=new Person("Pranali",21,"p@gmail.com");
set.add(new Person("Nikhil",23,"n@gmail.com"));
set.add(new Person("Priyal",20,"pp@gmail.com"));
set.add(p);
Iterator<Person> it=set.iterator(); 
while(it.hasNext()){
	System.out.println(it.next().getName());
}
	}

}
