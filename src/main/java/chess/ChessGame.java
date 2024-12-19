package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/**
 * For a class that can manage a chess game, making moves on a board
 */
public class ChessGame {
    private TeamColor currentTeam = TeamColor.WHITE;
    private ChessBoard board =new ChessBoard();

    public ChessGame() {
        board.resetBoard();
    }

    /**
     * @return Which team's turn it is
     */
    public TeamColor getTeamTurn() {
        return currentTeam;
    }

    /**
     * Set's which teams turn it is
     *
     * @param team the team whose turn it is
     */
    public void setTeamTurn(TeamColor team) {
        currentTeam = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessGame chessGame = (ChessGame) o;
        return currentTeam == chessGame.currentTeam && Objects.equals(board, chessGame.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentTeam, board);
    }

    /**
     * Enum identifying the 2 possible teams in a chess game
     */
    public enum TeamColor {
        WHITE,
        BLACK
    }

    /**
     * Gets a valid moves for a piece at the given location
     *
     * @param startPosition the piece to get valid moves for
     * @return Set of valid moves for requested piece, or null if no piece at
     * startPosition
     */
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        ChessPiece piece = board.getPiece(startPosition);
        // If there isn't a piece, then return null
        if (piece == null) {
            return null;
        }

        ArrayList<ChessMove> validMovesList = new ArrayList<>();
        Collection<ChessMove> potentialMoves = piece.pieceMoves(board, startPosition);

