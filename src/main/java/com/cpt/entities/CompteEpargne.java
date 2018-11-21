package com.cpt.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CE")
public class CompteEpargne extends Compte{
	
	public CompteEpargne(Date datecreation, Double solde, Client client, Collection<Operation> operations,
			double taux) {
		super(datecreation, solde, client, operations);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(Date datecreation, Double solde, Client client, Collection<Operation> operations) {
		super(datecreation, solde, client, operations);
		// TODO Auto-generated constructor stub
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
