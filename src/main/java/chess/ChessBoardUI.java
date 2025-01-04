package chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;

import java.util.Objects;

public class ChessBoardUI {
    private static final int TILE_SIZE = 70;
    private static final int ROWS = 10;
    private static final int COLS = 11;
    private final GridPane boardTiles;
    private final ChessGame chessGame;

    public ChessBoardUI(ChessGame chessGame) {
        this.boardTiles = new GridPane();
        this.chessGame = chessGame;
        drawBoard();
        updateBoard();
    }

    private void drawBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                StackPane tile = new StackPane();
                Rectangle background = new Rectangle(TILE_SIZE, TILE_SIZE);
                background.setFill((row + col) % 2 == 0 ? Color.LIGHTGREY : Color.BEIGE);
                tile.getChildren().add(background);
                boardTiles.add(tile, col, row);
            }
        }
        System.out.print(chessGame.getBoard());
    }

    /**
     * Updates the chessboard graphic based on the board state
     */
    public void updateBoard() {
        for (int row = 1; row <= ROWS; row++) {
            for (int col = 1; col <= COLS; col++) {
                System.out.println("Row: " + row + " column: " + col);
                System.out.println("Full: " +((row - 1)*COLS + (col - 1)));
                ChessPiece piece = chessGame.getBoard().getPiece(new ChessPosition(row, col));
                System.out.println(piece);
                if (piece == null) {
                    continue;
                }
                // Set the piece image. If it is a pawn, then add _{pawnType} to the end of file name
                Image pieceImage;
                if (piece.getPawnType() != null) {
                    pieceImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/" + piece.getTeamColor() + "_" + piece.getPieceType() + "_" + piece.getPawnType() + ".png")));
                } else {
                    pieceImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/" + piece.getTeamColor() + "_" + piece.getPieceType() + ".png")));
                }

                ImageView pieceView = new ImageView(pieceImage);
                pieceView.setFitWidth(TILE_SIZE);
                pieceView.setFitHeight(TILE_SIZE);
                // Add the piece to the corresponding tile
                StackPane tile = (StackPane) boardTiles.getChildren().get((-row + 10) * COLS + (col - 1));
                tile.getChildren().add(pieceView);
            }
        }
    }

    public GridPane getBoard() {
        return boardTiles;
    }
}
