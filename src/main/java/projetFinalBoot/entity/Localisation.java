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
	private Integer id;
	@JsonView(Views.Common.class)
	@Column(name = "Pays", length = 50, nullable = false)
	private String pays;
	@JsonView(Views.Common.class)
	@Column(name = "Region", length = 100, nullable = false)
	private String region;
	@JsonView(Views.Common.class)
	@Column(name = "Localite", length = 100)
	private String localite;
	@JsonView(Views.LocalisationWithObservation.class)
	@OneToMany(mappedBy = "localisation" )
	private Set<Observation> lobserv=new HashSet<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLocalite() {
		return localite;
	}
	public void setLocalite(String localite) {
		this.localite = localite;
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
		Localisation other = (Localisation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Localisation(Integer id, String pays, String region, String localite, Set<Observation> lobserv) {
		super();
		this.id = id;
		this.pays = pays;
		this.region = region;
		this.localite = localite;
		this.lobserv = lobserv;
	}
	public Localisation(Integer id, String pays, String region, String localite) {
		super();
		this.id = id;
		this.pays = pays;
		this.region = region;
		this.localite = localite;
	}
	public Localisation() {
		
	}	


	public Localisation(String region, String localite) {
		super();
		region = region;
		localite = localite;
	}
	
	
	
}
