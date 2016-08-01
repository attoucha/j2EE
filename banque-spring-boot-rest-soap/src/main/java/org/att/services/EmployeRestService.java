package org.att.services;

import java.util.List;

import org.att.entities.Employe;
import org.att.metier.EmployeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeRestService {
	
	@Autowired
	private EmployeMetier employeMetier;

	@RequestMapping(value="/employes",method=RequestMethod.POST)
	public Employe saveEmplye(@RequestBody Employe e) 
	{
		return employeMetier.saveEmplye(e);
	}

	@RequestMapping(value="/employe",method=RequestMethod.GET)
	public List<Employe> listEmployes() 
	{
		return employeMetier.listEmployes();
	}
	

}
