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
        context.fillOval(getX() - getRadius(), getY() - getRadius(), getSize(), getSize());
    }

    private double getRadius() {
        return getSize() >> 1;
    }

    @Override
    public Boolean isInside(double posX, double posY) {
        double distX = posX - getX();
        double distY = posY - getY();

        double distToCenter = Math.sqrt((distX * distX) + (distY * distY));

        return distToCenter <= getRadius();
    }

    @Override
    public ShapeType getType() {
        return CIRCLE;
    }

    @Override
    public String drawToSVGAsString() {
        String convertColor = "#" + getColor().toString().substring(2, 10);
        return "<circle cx=\"" + getX() + "\" " +
                "cy=\"" + getY() + "\" " +
                "r=\"" + getRadius() + "\" " +
                "fill=\"" + convertColor + "\" />";
    }
}