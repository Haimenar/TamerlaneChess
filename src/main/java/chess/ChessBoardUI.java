package chess;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoardUI {
    private static final int TILE_SIZE = 50;
    private static final int ROWS = 10;
    private static final int COLS = 11;

    private final GridPane board;

    public ChessBoardUI() {
        board = new GridPane();
        drawBoard();
    }

    private void drawBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
                tile.setFill((row + col) % 2 == 0 ? Color.LIGHTGREY : Color.BEIGE);
                board.add(tile, col, row);
            }
        }
    }

    public GridPane getBoard() {
        return board;
    }
}
