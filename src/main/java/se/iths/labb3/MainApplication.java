package se.iths.labb3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*Todo: Ett program där du kan göra olika figurer
   Man ska kunna ändra storlek på specifik figur
   Detta vill jag genomföra genom att klicka på figuren
   Sedan dra i kanten för att göra den större eller mindre mindre

  Todo: Använda ColorPicker

  Todo: Använda Menu och MenuItem för att få en menubar

*/

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}