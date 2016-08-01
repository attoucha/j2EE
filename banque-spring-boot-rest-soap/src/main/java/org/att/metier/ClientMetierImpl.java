package org.att.metier;

import java.util.List;

import org.att.dao.ClientRepository;
import org.att.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMetierImpl implements ClientMetier{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client saveClient(Client c) 
	{
		
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listClients() 
	{
		
		return clientRepository.findAll();
	}

}
