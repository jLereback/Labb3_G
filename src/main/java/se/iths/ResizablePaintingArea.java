package se.iths;

import javafx.scene.canvas.Canvas;

public class ResizablePaintingArea extends Canvas {

    /**
     * Returns the orientation of a node's resizing bias for layout purposes.
     * If the node type has no bias, returns null.  If the node is resizable and
     * it's height depends on its width, returns HORIZONTAL, else if its width
     * depends on its height, returns VERTICAL.
     * <p>
     * Resizable subclasses should override this method to return an
     * appropriate value.
     *
     * @see #isResizable()
     * @see #minWidth(double)
     * @see #minHeight(double)
     * @see #prefWidth(double)
     * @see #prefHeight(double)
     * @see #maxWidth(double)
     * @see #maxHeight(double)
     *
     * @return orientation of width/height dependency or null if there is none

     * #resize(double, double)
     * Invoked by the region's parent during layout to set the region's width and height.
     * Applications should not invoke this method directly.
     * If an application needs to directly set the size of the region,
     * it should override its size constraints by calling setMinSize(), setPrefSize(), or setMaxSize()
     * and it's parent will honor those overrides during layout.
     * Params:
     * width – the target layout bounds width
     * height – the target layout bounds height
     */


    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double minWidth(double height) {
        return 350;
    }

    @Override
    public double minHeight(double width) {
        return 240;
    }

    @Override
    public double prefWidth(double height) {
        return 550;
    }

    @Override
    public double prefHeight(double width) {
        return 390;
    }

    @Override
    public double maxWidth(double height) {
        return Double.MAX_VALUE;
    }


    @Override
    public double maxHeight(double width) {
        return Double.MAX_VALUE;
    }

    @Override
    public void resize(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
    }
}
