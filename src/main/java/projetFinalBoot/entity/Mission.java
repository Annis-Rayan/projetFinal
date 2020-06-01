package projetFinalBoot.entity;

import com.fasterxml.jackson.annotation.JsonView;

import projetFinalBoot.entity.views.Views;

public class Mission {
	
	@JsonView(Views.MissionWithObservation.class)
	private Observation obs;

	@JsonView(Views.MissionWithLocalisation.class)
	private Localisation loc;
	
	public Animal donneMission()
	{
		return new Animal();
	}
}
