package fr.eni.clinique.ihm;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOAnimal;
import fr.eni.clinique.dal.DAOFactory;

public class EcranAnimaux extends JFrame {
	private DAOAnimal animalDAO = DAOFactory.getDAOAnimal();
	// Déclaration des boutons, variables, zone de textes
	private JButton boutonValider;
	private JButton boutonAnnuler;
	private JLabel labelNom;
	private JLabel labelClient;
	private JLabel labelEspece;
	private JLabel labelRace;
	private JLabel labelCode;
	private JLabel labelCodeAnimal;
	private JLabel labelCouleur;
	private JLabel labelTatouage;
	private JTextField textNom;
	private JTextField textClient;
	private JTextField textCouleur;
	private JTextField textTatouage;
	JComboBox<String> sexeComboBox;
	JComboBox<String> especeComboBox;
	JComboBox<String> raceComboBox;
	private JFrame frame = new JFrame("Ajout d'utilisateur");

	// Mise en place d'un main
	/**
	 * Fonction en charge d'afficher l'écran
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame ecranAnimaux = new EcranAnimaux();
					ecranAnimaux.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Labels
	/**
	 * Fonction en charge de créer un nouveau Label s'il n'existe pas déjà
	 * 
	 * @return labelClient
	 */
	public JLabel getLabelClient() {
		if (labelClient == null) {
			labelClient = new JLabel("Client");
		}
		return labelClient;
	}

	/**
	 * Fonction en charge de créer un nouveau Label s'il n'existe pas déjà
	 * 
	 * @return labelNom
	 */
	public JLabel getLabelNom() {
		if (labelNom == null) {
			labelNom = new JLabel("Nom");
		}
		return labelNom;
	}

	/**
	 * Fonction en charge de créer un nouveau Label s'il n'existe pas déjà
	 * 
	 * @return labelEspece
	 */
	public JLabel getLabelEspece() {
		if (labelEspece == null) {
			labelEspece = new JLabel("Espèce");
		}
		return labelEspece;
	}

	/**
	 * Fonction en charge de créer un nouveau Label s'il n'existe pas déjà
	 * 
	 * @return labelRace
	 */
	public JLabel getLabelRace() {
		if (labelRace == null) {
			labelRace = new JLabel("Race");
		}
		return labelRace;
	}
	
	public JLabel getLabelCode() {
		if (labelCode == null) {
			labelCode = new JLabel("Code");
		}
		return labelCode;
	}
	
	// TODO Ajouter le code de l'animal dans le label
	public JLabel getLabelCodeAnimal() {
		if (labelCodeAnimal == null) {
			labelCodeAnimal = new JLabel("LeCodeDeL'Animal");
		}
		return labelCodeAnimal;
	}
	
	public JLabel getLabelCouleur() {
		if (labelCouleur == null) {
			labelCouleur = new JLabel("Couleur");
		}
		return labelCouleur;
	}
	
	public JLabel getLabelTatouage() {
		if (labelTatouage == null) {
			labelTatouage = new JLabel("Tatouage");
		}
		return labelTatouage;
	}

	// TextFields
	/**
	 * Fonction en charge de créer un nouveau TextField s'il n'existe pas déjà
	 * 
	 * @return textClient
	 */
	public JTextField getTextClient() {
		if (textClient == null) {
			textClient = new JTextField(60);
		}
		return textClient;
	}

	/**
	 * Fonction en charge de créer un nouveau TextField s'il n'existe pas déjà
	 * 
	 * @return textNom
	 */
	public JTextField getTextNom() {
		if (textNom == null) {
			textNom = new JTextField(20);
		}
		return textNom;
	}
	
	/**
	 * Fonction en charge de créer un nouveau TextField s'il n'existe pas déjà
	 * 
	 * @return textCouleur
	 */
	public JTextField getTextCouleur() {
		if (textCouleur == null) {
			textCouleur = new JTextField(20);
		}
		return textCouleur;
	}
	
	/**
	 * Fonction en charge de créer un nouveau TextField s'il n'existe pas déjà
	 * 
	 * @return textTatouage
	 */
	public JTextField getTextTatouage() {
		if (textTatouage == null) {
			textTatouage = new JTextField(20);
		}
		return textTatouage;
	}

