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

//	Boolean getAccess(String saisieLogin, String saisieMotpasse) throws BLLException {
//		Boolean access = false;
//		String pass = null;
//		
//		try {
//			pass = personnelDAO.selectbyMDP(saisieLogin);
//			System.out.println(pass);
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return access;
//	}
}
