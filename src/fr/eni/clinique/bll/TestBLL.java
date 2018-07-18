package fr.eni.clinique.bll;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOAuthentification;
import fr.eni.clinique.dal.DAOFactory;

public class TestBLL {
	static String nom = "efrgomooommmrpb";
	static String pass = null;
	static Boolean access;
	
	public static void main(String[] args) throws BLLException {
		LoginMger login = LoginMger.getInstance();
		DAOAuthentification loginDAO = DAOFactory.getDAOAuthentification();
		try {
			pass = loginDAO.selectbyMDP(nom);
			access = login.getAccess(nom, "12o34");
			if (access) {
				System.out.println("Connexion acceptée!");
			}
			else {
				System.out.println("Connexion refusée!");
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
