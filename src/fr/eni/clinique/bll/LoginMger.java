package fr.eni.clinique.bll;

import fr.eni.clinique.dal.DAOPersonnel;
import fr.eni.clinique.dal.DAOFactory;


public class LoginMger {
	
	private static LoginMger instance;
	private static DAOPersonnel personnelDAO;
	
	public static synchronized LoginMger getInstance(){
		if (instance == null) {
			instance = new LoginMger();	
		}
		return instance;
	}
	
	private LoginMger(){
		personnelDAO = DAOFactory.getDAOPersonnel();
	}
}
