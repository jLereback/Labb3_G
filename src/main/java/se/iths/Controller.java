package se.iths;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import se.iths.shapes.ShapeFactory;
import se.iths.shapes.ShapeParameter;
import se.iths.shapes.ShapeType;

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
    public ChoiceBox<ShapeType> shapeType;
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


        shapeType.hoverProperty().addListener(observable -> System.out.println("test"));
    }

/*    public void hoverShape(DragEvent dragEvent) {
        model.getShapeList().stream()
                .filter(shape -> shape.isInside(dragEvent.getX(), dragEvent.getY()))
                .reduce((first, second) -> second)
                .ifPresent(shape -> shape.updateShape(model.getColor(), model.getSize()));
        context.getCanvas().getGraphicsContext2D();
        draw();
    }*/

        public void canvasClicked(MouseEvent mouseEvent) {
        double posX = mouseEvent.getX() - (model.getSize() >> 1);
        double posY = mouseEvent.getY() - (model.getSize() >> 1);
        if (mouseEvent.isControlDown()) {
            selectShape(mouseEvent);
        } else {

            var shapeParameter = new ShapeParameter(posX, posY, model.getSize(), model.getColor());

            model.prepareDrawingList();

            model.getShapeList().addLast(shapeFactory.getShape(shapeType.getValue(), shapeParameter));

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
        model.getShapeList().stream()
                .filter(shape -> shape.isInside(mouseEvent.getX(), mouseEvent.getY()))
                .reduce((first, second) -> second)
                .ifPresent(shape -> shape.updateShape(model.getColor(), model.getSize()));
        draw();
    }

    public void exit() {
        System.exit(0);
    }
}
