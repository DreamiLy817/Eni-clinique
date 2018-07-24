package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOAnimal;
import fr.eni.clinique.dal.DAOFactory;

/**
 * Classe en charge de 
 * @author fbaconnais2018
 * @date 24 juil. 2018 - @time 09:09:30
 * Clinique - Version 1.0
 */
public class AnimalMger {
	private static AnimalMger instance;
	private static DAOAnimal animalDAO;
	private List<Animal> listeAnimaux = new ArrayList<Animal>();
	private List<String> listeRaces = new ArrayList<String>();
	private List<String> listeEspeces = new ArrayList<String>();
	
	public static synchronized AnimalMger getInstance() {
		if (instance == null) {
			instance = new AnimalMger();
		}
		return instance;
	}
	
	private AnimalMger() {
		animalDAO = DAOFactory.getDAOAnimal();
	}
	
	public void ajoutAnimal(Animal ani) throws BLLException {
		try {
			animalDAO.insert(ani);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException("Erreur lors de l'ajout d'un nouvel animal - " + e);
		}
	}
	
	public List<Animal> listeAnimauxParClient(int codeClient) throws BLLException {
		try {
			listeAnimaux = animalDAO.selectAllSelonIDClient(codeClient);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException("Erreur lors de la recherche des animaux d'un client - " + e);
		}
		return listeAnimaux;
	}
	
	public void modifierAnimal(String nom, char sexe, String couleur, String race, String espece, String tatouage,
			String antecedents, int codeAnimal) throws BLLException {
		try {
			animalDAO.modifier(nom, sexe, couleur, race, espece, tatouage, antecedents, codeAnimal);
		} catch (DALException e) {
			throw new BLLException("Erreur lors de la modification des infos d'un animal - " + e);
		}
	}
	
	public void archivageViaCodeClient(int codeClient, int codeAnimal) throws BLLException {
		try {
			animalDAO.supprimerViaCodeClient(codeClient, codeAnimal);
		} catch (DALException e) {
			throw new BLLException("Erreur lors de l'archivage d'un animal - " + e);
		}
	}
	
	public List<String> recupListeRace() throws BLLException {
		try {
			listeRaces = animalDAO.getRaceList();
		} catch (DALException e) {
			throw new BLLException("Erreur lors de l'obtention de la liste des races - " + e);
		}
		
		return listeRaces;
	}
	
	public List<String> recupListeEspece() throws BLLException {
		try {
			listeEspeces = animalDAO.getEspeceList();
		} catch (DALException e) {
			throw new BLLException("Erreur lors de l'obtention de la liste des espèces - " + e);
		}

		return listeEspeces;
	}
}
