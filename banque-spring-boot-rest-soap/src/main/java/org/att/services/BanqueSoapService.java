package org.att.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.att.entities.Compte;
import org.att.metier.CompteMetier;
import org.att.metier.OperationMetier;
import org.att.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@WebService
@Component
public class BanqueSoapService {
	
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;
	
	@WebMethod
	public Compte getCompte(@WebParam(name="code") String code) 
	{
		return compteMetier.getCompte(code);
	}
	
	@WebMethod
	public boolean verser(@WebParam(name="code") String code,@WebParam(name="montant") double montant,@WebParam(name="codeEmp") Long codeEmp) 
	{
		return operationMetier.verser(code, montant, codeEmp);
	}
	
	@WebMethod
	public boolean retirer(@WebParam(name="code") String code,@WebParam(name="montant") double montant,@WebParam(name="codeEmp") Long codeEmp)
	{
		return operationMetier.retirer(code, montant, codeEmp);
	}
	
	@WebMethod
	public boolean virement(@WebParam(name="code1") String code1,@WebParam(name="code2") String code2,@WebParam(name="montant") double montant,@WebParam(name="codeEmp") Long codeEmp) 
	{
		return operationMetier.virement(code1, code2, montant, codeEmp);
	}
	
	@WebMethod
	public PageOperation getOperations(@WebParam(name="code") String code,@WebParam(name="page") int page,@WebParam(name="size") int size) 
	{
		return operationMetier.getOperations(code, page, size);
	}

}
