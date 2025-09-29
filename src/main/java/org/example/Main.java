package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;


public class Main extends Application {

    TextField textInput;
    TextField resultArea;
    TextField searchBox;
    TextField replaceBox;
    Label statusLabel;

    public void start(Stage window) {

        textInput = new TextField();
        textInput.setPromptText("Enter your text here...");
        textInput.setPrefHeight(50);

        resultArea = new TextField();
        resultArea.setPrefHeight(50);
        resultArea.setEditable(false);

        searchBox = new TextField();
        searchBox.setPromptText("word to find");

        replaceBox = new TextField();
        replaceBox.setPromptText("word to replace with");

        statusLabel = new Label("Ready to process text");

        Button findButton = new Button("Find");
        Button replaceButton = new Button("Replace");
        Button resetButton = new Button("Clear");

        findButton.setOnAction(e -> findWords());
        replaceButton.setOnAction(e -> replaceWords());
        resetButton.setOnAction(e -> clearAll());

        HBox searchLayout = new HBox(10);
        VBox findSection = new VBox(5);
        findSection.getChildren().addAll(new Label("Find:"), searchBox);

        VBox replaceSection = new VBox(5);
        replaceSection.getChildren().addAll(new Label("Replace:"), replaceBox);

        searchLayout.getChildren().addAll(findSection, replaceSection);

        HBox buttonLayout = new HBox(10);
        buttonLayout.getChildren().addAll(findButton, replaceButton, resetButton);

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(15));

        mainLayout.getChildren().addAll(
                new Label("Text Processing Tool"),
                new Label("Input Text:"),
                textInput,
                searchLayout,
                buttonLayout,
                statusLabel,
                new Label("Output:"),
                resultArea
        );

        window.setScene(new Scene(mainLayout, 400, 400));
        window.setTitle("My Text Processor");
        window.show();
    }

    void findWords() {
        String text = textInput.getText();
        String word = searchBox.getText();

        if (text.isEmpty() || word.isEmpty()) {
            showMessage("Please fill in both text and search word");
            return;
        }

        String lowerText = text.toLowerCase();
        String lowerWord = word.toLowerCase();

        int count = 0;
        int position = lowerText.indexOf(lowerWord);

        while (position != -1) {
            count++;
            position = lowerText.indexOf(lowerWord, position + 1);
        }


        statusLabel.setText("Found " + count + " matches");
        resultArea.setText("Total matches found: " + count);
    }

    void replaceWords() {
        String text = textInput.getText();
        String find = searchBox.getText();
        String replace = replaceBox.getText();

        if (text.isEmpty() || find.isEmpty()) {
            showMessage("Please enter text and word to find");
            return;
        }

        String newText = text.replace(find, replace);
        resultArea.setText(newText);
        statusLabel.setText("Text replaced successfully");
    }

    void clearAll() {
        textInput.clear();
        resultArea.clear();
        searchBox.clear();
        replaceBox.clear();
        statusLabel.setText("Ready to process text");
    }

    void showMessage(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Notice");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}