package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
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
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Cursor;

public class EcranAccueil extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranAccueil frame = new EcranAccueil(null, null);
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
	 * @param login 
	 */
	public EcranAccueil(String role, String login) {
		setTitle("Clinique vétérinaire");
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
		this.setIconImage(img.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 491);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMaximumSize(new Dimension(0, 4));
		menuBar.setMinimumSize(new Dimension(0, 4));
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 204, 153));
		setJMenuBar(menuBar);
		
		
		JMenu menuFichier = new JMenu("Fichier");
		menuFichier.setBorder(null);
		menuFichier.setFont(new Font("Tahoma", Font.PLAIN, 16));
		menuFichier.setBackground(new Color(0, 153, 255));
		menuFichier.setForeground(new Color(255, 255, 255));
		menuBar.add(menuFichier);
		
		JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
		mntmDconnexion.setOpaque(true);
		mntmDconnexion.setBorder(null);
		mntmDconnexion.setBackground(new Color(0, 204, 102));
		mntmDconnexion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmDconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EcranPersonnel ecranPerso = new EcranPersonnel();
				ecranPerso.setVisible(true);
				EcranAccueil.this.dispose();
			}
		});
		menuFichier.add(mntmDconnexion);
		
		JMenuItem mntmFermer = new JMenuItem("Fermer");
		mntmFermer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuFichier.add(mntmFermer);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		if(role.equals("sec")) {
			JMenu menuGestionrdv = new JMenu("Gestion des rendez-vous");
			menuGestionrdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuGestionrdv.setBackground(new Color(0, 153, 255));
			menuGestionrdv.setForeground(new Color(255, 255, 255));
			menuBar.add(menuGestionrdv);
			
			JMenuItem mntmPriseDeRendez = new JMenuItem("Prise de rendez vous");
			mntmPriseDeRendez.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mntmPriseDeRendez.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			menuGestionrdv.add(mntmPriseDeRendez);
			
			JMenuItem mntmGestionDesClients = new JMenuItem("Gestion des clients");
			mntmGestionDesClients.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mntmGestionDesClients.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EcranClientPrincipal ecranP = new EcranClientPrincipal(null, null);
					ecranP.setVisible(true);
					EcranAccueil.this.dispose();
				}
			});
			menuGestionrdv.add(mntmGestionDesClients);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(EcranAccueil.class.getResource("/images/ani.png")));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 4;
			gbc_lblNewLabel.gridy = 0;
			getContentPane().add(lblNewLabel, gbc_lblNewLabel);
			
			JLabel lblBienvenueLeGestionnaire = new JLabel("Bienvenue "+ login +" sur le gestionnaire de la Clinique Ani'Forme");
			lblBienvenueLeGestionnaire.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblBienvenueLeGestionnaire = new GridBagConstraints();
			gbc_lblBienvenueLeGestionnaire.insets = new Insets(0, 0, 0, 5);
			gbc_lblBienvenueLeGestionnaire.gridx = 4;
			gbc_lblBienvenueLeGestionnaire.gridy = 1;
			getContentPane().add(lblBienvenueLeGestionnaire, gbc_lblBienvenueLeGestionnaire);
		}
			
		if(role.equals("vet")) {
			JMenuItem mntmAgenda = new JMenuItem("Agenda");
			mntmAgenda.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			mntmAgenda.setPreferredSize(new Dimension(30, 22));
			mntmAgenda.setFont(new Font("Tahoma", Font.PLAIN, 16));
			mntmAgenda.setBorder(null);
			mntmAgenda.setAlignmentX(Component.LEFT_ALIGNMENT);
			mntmAgenda.setHorizontalAlignment(SwingConstants.LEFT);
			mntmAgenda.setForeground(new Color(255, 255, 255));
			mntmAgenda.setBackground(new Color(0, 204, 153));
			menuBar.add(mntmAgenda);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(EcranAccueil.class.getResource("/images/ani.png")));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 4;
			gbc_lblNewLabel.gridy = 0;
			getContentPane().add(lblNewLabel, gbc_lblNewLabel);
			
			JLabel lblBienvenueLeGestionnaire = new JLabel("Bienvenue "+ login +" sur le gestionnaire de la Clinique Ani'Forme");
			lblBienvenueLeGestionnaire.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblBienvenueLeGestionnaire = new GridBagConstraints();
			gbc_lblBienvenueLeGestionnaire.insets = new Insets(0, 0, 0, 5);
			gbc_lblBienvenueLeGestionnaire.gridx = 4;
			gbc_lblBienvenueLeGestionnaire.gridy = 1;
			getContentPane().add(lblBienvenueLeGestionnaire, gbc_lblBienvenueLeGestionnaire);
		}
		if(role.equals("adm")) {
			JMenuItem mntmGestionDuPersonnel = new JMenuItem("Gestion du personnel");
			mntmGestionDuPersonnel.setPreferredSize(new Dimension(87, 22));
			mntmGestionDuPersonnel.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
			
			
			
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(EcranAccueil.class.getResource("/images/ani.png")));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 4;
			gbc_lblNewLabel.gridy = 0;
			getContentPane().add(lblNewLabel, gbc_lblNewLabel);
			
			JLabel lblBienvenueLeGestionnaire = new JLabel("Bienvenue "+ login.toUpperCase() +" sur le gestionnaire de la Clinique Ani'Forme");
			lblBienvenueLeGestionnaire.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblBienvenueLeGestionnaire = new GridBagConstraints();
			gbc_lblBienvenueLeGestionnaire.insets = new Insets(0, 0, 0, 5);
			gbc_lblBienvenueLeGestionnaire.gridx = 4;
			gbc_lblBienvenueLeGestionnaire.gridy = 1;
			getContentPane().add(lblBienvenueLeGestionnaire, gbc_lblBienvenueLeGestionnaire);
	
		}
			
	}
}
