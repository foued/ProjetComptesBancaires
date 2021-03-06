package com.cpt.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING,length=1,name="TYPE_OP")
public class Operation implements Serializable {
	
	@Id
	@GeneratedValue
	
	private Long numerooperation;
	private Date dateoperation;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="CODE_CPTE")
	private Compte compte;
	
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Operation(Date dateoperation, double montant, Compte compte) {
		super();
		this.dateoperation = dateoperation;
		this.montant = montant;
		this.compte = compte;
	}

	public Long getNumerooperation() {
		return numerooperation;
	}
	public void setNumerooperation(Long numerooperation) {
		this.numerooperation = numerooperation;
	}
	public Date getDateoperation() {
		return dateoperation;
	}
	public void setDateoperation(Date dateoperation) {
		this.dateoperation = dateoperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
	

}
