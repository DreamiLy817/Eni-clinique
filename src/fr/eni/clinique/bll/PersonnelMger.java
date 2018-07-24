/**
 * 
 */
package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DALException;
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
	int id = 0;
	private List<Personnel> listePersonnel = new ArrayList<Personnel>();
	private Personnel personnel;
	
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
			personnelDAO.supprimer(codeClient);
		} catch (DALException e) {
			throw new BLLException("Erreur d'archivage de l'employé sélectionné - " + e);
		}
	}

	public void ajoutPersonnel(Personnel p) throws BLLException {
		try {
			personnelDAO.insert(p);
		} catch (DALException e) {
			throw new BLLException("Erreur lors de l'ajout d'un nouvel employé - " + e);
		}
	}

	public void changementPasse(Personnel personne, String motDePasse) throws BLLException {
		try {
			personnelDAO.reinitialiserPersonnel(personne, motDePasse);
		} catch (DALException e) {
			throw new BLLException("Erreur lors du changement de mot de passe - " + e);
		}

	}
	
	public List<Personnel> affichagePersonnel() throws BLLException {
		try {
			listePersonnel = personnelDAO.selectAllArchi();
		} catch (DALException e) {
			throw new BLLException("Erreur lors du chargement de la liste des employés - " + e);
		}
		return listePersonnel;
	}
	
	public int selectNomID(String nom) throws BLLException {
		try {
			id = personnelDAO.selectbyNomGiveID(nom);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public Personnel selectNom(String nom) throws BLLException {
		try {
			personnel = personnelDAO.selectbyNom(nom);
		} catch (DALException e) {
			throw new BLLException("Erreur lors de la recherche d'employé par nom - " + e);
		}
		
		return personnel;
	}
}

