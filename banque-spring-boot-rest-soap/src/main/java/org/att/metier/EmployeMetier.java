package org.att.metier;

import java.util.List;

import org.att.entities.Employe;

public interface EmployeMetier {
	
	public Employe saveEmplye(Employe e);
	public List<Employe> listEmployes();

}
