package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;

public final class Square extends Shape {
    public Square(ShapeParameter parameter) {
        super(parameter);
    }
    public Square() {
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(parameter.getColor());
        context.fillRect(parameter.getCenterX(), parameter.getCenterY(), parameter.getSize(), parameter.getSize());

    }

    @Override
    public Boolean isInside(double posX, double posY) {
        return null;
    }

    @Override
    public String toString() {
        return "Square";
    }
}