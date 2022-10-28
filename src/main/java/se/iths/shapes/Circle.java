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
        context.setFill(getColor());
        context.fillOval(getX(), getY(), getSize(), getSize());
    }
    private double getCircleRadius(){
        return getSize() >> 1;
    }
    @Override
    public Boolean isInside(double posX, double posY) {
        double centerPointX = getX() + getCircleRadius();
        double centerPointY = getY() + getCircleRadius();

        double distX = posX - centerPointX;
        double distY = posY - centerPointY;

        double distToCenter = Math.sqrt((distX * distX) + (distY * distY));

        return distToCenter <= getCircleRadius();
    }
    @Override
    public String toString() {
        return "Circle";
    }
}