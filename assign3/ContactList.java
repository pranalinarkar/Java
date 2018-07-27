package assign3;

public class ContactList {
private String firstName,lastName,email;
private int age;
private long phone;
public ContactList(String firstName, String lastName, String email, long phone, int age) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phone = phone;
	this.age = age;
}
public String getFirstName() {
	return firstName;
}
public String getLastName() {
	return lastName;
}
public String getEmail() {
	return email;
}
public int getAge() {
	return age;
}
public long getPhone() {
	return phone;
}
@Override
public String toString() {
	return "ContactList [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", age=" + age
			+ ", phone=" + phone + "]";
}





}
