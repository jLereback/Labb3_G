package se.iths.shapes;

import javafx.collections.ObservableList;

public class ShapeFactory {

    public Shape getShape(String shapeType, shapeParameter values) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equals("Circle")){
            return new Circle(values);
        } else if(shapeType.equals("Square")){
            return new Square(values);
        }
        return null;
    }
}