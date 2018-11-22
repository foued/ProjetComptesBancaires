package com.cpt.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.dao.CompteRepository;
import com.cpt.entities.Compte;

@Service
public class CompteMetierImpl implements CompteMetier {

	
	@Autowired
	private CompteRepository cr;
	public Compte ajouterCompte(Compte c) {
		// TODO Auto-generated method stub
		return cr.save(c);
	}

	@Override
	public Compte consulterCompte(String codeCpt) {
	//Compte cp=cr.findOne(codeCpt);
	Compte cp=cr.findById(codeCpt).orElse(null);
	if(cp==null)throw new RuntimeException("Compte Introuvable");
	
		return cp;
	}

}
