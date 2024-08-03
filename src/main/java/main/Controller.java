package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Board _board;

    @FXML
    private GridPane myGrid;

    @FXML
    private void clickOnCell(MouseEvent event){
        Node source = (Node)event.getSource();
        int colIndex = (GridPane.getColumnIndex((source)) == null ? 0 : (GridPane.getColumnIndex(source)));
        int rowIndex = (GridPane.getRowIndex(source)) == null ? 0 : (GridPane.getRowIndex(source));
        // conv a to h
        rowIndex = 7 - rowIndex + 1;
        // System.out.println("test print:" + colIndex + ", " + rowIndex);
        System.out.println("cella: " + (char)('a' + colIndex) + rowIndex);

        //_board.printBoard();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("sono qui");
        //System.out.println(getClass().getResource("file:images/bp.png"));
        //Image image = new Image(new File("/images/bb.png").toURI().toString());
        //myGrid.add(new ImageView(,0,0);
        this._board = new Board();
        Image i = new Image(getClass().getResourceAsStream("/images/br.png"),70,70,true,false);
        ImageView iv = new ImageView(i);
        StackPane sp = new StackPane();
        sp.setBackground(new Background(new BackgroundImage(i, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO, false, false,false, false))));
        sp.setOnMouseClicked(this::clickOnCell);
        myGrid.add(sp,0,0);

    }
}