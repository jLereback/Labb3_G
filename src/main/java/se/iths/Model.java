package se.iths;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import se.iths.shapes.*;

import java.util.ArrayDeque;
import java.util.Deque;

import static se.iths.shapes.ShapeType.*;

public class Model {
    ShapeType[] shapeNames = ShapeType.values();
    private final ObservableList<ShapeType> choiceBoxShapeList = FXCollections.observableArrayList(shapeNames);
    private final Deque<Deque<Shape>> undoDeque;
    private final Deque<Deque<Shape>> redoDeque;
    //public Deque<Shape> shapeList;
    public ObservableList<Shape> shapeList;
    private final ObjectProperty<Integer> size;
    private final ObjectProperty<Color> color;
    public final ObjectProperty<ShapeType> shapeType;
    public final ObjectProperty<Shape> shape;
    public Model() {
        //this.shapeList = new ArrayDeque<>();
        this.shapeList = FXCollections.observableArrayList();
        this.undoDeque = new ArrayDeque<>();
        this.redoDeque = new ArrayDeque<>();
        this.color = new SimpleObjectProperty<>(Color.web("#004B87"));
        this.size = new SimpleObjectProperty<>(50);
        this.shapeType = new SimpleObjectProperty<>();
        this.shape = new SimpleObjectProperty<>();
    }

    public Shape getShape() {
        return shape.get();
    }

    public ObjectProperty<Shape> shapeProperty() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape.set(shape);
    }

    public ObjectProperty<ShapeType> shapeTypeProperty() {
        return shapeType;
    }

    public ShapeType getShapeType() {
        return shapeType.get();
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType.set(shapeType);
    }

    public Property<Integer> sizeProperty() {
        return size;
    }
    public Integer getSize() {
        return size.get();
    }
    public ObjectProperty<Color> colorProperty() {
        return color;
    }
    public Color getColor() {
        return color.get();
    }
    public ObservableList<ShapeType> getChoiceBoxShapeList() {
        return choiceBoxShapeList;
    }
    public ObservableList<Shape> getShapeList() {
        return shapeList;
    }

/*    public void undo() {
        if (undoDeque.isEmpty())
            return;
        shapeList.clear();
        shapeList.addAll(undoDeque.removeLast());
    }
    public Deque<Shape> getTempList() {
        Deque<Shape> tempList = new ArrayDeque<>();
        for (Shape shape : shapeList)
            tempList.add(shape.getShapeDuplicate());
        return tempList;
    }
    public void addToUndoDeque() {
        undoDeque.addLast(getTempList());
    }*/

    public void undo() {
        if (undoDeque.isEmpty())
            return;

        addToRedoDeque();
        shapeList.clear();
        shapeList.addAll(undoDeque.removeLast());
    }

    public void redo() {
        if (redoDeque.isEmpty())
            return;

        addToUndoDeque();
        shapeList.clear();
        shapeList.addAll(redoDeque.removeLast());
    }

    public Deque<Shape> getTempList() {
        Deque<Shape> tempList = new ArrayDeque<>();
        for (Shape shape : shapeList)
            tempList.add(shape.getShapeDuplicate());
        return tempList;
    }

    public void addToUndoDeque() {
        undoDeque.addLast(getTempList());
    }

    public void addToRedoDeque() {
        redoDeque.addLast(getTempList());
    }

}