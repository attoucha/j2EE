package org.att.metier;

import java.util.Date;

import org.att.dao.CompteRepository;
import org.att.dao.EmployeRepository;
import org.att.dao.OperationRepository;
import org.att.entities.Compte;
import org.att.entities.Employe;
import org.att.entities.Operation;
import org.att.entities.Retrait;
import org.att.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationMetierImpl implements OperationMetier {
	
	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;

	@Override
	@Transactional
	public boolean verser(String codeCp, double montant, Long codeEmp) 
	{
		Employe e = employeRepository.findOne(codeEmp);
		Compte cp = compteRepository.findOne(codeCp);
		Operation o =new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()+montant);
		
		
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String codeCp, double montant, Long codeEmp) 
	{

		Employe e = employeRepository.findOne(codeEmp);
		Compte cp = compteRepository.findOne(codeCp);
		if(cp.getSolde()<montant) throw new RuntimeException("Solde insuffisant");
		Operation o =new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()-montant);
		
		
		return true;
	}

	@Override
	@Transactional
	public boolean virement(String codeCp1, String codeCp2, double montant, Long codeEmp) 
	{
		retirer(codeCp1,montant,codeEmp);
		verser(codeCp2,montant,codeEmp);
		return true;
	}

	@Override
	public PageOperation getOperations(String codeCp, int page, int size) 
	{
		Page<Operation> ops=operationRepository.getOperations(codeCp,new PageRequest(page,size));
		PageOperation pOp=new PageOperation();
		pOp.setOperations(ops.getContent());
		pOp.setNombreOperations(ops.getNumberOfElements());
		pOp.setPage(ops.getNumber());
		pOp.setTotalPages(ops.getTotalPages());
		pOp.setTotalOperations((int)ops.getTotalElements());
		return pOp ;
	}

}
