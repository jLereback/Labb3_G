package se.iths;

import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    Model model = new Model();
    public MenuBar menuBar;
    public ToolBar toolBar;
    public Spinner<Integer> sizeSetter;
    public ChoiceBox<String> shapeType;
    public Button buttonUndo;
    public ColorPicker colorPicker;
    public Canvas paintingArea;

    public GraphicsContext context;

    int currentSize;

    public void initialize() {
        context = paintingArea.getGraphicsContext2D();
        context.setFill(Color.web("#eddeaf"));
        context.fillRect(0, 0, paintingArea.getWidth(), paintingArea.getHeight());
        colorPicker.valueProperty().bindBidirectional(model.colorProperty());
        shapeType.setValue("Choose shape");
        shapeType.setItems(model.getShapes());



/*
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
        valueFactory.setValue(10);
        currentSize = sizeSetter.getValue();
        sizeSetter.valueProperty().addListener((observable, oldValue, newValue) -> currentSize = sizeSetter.getValue());
*/
    }


    public void canvasClicked(MouseEvent mouseEvent) {
        context.setFill(model.getColor());

        currentSize = sizeSetter.getValue();
        double X = mouseEvent.getX() - (currentSize >> 1);
        double Y = mouseEvent.getY() - (currentSize >> 1);

        if (shapeType.getValue().equals("Circle")) {
            context.fillOval(X, Y, currentSize, currentSize);
        } else if (shapeType.getValue().equals("Rectangle")) {
            context.fillRect(X, Y, currentSize, currentSize);
        }
    }

    public void undoClicked(ActionEvent actionEvent) {

    }
}