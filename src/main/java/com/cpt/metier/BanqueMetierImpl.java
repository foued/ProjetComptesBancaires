package com.cpt.metier;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cpt.dao.CompteRepository;
import com.cpt.dao.OperationRepository;
import com.cpt.entities.Compte;
import com.cpt.entities.CompteCourant;
import com.cpt.entities.Operation;
import com.cpt.entities.Retrait;
import com.cpt.entities.Versement;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier{

	@Autowired
	private CompteRepository cr;
	@Autowired
	private OperationRepository rp;
	@Override
	public Compte consulter(String codecpte) {
		Compte cp=cr.findById(codecpte).orElse(null);
		if(cp==null) throw new RuntimeException("Compte Introuvable");
		return cp;
	}

	@Override
	public void verser(String codecpte, double montant) {
		Compte cp=consulter(codecpte);
		Versement opv=new Versement(new Date(), montant, cp);
		rp.save(opv);
		cp.setSolde(cp.getSolde()+montant);
		cr.save(cp);
		
		
	}

	@Override
	public void retirer(String codecpte, double montant) {
		Compte cp=consulter(codecpte);
		Retrait opr=new Retrait(new Date(), montant, cp);
		double facilitedecaise=0;
		if(cp instanceof CompteCourant)
			facilitedecaise=((CompteCourant)cp).getDecouvert();
		if(cp.getSolde()+facilitedecaise>facilitedecaise)
			throw new RuntimeException("Solde Insuffisant");
		rp.save(opr);
		cp.setSolde(cp.getSolde()-montant);
		cr.save(cp);
		
	}

	@Override
	public void virement(String cp1, String cp2, double montant) {
		// TODO Auto-generated method stub
		
		if(cp1.equals(cp2))
			throw new RuntimeException("Impossible de faire un virement sur un meme compte");
		retirer(cp1, montant);
		verser(cp2, montant);
		
	}

	@Override
	public Page<Operation> listeOperation(String cpt, int page, int size) {
		// TODO Auto-generated method stub
		return rp.ListOperation(cpt, new PageRequest(page, size));
	}

}
