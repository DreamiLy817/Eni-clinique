package fr.eni.clinique.bo;

import java.util.Date;

public class Rdv {
	private Date dateRDV;
	private int codeAnimal;
	private int codePers;
	
	//CONSTRUCTEUR 
	public Rdv(Date dateRDV, int codeAnimal, int codePers) {
		super();
		this.dateRDV = dateRDV;
		this.codeAnimal = codeAnimal;
		this.codePers = codePers;
	}
	// GETTER AND SETTER
	public Date getDateRDV() {
		return dateRDV;
	}

	public void setDateRDV(Date dateRDV) {
		this.dateRDV = dateRDV;
	}
	
}
