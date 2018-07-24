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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.BevelBorder;

public class EcranAccueil extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranAccueil frame = new EcranAccueil(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param role 
	 */
	public EcranAccueil(String role) {
		System.out.println(role);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 491);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 204, 153));
		setJMenuBar(menuBar);
		
		
		JMenu menuFichier = new JMenu("Fichier");
		menuFichier.setBackground(new Color(0, 153, 255));
		menuFichier.setForeground(new Color(255, 255, 255));
		menuBar.add(menuFichier);
		
		JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
		mntmDconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EcranPersonnel ecranPerso = new EcranPersonnel();
				ecranPerso.setVisible(true);
				EcranAccueil.this.dispose();
			}
		});
		menuFichier.add(mntmDconnexion);
		
		JMenuItem mntmFermer = new JMenuItem("Fermer");
		menuFichier.add(mntmFermer);
		
		if(role.equals("sec")) {
			JMenu menuGestionrdv = new JMenu("Gestion des rendez-vous");
			menuGestionrdv.setBackground(new Color(0, 153, 255));
			menuGestionrdv.setForeground(new Color(255, 255, 255));
			menuBar.add(menuGestionrdv);
			
			JMenuItem mntmPriseDeRendez = new JMenuItem("Prise de rendez vous");
			mntmPriseDeRendez.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			menuGestionrdv.add(mntmPriseDeRendez);
			
			JMenuItem mntmGestionDesClients = new JMenuItem("Gestion des clients");
			mntmGestionDesClients.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EcranClientPrincipal ecranP = new EcranClientPrincipal(null, null);
					ecranP.setVisible(true);
					EcranAccueil.this.dispose();
				}
			});
			menuGestionrdv.add(mntmGestionDesClients);
		}
			
		if(role.equals("vet")) {
			JMenuItem mntmAgenda = new JMenuItem("Agenda");
			mntmAgenda.setBorder(null);
			mntmAgenda.setAlignmentX(Component.LEFT_ALIGNMENT);
			mntmAgenda.setHorizontalAlignment(SwingConstants.LEFT);
			mntmAgenda.setForeground(new Color(255, 255, 255));
			mntmAgenda.setBackground(new Color(0, 204, 153));
			menuBar.add(mntmAgenda);
		}
		if(role.equals("adm")) {
			JMenuItem mntmGestionDuPersonnel = new JMenuItem("Gestion du personnel");
			mntmGestionDuPersonnel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EcranPersonnel ecranPerso = new EcranPersonnel();
					ecranPerso.setVisible(true);
					EcranAccueil.this.dispose();
					
				}
			});
			mntmGestionDuPersonnel.setAlignmentX(Component.LEFT_ALIGNMENT);
			mntmGestionDuPersonnel.setBorder(null);
			mntmGestionDuPersonnel.setHorizontalAlignment(SwingConstants.RIGHT);
			mntmGestionDuPersonnel.setForeground(new Color(255, 255, 255));
			mntmGestionDuPersonnel.setBackground(new Color(0, 204, 153));
			menuBar.add(mntmGestionDuPersonnel);
		}
	}
}
