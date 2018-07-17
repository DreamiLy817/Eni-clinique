package fr.eni.clinique.dal;


import java.util.List;

import fr.eni.clinique.bo.Personnel;

public class AppliTestDAL {

	public static void main(String[] args) {
		
		// déclaration et instanciation de la DAO
		PersonnelDAO personnelDAO = PersonnelDAOFactory.getPersonnelDAO();
		
		// creer un nouveau personnel 
		Personnel p1 = new Personnel( "Ally", "1234", "vet");
		personnelDAO.insertPersonnel(p1);
		


	}

}