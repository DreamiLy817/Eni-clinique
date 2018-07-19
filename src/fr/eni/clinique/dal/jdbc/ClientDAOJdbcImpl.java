package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAO;
import fr.eni.clinique.dal.DAOClient;


public class ClientDAOJdbcImpl implements DAO<Client>, DAOClient {

	private static final String sqlSelectAllClient = "select CodeClient, NomClient ,PrenomClient,Adresse1,Adresse2 ,CodePostal ,Ville,NumTel,Assurance,Email,Remarque,Archive from Clients";
	private static final String sqlInsertClient = "insert into Clients (NomClient ,PrenomClient,Adresse1,Adresse2 ,CodePostal ,Ville,NumTel,Assurance,Email,Remarque,Archive) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String sqlMiseAJourClient = "update Clients set NomClient = ? ,PrenomClient = ?,Adresse1 = ?,Adresse2 = ?,CodePostal = ? ,Ville = ?,NumTel = ?,Assurance = ?,Email = ?,Remarque = ? where CodeClient=?";
	private static final String sqlRechercher = "SELECT  * FROM Clients WHERE NomClient LIKE ?";
	 
	 /*
	  * (non-Javadoc)
	  * @see fr.eni.clinique.dal.DAO#selectbyID(java.lang.Integer)
	  */
	@Override
	public Client selectbyID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.eni.clinique.dal.DAO#insert(java.lang.Object)
	 * return void
	 */
	@Override
	public void insert(Client client) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsertClient, Statement.RETURN_GENERATED_KEYS);

			String nom = client.getNomClient();
			String prenom = client.getPrenomClient();
			String adresse1 = client.getAdresse1();
			String adresse2 = client.getAdresse2();
			String codePostal = client.getCodePostal();
			String ville = client.getVille();
			String num = client.getNumTel();
			String assurance = client.getAssurance();
			String email = client.getEmail();
			String remarque = client.getRemarque();
			Boolean archive = client.getArchive();

			rqt.setString(1, nom);
			rqt.setString(2, prenom);
			rqt.setString(3, adresse1);
			rqt.setString(4, adresse2);
			rqt.setString(5, codePostal);
			rqt.setString(6, ville);
			rqt.setString(7, num);
			rqt.setString(8, assurance);
			rqt.setString(9, email);
			rqt.setString(10, remarque);
			rqt.setBoolean(11, archive);

			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				// recuperation du tampon
				rs = rqt.getGeneratedKeys();
				// je vais sur le premier enregistrement s'il existe
				if (rs.next()) {
					client.setCodeClient(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			// TO DO DALException
			throw new DALException("insertPersonnel failed - ", e);
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

	/*
	 * (non-Javadoc)
	 * @see fr.eni.clinique.dal.DAO#selectAll()
	 * return listClient
	 */
	@Override
	public List<Client> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null; 
		List<Client> listeClient = new ArrayList<Client>();
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAllClient);
			Client client = null; 
			
			while(rs.next()) {
				client = new Client(rs.getInt("codeClient"),
						rs.getString("NomClient"),
						rs.getString("PrenomClient"),
						rs.getString("Adresse1"),
						rs.getString("Adresse2"),
						rs.getString("CodePostal"),
						rs.getString("Ville"),
						rs.getString("NumTel"),
						rs.getString("Assurance"),
						rs.getString("Email"),
						rs.getString("Remarque"),
						rs.getBoolean("Archive"));
				listeClient.add(client);
			}
		} catch (SQLException e) {
			throw new DALException("selectAllClient failed - " , e);
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
		return listeClient;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.eni.clinique.dal.DAO#update(java.lang.Object)
	 * return client
	 */
	@Override
	public Client update(Client client) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlMiseAJourClient);
		
			rqt.setString(1, client.getNomClient());
			rqt.setString(2, client.getPrenomClient());
			rqt.setString(3, client.getAdresse1());
			rqt.setString(4, client.getAdresse2());
			rqt.setString(5, client.getCodePostal());
			rqt.setString(6, client.getVille());
			rqt.setString(7, client.getNumTel());
			rqt.setString(8, client.getAssurance());
			rqt.setString(9, client.getEmail());
			rqt.setString(10, client.getRemarque());
			rqt.setInt(11, client.getCodeClient());


			rqt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Update article failed - " + client, e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.eni.clinique.dal.DAO#supprimer(java.lang.Integer)
	 */
	@Override
	public void supprimer(Integer id) throws DALException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see fr.eni.clinique.dal.DAOClient#rechercherClient(java.lang.String)
	 * return listClient
	 */
	@Override
	public List<Client> rechercherClient(String recherche) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null; 
		List<Client> listeClient = new ArrayList<Client>();
		Client client = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlRechercher);
			rqt.setString(1, "%" + recherche + "%");
			rs = rqt.executeQuery();
		
			while(rs.next()) {
				client = new Client(rs.getInt("codeClient"),
						rs.getString("NomClient"),
						rs.getString("PrenomClient"),
						rs.getString("Adresse1"),
						rs.getString("Adresse2"),
						rs.getString("CodePostal"),
						rs.getString("Ville"),
						rs.getString("NumTel"),
						rs.getString("Assurance"),
						rs.getString("Email"),
						rs.getString("Remarque"),
						rs.getBoolean("Archive"));
				listeClient.add(client);
			}
		} catch (SQLException e) {
			throw new DALException("Recherche Client failed - " + recherche , e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeClient;
		
	}

}
