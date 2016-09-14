package model;

public class Book {
	
	private Long id;
	private Long categoryId;
	private String bookTitle;
	private String publisher;

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	
	public Long getCategoryId() 
	{
		return categoryId;
	}

	public void setCategoryId(Long categoryId) 
	{
		this.categoryId = categoryId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) 
	{
		this.bookTitle = bookTitle;
	}
	
	@Override
	public String toString() 
	{
		return "Book - Id: " + id + ", Book Title: " + bookTitle;
	}

	public String getPublisher() 
	{
		return publisher;
	}

	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}

}