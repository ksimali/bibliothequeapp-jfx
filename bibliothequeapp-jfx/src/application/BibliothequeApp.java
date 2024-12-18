package application;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Livre;
import model.Transaction;
import model.Utilisateur;

public class BibliothequeApp extends Application {
	
	// ListView pour afficher la liste des livres
    private ListView<Livre> listeLivres = new ListView<>();
    // ListView pour afficher tous les utilisateurs
    private ListView<Utilisateur> listeUtilisateurs = new ListView<>();
    
    // Création du TableView pour afficher les transactions
    TableView<Transaction> tableEmprunts = new TableView<>();
    
    // Déclarez les ComboBox comme des variables d'instance
    private ComboBox<Utilisateur> comboBoxUtilisateurs = new ComboBox<>();
    private ComboBox<Livre> comboBoxLivres = new ComboBox<>();
    
    // List pour garder une trace des livres empruntés
    private List<Transaction> transactions = new ArrayList<>();
    
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
		
		//Ajouter les composants pour gérer les livres(TextField, ListView, AjouterLivreButton, SupprimerLivrebutton)
		// Créer un TextField pour entrer le titre du livre
		TextField titreLivreField = new TextField();
		titreLivreField.setPromptText("Titre du livre");
		
		// Créer un bouton pour ajouter un nouveau livre à la liste
		Button ajouterLivreButton = new Button("Ajouter Livre");
		
		// Créer une ListView pour afficher la liste des livres
	    listeLivres = new ListView<>();
	    
		// action à executé au click du bouton Ajouter Livre
		ajouterLivreButton.setOnAction((e) -> {
			String titre = titreLivreField.getText();
			if(!titre.isEmpty()) {
				// Ajouter un nouveau livre avec le titre indiqué dans le TextField
				listeLivres.getItems().add(new Livre(titre));
				// Delete le TextField après l'ajout
				titreLivreField.clear();
				// Met à jour les ComboBox dans l'onglet emprunts
		        updateComboBoxes();
			}
		});
		
		// Create a button to remove the selected book from the list
	    Button supprimerLivreButton = new Button("Supprimer Livre");
		
	    // Action à executé au click du button supprimer
 		supprimerLivreButton.setOnAction((e) -> {
 			Livre livreSelectionne = listeLivres.getSelectionModel().getSelectedItem();
 			if(livreSelectionne != null) {
 				listeLivres.getItems().remove(livreSelectionne);
 				// Met à jour les ComboBox dans l'onglet emprunts
 		        updateComboBoxes();
 			}
 		});
 		
		// Créer un conteneur (VBox) pour organiser les composants crées ci-dessus verticalement 
	    VBox vbox = new VBox(10); // espaces de  10 pixels entre les élements
	    vbox.getChildren().addAll(titreLivreField, ajouterLivreButton, listeLivres, supprimerLivreButton);

	    // Mettre a padding de 10px pour la VBox pour ajouter un espace autour du conteneur
	    vbox.setPadding(new Insets(10));

