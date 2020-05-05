package projetFinal.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="animal")
@SequenceGenerator(name="seqAnimal",sequenceName = "seq_ani",initialValue=100,allocationSize=1)
public class Animal {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqAnimal")
	@Column(name="id_animal", nullable = false)
	private Integer id;
	@Column(name="nom_courant", nullable = false,unique = true, length = 150)
	private String nomCourant;
	@Column(name="nom_scientifique",unique = false, length = 150)
	private String nomScientifique;
	@Column(name="emplacement_image")
	private String emplacementImage;
	@Column(name="description")
	private String description;
	@Column(name="ordre", length=20)
	@Enumerated(EnumType.STRING)
	private Ordre ordre;
	@OneToMany (mappedBy = "animal")
	private List<Observation> observations=new ArrayList<Observation>();
	
	public Animal(String nomCourant, String nomScientifique, String emplacementImage, String description) {
		this.nomCourant = nomCourant;
		this.nomScientifique = nomScientifique;
		this.emplacementImage = emplacementImage;
		this.description = description;
	}


	public Animal() {
	}


	public Animal(String nomScientifique, String emplacementImage, String description, Ordre ordre) {
		super();
		this.nomScientifique = nomScientifique;
		this.emplacementImage = emplacementImage;
		this.description = description;
		this.ordre = ordre;
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

	public String getEmplacementImage() {
		return emplacementImage;
	}

	public void setEmplacementImage(String emplacementImage) {
		this.emplacementImage = emplacementImage;
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



	public Ordre getOrdre() {
		return ordre;
	}


	public void setOrdre(Ordre ordre) {
		this.ordre = ordre;
	}





	public List<Observation> getObservations() {
		return observations;
	}


	public void setObservations(List<Observation> observations) {
		this.observations = observations;
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
