package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BookDAO1 implements BookDAO {
List<Book> book=new LinkedList<>();
	@Override
	public  void add(Book b) {
		// TODO Auto-generated method stub
book.add(b);
	}

	@Override
	public List<Book> searchByAuthor(String author) {
		// TODO Auto-generated method stub
		Iterator<Book> it=book.iterator(); 
		List<Book> tempList=new LinkedList<>();
		while(it.hasNext()){
			if(author==it.next().getAuthor()){
				tempList.add(it.next());
				return tempList;
				
			}
		}
		return null;
	}

	@Override
	public List<Book> belowRs(float amt) {
		// TODO Auto-generated method stub
		List<Book> tempList=new LinkedList<>();
		for(Book b: book){
			if(b.getPrice()<amt){
				tempList.add(b);
				return tempList;
			}
		}
		return null;
	}

}
