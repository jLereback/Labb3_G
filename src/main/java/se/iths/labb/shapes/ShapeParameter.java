package se.iths.labb.shapes;

import javafx.scene.paint.Color;

import java.util.Objects;

public record ShapeParameter(double posX, double posY, int size, Color color) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ShapeParameter) obj;
        return Double.doubleToLongBits(this.posX) == Double.doubleToLongBits(that.posX) &&
                Double.doubleToLongBits(this.posY) == Double.doubleToLongBits(that.posY) &&
                this.size == that.size &&
                Objects.equals(this.color, that.color);
    }

    @Override
    public String toString() {
        return "ShapeParameter[" +
                "posX=" + posX + ", " +
                "posY=" + posY + ", " +
                "size=" + size + ", " +
                "color=" + color + ']';
    }
}