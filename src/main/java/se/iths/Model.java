package se.iths;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class Model {
    String[] shapeList = {"Circle", "Square"};
    private ObservableList<String> shapes = FXCollections.observableArrayList(shapeList);
    private final Property<Integer> size;
    private final ObjectProperty<Color> color;
    public final ObjectProperty<String> shape;

    public Model() {
        this.color = new SimpleObjectProperty<>(Color.web("#004B87"));
        this.size = new SimpleObjectProperty<>(50);
        this.shape = new SimpleObjectProperty<>("Choose shape");
    }

    public ObjectProperty<String> shapeProperty() {
        return shape;
    }

    public Property<Integer> getSize() {
        return size;
    }

    public Property<Integer> sizeProperty() {
        return size;
    }

    public Color getColor() {
        return color.get();
    }

    public void setShapes(ObservableList<String> shapes) {
        this.shapes = shapes;
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public ObservableList<String> getShapes() {
        return shapes;
    }

/*    public ObservableList<String> getTempList() {
        ObservableList<String> tempList = FXCollections.observableArrayList();

        for (String shape : shapes)
            tempList.add(shape.copyOf());

        return tempList;
    }

    public void undo() {
        if (undo.isEmpty()) {
            return;
        }
        ObservableList<String> temp = getTempList();
        redo.addLast(temp);
        shapes = undo.removeLast();
    }

    public void redo() {
        if (redo.isEmpty())
            return;
        ObservableList<String> temp = getTempList();
        undo.addLast(FXCollections.observableArrayList(temp));
        shapes = redo.removeLast();
    }*/
}
