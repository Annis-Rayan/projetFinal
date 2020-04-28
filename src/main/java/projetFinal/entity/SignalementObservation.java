package projetFinal.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

@Entity
@DiscriminatorValue("O")
public class SignalementObservation extends Signalement {
	
	@ManyToOne
	@JoinColumn(name = "observation", foreignKey = @ForeignKey(name = "utilisateur_fk"))
	private Observation observation;

	public Observation getObservation() {
		return observation;
	}

	public void setObservation(Observation observation) {
		this.observation = observation;
	}

	public SignalementObservation() {
		super();
	}
	
	
	
}
