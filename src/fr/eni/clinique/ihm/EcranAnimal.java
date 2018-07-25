package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import fr.eni.clinique.bll.AnimalMger;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;

import java.awt.Panel;
import javax.swing.SwingConstants;

public class EcranAnimal extends JFrame {

	private JPanel contentPane;
	private JTextField textClient;
	private JTextField textNom;
	private JTextField textCouleur;
	private JTextField textTatouage;
	private JButton boutonValider;
	private JButton boutonAnnuler;
	private JLabel lblCode;
	private JLabel labelCodeAnimal;
	private JLabel lblNom;
	private JLabel label;
	private JLabel lblCouleur;
	private JLabel lblEspece;
	private JLabel lblRace;
	private JLabel lblTatouage;
	private JComboBox sexeComboBox;
	private JComboBox especeComboBox;
	private JComboBox raceComboBox;
	private Client client;
	private Animal animal;
	private AnimalMger animalMger = AnimalMger.getInstance();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranAnimal frame = new EcranAnimal(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JButton getBoutonValider() {
		if (boutonValider == null) {
			boutonValider = new JButton("Valider");
			boutonValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					char tamponSexe;
					String tamponNomAnimal = textNom.getText();
					String tamponCouleur = textCouleur.getText();
					String tamponEspece = ((String) especeComboBox.getSelectedItem());
					String tamponRace = ((String) raceComboBox.getSelectedItem());
					String tamponTatouage = textTatouage.getText();
					int tamponCodeClient = client.getCodeClient();
					if (((String) sexeComboBox.getSelectedItem()) == "Male") {
						tamponSexe = 'M';
					} else {
						tamponSexe = 'F';
					}
					Animal nouvelAnimal = new Animal(tamponNomAnimal, tamponSexe, tamponCouleur, tamponRace, tamponEspece, tamponCodeClient, tamponTatouage);
					try {
						animalMger.ajoutAnimal(nouvelAnimal);
						JOptionPane.showMessageDialog(EcranAnimal.this, "Ajout effectué");
					} catch (BLLException e1) {
						JOptionPane.showMessageDialog(EcranAnimal.this, "Erreur lors de l'ajout d'un animal");
						e1.printStackTrace();
					}
				}
			});
		}
		return boutonValider;
	}

	public JButton getBoutonAnnuler() {
		if (boutonAnnuler == null) {
			boutonAnnuler = new JButton("Annuler");
		}
		return boutonAnnuler;
	}

	public JTextField getTextClient() {
		if (textClient == null) {
			textClient = new JTextField();
			textClient.setEnabled(false);
		}

		return textClient;
	}

	public JTextField getTextNom() {
		if (textNom == null) {
			textNom = new JTextField();
		}
		return textNom;
	}

	public JTextField getTextCouleur() {
		if (textCouleur == null) {
			textCouleur = new JTextField();
		}

		return textCouleur;
	}

	public JTextField getTextTatouage() {
		if (textTatouage == null) {
			textTatouage = new JTextField();
		}

		return textTatouage;
	}

	public JLabel getLblCode() {
		if (lblCode == null) {
			lblCode = new JLabel("Code");
		}

		return lblCode;
	}

	public JLabel getLabelCodeAnimal() {
		if (labelCodeAnimal == null) {
			labelCodeAnimal = new JLabel("Code Animal");
		}

		return labelCodeAnimal;
	}

	public JLabel getLblNom() {
		if (lblNom == null) {
			lblNom = new JLabel("Nom");
		}

		return lblNom;
	}

	public JLabel getLabel() {
		if (label == null) {

			label = new JLabel("");

		}

		return label;
	}

	public JLabel getLblCouleur() {
		if (lblCouleur == null) {
			lblCouleur = new JLabel("Couleur");
		}

		return lblCouleur;
	}

	public JLabel getLblEspece() {
		if (lblEspece == null) {
			lblEspece = new JLabel("Espece");
		}

		return lblEspece;
	}

	public JLabel getLblRace() {
		if (lblRace == null) {
			lblRace = new JLabel("Race");
		}

		return lblRace;
	}

	public JLabel getLblTatouage() {
		if (lblTatouage == null) {
			lblTatouage = new JLabel("Tatouage");
		}

		return lblTatouage;
	}

	public JComboBox getSexeComboBox() {
		if (sexeComboBox == null) {
			String[] listeSexe = { "Male", "Femelle" };
			sexeComboBox = new JComboBox<String>(listeSexe);
		}
		return sexeComboBox;
	}

	public JComboBox getEspeceComboBox() {
		if (especeComboBox == null) {
			try {
				List<String> listeEspece = null;
				listeEspece = animalMger.recupListeEspece();
				String[] tabEspece = listeEspece.toArray(new String[0]);
				especeComboBox = new JComboBox<String>(tabEspece);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return especeComboBox;
	}

	public JComboBox getRaceComboBox() {
		if (raceComboBox == null) {
			try {
				List<String> listeRace = null;
				listeRace = animalMger.recupListeRace();
				String[] tabRace = listeRace.toArray(new String[0]);
				raceComboBox = new JComboBox<String>(tabRace);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return raceComboBox;
	}

	/**
	 * Create the frame.
	 * 
	 * @param animalSelectionne
	 */
	public EcranAnimal(Animal animalSelectionne, Client clientSelectionne) {
		client = clientSelectionne;
		animal = animalSelectionne;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 402);
		contentPane = new JPanel();
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 27, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		getBoutonValider().setForeground(new Color(0, 0, 0));
		getBoutonValider().setBackground(new Color(0, 204, 153));
		getBoutonValider().setIcon(new ImageIcon(EcranAnimal.class.getResource("/images/check.png")));
		GridBagConstraints gbc_boutonValider = new GridBagConstraints();
		gbc_boutonValider.fill = GridBagConstraints.HORIZONTAL;
		gbc_boutonValider.insets = new Insets(0, 0, 5, 5);
		gbc_boutonValider.gridx = 2;
		gbc_boutonValider.gridy = 1;
		contentPane.add(getBoutonValider(), gbc_boutonValider);

		getBoutonAnnuler().setForeground(new Color(0, 0, 0));
		getBoutonAnnuler().setBackground(new Color(0, 204, 153));
		getBoutonAnnuler().setIcon(new ImageIcon(EcranAnimal.class.getResource("/images/back.png")));
		GridBagConstraints gbc_boutonAnnuler = new GridBagConstraints();
		gbc_boutonAnnuler.fill = GridBagConstraints.HORIZONTAL;
		gbc_boutonAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_boutonAnnuler.gridx = 7;
		gbc_boutonAnnuler.gridy = 1;
		contentPane.add(getBoutonAnnuler(), gbc_boutonAnnuler);

		getTextClient().setOpaque(true);
		getTextClient().setHorizontalAlignment(SwingConstants.CENTER);
		getTextClient().setForeground(new Color(0, 0, 0));
		getTextClient().setBackground(new Color(255, 255, 255));
		getTextClient().setBorder(
				new TitledBorder(null, "Client", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 204, 153)));
		GridBagConstraints gbc_textClient = new GridBagConstraints();
		gbc_textClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textClient.gridwidth = 6;
		gbc_textClient.insets = new Insets(0, 0, 5, 5);
		gbc_textClient.gridx = 2;
		gbc_textClient.gridy = 2;
		contentPane.add(getTextClient(), gbc_textClient);
		getTextClient().setColumns(10);

		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.WEST;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 2;
		gbc_lblCode.gridy = 4;
		contentPane.add(getLblCode(), gbc_lblCode);

		GridBagConstraints gbc_labelCodeAnimal = new GridBagConstraints();
		gbc_labelCodeAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_labelCodeAnimal.gridx = 3;
		gbc_labelCodeAnimal.gridy = 4;
		contentPane.add(getLabelCodeAnimal(), gbc_labelCodeAnimal);

		GridBagConstraints gbc_sexeComboBox = new GridBagConstraints();
		gbc_sexeComboBox.gridwidth = 3;
		gbc_sexeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_sexeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_sexeComboBox.gridx = 5;
		gbc_sexeComboBox.gridy = 4;
		contentPane.add(getSexeComboBox(), gbc_sexeComboBox);

		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.WEST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 2;
		gbc_lblNom.gridy = 5;
		contentPane.add(getLblNom(), gbc_lblNom);

		GridBagConstraints gbc_textNom = new GridBagConstraints();
		gbc_textNom.gridwidth = 5;
		gbc_textNom.insets = new Insets(0, 0, 5, 5);
		gbc_textNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNom.gridx = 3;
		gbc_textNom.gridy = 5;
		contentPane.add(getTextNom(), gbc_textNom);
		textNom.setColumns(10);

		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 6;
		contentPane.add(getLabel(), gbc_label);

		GridBagConstraints gbc_lblCouleur = new GridBagConstraints();
		gbc_lblCouleur.anchor = GridBagConstraints.WEST;
		gbc_lblCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouleur.gridx = 2;
		gbc_lblCouleur.gridy = 7;
		contentPane.add(getLblCouleur(), gbc_lblCouleur);

		GridBagConstraints gbc_textCouleur = new GridBagConstraints();
		gbc_textCouleur.gridwidth = 5;
		gbc_textCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_textCouleur.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCouleur.gridx = 3;
		gbc_textCouleur.gridy = 7;
		contentPane.add(getTextCouleur(), gbc_textCouleur);
		textCouleur.setColumns(10);

		GridBagConstraints gbc_lblEspece = new GridBagConstraints();
		gbc_lblEspece.anchor = GridBagConstraints.WEST;
		gbc_lblEspece.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspece.gridx = 2;
		gbc_lblEspece.gridy = 8;
		contentPane.add(getLblEspece(), gbc_lblEspece);

		GridBagConstraints gbc_especeComboBox = new GridBagConstraints();
		gbc_especeComboBox.gridwidth = 2;
		gbc_especeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_especeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_especeComboBox.gridx = 3;
		gbc_especeComboBox.gridy = 8;
		contentPane.add(getEspeceComboBox(), gbc_especeComboBox);

		GridBagConstraints gbc_lblRace = new GridBagConstraints();
		gbc_lblRace.anchor = GridBagConstraints.EAST;
		gbc_lblRace.insets = new Insets(0, 0, 5, 5);
		gbc_lblRace.gridx = 5;
		gbc_lblRace.gridy = 8;
		contentPane.add(getLblRace(), gbc_lblRace);

		getRaceComboBox().setBorder(UIManager.getBorder("Button.border"));
		GridBagConstraints gbc_raceComboBox = new GridBagConstraints();
		gbc_raceComboBox.gridwidth = 2;
		gbc_raceComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_raceComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_raceComboBox.gridx = 6;
		gbc_raceComboBox.gridy = 8;
		contentPane.add(getRaceComboBox(), gbc_raceComboBox);

		GridBagConstraints gbc_lblTatouage = new GridBagConstraints();
		gbc_lblTatouage.anchor = GridBagConstraints.WEST;
		gbc_lblTatouage.insets = new Insets(0, 0, 5, 5);
		gbc_lblTatouage.gridx = 2;
		gbc_lblTatouage.gridy = 9;
		contentPane.add(getLblTatouage(), gbc_lblTatouage);

		GridBagConstraints gbc_textTatouage = new GridBagConstraints();
		gbc_textTatouage.gridwidth = 5;
		gbc_textTatouage.insets = new Insets(0, 0, 5, 5);
		gbc_textTatouage.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTatouage.gridx = 3;
		gbc_textTatouage.gridy = 9;
		contentPane.add(getTextTatouage(), gbc_textTatouage);
		getTextTatouage().setColumns(10);
	}

}
