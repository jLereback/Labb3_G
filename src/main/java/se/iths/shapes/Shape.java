package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    public ShapeParameter parameter;

    public Shape(ShapeParameter parameter) {
        this.parameter = parameter;
    }
    public Shape() {
    }
    public abstract void draw(GraphicsContext context);
    public Integer getSize() {
        return this.parameter.getSize();
    }
    public Color getColor() {
        return this.parameter.getColor();
    }
    public void setSize(int size) {
        this.parameter.setSize(size);
    }
    public void setColor(Color color) {
        this.parameter.setColor(color);
    }
    public abstract Boolean isInside(double posX, double posY);
}
