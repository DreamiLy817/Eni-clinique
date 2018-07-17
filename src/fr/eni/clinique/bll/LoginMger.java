package fr.eni.clinique.bll;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOAuthentification;
import fr.eni.clinique.dal.DAOFactory;


public class LoginMger {
	private static LoginMger instance;
	private static DAOAuthentification personnelDAO;
	public static synchronized LoginMger getInstance(){
		if (instance == null) {
			instance = new LoginMger();	
		}
		return instance;
	}
	
	private LoginMger(){
		personnelDAO = DAOFactory.getDAOAuthentification();
	}

	public Boolean getAccess(String saisieLogin, String saisieMotpasse) {
		Boolean access = null;
		String pass = null;
		
		try {
			pass = personnelDAO.selectbyMDP(saisieLogin).toString();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (saisieLogin == pass) {
			access = true;
		}
		
		return access;
	}
}
