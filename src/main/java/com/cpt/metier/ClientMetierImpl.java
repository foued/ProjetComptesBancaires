package com.cpt.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cpt.dao.ClienRepository;
import com.cpt.entities.Client;

@Component
public class ClientMetierImpl implements ClientMetier {

	@Autowired
	private ClienRepository cr;
	public Client AddClient(Client c) {
		// TODO Auto-generated method stub
		
		
		return cr.save(c);
	}

	@Override
	public List<Client> ListClient() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public List<Client> ListClientParMotCle(String mc) {
		// TODO Auto-generated method stub
		return cr.clientparMc(mc);
	}

}
