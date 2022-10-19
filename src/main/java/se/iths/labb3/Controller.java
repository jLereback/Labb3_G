package se.iths.labb3;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    Model model = new Model();
    public MenuBar menuBar;
    public CheckMenuItem connectToServer;
    public ToolBar toolBar;
    public Spinner<Integer> sizeSetter;
    public ChoiceBox<String> shapeChooser;
    public Button buttonUndo;
    public Button buttonRedo;
    public ColorPicker colorPicker;


    @FXML
    protected void initialize() {
        connectToServer.selectedProperty().bindBidirectional(model.connectedProperty());
        connectedToServer.visibleProperty().bind(model.connectedProperty());
        buttonRedo.disableProperty().bind(model.connectedProperty());
    }


    @FXML
    private Label connectedToServer;


}