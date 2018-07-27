package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.eni.clinique.bll.AnimalMger;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientMger;
import fr.eni.clinique.bo.Client;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.List;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class EcranRdv extends JFrame {

	private JPanel contentPane;
	private JLabel lblClient;
	private JLabel lblAnimal;
	private JComboBox comboBoxAnimal;
	private JButton buttonAjouterClient;
	private JButton buttonAjouterAnimal;
	private JComboBox comboBoxVeto;
	private JLabel lblVeterinaire;
	private JComboBox comboBoxHeure;
	private JComboBox comboBoxMinute;
	private JLabel lblHeure;
	private JComboBox comboBoxClient;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	private List<Client> listeClient;
	

	private ClientMger clientMger = ClientMger.getInstance();
	private AnimalMger animalMger = AnimalMger.getInstance();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranRdv frame = new EcranRdv();
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
	public EcranRdv() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{22, 101, 0, 123, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 1;
		gbc_lblClient.gridy = 1;
		contentPane.add(getLblClient(), gbc_lblClient);
		GridBagConstraints gbc_lblVeterinaire = new GridBagConstraints();
		gbc_lblVeterinaire.insets = new Insets(0, 0, 5, 5);
		gbc_lblVeterinaire.gridx = 3;
		gbc_lblVeterinaire.gridy = 1;
		contentPane.add(getLblVeterinaire(), gbc_lblVeterinaire);
		GridBagConstraints gbc_comboBoxClient = new GridBagConstraints();
		gbc_comboBoxClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxClient.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxClient.gridx = 1;
		gbc_comboBoxClient.gridy = 2;
		contentPane.add(getComboBoxClient(), gbc_comboBoxClient);
		GridBagConstraints gbc_buttonAjouterClient = new GridBagConstraints();
		gbc_buttonAjouterClient.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAjouterClient.gridx = 2;
		gbc_buttonAjouterClient.gridy = 2;
		contentPane.add(getButtonAjouterClient(), gbc_buttonAjouterClient);
		GridBagConstraints gbc_comboBoxVeto = new GridBagConstraints();
		gbc_comboBoxVeto.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxVeto.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxVeto.gridx = 3;
		gbc_comboBoxVeto.gridy = 2;
		contentPane.add(getComboBoxVeto(), gbc_comboBoxVeto);
		GridBagConstraints gbc_lblAnimal = new GridBagConstraints();
		gbc_lblAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnimal.gridx = 1;
		gbc_lblAnimal.gridy = 3;
		contentPane.add(getLblAnimal(), gbc_lblAnimal);
		GridBagConstraints gbc_lblHeure = new GridBagConstraints();
		gbc_lblHeure.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeure.gridx = 4;
		gbc_lblHeure.gridy = 3;
		contentPane.add(getLblHeure(), gbc_lblHeure);
		GridBagConstraints gbc_comboBoxAnimal = new GridBagConstraints();
		gbc_comboBoxAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAnimal.gridx = 1;
		gbc_comboBoxAnimal.gridy = 4;
		contentPane.add(getComboBoxAnimal(), gbc_comboBoxAnimal);
		GridBagConstraints gbc_buttonAjouterAnimal = new GridBagConstraints();
		gbc_buttonAjouterAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAjouterAnimal.gridx = 2;
		gbc_buttonAjouterAnimal.gridy = 4;
		contentPane.add(getButtonAjouterAnimal(), gbc_buttonAjouterAnimal);
		GridBagConstraints gbc_comboBoxHeure = new GridBagConstraints();
		gbc_comboBoxHeure.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxHeure.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxHeure.gridx = 4;
		gbc_comboBoxHeure.gridy = 4;
		contentPane.add(getComboBoxHeure(), gbc_comboBoxHeure);
		GridBagConstraints gbc_comboBoxMinute = new GridBagConstraints();
		gbc_comboBoxMinute.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxMinute.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMinute.gridx = 5;
		gbc_comboBoxMinute.gridy = 4;
		contentPane.add(getComboBoxMinute(), gbc_comboBoxMinute);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 5;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 5;
		contentPane.add(getTable(), gbc_table);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 6;
		contentPane.add(getBtnNewButton(), gbc_btnNewButton);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 6;
		contentPane.add(getBtnNewButton_1(), gbc_btnNewButton_1);
	}

	private JLabel getLblClient() {
		if (lblClient == null) {
			lblClient = new JLabel("Client");
		}
		return lblClient;
	}
	private JLabel getLblAnimal() {
		if (lblAnimal == null) {
			lblAnimal = new JLabel("Animal");
		}
		return lblAnimal;
	}
	private JComboBox getComboBoxAnimal() {
		if (comboBoxAnimal == null) {
			comboBoxAnimal = new JComboBox();
		}
		return comboBoxAnimal;
	}
	private JButton getButtonAjouterClient() {
		if (buttonAjouterClient == null) {
			buttonAjouterClient = new JButton("+");
		}
		return buttonAjouterClient;
	}
	private JButton getButtonAjouterAnimal() {
		if (buttonAjouterAnimal == null) {
			buttonAjouterAnimal = new JButton("+");
		}
		return buttonAjouterAnimal;
	}
	private JComboBox getComboBoxVeto() {
		if (comboBoxVeto == null) {
			comboBoxVeto = new JComboBox();
		}
		return comboBoxVeto;
	}
	private JLabel getLblVeterinaire() {
		if (lblVeterinaire == null) {
			lblVeterinaire = new JLabel("Veterinaire");
		}
		return lblVeterinaire;
	}
	private JComboBox getComboBoxHeure() {
		if (comboBoxHeure == null) {
			comboBoxHeure = new JComboBox();
		}
		return comboBoxHeure;
	}
	private JComboBox getComboBoxMinute() {
		if (comboBoxMinute == null) {
			comboBoxMinute = new JComboBox();
		}
		return comboBoxMinute;
	}
	private JLabel getLblHeure() {
		if (lblHeure == null) {
			lblHeure = new JLabel("Heure");
		}
		return lblHeure;
	}
	private JComboBox getComboBoxClient() {
		if (comboBoxClient == null) {
			
			//TODO
			try {
				listeClient = clientMger.affichageClient();
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[] tabClient = listeClient.toArray(new String[0]);
			comboBoxClient = new JComboBox<String>(tabClient);
		}
		return comboBoxClient;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Supprimer");
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Valider");
		}
		return btnNewButton_1;
	}
}
