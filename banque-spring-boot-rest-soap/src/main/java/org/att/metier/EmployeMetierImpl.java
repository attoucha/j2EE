package org.att.metier;

import java.util.List;

import org.att.dao.EmployeRepository;
import org.att.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeMetierImpl implements EmployeMetier {

	@Autowired
	private EmployeRepository employeRepository;
	@Override
	public Employe saveEmplye(Employe e) 
	{
		return employeRepository.save(e);
	}

	@Override
	public List<Employe> listEmployes() 
	{
		return employeRepository.findAll();
	}

}
