package se.iths.shapes;

import javafx.beans.property.ObjectProperty;
import javafx.scene.canvas.GraphicsContext;

public final class Square extends Shape {
    public Square(ShapeParameter parameter) {
        super(parameter);
    }
    public Square(Square square) {
        super(square);
    }

    @Override
    public Shape getDuplicate() {
        return new Square(this.parameter);
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