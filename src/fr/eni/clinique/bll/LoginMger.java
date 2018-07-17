package fr.eni.clinique.bll;

import fr.eni.clinique.dal.PersonnelDAO;
import fr.eni.clinique.dal.DAOFactory;


public class LoginMger {
	private static LoginMger instance;
	private static PersonnelDAO personnelDAO;
	
	public static synchronized LoginMger getInstance(){
		if (instance == null) {
			instance = new LoginMger();	
		}
		return instance;
	}
	
	private LoginMger(){
		personnelDAO = DAOFactory.getPersonnelDAO();
	}

	private Boolean getAccess(String saisieLogin, String saisieMotpasse) {
		Boolean access = null;
		String pass = null;
		
		
		return access;
	}
}
