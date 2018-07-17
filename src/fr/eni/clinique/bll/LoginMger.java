package fr.eni.clinique.bll;

import fr.eni.clinique.dal.PersonnelDAO;
import fr.eni.clinique.dal.PersonnelDAOFactory;


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
		personnelDAO = PersonnelDAOFactory.getPersonnelDAO();
	}

	private void getAccess(String saisieLogin, String saisieMotpasse) {
		
	}
	//Ha
	//Ha
	//Ha
}
