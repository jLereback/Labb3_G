package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;

public final class Circle implements Shape {
    private shapeParameter data;
    public Circle(shapeParameter data) {
        this.data = data;
    }

    public Circle() {
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(data.colorPicker().getValue());
        context.fillOval(data.posX(), data.posY(), data.size(), data.size());
    }
}