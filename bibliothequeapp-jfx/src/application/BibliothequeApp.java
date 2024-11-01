package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
		
		// Creer a conteneur VBox container pour organiser verticallement les composants.
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(
				);		
		// mettre un padding a la VBox
		vbox.setPadding(new Insets(10));
		
		// mettre la VBox comme de l'onglet tab
		tabLivres.setContent(vbox);
		
		return tabLivres;
	}
	
	// Créer l'onglet pour la gestion des utilisateurs
	private Tab creerOngletUtilisateurs() {
		Tab tabUtilisateurs = new Tab("Utilisateurs");
		
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
