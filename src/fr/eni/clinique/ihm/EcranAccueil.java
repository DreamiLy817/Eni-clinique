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
		menuBar.setBackground(new Color(0, 204, 153));
		setJMenuBar(menuBar);
		
		
		JMenu menuFichier = new JMenu("Fichier");
		menuFichier.setBackground(new Color(0, 153, 255));
		menuFichier.setForeground(new Color(255, 255, 255));
		menuBar.add(menuFichier);
		
		JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
		menuFichier.add(mntmDconnexion);
		
		JMenuItem mntmFermer = new JMenuItem("Fermer");
		menuFichier.add(mntmFermer);
		
		//if(role.equals("sec")) {
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
		//}
		//if(role.equals("vet")) {
			JMenu menuAgenda = new JMenu("Agenda");
			menuAgenda.setForeground(new Color(255, 255, 255));
			menuBar.add(menuAgenda);
		//}
		
	//if(role.equals("adm")) {
			JMenu menuGestionPerso = new JMenu("Gestion du personnel");
			menuGestionPerso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EcranPersonnel ecranPersonnel = new EcranPersonnel();
					ecranPersonnel.setVisible(true);
					EcranAccueil.this.dispose();
				}
			});
			menuGestionPerso.setForeground(new Color(255, 255, 255));
			menuBar.add(menuGestionPerso);
		}
		
	//}

}
