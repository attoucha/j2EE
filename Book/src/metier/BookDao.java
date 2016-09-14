package metier;

import java.util.List;

import model.Book;
import model.Category;

public interface BookDao {
	
	public List<Book> findAllBooks();
	public List<Category> findAllCategories();
	public List<Book> searchBooksByKeyword(String keyWord);
	public void insert(Book book);
	public void delete(Long bookId);
	

}
