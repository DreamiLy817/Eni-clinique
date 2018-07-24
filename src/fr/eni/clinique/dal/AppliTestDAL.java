package fr.eni.clinique.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;

public class AppliTestDAL {

	/**
	 * @param args
	 * @throws DALException
	 */
	public static void main(String[] args) throws DALException {

		// d�claration et instanciation de la DAO
		DAOPersonnel personnelDAO = DAOFactory.getDAOPersonnel();

		DAOClient clientDAO = DAOFactory.getDAOClient();

		DAOAnimal animalDAO = DAOFactory.getDAOAnimal();

		// creer un nouveau personnel
		// Personnel p1 = new Personnel( "Antoinette", "Marie", "946575",
		// "vet",false);
		// Personnel p2 = new Personnel( "ezaez","frgr", "12o34", "vet",false);
		// Personnel p3 = new Personnel( "eoz","frgr", "12o34", "vet",false);
		// Personnel p4 = new Personnel( "azade","foorgr", "12o34",
		// "vet",false);
		// Personnel p5 = new Personnel( "ez","frgr", "12o34", "vet",false);
		// personnelDAO.insert(p1);
		// personnelDAO.insert(p2);
		// personnelDAO.insert(p3);
		// personnelDAO.insert(p4);
		// personnelDAO.insert(p5);

		// selection de tout le personnel
		// List<Personnel> allPersonnel = personnelDAO.selectAll();
		// System.out.println("Selection de tous le personnel : " +
		// allPersonnel.toString());

		// selection de tous les clients
		// List<Client> allClient = clientDAO.selectAll();
		// System.out.println("Selection de tous les clients : " +
		// allClient.toString());

		// System.out.println("Suppression de l'article : " + p1.toString());
		// personnelDAO.supprimer(p1.getCodePers());
		// allPersonnel = personnelDAO.selectAll();

		// System.out.println("---------------------------------------------------------------");
		// System.out.println("Liste des articles après suppression : ");
		// StringBuffer sb = new StringBuffer();
		// for (Personnel pers : allPersonnel) {
		// sb.append("Membre du personnel [id = ");
		// sb.append(pers.getCodePers());
		// sb.append(", nom = ");
		// sb.append(pers.getNom());
		// sb.append(", prenom = ");
		// sb.append(pers.getPrenom()).append("]\n");
		// }
		// System.out.println(sb.toString());
		// System.out.println("---------------------------------------------------------------");

		// mise a jour personnel
		// personnelDAO.reinitialiserPersonnel(p1, "nouveau");
		// System.out.println(p1);

		// ajouter un client
		// Client c1 = new Client("test", "alex", "6 chemin du calvaire",
		// "batiment 45 app 12", "84230", "Random",
		// "0658789512", "toutrisque", "all@fef.fr", "", false);
		// clientDAO.insert(c1);

		// System.out.println("Client avant modification : " + c1.toString());
		// c1.setAdresse1("nouveau");
		// c1.setAdresse2("nouveau 2");
		// c1.setPrenomClient("AlainNouveau");
		// c1.setNomClient("nouveauNom");
		// clientDAO.update(c1);
		// System.out.println("Client apres modification : " + c1.toString());
		//
		// clientDAO.rechercherClient("po");
		//
		// System.out.println(clientDAO.rechercherClient("po"));

		// List<String> listeEspece = new ArrayList<String>();
		// listeEspece = animalDAO.getEspeceList();
		// System.out.println(listeEspece);
		//
		// List<String> listeRace = new ArrayList<String>();
		// listeRace = animalDAO.getRaceList();
		// System.out.println(listeRace);

		//Cr�ation d'animaux
		Animal a1 = new Animal("Bill", 'H', "Rouge", "chien", "Golden retriever", 1, "", "");
		Animal a2 = new Animal("Azra�l", 'F', "Brun", "chat", "MaineCoon", 1, "", "");
		 Animal a3 = new Animal("Willy", 'H', "Bleu", "cheval", "Poney", 1, "", "");
		
		 //Insert d'animal dans la base
		 animalDAO.insert(a1);
		 animalDAO.insert(a2);
		 animalDAO.insert(a3);
		
		// //Select All des animaux
		 animalDAO.selectbyID(1);

		// //Mise en archive d'un animal
		 animalDAO.supprimerViaCodeClient(1, 2);

		// Modification des donn�es d'un animal
		//animalDAO.modifier("Azra�l", 'F', "Marron", "De Goutti�re", "Chat", "14FB57", "Traitement contre l'anxi�t�", 3);

		System.out.println(animalDAO.selectAllSelonIDClient(1));
		String role = personnelDAO.selectbyMDP("Albert", "845364");
		System.out.println(role);
	}
}