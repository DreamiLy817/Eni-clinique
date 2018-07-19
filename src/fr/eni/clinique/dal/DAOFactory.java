package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.jdbc.AnimalDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;

public class DAOFactory {
	public static DAO<Personnel> getPersonnelDAO() {
		DAO<Personnel> personnelDAO = new PersonnelDAOJdbcImpl();
		return personnelDAO;
	}
	
	public static DAOPersonnel getDAOPersonnel() {
		DAOPersonnel personnelDAO = new PersonnelDAOJdbcImpl();
		return personnelDAO;
	}

	public static DAO<Client> getClientDAO() {
		DAO<Client> clientDAO = new ClientDAOJdbcImpl();
		return clientDAO;
	}


	public static DAO<Animal> getAnimalDAO() {
		DAO<Animal> animalDAO = new AnimalDAOJdbcImpl();
		return animalDAO;
	}

	public static DAOClient getDAOClient() {
		DAOClient clientDAO = new ClientDAOJdbcImpl();
		return clientDAO;
	}


}
