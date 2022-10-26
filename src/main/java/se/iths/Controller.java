package se.iths;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import se.iths.shapes.ShapeFactory;
import se.iths.shapes.shapeParameter;

public class Controller {
    public static final int TOP_EDGE = 0;
    public static final int LEFT_EDGE = 0;
    public static final int MAX_WIDTH = 2000;
    public static final int MAX_HEIGHT = 1000;

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
    Color currentColor;

    public void initialize() {
        context = paintingArea.getGraphicsContext2D();

        preparePaintingArea();

        colorPicker.valueProperty().bindBidirectional(model.colorProperty());

        shapeType.valueProperty().bindBidirectional(model.shapeProperty());
        shapeType.setItems(model.getChoiceBoxShapeList());

        sizeSpinner.getValueFactory().valueProperty().bindBidirectional(model.sizeProperty());

        currentSize = model.getSize();
        sizeSpinner.valueProperty().addListener((observable, oldValue, newValue) -> currentSize = model.getSize());

        currentColor = model.getColor();
        colorPicker.valueProperty().addListener((observable, oldValue, newValue) -> currentColor = model.getColor());
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        double centerX = mouseEvent.getX() - (currentSize >> 1);
        double centerY = mouseEvent.getY() - (currentSize >> 1);
        if (mouseEvent.isControlDown()) {
            selectShape();
        }
        else {

            var shapeParameter = new shapeParameter(centerX, centerY, currentSize, currentColor);

            model.prepareDrawingList();

            model.getShapeList().addLast(shapeFactory.getNewShape(shapeType.getValue(), shapeParameter));

            draw();
        }
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

    public void selectShape() {

    }

    public void exit() {
        System.exit(0);
    }
}
