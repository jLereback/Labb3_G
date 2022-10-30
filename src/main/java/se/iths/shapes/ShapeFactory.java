package se.iths.shapes;

public class ShapeFactory {

    public Shape getShape(ShapeType shapeType, ShapeParameter parameter) {
        if (shapeType.equals(ShapeType.CIRCLE))
            return new Circle(parameter);
        else if (shapeType.equals(ShapeType.SQUARE))
            return new Square(parameter);
        else
            return null;
    }
}