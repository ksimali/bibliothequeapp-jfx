package model;

public class Livre {
	// Attributes
	private String titre;
	
	// Getters and Setters
	public String getTitre() {
		return titre;
	}
	
	// Constructor
	public Livre(String titre) {
		this.titre = titre;
	}
	
	// Override the toString() method
	@Override
	public String toString() {
		return titre;
	}
	
}