	// Boutons
	/**
	 * Fonction en charge de créer un nouveau bouton s'il n'exise pas déjà
	 * 
	 * @return boutonAnnuler
	 */
	public JButton getBoutonAnnuler() {
		if (boutonAnnuler == null) {
			boutonAnnuler = new JButton("Annuler");
			boutonAnnuler.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return boutonAnnuler;
	}

	/**
	 * Fonction en charge de créer un nouveau bouton s'il n'existe pas déjà
	 * 
	 * @return boutonValider
	 */
	public JButton getBoutonValider() {
		if (boutonValider == null) {
			boutonValider = new JButton("Valider");
			boutonValider.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		return boutonValider;
	}

	// ComboBox
	/**
	 * Fonction en charge de créer une nouvelle ComboBox
	 * 
	 * @return sexeComboBox
	 */
	public JComboBox<String> getRaceComboBox() {
		if (raceComboBox == null) {
			try {
				List<String> listeRace = null;
				listeRace = animalDAO.getRaceList();
				String[] tabRace = listeRace.toArray(new String[0]);
				raceComboBox = new JComboBox<String>(tabRace);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return raceComboBox;
	}

	/**
	 * Fonction en charge de créer une nouvelle ComboBox
	 * 
	 * @return sexeComboBox
	 */
	public JComboBox<String> getEspeceComboBox() {
		if (especeComboBox == null) {
			try {
				List<String> listeEspece = null;
				listeEspece = animalDAO.getEspeceList();
				String[] tabEspece = listeEspece.toArray(new String[0]);
				especeComboBox = new JComboBox<String>(tabEspece);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return especeComboBox;
	}

	/**
	 * Fonction en charge de créer une nouvelle ComboBox
	 * 
	 * @return sexeComboBox
	 */
	public JComboBox<String> getSexeComboBox() {
		if (sexeComboBox == null) {
			String[] listeSexe = { "Mâle", "Femelle" };
			sexeComboBox = new JComboBox<String>(listeSexe);
		}
		return sexeComboBox;
	}

	/**
	 * Constructeur de l'affichage de la fenêtre Ajout/Modification des animaux
	 */
	public EcranAnimaux() {
		super();
		initIHM();
	}

	// Initiation IHM
	private void initIHM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 750);
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridBagLayout());
		panelPrincipal.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();

		// Panel Boutons Valider & Supprimer
		JPanel panelBoutons = new JPanel();
		panelBoutons.setLayout(new GridBagLayout());
		panelBoutons.setOpaque(false);
		gbc.gridx = 3;
		gbc.gridy = 0;
		panelBoutons.add(getBoutonValider(), gbc);
		gbc.gridx = 4;
		gbc.gridy = 0;
		panelBoutons.add(getBoutonAnnuler(), gbc);

		// Panel Client & Text
		JPanel panelClientTexte = new JPanel();
		panelClientTexte.setLayout(new GridBagLayout());
		panelClientTexte.setOpaque(false);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panelClientTexte.add(getLabelClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panelClientTexte.add(getTextClient(), gbc);

		// Panel Nom & Sexe
		JPanel panelNomSexe = new JPanel();
		panelNomSexe.setLayout(new GridBagLayout());
		panelNomSexe.setOpaque(false);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panelNomSexe.add(getLabelNom(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		panelNomSexe.add(getTextNom(), gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		panelNomSexe.add(getSexeComboBox(), gbc);

		// Panel Espece & Race
		JPanel panelEspeceRace = new JPanel();
		panelEspeceRace.setLayout(new GridBagLayout());
		panelEspeceRace.setOpaque(false);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panelEspeceRace.add(getLabelEspece(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panelEspeceRace.add(getEspeceComboBox(), gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		panelEspeceRace.add(getLabelRace(), gbc);
		gbc.gridx = 3;
		gbc.gridy = 0;
		panelEspeceRace.add(getRaceComboBox(), gbc);

		// Panel principal
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panelPrincipal.add(panelBoutons, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		//gbc.gridheight = 2;
		gbc.gridwidth = 4;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panelPrincipal.add(panelClientTexte, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panelPrincipal.add(getLabelCode(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelPrincipal.add(getLabelCodeAnimal(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
//		gbc.gridwidth = 4;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panelPrincipal.add(panelNomSexe, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panelPrincipal.add(getLabelCouleur(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelPrincipal.add(getTextCouleur(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
//		gbc.gridwidth = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panelPrincipal.add(panelEspeceRace, gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panelPrincipal.add(getLabelTatouage(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panelPrincipal.add(getTextTatouage(), gbc);
		this.setContentPane(panelPrincipal);
	}
}
