package com.example.javafxjavadoc;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class RegistrationFormController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField dobField;
    @FXML
    private TextField zipCodeField;
    @FXML
    private Button addButton;
    @FXML
    private Label statusLabel;

    public void initialize() {
        addButton.setDisable(true);

        firstNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) validateFirstName();
            toggleAddButton();
        });
        lastNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) validateLastName();
            toggleAddButton();
        });
        emailField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) validateEmail();
            toggleAddButton();
        });
        dobField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) validateDOB();
            toggleAddButton();
        });
        zipCodeField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) validateZipCode();
            toggleAddButton();
        });
    }

    private void validateFirstName() {
        if (!firstNameField.getText().matches("[A-Za-z]{2,25}")) {
            statusLabel.setText("First Name must be 2-25 alphabetic characters.");
        } else {
            statusLabel.setText("");
        }
    }

    private void validateLastName() {
        if (!lastNameField.getText().matches("[A-Za-z]{2,25}")) {
            statusLabel.setText("Last Name must be 2-25 alphabetic characters.");
        } else {
            statusLabel.setText("");
        }
    }

    private void validateEmail() {
        if (!emailField.getText().matches("[A-Za-z0-9._%+-]+@farmingdale\\.edu")) {
            statusLabel.setText("Email must be a valid Farmingdale address.");
        } else {
            statusLabel.setText("");
        }
    }

    private void validateDOB() {
        if (!dobField.getText().matches("(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}")) {
            statusLabel.setText("Date of Birth must be in MM/DD/YYYY format.");
        } else {
            statusLabel.setText("");
        }
    }

    private void validateZipCode() {
        if (!zipCodeField.getText().matches("\\d{5}")) {
            statusLabel.setText("Zip Code must be a 5-digit number.");
        } else {
            statusLabel.setText("");
        }
    }

    private void toggleAddButton() {
        addButton.setDisable(!isFormValid());
    }

    private boolean isFormValid() {
        return firstNameField.getText().matches("[A-Za-z]{2,25}")
                && lastNameField.getText().matches("[A-Za-z]{2,25}")
                && emailField.getText().matches("[A-Za-z0-9._%+-]+@farmingdale\\.edu")
                && dobField.getText().matches("(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}")
                && zipCodeField.getText().matches("\\d{5}");
    }

    @FXML
    private void handleAdd() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("success_scene.fxml"));
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Registration Successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
