package org.gestion.banque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.gestion.banque.entities.Client;
import org.gestion.banque.entities.Compte;
import org.gestion.banque.entities.Employe;
import org.gestion.banque.entities.Groupe;
import org.gestion.banque.entities.Operation;

public class BanqueDaoImpl implements IBanqueDao {
    @PersistenceContext
	private EntityManager em;
	
	@Override
	public Client addClient(Client c) 
	{
		em.persist(c);
		return c;
	}

	@Override
	public Employe addEmploye(Employe e, Long codeSup) 
	{
		if(codeSup!=null)
		{
			Employe sup =em.find(Employe.class,codeSup);
			e.setEmployeSup(sup);
		}
		em.persist(e);
		return e;
	}

	@Override
	public Groupe addGroupe(Groupe g) 
	{
		em.persist(g);
		
		return g;
	}

	@Override
	public void addEmployeToGroupe(Long codeEmp, Long codeGr) 
	{
		
		Employe e = em.find(Employe.class,codeEmp);
		Groupe g = em.find(Groupe.class,codeGr);
		e.getGroupes().add(g);
		g.getEmployes().add(e);
		em.persist(g);
		em.persist(e);
		
	}

	@Override
	public Compte addCompte(Compte cp, Long codeCl, Long codeEmp) 
	{
		Client cl=em.find(Client.class,codeCl);
		Employe emp = em.find(Employe.class,codeEmp);
		cp.setClient(cl);
		cp.setEmploye(emp);
		em.persist(cp);
		return cp;
	}

	@Override
	public Operation addOperation(Operation op, String codeCp, Long codeEmp)
	{
		Compte cp = consulterCompte(codeCp);
		Employe emp = em.find(Employe.class,codeEmp);
		op.setCompte(cp);
		op.setEmploye(emp);
		em.persist(op);
		return op;
	}

	@Override
	public Compte consulterCompte(String codeCp)
	{
		Compte cp =em.find(Compte.class,codeCp);
		if(cp==null) throw new RuntimeException("Compte introuvable!");
		return cp;
	}

	@Override
	public List<Operation> consulterOperations(String codeCp) 
	{
		Query req = em.createQuery("select o from Operation o where o.compte.codeCompte=:x");
		req.setParameter("x",codeCp);
		
		return req.getResultList();
	}

	@Override
	public Client consulterClient(Long codeCl)
	{
		Client c =em.find(Client.class,codeCl);
		if(c==null) throw new RuntimeException("Client introuvable!");
		return c;
	}

	@Override
	public List<Client> consulterClients(String mc)
	{
		Query req = em.createQuery("select c from Client c where c.nomClient like:x");
		req.setParameter("x","%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Compte> getComptesByClient(Long codeCl)
	{
		Query req = em.createQuery("select cp from Compte cp where cp.client.codeClient=:x");
		req.setParameter("x",codeCl);
		return req.getResultList();
	}

	@Override
	public List<Compte> getComptesByEmploye(Long codeEmp) 
	{
		Query req = em.createQuery("select cp from Compte cp where cp.employe.codeEmploye=:x");
		req.setParameter("x",codeEmp);
		return req.getResultList();
	}

	@Override
	public List<Employe> getEmployes() 
	{
		Query req = em.createQuery("select e from Employe e");
		return req.getResultList();
	}

	@Override
	public List<Groupe> getGroupes() 
	{
		Query req = em.createQuery("select g from Groupe g");
		return req.getResultList();
	
	}

	@Override
	public List<Employe> getEmployeByGroupe(Long codeGr) 
	{
		Query req = em.createQuery("select e from Employe e inner join e.groupes g where g.codeGroupe=:x");
		req.setParameter("x",codeGr);
		return req.getResultList();
	}

	@Override
	public List<Client> getClients() 
	{
		Query req = em.createQuery("select c from Client c");
		return req.getResultList();
	}

}
