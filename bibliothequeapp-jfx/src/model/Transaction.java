package model;

public class Transaction {
	// Attributs 
	private String utilisateur;
	private String livre;
	private boolean retourne;
	
	// Getters and Setters
	// Recupère le nom de l'utilisateur
	public String getUtilisateur() {
		return utilisateur;
	}
	// Recupère le titre du livre
	public String getLivre() {
		return livre;
	}
	
	// Method qui verifie si le livre a été retourné
	public boolean isRetourne() {
		return retourne;
	}
	// Constructeur avec 2 paramètres
	public Transaction(String utilisateur, String livre) {
		this.utilisateur = utilisateur;
		this.livre = livre;
		this.retourne = false;
	}
	
	// Methode retournerLivre() qui marque le livre comme retourné
	public void retournerLivre() {
		this.retourne = true;
	}
}
