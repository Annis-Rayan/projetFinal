package projetFinalBoot.entity;

public enum TypeUtilisateur {
	USER("utilisateur"),
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
