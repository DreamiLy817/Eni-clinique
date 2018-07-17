package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Login;
import fr.eni.clinique.dal.jdbc.LoginDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;

public class DAOFactory {
	public static PersonnelDAO getPersonnelDAO() {
		PersonnelDAO personnelDAO = new PersonnelDAOJdbcImpl();
		return personnelDAO;
	}

//	public static PersonnelDAOFactory getLoginDAO() {
//		DAO<Login> loginDAO = new LoginDAOJdbcImpl();
//		return loginDAO;
//	}

}
