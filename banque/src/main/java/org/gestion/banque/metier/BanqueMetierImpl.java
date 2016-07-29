package org.gestion.banque.metier;

import java.util.Date;
import java.util.List;

import org.gestion.banque.dao.IBanqueDao;
import org.gestion.banque.entities.*;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BanqueMetierImpl implements IBanqueMetier {

	private IBanqueDao dao;
	public void setDao(IBanqueDao dao) 
	{
		this.dao = dao;
	}

	@Override
	public Client addClient(Client c)
	{
		return dao.addClient(c);
	}

	@Override
	public Employe addEmploye(Employe e, Long codeSup) 
	{
		return dao.addEmploye(e, codeSup);
	}

	@Override
	public Groupe addGroupe(Groupe g) 
	{
		return dao.addGroupe(g);
	}

	@Override
	public void addEmployeToGroupe(Long codeEmp, Long codeGr) 
	{
		dao.addEmployeToGroupe(codeEmp, codeGr);
	}

	@Override
	public Compte addCompte(Compte cp, Long codeCl, Long codeEmp)
	{
		return dao.addCompte(cp, codeCl, codeEmp);
	}

	@Override
	public void versement(String codeCp, double montant, Long codeEmp) 
	{
		dao.addOperation(new Versement(new Date(),montant), codeCp, codeEmp);
		Compte cp = dao.consulterCompte(codeCp);
		cp.setSolde(cp.getSolde()+montant);
	}

	@Override
	public void retrait(String codeCp, double montant, Long codeEmp) 
	{
		dao.addOperation(new Retrait(new Date(),montant), codeCp, codeEmp);
		Compte cp = dao.consulterCompte(codeCp);
		cp.setSolde(cp.getSolde()-montant);
	}

	@Override
	public void virement(String codecCp1, String codeCp2, double montant,Long codeEmp) 
	{
		retrait(codecCp1,montant,codeEmp);
		versement(codeCp2,montant,codeEmp);
	}

	@Override
	public Compte consulterCompte(String codeCp) 
	{
		return dao.consulterCompte(codeCp);
	}

	@Override
	public List<Operation> consulterOperations(String codeCp) 
	{
		return dao.consulterOperations(codeCp);
	}

	@Override
	public Client consulterClient(Long codeCl) 
	{
		
		return dao.consulterClient(codeCl);
	}

	@Override
	public List<Client> consulterClients(String mc) 
	{
		return dao.consulterClients(mc);
	}

	@Override
	public List<Compte> getComptesByClient(Long codeCl) 
	{
		return dao.getComptesByClient(codeCl);
	}

	@Override
	public List<Compte> getComptesByEmploye(Long codeEmp) 
	{
		return dao.getComptesByEmploye(codeEmp);
	}

	@Override
	public List<Employe> getEmployes() 
	{
		return dao.getEmployes();
	}

	@Override
	public List<Groupe> getGroupes() 
	{
		return dao.getGroupes();
	}
	@Override
	public List<Client> getClients()
	{
		return dao.getClients();
	}

	@Override
	public List<Employe> getEmployeByGroupe(Long codeGr) 
	{
		return dao.getEmployeByGroupe(codeGr);
	}
	

}
