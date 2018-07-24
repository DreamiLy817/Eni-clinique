package fr.eni.clinique.dal.jdbc;

import java.sql.Statement;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAO;
import fr.eni.clinique.dal.DAOPersonnel;


public class PersonnelDAOJdbcImpl implements DAOPersonnel {
	
	private static final String sqlSelectAllInfosPersonnel = "SELECT CodePers,Nom ,Prenom, MotPasse ,Role FROM Personnels";
	private static final String sqlSelectAllSansArchivage = "SELECT CodePers,Nom ,Prenom, MotPasse ,Role FROM Personnels WHERE Archive=?";
	private static final String sqlInsertPersonnel = "INSERT INTO Personnels ( nom,Prenom, MotPasse, role,archive) values(?,?,?,?,?);";
	private static final String sqlSuppressionPersonnel = "UPDATE Personnels SET Archive= ? WHERE CodePers= ?";
	private static final String sqlSelectByMDP = "SELECT role FROM Personnels WHERE Nom=? AND MotPasse=?";
	private static final String sqlSelectByNom = "SELECT CodePers,Nom ,Prenom, MotPasse ,Role FROM Personnels WHERE Nom= ?";
	private static final String sqlSelectByID = "SELECT CodePers FROM Personnels WHERE Nom= ?";
	private static final String sqlMiseAJourMDP = "update Personnels set MotPasse=? where Nom=?";
	
	public List<Personnel> selectAll() throws DALException{
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
						rs.getString("Prenom"),
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
	@Override
	public void insert(Personnel p) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsertPersonnel,Statement.RETURN_GENERATED_KEYS);
	 
			String nom = p.getNom();
			String prenom = p.getPrenom();
			String motpasse = p.getMotPasse();
			String role = p.getRole();
			Boolean archive = p.getArchive();
			
	
			rqt.setString(1, nom);
			rqt.setString(2, prenom);
			rqt.setString(3, motpasse);
			rqt.setString(4, role);
			rqt.setBoolean(5, archive);
			
		
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

	@Override
	public Personnel selectbyID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	// Réinitialiser le mot de passe de l'employé
	@Override
	public void reinitialiserPersonnel(Personnel personne, String mdp) throws DALException {
	Connection cnx = null;
		PreparedStatement rqt = null;
		try {
		cnx = JdbcTools.getConnection();
		rqt = cnx.prepareStatement(sqlMiseAJourMDP);
			rqt.setString(1, mdp);
			rqt.setString(2, personne.getNom());
			rqt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Update personnel failed - " + personne , e);
		} finally {
			try {
				if (rqt != null){
					rqt.close();
				}
				if(cnx !=null){
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
}

	// suppression d'un membre du personnel
	// TODO - Vérif RDV pour vet avant archivage
	@Override
	public void supprimer(Integer id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSuppressionPersonnel);
			rqt.setBoolean(1, true);
			rqt.setInt(2, id);
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

	@Override
	public Boolean selectbyMDP(String nom,String motDePasse)throws DALException{
				Connection cnx = null;
				PreparedStatement rqt = null;
				ResultSet rs = null;
				boolean ok = false;
	
				try {
					cnx = JdbcTools.getConnection();
					rqt = cnx.prepareStatement(sqlSelectByMDP);
					rqt.setString(1, nom);
					rqt.setString(2, motDePasse);
					
					rs = rqt.executeQuery();
					ok = rs.next();
					} catch (SQLException e) {
						throw new DALException("selectByMdp failed - id = " + nom  , e);
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
							e.printStackTrace();
						}
					}
				
			return ok;
	}

	@Override
	public Personnel update(Personnel obj) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personnel selectbyNom(String nom) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Personnel ok = new Personnel();

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByNom);
			rqt.setString(1, nom);
			
			rs = rqt.executeQuery();
			if (rs.next()) {
				ok.setCodePers(rs.getInt("CodePers"));
				ok.setNom(rs.getString("Nom"));
				ok.setPrenom(rs.getString("Prenom"));
				ok.setMotPasse(rs.getString("MotPasse"));
				ok.setRole(rs.getString("Role"));
			}
			} catch (SQLException e) {
				throw new DALException("selectByNom failed - id = " + nom  , e);
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
					e.printStackTrace();
				}
			}
		
	return ok;
	
	}

	@Override
	public int selectbyNomGiveID(String nom) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		int ok = 0;

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByNom);
			rqt.setString(1, nom);
			
			rs = rqt.executeQuery();
			if (rs.next()) {
				ok = rs.getInt("CodePers");
				
			}
			} catch (SQLException e) {
				throw new DALException("selectByNom failed - id = " + nom  , e);
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
					e.printStackTrace();
				}
			}
		
	return ok;
	}

	@Override
	public List<Personnel> selectAllArchi() throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
			List<Personnel> listePersonnel = new ArrayList<Personnel>();
			
			try {
				cnx = JdbcTools.getConnection();
				rqt = cnx.prepareStatement(sqlSelectAllSansArchivage);
				rqt.setBoolean(1, false);
				rs = rqt.executeQuery();
				Personnel personne = null; 
				
				while(rs.next()) {
					personne = new Personnel(rs.getInt("codePers"),
							rs.getString("Nom"),
							rs.getString("Prenom"),
							rs.getString("MotPasse"),
							rs.getString("Role"));
					listePersonnel.add(personne);
				}
			} catch (SQLException e) {
				throw new DALException("SelectAllSansArchivage failed - " , e);
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
}
