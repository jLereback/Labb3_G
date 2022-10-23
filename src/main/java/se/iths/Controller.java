package se.iths;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import se.iths.shapes.Circle;

public class Controller {
    Model model = new Model();
    public MenuBar menuBar;
    public ToolBar toolBar;
    public Spinner<Integer> sizeSetter;
    public ChoiceBox<String> shapeType;
    public Button buttonUndo;
    public ColorPicker colorPicker;
    public Canvas paintingArea;

    public GraphicsContext context;

    public void initialize() {
        context = paintingArea.getGraphicsContext2D();
        //paintingArea.setFocusTraversable(true);
        context.setFill(Color.web("#eddeaf"));
        context.fillRect(0, 0, Double.MAX_VALUE, Double.MAX_VALUE);
        shapeType.setValue("Choose shape");
        shapeType.setItems(model.getShapes());
    }


    public void canvasClicked(MouseEvent mouseEvent) {
        context.setFill(Color.web("#004B87"));

        double ovalSize = 10;
        double ovalX = mouseEvent.getX() - (ovalSize/2);
        double ovalY = mouseEvent.getY() - (ovalSize/2);

        double rectSize = 10;
        double rectX = mouseEvent.getX() - (rectSize/2);
        double rectY = mouseEvent.getY() - (rectSize/2);
        System.out.println(shapeType.valueProperty());
        if (shapeType.getValue().equals("Circle")) {
            context.fillOval(ovalX, ovalY, ovalSize, ovalSize);
        }
        else if (shapeType.getValue().equals("Rectangle")) {
            context.fillRect(rectX, rectY, rectSize, rectSize);
        }
    }
}