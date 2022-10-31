package se.iths.svg;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import se.iths.Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SVGWriter {
    FileChooser fileChooser = new FileChooser();
    Path filePath;

    public void save(Model model, Stage stage) {
        prepareFileChooser(stage);
        writeToSvg(model);
    }

    private void prepareFileChooser(Stage stage) {
        fileChooser.setInitialFileName("myMasterPiece");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG File", "*.svg"));
        filePath = fileChooser.showSaveDialog(stage.getOwner()).toPath();
    }

    private void writeToSvg(Model model) {
        try {
            Files.write(filePath, getSvgAsStrings(model));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getSvgAsStrings(Model model) {
        List<String> strings = new ArrayList<>();
        addStrings(model, strings);
        return strings;
    }

    private static void addStrings(Model model, List<String> strings) {
        addInitiateString(strings);
        addAllShapesAsStrings(model, strings);
        addFinalString(strings);
    }

    private static void addFinalString(List<String> strings) {
        strings.add("</svg>");
    }

    private static void addInitiateString(List<String> strings) {
        strings.add("<svg width=\"1540.0\" height=\"740.0\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">");
    }

    private static void addAllShapesAsStrings(Model model, List<String> strings) {
        model.getShapeList().forEach(shape -> strings.add(String.join(" ", shape.drawToSVGAsString())));
    }
}