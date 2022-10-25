module se.iths.labb3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.iths to javafx.fxml;
    exports se.iths;

    opens se.iths.shapes to javafx.fxml;
    exports se.iths.shapes;
}