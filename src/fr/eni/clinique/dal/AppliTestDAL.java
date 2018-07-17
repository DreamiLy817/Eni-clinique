package fr.eni.clinique.dal;


import java.util.List;

import fr.eni.clinique.bo.Personnel;

public class AppliTestDAL {

	public static void main(String[] args) {
		
		// déclaration et instanciation de la DAO
		PersonnelDAO personnelDAO = DAOFactory.getPersonnelDAO();
		
		// creer un nouveau personnel 
		//Personnel p1 = new Personnel( "azeppr", "1234", "vet",false);
		//Personnel p2 = new Personnel( "efrgommmrb", "12o34", "vet",false);
		//personnelDAO.insertPersonnel(p1);
		//personnelDAO.insertPersonnel(p2);
		
		
		//selection de tout le personnel
		List<Personnel> allPersonnel = personnelDAO.SelectAllInfosPersonnel();
		System.out.println("Selection de tous le personnel  : " + allPersonnel.toString() );
	
	}

}