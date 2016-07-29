package org.gestion.banque;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.gestion.banque.entities.Client;
import org.gestion.banque.entities.CompteCourant;
import org.gestion.banque.entities.CompteEpargne;
import org.gestion.banque.entities.Employe;
import org.gestion.banque.entities.Groupe;
import org.gestion.banque.metier.IBanqueMetier;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {
	
	private ClassPathXmlApplicationContext context;

	@Before
	public void setUp() throws Exception 
	{
		context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}
/*
	@Test
	public void test1()
	{
		try 
		{
			
			IBanqueMetier metier = (IBanqueMetier) context.getBean("metier");
			List<Client> client1=metier.getClients();
			metier.addClient(new Client("C1","AD1"));
			metier.addClient(new Client("C2","AD2"));
			List<Client> client2=metier.getClients();
			assertTrue(client2.size()==client1.size()+2);
			
		}
		catch (Exception e) 
		{
			assertTrue(e.getMessage(),false);
		}
	}
	
	@Test
	public void test2()
	{
		try 
		{
			
			IBanqueMetier metier = (IBanqueMetier) context.getBean("metier");
			List<Employe> emp1=metier.getEmployes();
			metier.addEmploye(new Employe("E1"),null);
			metier.addEmploye(new Employe("E2"),1L);
			metier.addEmploye(new Employe("E3"),1L);
			List<Employe> emp2=metier.getEmployes();
			assertTrue(emp2.size()==emp1.size()+3);
			
			
		}
		catch (Exception e) 
		{
			assertTrue(e.getMessage(),false);
		}
	}
	*/
	@Test
	public void test3()
	{
		try 
		{
			
			IBanqueMetier metier = (IBanqueMetier) context.getBean("metier");
			/*
			metier.addEmploye(new Employe("E1"),null);
			metier.addEmploye(new Employe("E2"),1L);
			metier.addEmploye(new Employe("E3"),1L);
			metier.addGroupe(new Groupe("G1"));
			metier.addEmployeToGroupe(1L,1L);
			metier.addEmployeToGroupe(2L,1L);
			metier.addEmployeToGroupe(3L,1L);
			*/
			metier.addEmploye(new Employe("E1"),null);
			metier.addEmploye(new Employe("E2"),1L);
			metier.addClient(new Client("C1","AD1"));
			metier.addCompte(new CompteCourant("CC1",new Date(),2500,500),1L,1L);
			metier.addCompte(new CompteEpargne("CE1",new Date(),15000,5.5),1L,1L);
		//	List<Employe> emp = metier.getEmployeByGroupe(1L);
			assertTrue(true);
			
			
		}
		catch (Exception e) 
		{
			assertTrue(e.getMessage(),false);
		}
	}
	
}
