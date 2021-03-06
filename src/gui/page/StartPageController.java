package gui.page;

import gui.ControllerHelper;
import gui.PageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartPageController {

    @FXML
    private Button buttonHoS, buttonDVIR;

    private PageController pageController = PageController.getInstance();

    @FXML
    private void initialize(){
    }

    @FXML
    private void buttonHoSClicked(ActionEvent actionEvent) {
        pageController.setPage( ControllerHelper.getHoSPage() );
    }

    @FXML
    private void buttonDVIRClicked(ActionEvent actionEvent) {
    }
}
