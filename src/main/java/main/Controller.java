package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private void clickOnCell(MouseEvent event){
        Node source = (Node)event.getSource();
        int colIndex = (GridPane.getColumnIndex((source)) == null ? -1 : (GridPane.getColumnIndex(source)));
        int rowIndex = (GridPane.getRowIndex(source)) == null ? -1 : (GridPane.getRowIndex(source));
        System.out.println("test print:" + colIndex + ", " + rowIndex);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}