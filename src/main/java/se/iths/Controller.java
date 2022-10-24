package se.iths;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import se.iths.shapes.ShapeFactory;
import se.iths.shapes.ShapeData;

public class Controller {
    Model model = new Model();
    ShapeFactory shapeFactory = new ShapeFactory();
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

        context.setFill(Color.web("#edece0"));
        context.fillRect(0, 0, 1600, 800);

        colorPicker.valueProperty().bindBidirectional(model.colorProperty());

        shapeType.valueProperty().bindBidirectional(model.shapeProperty());
        shapeType.setItems(model.getShapes());

        sizeSpinner.getValueFactory().valueProperty().bindBidirectional(model.sizeProperty());


        currentSize = sizeSpinner.getValue();
        sizeSpinner.valueProperty().addListener((observable, oldValue, newValue) -> currentSize = sizeSpinner.getValue());
    }
    public void canvasClicked(MouseEvent mouseEvent) {
        double X = mouseEvent.getX() - (currentSize >> 1);
        double Y = mouseEvent.getY() - (currentSize >> 1);

        var shapeValue = new ShapeData(X, Y, currentSize, colorPicker);
        shapeFactory.getShape(shapeType.getValue(), shapeValue).draw(context);
    }

    public void undoClicked(ActionEvent actionEvent) {

    }
}