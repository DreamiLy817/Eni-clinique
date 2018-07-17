package fr.eni.clinique.dal.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.PersonnelDAO;

public class PersonnelDAOJdbcImpl implements PersonnelDAO {
	
	private static final String sqlSelectAllInfosPersonnel = "SELECT CodePers,Nom ,MotPasse ,Role FROM Personnels";
	private static final String sqlInsertPersonnel = "INSERT INTO Personnels ( nom, MotPasse, role,archive) values(?,?,?,?);";
	private static final String sqlSuppressionPersonnel = "DELETE FROM Personnels WHERE CodePers=?";

	
	public List<Personnel> SelectAllInfosPersonnel() throws DALException{
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null; 
		List<Personnel> listePersonnel = new ArrayList<Personnel>();
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAllInfosPersonnel);
			Personnel personne = null; 
			
			while(rs.next()) {
				personne = new Personnel(rs.getInt("codePers"),
						rs.getString("Nom"),
						rs.getString("MotPasse"),
						rs.getString("Role"));
				listePersonnel.add(personne);
			}
		} catch (SQLException e) {
			throw new DALException("selectAllInfosPersonnel failed - " , e);
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed " , e);
			}
		}
		return listePersonnel;	
	}
	
	
	
	//// insertion d'une personne du personnel
	public void insertPersonnel(Personnel p) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsertPersonnel,Statement.RETURN_GENERATED_KEYS);
	 
			String nom = p.getNom();
			String motpasse = p.getMotPasse();
			String role = p.getRole();
			Boolean archive = p.getArchive();
			
	
			rqt.setString(1, nom);
			rqt.setString(2, motpasse);
			rqt.setString(3, role);
			rqt.setBoolean(4, archive);
			
		
			int nbRows = rqt.executeUpdate();
			if(nbRows == 1) {
				// recuperation du tampon
				 rs = rqt.getGeneratedKeys();
				// je vais sur le premier enregistrement s'il existe
				if(rs.next()) {
					p.setCodePers(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			//TO DO DALException
			throw new DALException("insertPersonnel failed - " , e);
		} finally {
			try {
				if (rs != null){
				rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				//throw new DALException("close failed " , e);
				e.printStackTrace();
			}
		}	
	}
	
	// suppression d'une personne du personnel
	public void suppressionPersonnel(int CodePers) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSuppressionPersonnel);
			rqt.setInt(1, CodePers);
			rqt.executeUpdate();	
		} catch (SQLException e) {
			//TO DO DALException
			throw new DALException("suppressionPersonnel failed - " , e);
		} finally {
			try {
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed " , e);
			}
		}	
	}
	
}
