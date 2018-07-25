package fr.eni.clinique.bo;

public class Animal {
	private int codeAnimal;
	private String nomAnimal;
	private char sexe;
	private String couleur;
	private String race;
	private String espece;
	private int codeClient;
	private String tatouage;
	private String antecedents;
	private boolean archive;

	// GETTER AND SETTER
	public int getCodeAnimal() {
		return codeAnimal;
	}

	public void setCodeAnimal(int codeAnimal) {
		this.codeAnimal = codeAnimal;
	}

	public String getNomAnimal() {
		return nomAnimal;
	}

	public void setNomAnimal(String nomAnimal) {
		this.nomAnimal = nomAnimal;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public int getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(int codeClient) {
		this.codeClient = codeClient;
	}

	public String getTatouage() {
		return tatouage;
	}

	public void setTatouage(String tatouage) {
		this.tatouage = tatouage;
	}

	public String getAntecedents() {
		return antecedents;
	}

	public void setAntecedents(String antecedents) {
		this.antecedents = antecedents;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	/**
	 * 
	 * Constructeur
	 * 
	 * @param codeAnimal
	 * @param nomAnimal
	 * @param sexe
	 * @param couleur
	 * @param race
	 * @param espece
	 * @param codeClient
	 */
	public Animal(int codeAnimal, String nomAnimal, char sexe, String couleur, String race, String espece,
			int codeClient) {
		super();
		this.codeAnimal = codeAnimal;
		this.nomAnimal = nomAnimal;
		this.sexe = sexe;
		this.couleur = couleur;
		this.race = race;
		this.espece = espece;
		this.codeClient = codeClient;
	}

	/**
	 * 
	 * Constructeur
	 * 
	 * @param codeAnimal
	 * @param nomAnimal
	 * @param sexe
	 * @param couleur
	 * @param race
	 * @param espece
	 * @param tatouage
	 */
	public Animal(int codeAnimal, String nomAnimal, char sexe, String couleur, String race, String espece,
			String tatouage) {
		super();
		this.codeAnimal = codeAnimal;
		this.nomAnimal = nomAnimal;
		this.sexe = sexe;
		this.couleur = couleur;
		this.race = race;
		this.espece = espece;
		this.tatouage = tatouage;
	}

	/**
	 * 
	 * Constructeur
	 * 
	 * @param nomAnimal
	 * @param sexe
	 * @param couleur
	 * @param race
	 * @param espece
	 * @param codeClient
	 * @param tatouage
	 */
	public Animal(String nomAnimal, char sexe, String couleur, String race, String espece, int codeClient,
			String tatouage) {
		super();
		this.codeClient = codeClient;
		this.nomAnimal = nomAnimal;
		this.sexe = sexe;
		this.couleur = couleur;
		this.race = race;
		this.espece = espece;
		this.tatouage = tatouage;
	}

	public Animal(String nomAnimal, char sexe, String couleur, String race, String espece, int codeClient,
			String tatouage, String antecedents) {
		super();
		this.codeClient = codeClient;
		this.nomAnimal = nomAnimal;
		this.sexe = sexe;
		this.couleur = couleur;
		this.race = race;
		this.espece = espece;
		this.tatouage = tatouage;
		this.antecedents = antecedents;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (tatouage != null) {
			sb.append("Tatouage=" + tatouage);
			sb.append(", ");
		}

		// sb.append("marque=" + marque); eviter la concatenation
		sb.append("codeAnimal=");
		sb.append(codeAnimal);
		sb.append(", Nom de l'animal=" + nomAnimal);
		sb.append(", sexe=" + sexe);
		sb.append(", couleur=" + couleur);
		sb.append(", race=" + race);
		sb.append(", espece" + espece);
		sb.append(", Code du client" + codeClient);
		return sb.toString();

	}
}
