package se.iths.svg;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import se.iths.Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class SVG {

    FileChooser fileChooser = new FileChooser();
    Path filePath;

    public void save(Model model, Stage stage){
      fileChooser.setTitle("Test");
      fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG Files", "*.svg"));
      filePath = fileChooser.showSaveDialog(stage).toPath();
      List<String> strings = new ArrayList<>();
      strings.add("<svg width=\"993.0\" height=\"712.0\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">");
      model.getShapeList().forEach(shape -> strings.add(String.join(" ", shape.drawSVG())));
      strings.add("</svg>");

      try {
          Files.write(filePath, strings);
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
    }
}
