package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;

import static se.iths.shapes.ShapeType.*;

public final class Circle extends Shape {
    public Circle(ShapeParameter parameter) {
        super(parameter);
    }

    @Override
    public Shape getShapeDuplicate() {
        return new Circle(getDuplicate());
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(getPosX(), getPosY(), getSize(), getSize());
    }

    private double getCircleRadius() {
        return getSize() >> 1;
    }

    @Override
    public Boolean isInside(double posX, double posY) {
        double centerPointX = getPosX() + getCircleRadius();
        double centerPointY = getPosY() + getCircleRadius();

        double distX = posX - centerPointX;
        double distY = posY - centerPointY;

        double distToCenter = Math.sqrt((distX * distX) + (distY * distY));

        return distToCenter <= getCircleRadius();
    }

    @Override
    public String drawSVG() {
        String convertColor = "#" + getColor().toString().substring(2, 10);
        return "<circle cx=\"" + getPosX() + "\" " +
                "cy=\"" + getPosY() + "\" " +
                "r=\"" + getSize() + "\" " +
                "fill=\"" + convertColor + "\" />";
    }

    @Override
    public ShapeType getType() {
        return CIRCLE;
    }
}