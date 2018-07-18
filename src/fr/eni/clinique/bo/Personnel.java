package fr.eni.clinique.bo;

public class Personnel {
	private int CodePers;
	private String Nom;
	private String Prenom;
	private String MotPasse; 
	private String Role;
	private Boolean Archive;
	
	//CONSTRUCTEUR 
	
	// sans codePersonne et avec les archives
		public Personnel( String nom, String prenom, String motPasse, String role, Boolean archive) {
			super();
			Nom = nom;
			Prenom = prenom;
			MotPasse = motPasse;
			Role = role;
			Archive = archive;
		}
		
		// avec codePersonne et sans les archives
		public Personnel( int codePers, String nom,  String prenom, String motPasse, String role) {
			super();
			CodePers = codePers;
			Prenom = prenom;
			Nom = nom;
			MotPasse = motPasse;
			Role = role;
		}
		
		// sans codePersonne sans les archives
	public Personnel( String nom,  String prenom, String motPasse, String role) {
			super();
			Nom = nom;
			Prenom = prenom;
			MotPasse = motPasse;
			Role = role;
		}



	// GETTER AND SETTER
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public int getCodePers() {
		return CodePers;
	}
	public void setCodePers(int codePers) {
		CodePers = codePers;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getMotPasse() {
		return MotPasse;
	}
	public void setMotPasse(String motPasse) {
		MotPasse = motPasse;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public Boolean getArchive() {
		return Archive;
	}
	public void setArchive(Boolean archive) {
		Archive = archive;
	}
	
	@Override
	public String toString() {
		StringBuilder sb =new StringBuilder();

		sb.append("Code Personnel  [ code = ");
		sb.append(CodePers);
		sb.append(",nom = ");
		sb.append(Nom);
		sb.append(", prenom = ");
		sb.append(Prenom);
		sb.append(",rôle = "); 
		sb.append(Role);
		sb.append("]\n");
		
		return sb.toString();

		}	
}
