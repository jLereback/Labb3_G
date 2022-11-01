package se.iths.labb.shapes;

import javafx.scene.canvas.GraphicsContext;

import static se.iths.labb.shapes.ShapeType.*;

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
        context.fillRect(getX() - getHalfSideSize(), getY() - getHalfSideSize(), getSize(), getSize());
    }

    private double getHalfSideSize() {
        return getSize() >> 1;
    }

    @Override
    public Boolean isInside(double posX, double posY) {
        double distanceToX = Math.abs(posX - getX());
        double distanceToY = Math.abs(posY - getY());

        return distanceToX <= getHalfSideSize() && distanceToY <= getHalfSideSize();
    }

    @Override
    public ShapeType getType() {
        return SQUARE;
    }

    @Override
    public String drawToSVGAsString() {
        String convertColor = getColor().toString().substring(2, 10);
        return "<rect x=\"" + (getX() - getHalfSideSize()) + "\" " +
                "y=\"" + (getY() - getHalfSideSize()) + "\" " +
                "width=\"" + getSize() + "\" " +
                "height=\"" + getSize() + "\" " +
                "fill=\"#" + convertColor + "\" />";
    }
}