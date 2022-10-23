package se.iths;

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

    public void initialize() {
        context = paintingArea.getGraphicsContext2D();
        context.setFill(Color.web("#eddeaf"));
        context.fillRect(0, 0, paintingArea.getWidth(), paintingArea.getHeight());
        colorPicker.valueProperty().bindBidirectional(model.colorProperty());
        shapeType.setValue("Choose shape");
        shapeType.setItems(model.getShapes());
    }


    public void canvasClicked(MouseEvent mouseEvent) {
        context.setFill(model.getColor());

        double sizeValue = sizeSetter.getValue();
        double X = mouseEvent.getX() - (sizeValue / 2);
        double Y = mouseEvent.getY() - (sizeValue / 2);

        if (shapeType.getValue().equals("Circle")) {
            context.fillOval(X, Y, sizeValue, sizeValue);
        } else if (shapeType.getValue().equals("Rectangle")) {
            context.fillRect(X, Y, sizeValue, sizeValue);
        }
    }
}