package se.iths;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {





    String[] shapeList = { "Circle", "Rectangle"};
    private ObservableList<String> shapes = FXCollections.observableArrayList(shapeList);


    public void setShapes(ObservableList<String> shapes) {
        this.shapes = shapes;
    }

    public ObservableList<String> getShapes() {

        return shapes;
    }
}
