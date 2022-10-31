package se.iths;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import se.iths.shapes.*;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;
import static se.iths.shapes.ShapeType.*;

class ModelTest {
    Color GRAY_GREEN = Color.web("#63967a");
    Color BLUE = Color.web("#004B87");
    Color PEACH = Color.web("#e0b494");

    int SMALL_SIZE = 5;
    int MEDIUM_SIZE = 50;
    int BIG_SIZE = 200;

    Model model = new Model();
    Controller controller = new Controller();
    ShapeFactory shapeFactory = new ShapeFactory();
    ShapeParameter parameter1 = new ShapeParameter(125, 150, MEDIUM_SIZE, BLUE);
    ShapeParameter parameter2 = new ShapeParameter(125, 150, SMALL_SIZE, GRAY_GREEN);
    ShapeParameter parameter3 = new ShapeParameter(125, 150, BIG_SIZE, PEACH);

    Shape mediumCircle = new Circle(parameter1);
    Shape smallSquare = new Square(parameter2);
    Shape bigCircle = new Circle(parameter3);

    private void prepareShapeListAndUndoDeque() {
        model.addToUndoDeque();
        model.shapeList.add(mediumCircle);
        model.addToUndoDeque();
        model.shapeList.add(smallSquare);
        model.addToUndoDeque();
        model.shapeList.add(bigCircle);
    }

    @Test
    void getShapeReturnsNewShapeWithTheSameShapeTypeAsInput() {
        Shape shape = shapeFactory.getShape(model.getShapeType(), parameter1);
        ShapeType actual = shape.getType();

        assertEquals(CIRCLE, actual);
    }

    @Test
    void setShapeTypeInModelShouldNotResultInChangedShapeTypeForTheShape() {
        Shape shape = shapeFactory.getShape(model.getShapeType(), parameter1);
        model.setShapeType(SQUARE);
        ShapeType actual = shape.getType();

        assertEquals(CIRCLE, actual, "The type of a shape should not be able to be changed");
    }

    @Test
    void undoOnPreparedShapeListResultInUndoDequeLastElementOneSizeLargerThenShapeList() {
        prepareShapeListAndUndoDeque();

        model.undo();
        int expected = model.getShapeList().size() - 1;
        int actual = model.getUndoDeque().getLast().size();

        assertEquals(expected, actual, "UndoDeque´s last element should have the size of ShapeList - 1");
    }

    @Test
    void undoOnPreparedShapeListResultInUndoDequeWithSameSizeAsShapeList() {
        prepareShapeListAndUndoDeque();

        model.undo();
        int expected = model.getShapeList().size();
        int actual = model.getUndoDeque().size();

        assertEquals(expected, actual, "UndoDeque should have the same size as shapeList");
    }

    @Test
    void undoAndRedoOnceOnPreparedShapeListResultInEmptyRedoDeque() {
        prepareShapeListAndUndoDeque();

        model.undo();
        model.redo();
        int actual = model.getRedoDeque().size();

        assertEquals(0, actual, "RedoDeque should be empty");
    }
}