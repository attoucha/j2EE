package org.att.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation{

	public Versement() 
	{
		super();
		
	}

	public Versement(Date dateOperation, double montant) 
	{
		super(dateOperation, montant);
		
	}
	
	@Override
	public String toString()
	{
		return "Versement";
		
	}

	

	
}
