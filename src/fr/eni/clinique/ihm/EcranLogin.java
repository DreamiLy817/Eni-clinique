package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginMger;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Point;

public class EcranLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField textPass;
	private JButton validerButton;
	
	private JLabel labelLogin;
    private JLabel labelPass;
	
	private String login;
    private String pass;
    private String role;
    
    private LoginMger loginMger = LoginMger.getInstance();

	/**
	 * Create the frame.
	 */
	public EcranLogin() {
		setTitle("Connexion");
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
        this.setIconImage(img.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(30, 30));
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setMaximumSize(new Dimension(300, 300));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(153, 204, 153));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 33, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		

		getLabelLogin().setFont(new Font("Tahoma", Font.PLAIN, 16));
		getLabelLogin().setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_labelNom = new GridBagConstraints();
		gbc_labelNom.insets = new Insets(0, 0, 5, 5);
		gbc_labelNom.anchor = GridBagConstraints.WEST;
		gbc_labelNom.gridx = 2;
		gbc_labelNom.gridy = 1;
		contentPane.add(getLabelLogin(), gbc_labelNom);
		
		GridBagConstraints gbc_textLogin = new GridBagConstraints();
		gbc_textLogin.insets = new Insets(0, 0, 5, 5);
		gbc_textLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLogin.gridx = 4;
		gbc_textLogin.gridy = 1;
		contentPane.add( getTextLogin(), gbc_textLogin);
		getTextLogin().setColumns(10);
		
	
		getLabelPass().setFont(new Font("Tahoma", Font.PLAIN, 16));
		getLabelPass().setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_labelPass = new GridBagConstraints();
		gbc_labelPass.anchor = GridBagConstraints.WEST;
		gbc_labelPass.insets = new Insets(0, 0, 5, 5);
		gbc_labelPass.gridx = 2;
		gbc_labelPass.gridy = 2;
		contentPane.add(getLabelPass(), gbc_labelPass);
		
		GridBagConstraints gbc_textPass = new GridBagConstraints();
		gbc_textPass.insets = new Insets(0, 0, 5, 5);
		gbc_textPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPass.gridx = 4;
		gbc_textPass.gridy = 2;
		contentPane.add(getPasswordFieldPass(), gbc_textPass);
		getPasswordFieldPass().setColumns(10);
		
	
		 getValiderButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login = textLogin.getText();
                pass = textPass.getText();
                try {
                    role=loginMger.connection(login, pass);
                        if (role != null) {
                            JOptionPane.showMessageDialog(EcranLogin.this, "Connexion reussie");
                            EcranAccueil ecranA = new EcranAccueil(role);
                            ecranA.setVisible(true);
                            EcranLogin.this.dispose();
                        }
                        else {
                            JOptionPane.showMessageDialog(EcranLogin.this, "Connexion echouee, identifiant ou mot de passe incorrect");
                        }
                } catch (BLLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(EcranLogin.this, "Erreur de connexion");
                    
                }
			}
		});
		 getValiderButton().setBorder(new LineBorder(new Color(0, 204, 153), 2));
		 getValiderButton().setBorderPainted(false);
		 getValiderButton().setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_validerButton = new GridBagConstraints();
		gbc_validerButton.fill = GridBagConstraints.BOTH;
		gbc_validerButton.gridwidth = 2;
		gbc_validerButton.insets = new Insets(0, 0, 5, 5);
		gbc_validerButton.gridx = 3;
		gbc_validerButton.gridy = 4;
		contentPane.add( getValiderButton(), gbc_validerButton);
	}
	
	  public JButton getValiderButton() {
	        if (validerButton == null) {
	            validerButton = new JButton("Valider");
	        }
	        return validerButton;
	    }
	  public JTextField getTextLogin() {
	        if (textLogin == null) {
	            textLogin = new JTextField(20);
	            textLogin.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
	        }
	        return textLogin;
	    }
	  public JPasswordField getPasswordFieldPass() {
	        if (textPass == null) {
	            textPass = new JPasswordField(20);
	            textPass.setBorder(new LineBorder(new Color(255, 255, 255), 3));
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
}
