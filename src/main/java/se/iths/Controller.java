package se.iths;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import se.iths.shapes.Shape;
import se.iths.shapes.ShapeFactory;
import se.iths.shapes.ShapeParameter;
import se.iths.shapes.ShapeType;
import se.iths.svg.SVGWriter;

import java.util.Optional;

public class Controller {
    final static KeyCombination SAVE = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
    final static KeyCombination UNDO = new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN);
    final static KeyCombination REDO = new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN);

    public static final int MAX_WIDTH = 2000;
    public static final int MAX_HEIGHT = 1000;
    public static final Color BACKGROUND_COLOR = Color.web("#edece0");

    Model model = new Model();
    ShapeFactory shapeFactory = new ShapeFactory();
    SVGWriter svgWriter = new SVGWriter();
    ShapeParameter shapeParameter;
    public GraphicsContext context;
    public Spinner<Integer> sizeSpinner;
    public ChoiceBox<ShapeType> shapeType;
    public ColorPicker colorPicker;
    public Canvas paintingArea;
    public MenuItem menuUndo;
    public MenuItem menuSave;
    public MenuItem menuRedo;
    private Stage stage;


    public void initialize() {
        context = paintingArea.getGraphicsContext2D();

        colorPicker.valueProperty().bindBidirectional(model.colorProperty());

        shapeType.valueProperty().bindBidirectional(model.shapeTypeProperty());
        shapeType.setItems(model.getChoiceBoxShapeList());

        sizeSpinner.getValueFactory().valueProperty().bindBidirectional(model.sizeProperty());

        menuRedo.setAccelerator(REDO);
        menuUndo.setAccelerator(UNDO);
        menuSave.setAccelerator(SAVE);

        preparePaintingArea();
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        if (mouseEvent.isControlDown() && mouseEvent.isShiftDown())
            updateShape(mouseEvent);
        else if (mouseEvent.isControlDown())
            updateColor(mouseEvent);
        else if (mouseEvent.isShiftDown())
            updateSize(mouseEvent);
        else {
            createNewShape(mouseEvent);
        }
        draw();
    }

    private void createNewShape(MouseEvent mouseEvent) {
        createNewShapeParameter(mouseEvent.getX(), mouseEvent.getY());

        model.addToUndoDeque();
        model.getShapeList().add(shapeFactory.getShape(model.getShapeType(), shapeParameter));
    }

    private void createNewShapeParameter(double posX, double posY) {
        shapeParameter = new ShapeParameter(posX, posY, model.getSize(), model.getColor());
    }

    private void draw() {
        preparePaintingArea();
        model.getShapeList().forEach(shape -> shape.draw(context));
    }

    private void preparePaintingArea() {
        context.setFill(BACKGROUND_COLOR);
        context.fillRect(0, 0, MAX_WIDTH, MAX_HEIGHT);
    }

    public void undoClicked() {
        model.undo();
        draw();
    }

    public void redoClicked() {
        model.redo();
        draw();
    }

    public void updateShape(MouseEvent mouseEvent) {
        if (findShape(mouseEvent).isEmpty())
            return;
        model.addToUndoDeque();
        findShape(mouseEvent).ifPresent(shape -> shape.updateShape(model.getColor(), model.getSize()));
    }

    private void updateColor(MouseEvent mouseEvent) {
        if (findShape(mouseEvent).isEmpty())
            return;
        model.addToUndoDeque();
        findShape(mouseEvent).ifPresent(shape -> shape.setColor(model.getColor()));
    }

    private void updateSize(MouseEvent mouseEvent) {
        if (findShape(mouseEvent).isEmpty())
            return;
        model.addToUndoDeque();
        findShape(mouseEvent).ifPresent(shape -> shape.setSize(model.getSize()));
    }

    private Optional<Shape> findShape(MouseEvent mouseEvent) {
        return model.getShapeList().stream()
                .filter(shape -> shape.isInside(mouseEvent.getX(), mouseEvent.getY()))
                .reduce((first, second) -> second);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void save() {
        svgWriter.save(model, stage);
    }

    public void exit() {
        System.exit(0);
    }

    public void checkShortcut(KeyEvent keyEvent) {
        if (SAVE.match(keyEvent))
            save();
        else if (UNDO.match(keyEvent))
            undoClicked();
        else if (REDO.match(keyEvent))
            redoClicked();
    }
}