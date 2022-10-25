package se.iths;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import se.iths.shapes.ShapeFactory;
import se.iths.shapes.shapeParameter;

public class Controller {
    Model model = new Model();
    ShapeFactory shapeFactory = new ShapeFactory();

    public static final int MAX_WIDTH = 2000;
    public static final int MAX_HEIGHT = 1000;
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

        preparePaintingArea();

        colorPicker.valueProperty().bindBidirectional(model.colorProperty());

        shapeType.valueProperty().bindBidirectional(model.currentShapeProperty());
        shapeType.setItems(model.getChoiceBoxShapeList());

        sizeSpinner.getValueFactory().valueProperty().bindBidirectional(model.sizeProperty());


        currentSize = sizeSpinner.getValue();
        sizeSpinner.valueProperty().addListener((observable, oldValue, newValue) -> currentSize = sizeSpinner.getValue());
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        double X = mouseEvent.getX() - (currentSize >> 1);
        double Y = mouseEvent.getY() - (currentSize >> 1);

        var shapeParameter = new shapeParameter(X, Y, currentSize, colorPicker);
        model.getShapeList().addLast(shapeFactory.getShape(shapeType.getValue(), shapeParameter));
        model.prepareDrawing();
        draw();
    }

    private void draw() {
        preparePaintingArea();
        model.getShapeList().forEach(shape -> shape.draw(context));
    }

    private void preparePaintingArea() {
        context.setFill(Color.web("#edece0"));
        context.fillRect(0, 0, MAX_WIDTH, MAX_HEIGHT);
    }

    public void undoClicked() {
        model.undo();
        draw();
    }

    public void exit() {
        System.exit(0);
    }
}