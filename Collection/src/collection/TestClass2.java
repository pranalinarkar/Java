package collection;
import java.util.*;
import java.util.Map.Entry;
import java.lang.*;
public class TestClass2 {
public  static void main(String[] args){
	Map<String,Person> people=new HashMap<>();
	people.put("P1",new Person("Pranali",21,"pn@gmail.com"));
	people.put("P2",new Person("Nikhil",21,"pn@gmail.com"));
	people.put("P3",new Person("Priyal",21,"pn@gmail.com"));
	people.put("P4",new Person("Shreyas",21,"pn@gmail.com"));
	System.out.println(people.get("P2").getName());
	Set<Entry <String,Person>> entries=people.entrySet();
	for(Entry e:entries){
		System.out.println(e.getKey()+""+((Person) e.getValue()).getName());
	}
	
}
}
