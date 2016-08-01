package org.att.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{

	public Retrait() 
	{
		super();
		
	}

	public Retrait(Date dateOperation, double montant) 
	{
		super(dateOperation, montant);
		
	}
	
	
	@Override
	public String toString()
	{
		return "Retrait";
		
	}


}
