package fr.eni.clinique.bo;

public class Personnel {
	private int CodePers;
	private String Nom;
	private String MotPasse; 
	private String Role;
	private Boolean Archive;
	
	//CONSTRUCTEUR 
		public Personnel( String nom, String motPasse, String role, Boolean archive) {
			super();
			Nom = nom;
			MotPasse = motPasse;
			Role = role;
			Archive = archive;
		}

	public Personnel( String nom, String motPasse, String role) {
			super();
			Nom = nom;
			MotPasse = motPasse;
			Role = role;
		}



	// GETTER AND SETTER
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
	
		//sb.append("marque=" + marque); eviter la concatenation
		sb.append("Code Personnel=" +CodePers);
		sb.append(", nom=" + Nom); 
		sb.append(", mot de passe=" + MotPasse); 
		sb.append(", rôle="+ Role); 
		return sb.toString();

		}
	
	
}
