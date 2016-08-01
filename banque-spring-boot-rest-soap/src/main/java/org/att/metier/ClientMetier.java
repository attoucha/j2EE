package org.att.metier;

import java.util.List;

import org.att.entities.Client;

public interface ClientMetier {
	
	public Client saveClient(Client c);
	public List<Client> listClients();

}