	    // Mettre la VBox comme contenu de l'onglet "Livres"
	    tabLivres.setContent(vbox);
	    
	
		return tabLivres;
	}
	
	// Créer l'onglet pour la gestion des utilisateurs
	private Tab creerOngletUtilisateurs() {
		Tab tabUtilisateurs = new Tab("Utilisateurs");
		
		// Ajout des composants pour gérer les utilisateurs(TextField, ListView, AjouterUserButton, SupprimerUserButton)
		// Ajout TextField pour entre le nom de l'utilisateur
		TextField nomUtilisateurField = new TextField();
		nomUtilisateurField.setPromptText("nom de l'utilisateur");
		
		// Créer un button pour ajouter un nouvel utilisateur
		Button ajouterUtilisateurButton = new Button("Ajouter utilisateur");
		
		// Créer un button pour supprimer un utilisateur
		Button supprimerUtilisateurButton = new Button("Supprimer utilisateur");
		
		// Créer une ListView pour afficher la liste des utilisateurs
		listeUtilisateurs = new ListView<>();
		
		// Logique d'ajout et suppression des utilisateurs
		ajouterUtilisateurButton.setOnAction((e) -> {
			// Récupérer le contenu du nomUtilisateurField
			String nom = nomUtilisateurField.getText();
			// Ajout un utilisateur avec le nom indiqué dans le nomUtilisateurField
			listeUtilisateurs.getItems().add(new Utilisateur(nom));
			// Delete le nomUtilisateurField après l'ajout
			nomUtilisateurField.clear();
			
			// Met à jour les ComboBox dans l'onglet emprunts
	        updateComboBoxes();
		});
		
		supprimerUtilisateurButton.setOnAction((e) -> {
			Utilisateur utilisateurSelectionne = listeUtilisateurs.getSelectionModel().getSelectedItem();
			if(utilisateurSelectionne != null) {
				listeUtilisateurs.getItems().remove(utilisateurSelectionne);
				// Mettez à jour les ComboBox dans l'onglet emprunts
		        updateComboBoxes();
			}
		});
		
		// Créer un conteneur (VBox) pour organiser les composants crées ci-dessus verticalement 
	    VBox vbox = new VBox(10); // espace de 10 pixels entre les elements
	    vbox.getChildren().addAll(nomUtilisateurField, ajouterUtilisateurButton, listeUtilisateurs, supprimerUtilisateurButton);

	    // Met un padding de 10px pour la VBox pour ajouter un espace autour du conteneur
	    vbox.setPadding(new Insets(10));

	    // Met la VBox comme le contenu de l'onglet "Utilisateurs"
	    tabUtilisateurs.setContent(vbox);
		
		return tabUtilisateurs;
	}
	
	// Créer l'onglet pour la gestion des transactions d'emprunts
	private Tab creerOngletEmprunts() {
		// Créer l'onglet Emprunts
		Tab tabEmprunts = new Tab("Emprunts");
		
		// Initialisation ComboBox pour sélectionner l'utilisateur
		comboBoxUtilisateurs.setPromptText("Selectionner un utilisateur");
			
		// Initialisation ComboBox pour sélectionner un livre
		comboBoxLivres.setPromptText("Selectionner un livre");
		
		// Récupération des données et ajout aux ComboBox
		updateComboBoxes();

	    // Colonne pour le titre du livre
	    TableColumn<Transaction, String> colonneLivre = new TableColumn<>("Livre");
	    colonneLivre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLivre().getTitre()));

	    // Colonne pour le nom de l'utilisateur
	    TableColumn<Transaction, String> colonneUtilisateur = new TableColumn<>("Utilisateur");
	    colonneUtilisateur.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getUtilisateur().getNom()));

	    // Colonne pour le statut de l'emprunt
	    TableColumn<Transaction, String> colonneStatut = new TableColumn<>("Statut");
	    colonneStatut.setCellValueFactory(data -> new SimpleStringProperty(
	        data.getValue().isRetourne() ? "Retourné" : "En cours"));

	    // Ajout des colonnes au TableView
	    tableEmprunts.getColumns().addAll(colonneLivre, colonneUtilisateur, colonneStatut);
	    
		// Créer les  boutons pour enregistrer un emprunt, retourner livre et supprimer transaction
		Button enregistrerEmpruntButton = new Button("Enregistrer Emprunt");
		Button retournerLivreButton = new Button("Retourner Livre");
		Button supprimerTransactionButton = new Button("Supprimer Transaction");
		
		// Action pour enregistrer un nouvel emprunt
	    enregistrerEmpruntButton.setOnAction((e) -> {
	        Utilisateur utilisateur = comboBoxUtilisateurs.getValue();
	        Livre livre = comboBoxLivres.getValue();
	        
	        if (utilisateur != null && livre != null) {
	        	// Vérifier si le livre est déjà emprunté (statut "En cours")
	        	boolean livreDejaEmprunte = false;
	        	for(Transaction transaction : transactions) {
	        		if(transaction.getLivre().equals(livre) && !transaction.isRetourne()) {
	        			livreDejaEmprunte = true;
	        			break;
	        		}
	        	}
	        	
	        	// Si le livre est déjà emprunté, afficher un message d'erreur
	        	if(livreDejaEmprunte) {
	        		System.out.println("Le livre est déjà emprunté ! Choisir un autre livre.");
	        	}else {
	        		// Ajouter la transaction d'emprunt
	        		Transaction transaction = new Transaction(utilisateur, livre);
	 	            transactions.add(transaction);
	 	            rafraichirListeEmprunts();
	        	}
	           
	        }
	    });
		
		// Action pour marquer un livre comme retourné
	    retournerLivreButton.setOnAction((e) -> {
	        Transaction transactionSelectionnee = tableEmprunts.getSelectionModel().getSelectedItem();
	        if (transactionSelectionnee != null && !transactionSelectionnee.isRetourne()) {
	            transactionSelectionnee.setRetourne(true);
	            rafraichirListeEmprunts();
	        }
	    });
		
		// Action pour supprimer une transaction d'emprunt
	    supprimerTransactionButton.setOnAction((e) -> {
	        Transaction transactionSelectionnee = tableEmprunts.getSelectionModel().getSelectedItem();
	        if (transactionSelectionnee != null) {
	            transactions.remove(transactionSelectionnee);
	            rafraichirListeEmprunts();
	        }
	    });
		
		// Ajout des composant(ComboBox, bouton et ListView) à un conteneur vertical
		// Créer un conteneur (VBox) pour organiser les composants crées ci-dessus verticalement 
	    VBox vbox = new VBox(10); // espaces de  10 pixels entre les élements
	    vbox.getChildren().addAll(comboBoxUtilisateurs, comboBoxLivres, tableEmprunts, enregistrerEmpruntButton, retournerLivreButton, supprimerTransactionButton);

	    // Mettre a padding de 10px pour la VBox pour ajouter un espace autour du conteneur
	    vbox.setPadding(new Insets(10));

	    // Mettre la VBox comme contenu de l'onglet "Emprunts"
	    tabEmprunts.setContent(vbox);
		return tabEmprunts;
	}
	
	// Methode pour mettre a jour le contenu des ComboBox
	private void updateComboBoxes() {
	    comboBoxUtilisateurs.getItems().clear(); // Vide les ComboBox
	    comboBoxLivres.getItems().clear();
	    
	    // Ajoute les utilisateurs et livres actuels aux ComboBox
	    comboBoxUtilisateurs.getItems().addAll(listeUtilisateurs.getItems());
	    comboBoxLivres.getItems().addAll(listeLivres.getItems());
	}
	
	// Update Liste Emprunts
	private void rafraichirListeEmprunts() {
	    tableEmprunts.getItems().clear();
	    for (Transaction transaction : transactions) {
	    	tableEmprunts.getItems().add(transaction);
	    }
	}
	
	
	// main method
	public static void main(String[] args) {
		launch(args);

	}

}
