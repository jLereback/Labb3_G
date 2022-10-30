package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;

public final class Square extends Shape {
    public Square(ShapeParameter parameter) {
        super(parameter);
    }
    @Override
    public Shape getShapeDuplicate() {
        return new Square(getDuplicate());
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(getPosX(), getPosY(), getSize(), getSize());
    }
    @Override
    public Boolean isInside(double posX, double posY) {
        double centerPointX = getPosX() + getHalfSideSize();
        double centerPointY = getPosY() + getHalfSideSize();

        double distanceToX = Math.abs(posX - centerPointX);
        double distanceToY = Math.abs(posY - centerPointY);

        return distanceToX <= getHalfSideSize() && distanceToY <= getHalfSideSize();
    }

    @Override
    public ShapeType getType() {
        return ShapeType.SQUARE;
    }

    private double getHalfSideSize() {
        return getSize() >> 1;
    }

    @Override
    public String toString() {
        return "Square";
    }
}