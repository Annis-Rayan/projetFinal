package projetFinalBoot.entity;

public enum TypeUtilisateur {
	U("utilisateur"),
	A("adherent"),
	ADMIN("administrateur");
	
	private String type;

	private TypeUtilisateur(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
}
