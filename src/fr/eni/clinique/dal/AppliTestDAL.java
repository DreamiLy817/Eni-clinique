package fr.eni.clinique.dal;


import java.util.List;

import fr.eni.clinique.bo.Personnel;

public class AppliTestDAL {

	public static void main(String[] args) throws DALException {
		
		// déclaration et instanciation de la DAO
		//PersonnelDAO personnelDAO = DAOFactory.getPersonnelDAO();
		DAO<Personnel> personnelDAO = DAOFactory.getPersonnelDAO();
				
		// creer un nouveau personnel 
		Personnel p1 = new Personnel( "vfrh", "1234", "vet",false);
		Personnel p2 = new Personnel( "ezaez", "12o34", "vet",false);
		personnelDAO.insert(p1);
		personnelDAO.insert(p2);
		
		//selection de tout le personnel
		List<Personnel> allPersonnel = personnelDAO.selectAll();
		System.out.println("Selection de tous le personnel  : " + allPersonnel.toString() );
		
		System.out.println("Suppression de l'article  : " + p1.toString());
		personnelDAO.supprimer(p1.getCodePers());
		allPersonnel = personnelDAO.selectAll();
		
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("Liste des articles aprÃ¨s suppression : "  );
		StringBuffer sb = new StringBuffer();
		for(Personnel pers: allPersonnel){
			sb.append("Membre du personnel   [id = ");
			sb.append(pers.getCodePers());
			sb.append(", nom = ");
			sb.append(pers.getNom()).append("]\n");
		}
		System.out.println(sb.toString());
		System.out.println("---------------------------------------------------------------");

		
	
	}

}