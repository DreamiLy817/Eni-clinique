package fr.eni.clinique.ihm;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CliniqueApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				EcranPersonnel ecranPerso = new EcranPersonnel();
				ecranPerso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ecranPerso.setLocationRelativeTo(null);
				ecranPerso.setSize(500, 400);
				ecranPerso.setResizable(false);
				ecranPerso.setTitle("Connexion");
				ecranPerso.setVisible(true);
			}

		});

	}

}
