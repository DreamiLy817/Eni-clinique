package fr.eni.clinique.dal.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.PersonnelDAO;

public class PersonnelDAOJdbcImpl implements PersonnelDAO {
	
	private static final String sqlSelectAllInfosPersonnel = "SELECT CodePers,Nom ,MotPasse ,Role FROM Personnels";
	private static final String sqlInsertPersonnel = "INSERT INTO Personnels ( nom, prenom, role) values(?,?,?)";

	
	public List<Personnel> SelectAllInfosPersonnel() {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null; 
		List<Personnel> listePersonnel = new ArrayList<Personnel>();
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectAllInfosPersonnel);
			rs = rqt.executeQuery(sqlSelectAllInfosPersonnel);
			Personnel personne = null; 
			
			while(rs.next()) {
				personne = new Personnel(rs.getString("Nom"),
						rs.getString("MotPasse"),
						rs.getString("Role"));
			}
			listePersonnel.add(personne);
			
	
		} catch (SQLException e) {
			//TO DO DALException
			//throw new DALException("selectByMotCle failed - " , e);
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
			}
		}
		return listePersonnel;	
	}
	
	
	
	////
	public void insertPersonnel(Personnel p) {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsertPersonnel,Statement.RETURN_GENERATED_KEYS);
			Personnel personne = null; 
			
			String nom = p.getNom();
			String motpasse = p.getMotPasse();
			String role = p.getRole();
			
		
			rqt.setString(1, nom);
			rqt.setString(2, motpasse);
			rqt.setString(3, role);
			
		
			int nbRows = rqt.executeUpdate();
			if(nbRows == 1) {
				// recuperation du tampon
				 rs = rqt.getGeneratedKeys();
				// je vais sur le premier enregistrement s'il existe
				if(rs.next()) {
					// je récupere la colonne 1 du tampon
					int cle = rs.getInt(1);
					// j'affecte a mon article la cle generee 
					p.setCodePers(cle);
				}
			}
		} catch (SQLException e) {
			//TO DO DALException
			//throw new DALException("selectByMotCle failed - " , e);
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
			}
		}	
	}
}
