package com.cpt.metier;

import org.springframework.data.domain.Page;

import com.cpt.entities.Operation;

public interface OperationMetier {
	
	public void verser(String codecpte,double montant );
	public void retirer(String codecpte,double montant );
	public void virement(String cp1,String cp2,double montant );
	
	public Page<Operation> listeOperation(String cpt,int page,int size);
	

}
