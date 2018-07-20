package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOClient;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.DAOPersonnel;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class EcranClientRecherche extends JFrame {

	private JPanel contentPane;
	private JTextField inputRecherche;
	DAOClient client = DAOFactory.getDAOClient();
	
	
	
	private JList listClient;
    private DefaultListModel listModelClient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranClientRecherche frame = new EcranClientRecherche();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EcranClientRecherche() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 430, 146, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		/*
		 * JTexteField
		 * Champs texte pour rechercher un client
		 */
		inputRecherche = new JTextField();
		GridBagConstraints gbc_inputRecherche = new GridBagConstraints();
		gbc_inputRecherche.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputRecherche.insets = new Insets(0, 0, 5, 5);
		gbc_inputRecherche.gridx = 1;
		gbc_inputRecherche.gridy = 0;
		contentPane.add(inputRecherche, gbc_inputRecherche);
		inputRecherche.setColumns(10);
		
		/*
		 * JButton
		 * Bouton pour lancer la recherche
		 */
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(client.rechercherClient(inputRecherche.getText()));
				} catch (DALException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRechercher.setSelectedIcon(new ImageIcon(EcranClientRecherche.class.getResource("/images/loupe.png")));
		btnRechercher.setForeground(new Color(255, 255, 255));
		btnRechercher.setBackground(new Color(0, 204, 153));
		btnRechercher.setIcon(new ImageIcon(EcranClientRecherche.class.getResource("/images/loupe.png")));
		GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
		gbc_btnRechercher.insets = new Insets(0, 0, 5, 0);
		gbc_btnRechercher.gridx = 2;
		gbc_btnRechercher.gridy = 0;
		contentPane.add(btnRechercher, gbc_btnRechercher);
		
		
		// Liste pour afficher tous les clients
		
		// entrer des donn�es dans mon modele de liste
		 listModelClient = new DefaultListModel();
		 listModelClient.addElement("Jane Doe");
		 listModelClient.addElement("John Smith");
		 listModelClient.addElement("Kathy Green");
		
		//creation de la liste et la mettre dans un scroll pane
		 listClient = new JList(listModelClient);
		 listClient.setBorder(null);
		listClient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listClient.setLayoutOrientation(JList.VERTICAL);
		listClient.setSelectedIndex(0);
		listClient.setVisibleRowCount(5);
		
		 JScrollPane listScrollPane = new JScrollPane(listClient);
		 
		 
		GridBagConstraints gbc_listeClient = new GridBagConstraints();
		gbc_listeClient.anchor = GridBagConstraints.WEST;
		gbc_listeClient.insets = new Insets(0, 0, 0, 5);
		gbc_listeClient.fill = GridBagConstraints.VERTICAL;
		gbc_listeClient.gridx = 1;
		gbc_listeClient.gridy = 1;
		contentPane.add(listScrollPane, gbc_listeClient);
	}
	
	/*
	 * methode pour recup�rer le texte dans le input de recherche
	 */
	public JTextField getTxtRecherche() {
		if (inputRecherche == null) {
			inputRecherche = new JTextField(30);
		}
		return inputRecherche;
	}

}
