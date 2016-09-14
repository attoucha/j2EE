package model;

public class Category {
	
	private Long id;
	private String description;

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String categoryDescription) 
	{
		this.description = categoryDescription;
	}

	public String toString() 
	{
		return "Category - Id: " + id + ", Category Description: " + description;
	}

}