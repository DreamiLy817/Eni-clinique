package fr.eni.clinique.dal;


import java.util.List;

import fr.eni.clinique.bo.Personnel;

public class AppliTestDAL {

	public static void main(String[] args) throws DALException {
		
		// déclaration et instanciation de la DAO
		DAOPersonnel personnelDAO2 = DAOFactory.getDAOPersonnel();
		DAO<Personnel> personnelDAO = DAOFactory.getPersonnelDAO();
				
		// creer un nouveau personnel 
		Personnel p1 = new Personnel( "o65769", "frgr", "1234", "vet",false);
		//Personnel p2 = new Personnel( "ezaez","frgr", "12o34", "vet",false);
		//Personnel p3 = new Personnel( "eoz","frgr", "12o34", "vet",false);
		//Personnel p4 = new Personnel( "azade","foorgr", "12o34", "vet",false);
		//Personnel p5 = new Personnel( "ez","frgr", "12o34", "vet",false);
		personnelDAO.insert(p1);
		//personnelDAO.insert(p2);
		//personnelDAO.insert(p3);
		//personnelDAO.insert(p4);
		//personnelDAO.insert(p5);

		//selection de tout le personnel
		List<Personnel> allPersonnel = personnelDAO.selectAll();
		System.out.println("Selection de tous le personnel  : " + allPersonnel.toString() );
		
		System.out.println("Suppression de l'article  : " + p1.toString());
		//personnelDAO.supprimer(p1.getCodePers());
		allPersonnel = personnelDAO.selectAll();
		
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("Liste des articles aprÃ¨s suppression : "  );
		StringBuffer sb = new StringBuffer();
		for(Personnel pers: allPersonnel){
			sb.append("Membre du personnel   [id = ");
			sb.append(pers.getCodePers());
			sb.append(", nom = ");
			sb.append(pers.getNom());
			sb.append(", prenom = ");
			sb.append(pers.getPrenom()).append("]\n");
		}
		System.out.println(sb.toString());
		System.out.println("---------------------------------------------------------------");

		// mise a jour personnel 
		personnelDAO2.reinitialiserPersonnel(p1, "nouveau");
		System.out.println(p1);
	
	}

}