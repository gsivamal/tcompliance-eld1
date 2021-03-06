package gui.page.tab;

import gui.ControllerHelper;
import gui.PageController;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.StageStyle;
import domain.model.Driver;
import domain.model.Mediator;


public class DriverListTabController {



    private PageController pageController = PageController.getInstance();
    @FXML
    private TableView<Driver> tableUserList;
    @FXML
    private TableColumn<Driver, String> tableColumnID, tableColumnFirstName, tableColumnLastName, tableColumnLicNumber, tableColumnUsername, tableColumnStatus;
    @FXML
    private Button buttonNew, buttonDisable, buttonDelete;

    @FXML
    private void initialize(){
        tableColumnID.prefWidthProperty().bind( tableUserList.widthProperty().multiply( 0.06 ) );
        tableColumnFirstName.prefWidthProperty().bind( tableUserList.widthProperty().multiply( 0.235 ) );
        tableColumnLastName.prefWidthProperty().bind( tableUserList.widthProperty().multiply( 0.235 ) );
        tableColumnLicNumber.prefWidthProperty().bind( tableUserList.widthProperty().multiply( 0.20 ) );
        tableColumnUsername.prefWidthProperty().bind( tableUserList.widthProperty().multiply( 0.1699 ) );
        tableColumnStatus.prefWidthProperty().bind( tableUserList.widthProperty().multiply( 0.1 ) );
        tableUserList.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableColumnID.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf( cellData.getValue().getID() ) ) );
        tableColumnFirstName.setCellValueFactory( cellData -> cellData.getValue().firstNameProperty() );
        tableColumnLastName.setCellValueFactory( cellData -> cellData.getValue().lastNameProperty() );
        tableColumnLicNumber.setCellValueFactory( cellData -> cellData.getValue().licNumberProperty() );
        tableColumnUsername.setCellValueFactory( cellData -> cellData.getValue().usernameProperty() );
        tableColumnStatus.setCellValueFactory( cellData -> cellData.getValue().statusProperty() );

        tableUserList.setItems( Mediator.getInstance().getDriverList() );



    }

    @FXML
    private void buttonNewClicked(ActionEvent actionEvent) {
        Alert alert = new Alert( Alert.AlertType.NONE );
        alert.initStyle( StageStyle.UNDECORATED );
        alert.setResizable( false );
        alert.getDialogPane().setContent( ControllerHelper.getAddUserPage() );
        alert.getDialogPane().getStylesheets().add( ControllerHelper.getUtilCSSFile() );
        alert.getDialogPane().setStyle( "-fx-border-color: #4f81bd;" +
                "-fx-border-width: 5px;" );
        alert.showAndWait();
    }

    @FXML
    private void buttonDisableClicked(ActionEvent actionEvent) {
        Driver selected = getSelected();
        if ( selected != null ) {
            if ( ControllerHelper.showConfirmationWindow( "Disable user", "Are you sure you want to disable user ID: " + selected.getID() ) ) {
                selected.setStatus( "Inactive" );
            }
        }
    }

    @FXML
    private void buttonDeleteClicked(ActionEvent actionEvent) {
        Driver selected = getSelected();
        if ( selected != null ) {
            if ( ControllerHelper.showConfirmationWindow( "Delete user", "Are you sure you want to delete user ID: " + selected.getID() ) ) {
                Mediator.getInstance().removeDriver( selected );
            }
        }
    }

    private Driver getSelected(){
        return tableUserList.getSelectionModel().getSelectedItem();
    }
}
