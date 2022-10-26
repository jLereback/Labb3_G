package se.iths.shapes;

import javafx.css.Size;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface Shape {
    void draw(GraphicsContext context);

    static String getName(Shape shape) {
        return shape.toString();
    }

    Integer getSize(int size);
    Color getColor(Color color);
    Integer setSize(int size);
    Color setColor(Color color);

    static Shape get(Shape shape) {
        return shape;
    }
    Boolean isInside(double posX, double posY);
}
