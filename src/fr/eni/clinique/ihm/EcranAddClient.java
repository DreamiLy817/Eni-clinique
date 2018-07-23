package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAO;
import fr.eni.clinique.dal.DAOClient;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.DAOPersonnel;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

/**
 * @author lbaltimore2017
 *
 */
public class EcranAddClient extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodeClient;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse1;
	private JTextField textFieldAdresse2;
	private JTextField textFieldCodePostal;
	private JTextField textFieldVille;
	private JTextField textFieldNumero;
	private JTextField textFieldAssurance;
	private JTextField textFieldEmail;
	
	private DAO<Client> clientDAO = DAOFactory.getClientDAO();
	private DAOClient clientDAO1 = DAOFactory.getDAOClient();
	
	private TextArea textArea;
	
	/**
	 * Create the frame.
	 */
	/**
	 * 
	 */
	public EcranAddClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client clientAjoute = new Client(getTextFieldNom().getText(), getTextFieldPrenom().getText(), getTextFieldAdresse1().getText(), getTextFieldAdresse2().getText(), getTextFieldCodePostal().getText(), getTextFieldVille().getText(), getTextFieldNumero().getText(), getTextFieldAssurance().getText(), getTextFieldEmail().getText(), getTextArea().getText(), false);
				try {
					clientDAO.insert(clientAjoute);
					System.out.println("je passe");
						JOptionPane.showMessageDialog(EcranAddClient.this, "Le client a ete ajoute");
						EcranClientPrincipal ecranP = new EcranClientPrincipal(clientAjoute);
						ecranP.setVisible(true);
						ecranP.getTextFieldCodeClient().setText(String.valueOf(clientAjoute.getCodeClient()));
						ecranP.getTextFieldNom().setText(clientAjoute.getNomClient());
						ecranP.getTextFieldPrenom().setText(clientAjoute.getPrenomClient());
						ecranP.getTextFieldAdresse1().setText(clientAjoute.getAdresse1());
						ecranP.getTextFieldAdresse2().setText(clientAjoute.getAdresse2());
						ecranP.getTextFieldCodePostal().setText(clientAjoute.getCodePostal());
						ecranP.getTextFieldVille().setText(clientAjoute.getVille());
						ecranP.getTextFieldNumero().setText(clientAjoute.getNumTel());
						ecranP.getTextFieldAssurance().setText(clientAjoute.getAssurance());
						ecranP.getTextFieldEmail().setText(clientAjoute.getEmail());
						ecranP.getTextRemarque().setText(clientAjoute.getRemarque());
							
					
						//EcranAddClient.this.dispose();
				} catch (DALException e) {
					JOptionPane.showMessageDialog(EcranAddClient.this, "Le client n'a pas pu etre ajoute");
					e.printStackTrace();
				}
			}
		});
		btnValider.setForeground(new Color(255, 255, 255));
		btnValider.setBackground(new Color(0, 204, 153));
		btnValider.setIcon(new ImageIcon(EcranAddClient.class.getResource("/images/check.png")));
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 10;
		gbc_btnValider.gridy = 0;
		contentPane.add(btnValider, gbc_btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(255, 255, 255));
		btnAnnuler.setBackground(new Color(0, 204, 153));
		btnAnnuler.setIcon(new ImageIcon(EcranAddClient.class.getResource("/images/back.png")));
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnuler.gridx = 11;
		gbc_btnAnnuler.gridy = 0;
		contentPane.add(btnAnnuler, gbc_btnAnnuler);
		
		
		JLabel lblNom = new JLabel("Nom");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 2;
		gbc_lblNom.gridy = 3;
		contentPane.add(lblNom, gbc_lblNom);
		
		GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
		gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNom.gridx = 3;
		gbc_textFieldNom.gridy = 3;
		contentPane.add(getTextFieldNom(), gbc_textFieldNom);
		textFieldNom.setColumns(10);
	
		JLabel lblPrenom = new JLabel("Prenom");
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.anchor = GridBagConstraints.EAST;
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 2;
		gbc_lblPrenom.gridy = 4;
		contentPane.add(lblPrenom, gbc_lblPrenom);
		

		GridBagConstraints gbc_textFieldPrenom = new GridBagConstraints();
		gbc_textFieldPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenom.gridx = 3;
		gbc_textFieldPrenom.gridy = 4;
		contentPane.add(getTextFieldPrenom(), gbc_textFieldPrenom);
		textFieldPrenom.setColumns(10);

		
		JLabel lblAdresse = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.EAST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 2;
		gbc_lblAdresse.gridy = 5;
		contentPane.add(lblAdresse, gbc_lblAdresse);
		
		GridBagConstraints gbc_textFieldAdresse1 = new GridBagConstraints();
		gbc_textFieldAdresse1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse1.gridx = 3;
		gbc_textFieldAdresse1.gridy = 5;
		contentPane.add(getTextFieldAdresse1(), gbc_textFieldAdresse1);
		textFieldAdresse1.setColumns(10);
		
		
		GridBagConstraints gbc_textFieldAdresse2 = new GridBagConstraints();
		gbc_textFieldAdresse2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse2.gridx = 3;
		gbc_textFieldAdresse2.gridy = 6;
		contentPane.add(getTextFieldAdresse2(), gbc_textFieldAdresse2);
		textFieldAdresse2.setColumns(10);
		
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		GridBagConstraints gbc_lblCodePostal = new GridBagConstraints();
		gbc_lblCodePostal.anchor = GridBagConstraints.EAST;
		gbc_lblCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostal.gridx = 2;
		gbc_lblCodePostal.gridy = 7;
		contentPane.add(lblCodePostal, gbc_lblCodePostal);
		
		GridBagConstraints gbc_textFieldCodePostal = new GridBagConstraints();
		gbc_textFieldCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodePostal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodePostal.gridx = 3;
		gbc_textFieldCodePostal.gridy = 7;
		contentPane.add(getTextFieldCodePostal(), gbc_textFieldCodePostal);
		textFieldCodePostal.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville");
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.anchor = GridBagConstraints.EAST;
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.gridx = 2;
		gbc_lblVille.gridy = 8;
		contentPane.add(lblVille, gbc_lblVille);
		
		GridBagConstraints gbc_textFieldVille = new GridBagConstraints();
		gbc_textFieldVille.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVille.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVille.gridx = 3;
		gbc_textFieldVille.gridy = 8;
		contentPane.add(getTextFieldVille(), gbc_textFieldVille);
		textFieldVille.setColumns(10);
		
		
		JLabel lblNumero = new JLabel("Numero");
		GridBagConstraints gbc_lblNumero = new GridBagConstraints();
		gbc_lblNumero.anchor = GridBagConstraints.EAST;
		gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumero.gridx = 2;
		gbc_lblNumero.gridy = 9;
		contentPane.add(lblNumero, gbc_lblNumero);
		
		GridBagConstraints gbc_textFieldNumero = new GridBagConstraints();
		gbc_textFieldNumero.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumero.gridx = 3;
		gbc_textFieldNumero.gridy = 9;
		contentPane.add(getTextFieldNumero(), gbc_textFieldNumero);
		textFieldNumero.setColumns(10);
		
		
		JLabel lblAssurance = new JLabel("Assurance");
		GridBagConstraints gbc_lblAssurance = new GridBagConstraints();
		gbc_lblAssurance.anchor = GridBagConstraints.EAST;
		gbc_lblAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssurance.gridx = 2;
		gbc_lblAssurance.gridy = 10;
		contentPane.add(lblAssurance, gbc_lblAssurance);
		
		GridBagConstraints gbc_textFieldAssurance = new GridBagConstraints();
		gbc_textFieldAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAssurance.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAssurance.gridx = 3;
		gbc_textFieldAssurance.gridy = 10;
		contentPane.add(getTextFieldAssurance(), gbc_textFieldAssurance);
		textFieldAssurance.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 11;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 3;
		gbc_textFieldEmail.gridy = 11;
		contentPane.add(getTextFieldEmail(), gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblRemarque = new JLabel("Remarque");
		GridBagConstraints gbc_lblRemarque = new GridBagConstraints();
		gbc_lblRemarque.anchor = GridBagConstraints.EAST;
		gbc_lblRemarque.insets = new Insets(0, 0, 5, 5);
		gbc_lblRemarque.gridx = 2;
		gbc_lblRemarque.gridy = 12;
		contentPane.add(lblRemarque, gbc_lblRemarque);
		
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 3;
		gbc_textArea.gridy = 12;
		contentPane.add(getTextArea(), gbc_textArea);
	
	}
	
	/**
	 * @return textFieldNom
	 */
	public JTextField getTextFieldNom() {
		if(textFieldNom == null){
			textFieldNom = new JTextField(20);
		}
		return textFieldNom;
		
	}
	
	/**
	 * @return textFieldPrenom
	 */
	public JTextField getTextFieldPrenom() {
		if(textFieldPrenom == null){
			textFieldPrenom = new JTextField(20);
		}
		return textFieldPrenom;
		
	}
	
	/**
	 * @return textFieldAdresse1
	 */
	public JTextField getTextFieldAdresse1() {
		if(textFieldAdresse1 == null){
			textFieldAdresse1 = new JTextField(30);
		}
		return textFieldAdresse1;
		
	}
	
	/**
	 * @return textFieldAdresse2
	 */
	public JTextField getTextFieldAdresse2() {
		if(textFieldAdresse2 == null){
			textFieldAdresse2 = new JTextField(30);
		}
		return textFieldAdresse2;
		
	}
	
	/**
	 * @return textFieldCodePostal
	 */
	public JTextField getTextFieldCodePostal() {
		if(textFieldCodePostal == null){
			textFieldCodePostal = new JTextField(6);
		}
		return textFieldCodePostal;
	}
	
	/**
	 * @return textFieldVille
	 */
	public JTextField getTextFieldVille() {
		if(textFieldVille == null){
			textFieldVille = new JTextField(25);
		}
		return textFieldVille;	
	}
	
	/**
	 * @return textFieldNumero
	 */
	public JTextField getTextFieldNumero() {
		if(textFieldNumero == null){
			textFieldNumero = new JTextField(15);
		}
		return textFieldNumero;	
	}
	
	/**
	 * @return textFieldAssurance
	 */
	public JTextField getTextFieldAssurance() {
		if(textFieldAssurance == null){
			textFieldAssurance = new JTextField(30);
		}
		return textFieldAssurance;		
	}
	
	/**
	 * @return textFieldEmail
	 */
	public JTextField getTextFieldEmail() {
		if(textFieldEmail == null){
			textFieldEmail = new JTextField(20);
		}
		return textFieldEmail;	
	}
	
	/**
	 * @return textArea
	 */
	public TextArea getTextArea() {
		if(textArea == null){
			textArea = new TextArea();
		}
		return textArea;	
	}

}
