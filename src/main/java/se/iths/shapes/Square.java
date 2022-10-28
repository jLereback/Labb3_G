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
        context.setFill(getColor());
        context.fillRect(getX(), getY(), getSize(), getSize());
    }
    @Override
    public Boolean isInside(double posX, double posY) {
        double centerPointX = getX() + getHalfSideSize();
        double centerPointY = getY() + getHalfSideSize();

        double distanceToX = Math.abs(posX - centerPointX);
        double distanceToY = Math.abs(posY - centerPointY);

        return distanceToX <= getHalfSideSize() && distanceToY <= getHalfSideSize();
    }

    private double getHalfSideSize() {
        return getSize() >> 1;
    }

    @Override
    public String toString() {
        return "Square";
    }
}