package projetFinal.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="observation")
@SequenceGenerator(name="seqObservation",sequenceName = "seq_obs",initialValue=100,allocationSize=1)
public class Observation {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqObservation")
	@Column(name="id_observation")
	private Integer id;
	@Column(name="date_observation",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateObservation;
	@Column(name="nombre",nullable=false)
	private Integer nombre;
	@Column(name="description",nullable=false)
	private String description;
	@OneToOne()
	@JoinColumn(name = "localisation", foreignKey = @ForeignKey(name = "localisation_fk"))
	private Localisation localisation;
	@OneToOne()
	@JoinColumn(name = "utilisateur", foreignKey = @ForeignKey(name = "utilisateur_fk"))
	private Utilisateur utilisateur;
	@OneToOne()
	@JoinColumn(name = "animal", foreignKey = @ForeignKey(name = "animal_fk"))
	private Animal animal;
	@OneToMany(mappedBy="observation")
	private Set<SignalementObservation> signalementObservation=new HashSet<>();
	
	
	
	// constructeur
	
	public Observation() {
	}

	
	// methodes
	
	
	public Localisation getLocalisation() {
		return localisation;
	}


	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Animal getAnimal() {
		return animal;
	}


	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDateObservation() {
		return dateObservation;
	}


	public void setDateObservation(Date dateObservation) {
		this.dateObservation = dateObservation;
	}


	public Integer getNombre() {
		return nombre;
	}


	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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
		Observation other = (Observation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	

}
