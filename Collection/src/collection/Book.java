package collection;

public class Book {
private String title,author,category;
private float price;
public Book(String title, String author, String category, float price) {
	super();
	this.title = title;
	this.author = author;
	this.category = category;
	this.price = price;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
}
