package com.cpt.metier;

import java.util.List;

import com.cpt.entities.Client;

public interface ClientMetier {
	
	public Client  AddClient(Client c);
	public List<Client> ListClient();
	public List<Client> ListClientParMotCle(String mc);
 	
	

}
