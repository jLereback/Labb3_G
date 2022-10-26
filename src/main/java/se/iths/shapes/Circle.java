package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class Circle implements Shape {
    private ShapeParameter parameter;
    public Circle(ShapeParameter parameter) {
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
    public Integer getSize(int size) {
        return this.parameter.size();
    }

    @Override
    public Color getColor(Color color) {
        return this.parameter.color();
    }

    @Override
    public Integer setSize(int size) {
        return null;
    }

    @Override
    public Color setColor(Color color) {
        return null;
    }

    @Override
    public Boolean isInside(double posX, double posY) {
        return null;
    }
}