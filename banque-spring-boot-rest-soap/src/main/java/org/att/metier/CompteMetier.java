package org.att.metier;

import org.att.entities.Compte;

public interface CompteMetier {
	
	public Compte saveCompte(Compte cp);
	public Compte getCompte(String codeCp);

}
