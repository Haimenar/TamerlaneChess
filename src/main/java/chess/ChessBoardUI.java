package chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;

import java.util.Collection;
import java.util.Objects;

public class ChessBoardUI {
    private static final int TILE_SIZE = 70;
    private static final int ROWS = 10;
    private static final int COLS = 11;
    private final GridPane boardTiles;
    private final ChessGame chessGame;
    private final Color lightTileColor = Color.DIMGREY;
    private final Color darkTileColor = Color.BLANCHEDALMOND;
    private final Color selectedTileColor = Color.CADETBLUE;
    private final Color possibleMoveTileColor = Color.LIGHTBLUE;
    private ChessPosition selectedPosition = null;


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
                background.setFill((row + col) % 2 == 0 ? darkTileColor : lightTileColor);
                tile.getChildren().add(background);
                int finalRow = row;
                int finalCol = col;
                tile.setOnMouseClicked(_ -> handleTileClick(finalRow, finalCol, background));

                boardTiles.add(tile, col, row);
            }
        }
    }

    /**
     * Updates the entire chessboard graphic based on the board state
     */
    public void updateBoard() {
        for (int row = 1; row <= ROWS; row++) {
            for (int col = 1; col <= COLS; col++) {
                // Get the corresponding tile
                StackPane tile = (StackPane) boardTiles.getChildren().get((-row + 10) * COLS + (col - 1));

                // Remove the existing piece
                tile.getChildren().removeIf(node -> node instanceof ImageView);

                // Get the piece at the current position
                ChessPiece piece = chessGame.getBoard().getPiece(new ChessPosition(row, col));
                if (piece != null) {
                    // Set the piece image
                    Image pieceImage;
                    if (piece.getPawnType() != null) {
                        pieceImage = new Image(Objects.requireNonNull(
                                getClass().getResourceAsStream("/assets/" + piece.getTeamColor() + "_" + piece.getPieceType() + "_" + piece.getPawnType() + ".png")
                        ));
                    } else {
                        pieceImage = new Image(Objects.requireNonNull(
                                getClass().getResourceAsStream("/assets/" + piece.getTeamColor() + "_" + piece.getPieceType() + ".png")
                        ));
                    }
                    ImageView pieceView = new ImageView(pieceImage);
                    pieceView.setFitWidth(TILE_SIZE);
                    pieceView.setFitHeight(TILE_SIZE);

                    // Add the piece to the tile
                    tile.getChildren().add(pieceView);
                }
            }
        }
    }

    /**
     * Handles what happens when a tile is clicked
     */
    private void handleTileClick(int row, int col, Rectangle background) {
        ChessPosition clickedPosition = new ChessPosition(10 - row, col + 1);
        ChessPiece clickedPiece = chessGame.getBoard().getPiece(clickedPosition);
        Collection<ChessMove> possibleMoves = chessGame.validMoves(clickedPosition);
        resetTileColors();

        // If there is already a piece selected, check if a new move is being made
        if (selectedPosition != null && (clickedPiece == null || clickedPiece.getTeamColor() != chessGame.getTeamTurn())) {
            Collection<ChessMove> moves = chessGame.validMoves(selectedPosition);
            System.out.println(moves);
            // Iterate through moves and see if they work
            for (ChessMove move : moves) {
                if (move.getEndPosition().equals(clickedPosition)) {
                    System.out.println("Move attempted");
                    try {
                        chessGame.makeMove(new ChessMove(selectedPosition, clickedPosition, move.getPromotionPiece()));
                        updateBoard();
                        System.out.println("Move made");
                    } catch (InvalidMoveException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
        // If the clicked tile is the player's own piece, show the available moves
        if (clickedPiece != null && clickedPiece.getTeamColor() == chessGame.getTeamTurn()) {
            selectedPosition = clickedPosition;
            background.setFill(selectedTileColor);

            // Select all tiles that this piece can move to
            for (ChessMove move : possibleMoves) {
                ChessPosition movePosition = move.getEndPosition();
                int moveRow = 10 - movePosition.getRow(); // Convert to 0-based indexing
                int moveCol = movePosition.getColumn() - 1;

                StackPane tile = (StackPane) boardTiles.getChildren().get(moveRow * COLS + moveCol);
                Rectangle moveBackground = (Rectangle) tile.getChildren().getFirst(); // First child is the background
                moveBackground.setFill(possibleMoveTileColor);
            }
        }
    }

    /**
     * Resets the colors of all tiles to their default
     */
    private void resetTileColors() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                StackPane tile = (StackPane) boardTiles.getChildren().get(row * COLS + col);
                Rectangle background = (Rectangle) tile.getChildren().getFirst(); // First child is the background
                background.setFill((row + col) % 2 == 0 ? darkTileColor : lightTileColor);
            }
        }
    }

    public GridPane getBoard() {
        return boardTiles;
    }
}
