package projetFinalBoot.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

import projetFinalBoot.entity.views.Views;

import javax.persistence.ForeignKey;

@Entity
@DiscriminatorValue("U")
public class SignalementUtilisateur extends Signalement {
	
	@JsonView(Views.SignalementObservateurWithObservateur.class)
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
