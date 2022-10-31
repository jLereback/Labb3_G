package se.iths.shapes;

import static se.iths.shapes.ShapeType.*;

public class ShapeFactory {
    public Shape getShape(ShapeType shapeType, ShapeParameter parameter) {
        return switch (shapeType) {
            case CIRCLE -> new Circle(parameter);
            case SQUARE -> new Square(parameter);
        };
    }
}