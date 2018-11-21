package com.cpt.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "V")
public class Versement extends Operation {

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Long numerooperation, Date dateoperation, double montant, Compte compte) {
		super(numerooperation, dateoperation, montant, compte);
		// TODO Auto-generated constructor stub
	}

}
