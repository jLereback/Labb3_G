package se.iths.labb.shapes;

public class ShapeFactory {
    public Shape getShape(ShapeType shapeType, ShapeParameter parameter) {
        return switch (shapeType) {
            case CIRCLE -> new Circle(parameter);
            case SQUARE -> new Square(parameter);
        };
    }
}