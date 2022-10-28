package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;

public final class Square extends Shape {
    public Square(ShapeParameter parameter) {
        super(parameter);
    }

    public Square() {
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(parameter.getColor());
        context.fillRect(parameter.getX(), parameter.getY(), parameter.getSize(), parameter.getSize());

    }

    @Override
    public Boolean isInside(double posX, double posY) {

        double xMinLimit = parameter.getX() - (parameter.getSize() >> 1);
        double xMaxLimit = parameter.getX() + (parameter.getSize() >> 1);
        double yMinLimit = parameter.getY() - (parameter.getSize() >> 1);
        double yMaxLimit = parameter.getY() + (parameter.getSize() >> 1);

        if (posX >= xMinLimit && posX <=xMaxLimit && posY >= yMinLimit && posY <= yMaxLimit)
            return true;
        else
            return null;
    }

/*    public boolean isInside(double mouseX, double mouseY) {
        double leftX = getX() - size;
        double topY = getY() - size;

        return mouseX >= leftX &&
                mouseX <= leftX + 2 * size &&
                mouseY >= topY &&
                mouseY <= topY + 2 * size;
    }*/

    @Override
    public String toString() {
        return "Square";
    }
}