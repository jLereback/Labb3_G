package se.iths;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import se.iths.shapes.Shape;
import se.iths.shapes.ShapeFactory;
import se.iths.shapes.ShapeParameter;

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
    public ChoiceBox<Shape> shapeType;
    public Button buttonUndo;
    public ColorPicker colorPicker;
    public Canvas paintingArea;

    public GraphicsContext context;



    public void initialize() {
        context = paintingArea.getGraphicsContext2D();

        preparePaintingArea();

        colorPicker.valueProperty().bindBidirectional(model.colorProperty());

        shapeType.valueProperty().bindBidirectional(model.shapeProperty());
        shapeType.setItems(model.getChoiceBoxShapeList());

        sizeSpinner.getValueFactory().valueProperty().bindBidirectional(model.sizeProperty());
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        double centerX = mouseEvent.getX() - (model.getSize() >> 1);
        double centerY = mouseEvent.getY() - (model.getSize() >> 1);
        if (mouseEvent.isControlDown()) {
            selectShape(mouseEvent);
        }
        else {

            var shapeParameter = new ShapeParameter(centerX, centerY, model.getSize(), model.getColor());

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


    public void selectShape(MouseEvent mouseEvent) {
        double posX = mouseEvent.getX();
        double posY = mouseEvent.getY();

        model.getShapeList().stream()
                .filter(shape -> shape.isInside(posX,posY))
                .reduce((first , second) -> second)
                .ifPresent(shape -> shape.);
    }
/*
    private void changeShapeSize(MouseEvent event) {
        model.shapes.stream()
                .filter(shape -> shape.isInside(event.getX(), event.getY()))
                .reduce((first, second) -> second)
                .ifPresent(shape -> shape.setSize(sizeSpinner.getValue()));
    }

    private void changeShapeColor(MouseEvent event) {
        model.shapes.stream()
                .filter(shape -> shape.isInside(event.getX(), event.getY()))
                .reduce((first, second) -> second)
                .ifPresent(shape -> shape.setColor(model.getColor()));
    }
*/

    public void exit() {
        System.exit(0);
    }
}
