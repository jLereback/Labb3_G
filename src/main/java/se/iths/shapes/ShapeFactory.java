package se.iths.shapes;

public class ShapeFactory {

    public Shape getShape(String shapeType, ShapeData values) {
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