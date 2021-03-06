package gui.page;

import gui.ControllerHelper;
import gui.PageController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import domain.model.DutyStatus;
import domain.model.LogbookStatus;
import domain.model.Mediator;

public class ChangeStatusPageController {

    @FXML
    private HBox changeStatusPage;

    private PageController pageController = PageController.getInstance();

    @FXML
    private void initialize(){
        DutyStatus[] statusValues = DutyStatus.values();
        for (DutyStatus statusValue : statusValues) {
            Button statusButton = new Button( statusValue.toString() );
            statusButton.setStyle( "-fx-background-color: " + statusValue.getColorHexCode() + ";" );
            statusButton.getStyleClass().add( "changeStatusButton" );
            statusButton.getStylesheets().add( ControllerHelper.class.getResource( "util.css" ).toExternalForm() );
            statusButton.setOnAction( event -> {
                DutyStatus buttonStatusValue = DutyStatus.valueOf( statusButton.getText() );
                Mediator.getInstance().changeStatus( LogbookStatus.APPROVED, "", "", buttonStatusValue );
                close();
            } );
            changeStatusPage.getChildren().add( statusButton );
        }
    }

    private void close(){
        ( (Stage) (changeStatusPage.getScene().getWindow()) ).close();
    }
}
