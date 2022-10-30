package se.iths.shapes;

import javafx.scene.paint.Color;

import java.util.Objects;

public final class ShapeParameter {
    private double posX;
    private double posY;
    private int size;
    private Color color;

    public ShapeParameter(double posX, double posY, int size, Color color) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.color = color;
    }
    public double getPosX() {
        return posX;
    }
    public double getPosY() {
        return posY;
    }
    public Color getColor() {
        return color;
    }
    public int getSize() {
        return size;
    }
    public void setPosX(double posX) {
        this.posX = posX;
    }
    public void setPosY(double posY) {
        this.posY = posY;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setColor(Color color) {
        this.color = color;
    }

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
    public int hashCode() {
        return Objects.hash(posX, posY, size, color);
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