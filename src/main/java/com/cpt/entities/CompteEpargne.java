package com.cpt.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CE")
public class CompteEpargne extends Compte{
	
	

	

	public double getTaux() {
		return taux;
	}

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(String codeCompte, Date datecreation, double solde, Client client, double taux) {
		super(codeCompte, datecreation, solde, client);
		this.taux = taux;
	}

	public CompteEpargne(String codeCompte, Date datecreation) {
		super(codeCompte, datecreation);
		// TODO Auto-generated constructor stub
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	private double taux;

}
