package chess;

import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 */
public class ChessBoard {
    private final ChessPiece[][] squares = new ChessPiece[10][11];

    public ChessBoard() {
        
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        squares[position.getRow() - 1][position.getColumn() - 1] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return squares[position.getRow() - 1][position.getColumn() - 1];
    }

    /**
     * Sets the board to the default starting board
     */
    public void resetBoard() {
            //Remove all
            for (int x = 0; x < 10; x++){
                for (int y = 0; y < 11; y++){
                    this.squares[x][y] = null;
                }
            }

            ChessPiece.PieceType[] backRowPieces =
                    {ChessPiece.PieceType.ELEPHANT, ChessPiece.PieceType.CAMEL,
                    ChessPiece.PieceType.WARMACHINE, ChessPiece.PieceType.WARMACHINE,
                            ChessPiece.PieceType.CAMEL, ChessPiece.PieceType.ELEPHANT};
            int x = 1;
            int y = 1;
            //White Pieces Back Row
            for (ChessPiece.PieceType type : backRowPieces){
                addPiece(new ChessPosition(x, y), new ChessPiece(ChessGame.TeamColor.WHITE, type, null));
                y += 2;
            }

            //White Pieces Middle Row
            ChessPiece.PieceType[] middleRowPieces =
                    {ChessPiece.PieceType.ROOK, ChessPiece.PieceType.KNIGHT,
                            ChessPiece.PieceType.PICKET, ChessPiece.PieceType.GIRAFFE,
                            ChessPiece.PieceType.COUNSELLOR, ChessPiece.PieceType.KING,
                            ChessPiece.PieceType.VIZIER, ChessPiece.PieceType.GIRAFFE,
                            ChessPiece.PieceType.PICKET, ChessPiece.PieceType.KNIGHT,
                            ChessPiece.PieceType.ROOK};
            x = 2;
            y = 1;
            for (ChessPiece.PieceType type : middleRowPieces){
                addPiece(new ChessPosition(x, y), new ChessPiece(ChessGame.TeamColor.WHITE, type, null));
                y ++;
            }

            //White Pawns
            ChessPiece.PieceType[] pawnTypeArray =
                    {ChessPiece.PieceType.PAWN, ChessPiece.PieceType.WARMACHINE,
                            ChessPiece.PieceType.CAMEL, ChessPiece.PieceType.ELEPHANT,
                            ChessPiece.PieceType.COUNSELLOR, ChessPiece.PieceType.KING,
                            ChessPiece.PieceType.VIZIER, ChessPiece.PieceType.GIRAFFE,
                            ChessPiece.PieceType.PICKET, ChessPiece.PieceType.KNIGHT,
                            ChessPiece.PieceType.ROOK};
            x = 3;
            y = 1;
            for (ChessPiece.PieceType pawnType : pawnTypeArray){
                addPiece(new ChessPosition(x, y), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN, pawnType));
                y ++;
            }

            //Black Pieces Back Row
            x = 10;
            y = 1;

            for (ChessPiece.PieceType type : backRowPieces){
                addPiece(new ChessPosition(x, y), new ChessPiece(ChessGame.TeamColor.BLACK, type, null));
                y += 2;
            }

            //Black Pieces Middle Row
            x = 9;
            y = 11;

            for (ChessPiece.PieceType type : middleRowPieces){
                addPiece(new ChessPosition(x, y), new ChessPiece(ChessGame.TeamColor.BLACK, type, null));
                y --;
            }
            //Black Pawns
            x = 8;
            y = 11;
            for (ChessPiece.PieceType pawnType : pawnTypeArray){
                addPiece(new ChessPosition(x, y), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN, pawnType));
                y --;
            }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(squares, that.squares);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(squares);
    }

    @Override
    public String toString() {
        var board  = "";
        for (int rows = 0; rows < 10; rows++) {
            board += "|";
            for (int columns = 0; columns < 11; columns++) {
                if (squares[rows][columns] != null) {
                    board += squares[rows][columns].toString();
                }
                else {
                    board += " ";
                }
                board += "|";
            }
            board += "\n";
        }
        return board;
    }
}
