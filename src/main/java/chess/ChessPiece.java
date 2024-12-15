package chess;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents a single chess piece
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;
    private final PawnType pawnInherit;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type, ChessPiece.PawnType pawnInherit) {
        this.pieceColor = pieceColor;
        this.type = type;
        this.pawnInherit = pawnInherit;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        COUNSELLOR,
        VIZIER,
        GIRAFFE,
        PICKET,
        KNIGHT,
        ROOK,
        ELEPHANT,
        CAMEL,
        WARENGINE,
        PAWN
    }
    public enum PawnType {
        NULL,
        KING,
        COUNSELLOR,
        VIZIER,
        GIRAFFE,
        PICKET,
        KNIGHT,
        ROOK,
        ELEPHANT,
        CAMEL,
        WARENGINE,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * @return which type of piece a pawn promotes to
     * Is NULL if it isn't a pawn
     */
    public PawnType getPawnType() {return pawnInherit;}

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition piecePosition) {
        if (type == PieceType.KING){
            return kingMoves(board, piecePosition);
        } else if (type == PieceType.COUNSELLOR){
            return counsellorMoves(board, piecePosition);
        } else if (type == PieceType.VIZIER){
            return vizierMoves(board, piecePosition);
        } else if (type == PieceType.GIRAFFE){
            return giraffeMoves(board, piecePosition);
        } else if (type == PieceType.PICKET){
            return picketMoves(board, piecePosition);
        } else if (type == PieceType.KNIGHT){
            return knightMoves(board, piecePosition);
        } else if (type == PieceType.ROOK){
            return rookMoves(board, piecePosition);
        } else if (type == PieceType.ELEPHANT){
            return elephantMoves(board, piecePosition);
        } else if (type == PieceType.CAMEL){
            return camelMoves(board, piecePosition);
        } else if (type == PieceType.WARENGINE){
            return warEngineMoves(board, piecePosition);
        } else if (type == PieceType.PAWN){
            return pawnMoves(board, piecePosition);
        } else {
            throw new RuntimeException("Piece not implemented");
        }

    }

    /**
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> kingMoves(ChessBoard board, ChessPosition startPosition) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> counsellorMoves(ChessBoard board, ChessPosition startPosition) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> vizierMoves(ChessBoard board, ChessPosition startPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        int row = startPosition.getRow();
        int col = startPosition.getColumn();

        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                if (!(x == 0 && y == 0)){
                    ChessPosition newPosition = new ChessPosition(row + x, col + y);

                    boolean validPosition = isValidPosition(newPosition);
                    boolean emptyPosition = isEmptySquare(board, newPosition);

                    if (validPosition) {
                        // A move to a valid position may be made if it is empty or an opposing piece
                        if (emptyPosition || isDifferentColor(board, startPosition, newPosition)){
                            moves.add(new ChessMove(startPosition, newPosition, null));
                        }
                    }
                }
            }
        }
        return moves;
    }

    /**
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> giraffeMoves(ChessBoard board, ChessPosition startPosition) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> picketMoves(ChessBoard board, ChessPosition startPosition) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> knightMoves(ChessBoard board, ChessPosition startPosition) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> rookMoves(ChessBoard board, ChessPosition startPosition) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> elephantMoves(ChessBoard board, ChessPosition startPosition) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> camelMoves(ChessBoard board, ChessPosition startPosition) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> warEngineMoves(ChessBoard board, ChessPosition startPosition) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> pawnMoves(ChessBoard board, ChessPosition startPosition) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * @return boolean of the colors of two positions
     * true if they are different colors, false if they are the same color
     */
    private boolean isDifferentColor(ChessBoard board, ChessPosition pos1, ChessPosition pos2) {
        return board.getPiece(pos1).getTeamColor() == board.getPiece(pos2).getTeamColor();
    }

    /**
     * @return boolean of if there is no piece on the selected position
     */
    private boolean isEmptySquare(ChessBoard board, ChessPosition position) {
        return board.getPiece(position).getPieceType() == null;
    }

    /**
     * @return boolean of if the position is on the board
     */
    private boolean isValidPosition(ChessPosition position) {
        int row = position.getRow();
        int col = position.getColumn();
        return(row >= 1 && row <= 10 && col >= 1 && col <= 11);
    }
}
