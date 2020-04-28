package projetFinal.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

@Entity
@DiscriminatorValue("U")
public class SignalementUtilisateur extends Signalement {
	
	
	@ManyToOne
	@JoinColumn(name = "cible", foreignKey = @ForeignKey(name = "cible_fk"))
	private Utilisateur cible;

	public Utilisateur getCible() {
		return cible;
	}

	public void setCible(Utilisateur cible) {
		this.cible = cible;
	}

	public SignalementUtilisateur() {
		super();
	}

}
