package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOAnimal;
import fr.eni.clinique.dal.DAOClient;
import fr.eni.clinique.dal.DAOFactory;

/**
 * Classe en charge de 
 * @author fbaconnais2018
 * @date 24 juil. 2018 - @time 08:28:05
 * Clinique - Version 1.0
 */
public class ClientMger {
	private static ClientMger instance;
	private DAOClient clientDAO;
	private DAOAnimal animalDAO;
	private List<Client> listeClients = new ArrayList<Client>();
	
	public static synchronized ClientMger getInstance() {
		if (instance == null) {
			instance = new ClientMger();
		}
		return instance;
	}
	
	private ClientMger() {
		clientDAO = DAOFactory.getDAOClient();
		animalDAO = DAOFactory.getDAOAnimal();
	}
	
	public void ajoutClient(Client cli) throws BLLException {
		try {
			clientDAO.insert(cli);
		} catch (DALException e) {
			throw new BLLException("Erreur lors de l'ajout d'un nouvel client - " + e);
		}
	}
	
	public List<Client> affichageClient()  throws BLLException {
		try {
			listeClients = clientDAO.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur lors de l'affichage des clients - " + e);
		}
		return listeClients;
	}
	
	public Client miseAJourClient(Client cli) throws BLLException {
		try {
			clientDAO.update(cli);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException("Erreur lors de la mise � jour d'un client - " + e);
		}
		return cli;
	}
	
	public void archivageClient(int codeClient) throws BLLException {
		try {
			clientDAO.supprimer(codeClient);
			animalDAO.archivageAnimauxViaCodeClient(codeClient);
		} catch (DALException e) {
			throw new BLLException("Erreur lors de l'archivage d'un client - " + e);	
		}
	}
	
	public void rechercheClient(String recherche) throws BLLException {
		try {
			clientDAO.rechercherClient(recherche);
		} catch (DALException e) {
			throw new BLLException("Erreur lors de la recherche d'un client - " + e);
		}
	}
}
