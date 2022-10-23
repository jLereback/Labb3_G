package se.iths;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.paint.Color;

public class Model {





    String[] shapeList = { "Circle", "Rectangle"};
    private ObservableList<String> shapes = FXCollections.observableArrayList(shapeList);
    private final ObjectProperty<Color> color;



    public Model() {
        this.color = new SimpleObjectProperty<>(Color.web("#004B87"));
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
}
