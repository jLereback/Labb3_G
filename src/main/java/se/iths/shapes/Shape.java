package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;

public interface Shape {
    void draw(GraphicsContext context);

    static String getName(Shape shape) {
        return shape.toString();
    }

    Boolean isInside(double posX, double posY);
}
