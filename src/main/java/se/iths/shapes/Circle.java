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



    @Override
    public Boolean isInside(double posX, double posY) {
        double radius = getSize() >> 1;
        double centerX = getX() + radius;
        double centerY = getY() + radius;

        double distanceToX = posX - centerX;
        double distanceToY = posY - centerY;

        if (distanceToX < 0)
            distanceToX = distanceToX * -1;
        if (distanceToY < 0)
            distanceToY = distanceToY * -1;

        return distanceToX <= radius && distanceToY <= radius;
    }

    @Override
    public String toString() {
        return "Circle";
    }
}