package hust.soict.hedspi.Javafx;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.awt.event.MouseEvent;

public class PainterController {
    private Pane drawingAreaPane;

    void clearButtonPressed(){

    }

    void drawingAreaMousingDragged(MouseEvent event){
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
