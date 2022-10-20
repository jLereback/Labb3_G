package se.iths;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
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


    public void initialize() {


        shapeType.setValue("Choose shape");
        shapeType.setItems(model.getShapes());
    }


    public void canvasClicked(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        System.out.println(shapeType.valueProperty());
        if (shapeType.getValue().equals("Circle"))
            System.out.println(shapeType.getValue());
        else if (shapeType.getValue().equals("Rectangle")) {
            System.out.println(shapeType.getValue());

        }
    }
}