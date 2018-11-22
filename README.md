# ProjetComptesBancaires
On a envoyé une requette avec Get /index au dispatcherServlet qui est un FrontController qui va recevoir toutes les requetes clients.

DispatcherServlet va chercher dans quel controller est associé cette action.

Il a trouvé que c'est dans le controller produits on a une methode qui retourne le nom de la vue(produits) en tapant /index.

Il a cherché apres cette vue qui est produits.html.


Maintenant on veut afficher tous les produits dans la base de données.

On va créer un Model qui va stocker le resultat de retour des produits.


Dans le model MVC on accede jamais a la vue directement ,on accede au controlleur qui va appeller ma vue

Ici c'est un exemple d'une methode dans controlleur:
public String produits(Model model)
	{
		List<Produit> produit=rp.findAll();// le controlleur accede a la couche metier pour récuperer les données
		model.addAttribute("listesDesproduits",produit);// Apres il va les stocker dans un modele.
		return"produits"; Finalement il va afficher la vue.

	}
	
	
	
Sur la couche metier a besoin de la couche DAO pour acceder a l'entite

et pour faire l'injection des dependances on ajoute Autowired;

Pour que springbott instancie la couche metier au demarrage il faut ajouter l'annotation service ou Componenet.

exemple: public class ClientMetierImpl implements ClientMetier

Pour faire l'injection des dependances soit par annotation soit par xml.


@Transactionnal

Il fau que toutes les operations soit executés si il y a exception rollback,sinon commit
exemple  OperationMetierImpl	
