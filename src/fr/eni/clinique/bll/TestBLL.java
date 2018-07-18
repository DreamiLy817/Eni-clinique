package fr.eni.clinique.bll;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOPersonnel;
import fr.eni.clinique.dal.DAOFactory;

public class TestBLL {
	static String nom = "ezaez";
	static String pass = "12o34";
	static Boolean access;
	
	public static void main(String[] args) throws BLLException {
		LoginMger login = LoginMger.getInstance();
		DAOPersonnel loginDAO = DAOFactory.getDAOPersonnel();
		try {
			boolean connexionEtat = loginDAO.selectbyMDP(nom, pass);
			if (connexionEtat == true) {
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
