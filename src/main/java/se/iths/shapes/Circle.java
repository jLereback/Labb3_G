package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;

public final class Circle extends Shape {
    public Circle(ShapeParameter parameter) {
        super(parameter);
    }
    public Circle() {
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(parameter.getColor());
        context.fillOval(parameter.getCenterX(), parameter.getCenterY(), parameter.getSize(), parameter.getSize());

    }

    @Override
    public Boolean isInside(double posX, double posY) {
        return null;
    }

    @Override
    public String toString() {
        return "Circle";
    }
}