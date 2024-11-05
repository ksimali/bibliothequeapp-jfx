package model;

public class Utilisateur {
	// Attributes
	private String nom;
	
	// Getters and Setters
	public String getNom() {
		return nom;
	}
	
	// Constructor
	public Utilisateur(String nom) {
		this.nom = nom;
	}
	
	// an Override toString() method
	@Override
	public String toString() {
		return nom;
	}
	

}
