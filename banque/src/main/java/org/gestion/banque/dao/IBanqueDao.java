package org.gestion.banque.dao;

import java.util.List;

import org.gestion.banque.entities.*;

public interface IBanqueDao {
	
	public Client addClient(Client c);
	public Employe addEmploye(Employe e,Long codeSup);
	public Groupe addGroupe(Groupe g);
	public void addEmployeToGroupe(Long codeEmp,Long codeGr);
	public Compte addCompte(Compte cp,Long codeCl,Long codeEmp);
	public Operation addOperation(Operation op,String codeCp,Long codeEmp);
	public Compte consulterCompte(String codeCp);
	public List<Operation> consulterOperations(String codeCp);
	public Client consulterClient(Long codeCl);
	public List<Client> consulterClients(String mc);
	public List<Compte> getComptesByClient(Long codeCl);
	public List<Compte> getComptesByEmploye(Long codeEmp);
	public List<Employe> getEmployes();
	public List<Groupe> getGroupes();
	public List<Client> getClients();
	public List<Employe> getEmployeByGroupe(Long codeGr);
	
	
	

}
