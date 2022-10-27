package se.iths.shapes;

public class ShapeFactory {

    public Shape getNewShape(Shape shapeType, ShapeParameter parameter) {
        if (shapeType == null)
            return null;
        if (shapeType.toString().equals(new Circle().toString()))
            return new Circle(parameter);
        else if (shapeType.toString().equals(new Square().toString()))
            return new Square(parameter);
        return null;
    }

    public void /*Shape*/ getShape(String shapeType, ShapeParameter values) {

        //Todo;Redan utritade objekt ska kunna väljas genom att gå över i select mode och klicka på skärmen.
        // Använd musens koordinater för att leta upp det objekt du klickat på.
        // Tips! Implementera en metod på dina shapes för att fråga om koordinaterna är inom shapens area.
        // På den valda shapen ska vi sedan kunna ändra färg och storlek.
        //return ;
    }
}