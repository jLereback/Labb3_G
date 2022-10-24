package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;

public final class Square implements Shape {
    private ShapeData data;
    public Square(ShapeData data) {
        this.data = data;
    }

    public Square() {
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(data.colorPicker().getValue());
        context.fillRect(data.posX(), data.posY(), data.size(), data.size());
    }
}