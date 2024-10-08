package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import piece.Knight;
import utils.FileHelper;
import utils.Move;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static utils.Constant.Pieces.Path.*;
import static utils.Constant.Pieces.Dimensions.*;

/**
 * Controller class for managing the chessboard and pieces.
 * Initializes the board with the starting chess pieces and handles cell clicks.
 */
public class Controller implements Initializable {
    @FXML
    private AnchorPane myAP;

    @FXML
    private GridPane myGrid;

    private Game _game;
    private int startCol = -1;
    private int startRow = -1;

    private FileHelper _fileHelper = new FileHelper("src/main/java/print/movefailed.csv");

    // Set instance Game
    public void setGame(Game game) {
        this._game = game;
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
                new BackgroundSize(PIECE_HEIGHT, PIECE_WIDTH, false, false, false, false))));

        sp.setOnMouseClicked(this::clickOnCell); // Set click handler
        sp.setOnMouseDragged(event -> dragged(event, sp)); // Set drag handler
        sp.setOnMouseReleased(event -> released(event, sp)); // Set release handler
        return sp;
    }

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
     * Handles the dragging of a chess piece.
     *
     * @param event the MouseEvent triggered by dragging the piece
     * @param p     the Node representing the piece being dragged
     */
    public void dragged(MouseEvent event, Node p){
        if (startCol == -1 && startRow == -1) {
            startCol = (GridPane.getColumnIndex(p) == null ? 0 : GridPane.getColumnIndex(p));
            startRow = (GridPane.getRowIndex(p) == null ? 0 : GridPane.getRowIndex(p));
        }
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

        char startColChar = (char) ('a' + startCol);
        char endColChar = (char) ('a' + gridX);

        if (startCol > -1 && startRow > -1){
            Move move = new Move(startColChar, startRow, endColChar, gridY);
            boolean canMoveHere = _game.isInputMoveValid(move);

            if (canMoveHere) {
                // Set the piece in the new grid cell
                GridPane.setColumnIndex((Node) p, gridX);
                GridPane.setRowIndex((Node) p, gridY);
            } else{
                String piece = "Il pezzo era un " + _game.getPieceChar(startRow, startCol);
                _fileHelper.saveToFile(move.toString() + piece);
                _game.saveDetailsGame();
            }

            // Reset translation offsets
            p.setTranslateX(0);
            p.setTranslateY(0);

            startCol = -1;
            startRow = -1;
        }
        else {
            System.out.println("Spostamento non valido");
        }

        //aggiungere il checkmate
    }

    // Metodo per rimuovere lo sfondo del pezzo alla posizione (x, y)
    public void removePiece(int rowCP, int colCP, int rowCA, int colCA) {
        // Ottieni tutti i figli della griglia
        List<Node> children = myGrid.getChildren();
        Node cp = getNodeByRowColumnIndex(rowCP, colCP, myGrid);
        Node ca = getNodeByRowColumnIndex(rowCA, colCA, myGrid);
        // Itera su tutti i nodi della griglia per trovare quello alla posizione (x, y)

        myGrid.getChildren().remove(ca);
        //myGrid.getChildren().add(rowCA * 8 + colCA, cp);

        /*for (Node node : children) {
            // Ottieni la colonna e la riga del nodo corrente
            Integer colIndex = GridPane.getColumnIndex(node);
            Integer rowIndex = GridPane.getRowIndex(node);
            // Se il nodo è alla posizione specificata (x, y) ed è uno StackPane
            if (colIndex != null && rowIndex != null && colIndex == colCA && rowIndex == rowCA && node instanceof StackPane sp) {
                // Rimuovi il background del StackPane
                node = cp;
                break; // Esci dal ciclo dopo aver trovato e modificato il nodo
            }
        }*/
    }

    /**
     * NON HO TROVATO L UTILITA DEL METODO - GENERA SOLO ERRORE
     * @param row
     * @param column
     * @param gridPane
     * @return
     */
    public static Node getNodeByRowColumnIndex(final int row, int column, GridPane gridPane) {
        return gridPane.getChildren().stream()
                .filter(node -> {
                    Integer nodeRow = GridPane.getRowIndex(node);
                    Integer nodeColumn = GridPane.getColumnIndex(node);
                    return nodeRow != null && nodeRow == row && nodeColumn != null && nodeColumn == column;
                })
                .findFirst()
                .orElse(null);
    }
}