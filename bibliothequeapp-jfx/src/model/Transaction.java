package model;

public class Transaction {
	// Attriubtes
	private String utilisateur;
	private String livre;
	private boolean retourne;
	
	// Getters and Setters
	public String getUtilisateur() {
		return utilisateur;
	}
	
	public String getLivre() {
		return livre;
	}
	
	public boolean isRetourne() {
		return retourne;
	}
	// Constructor
	public Transaction(String utilisateur, String livre) {
		this.utilisateur = utilisateur;
		this.livre = livre;
		this.retourne = false;
	}
	
	// Method retournerLivre()
	public void retournerLivre() {
		this.retourne = true;
	}
}
