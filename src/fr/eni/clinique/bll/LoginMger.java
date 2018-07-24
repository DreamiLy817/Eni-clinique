package fr.eni.clinique.bll;

import fr.eni.clinique.dal.DAOPersonnel;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;


public class LoginMger {
	
	private static LoginMger instance;
	private static DAOPersonnel personnelDAO;
	private String role;
	
	public static synchronized LoginMger getInstance(){
		if (instance == null) {
			instance = new LoginMger();	
		}
		return instance;
	}
	
	private LoginMger(){
		personnelDAO = DAOFactory.getDAOPersonnel();
	}
	
	public String connection(String nom, String motDePasse) throws BLLException {
		try {
			role = personnelDAO.selectbyMDP(nom, motDePasse);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException("Echec de la tentative de connexion - "+e );
		}
		return role;
	}
	
}
