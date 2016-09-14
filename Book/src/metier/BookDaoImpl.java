package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Category;

public class BookDaoImpl implements BookDao {
	
	Connection connection = SingletonConnection.getConnection();

	@Override
	public List<Book> findAllBooks() 
	{
		List<Book> result = new ArrayList<Book>();
		String sql = "select * from book";
		try 
		{
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) 
			{
				Book book = new Book();
				book.setId(resultSet.getLong("id"));
				book.setBookTitle(resultSet.getString("book_title"));
				book.setCategoryId(resultSet.getLong("category_id"));
				result.add(book);
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		} 
		
		return result;
	}

	@Override
	public List<Book> searchBooksByKeyword(String keyWord) 
	{
		List<Book> result = new ArrayList<Book>();
		try 
		{
			PreparedStatement ps = connection.prepareStatement("select * from book where book_title like ? ");
			ps.setString(1,"%" + keyWord+ "%");
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) 
			{
				Book book = new Book();
				book.setId(resultSet.getLong("id"));
				book.setBookTitle(resultSet.getString("book_title"));
				book.setPublisher(resultSet.getString("publisher"));
				result.add(book);
			}
		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
	
		return result;
	}
	
	@Override
	public List<Category> findAllCategories()
	{
		List<Category> result = new ArrayList<>();
		try 
		{
			PreparedStatement statement = connection.prepareStatement( "select * from category");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) 
			{
				Category category = new Category();
				category.setId(resultSet.getLong("id"));
				category.setDescription(resultSet.getString("description"));
				result.add(category);
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void insert(Book book) 
	{
		Connection connection = null;
		try 
		{
	
			PreparedStatement statement = connection.prepareStatement("insert into Book (category_id,book_title,publisher) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1,book.getCategoryId());
			statement.setString(1,book.getBookTitle());
			statement.setString(1,book.getPublisher());
			statement.execute();
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next())
			{
				book.setId(generatedKeys.getLong(1));
			
			}
		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		} 
		finally 
		{
			
		}
	}

	@Override
	public void delete(Long bookId) 
	{
		try 
		{
			PreparedStatement statement = connection.prepareStatement("delete from book where id=?");
			statement.setLong(1,bookId);
			statement.execute();
		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		} 
		finally 
		{
			
		}
	}

}