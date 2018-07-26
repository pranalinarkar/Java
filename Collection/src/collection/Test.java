package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookDAO1 b=new BookDAO1();
b.add(new Book("Pranali","pn@gmail.com","hi",21));
b.add(new Book("Pranali","pn@gmail.com","hi",21));
b.add(new Book("Pranali","pn@gmail.com","hi",21));
b.add(new Book("Pranali","pn@gmail.com","hi",21));
String title="Let Us C++";
System.out.println(title.toLowerCase());
System.out.println(title);
StringBuffer builder=new StringBuffer();
builder.append("Mahendra");
builder.insert(0, "Mr").append(" ").append("Shinde");
System.out.println(builder.toString());
StringTokenizer tokenizer=new StringTokenizer("The quick fox jumps over the dog");
while(tokenizer.hasMoreTokens()){
	System.out.println(tokenizer.nextToken());
}
}

}
