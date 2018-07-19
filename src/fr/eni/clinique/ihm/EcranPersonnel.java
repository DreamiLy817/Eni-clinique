package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultCaret;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAO;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.DAOPersonnel;

public class EcranPersonnel extends JFrame {

	private JButton ajouterButton;
	private JButton supprimerButton;
	private JButton reinitialiserButton;
	private JTextField zoneTextePass = new JTextField(20);
	private JButton buttonAnnuler;
	private JButton buttonOk;
	private JLabel labelUtilisateur = new JLabel("Utilisateur:");
	private JTextField zoneTexteUtilisateur = new JTextField(20);
	private JLabel labelNewPass = new JLabel("Mot de passe:");
	private JTextField zoneTexteRole = new JTextField(20);
	private JLabel labelNewRole = new JLabel("Rôle:");
	DAO<Personnel> loginDAO = DAOFactory.getPersonnelDAO();

	private JButton getSupprimerButton() {
		if (supprimerButton == null) {
			supprimerButton = new JButton("Supprimer");
		}
		return supprimerButton;
	}

	private JButton getOkButton() {
		if (buttonOk == null) {
			buttonOk = new JButton("Ok");
			buttonOk.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String tamponNom = zoneTexteUtilisateur.getText();
					String tamponPass = zoneTextePass.getText();
					String tamponRole = zoneTexteRole.getText();
					Personnel nouveau = null;
					nouveau.setMotPasse(tamponPass);
					nouveau.setNom(tamponNom);
					nouveau.setRole(tamponRole);
					nouveau.setArchive(false);
					try {
						System.out.println(nouveau.getNom().toString());
						loginDAO.insert(nouveau);
					} catch (DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
		}
		return buttonOk;
	}

	private JButton getAnnulerButton() {
		if (buttonAnnuler == null) {
			buttonAnnuler = new JButton("Annuler");
			buttonAnnuler.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					 getContentPane().removeAll(); //gets rid of first panel
				     getContentPane().add(rootPane); //adds desired panel to frame
				      validate();

				}
			});
		}
		return buttonAnnuler;
	}

	public void createFrameAjouter() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Ajout d'utilisateur");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				JPanel panelAjout = new JPanel();
				panelAjout.setLayout(new GridBagLayout());
				GridBagConstraints gbc = new GridBagConstraints();
				panelAjout.setOpaque(true);
				frame.getContentPane().add(BorderLayout.CENTER, panelAjout);
				frame.setVisible(true);
				frame.setResizable(true);

				// Création du panel AjoutUtilisateur
				gbc.gridx = 0;
				gbc.gridy = 0;
				panelAjout.add(labelUtilisateur, gbc);
				gbc.gridx = 1;
				gbc.gridy = 0;
				panelAjout.add(zoneTexteUtilisateur, gbc);
				gbc.gridx = 0;
				gbc.gridy = 1;
				panelAjout.add(labelNewPass, gbc);
				gbc.gridx = 1;
				gbc.gridy = 1;
				panelAjout.add(zoneTextePass, gbc);
				gbc.gridx = 0;
				gbc.gridy = 2;
				panelAjout.add(labelNewRole, gbc);
				gbc.gridx = 1;
				gbc.gridy = 2;
				panelAjout.add(zoneTexteRole, gbc);
				gbc.gridx = 0;
				gbc.gridy = 3;
				panelAjout.add(getOkButton(), gbc);
				gbc.gridx = 1;
				gbc.gridy = 3;
				panelAjout.add(getAnnulerButton(), gbc);
			}
		});
	}

	public void createFrameReinit() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Test");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				panel.setOpaque(true);
				JTextArea textArea = new JTextArea(15, 50);
				textArea.setWrapStyleWord(true);
				textArea.setEditable(false);
				textArea.setFont(Font.getFont(Font.SANS_SERIF));
				JScrollPane scroller = new JScrollPane(textArea);
				scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				JPanel inputpanel = new JPanel();
				inputpanel.setLayout(new FlowLayout());
				JTextField input = new JTextField(20);
				JButton button = new JButton("Enter");
				DefaultCaret caret = (DefaultCaret) textArea.getCaret();
				caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
				panel.add(scroller);
				inputpanel.add(input);
				inputpanel.add(button);
				panel.add(inputpanel);
				frame.getContentPane().add(BorderLayout.CENTER, panel);
				frame.pack();
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
				frame.setResizable(false);
				input.requestFocus();
			}
		});
	}

	private JButton getReinitialiserButton() {
		if (reinitialiserButton == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/89647-200.png")));
			reinitialiserButton = new JButton(image);
			reinitialiserButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					createFrameReinit();

				}
			});
		}
		return reinitialiserButton;
	}

	private JButton getAjouterButton() {
		if (ajouterButton == null) {
			ajouterButton = new JButton("Ajouter");
			ajouterButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					createFrameAjouter();

				}
			});
		}
		return ajouterButton;
	}

	public EcranPersonnel() {
		super();
		try {
			initIHM();
		} catch (DALException e) {
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

		// Préparation des données à mettre dans la JTable
		DAO<Personnel> personnelDAO = DAOFactory.getPersonnelDAO();
		List<Personnel> catalogue = personnelDAO.selectAll();
		// List<String[]> lignes = new ArrayList<String[]>();
		final String[] colonne = new String[] { "Nom", "Rôle", "Mot de Passe" };
		int taille = catalogue.size();
		final String[][] data = new String[taille][3];
		int i = 0;
		for (Personnel employe : catalogue) {
			String tamponNom = employe.getNom();
			String tamponRole = employe.getRole();
			String tamponPass = employe.getMotPasse();
			data[i][0] = tamponNom;
			data[i][1] = tamponRole;
			data[i][2] = tamponPass;
			i++;
		}
		// TODO Essayer de masquer le mot de passe des utilisateurs
		// Création d'un modèle personnalisé de JTable
		TableModel tableModel = new DefaultTableModel(data, colonne);
		JTable table = new JTable(tableModel);

		// Intégration de la table dans le panneau principal
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
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelPrincipal.add(panelTable, gbc);
		this.setContentPane(panelPrincipal);
	}
}
