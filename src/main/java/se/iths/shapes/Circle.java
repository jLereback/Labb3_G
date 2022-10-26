package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;

public final class Circle implements Shape {
    private shapeParameter parameter;
    public Circle(shapeParameter parameter) {
        this.parameter = parameter;
    }
    public Circle() {
    }
    @Override
    public String toString() {
        return "Circle";
    }
    @Override
    public void draw(GraphicsContext context) {
        context.setFill(parameter.color());
        context.fillOval(parameter.centerX(), parameter.centerY(), parameter.size(), parameter.size());
    }
    @Override
    public Boolean isInside(double posX, double posY) {
        return null;
    }
}