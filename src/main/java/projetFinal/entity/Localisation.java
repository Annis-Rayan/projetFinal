package projetFinal.entity;

public class Localisation {
	
	private int ID;
	private String Pays;
	private String Region;
	private String Localite;
	
	
	public Localisation() {
		super();
	}


	public String getPays() {
		return Pays;
	}


	public void setPays(String pays) {
		Pays = pays;
	}


	public String getRegion() {
		return Region;
	}


	public void setRegion(String region) {
		Region = region;
	}


	public String getLocalite() {
		return Localite;
	}


	public void setLocalite(String localite) {
		Localite = localite;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
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
		Localisation other = (Localisation) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	
	
	
}
