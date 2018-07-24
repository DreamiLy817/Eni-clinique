package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JMenu;

public class EcranAccueil extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranAccueil frame = new EcranAccueil();
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
	public EcranAccueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 491);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 204, 153));
		setJMenuBar(menuBar);
		
		
		JMenu mnNewMenu = new JMenu("Fichier");
		mnNewMenu.setBackground(new Color(0, 153, 255));
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
		mnNewMenu.add(mntmDconnexion);
		
		JMenuItem mntmFermer = new JMenuItem("Fermer");
		mnNewMenu.add(mntmFermer);
		
		JMenu mnNewMenu_1 = new JMenu("Gestion des rendez-vous");
		mnNewMenu_1.setBackground(new Color(0, 153, 255));
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmPriseDeRendez = new JMenuItem("Prise de rendez vous");
		mnNewMenu_1.add(mntmPriseDeRendez);
		
		JMenuItem mntmGestionDesClients = new JMenuItem("Gestion des clients");
		mnNewMenu_1.add(mntmGestionDesClients);
		
		JMenu mnNewMenu_2 = new JMenu("Agenda");
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Gestion du personnel");
		mnNewMenu_3.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_3);
	}

}
