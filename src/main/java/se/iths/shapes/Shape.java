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

    public void updateShape(Color color, int size){
        setColor(color);
        setSize(size);
    }
    public double getX() {
        return parameter.getPosX();
    }

    public void setX(double X) {
        this.parameter.setPosX(X);
    }

    public double getY() {
        return parameter.getPosY();
    }

    public void setY(double Y) {
        this.parameter.setPosY(Y);
    }

    public abstract Boolean isInside(double posX, double posY);
}

