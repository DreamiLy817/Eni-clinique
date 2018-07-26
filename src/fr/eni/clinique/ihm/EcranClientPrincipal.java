package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import fr.eni.clinique.bll.AnimalMger;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientMger;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.DALException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EcranClientPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodePersClient;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse1;
	private JTextField textFieldAdresse2;
	private JTextField textFieldCodeP;
	private JTextField textFieldVille;
	private JTextField textFieldNum;
	private JTextField textFieldAssurance;
	private JTextField textFieldEmail;
	private JPanel panelTable;

	private TextArea textAreaRemarque;

	private ClientMger clientMger = ClientMger.getInstance();
	private AnimalMger animalMger = AnimalMger.getInstance();

	private JTable ListeAnimaux;

	private Client client;
	private JTable table;

	private Integer animalInt;
	private Animal animalSelectionne;

	private JButton btnEditerUnAnimal;
	private int selectTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranClientPrincipal frame = new EcranClientPrincipal(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param clientSelectionne
	 * @param listeAnimauxClient
	 */
	public EcranClientPrincipal(final Client clientSelectionne, List<Animal> listeAnimauxClient) {
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
		this.setIconImage(img.getImage());
		client = clientSelectionne;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 642);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 72, 0, 136, 99, 49, 0, 0, 0, 95, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 38, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);


		ImageIcon logo = new ImageIcon(EcranClientPrincipal.class.getResource("/images/ani.png"));
		Image imageLogo = logo.getImage();
		Image imageN = imageLogo.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(imageN);

	
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(logo);
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 1;
				gbc_lblNewLabel.gridy = 0;
				contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
				JButton btnRechercher = new JButton("rechercher");
				btnRechercher.setForeground(new Color(255, 255, 255));
				btnRechercher.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EcranClientRecherche panelRecherche = new EcranClientRecherche();
						panelRecherche.setVisible(true);
						EcranClientPrincipal.this.dispose();
					}
				});
				btnRechercher.setBackground(new Color(0, 204, 153));
				btnRechercher.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/loupe.png")));
				GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
				gbc_btnRechercher.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnRechercher.insets = new Insets(0, 0, 5, 5);
				gbc_btnRechercher.gridx = 3;
				gbc_btnRechercher.gridy = 0;
				contentPane.add(btnRechercher, gbc_btnRechercher);
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EcranAddClient panelAjoutClient = new EcranAddClient();
				panelAjoutClient.setVisible(true);
				EcranClientPrincipal.this.dispose();
			}
		});
		btnAjouter.setForeground(new Color(255, 255, 255));
		btnAjouter.setBackground(new Color(0, 204, 153));
		btnAjouter.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/plus.png")));
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouter.gridx = 4;
		gbc_btnAjouter.gridy = 0;
		contentPane.add(btnAjouter, gbc_btnAjouter);
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clientMger.archivageClient(clientSelectionne.getCodeClient());
					textFieldCodePersClient.setText("");
					textFieldNom.setText("");
					textFieldPrenom.setText("");
					textFieldAdresse1.setText("");
					textFieldAdresse2.setText("");
					textFieldCodeP.setText("");
					textFieldVille.setText("");
					textFieldNum.setText("");
					textFieldAssurance.setText("");
					textFieldEmail.setText("");
					textAreaRemarque.setText("");

				} catch (BLLException e1) {
					JOptionPane.showMessageDialog(EcranClientPrincipal.this,
							"Echec de l'archivage d'un client" +e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnSupprimer.setForeground(new Color(255, 255, 255));
		btnSupprimer.setBackground(new Color(0, 204, 153));
		btnSupprimer.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/minus.png")));
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer.gridx = 5;
		gbc_btnSupprimer.gridy = 0;
		contentPane.add(btnSupprimer, gbc_btnSupprimer);
		JButton btnValider = new JButton("valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Vérification que la nouvelle saisie n'est pas égale a celle
				// de base du client
				// Nom
				if (clientSelectionne.getNomClient() != (getTextFieldNom().getText())) {
					clientSelectionne.setNomClient(getTextFieldNom().getText());
				}
				// Prénom
				if (clientSelectionne.getPrenomClient() != (getTextFieldPrenom().getText())) {
					clientSelectionne.setPrenomClient(getTextFieldPrenom().getText());
				}
				// Adresse 1
				if (clientSelectionne.getAdresse1() != (getTextFieldAdresse1().getText())) {
					clientSelectionne.setAdresse1(getTextFieldAdresse1().getText());
				}
				// Adresse 2
				if (clientSelectionne.getAdresse2() != (getTextFieldAdresse2().getText())) {
					clientSelectionne.setAdresse2(getTextFieldAdresse2().getText());
				}
				// Code Postal
				if (clientSelectionne.getCodePostal() != (getTextFieldCodePostal().getText())) {
					clientSelectionne.setCodePostal(getTextFieldCodePostal().getText());
				}
				// Ville
				if (clientSelectionne.getVille() != (getTextFieldVille().getText())) {
					clientSelectionne.setVille(getTextFieldVille().getText());
				}
				// Numéro de téléphone
				if (clientSelectionne.getNumTel() != (getTextFieldNumero().getText())) {
					clientSelectionne.setNumTel(getTextFieldNumero().getText());
				}
				// Assurance
				if (clientSelectionne.getAssurance() != (getTextFieldAssurance().getText())) {
					clientSelectionne.setAssurance(getTextFieldAssurance().getText());
				}
				// Email
				if (clientSelectionne.getEmail() != (getTextFieldEmail().getText())) {
					clientSelectionne.setEmail(getTextFieldEmail().getText());
				}
				// Remarque
				if (clientSelectionne.getRemarque() != (getTextRemarque().getText())) {
					clientSelectionne.setRemarque(getTextRemarque().getText());
				}

				try {
					// TODO optimisation ne pas faire la requete si les champs
					// sont pareils
					clientMger.miseAJourClient(clientSelectionne);
				} catch (BLLException e1) {
					JOptionPane.showMessageDialog(EcranClientPrincipal.this,
							"Echec de la validation des informations." + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnValider.setForeground(new Color(255, 255, 255));
		btnValider.setBackground(new Color(0, 204, 153));
		btnValider.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/check.png")));
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 6;
		gbc_btnValider.gridy = 0;
		contentPane.add(btnValider, gbc_btnValider);
		JButton btnAnnuler = new JButton("annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textFieldNom.setText(clientSelectionne.getNomClient());
				textFieldPrenom.setText(clientSelectionne.getPrenomClient());
				textFieldAdresse1.setText(clientSelectionne.getAdresse1());
				textFieldAdresse2.setText(clientSelectionne.getAdresse2());
				textFieldCodeP.setText(clientSelectionne.getCodePostal());
				textFieldVille.setText(clientSelectionne.getVille());
				textFieldNum.setText(clientSelectionne.getNumTel());
				textFieldAssurance.setText(clientSelectionne.getAssurance());
				textFieldEmail.setText(clientSelectionne.getEmail());
				textAreaRemarque.setText(clientSelectionne.getRemarque());

			}
		});
		btnAnnuler.setBackground(new Color(0, 204, 153));
		btnAnnuler.setForeground(new Color(255, 255, 255));
		btnAnnuler.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/back.png")));
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnuler.gridx = 7;
		gbc_btnAnnuler.gridy = 0;
		contentPane.add(btnAnnuler, gbc_btnAnnuler);
		JLabel lblCode = new JLabel("Code");
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.EAST;
		gbc_lblCode.fill = GridBagConstraints.VERTICAL;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 1;
		gbc_lblCode.gridy = 1;
		contentPane.add(lblCode, gbc_lblCode);

		/**
		 * Input code client
		 */
		GridBagConstraints gbc_textFieldCode = new GridBagConstraints();
		gbc_textFieldCode.gridwidth = 3;
		gbc_textFieldCode.fill = GridBagConstraints.BOTH;
		gbc_textFieldCode.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCode.gridx = 2;
		gbc_textFieldCode.gridy = 1;
		contentPane.add(getTextFieldCodeClient(), gbc_textFieldCode);
		textFieldCodePersClient.setColumns(10);

		/**
		 * Jtable liste des animaux
		 */

		afficherTableauAnimaux(listeAnimauxClient);

		/**
		 * Label de l'input nom
		 */
	

		JLabel lblNom = new JLabel("Nom");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 2;
		contentPane.add(lblNom, gbc_lblNom);

		/**
		 * Input du nom du client
		 */
		GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
		gbc_textFieldNom.gridwidth = 3;
		gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNom.gridx = 2;
		gbc_textFieldNom.gridy = 2;
		contentPane.add(getTextFieldNom(), gbc_textFieldNom);
		textFieldNom.setColumns(10);

		/**
		 * Label de l'input prénom
		 */
		JLabel lblPrenom = new JLabel("Prenom");
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.anchor = GridBagConstraints.EAST;
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 1;
		gbc_lblPrenom.gridy = 3;
		contentPane.add(lblPrenom, gbc_lblPrenom);

		/**
		 * Input du prenom du client
		 */
		GridBagConstraints gbc_textFieldPrenom = new GridBagConstraints();
		gbc_textFieldPrenom.gridwidth = 3;
		gbc_textFieldPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrenom.gridx = 2;
		gbc_textFieldPrenom.gridy = 3;
		contentPane.add(getTextFieldPrenom(), gbc_textFieldPrenom);
		textFieldPrenom.setColumns(10);

		/**
		 * Label de l'input adresse 1
		 */
		JLabel lblAdresse = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.EAST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 1;
		gbc_lblAdresse.gridy = 4;
		contentPane.add(lblAdresse, gbc_lblAdresse);

		/**
		 * Input 1 de l'adresse du client
		 */
		GridBagConstraints gbc_textFieldAdresse1 = new GridBagConstraints();
		gbc_textFieldAdresse1.gridwidth = 3;
		gbc_textFieldAdresse1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse1.gridx = 2;
		gbc_textFieldAdresse1.gridy = 4;
		contentPane.add(getTextFieldAdresse1(), gbc_textFieldAdresse1);
		textFieldAdresse1.setColumns(10);

		/**
		 * Input 2 de l'adresse du client
		 */
		GridBagConstraints gbc_textFieldAdresse2 = new GridBagConstraints();
		gbc_textFieldAdresse2.gridwidth = 3;
		gbc_textFieldAdresse2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse2.gridx = 2;
		gbc_textFieldAdresse2.gridy = 5;
		contentPane.add(getTextFieldAdresse2(), gbc_textFieldAdresse2);
		textFieldAdresse2.setColumns(10);

		/**
		 * Label de l'input code postal
		 */
		JLabel lblCodePostal = new JLabel("Code postal");
		GridBagConstraints gbc_lblCodePostal = new GridBagConstraints();
		gbc_lblCodePostal.anchor = GridBagConstraints.EAST;
		gbc_lblCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostal.gridx = 1;
		gbc_lblCodePostal.gridy = 6;
		contentPane.add(lblCodePostal, gbc_lblCodePostal);

		/**
		 * Input du code postal
		 */
		GridBagConstraints gbc_textFieldCodeP = new GridBagConstraints();
		gbc_textFieldCodeP.gridwidth = 3;
		gbc_textFieldCodeP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodeP.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodeP.gridx = 2;
		gbc_textFieldCodeP.gridy = 6;
		contentPane.add(getTextFieldCodePostal(), gbc_textFieldCodeP);
		textFieldCodeP.setColumns(10);

		/**
		 * Label de l'input ville
		 */
		JLabel lblVille = new JLabel("Ville");
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.anchor = GridBagConstraints.EAST;
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.gridx = 1;
		gbc_lblVille.gridy = 7;
		contentPane.add(lblVille, gbc_lblVille);

		/**
		 * Input de ville
		 */
		GridBagConstraints gbc_textFieldVille = new GridBagConstraints();
		gbc_textFieldVille.gridwidth = 3;
		gbc_textFieldVille.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVille.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVille.gridx = 2;
		gbc_textFieldVille.gridy = 7;
		contentPane.add(getTextFieldVille(), gbc_textFieldVille);
		textFieldVille.setColumns(10);

		/**
		 * Label de l'input numero de téléphone
		 */
		JLabel lblNum = new JLabel("Num");
		GridBagConstraints gbc_lblNum = new GridBagConstraints();
		gbc_lblNum.anchor = GridBagConstraints.EAST;
		gbc_lblNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblNum.gridx = 1;
		gbc_lblNum.gridy = 8;
		contentPane.add(lblNum, gbc_lblNum);

		/**
		 * Input du numero de tel
		 */
		GridBagConstraints gbc_textFieldNum = new GridBagConstraints();
		gbc_textFieldNum.gridwidth = 3;
		gbc_textFieldNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNum.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNum.gridx = 2;
		gbc_textFieldNum.gridy = 8;
		contentPane.add(getTextFieldNumero(), gbc_textFieldNum);
		textFieldNum.setColumns(10);

		/**
		 * Label de l'input assurance
		 */
		JLabel lblAssurance = new JLabel("Assurance");
		GridBagConstraints gbc_lblAssurance = new GridBagConstraints();
		gbc_lblAssurance.anchor = GridBagConstraints.EAST;
		gbc_lblAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssurance.gridx = 1;
		gbc_lblAssurance.gridy = 9;
		contentPane.add(lblAssurance, gbc_lblAssurance);

		/**
		 * Input de l'assurance
		 */
		GridBagConstraints gbc_textFieldAssurance = new GridBagConstraints();
		gbc_textFieldAssurance.gridwidth = 3;
		gbc_textFieldAssurance.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAssurance.gridx = 2;
		gbc_textFieldAssurance.gridy = 9;
		contentPane.add(getTextFieldAssurance(), gbc_textFieldAssurance);
		textFieldAssurance.setColumns(10);

				JButton btnAjouterUnAnimal = new JButton("Ajouter un animal");
				btnAjouterUnAnimal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						EcranAnimalAjout ecranA = new EcranAnimalAjout(animalSelectionne, clientSelectionne);
						ecranA.getTextClient().setText(clientSelectionne.getNomClient());
						ecranA.setVisible(true);
						EcranClientPrincipal.this.dispose();
					}
				});
				btnAjouterUnAnimal.setForeground(new Color(255, 255, 255));
				btnAjouterUnAnimal.setBackground(new Color(0, 204, 153));
				btnAjouterUnAnimal.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/plus.png")));
				GridBagConstraints gbc_btnAjouterUnAnimal = new GridBagConstraints();
				gbc_btnAjouterUnAnimal.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnAjouterUnAnimal.insets = new Insets(0, 0, 5, 5);
				gbc_btnAjouterUnAnimal.gridx = 5;
				gbc_btnAjouterUnAnimal.gridy = 9;
				contentPane.add(btnAjouterUnAnimal, gbc_btnAjouterUnAnimal);

		/**
		 * Bouton supprimer un animal au client sélectionné
		 */
		
		JButton btnSupprimerAnimal = new JButton("Supprimer un animal");
		btnSupprimerAnimal.setForeground(new Color(255, 255, 255));
		btnSupprimerAnimal.setBackground(new Color(0, 204, 153));
		btnSupprimerAnimal.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/minus.png")));
		btnSupprimerAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectTable = ((int)table.getValueAt(table.getSelectedRow(), 0));
				try {
					animalMger.archivageViaCodeClient(client.getCodeClient(), selectTable);
					int recupRow = table.getSelectedRow();
					((DefaultTableModel) table.getModel()).removeRow(recupRow);
				} catch (BLLException e1) {
					JOptionPane.showMessageDialog(EcranClientPrincipal.this,
							"Echec de l'archivage de l'animal." + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnSupprimerAnimal = new GridBagConstraints();
		gbc_btnSupprimerAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimerAnimal.gridx = 6;
		gbc_btnSupprimerAnimal.gridy = 9;
		contentPane.add(btnSupprimerAnimal, gbc_btnSupprimerAnimal);

		/**
		 * Label de l'input email
		 */
		btnEditerUnAnimal = new JButton("Editer un animal");
		btnEditerUnAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			     animalInt = (Integer) table.getValueAt(table.getSelectedRow(),0);
	                try {
						animalSelectionne = animalMger.selectionByCodeAnimal(animalInt);
						System.out.println(animalInt);
						System.out.println(animalSelectionne);
						 EcranAnimal ecranA = new EcranAnimal(animalSelectionne, clientSelectionne);
						 ecranA.setVisible(true);
						 EcranClientPrincipal.this.dispose();
						 
						 
							ecranA.getLabelCodeAnimal().setText(String.valueOf(animalSelectionne.getCodeAnimal()));
								ecranA.getTextClient().setText(clientSelectionne.getNomClient());
				                ecranA.getTextNom().setText(animalSelectionne.getNomAnimal());
								ecranA.getSexeComboBox().setSelectedItem(animalSelectionne.getSexe());
								ecranA.getTextCouleur().setText(animalSelectionne.getCouleur());
								ecranA.getEspeceComboBox().setSelectedItem(animalSelectionne.getEspece());
								ecranA.getRaceComboBox().setSelectedItem(animalSelectionne.getRace());
								ecranA.getTextTatouage().setText(animalSelectionne.getTatouage());
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(EcranClientPrincipal.this,
								"Echec de l'édition des informations de l'animal." + e1.getMessage());
						e1.printStackTrace();
					}
	             
			}
		});
		
		btnEditerUnAnimal.setForeground(new Color(255, 255, 255));
		btnEditerUnAnimal.setBackground(new Color(0, 204, 153));
		GridBagConstraints gbc_btnEditerUnAnimal = new GridBagConstraints();
		gbc_btnEditerUnAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditerUnAnimal.gridx = 7;
		gbc_btnEditerUnAnimal.gridy = 9;
		contentPane.add(btnEditerUnAnimal, gbc_btnEditerUnAnimal);
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 10;
		contentPane.add(lblEmail, gbc_lblEmail);

		/**
		 * Input de l'email
		 */
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.gridwidth = 3;
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 2;
		gbc_textFieldEmail.gridy = 10;
		contentPane.add(getTextFieldEmail(), gbc_textFieldEmail);
		textFieldEmail.setColumns(10);

		/**
		 * Label de l'input remarque
		 */
		JLabel lblRemarque = new JLabel("Remarque");
		GridBagConstraints gbc_lblRemarque = new GridBagConstraints();
		gbc_lblRemarque.anchor = GridBagConstraints.EAST;
		gbc_lblRemarque.insets = new Insets(0, 0, 0, 5);
		gbc_lblRemarque.gridx = 1;
		gbc_lblRemarque.gridy = 11;
		contentPane.add(lblRemarque, gbc_lblRemarque);

		/**
		 * Textarea de remarque
		 */
		GridBagConstraints gbc_textAreaRemarque = new GridBagConstraints();
		gbc_textAreaRemarque.anchor = GridBagConstraints.NORTH;
		gbc_textAreaRemarque.gridwidth = 3;
		gbc_textAreaRemarque.insets = new Insets(0, 0, 0, 5);
		gbc_textAreaRemarque.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAreaRemarque.gridx = 2;
		gbc_textAreaRemarque.gridy = 11;
		contentPane.add(getTextRemarque(), gbc_textAreaRemarque);

	}

	

	/**
	 * Méthode pour recupérer le texte dans l'input code client
	 * 
	 * @return textFieldCodePers
	 */
	public JTextField getTextFieldCodeClient() {
		if (textFieldCodePersClient == null) {
			textFieldCodePersClient = new JTextField();
		}
		return textFieldCodePersClient;

	}

	/**
	 * Méthode pour recupérer le texte dans l'input du nom
	 * 
	 * @return textFieldNom
	 */
	public JTextField getTextFieldNom() {
		if (textFieldNom == null) {
			textFieldNom = new JTextField(20);
		}
		return textFieldNom;

	}

	/**
	 * Méthode pour recupérer le texte dans l'input du prenom
	 * 
	 * @return textFieldPrenom
	 */
	public JTextField getTextFieldPrenom() {
		if (textFieldPrenom == null) {
			textFieldPrenom = new JTextField(20);
		}
		return textFieldPrenom;

	}

	/**
	 * Méthode pour recupérer le texte dans l'input de ladresse 1
	 * 
	 * @return textFieldAdresse1
	 */
	public JTextField getTextFieldAdresse1() {
		if (textFieldAdresse1 == null) {
			textFieldAdresse1 = new JTextField(30);
		}
		return textFieldAdresse1;

	}

	/**
	 * Méthode pour recupérer le texte dans l'input de l'adresse 2
	 * 
	 * @return textFieldAdresse2
	 */
	public JTextField getTextFieldAdresse2() {
		if (textFieldAdresse2 == null) {
			textFieldAdresse2 = new JTextField(30);
		}
		return textFieldAdresse2;

	}

	/**
	 * Méthode pour recupérer le texte dans l'input du code postal
	 * 
	 * @return textFieldCodePostal
	 */
	public JTextField getTextFieldCodePostal() {
		if (textFieldCodeP == null) {
			textFieldCodeP = new JTextField(6);
		}
		return textFieldCodeP;
	}

	/**
	 * Méthode pour recupérer le texte dans l'input de ville
	 * 
	 * @return textFieldVille
	 */
	public JTextField getTextFieldVille() {
		if (textFieldVille == null) {
			textFieldVille = new JTextField(25);
		}
		return textFieldVille;
	}

	/**
	 * Méthode pour recupérer le texte dans l'input du numero
	 * 
	 * @return textFieldNumero
	 */
	public JTextField getTextFieldNumero() {
		if (textFieldNum == null) {
			textFieldNum = new JTextField(15);
		}
		return textFieldNum;
	}

	/**
	 * Méthode pour recupérer le texte dans l'input de l'assurance
	 * 
	 * @return textFieldAssurance
	 */
	public JTextField getTextFieldAssurance() {
		if (textFieldAssurance == null) {
			textFieldAssurance = new JTextField(30);
		}
		return textFieldAssurance;
	}

	/**
	 * Méthode pour recupérer le texte dans l'input du mail
	 * 
	 * @return textFieldEmail
	 */
	public JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField(20);
		}
		return textFieldEmail;
	}

	/**
	 * Méthode pour recupérer le texte dans le input de remarque
	 * 
	 * @return textArea
	 */
	public TextArea getTextRemarque() {
		if (textAreaRemarque == null) {
			textAreaRemarque = new TextArea();
		}
		return textAreaRemarque;
	}
	
	public void afficherTableauAnimaux(List<Animal> listeAnimauxClient) {
		if (listeAnimauxClient != null) {
			// TODO HEADER
			String col[] = { "numero", "nom", "sexe", "couleur", "race", "espece", "tatouage" };
			DefaultTableModel tableModel = new DefaultTableModel(col, 0);
			table = new JTable(tableModel);
			for (Animal animal : listeAnimauxClient) {
				Object[] obj = { animal.getCodeAnimal(), animal.getNomAnimal(), animal.getSexe(), animal.getCouleur(),
						animal.getRace(), animal.getEspece(), animal.getTatouage() };
				tableModel.addRow(obj);
			}
			table.setDefaultEditor(Object.class, null);
			GridBagConstraints gbc_table = new GridBagConstraints();
			gbc_table.gridwidth = 3;
			gbc_table.gridheight = 7;
			gbc_table.insets = new Insets(0, 0, 5, 5);
			gbc_table.fill = GridBagConstraints.BOTH;
			gbc_table.gridx = 5;
			gbc_table.gridy = 1;

			contentPane.add(table, gbc_table);

		}
	}

}
