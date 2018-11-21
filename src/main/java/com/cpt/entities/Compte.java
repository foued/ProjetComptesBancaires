package com.cpt.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CTE",discriminatorType=DiscriminatorType.STRING,length=2)
public class Compte implements Serializable{
	@Id
	private String codeCompte;
	private Date datecreation;
	private Double solde;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	
	@OneToMany(mappedBy="compte")
	
	private Collection<Operation> operations;
	public Compte(Date datecreation, Double solde, Client client, Collection<Operation> operations) {
		super();
		this.datecreation = datecreation;
		this.solde = solde;
		this.client = client;
		this.operations = operations;
	}
	
	public Compte(String codeCompte, Date datecreation) {
		super();
		this.codeCompte = codeCompte;
		this.datecreation = datecreation;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

}
