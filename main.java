package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class main extends Application {

	private controller controller;

	// START
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("connectfour.fxml"));
		GridPane gridPane = loader.load();
		controller = loader.getController();
		controller.createPlayground();
		// Menu_Pane
		MenuBar menuBar = createMenu();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

		Pane pane = (Pane) gridPane.getChildren().get(0);
		pane.getChildren().add(menuBar);
		// End OF THE START
		Scene scene = new Scene(gridPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Connect4");
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	private MenuBar createMenu() {
		//FILE_MENU
		Menu fileMenu = new Menu("File");
		MenuItem newGame = new MenuItem("New Game");
		MenuItem resetGame = new MenuItem("Reset Game");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		MenuItem exitGame = new MenuItem("Exit Game");
		fileMenu.getItems().addAll(newGame, resetGame, separator, exitGame);
		exitGame.setOnAction(event -> exitGame());
		newGame.setOnAction(event -> {
			controller.resetGame();
			controller.playerOneTextField.setText(null);
			controller.playerTwoTextField.setText(null);
			controller.playerNameLabel.setText("PLayer One");
		});
		resetGame.setOnAction(event -> controller.resetGame());

		//HELP_MENU
		Menu helpMenu = new Menu("Help");
		MenuItem aboutGame = new MenuItem("About Game");
		MenuItem aboutMe = new MenuItem("About Me");
		SeparatorMenuItem separator1 = new SeparatorMenuItem();
		helpMenu.getItems().addAll(aboutGame, separator1, aboutMe);
		aboutGame.setOnAction(event -> aboutGame());
		aboutMe.setOnAction(event -> aboutMe());

		// MENU_BAR
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		return menuBar;
	}

	private void exitGame() {
		Platform.exit();
		System.exit(0);
	}

	private void aboutGame() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect4");
		alert.setHeaderText("How to Play?");
		alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid." +
				"The pieces fall straight down, occupying the next available space within the column." +
				"The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. " +
				"Connect Four is a solved game. The first player can always win by playing the right moves.");
		alert.show();

	}

	private void aboutMe() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About the developer");
		alert.setHeaderText("Mitul Tandon");
		alert.setContentText("I'm a Java and python Developer. I am also a data science student." +
				" I love to create games. Connect4 is one of them.");
		alert.show();
	}

	public static void main(String[] args) {
		System.out.println("main");
		launch(args);
	}

}