        // Look at each potential move. If it doesn't put the king in check, then add to the list
        for (ChessMove move : potentialMoves) {
            if (!putsInCheck(piece.getTeamColor(), move)) {
                validMovesList.add(move);
            }
        }
        return new HashSet<>(validMovesList);
    }

    /**
     * Makes a move in a chess game
     *
     * @param move chess move to preform
     * @throws InvalidMoveException if move is invalid
     */
    public void makeMove(ChessMove move) throws InvalidMoveException {
        ChessPiece selectedPiece = board.getPiece(move.getStartPosition());
        ChessPosition startPosition = move.getStartPosition();
        ChessPosition endPosition = move.getEndPosition();
        // Make sure piece is selected
        if (selectedPiece == null) {
            throw new InvalidMoveException("No piece selected.");
        }
        // Make sure players can only move pieces if it is the respective player's turn
        if (selectedPiece.getTeamColor() != currentTeam) {
            throw new InvalidMoveException("It is the other player's turn. Wait for your turn to make a move.");
        }
        // Check if the move is valid
        Collection<ChessMove> possibleMoves = validMoves(startPosition);
        if (!possibleMoves.contains(move)) {
            throw new InvalidMoveException("Invalid move. Please choose a valid move.");
        }

        // Store the possible captured piece for later
        ChessPiece capturedPiece = board.getPiece(endPosition);
        board.removePiece(startPosition);

        // Execute the move
        if (move.getPromotionPiece() == null) {
            board.addPiece(endPosition, selectedPiece);
        } else {
            ChessPiece promotedPiece = new ChessPiece(currentTeam, move.getPromotionPiece(), null);
            board.addPiece(endPosition, promotedPiece);
        }

        // If the move puts the current team in check, undo the move
        if (isInCheck(selectedPiece.getTeamColor())) {
            board.addPiece(startPosition, selectedPiece);
            board.removePiece(endPosition);

            if (capturedPiece != null) {
                board.addPiece(endPosition, capturedPiece);
            }

            throw new InvalidMoveException("Move puts the king in check. Invalid move.");
        }

        // Switch the turn
        currentTeam = (currentTeam == TeamColor.WHITE) ? TeamColor.BLACK : TeamColor.WHITE;
    }


    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) {
        ChessPosition kingPosition = getKingPosition(teamColor);

        // If the player of teamColor has multiple kings, then the respective player cannot be in check
        if (hasMultipleKings(teamColor)) {
            return false;
        }

        // Iterate through the whole board
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 11; y++) {
                // Look at the piece at the position
                ChessPosition piecePosition = new ChessPosition(x, y);
                ChessPiece piece = board.getPiece(piecePosition);

                // If the square is empty, or the piece is the same color, it cannot check the king
                if (piece == null || piece.getTeamColor() == teamColor) {
                    continue;
                }

                // Check every move this piece can make and see if it puts the king in check
                Collection<ChessMove> possibleMoves = piece.pieceMoves(board, piecePosition);
                for (ChessMove move : possibleMoves) {
                    if (move.getEndPosition().equals(kingPosition)) {
                        return true;
                    }
                }
            }
        }

        // If it iterates through the whole board without checking the king, the king is not in check
        return false;
    }

    /**
     * Determines if the given team would be put in check by a move
     *
     * @param teamColor which team to check for check
     * @param move      Which move to execute
     * @return True if the specified team is in check
     */
    public boolean putsInCheck(TeamColor teamColor, ChessMove move) {
        ChessPiece selectedPiece = board.getPiece(move.getStartPosition());
        ChessPosition startPosition = move.getStartPosition();
        ChessPosition endPosition = move.getEndPosition();
        ChessPiece capturedPiece = board.getPiece(endPosition);
        // If the player of teamColor has multiple kings, then the respective player cannot be in check
        if (hasMultipleKings(teamColor)) {
            return false;
        }
        // Remove the starting piece
        board.removePiece(startPosition);
        // Add the promoted piece or regular piece
        if (move.getPromotionPiece() == null) {
            board.addPiece(endPosition, selectedPiece);
        } else {
            ChessPiece promotedPiece = new ChessPiece(currentTeam, move.getPromotionPiece(), null);
            board.addPiece(endPosition, promotedPiece);
        }

        boolean inCheck = isInCheck(teamColor);

        // Undo the move
        board.removePiece(endPosition);
        board.addPiece(startPosition, selectedPiece);
        if (capturedPiece != null) {
            board.addPiece(endPosition, capturedPiece);
        }

        return inCheck;
    }

    /**
     * Determines if the given team is in checkmate
     *
     * @param teamColor which team to check for checkmate
     * @return True if the specified team is in checkmate
     */
    public boolean isInCheckmate(TeamColor teamColor) {
        if (!isInCheck(teamColor)) {
            return false;
        }

        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 11; y++) {
                ChessPosition piecePosition = new ChessPosition(x, y);
                ChessPiece piece = board.getPiece(piecePosition);

                // If the space is empty or the piece is the opposite color, it cannot get the player out of check
                if (piece == null || piece.getTeamColor() != teamColor) {
                    continue;
                }
                //Look through all available moves, if there is a move to make, then they aren't in checkMate
                Collection<ChessMove> possibleMoves = validMoves(piecePosition);
                if (!possibleMoves.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determines if the given team is in stalemate, which here is defined as having
     * no valid moves
     *
     * @param teamColor which team to check for stalemate
     * @return True if the specified team is in stalemate, otherwise false
     */
    public boolean isInStalemate(TeamColor teamColor) {
        if (isInCheck(teamColor)) {
            return false;
        }

        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 11; y++) {

                ChessPosition piecePosition = new ChessPosition(x, y);
                ChessPiece piece = board.getPiece(piecePosition);

                // Check if the square is empty or on the opposing team
                if ((piece == null) || (piece.getTeamColor() != teamColor)) {
                    continue;
                }

                Collection<ChessMove> possibleMoves = validMoves(piecePosition);
                if (!possibleMoves.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Sets this game's chessboard with a given board
     *
     * @param board the new board to use
     */
    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    /**
     * Gets the current chessboard
     *
     * @return the chessboard
     */
    public ChessBoard getBoard() {
        return this.board;
    }

    /**
     * Determines the position of the king of the team
     * If there are multiple kings of one color on the board, then the king's position doesn't matter
     *
     * @param teamColor color of the king
     * @return Position of the king of the teamColor
     */
    private ChessPosition getKingPosition(TeamColor teamColor) {
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 11; y++) {
                ChessPiece potentialKing = board.getPiece(new ChessPosition(x, y));

                // Check if the square is empty
                if (potentialKing == null) {
                    continue;
                }

                // Check if the king is the right color
                if (potentialKing.getTeamColor() != teamColor) {
                    continue;
                }

                // Check if the piece is a king, prince, or adventitious king
                if (potentialKing.getPieceType() == ChessPiece.PieceType.KING) {
                    return new ChessPosition(x, y);
                } else if (potentialKing.getPieceType() == ChessPiece.PieceType.PRINCE) {
                    return new ChessPosition(x, y);
                } else if (potentialKing.getPieceType() == ChessPiece.PieceType.ADVENTITIOUSKING) {
                    return new ChessPosition(x, y);
                }
            }
        }
        return null; // There is no king on the board
    }

    /**
     * Checks if there are multiple kings of the input color
     *
     * @return boolean, true if more than one king of the input color
     */
    public Boolean hasMultipleKings(TeamColor teamColor) {
        int kingCounter = 0;

        // Iterate through the board
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 11; y ++){
                ChessPiece potentialKing = board.getPiece(new ChessPosition(x, y));

                // If the square is empty, then continue
                if (potentialKing == null) {
                    continue;
                }

                // Check if the king is the right color
                if (potentialKing.getTeamColor() != teamColor) {
                    continue;
                }

                // Check if the piece is a king, prince, or adventitious king and increment king counter accordingly
                if (potentialKing.getPieceType() == ChessPiece.PieceType.KING) {
                    kingCounter ++;
                } else if (potentialKing.getPieceType() == ChessPiece.PieceType.PRINCE) {
                    kingCounter ++;
                } else if (potentialKing.getPieceType() == ChessPiece.PieceType.ADVENTITIOUSKING) {
                    kingCounter ++;
                }
            }
        }

        return kingCounter > 1;
    }
}
