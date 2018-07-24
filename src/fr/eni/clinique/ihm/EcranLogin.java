package fr.eni.clinique.ihm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginMger;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOPersonnel;
import fr.eni.clinique.dal.DAOFactory;

public class EcranLogin extends JFrame {

	private JTextField textLogin;
	private JPasswordField textPass;
	private JLabel labelLogin;
	private JLabel labelPass;
	private JButton validerButton;
	private String login;
	private String pass;
	private String role;
	private LoginMger loginMger = LoginMger.getInstance();

	public JButton getValiderButton() {
		if (validerButton == null) {
			validerButton = new JButton("Ok");
			validerButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					login = textLogin.getText();
					pass = textPass.getText();
					try {
						role=loginMger.connection(login, pass);
							if (role != null) {
								JOptionPane.showMessageDialog(EcranLogin.this, "Connexion réussie");
							}
							else {
								JOptionPane.showMessageDialog(EcranLogin.this, "Connexion échouée, identifiant ou mot de passe incorrect");
							}
					} catch (BLLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(EcranLogin.this, "Erreur de connexion");
					}
				}
			});
		}
		return validerButton;
	}

	public JTextField getTextLogin() {
		if (textLogin == null) {
			textLogin = new JTextField(20);
		}
		return textLogin;
	}

	public JPasswordField getPasswordFieldPass() {
		if (textPass == null) {
			textPass = new JPasswordField(20);
			textPass.setEchoChar('*');
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
		panelPrincipal.add(getPasswordFieldPass(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.EAST;
		panelPrincipal.add(getValiderButton(), gbc);
		this.setContentPane(panelPrincipal);

	}
}
