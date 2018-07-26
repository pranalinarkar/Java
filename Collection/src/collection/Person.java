package collection;
import java.lang.*;
public class Person implements Comparable<Person> {
private String name;
private int age;
private String email;
public Person(String name, int age, String email) {
	super();
	this.name = name;
	this.age = age;
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getEmail() {
	return email;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + age;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Person other = (Person) obj;
	if (age != other.age)
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public int compareTo(Person arg0) {
	// TODO Auto-generated method stub
	return this.name.compareTo(arg0.name);
	
}
}
