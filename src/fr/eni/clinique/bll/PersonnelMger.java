/**
 * 
 */
package fr.eni.clinique.bll;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAO;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.DAOPersonnel;

/**
 * Classe en charge de faire la jonction entre la DAL et l'IHM
 * 
 * @author fbaconnais2018
 * @date 23 juil. 2018 - @time 16:13:55 Clinique - Version 1.0
 */
public class PersonnelMger {
	private static PersonnelMger instance;
	private static DAOPersonnel personnelDAO;
	private static DAO<Personnel> DAOpersonnel;

	public static synchronized PersonnelMger getInstance() {
		if (instance == null) {
			instance = new PersonnelMger();
		}
		return instance;
	}

	private PersonnelMger() {
		personnelDAO = DAOFactory.getDAOPersonnel();
	}

	public void archivagePersonnel(int codeClient) throws BLLException {
		try {
			DAOpersonnel.supprimer(codeClient);
		} catch (DALException e) {
			throw new BLLException("Erreur d'archivage de l'employ� s�lectionn� - " + e);
		}
	}

	public void ajoutPersonnel(Personnel p) throws BLLException {
		try {
			DAOpersonnel.insert(p);
		} catch (DALException e) {
			throw new BLLException("Erreur lors de l'ajout d'un nouvel employ� - " + e);
		}
	}

	public void changementPasse(Personnel personne, String motDePasse) throws BLLException {
		try {
			personnelDAO.reinitialiserPersonnel(personne, motDePasse);
		} catch (DALException e) {
			throw new BLLException("Erreur lors du changement de mot de passe - " + e);
		}

	}
	
	public void affichagePersonnel() throws BLLException {
		try {
			personnelDAO.selectAllArchi();
		} catch (DALException e) {
			throw new BLLException("Erreur lors du chargement de la liste des employ�s - " + e);
		}
	}
	
	public void selectByNom(String nom) throws BLLException {
		try {
			personnelDAO.selectbyNom(nom);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
