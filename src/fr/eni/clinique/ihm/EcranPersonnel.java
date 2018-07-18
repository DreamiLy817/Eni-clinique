package fr.eni.clinique.ihm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EcranPersonnel extends JFrame{

	private JButton ajouterButton;
	private JButton supprimerButton;
	private JButton reinitialiserButton;
	private JLabel ajouterLabel;
	private JLabel supprimerLabel;
	private JLabel reinitialiserLabel;
	
	
	private JLabel getSupprimerLabel() {
		if (supprimerLabel == null) {
			supprimerLabel = new JLabel("Supprimer");
		}
		return ajouterLabel;
	}
	
	private JButton getSupprimerButton() {
		if (supprimerButton == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IconesBoutons/Icons8-Windows-8-Science-Minus2-Math.png")));
			supprimerButton = new JButton(image);
		}
		return supprimerButton;
	}
	
	private JLabel getReinitialiserLabel() {
		if (reinitialiserLabel == null) {
			reinitialiserLabel = new JLabel("Réinitialiser");
		}
		return reinitialiserLabel;
	}
	
	private JButton getReinitialiserButton() {
		if (reinitialiserButton == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IconesBoutons/89647-200.png")));
			reinitialiserButton = new JButton(image);
		}
		return reinitialiserButton;
	}
	
	private JLabel getAjouterLabel() {
		if (ajouterLabel == null) {
			ajouterLabel = new JLabel("Ajouter");
		}
		return ajouterLabel;
	}
	
	private JButton getAjouterButton() {
		if (ajouterButton == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/plus.png")));
			ajouterButton = new JButton(image);
		}
		return ajouterButton;
	}
	
	public EcranPersonnel() {
		super();
		initIHM();
	}
	
	private void initIHM() {
		// Initialisation de l'IHM, déclaration des panneaux
		JPanel panelPrincipal = new JPanel();
		JPanel panelBoutons = new JPanel();
		panelPrincipal.setOpaque(false);
		panelPrincipal.setLayout(new GridBagLayout());
		panelBoutons.setOpaque(false);
		panelBoutons.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		//Création du panneau des boutons
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panelBoutons.add(getAjouterButton(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panelBoutons.add(getSupprimerButton(), gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panelBoutons.add(getReinitialiserButton(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelBoutons.add(getAjouterLabel(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panelBoutons.add(getSupprimerLabel(), gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		panelBoutons.add(getReinitialiserLabel(), gbc);
		
		//Création du panel principal
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		panelPrincipal.add(panelBoutons, gbc);
		this.setContentPane(panelPrincipal);
	}
}
