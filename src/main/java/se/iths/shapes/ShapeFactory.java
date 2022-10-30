package se.iths.shapes;

import javafx.scene.control.Tooltip;

import java.util.Objects;

public class ShapeFactory {

    public Shape getShape(ShapeType shapeType, ShapeParameter parameter) {
        if (shapeType.equals(ShapeType.CIRCLE))
            return new Circle(parameter);
        else if (shapeType.equals(ShapeType.SQUARE))
            return new Square(parameter);
        else
            return null;
    }

    public Shape getShape(Shape shape) {
        if (shape.getType().equals(ShapeType.CIRCLE))
            return new Circle(shape.parameter);
        else if (shape.getType().equals(ShapeType.SQUARE))
            return new Square(shape.parameter);
        else
            return null;
    }
}