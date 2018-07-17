package fr.eni.clinique.dal;

import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;

public class PersonnelDAOFactory {
	public static PersonnelDAO getPersonnelDAO() {
		PersonnelDAO personnelDAO = new PersonnelDAOJdbcImpl();
		return personnelDAO;
	}

}
