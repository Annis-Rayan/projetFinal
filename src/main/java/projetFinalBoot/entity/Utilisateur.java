package projetFinalBoot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import projetFinalBoot.entity.views.Views;
import projetFinalBoot.models.ImageModel;



@Entity
@Table(name = "utilisateur")
@SequenceGenerator(name = "seqUtilisateur", sequenceName = "seq_utilisateur", initialValue = 100, allocationSize = 1)


public class Utilisateur {
	
	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUtilisateur")
	@Column(name = "id_utilisateur")
	private Integer id;
	
	@JsonView(Views.Common.class)
	@Column(name = "prenom", length = 50)
	private String prenom;
	
	@JsonView(Views.Common.class)
	@Column(name = "nom", length = 50)
	private String nom;
	
	@JsonView(Views.Common.class)
	@Column(name = "pseudo", length = 50, nullable = false)
	private String pseudo;
	
	@JsonView(Views.Common.class)
	@OneToOne
	private ImageModel imageProfil;
	
	@JsonView(Views.Common.class)
	@Column(name = "type", length = 5, nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeUtilisateur type;
	

	@Version
	private int version;
	
	public Utilisateur() {
	}


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



	


	public ImageModel getImageProfil() {
		return imageProfil;
	}


	public void setImageProfil(ImageModel imageProfil) {
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


	
	public String getPseudo() {
		return pseudo;
	}


	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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
		Utilisateur other = (Utilisateur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
