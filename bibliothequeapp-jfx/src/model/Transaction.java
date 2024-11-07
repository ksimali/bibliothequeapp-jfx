package model;

public class Transaction {
    // Attributs 
    private Utilisateur utilisateur; // Nom du user qui a emprunté le livre
    private Livre livre; // titre du livre emprunté
    private boolean estRetourne; // statut de retour du livre
    
    // Getters and Setters
    // Récupère le nom de l'utilisateur
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    // Récupère le titre du livre
    public Livre getLivre() {
        return livre;
    }
    
    // Méthode qui vérifie si le livre a été retourné
    public boolean isRetourne() {
        return estRetourne;
    }

    // Constructeur avec 2 paramètres
    public Transaction(Utilisateur utilisateur, Livre livre) {
        this.utilisateur = utilisateur;
        this.livre = livre;
        this.estRetourne = false; // Par défaut, l'emprunt n'est pas retourné
    }

    // Méthode setRetourne() qui marque le livre comme retourné
    public void setRetourne(boolean estRetourne) {
        this.estRetourne = estRetourne;
    }
    
    // Méthode pour afficher l'information de la transaction sous forme de chaîne de caractères
    @Override
    public String toString() {
        return "Transaction [Utilisateur=" + utilisateur.getNom() 
                + ", Livre=" + livre.getTitre() 
                + ", Statut=" + (estRetourne ? "Retourne" : "Emprunte") + "]";
    }
}
