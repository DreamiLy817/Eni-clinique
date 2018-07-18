package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAO;
import fr.eni.clinique.dal.DAOFactory;

public class EcranPersonnel extends JFrame {

	private JButton ajouterButton;
	private JButton supprimerButton;
	private JButton reinitialiserButton;


	private JButton getSupprimerButton() {
		if (supprimerButton == null) {
			supprimerButton = new JButton("Supprimer");
		}
		return supprimerButton;
	}

	private JButton getReinitialiserButton() {
		if (reinitialiserButton == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/89647-200.png")));
			reinitialiserButton = new JButton(image);
		}
		return reinitialiserButton;
	}

	private JButton getAjouterButton() {
		if (ajouterButton == null) {
			ajouterButton = new JButton("Ajouter");
		}
		return ajouterButton;
	}

	public EcranPersonnel() {
		super();
		try {
			initIHM();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void initIHM() throws DALException {
		// Initialisation de l'IHM, déclaration des panneaux
		JPanel panelPrincipal = new JPanel();
		JPanel panelBoutons = new JPanel();
		JPanel panelTable = new JPanel();
		panelPrincipal.setOpaque(false);
		panelPrincipal.setLayout(new GridBagLayout());
		panelBoutons.setOpaque(false);
		panelBoutons.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		//Création du tableau JTable
		DAO<Personnel> personnelDAO = DAOFactory.getPersonnelDAO();
        List<Personnel> catalogue = personnelDAO.selectAll();
        List<String[]> lignes = new ArrayList<String[]>();
        List<String> colonne = new ArrayList<String>();
        colonne.add("Nom");
        colonne.add("Rôle");
        colonne.add("Mot de Passe");
        String tampon = null;
    	int i = 0;
        for (Personnel employe : catalogue){
        	tampon = employe.getNom();
//        	lignes.add(i, tampon);
        	i++;

       }

        TableModel tableModel = new DefaultTableModel(lignes.toArray(new Object[][] {}), colonne.toArray());
        JTable table = new JTable(tableModel);
        panelTable.setLayout(new BorderLayout());
        panelTable.add(new JScrollPane(table), BorderLayout.CENTER);
        panelTable.add(table.getTableHeader(), BorderLayout.NORTH);
        panelTable.setVisible(true);
		
		// Création du panneau des boutons
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelBoutons.add(getAjouterButton(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panelBoutons.add(getSupprimerButton(), gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		panelBoutons.add(getReinitialiserButton(), gbc);


		// Création du panel principal
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panelPrincipal.add(panelBoutons, gbc);
		gbc.gridx= 0;
		gbc.gridy= 1;
		panelPrincipal.add(panelTable, gbc);
		this.setContentPane(panelPrincipal);

	}
}
