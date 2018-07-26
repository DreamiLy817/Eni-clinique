package fr.eni.clinique.ihm;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CliniqueApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				EcranLogin ecranLogin = new EcranLogin();
				ecranLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ecranLogin.setVisible(true);
			}
		});
	}

}
