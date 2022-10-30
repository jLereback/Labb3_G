package se.iths.shapes;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.function.Consumer;

public abstract class Shape {
    public ShapeParameter parameter;
    public Shape(ShapeParameter parameter) {
        this.parameter = parameter;
    }
    public Shape(Shape shape) {
        this.parameter = shape.parameter;
    }
    public abstract Shape getDuplicate();

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

    public abstract ShapeType getType();
}

