package fr.eni.clinique.ihm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EcranLogin extends JFrame {

	private JTextField textLogin;
	private JTextField textPass;
	private JLabel labelLogin;
	private JLabel labelPass;
	private JButton validerButton;

	public JButton getValiderButton() {
		if (validerButton == null) {
			validerButton = new JButton("Ok");
		}
		return validerButton;
	}

	public JTextField getTextLogin() {
		if (textLogin == null) {
			textLogin = new JTextField(20);
		}
		return textLogin;
	}

	public JTextField getTextPass() {
		if (textPass == null) {
			textPass = new JTextField(20);
		}
		return textPass;
	}

	public JLabel getLabelLogin() {
		if (labelLogin == null) {
			labelLogin = new JLabel("Nom: ");
		}
		return labelLogin;
	}

	public JLabel getLabelPass() {
		if (labelPass == null) {
			labelPass = new JLabel("Mot de passe: ");
		}
		return labelPass;
	}

	public EcranLogin() {
		super();
		initIhm();
	}

	private void initIhm() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridBagLayout());
		panelPrincipal.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();

		// login
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelPrincipal.add(getLabelLogin(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panelPrincipal.add(getTextLogin(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelPrincipal.add(getLabelPass(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panelPrincipal.add(getTextPass(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.EAST;
		panelPrincipal.add(getValiderButton(), gbc);
		this.setContentPane(panelPrincipal);

	}
}
