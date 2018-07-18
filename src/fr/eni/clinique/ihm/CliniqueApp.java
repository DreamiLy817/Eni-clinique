package fr.eni.clinique.ihm;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CliniqueApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				EcranPersonnel ecranLogin = new EcranPersonnel();
				ecranLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ecranLogin.setLocationRelativeTo(null);
				ecranLogin.setSize(600, 600);
				//ecranLogin.setResizable(false);
				ecranLogin.setTitle("Connexion");
				ecranLogin.setVisible(true);
			}
		});
	}

}
