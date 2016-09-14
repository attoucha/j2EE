package main;

import java.util.List;

import metier.BookDao;
import metier.BookDaoImpl;
import model.Book;
import model.Category;

public class BookApp {
	
	private static BookDao bookDao = new BookDaoImpl();
	

	public static void main(String[] args) 
	{
		// List all books
		System.out.println("Listing all Books:");
		findAllBooks();
		
		System.out.println("++++++++++++++++++++++++++++++");

		System.out.println("Searching Books by Keyword: Java");

		searchBooksByKeyword("java");
		

	}
	
	private static void findAllBooks() 
	{
		List<Book> books = bookDao.findAllBooks();
		for (Book book : books) 
		{
			System.out.println(book);
		}
	}
	
	private static void searchBooksByKeyword(String keyWord) 
	{
		List<Book> books = bookDao.searchBooksByKeyword(keyWord);
		for (Book book : books) 
		{
			System.out.println(book);
		}
	}
	
	private static void findAllCategories() 
	{
		List<Category> cats = bookDao.findAllCategories();
		for (Category cat : cats) 
		{
			System.out.println(cat);
		}
	}

}
