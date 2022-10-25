package se.iths;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import se.iths.shapes.Shape;

import java.util.ArrayDeque;
import java.util.Deque;

public class Model {
    String[] shapeNames = {"Circle", "Square"};
    private final ObservableList<String> choiceBoxShapeList = FXCollections.observableArrayList(shapeNames);
    private Deque<Shape> tempList;
    public Deque<Shape> shapeList;
    private final Property<Integer> size;
    private final ObjectProperty<Color> color;
    public final ObjectProperty<String> currentShape;

    public Model() {
        this.shapeList = new ArrayDeque<>();
        this.tempList = new ArrayDeque<>();
        this.color = new SimpleObjectProperty<>(Color.web("#004B87"));
        this.size = new SimpleObjectProperty<>(50);
        this.currentShape = new SimpleObjectProperty<>("Choose shape");
    }
    public ObjectProperty<String> currentShapeProperty() {
        return currentShape;
    }
    public Property<Integer> sizeProperty() {
        return size;
    }
    public ObjectProperty<Color> colorProperty() {
        return color;
    }
    public ObservableList<String> getChoiceBoxShapeList() {
        return choiceBoxShapeList;
    }
    public Deque<Shape> getShapeList() {
        return shapeList;
    }
    public void undo() {
        if (tempList.isEmpty())
            return;
        tempList.removeLast();
        shapeList = tempList;
    }
    public void prepareDrawing() {
        tempList = shapeList;
    }
}