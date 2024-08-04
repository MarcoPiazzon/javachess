package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import piece.Piece;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import static utils.Constant.Pieces.Path.*;
import static utils.Constant.Pieces.Dimensions.*;

/**
 * Controller class for managing the chessboard and pieces.
 * Initializes the board with the starting chess pieces and handles cell clicks.
 */
public class Controller implements Initializable {
    private Board _board;
    private static final Logger logger = Logger.getLogger(Controller.class.getName());

    @FXML
    private AnchorPane myAP;


    @FXML
    private GridPane myGrid;

    /**
     * Handles mouse clicks on cells of the chessboard.
     * Converts the cell's row and column indices to chess notation and prints the cell identifier.
     *
     * @param event the MouseEvent triggered by clicking a cell
     */
    @FXML
    private void clickOnCell(MouseEvent event){
        Node source = (Node)event.getSource();
        int colIndex = (GridPane.getColumnIndex((source)) == null ? 0 : (GridPane.getColumnIndex(source)));
        int rowIndex = (GridPane.getRowIndex(source)) == null ? 0 : (GridPane.getRowIndex(source));
        // conv a to h
        rowIndex = 8 - rowIndex;
        System.out.println("cella: " + (char)('a' + colIndex) + rowIndex);

        //_board.printBoard();
    }

    /**
     * Initializes the chessboard with the starting positions of chess pieces.
     * This method is called by the JavaFX framework during the initialization phase.
     *
     * @param url the location used to resolve relative paths for the root object
     * @param resourceBundle the resources used to localize the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this._board = new Board();

        draggableMakerGrid = new DraggableMakerGrid(myAP.getPrefWidth(), myAP.getPrefHeight(), 64, myAP);

        // gridsize -> 64 (ncell) = (planeWidth / x) * (planeHeight / x)
        gridHandler = new GridHandler(myAP.getPrefWidth(), myAP.getPrefHeight(), 64, myAP);
        gridHandler.updateGrid();

        // Black square
        Component component = new Component(64, 0, 0);
        myAP.getChildren().add(component.getRectangle());

        draggableMakerGrid.makeDraggable(component);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Get the image path for the piece at position (i, j)
                String imgPath = correspondingMatchPath(i, j);

                if (imgPath != null) {
                    URL imgURL = getClass().getResource(imgPath);

                    // Print an error message if the image is not found
                    if (imgURL == null) {
                        logger.warning("Image not found: " + imgPath);
                        // System.err.println("Image not found at path: " + imgPath);
                        continue;
                    }

                    // Load image, create StackPane with it, set click handler, and add to GridPane
                    Image img = new Image(imgURL.toExternalForm(), PIECE_HEIGHT, PIECE_WIDTH, true, false);
                    StackPane sp = new StackPane();
                    sp.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, false))));

                    sp.setOnMouseClicked(this::clickOnCell);
<<<<<<< HEAD
                    sp.setOnMouseDragged(event -> dragged(event, sp));
                    sp.setOnMouseReleased(event -> released(event, sp));
=======
                    draggableMakerGrid.makeDraggable(sp);
>>>>>>> 8c9ee86680808e4b02ab4525f99cf6ac2d25a64f
                    myGrid.add(sp, j, i);
                }
            }
        }
    }

    public void dragged(MouseEvent event,Node p){
        p.setTranslateX(event.getX() + p.getTranslateX());
        p.setTranslateY(event.getY() + p.getTranslateY());
    }

    public void released(MouseEvent event, StackPane p){
        int gridx = (int)p.getTranslateX() / PIECE_HEIGHT;
        int gridy = (int)p.getTranslateY() / PIECE_HEIGHT;
        p.setTranslateX(PIECE_HEIGHT / 2 + PIECE_HEIGHT * gridx);
        p.setTranslateY(PIECE_HEIGHT / 2 + PIECE_HEIGHT * gridy);

    }
}