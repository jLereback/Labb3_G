package se.iths.shapes;

import javafx.scene.paint.Color;

import java.util.Objects;

public final class ShapeParameter {
    private double X;
    private double Y;
    private int size;
    private Color color;

    public ShapeParameter(double X, double Y, int size, Color color) {
        this.X = X;
        this.Y = Y;
        this.size = size;
        this.color = color;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        this.X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        this.Y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ShapeParameter) obj;
        return Double.doubleToLongBits(this.X) == Double.doubleToLongBits(that.X) &&
                Double.doubleToLongBits(this.Y) == Double.doubleToLongBits(that.Y) &&
                this.size == that.size &&
                Objects.equals(this.color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y, size, color);
    }

    @Override
    public String toString() {
        return "ShapeParameter[" +
                "centerX=" + X + ", " +
                "centerY=" + Y + ", " +
                "size=" + size + ", " +
                "color=" + color + ']';
    }
}