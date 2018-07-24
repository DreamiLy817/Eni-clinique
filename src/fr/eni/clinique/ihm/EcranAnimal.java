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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Panel;
import javax.swing.SwingConstants;

public class EcranAnimal extends JFrame {

	private JPanel contentPane;
	private JTextField textClient;
	private JTextField textNom;
	private JTextField textCouleur;
	private JTextField textTatouage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranAnimal frame = new EcranAnimal();
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
	public EcranAnimal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 402);
		contentPane = new JPanel();
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 27, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton boutonValider = new JButton("Valider");
		boutonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boutonValider.setForeground(new Color(0, 0, 0));
		boutonValider.setBackground(new Color(0, 204, 153));
		boutonValider.setIcon(new ImageIcon(EcranAnimal.class.getResource("/images/check.png")));
		GridBagConstraints gbc_boutonValider = new GridBagConstraints();
		gbc_boutonValider.fill = GridBagConstraints.HORIZONTAL;
		gbc_boutonValider.insets = new Insets(0, 0, 5, 5);
		gbc_boutonValider.gridx = 2;
		gbc_boutonValider.gridy = 1;
		contentPane.add(boutonValider, gbc_boutonValider);
		
		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.setForeground(new Color(0, 0, 0));
		boutonAnnuler.setBackground(new Color(0, 204, 153));
		boutonAnnuler.setIcon(new ImageIcon(EcranAnimal.class.getResource("/images/back.png")));
		GridBagConstraints gbc_boutonAnnuler = new GridBagConstraints();
		gbc_boutonAnnuler.fill = GridBagConstraints.HORIZONTAL;
		gbc_boutonAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_boutonAnnuler.gridx = 7;
		gbc_boutonAnnuler.gridy = 1;
		contentPane.add(boutonAnnuler, gbc_boutonAnnuler);
		
		textClient = new JTextField();
		textClient.setOpaque(true);
		textClient.setHorizontalAlignment(SwingConstants.CENTER);
		textClient.setForeground(new Color(0, 0, 0));
		textClient.setBackground(new Color(255, 255, 255));
		textClient.setEditable(false);
		textClient.setBorder(new TitledBorder(null, "Client", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 204, 153)));
		GridBagConstraints gbc_textClient = new GridBagConstraints();
		gbc_textClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textClient.gridwidth = 6;
		gbc_textClient.insets = new Insets(0, 0, 5, 5);
		gbc_textClient.gridx = 2;
		gbc_textClient.gridy = 2;
		contentPane.add(textClient, gbc_textClient);
		textClient.setColumns(10);
		
		JLabel lblCode = new JLabel("Code");
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.WEST;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 2;
		gbc_lblCode.gridy = 4;
		contentPane.add(lblCode, gbc_lblCode);
		
		JLabel labelCodeAnimal = new JLabel("New label");
		GridBagConstraints gbc_labelCodeAnimal = new GridBagConstraints();
		gbc_labelCodeAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_labelCodeAnimal.gridx = 3;
		gbc_labelCodeAnimal.gridy = 4;
		contentPane.add(labelCodeAnimal, gbc_labelCodeAnimal);
		
		JComboBox sexeComboBox = new JComboBox();
		GridBagConstraints gbc_sexeComboBox = new GridBagConstraints();
		gbc_sexeComboBox.gridwidth = 3;
		gbc_sexeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_sexeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_sexeComboBox.gridx = 5;
		gbc_sexeComboBox.gridy = 4;
		contentPane.add(sexeComboBox, gbc_sexeComboBox);
		
		JLabel lblNom = new JLabel("Nom");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.WEST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 2;
		gbc_lblNom.gridy = 5;
		contentPane.add(lblNom, gbc_lblNom);
		
		textNom = new JTextField();
		GridBagConstraints gbc_textNom = new GridBagConstraints();
		gbc_textNom.gridwidth = 5;
		gbc_textNom.insets = new Insets(0, 0, 5, 5);
		gbc_textNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNom.gridx = 3;
		gbc_textNom.gridy = 5;
		contentPane.add(textNom, gbc_textNom);
		textNom.setColumns(10);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 6;
		contentPane.add(label, gbc_label);
		
		JLabel lblCouleur = new JLabel("Couleur");
		GridBagConstraints gbc_lblCouleur = new GridBagConstraints();
		gbc_lblCouleur.anchor = GridBagConstraints.WEST;
		gbc_lblCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouleur.gridx = 2;
		gbc_lblCouleur.gridy = 7;
		contentPane.add(lblCouleur, gbc_lblCouleur);
		
		textCouleur = new JTextField();
		GridBagConstraints gbc_textCouleur = new GridBagConstraints();
		gbc_textCouleur.gridwidth = 5;
		gbc_textCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_textCouleur.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCouleur.gridx = 3;
		gbc_textCouleur.gridy = 7;
		contentPane.add(textCouleur, gbc_textCouleur);
		textCouleur.setColumns(10);
		
		JLabel lblEspece = new JLabel("Espece");
		GridBagConstraints gbc_lblEspece = new GridBagConstraints();
		gbc_lblEspece.anchor = GridBagConstraints.WEST;
		gbc_lblEspece.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspece.gridx = 2;
		gbc_lblEspece.gridy = 8;
		contentPane.add(lblEspece, gbc_lblEspece);
		
		JComboBox especeComboBox = new JComboBox();
		GridBagConstraints gbc_especeComboBox = new GridBagConstraints();
		gbc_especeComboBox.gridwidth = 2;
		gbc_especeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_especeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_especeComboBox.gridx = 3;
		gbc_especeComboBox.gridy = 8;
		contentPane.add(especeComboBox, gbc_especeComboBox);
		
		JLabel lblRace = new JLabel("Race");
		GridBagConstraints gbc_lblRace = new GridBagConstraints();
		gbc_lblRace.anchor = GridBagConstraints.EAST;
		gbc_lblRace.insets = new Insets(0, 0, 5, 5);
		gbc_lblRace.gridx = 5;
		gbc_lblRace.gridy = 8;
		contentPane.add(lblRace, gbc_lblRace);
		
		JComboBox raceComboBox = new JComboBox();
		raceComboBox.setBorder(UIManager.getBorder("Button.border"));
		GridBagConstraints gbc_raceComboBox = new GridBagConstraints();
		gbc_raceComboBox.gridwidth = 2;
		gbc_raceComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_raceComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_raceComboBox.gridx = 6;
		gbc_raceComboBox.gridy = 8;
		contentPane.add(raceComboBox, gbc_raceComboBox);
		
		JLabel lblTatouage = new JLabel("Tatouage");
		GridBagConstraints gbc_lblTatouage = new GridBagConstraints();
		gbc_lblTatouage.anchor = GridBagConstraints.WEST;
		gbc_lblTatouage.insets = new Insets(0, 0, 5, 5);
		gbc_lblTatouage.gridx = 2;
		gbc_lblTatouage.gridy = 9;
		contentPane.add(lblTatouage, gbc_lblTatouage);
		
		textTatouage = new JTextField();
		GridBagConstraints gbc_textTatouage = new GridBagConstraints();
		gbc_textTatouage.gridwidth = 5;
		gbc_textTatouage.insets = new Insets(0, 0, 5, 5);
		gbc_textTatouage.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTatouage.gridx = 3;
		gbc_textTatouage.gridy = 9;
		contentPane.add(textTatouage, gbc_textTatouage);
		textTatouage.setColumns(10);
	}

}
