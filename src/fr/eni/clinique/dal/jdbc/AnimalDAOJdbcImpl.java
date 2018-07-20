package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAO;

public class AnimalDAOJdbcImpl implements DAO<Animal> {
	private static final String sqlSupprAnimal = "UPDATE Animaux SET Archive= ? WHERE CodePers= ?";
	private static final String sqlInsertAnimal = "INSERT INTO Animaux (NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String sqlSelectAllAnimals = "SELECT NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE CodeClient = ?";

	@Override
	public Animal selectbyID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

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
			throw new DALException("Echec de la création d'un animal - ", e);
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

	public List<Animal> selectAllSelonIDClient(int id) throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Animal> listeAnimaux = new ArrayList<Animal>();

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAllAnimals);
			Animal animal = null;

			while (rs.next()) {
				animal = new Animal(rs.getInt("CodeAnimal"), rs.getString("NomAnimal"), rs.getString("Sexe").charAt(0),
						rs.getString("Couleur"), rs.getString("Race"), rs.getString("Espece"),
						rs.getString("Tatouage"));
				listeAnimaux.add(animal);
			}
		} catch (SQLException e) {
			throw new DALException("Echec de la récupération de la liste d'animaux - ", e);
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
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSupprAnimal);
			rqt.setBoolean(1, true);
			rqt.setInt(2, id);
			rqt.executeUpdate();
		} catch (SQLException e) {
			// TO DO DALException
			throw new DALException("Archivage échoué - ", e);
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
	public List<Animal> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
