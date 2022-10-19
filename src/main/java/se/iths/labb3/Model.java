package se.iths.labb3;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {

    private final BooleanProperty connected = new SimpleBooleanProperty();

    public boolean isConnected() {
        return connected.get();
    }

    public BooleanProperty connectedProperty() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected.set(connected);
    }

    ObjectProperty<ObservableList<FXCollections>>
    String shapes = new ObservableList<>()
    /*    ObservableList från FXCollections som String
    Koppla med SetItems till ComboBoxen
    ChoiceBox<String> shapeType
    setValue som förvalt*/

}
