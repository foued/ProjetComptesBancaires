package com.cpt.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "CC")
public class CompteCourant extends Compte{
	
	private double decouvert;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(Date datecreation, Double solde, Client client, Collection<Operation> operations) {
		super(datecreation, solde, client, operations);
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(String codeCompte, Date datecreation) {
		super(codeCompte, datecreation);
		// TODO Auto-generated constructor stub
	}

	

	public CompteCourant(Date datecreation, Double solde, Client client, Collection<Operation> operations,
			Double decouvert) {
		super(datecreation, solde, client, operations);
		this.decouvert = decouvert;
	}

	public Double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(Double decouvert) {
		this.decouvert = decouvert;
	}

}
