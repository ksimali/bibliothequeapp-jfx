package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Livre;

public class BibliothequeApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Créer le TabPane pour gérer les onglets
		// & y insérer les onglets livres, utilisateurs et, emprunts via des méthodes. 
		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(creerOngletLivres(), creerOngletUtilisateurs(), creerOngletEmprunts());
		
		
		// Créer un VBOX pour organiser les composant verticalement
		VBox root = new VBox(10);
		root.getChildren().add(tabPane);
		
		// Configurer la scène
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setTitle("Application de Gestion de Bibliothèque");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	// Méthodes pour créer chaque onglet
	
	// Crée l'onglet pour la gestion des livres
	private Tab creerOngletLivres() {
		// creer un nouvel onglet
		Tab tabLivres = new Tab("Livres");
		
		//Ajouter les composants pour gérer les livres(TextField, ListView, Button)
		// Créer un TextField pour entrer le titre du livre
		TextField titreLivreField = new TextField();
		titreLivreField.setPromptText("Recherche du livre par titre");
		
		// Créer un bouton pour ajouter un nouveau livre à la liste
		Button ajouterLivreButton = new Button("Ajouter Livre");
		
		// Créer une ListView pour afficher la liste des livres
		ListView<Livre> listeLivres = new ListView<>();
		
		// Create a button to remove the selected book from the list
	    Button supprimerLivreButton = new Button("Supprimer Livre");
		
		// Create a container (VBox) to organize the components vertically
	    VBox vbox = new VBox(10); // Spacing of 10 pixels between elements
	    vbox.getChildren().addAll(titreLivreField, ajouterLivreButton, listeLivres, supprimerLivreButton);

	    // Set padding for the VBox to add spacing around the edges
	    vbox.setPadding(new Insets(10));

	    // Set the VBox as the content of the "Livres" tab
	    tabLivres.setContent(vbox);
	    
		// Implémenter le gui et la logique d'ajout/suppression de livres
		return tabLivres;
	}
	
	// Créer l'onglet pour la gestion des utilisateurs
	private Tab creerOngletUtilisateurs() {
		Tab tabUtilisateurs = new Tab("Utilisateurs");
		
		//
		return tabUtilisateurs;
	}		// Méthodes pour créer chaque onglet
	
	// Créer l'onglet pour la gestion des transactions d'emprunts
	private Tab creerOngletEmprunts() {
		Tab tabEmprunts = new Tab("Emprunts");
		
		return tabEmprunts;
	}
	
	
	// main method
	public static void main(String[] args) {
		launch(args);

	}

}
