package org.gestion.banque.controllers;

import java.util.List;

import javax.validation.Valid;

import org.gestion.banque.entities.Compte;
import org.gestion.banque.entities.Operation;
import org.gestion.banque.metier.IBanqueMetier;
import org.gestion.banque.models.BanqueForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BanqueController {
	
	@Autowired
	private IBanqueMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model)
	{
		model.addAttribute("banqueForm",new BanqueForm());
		return "banque";
	}
	
	@RequestMapping(value="/chargerCompte")
	public String chargerCompte(@Valid BanqueForm bf,BindingResult bindingResult,Model model)
	{
		if(bindingResult.hasErrors())
		{
			return "banque";
		}
		try
		{
			Compte cp = metier.consulterCompte(bf.getCode());
			bf.setTypeCompte(cp.getClass().getSimpleName());
			bf.setCompte(cp);
			List<Operation> ops= metier.consulterOperations(bf.getCode());
			bf.setOperations(ops);
		}
		catch(Exception e)
		{
			bf.setException(e.getMessage());
		}
		
		model.addAttribute("banqueForm",bf);
		return "banque";
	}
	
	@RequestMapping(value="/saveOperation")
	public String saveOperation(@Valid BanqueForm bf,BindingResult bindingResult,Model model)
	{
		try
		{
			Compte cp = metier.consulterCompte(bf.getCode());
			bf.setTypeCompte(cp.getClass().getSimpleName());
			bf.setCompte(cp);
			
		}
		catch(Exception e)
		{
			bf.setException(e.getMessage());
		}
		if(bindingResult.hasErrors())
		{
			return "banque";
		}
		
		if(bf.getAction()!=null)
		{
			if(bf.getTypeOperation().equals("VER"))
			{
				metier.versement(bf.getCode(),bf.getMontant(),1L);
				
			}
			else if(bf.getTypeOperation().equals("RET"))
			{
				metier.retrait(bf.getCode(),bf.getMontant(),1L);
			}
			else if(bf.getTypeOperation().equals("VIR"))
			{
				metier.virement(bf.getCode(),bf.getCode2(),bf.getMontant(),1L);
			}
		}
		List<Operation> ops= metier.consulterOperations(bf.getCode());
		bf.setOperations(ops);
		return "banque";
	}
	

}
