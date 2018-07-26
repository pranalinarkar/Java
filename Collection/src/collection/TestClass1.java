package collection;


import java.util.*;
public class TestClass1 {
public  static void main(String[] args){
	List<Person> list=new LinkedList<>();
	list.add(new Person("Pranali",21,"pn@gmail.com"));
	list.add(new Person("Nikhil",23,"pn@gmail.com"));
	list.add(new Person("Priyal",19,"pn@gmail.com"));
	list.add(new Person("Shreyas",20,"pn@gmail.com"));
	Collections.sort(list);
	ListIterator<Person> it=list.listIterator();
	while(it.hasNext()){
		System.out.println(it.next().getName());
	}
	Comparator<Person> comparator=(p1,p2)->p1.getAge()-p2.getAge();
	Collections.sort(list,comparator);
	for(Person pp: list){
		System.out.println(pp.getName()+"\t"+pp.getAge());
	}
}
}
