package gui.page;

import gui.ControllerHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import model.UserList;

public class NewUserPageController {

    @FXML
    private Parent newUserPage;
    @FXML
    private Label labelLicNumber, labelID, labelFirstName, labelMiddleName, labelLastName, labelStatus, labelIssuedState, labelUsername, labelIssuedCountry, labelPassword;
    @FXML
    private TextField textFieldLicNumber, textFieldIssuedState, textFieldIssuedCountry, textFieldUsername, textFieldPassword,  textFieldFirstName, textFieldID, textFieldMiddleName, textFieldLastName;
    @FXML
    private ComboBox<String> comboBoxStatus;
    @FXML
    private Button buttonSaveNew;

    @FXML
    private void initialize(){
        group( labelID, textFieldID );
        group( labelFirstName, textFieldFirstName );
        group( labelLastName, textFieldLastName );
        group( labelMiddleName, textFieldMiddleName );
        group( labelLicNumber, textFieldLicNumber );
        group( labelStatus, comboBoxStatus );
        group( labelIssuedState, textFieldIssuedState );
        group( labelIssuedCountry, textFieldIssuedCountry );
        group( labelUsername, textFieldUsername );
        group( labelPassword, textFieldPassword );
    }

    private void group(Label label, TextField textField) {
        textField.heightProperty().addListener( (observable, oldValue, newValue) -> {
            label.setPrefHeight( newValue.doubleValue() );
        } );
    }

    private void group(Label label, ComboBox comboBox) {
        comboBox.heightProperty().addListener( (observable, oldValue, newValue) -> {
            label.setPrefHeight( newValue.doubleValue() );
        } );
    }


    @FXML
    private void buttonSaveNewClicked(ActionEvent actionEvent) {
        if ( ControllerHelper.showConfirmationWindow( "Save", "Are you sure you want to save this user?" ) ) {
            saveUser();
            close();
        }
    }

    @FXML
    private void buttonCancelNewClicked(ActionEvent actionEvent) {
        if ( ControllerHelper.showConfirmationWindow( "Cancel", "Are you sure you want to cancel user saving?" ) ) {
            close();
        }
    }

    private void close(){
        ( (Stage)(newUserPage.getScene().getWindow()) ).close();
    }

    private void saveUser(){
        UserList.getInstance().add( getUser() );
    }

    public User getUser(){
        String ID = textFieldID.getText();
        String firstName = textFieldFirstName.getText();
        String middleName = textFieldMiddleName.getText();
        String lastName = textFieldLastName.getText();
        String licNumber = textFieldLicNumber.getText();
        String status = comboBoxStatus.getValue();
        String issuedCountry = textFieldIssuedCountry.getText();
        String issuedState = textFieldIssuedCountry.getText();
        String username = textFieldUsername.getText();
        String password = textFieldPassword.getText();
        return new User(ID, username, password, firstName, middleName, lastName, licNumber, status, issuedState, issuedCountry, false, null);
    }
}