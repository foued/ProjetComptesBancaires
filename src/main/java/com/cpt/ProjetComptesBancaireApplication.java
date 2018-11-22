package com.cpt;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cpt.entities.Client;
import com.cpt.entities.CompteCourant;
import com.cpt.entities.CompteEpargne;
import com.cpt.metier.ClientMetier;
import com.cpt.metier.CompteMetier;


@SpringBootApplication
public class ProjetComptesBancaireApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(ProjetComptesBancaireApplication.class, args);
		
		ClientMetier clientmetier=ctx.getBean(ClientMetier.class);
		
		clientmetier.AddClient(new Client("Kamil"));
		clientmetier.AddClient(new Client("Delphine"));
		clientmetier.AddClient(new Client("Amine"));
		clientmetier.AddClient(new Client("Samir"));
		System.out.println("******************ListDesClients*************************");
		List<Client> clts=clientmetier.ListClient();
		
		for(Client c:clts)
		{
			System.out.println(c.getNom());
		}
		System.out.println("******************ListDesClientsParMotCles*************************");
		
		List<Client>cltsmc =clientmetier.ListClientParMotCle("%a%");
	
	for(Client c:cltsmc)
	{
		System.out.println(c.getNom());
	}
//	System.out.println("******************Comptes*************************");
//	
//	
//	CompteMetier compteMetier=ctx.getBean(CompteMetier.class);
//	compteMetier.ajouterCompte(new CompteCourant("1", new Date(),9000, new Client(1L), 200));
//	compteMetier.ajouterCompte(new CompteCourant("2", new Date(),15000, new Client(2L), 800));
//	compteMetier.ajouterCompte(new CompteCourant("1", new Date(),10000, new Client(1L), 100));
//	compteMetier.ajouterCompte(new CompteEpargne("3", new Date(),55000, new Client(2L), 0.05));
//	
}
}