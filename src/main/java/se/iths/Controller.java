package se.iths;

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
    public Spinner<Integer> sizeSpinner;
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

        currentSize = sizeSpinner.getValue();

        sizeSpinner.valueProperty().addListener((observable, oldValue, newValue) -> currentSize = sizeSpinner.getValue());
    }


    public void canvasClicked(MouseEvent mouseEvent) {
        context.setFill(model.getColor());

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