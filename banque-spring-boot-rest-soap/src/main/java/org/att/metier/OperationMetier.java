package org.att.metier;

public interface OperationMetier {
	
	public boolean verser(String codeCp,double montant,Long codeEmp);
	public boolean retirer(String code,double montant,Long codeEmp);
	public boolean virement(String codeCp1,String codeCp2,double montant,Long codeEmp);
	public PageOperation getOperations(String codeCp,int page,int size);

}
