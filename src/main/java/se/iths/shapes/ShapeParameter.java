package se.iths.shapes;

import javafx.scene.paint.Color;

import java.util.Objects;

public final class ShapeParameter {
    private double centerX;
    private double centerY;
    private int size;
    private Color color;

    public ShapeParameter(double centerX, double centerY, int size, Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.size = size;
        this.color = color;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
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
        return Double.doubleToLongBits(this.centerX) == Double.doubleToLongBits(that.centerX) &&
                Double.doubleToLongBits(this.centerY) == Double.doubleToLongBits(that.centerY) &&
                this.size == that.size &&
                Objects.equals(this.color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centerX, centerY, size, color);
    }

    @Override
    public String toString() {
        return "ShapeParameter[" +
                "centerX=" + centerX + ", " +
                "centerY=" + centerY + ", " +
                "size=" + size + ", " +
                "color=" + color + ']';
    }
}