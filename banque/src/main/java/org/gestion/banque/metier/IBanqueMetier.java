package org.gestion.banque.metier;

import java.util.List;

import org.gestion.banque.entities.Client;
import org.gestion.banque.entities.Compte;
import org.gestion.banque.entities.Employe;
import org.gestion.banque.entities.Groupe;
import org.gestion.banque.entities.Operation;

public interface IBanqueMetier {
	
	public Client addClient(Client c);
	public Employe addEmploye(Employe e,Long codeSup);
	public Groupe addGroupe(Groupe g);
	public void addEmployeToGroupe(Long codeEmp,Long codeGr);
	public Compte addCompte(Compte cp,Long codeCl,Long codeEmp);
    public void versement(String codeCp,double montant,Long codeEmp);
	public void retrait(String codeCp,double montant,Long codeEmp);
	public void virement(String codecCp1,String codeCp2,double montant,Long codeEmp);
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
