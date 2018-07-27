package assign3;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FileClass implements Runnable {
private String source,destination;

	public FileClass(String source, String destination) {
	super();
	this.source = source;
	this.destination = destination;
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		FileInputStream input;
		FileOutputStream output;
	try{
		
		input = new FileInputStream(source);
		output = new FileOutputStream(destination);
		if(input!=null){
			System.out.println("Source file found,preparing to copy...");
			 
			
			
			byte[] buffer=new byte[1000];

		
			int read = input.read(buffer,0,1000);

			while (read >0) {
			    System.out.println("Read " + read);
			    output.write(buffer,0,read);
			    output.flush();
			    read = input.read(buffer,0,1000);
			}
			System.out.println("Source file copied successfully");
				
		}
		input.close();
		output.close();

		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	
	}

}
