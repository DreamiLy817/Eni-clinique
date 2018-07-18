package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAO;

public class ClientDAOJdbcImpl implements DAO<Client> {
	
	private static final String sqlSelectAllInfosPersonnel = "SELECT CodePers,Nom ,Prenom, MotPasse ,Role FROM Personnels";
	private static final String sqlInsertClient= "INSERT INTO Client ( nom,Prenom, MotPasse, role,archive) values(?,?,?,?,?);";
	private static final String sqlSuppressionPersonnel = "UPDATE Personnels SET Archive= ? WHERE Nom= ?";
	private static final String sqlSelectByMDP = "SELECT role FROM Personnels WHERE Nom=? AND MotPasse=?";
	private static final String sqlMiseAJourMDP = "update Personnels set MotPasse=? where Nom=?";

	@Override
	public Client selectbyID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Client client) throws DALException {
//		Connection cnx = null;
//		PreparedStatement rqt = null;
//		ResultSet rs = null;
//
//		try {
//			cnx = JdbcTools.getConnection();
//			rqt = cnx.prepareStatement(sqlInsertClient,Statement.RETURN_GENERATED_KEYS);
//	 
//			String nom = p.getNom();
//			String prenom = p.getPrenom();
//			String motpasse = p.getMotPasse();
//			String role = p.getRole();
//			Boolean archive = p.getArchive();
//			
//	
//			rqt.setString(1, nom);
//			rqt.setString(2, prenom);
//			rqt.setString(3, motpasse);
//			rqt.setString(4, role);
//			rqt.setBoolean(5, archive);
//			
//		
//			int nbRows = rqt.executeUpdate();
//			if(nbRows == 1) {
//				// recuperation du tampon
//				 rs = rqt.getGeneratedKeys();
//				// je vais sur le premier enregistrement s'il existe
//				if(rs.next()) {
//					p.setCodePers(rs.getInt(1));
//				}
//			}
//		} catch (SQLException e) {
//			//TO DO DALException
//			throw new DALException("insertPersonnel failed - " , e);
//		} finally {
//			try {
//				if (rs != null){
//				rs.close();
//				}
//				if (rqt != null){
//					rqt.close();
//				}
//				if(cnx!=null){
//					cnx.close();
//				}
//			} catch (SQLException e) {
//				//throw new DALException("close failed " , e);
//				e.printStackTrace();
//			}
//		}	
	}

	@Override
	public List<Client> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client update(Client obj) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(Integer id) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
