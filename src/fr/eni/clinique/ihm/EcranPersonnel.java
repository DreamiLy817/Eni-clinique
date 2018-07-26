package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelMger;
import fr.eni.clinique.bo.Personnel;

@SuppressWarnings("serial")
public class EcranPersonnel extends JFrame {

	private JButton ajouterButton;
	private JButton supprimerButton;
	private JButton reinitialiserButton;
	private JTextField zoneTextePass = new JTextField(20);
	private JPasswordField zoneTexteNouveauPass = new JPasswordField(20);
	private JTextField zoneTextePrenom = new JTextField(20);
	private JButton buttonAnnuler;
	private JButton buttonOkAjout;
	private JButton buttonOkReinit;
	private JLabel labelUtilisateur = new JLabel("Nom:");
	private JLabel labelNewPassword = new JLabel("Nouveau mot de passe:");
	private JLabel labelPrenom = new JLabel("Prénom:");
	private JTextField zoneTexteUtilisateur = new JTextField(20);
	private JLabel labelNewPass = new JLabel("Mot de passe:");
	private JTextField zoneTexteRole = new JTextField(20);
	private JLabel labelNewRole = new JLabel("Rôle:");
	private JFrame frame = new JFrame("Ajout d'utilisateur");
	private JFrame frame1 = new JFrame("Reinitialisation du mot de passe");
	private PersonnelMger pm = PersonnelMger.getInstance();
	private String selectTable = new String();
	private String tampon = new String();
	private JTable table;
	private int recupRow = 0;
	private JPanel panelTable;

