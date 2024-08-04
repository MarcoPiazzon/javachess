package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

import static utils.Constant.Pieces.Path.*;
import static utils.Constant.Pieces.Dimensions.*;

/**
 * Controller class for managing the chessboard and pieces.
 * Initializes the board with the starting chess pieces and handles cell clicks.
 */
public class Controller implements Initializable {
    private Board _board;

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
        // Get dates of the clicked cell
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

        // Loop through each cell in the 8x8 chessboard grid
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Get the image path for the piece at position (i, j)
                String imgPath = correspondingMatchPath(i, j);

                if (imgPath != null) {
                    URL imgURL = getClass().getResource(imgPath);

                    // Print an error message if the image is not found
                    if (imgURL == null) {
                        System.err.println("Image not found: " + imgPath);
                        continue;
                    }

                    // Load image, create StackPane with it, set click handler, and add to GridPane
                    StackPane sp = getStackPane(imgURL);

                    myGrid.add(sp, j, i);
                }
            }
        }
    }

    /**
     * Creates a StackPane containing the chess piece image and sets up event handlers.
     *
     * @param imgURL the URL of the image to be used for the piece
     * @return the StackPane containing the image
     */
    private StackPane getStackPane(URL imgURL) {
        Image img = new Image(imgURL.toExternalForm(), PIECE_HEIGHT, PIECE_WIDTH, true, false);
        StackPane sp = new StackPane();
        sp.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, false))));

        sp.setOnMouseClicked(this::clickOnCell); // Set click handler
        sp.setOnMouseDragged(event -> dragged(event, sp)); // Set drag handler
        sp.setOnMouseReleased(event -> released(event, sp)); // Set release handler
        return sp;
    }

    /**
     * Handles the dragging of a chess piece.
     *
     * @param event the MouseEvent triggered by dragging the piece
     * @param p     the Node representing the piece being dragged
     */
    public void dragged(MouseEvent event, Node p){
        p.setTranslateX(event.getX() + p.getTranslateX());
        p.setTranslateY(event.getY() + p.getTranslateY());
    }

    /**
     * Handles the release of a chess piece after dragging.
     *
     * @param event the MouseEvent triggered by releasing the piece
     * @param p     the StackPane representing the piece being released
     */

    public void released(MouseEvent event, StackPane p){
        // Current position piece
        double layoutX = p.getLayoutX() + p.getTranslateX();
        double layoutY = p.getLayoutY() + p.getTranslateY();

        // Coord grid and check errors
        int gridX = (int) (layoutX / PIECE_WIDTH);
        int gridY = (int) (layoutY / PIECE_HEIGHT);
        gridX = Math.max(0, Math.min(gridX, 7));
        gridY = Math.max(0, Math.min(gridY, 7));

        // Set the piece in the new grid cell
        GridPane.setColumnIndex(p, gridX);
        GridPane.setRowIndex(p, gridY);

        // Reset translation offsets
        p.setTranslateX(0);
        p.setTranslateY(0);
    }
}