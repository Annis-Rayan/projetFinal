package projetFinal.entity;

public class Animal {

	private String nomCourant;
	private String nomScientifique;
	private String emplacement;
	private String description;
	
	public Animal(String nomCourant, String nomScientifique, String emplacement, String description) {
		this.nomCourant = nomCourant;
		this.nomScientifique = nomScientifique;
		this.emplacement = emplacement;
		this.description = description;
	}

	public Animal(String nomCourant, String nomScientifique) {
		this.nomCourant = nomCourant;
		this.nomScientifique = nomScientifique;
	}

	public Animal() {
	}

	public Animal(String nomCourant, String description) {
		this.nomCourant = nomCourant;
		this.description = description;
	}

	public String getNomCourant() {
		return nomCourant;
	}

	public void setNomCourant(String nomCourant) {
		this.nomCourant = nomCourant;
	}

	public String getNomScientifique() {
		return nomScientifique;
	}

	public void setNomScientifique(String nomScientifique) {
		this.nomScientifique = nomScientifique;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
