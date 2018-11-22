package com.cpt.metier;

import com.cpt.entities.Compte;

public interface CompteMetier {
	public Compte ajouterCompte(Compte c);
	public Compte consulterCompte(String codeCpt);

}
