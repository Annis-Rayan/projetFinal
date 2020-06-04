package projetFinalBoot.entity;


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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import projetFinalBoot.entity.views.Views;
import projetFinalBoot.models.ImageModel;



@Entity
@Table(name="animal")
@SequenceGenerator(name="seqAnimal",sequenceName = "seq_animal",initialValue=100,allocationSize=1)
public class Animal {

	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqAnimal")
	@Column(name="id_animal", nullable = false)
	private Integer id;
	
	@JsonView(Views.Common.class)
	@Column(name="nom_courant", nullable = false,unique = true, length = 150)
	private String nomCourant;
	
	@JsonView(Views.Common.class)
	@Column(name="nom_scientifique",unique = false, length = 150)
	private String nomScientifique;
	
	
	
	@JsonView(Views.Common.class)
	@Column(name="description")
	private String description;
	
	@JsonView(Views.Common.class)
	@Column(name="ordre", length=20)
	@Enumerated(EnumType.STRING)
	private Ordre ordre;
	
	@JsonView(Views.Common.class)
	@OneToOne
	private ImageModel emplacementImage;
	
	@JsonView(Views.AnimalwithObservation.class)
	@OneToMany (mappedBy = "animal")
	private List<Observation> observations=new ArrayList<Observation>();
	
	public Animal(String nomCourant, String nomScientifique, String emplacementImage, String description) {
		this.nomCourant = nomCourant;
		this.nomScientifique = nomScientifique;
		
		this.description = description;
	}


	public Animal() {
	}


	public Animal(String nomScientifique, String emplacementImage, String description, Ordre ordre) {
		super();
		this.nomScientifique = nomScientifique;
		
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

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public ImageModel getEmplacementImage() {
		return emplacementImage;
	}


	public void setEmplacementImage(ImageModel emplacementImage) {
		this.emplacementImage = emplacementImage;
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
