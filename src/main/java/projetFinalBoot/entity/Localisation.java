package projetFinalBoot.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import projetFinalBoot.entity.views.Views;

@Entity
@Table(name = "localisation")
@SequenceGenerator(name = "seqlocalisation", sequenceName = "seq_localisation", initialValue = 100, allocationSize = 1)
	public class Localisation {
	
	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqlocalisation")
	@Column(name = "id_localisation")
	private Integer ID;
	@JsonView(Views.Common.class)
	@Column(name = "Pays", length = 50, nullable = false)
	private String Pays;
	@JsonView(Views.Common.class)
	@Column(name = "Region", length = 100, nullable = false)
	private String Region;
	@JsonView(Views.Common.class)
	@Column(name = "Localite", length = 100)
	private String Localite;
	@JsonView(Views.Common.class)
	@OneToMany(mappedBy = "localisation" )
	private Set<Observation> lobserv=new HashSet<>();
	
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


	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}

	public Set<Observation> getLobserv() {
		return lobserv;
	}


	public void setLobserv(Set<Observation> lobserv) {
		this.lobserv = lobserv;
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


	public Localisation(String region, String localite) {
		super();
		Region = region;
		Localite = localite;
	}
	
	
	
}
