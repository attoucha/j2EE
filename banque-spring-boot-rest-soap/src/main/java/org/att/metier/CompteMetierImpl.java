package org.att.metier;

import org.att.dao.CompteRepository;
import org.att.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteMetierImpl implements CompteMetier{
	
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Compte saveCompte(Compte cp) 
	{
		return compteRepository.save(cp);
	}

	@Override
	public Compte getCompte(String codeCp) 
	{
		return compteRepository.findOne(codeCp);
	}

}
