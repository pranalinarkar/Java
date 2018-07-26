package app;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class ReadFileApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Reading file through channel");
try(FileInputStream fis=new FileInputStream(("d:/data/emps.txt"))){
	FileChannel in=fis.getChannel();
	ByteBuffer buffer=ByteBuffer.allocate(100);
	int readBytes=in.read(buffer);
	while(readBytes!=-1){
		buffer.flip();
		while(buffer.hasRemaining()){
			System.out.println((char)buffer.get());
			
		}
		buffer.clear();
		readBytes=in.read(buffer);
	}
}
catch(Exception e){
	e.printStackTrace();
}

		
	}

}
