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
     */
    @Override
    public boolean isResizable() {
        return true;
    }


}
