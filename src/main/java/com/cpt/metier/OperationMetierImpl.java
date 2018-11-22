package com.cpt.metier;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cpt.dao.CompteRepository;
import com.cpt.dao.OperationRepository;
import com.cpt.entities.Compte;
import com.cpt.entities.Operation;
import com.cpt.entities.Retrait;
import com.cpt.entities.Versement;

@Service
public class OperationMetierImpl implements OperationMetier{

	
	@Autowired
	private OperationRepository or;
	@Autowired
	private CompteMetier cm;
	
	
	@Transactional
	public void verser(String codecpte, double montant) {
		Compte cp=cm.consulterCompte(codecpte);
		Operation op=new Versement(new Date(), montant, cp);
		or.save(op);
		cp.setSolde(cp.getSolde()+montant);
		
	}

	@Transactional
	public void retirer(String codecpte, double montant) {
		Compte cp=cm.consulterCompte(codecpte);
		Operation op=new Retrait(new Date(), montant, cp);
		if(cp.getSolde()<montant)
		throw new RuntimeException("Solde Insuffisant");
		or.save(op);
		cp.setSolde(cp.getSolde()-montant);
		
	}

	@Override
	public void virement(String cp1, String cp2, double montant) {
		retirer(cp1, montant);
		verser(cp2, montant);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<Operation> listeOperation(String cpt, int page, int size) {
		// TODO Auto-generated method stub
		return or.ListOperation(cpt, new PageRequest(page, size,new Sort(Direction.DESC,"numerooperation")));
	}

}
