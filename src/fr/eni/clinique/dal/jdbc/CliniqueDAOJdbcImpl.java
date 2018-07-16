
package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;

public class CliniqueDAOJdbcImpl implements ArticleDAO {

	private static final String TYPE_STYLO = "STYLO";
	private static final String TYPE_RAMETTE = "RAMETTE";

	private static final String sqlSelectById = "select idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type " +
			" from articles where idArticle = ?";
	private static final String sqlSelectAll = "select idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type " +  
			" from articles";
	private static final String sqlUpdate = "update articles set reference=?,marque=?,designation=?,prixUnitaire=?,qteStock=?,grammage=?,couleur=? where idArticle=?";
	private static final String sqlInsert = "insert into articles(reference,marque,designation,prixUnitaire,qteStock,type,grammage,couleur) values(?,?,?,?,?,?,?,?)";
	private static final String sqlDelete = "delete from articles where idArticle=?";
	private static final String sqlSelectByMarque = "select reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type " + 
													" from articles where marque = ?";
	private static final String sqlSelectByMotCle = "select reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type " + 
													" from articles where marque like ? or designation like ?";
	











}
