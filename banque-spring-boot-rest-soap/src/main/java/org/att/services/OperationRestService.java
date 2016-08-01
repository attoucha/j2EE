package org.att.services;

import org.att.metier.OperationMetier;
import org.att.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestService {
	
	@Autowired
	private OperationMetier operationMetier;

	@RequestMapping(value="/operations",method=RequestMethod.GET)
	public PageOperation getOperations(@RequestParam String codeCp,@RequestParam int page,@RequestParam int size) {
		return operationMetier.getOperations(codeCp, page, size);
	}

	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public boolean verser(@RequestParam String codeCp,@RequestParam  double montant,@RequestParam  Long codeEmp) 
	{
		return operationMetier.verser(codeCp, montant, codeEmp);
	}

	@RequestMapping(value="/retrait",method=RequestMethod.PUT)
	public boolean retirer(@RequestParam String codeCp,@RequestParam double montant,@RequestParam Long codeEmp)
	{
		return operationMetier.retirer(codeCp, montant, codeEmp);
	}

	@RequestMapping(value="/virement",method=RequestMethod.PUT)
	public boolean virement(@RequestParam String codeCp1,@RequestParam String codeCp2,@RequestParam double montant,@RequestParam Long codeEmp) 
	{
		return operationMetier.virement(codeCp1,codeCp2,montant,codeEmp);
	}

}