	private JButton getSupprimerButton() {
		if (supprimerButton == null) {
			supprimerButton = new JButton("Supprimer");
			supprimerButton.setBackground(new Color(0, 204, 153));
			supprimerButton.setForeground(Color.WHITE);
			supprimerButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selectTable = table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
					try {
						pm.archivagePersonnel(pm.selectNomID(selectTable));
						deleteRow();
						JOptionPane.showMessageDialog(EcranPersonnel.this, "Archivage d'un employé effectué");
					} catch (BLLException e1) {
						JOptionPane.showMessageDialog(EcranPersonnel.this, "Echec de l'archivage d'un employé" + e1.getMessage());
						e1.printStackTrace();
					}
				}
			});
		}
		return supprimerButton;
	}

	private JButton getOkButton() {
		if (buttonOkAjout == null) {
			buttonOkAjout = new JButton("Valider");
			buttonOkAjout.setBackground(new Color(0, 204, 153));
			buttonOkAjout.setForeground(Color.WHITE);
			buttonOkAjout.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String tamponNom = zoneTexteUtilisateur.getText();
					String tamponPrenom = zoneTextePrenom.getText();
					String tamponPass = zoneTextePass.getText();
					String tamponRole = zoneTexteRole.getText();
					Personnel nouveau = new Personnel();
					nouveau.setMotPasse(tamponPass);
					nouveau.setNom(tamponNom);
					nouveau.setPrenom(tamponPrenom);
					nouveau.setRole(tamponRole);
					nouveau.setArchive(false);
					try {
						System.out.println(nouveau.getNom().toString());
						pm.ajoutPersonnel(nouveau);
						addRow(tamponNom, tamponRole);
						JOptionPane.showMessageDialog(EcranPersonnel.this, "Ajout d'un nouvel employé effectué");
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(EcranPersonnel.this, "Echec de l'ajout d'un nouvel employé" + e1.getMessage());
						e1.printStackTrace();
					}

				}
			});
		}
		return buttonOkAjout;
	}

	private JButton getAnnulerButton() {
		if (buttonAnnuler == null) {
			buttonAnnuler = new JButton("Annuler");
			buttonAnnuler.setBackground(new Color(0, 204, 153));
			buttonAnnuler.setForeground(Color.WHITE);
			buttonAnnuler.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();

				}
			});
		}
		return buttonAnnuler;
	}

	public void createFrameAjouter() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(EcranPersonnel.this, "Echec lors de l'initialisation de la fenêtre" + e.getMessage());
					e.printStackTrace();
				}
				JPanel panelAjout = new JPanel();
				panelAjout.setLayout(new GridBagLayout());
				GridBagConstraints gbc = new GridBagConstraints();
				panelAjout.setOpaque(true);
				frame.getContentPane().add(BorderLayout.CENTER, panelAjout);
				frame.setSize(500, 300);
				frame.setVisible(true);
				frame.setResizable(false);

				// Création du panel AjoutUtilisateur
				gbc.gridx = 0;
				gbc.gridy = 0;
				panelAjout.add(labelUtilisateur, gbc);
				gbc.gridx = 1;
				gbc.gridy = 0;
				panelAjout.add(zoneTexteUtilisateur, gbc);
				gbc.gridx = 0;
				gbc.gridy = 1;
				panelAjout.add(labelPrenom, gbc);
				gbc.gridx = 1;
				gbc.gridy = 1;
				panelAjout.add(zoneTextePrenom, gbc);
				gbc.gridx = 0;
				gbc.gridy = 2;
				panelAjout.add(labelNewPass, gbc);
				gbc.gridx = 1;
				gbc.gridy = 2;
				panelAjout.add(zoneTextePass, gbc);
				gbc.gridx = 0;
				gbc.gridy = 3;
				panelAjout.add(labelNewRole, gbc);
				gbc.gridx = 1;
				gbc.gridy = 3;
				panelAjout.add(zoneTexteRole, gbc);
				gbc.gridx = 0;
				gbc.gridy = 4;
				panelAjout.add(getOkButton(), gbc);
				gbc.gridx = 1;
				gbc.gridy = 4;
				panelAjout.add(getAnnulerButton(), gbc);
			}

		});
	}

	public void createFrameReinit() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(EcranPersonnel.this, "Echec lors de l'initialisation de la fenêtre" + e.getMessage());
					e.printStackTrace();
				}
				JPanel panelReinit = new JPanel();
				panelReinit.setLayout(new GridBagLayout());
				GridBagConstraints gbc = new GridBagConstraints();
				panelReinit.setOpaque(true);
				frame1.getContentPane().add(BorderLayout.CENTER, panelReinit);
				frame1.setSize(500, 500);
				frame1.setVisible(true);
				frame1.setResizable(false);

				// Création du panel Réinitialiser Mot de Passe
				gbc.gridx = 0;
				gbc.gridy = 0;
				panelReinit.add(labelNewPassword);
				gbc.gridx = 1;
				gbc.gridy = 0;
				panelReinit.add(zoneTexteNouveauPass);
				gbc.gridx = 0;
				gbc.gridy = 1;
				gbc.gridwidth = 2;
				panelReinit.add(getbuttonOkReinit());

			}
		});
	}

	private JButton getbuttonOkReinit() {
		if (buttonOkReinit == null) {
			buttonOkReinit = new JButton("Valider");
			buttonOkReinit.setBackground(new Color(0, 204, 153));
			buttonOkReinit.setForeground(Color.WHITE);
			
			buttonOkReinit.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					selectTable = table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
					if (selectTable != null) {
						tampon = zoneTexteNouveauPass.getText();
						try {
							pm.changementPasse(pm.selectNom(selectTable), tampon);
						} catch (BLLException e1) {
							JOptionPane.showMessageDialog(EcranPersonnel.this, "Echec lors de la réinitialisation du mot de passe" + e1.getMessage());
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(EcranPersonnel.this,
								"Veuillez selectionner un employé dans la liste avant de changer son mot de passe.");
					}
				}
			});
		}
		return buttonOkReinit;
	}

	private JButton getReinitialiserButton() {
		if (reinitialiserButton == null) {
			reinitialiserButton = new JButton();
			reinitialiserButton.setBackground(new Color(0, 204, 153));
			reinitialiserButton.setForeground(Color.WHITE);
			reinitialiserButton.setIcon(new ImageIcon(EcranClientRecherche.class.getResource("/images/refresh.png")));
			reinitialiserButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					createFrameReinit();

				}
			});
		}
		return reinitialiserButton;
	}

	private JButton getAjouterButton() {
		if (ajouterButton == null) {
			ajouterButton = new JButton("Ajouter");
			ajouterButton.setBackground(new Color(0, 204, 153));
			ajouterButton.setForeground(Color.WHITE);
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
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
		this.setIconImage(img.getImage());
		try {
			setBounds(100,100,600,700);
			initIHM();
		} catch (BLLException e) {
			JOptionPane.showMessageDialog(EcranPersonnel.this,
					"Echec de l'affichage de la fenêtre, veuillez contacter Leslie pour un débugage en règle" + e.getMessage());
			e.printStackTrace();
		}
	}

	private void initIHM() throws BLLException {
		// Initialisation de l'IHM, déclaration des panneaux
		JPanel panelPrincipal = new JPanel();
		JPanel panelBoutons = new JPanel();
		panelTable = new JPanel();
		panelPrincipal.setOpaque(false);
		panelPrincipal.setLayout(new GridBagLayout());
		panelBoutons.setOpaque(false);
		panelBoutons.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		updateTable();
		table.setDefaultEditor(Object.class, null);

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

	public void addRow(String a, String b) throws BLLException {
		((DefaultTableModel) table.getModel()).addRow(new Object[] { a, b, "*****" });
	}

	public void deleteRow() throws BLLException {
		recupRow = table.getSelectedRow();
		((DefaultTableModel) table.getModel()).removeRow(recupRow);
	}

	public void updateTable() throws BLLException {
		List<Personnel> catalogue = pm.affichagePersonnel();
		final String[] colonne = new String[] { "Nom", "Rôle", "Mot de Passe" };
		int taille = catalogue.size();
		final String[][] data = new String[taille][3];
		int i = 0;
		for (Personnel employe : catalogue) {
			String tamponNom = employe.getNom();
			String tamponRole = employe.getRole();
			String tamponPass = "*****";
			data[i][0] = tamponNom;
			data[i][1] = tamponRole;
			data[i][2] = tamponPass;
			i++;
		}
		// Création d'un modèle personnalisé de JTable
		TableModel tableModel = new DefaultTableModel(data, colonne);
		table = new JTable(tableModel);
	}
}
