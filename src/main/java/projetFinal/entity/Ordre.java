package projetFinal.entity;



public enum Ordre {
	
	Mammifere("Mammifere"), Insecte("Insecte"), Oiseaux("Oiseaux"), Amphibiens("Amphibiens"); 

	private String label;

	private Ordre(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
