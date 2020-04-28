package projetFinal.entity;

public class Animal {

	private Integer id;
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



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
