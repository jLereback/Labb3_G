package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    private final double posX;
    private final double posY;
    private int size;
    private Color color;


    public Shape(ShapeParameter parameter) {
        this.posX = parameter.getPosX();
        this.posY = parameter.getPosY();
        this.size = parameter.getSize();
        this.color = parameter.getColor();
    }

    public abstract void draw(GraphicsContext context);

    public abstract Shape getShapeDuplicate();
    public ShapeParameter getDuplicate() {
        return new ShapeParameter(getPosX(), getPosY(), getSize(), getColor());
    }
    public double getPosX() {
        return posX;
    }
    public double getPosY() {
        return posY;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void updateShape(Color color, int size){
        setColor(color);
        setSize(size);
    }
    public abstract Boolean isInside(double posX, double posY);

    public abstract String drawSVG();

    public abstract ShapeType getType();
}