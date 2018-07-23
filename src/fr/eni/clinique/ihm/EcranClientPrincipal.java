package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DAO;
import fr.eni.clinique.dal.DAOFactory;
import javax.swing.JInternalFrame;

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
	
	private TextArea textAreaRemarque;
	
	
	private DAO<Client> clientDAO = DAOFactory.getClientDAO();
	
	private JTable ListeAnimaux;
	
	private Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranClientPrincipal frame = new EcranClientPrincipal(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param clientSelectionne 
	 */
	public EcranClientPrincipal(Client clientSelectionne) {
		client = clientSelectionne;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 136, 99, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		/**
		 * button rechercher un client
		 */
		JButton btnRechercher = new JButton("rechercher");
		btnRechercher.setForeground(new Color(255, 255, 255));
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EcranClientRecherche panelRecherche = new EcranClientRecherche();
				panelRecherche.setVisible(true);
			}
		});
		btnRechercher.setBackground(new Color(0, 204, 153));
		btnRechercher.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/loupe.png")));
		GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
		gbc_btnRechercher.anchor = GridBagConstraints.WEST;
		gbc_btnRechercher.insets = new Insets(0, 0, 5, 5);
		gbc_btnRechercher.gridx = 1;
		gbc_btnRechercher.gridy = 0;
		contentPane.add(btnRechercher, gbc_btnRechercher);
		
		/**
		 * button ajouter un client
		 */
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EcranAddClient panelAjoutClient = new EcranAddClient();
				panelAjoutClient.setVisible(true);
			}
		});
		btnAjouter.setForeground(new Color(255, 255, 255));
		btnAjouter.setBackground(new Color(0, 204, 153));
		btnAjouter.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/plus.png")));
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.anchor = GridBagConstraints.WEST;
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouter.gridx = 4;
		gbc_btnAjouter.gridy = 0;
		contentPane.add(btnAjouter, gbc_btnAjouter);
		
		/**
		 * button supprimer un client
		 */
		JButton btnSupprimer = new JButton("supprimer");
		btnSupprimer.setForeground(new Color(255, 255, 255));
		btnSupprimer.setBackground(new Color(0, 204, 153));
		btnSupprimer.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/minus.png")));
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer.gridx = 5;
		gbc_btnSupprimer.gridy = 0;
		contentPane.add(btnSupprimer, gbc_btnSupprimer);
		
		/**
		 * button valider un client
		 */
		JButton btnValider = new JButton("valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnValider.setForeground(new Color(255, 255, 255));
		btnValider.setBackground(new Color(0, 204, 153));
		btnValider.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/check.png")));
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.anchor = GridBagConstraints.EAST;
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 6;
		gbc_btnValider.gridy = 0;
		contentPane.add(btnValider, gbc_btnValider);
		
		/**
		 * button annuler un client
		 */
		JButton btnAnnuler = new JButton("annuler");
		btnAnnuler.setBackground(new Color(0, 204, 153));
		btnAnnuler.setForeground(new Color(255, 255, 255));
		btnAnnuler.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/back.png")));
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnuler.gridx = 7;
		gbc_btnAnnuler.gridy = 0;
		contentPane.add(btnAnnuler, gbc_btnAnnuler);
		
		/**
		 * label de l'input code
		 */
		JLabel lblCode = new JLabel("Code");
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.WEST;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 1;
		gbc_lblCode.gridy = 2;
		contentPane.add(lblCode, gbc_lblCode);
		
		/**
		 * input code client
		 */
		GridBagConstraints gbc_textFieldCode = new GridBagConstraints();
		gbc_textFieldCode.anchor = GridBagConstraints.NORTH;
		gbc_textFieldCode.gridwidth = 2;
		gbc_textFieldCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCode.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCode.gridx = 2;
		gbc_textFieldCode.gridy = 2;
		contentPane.add(getTextFieldCodeClient(), gbc_textFieldCode);
		textFieldCodePersClient.setColumns(10);
		
	
		/**
		 * liste des clients JTable
		 */
		TableModel tableModel = new DefaultTableModel();
		
		ListeAnimaux = new JTable();
		GridBagConstraints gbc_ListeAnimaux = new GridBagConstraints();
		gbc_ListeAnimaux.gridheight = 7;
		gbc_ListeAnimaux.gridwidth = 3;
		gbc_ListeAnimaux.insets = new Insets(0, 0, 5, 5);
		gbc_ListeAnimaux.fill = GridBagConstraints.BOTH;
		gbc_ListeAnimaux.gridx = 5;
		gbc_ListeAnimaux.gridy = 2;
		contentPane.add(ListeAnimaux, gbc_ListeAnimaux);
		
		/**
		 * label de l'input nom
		 */
		JLabel lblNom = new JLabel("Nom");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.WEST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 3;
		contentPane.add(lblNom, gbc_lblNom);
		
		/**
		 * input du nom du client
		 */
		GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
		gbc_textFieldNom.gridwidth = 2;
		gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNom.gridx = 2;
		gbc_textFieldNom.gridy = 3;
		contentPane.add(getTextFieldNom(), gbc_textFieldNom);
		textFieldNom.setColumns(10);
		
		/**
		 * label de l'input prenom
		 */
		JLabel lblPrenom = new JLabel("Prenom");
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.anchor = GridBagConstraints.WEST;
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 1;
		gbc_lblPrenom.gridy = 4;
		contentPane.add(lblPrenom, gbc_lblPrenom);
		
		/**
		 * inpu du prenom du client
		 */
		GridBagConstraints gbc_textFieldPrenom = new GridBagConstraints();
		gbc_textFieldPrenom.gridwidth = 2;
		gbc_textFieldPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrenom.gridx = 2;
		gbc_textFieldPrenom.gridy = 4;
		contentPane.add(getTextFieldPrenom(), gbc_textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		/**
		 * label de l'input adresse 1 
		 */
		JLabel lblAdresse = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.WEST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 1;
		gbc_lblAdresse.gridy = 5;
		contentPane.add(lblAdresse, gbc_lblAdresse);
		
		/**
		 * input 1 de l'adresse du client
		 */
		GridBagConstraints gbc_textFieldAdresse1 = new GridBagConstraints();
		gbc_textFieldAdresse1.gridwidth = 2;
		gbc_textFieldAdresse1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse1.gridx = 2;
		gbc_textFieldAdresse1.gridy = 5;
		contentPane.add(getTextFieldAdresse1(), gbc_textFieldAdresse1);
		textFieldAdresse1.setColumns(10);
		
		/**
		 * input 2 de l'adresse du client
		 */
		GridBagConstraints gbc_textFieldAdresse2 = new GridBagConstraints();
		gbc_textFieldAdresse2.gridwidth = 2;
		gbc_textFieldAdresse2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse2.gridx = 2;
		gbc_textFieldAdresse2.gridy = 6;
		contentPane.add(getTextFieldAdresse2(), gbc_textFieldAdresse2);
		textFieldAdresse2.setColumns(10);
		
		/**
		 * label de l'input code postal
		 */
		JLabel lblCodePostal = new JLabel("Code postal");
		GridBagConstraints gbc_lblCodePostal = new GridBagConstraints();
		gbc_lblCodePostal.anchor = GridBagConstraints.WEST;
		gbc_lblCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostal.gridx = 1;
		gbc_lblCodePostal.gridy = 7;
		contentPane.add(lblCodePostal, gbc_lblCodePostal);
		
		/**
		 * input du code postal
		 */
		GridBagConstraints gbc_textFieldCodeP = new GridBagConstraints();
		gbc_textFieldCodeP.gridwidth = 2;
		gbc_textFieldCodeP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodeP.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodeP.gridx = 2;
		gbc_textFieldCodeP.gridy = 7;
		contentPane.add(getTextFieldCodePostal(), gbc_textFieldCodeP);
		textFieldCodeP.setColumns(10);
		
		/**
		 * label de l'input ville
		 */
		JLabel lblVille = new JLabel("Ville");
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.anchor = GridBagConstraints.WEST;
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.gridx = 1;
		gbc_lblVille.gridy = 8;
		contentPane.add(lblVille, gbc_lblVille);
		 
		/**
		 * input de ville
		 */
		GridBagConstraints gbc_textFieldVille = new GridBagConstraints();
		gbc_textFieldVille.gridwidth = 2;
		gbc_textFieldVille.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVille.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVille.gridx = 2;
		gbc_textFieldVille.gridy = 8;
		contentPane.add(getTextFieldVille(), gbc_textFieldVille);
		textFieldVille.setColumns(10);
		
		/**
		 * label de l'input numero de telephone
		 */
		JLabel lblNum = new JLabel("Num");
		GridBagConstraints gbc_lblNum = new GridBagConstraints();
		gbc_lblNum.anchor = GridBagConstraints.WEST;
		gbc_lblNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblNum.gridx = 1;
		gbc_lblNum.gridy = 9;
		contentPane.add(lblNum, gbc_lblNum);
		
		/**
		 * input du numero de tel
		 */
		GridBagConstraints gbc_textFieldNum = new GridBagConstraints();
		gbc_textFieldNum.gridwidth = 2;
		gbc_textFieldNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNum.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNum.gridx = 2;
		gbc_textFieldNum.gridy = 9;
		contentPane.add(getTextFieldNumero(), gbc_textFieldNum);
		textFieldNum.setColumns(10);
		
		/**
		 * label de l'input assurance
		 */
		JLabel lblAssurance = new JLabel("Assurance");
		GridBagConstraints gbc_lblAssurance = new GridBagConstraints();
		gbc_lblAssurance.anchor = GridBagConstraints.WEST;
		gbc_lblAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssurance.gridx = 1;
		gbc_lblAssurance.gridy = 10;
		contentPane.add(lblAssurance, gbc_lblAssurance);
		
		/**
		 * input de l'assurance
		 */
		GridBagConstraints gbc_textFieldAssurance = new GridBagConstraints();
		gbc_textFieldAssurance.gridwidth = 2;
		gbc_textFieldAssurance.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAssurance.gridx = 2;
		gbc_textFieldAssurance.gridy = 10;
		contentPane.add(getTextFieldAssurance(), gbc_textFieldAssurance);
		textFieldAssurance.setColumns(10);
		
		/**
		 *button ajouter un animal au client selectionne
		 */
		JButton btnAjouterUnAnimal = new JButton("Ajouter un animal");
		btnAjouterUnAnimal.setForeground(new Color(255, 255, 255));
		btnAjouterUnAnimal.setBackground(new Color(0, 204, 153));
		btnAjouterUnAnimal.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/plus.png")));
		GridBagConstraints gbc_btnAjouterUnAnimal = new GridBagConstraints();
		gbc_btnAjouterUnAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAjouterUnAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouterUnAnimal.gridx = 5;
		gbc_btnAjouterUnAnimal.gridy = 10;
		contentPane.add(btnAjouterUnAnimal, gbc_btnAjouterUnAnimal);
		

		/**
		 *button supprime un animal au client selectionne
		 */
		JButton btnSupprimerAnimal = new JButton("Supprimer un animal");
		btnSupprimerAnimal.setForeground(new Color(255, 255, 255));
		btnSupprimerAnimal.setBackground(new Color(0, 204, 153));
		btnSupprimerAnimal.setIcon(new ImageIcon(EcranClientPrincipal.class.getResource("/images/minus.png")));
		btnSupprimerAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnSupprimerAnimal = new GridBagConstraints();
		gbc_btnSupprimerAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimerAnimal.gridx = 6;
		gbc_btnSupprimerAnimal.gridy = 10;
		contentPane.add(btnSupprimerAnimal, gbc_btnSupprimerAnimal);
		

		/**
		 *button editer un animal au client selectionne
		 */
		JButton btnEditerUnAnimal = new JButton("Editer un animal");
		btnEditerUnAnimal.setForeground(new Color(255, 255, 255));
		btnEditerUnAnimal.setBackground(new Color(0, 204, 153));
		GridBagConstraints gbc_btnEditerUnAnimal = new GridBagConstraints();
		gbc_btnEditerUnAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditerUnAnimal.gridx = 7;
		gbc_btnEditerUnAnimal.gridy = 10;
		contentPane.add(btnEditerUnAnimal, gbc_btnEditerUnAnimal);
		
		/**
		 * label de l'input email
		 */
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 11;
		contentPane.add(lblEmail, gbc_lblEmail);

		/**
		 * input de email
		 */
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.gridwidth = 2;
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 2;
		gbc_textFieldEmail.gridy = 11;
		contentPane.add(getTextFieldEmail(), gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		
		/**
		 * label de l'input remarque
		 */
		JLabel lblRemarque = new JLabel("Remarque");
		GridBagConstraints gbc_lblRemarque = new GridBagConstraints();
		gbc_lblRemarque.anchor = GridBagConstraints.WEST;
		gbc_lblRemarque.insets = new Insets(0, 0, 0, 5);
		gbc_lblRemarque.gridx = 1;
		gbc_lblRemarque.gridy = 12;
		contentPane.add(lblRemarque, gbc_lblRemarque);
		
		/**
		 * textarea de remarque
		 */
		GridBagConstraints gbc_textAreaRemarque = new GridBagConstraints();
		gbc_textAreaRemarque.gridwidth = 2;
		gbc_textAreaRemarque.insets = new Insets(0, 0, 0, 5);
		gbc_textAreaRemarque.fill = GridBagConstraints.BOTH;
		gbc_textAreaRemarque.gridx = 2;
		gbc_textAreaRemarque.gridy = 12;
		contentPane.add(getTextRemarque(), gbc_textAreaRemarque);
	}

	/**
	 * methode pour recup�rer le texte dans le input code client
	 * @return textFieldCodePers
	 */
	public JTextField getTextFieldCodeClient(){
		if(textFieldCodePersClient == null){
			textFieldCodePersClient = new JTextField();
		}
		return textFieldCodePersClient;
		
	}
	
	/**
	 * methode pour recup�rer le texte dans le input du nom
	 * @return textFieldNom
	 */
	public JTextField getTextFieldNom() {
		if(textFieldNom == null){
			textFieldNom = new JTextField(20);
		}
		return textFieldNom;
		
	}
	
	/**
	 * methode pour recup�rer le texte dans le input du prenom
	 * @return textFieldPrenom
	 */
	public JTextField getTextFieldPrenom() {
		if(textFieldPrenom == null){
			textFieldPrenom = new JTextField(20);
		}
		return textFieldPrenom;
		
	}
	
	/**
	 * methode pour recup�rer le texte dans le input de ladresse 1 
	 * @return textFieldAdresse1
	 */
	public JTextField getTextFieldAdresse1() {
		if(textFieldAdresse1 == null){
			textFieldAdresse1 = new JTextField(30);
		}
		return textFieldAdresse1;
		
	}
	
	/**
	 * methode pour recup�rer le texte dans le input de l'adresse 2
	 * @return textFieldAdresse2
	 */
	public JTextField getTextFieldAdresse2() {
		if(textFieldAdresse2 == null){
			textFieldAdresse2 = new JTextField(30);
		}
		return textFieldAdresse2;
		
	}
	
	/**
	 * methode pour recup�rer le texte dans le input du code postal
	 * @return textFieldCodePostal
	 */
	public JTextField getTextFieldCodePostal() {
		if(textFieldCodeP == null){
			textFieldCodeP = new JTextField(6);
		}
		return textFieldCodeP;
	}
	
	/**
	 * methode pour recup�rer le texte dans le input de ville 
	 * @return textFieldVille
	 */
	public JTextField getTextFieldVille() {
		if(textFieldVille == null){
			textFieldVille = new JTextField(25);
		}
		return textFieldVille;	
	}
	
	/**
	 * methode pour recup�rer le texte dans le input du numero
	 * @return textFieldNumero
	 */
	public JTextField getTextFieldNumero() {
		if(textFieldNum == null){
			textFieldNum = new JTextField(15);
		}
		return textFieldNum;	
	}
	
	/**
	 * methode pour recup�rer le texte dans le input de l'assurance
	 * @return textFieldAssurance
	 */
	public JTextField getTextFieldAssurance() {
		if(textFieldAssurance == null){
			textFieldAssurance = new JTextField(30);
		}
		return textFieldAssurance;		
	}
	
	/**
	 * methode pour recup�rer le texte dans le input du mail
	 * @return textFieldEmail
	 */
	public JTextField getTextFieldEmail() {
		if(textFieldEmail == null){
			textFieldEmail = new JTextField(20);
		}
		return textFieldEmail;	
	}
	
	/**
	 * methode pour recup�rer le texte dans le input de remarque
	 * @return textArea
	 */
	public TextArea getTextRemarque() {
		if(textAreaRemarque == null){
			textAreaRemarque = new TextArea();
		}
		return textAreaRemarque;	
	}


}
