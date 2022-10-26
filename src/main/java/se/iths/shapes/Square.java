package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class Square implements Shape {
    private ShapeParameter parameter;
    public Square(ShapeParameter data) {
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