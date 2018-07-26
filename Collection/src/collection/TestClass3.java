package collection;

import java.util.Enumeration;
import java.util.Properties;

public class TestClass3 {
public static void main(String args[]){
	Properties ps=System.getProperties();
	System.out.println("OS:"+ps.getProperty("os.name"));
	System.out.println("All properties");
	Enumeration enums=ps.keys();
	while(enums.hasMoreElements()){
		String name=enums.nextElement().toString();
		String value=ps.getProperty(name);
		System.out.println(name +"\t\t"+value);
	}
}
}
