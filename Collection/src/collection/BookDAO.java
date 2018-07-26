package collection;

import java.util.List;

public interface BookDAO {
void add(Book b);
List<Book> searchByAuthor(String author);
List<Book> belowRs(float amt);
}
