package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;
    private final PieceType pawnInherit;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type, ChessPiece.PieceType pawnInherit) {
        this.pieceColor = pieceColor;
        this.type = type;
        this.pawnInherit = pawnInherit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece piece = (ChessPiece) o;
        return pieceColor == piece.pieceColor && type == piece.type && pawnInherit == piece.pawnInherit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type, pawnInherit);
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "Color=" + pieceColor +
                ", type=" + type +
                ", pawnInherit=" + pawnInherit +
                '}';
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
        WARMACHINE,
        PAWN,
        PRINCE,
        ADVENTITIOUSKING
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
    public PieceType getPawnType() {return pawnInherit;}

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition piecePosition) {
        return switch (type) {
            case KING -> kingMoves(board, piecePosition);
            case COUNSELLOR -> counsellorMoves(board, piecePosition);
            case VIZIER -> vizierMoves(board, piecePosition);
            case GIRAFFE -> giraffeMoves(board, piecePosition);
            case PICKET -> picketMoves(board, piecePosition);
            case KNIGHT -> knightMoves(board, piecePosition);
            case ROOK -> rookMoves(board, piecePosition);
            case ELEPHANT -> elephantMoves(board, piecePosition);
            case CAMEL -> camelMoves(board, piecePosition);
            case WARMACHINE -> warMachineMoves(board, piecePosition);
            case PAWN -> pawnMoves(board, piecePosition);
            case PRINCE -> princeMoves(board, piecePosition);
            case ADVENTITIOUSKING -> adventitiousKingMoves(board, piecePosition);
            case null, default -> throw new RuntimeException("Piece not implemented");
        };

    }

    /**
     * King moves one square vertically or horizontally
     *
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> kingMoves(ChessBoard board, ChessPosition startPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        int row = startPosition.getRow();
        int col = startPosition.getColumn();
        int[][] spots = {{1,1}, {1,-1}, {-1,1}, {-1,-1}, {1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int[] spot : spots){
            int x = spot[0];
            int y = spot[1];
            ChessPosition newPosition = new ChessPosition(row + x, col + y);

            if(isValidPosition(newPosition)) {
                if (isEmptySquare(board, newPosition) || ((!isEmptySquare(board, newPosition) && isDifferentColor(board, startPosition, newPosition)))){
                    moves.add(new ChessMove(startPosition, newPosition, null));
                }
            }
        }
        return moves;
    }

    /**
     * Prince moves one square vertically or horizontally
     *
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> princeMoves(ChessBoard board, ChessPosition startPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        int row = startPosition.getRow();
        int col = startPosition.getColumn();
        int[][] spots = {{1,1}, {1,-1}, {-1,1}, {-1,-1}, {1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int[] spot : spots){
            int x = spot[0];
            int y = spot[1];
            ChessPosition newPosition = new ChessPosition(row + x, col + y);

            if(isValidPosition(newPosition)) {
                if (isEmptySquare(board, newPosition) || ((!isEmptySquare(board, newPosition) && isDifferentColor(board, startPosition, newPosition)))){
                    moves.add(new ChessMove(startPosition, newPosition, null));
                }
            }
        }
        return moves;
    }

    /**
     * Adventitious king moves one square vertically or horizontally
     *
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> adventitiousKingMoves(ChessBoard board, ChessPosition startPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        int row = startPosition.getRow();
        int col = startPosition.getColumn();
        int[][] spots = {{1,1}, {1,-1}, {-1,1}, {-1,-1}, {1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int[] spot : spots){
            int x = spot[0];
            int y = spot[1];
            ChessPosition newPosition = new ChessPosition(row + x, col + y);

            if(isValidPosition(newPosition)) {
                if (isEmptySquare(board, newPosition) || ((!isEmptySquare(board, newPosition) && isDifferentColor(board, startPosition, newPosition)))){
                    moves.add(new ChessMove(startPosition, newPosition, null));
                }
            }
        }
        return moves;
    }

    /**
     * Counsellor moves one square diagonally
     *
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> counsellorMoves(ChessBoard board, ChessPosition startPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        int row = startPosition.getRow();
        int col = startPosition.getColumn();
        int[][] spots = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int[] spot : spots){
            int x = spot[0];
            int y = spot[1];
            ChessPosition newPosition = new ChessPosition(row + x, col + y);

            if(isValidPosition(newPosition)) {
                if (isEmptySquare(board, newPosition) || ((!isEmptySquare(board, newPosition) && isDifferentColor(board, startPosition, newPosition)))){
                    moves.add(new ChessMove(startPosition, newPosition, null));
                }
            }
        }
        return moves;        }

    /**
     * Vizier moves one square vertically or horizontally
     *
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

                    if(isValidPosition(newPosition)) {
                        if (isEmptySquare(board, newPosition) || ((!isEmptySquare(board, newPosition) && isDifferentColor(board, startPosition, newPosition)))){
                            moves.add(new ChessMove(startPosition, newPosition, null));
                        }
                    }
                }
            }
        }
        return moves;
    }

    /**
     * Giraffe moves diagonally once and then a minimum of three squares vertically or horizontally
     * Cannot jump pieces
     * Can only make the diagonal move if there is also an empty square adjacent to
     * the giraffe's square and diagonal square
     *
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> giraffeMoves(ChessBoard board, ChessPosition startPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        int row = startPosition.getRow();
        int col = startPosition.getColumn();

        int[][] cornerDirections = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int[] corner : cornerDirections) {
            int diagonalRow = row + corner[0];
            int diagonalCol = col + corner[1];
            ChessPosition diagonalSquare = new ChessPosition(diagonalRow, diagonalCol);
            ChessPosition adjacentSquare1 = new ChessPosition(diagonalRow, col);
            ChessPosition adjacentSquare2 = new ChessPosition(row, diagonalCol);

            // Check if diagonal square is empty
            if (!isValidPosition(diagonalSquare) || !isEmptySquare(board, diagonalSquare)) {
                continue;
            }

            //Check if there is at least one adjacent space nest to the diagonal square
            if ((!isValidPosition(adjacentSquare1) || !isEmptySquare(board, adjacentSquare1)) && (!isValidPosition(adjacentSquare2) || !isEmptySquare(board, adjacentSquare2))) {
                continue;
            }

            // Directions to continue from the diagonal square
            int[][] straightDirections = {{corner[0], 0}, {0, corner[1]}};

            for (int[] dir : straightDirections) {
                int newRow = diagonalRow;
                int newCol = diagonalCol;
                int steps = 0;

                // Move in the current direction while valid
                while (true) {
                    newRow += dir[0];
                    newCol += dir[1];
                    steps++;

                    ChessPosition newPosition = new ChessPosition(newRow, newCol);

                    if (!isValidPosition(newPosition)) break;

                    if (board.getPiece(newPosition) != null) {
                        // If it's an opponent's piece and the move is at least 3 spaces, add it
                        if (steps >= 3 && isDifferentColor(board, startPosition, newPosition)) {
                            moves.add(new ChessMove(startPosition, newPosition, null));
                        }
                        break;
                    }

                    if (steps >= 3) {
                        moves.add(new ChessMove(startPosition, newPosition, null));
                    }
                }
            }
        }

        return moves;
    }

    /**
     * Picket moves two or more squares diagonally
     * Cannot jump pieces
     *
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> picketMoves(ChessBoard board, ChessPosition startPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        int row = startPosition.getRow();
        int col = startPosition.getColumn();
        int[][] direction = {{1,1}, {-1,1}, {1,-1}, {-1,-1}};

        for(int[] dir : direction){
            int x = dir[0];
            int y = dir[1];
            ChessPosition newPosition = new ChessPosition(row + x, col + y);

            while(isValidPosition(newPosition) && board.getPiece(newPosition) == null){
                // The Picket can only move more than one space at a time
                // Since x and y are always incremented together, so
                // if their product is neither 1 nor -1, the piece will move more than one space
                if (x*y != 1 && x*y != -1) {
                    moves.add(new ChessMove(startPosition, newPosition, null));
                }

                x += dir[0];
                y += dir[1];
                newPosition = new ChessPosition(row + x, col + y);
            }

            if (isValidPosition(newPosition) && isDifferentColor(board, startPosition, newPosition)){
                moves.add(new ChessMove(startPosition, newPosition, null));
            }
        }
        return moves;
    }

    /**
     * Knight jumps one square vertically and two squares horizontally
     * or jumps one square horizontally and two squares vertically
     *
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> knightMoves(ChessBoard board, ChessPosition startPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        int row = startPosition.getRow();
        int col = startPosition.getColumn();
        int[][] spots = {{2,1}, {-2,1}, {2,-1}, {-2,-1}, {1,2}, {-1,2}, {1,-2}, {-1,-2}};

        for(int[] spot : spots){
            int x = spot[0];
            int y = spot[1];
            ChessPosition newPosition = new ChessPosition(row + x, col + y);

            if(isValidPosition(newPosition)) {
                if (isEmptySquare(board, newPosition) || ((!isEmptySquare(board, newPosition) && isDifferentColor(board, startPosition, newPosition)))){
                    moves.add(new ChessMove(startPosition, newPosition, null));
                }
            }
        }
        return moves;
    }

    /**
     * Rook moves any number of squares vertically or horizontally
     * Cannot jump pieces
     *
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> rookMoves(ChessBoard board, ChessPosition startPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        int row = startPosition.getRow();
        int col = startPosition.getColumn();
        int[][] direction = {{1,0}, {-1,0}, {0,-1}, {0,1}};

        for(int[] dir : direction){
            int x = dir[0];
            int y = dir[1];
            ChessPosition newPosition = new ChessPosition(row + x, col + y);

            while(isValidPosition(newPosition) && isEmptySquare(board, newPosition)){
                moves.add(new ChessMove(startPosition, newPosition, null));
                x += dir[0];
                y += dir[1];
                newPosition = new ChessPosition(row + x, col + y);
            }

            if (isValidPosition(newPosition) && isDifferentColor(board, startPosition, newPosition)){
                moves.add(new ChessMove(startPosition, newPosition, null));
            }
        }
        return moves;
    }

    /**
     * Elephant jumps two squares diagonally
     *
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> elephantMoves(ChessBoard board, ChessPosition startPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        int row = startPosition.getRow();
        int col = startPosition.getColumn();

        for (int x = -2; x <= 2; x += 4) {
            for (int y = -2; y <= 2; y += 4) {
                ChessPosition newPosition = new ChessPosition(row + x, col + y);

                if(isValidPosition(newPosition)) {
                    if (isEmptySquare(board, newPosition) || ((!isEmptySquare(board, newPosition) && isDifferentColor(board, startPosition, newPosition)))){
                        moves.add(new ChessMove(startPosition, newPosition, null));
                    }
                }
            }
        }
        return moves;
    }

    /**
     * Camel jumps one square vertically and three squares horizontally,
     * or one square horizontally and three squares vertically
     *
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> camelMoves(ChessBoard board, ChessPosition startPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        int row = startPosition.getRow();
        int col = startPosition.getColumn();
        int[][] spots = {{3,1}, {-3,1}, {3,-1}, {-3,-1}, {1,3}, {-1,3}, {1,-3}, {-1,-3}};

        for(int[] spot : spots){
            int x = spot[0];
            int y = spot[1];
            ChessPosition newPosition = new ChessPosition(row + x, col + y);

            if(isValidPosition(newPosition)) {
                if (isEmptySquare(board, newPosition) || ((!isEmptySquare(board, newPosition) && isDifferentColor(board, startPosition, newPosition)))){
                    moves.add(new ChessMove(startPosition, newPosition, null));
                }
            }
        }
        return moves;
    }

    /**
     * War machine jumps two squares horizontally or vertically
     *
     * @return ArrayList of all positions this chess piece can move to
     */
    private ArrayList<ChessMove> warMachineMoves(ChessBoard board, ChessPosition startPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        int row = startPosition.getRow();
        int col = startPosition.getColumn();
        int[][] spots = {{2,0}, {-2,0}, {0,2}, {0,-2}};

        for(int[] spot : spots){
            int x = spot[0];
            int y = spot[1];
            ChessPosition newPosition = new ChessPosition(row + x, col + y);

            if(isValidPosition(newPosition)) {
                if (isEmptySquare(board, newPosition) || ((!isEmptySquare(board, newPosition) && isDifferentColor(board, startPosition, newPosition)))){
                    moves.add(new ChessMove(startPosition, newPosition, null));
                }
            }
        }
        return moves;
    }

    /**
     * Pawn moves forward one square if unobstructed. Can move diagonally forward if capturing
     * White pawns move in increasing rows or "up" the board
     * Black pawns move in decreasing rows, or "down" the board
     *
     * @return ArrayList of all positions this chess piece can move to
     */
    public ArrayList<ChessMove> pawnMoves(ChessBoard board, ChessPosition startPosition){
        ArrayList<ChessMove> moves = new ArrayList<>();
        int row = startPosition.getRow();
        int col = startPosition.getColumn();

        if (getTeamColor() == ChessGame.TeamColor.WHITE){
            //This piece is WHITE
            //set up diagonals
            int[][] diagonals = {{1,1}, {1,-1}};

            //Attacks
            for(int[] diag : diagonals) {
                int x = diag[0];
                int y = diag[1];
                ChessPosition newPosition = new ChessPosition(row + x, col + y);

                if (isValidPosition(newPosition) && (board.getPiece(newPosition) != null && isDifferentColor(board, startPosition, newPosition))) {
                    //Check conditions for promotion
                    if (row == 7){
                        moves.add(new ChessMove(startPosition, newPosition, getPawnType()));
                    } else {
                        moves.add(new ChessMove(startPosition, newPosition, null));
                    }
                }
            }
            //Get forward move
            ChessPosition newPosition = new ChessPosition(row + 1, col);

            if (isValidPosition(newPosition) && board.getPiece(newPosition) == null) {
                //Check conditions for promotion
                if (row == 7){
                    moves.add(new ChessMove(startPosition, newPosition, getPawnType()));
                } else {
                    moves.add(new ChessMove(startPosition, newPosition, null));
                }
            }
        } else {
            //This piece is BLACK
            //Set up diagonals
            int[][] diagonals = {{-1,1}, {-1,-1}};

            for(int[] diag : diagonals) {
                int x = diag[0];
                int y = diag[1];
                ChessPosition newPosition = new ChessPosition(row + x, col + y);

                if (isValidPosition(newPosition) && (board.getPiece(newPosition) != null && isDifferentColor(board, startPosition, newPosition))) {
                    //Check conditions for promotion
                    if (row == 2){
                        moves.add(new ChessMove(startPosition, newPosition, getPawnType()));
                    } else {
                        moves.add(new ChessMove(startPosition, newPosition, null));
                    }
                }
            }
            //Get forward move
            ChessPosition newPosition = new ChessPosition(row - 1, col);

            if (isValidPosition(newPosition) && board.getPiece(newPosition) == null) {
                //Check conditions for promotion
                if (row == 2){
                    moves.add(new ChessMove(startPosition, newPosition, getPawnType()));
                } else {
                    moves.add(new ChessMove(startPosition, newPosition, null));
                }
            }
        }
        return moves;
    }

    /**
     * @return boolean of the colors of two positions
     * true if they are different colors, false if they are the same color
     */
    private boolean isDifferentColor(ChessBoard board, ChessPosition pos1, ChessPosition pos2) {
        return board.getPiece(pos1).getTeamColor() != board.getPiece(pos2).getTeamColor();
    }

    /**
     * @return boolean of if there is no piece on the selected position
     */
    private boolean isEmptySquare(ChessBoard board, ChessPosition position) {
        return board.getPiece(position) == null;
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
