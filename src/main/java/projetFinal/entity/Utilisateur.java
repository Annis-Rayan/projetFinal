package projetFinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "utilisateur")
@SequenceGenerator(name = "seqUtilisateur", sequenceName = "seq_utilisateur", initialValue = 100, allocationSize = 1)


public class Utilisateur {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUtilisateur")
	@Column(name = "id_utilisateur")
	private Integer id;
	
	@Column(name = "prenom", length = 50, nullable = false)
	private String prenom;
	
	@Column(name = "nom", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "photo_profil", length = 50, nullable = false)
	private String imageProfil;
	
	@Column(name = "type", length = 5)
	@Enumerated(EnumType.STRING)
	private TypeUtilisateur type;
	
	
	@Version
	private int version;

	
	
	// constructeurs
	
	public Utilisateur() {
	}




	// getters et setters

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getImageProfil() {
		return imageProfil;
	}



	public void setImageProfil(String imageProfil) {
		this.imageProfil = imageProfil;
	}



	public TypeUtilisateur getType() {
		return type;
	}



	public void setType(TypeUtilisateur type) {
		this.type = type;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}


		
	//hashCode et equals

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
		Utilisateur other = (Utilisateur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
