package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;

public final class Square implements Shape {
    private shapeParameter parameter;
    public Square(shapeParameter data) {
        this.parameter = data;
    }
    public Square() {
    }
    @Override
    public String toString() {
        return "Square";
    }
    @Override
    public void draw(GraphicsContext context) {
        context.setFill(parameter.color());
        context.fillRect(parameter.centerX(), parameter.centerY(), parameter.size(), parameter.size());
    }
    @Override
    public Boolean isInside(double posX, double posY) {
        return null;
    }
}