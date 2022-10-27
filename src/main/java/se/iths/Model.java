package se.iths;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import se.iths.shapes.*;

import java.util.ArrayDeque;
import java.util.Deque;

public class Model {
    Shape[] shapeNames = {new Circle(), new Square()};
    private final ObservableList<Shape> choiceBoxShapeList = FXCollections.observableArrayList(shapeNames);
    private Deque<Shape> tempList;
    public Deque<Shape> shapeList;
    private final ObjectProperty<Integer> size;
    private final ObjectProperty<Color> color;
    public final ObjectProperty<Shape> shape;

    public Model() {
        this.shapeList = new ArrayDeque<>();
        this.tempList = new ArrayDeque<>();
        this.color = new SimpleObjectProperty<>(Color.web("#004B87"));
        this.size = new SimpleObjectProperty<>(50);
        this.shape = new SimpleObjectProperty<>();
    }

    public ObjectProperty<Shape> shapeProperty() {
        return shape;
    }

    public Shape getShape() {
        return shape.get();
    }

    public void setShape(Shape shape) {
        this.shape.set(shape);
    }

    public Property<Integer> sizeProperty() {
        return size;
    }

    public Integer getSize() {
        return size.get();
    }

    public void setSize(Integer size) {
        this.size.set(size);
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public Color getColor() {
        return color.get();
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public ObservableList<Shape> getChoiceBoxShapeList() {
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

    public void prepareDrawingList() {
        tempList = shapeList;
    }
}