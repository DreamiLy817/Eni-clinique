package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAO;
import fr.eni.clinique.dal.DAOAnimal;

public class AnimalDAOJdbcImpl implements DAOAnimal {
	private static final String sqlSupprAnimal = "UPDATE Animaux SET Archive= ? WHERE CodeClient= ? and CodeAnimal= ?";
	private static final String sqlArchivToutAnimaux = "UPDATE Animaux SET Archive = ? WHERE CodeClient = ?";
	private static final String sqlInsertAnimal = "INSERT INTO Animaux (NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String sqlSelectAllAnimals = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE CodeClient = ?";
	private static final String sqlModifAnimal = "UPDATE Animaux SET NomAnimal=?, Sexe=?, Couleur=?, Race=?, Espece=?, Tatouage=?, Antecedents=? FROM Animaux WHERE CodeAnimal = ?";
	private static final String sqlSelectRace = "SELECT DISTINCT Race FROM Races WHERE Espece=?";
	private static final String sqlSelectEspece = "SELECT DISTINCT Espece FROM Races";
	private static final String sqlSelectionByCodeAnimal = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE CodeAnimal = ?";
	
	@Override
	public Animal selectbyID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Fonction a charge d'inserer un nouvel animal dans la BDD {@inheritedDoc}
	 * 
	 * @see fr.eni.clinique.dal.DAO#insert(java.lang.Object)
	 */
	@Override
	public void insert(Animal ani) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsertAnimal, Statement.RETURN_GENERATED_KEYS);

			String nomAnimal = ani.getNomAnimal();
			char sexe = ani.getSexe();
			String couleur = ani.getCouleur();
			String race = ani.getRace();
			String espece = ani.getEspece();
			int codeClient = ani.getCodeClient();
			String tatouage = ani.getTatouage();
			String antecedents = ani.getAntecedents();
			Boolean archiveAni = ani.isArchive();

			rqt.setString(1, nomAnimal);
			rqt.setString(2, String.valueOf(sexe));
			rqt.setString(3, couleur);
			rqt.setString(4, race);
			rqt.setString(5, espece);
			rqt.setInt(6, codeClient);
			rqt.setString(7, tatouage);
			rqt.setString(8, antecedents);
			rqt.setBoolean(9, archiveAni);

			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				// recuperation du tampon
				rs = rqt.getGeneratedKeys();
				// je vais sur le premier enregistrement s'il existe
				if (rs.next()) {
					ani.setCodeAnimal(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			// TO DO DALException
			throw new DALException("Echec de la cr�ation d'un animal - ", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				// throw new DALException("close failed " , e);
				e.printStackTrace();
			}
		}

	}

	/**
	 * Fonction en charge de retourner une liste de tout les animaux appartenant
	 * au client
	 * 
	 * @param id
	 *            - Le code client de la personne dont on veut tout les animaux
	 * @return une liste d'animaux
	 * @throws DALException
	 */
	public List<Animal> selectAllSelonIDClient(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<Animal> listeAnimaux = new ArrayList<Animal>();
		Animal animal = null;
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectAllAnimals);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
			while (rs.next()) {
				animal = new Animal(rs.getInt("CodeAnimal"), rs.getString("NomAnimal"), rs.getString("Sexe").charAt(0),
						rs.getString("Couleur"), rs.getString("Race"), rs.getString("Espece"),
						rs.getString("Tatouage"));
				listeAnimaux.add(animal);
			}
		} catch (SQLException e) {
			throw new DALException("Echec de la recuperation de la liste d'animaux - ", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed ", e);
			}
		}
		return listeAnimaux;
	}

	@Override
	public Animal update(Animal ani) throws DALException {
		return null;
	}

	@Override
	public void supprimer(Integer id) throws DALException {

	}

	@Override
	public List<Animal> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Fonction dont la charge est de modifier les donnees d'un animal
	 * {@inheritedDoc}
	 * 
	 * @see fr.eni.clinique.dal.DAOAnimal#modifier(java.lang.String, char,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, int)
	 */
	@Override
	public void modifier(String nom, char sexe, String couleur, String race, String espece, String tatouage,
			String antecedents, int codeAnimal) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlModifAnimal);
			rqt.setString(1, nom);
			rqt.setString(2, String.valueOf(sexe));
			rqt.setString(3, couleur);
			rqt.setString(4, race);
			rqt.setString(5, espece);
			rqt.setString(6, tatouage);
			rqt.setString(7, antecedents);
			rqt.setInt(8, codeAnimal);
			rqt.executeUpdate();
		} catch (SQLException e) {
			// TO DO DALException
			throw new DALException("Archivage echoue - ", e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed ", e);
			}
		}
	}

	/**
	 * Fonction dont la charge est d'archiver un animal {@inheritedDoc}
	 * 
	 * @see fr.eni.clinique.dal.DAOAnimal#supprimerViaCodeClient(int, int)
	 */
	@Override
	public void supprimerViaCodeClient(int codeClient, int codeAnimal) throws DALException {
		// TODO Auto-generated method stub
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSupprAnimal);
			rqt.setBoolean(1, true);
			rqt.setInt(2, codeClient);
			rqt.setInt(3, codeAnimal);
			rqt.executeUpdate();
		} catch (SQLException e) {
			// TO DO DALException
			throw new DALException("Archivage echoue - ", e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed ", e);
			}
		}
	}

	/**
	 * Fonction pour recuperer une liste de races de la BDD {@inheritedDoc}
	 * 
	 * @see fr.eni.clinique.dal.DAOAnimal#getRaceList()
	 */
	@Override
	public List<String> getRaceList(String espece) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<String> listeRace = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectRace);
			rqt.setString(1, espece);
			rs = rqt.executeQuery();
			listeRace = new ArrayList<String>();
			while (rs.next()) {
				String race = rs.getString("race");
				listeRace.add(race);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeRace;
	}

	/**
	 * Fonction pour recuperer une liste d'especes de la BDD {@inheritedDoc}
	 * 
	 * @see fr.eni.clinique.dal.DAOAnimal#getEspeceList()
	 */
	@Override
	public List<String> getEspeceList() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<String> listeEspece = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectEspece);
			listeEspece = new ArrayList<String>();
			while (rs.next()) {
				String espece = rs.getString("espece");
				listeEspece.add(espece);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeEspece;
	}

	/**
	 * {@inheritedDoc}
	 * @see fr.eni.clinique.dal.DAOAnimal#archivageAnimauxViaCodeClient(int)
	 */
	@Override
	public void archivageAnimauxViaCodeClient(int codeClient) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlArchivToutAnimaux);
			rqt.setBoolean(1, true);
			rqt.setInt(2, codeClient);
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Archivage echoue - ", e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed ", e);
			}
		}
	}
	
	@Override
	public Animal selectionByCodeAnimal(Integer codeAnimal) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Animal animal = null;
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectionByCodeAnimal);
			rqt.setInt(1, codeAnimal);
			rs = rqt.executeQuery();
			
			while (rs.next()) {
				animal = new Animal(rs.getInt("CodeAnimal"),
						rs.getString("NomAnimal"),
						rs.getString("Sexe").charAt(0),
						rs.getString("Couleur"),
						rs.getString("Race"),
						rs.getString("Espece"),
						rs.getString("Tatouage"));
			}
		} catch (SQLException e) {
			throw new DALException("Echec de la recuperation de la liste d'animaux - ", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed ", e);
			}
		}
		return animal;
	}
}
