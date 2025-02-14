package passoff.chess;

import chess.*;
import org.junit.jupiter.api.Assertions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

public class TestUtilities {
    static public void validateMoves(String boardText, ChessPosition startPosition, int[][] endPositions) {
        var board = loadBoard(boardText);
        var testPiece = board.getPiece(startPosition);
        var validMoves = loadMoves(startPosition, endPositions);
        validateMoves(board, testPiece, startPosition, validMoves);
    }

    static public void validateMoves(ChessBoard board, ChessPiece testPiece, ChessPosition startPosition, Set<ChessMove> validMoves) {
        var pieceMoves = new HashSet<>(testPiece.pieceMoves(board, startPosition));
        assertCollectionsEquals(validMoves, pieceMoves, "Wrong moves");
    }

    static public <T> void assertCollectionsEquals(Collection<T> first, Collection<T> second, String message) {
        Assertions.assertEquals(new HashSet<>(first), new HashSet<>(second), message);
        Assertions.assertEquals(first.size(), second.size(), "Collections not the same size");
    }

    final static Map<Character, ChessPiece.PieceType> CHAR_TO_TYPE_MAP = Map.ofEntries(
            entry('k', ChessPiece.PieceType.KING),
            entry('c', ChessPiece.PieceType.GENERAL),
            entry('v', ChessPiece.PieceType.VIZIER),
            entry('g', ChessPiece.PieceType.GIRAFFE),
            entry('p', ChessPiece.PieceType.PICKET),
            entry('l', ChessPiece.PieceType.KNIGHT),
            entry('r', ChessPiece.PieceType.ROOK),
            entry('e', ChessPiece.PieceType.ELEPHANT),
            entry('m', ChessPiece.PieceType.CAMEL),
            entry('w', ChessPiece.PieceType.WARMACHINE),
            entry('o', ChessPiece.PieceType.PAWN)
    );


    public static ChessBoard loadBoard(String boardText) {
        var board = new ChessBoard();
        int row = 10;
        int column = 1;

        ChessPiece.PieceType[] pawnTypeArray = {
                ChessPiece.PieceType.PAWN, ChessPiece.PieceType.WARMACHINE,
                ChessPiece.PieceType.CAMEL, ChessPiece.PieceType.ELEPHANT,
                ChessPiece.PieceType.GENERAL, ChessPiece.PieceType.KING,
                ChessPiece.PieceType.VIZIER, ChessPiece.PieceType.GIRAFFE,
                ChessPiece.PieceType.PICKET, ChessPiece.PieceType.KNIGHT,
                ChessPiece.PieceType.ROOK
        };

        // Reverse the pawnTypeArray for black pawns
        ChessPiece.PieceType[] reversedPawnTypeArray = reverseArray(pawnTypeArray);

        int whitePawnIndex = 0; // Index to iterate over pawnTypeArray for white pawns
        int blackPawnIndex = 0; // Index to iterate over reversedPawnTypeArray for black pawns

        for (var c : boardText.toCharArray()) {
            switch (c) {
                case '\n' -> {
                    column = 1;
                    row--;
                }
                case ' ' -> column++;
                case '|' -> { /* Do nothing for board separators */ }
                default -> {
                    ChessGame.TeamColor color = Character.isLowerCase(c) ? ChessGame.TeamColor.BLACK
                            : ChessGame.TeamColor.WHITE;
                    var type = CHAR_TO_TYPE_MAP.get(Character.toLowerCase(c));
                    var position = new ChessPosition(row, column);

                    if (type == ChessPiece.PieceType.PAWN) {
                        ChessPiece.PieceType pawnType;

                        // Assign reversed pawn type for black pawns, normal order for white pawns
                        if (color == ChessGame.TeamColor.BLACK) {
                            pawnType = reversedPawnTypeArray[blackPawnIndex % reversedPawnTypeArray.length];
                            blackPawnIndex++;
                        } else {
                            pawnType = pawnTypeArray[whitePawnIndex % pawnTypeArray.length];
                            whitePawnIndex++;
                        }

                        var piece = new ChessPiece(color, type, pawnType);
                        board.addPiece(position, piece);
                    } else {
                        var piece = new ChessPiece(color, type, null);
                        board.addPiece(position, piece);
                    }
                    column++;
                }
            }
        }
        return board;
    }

    private static ChessPiece.PieceType[] reverseArray(ChessPiece.PieceType[] array) {
        ChessPiece.PieceType[] reversed = new ChessPiece.PieceType[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    public static Set<ChessMove> loadMoves(ChessPosition startPosition, int[][] endPositions) {
        var validMoves = new HashSet<ChessMove>();
        for (var endPosition : endPositions) {
            validMoves.add(new ChessMove(startPosition,
                    new ChessPosition(endPosition[0], endPosition[1]), null));
        }
        return validMoves;
    }

    public static void assertMoves(ChessGame game, Set<ChessMove> validMoves, ChessPosition position) {
        var generatedMoves = game.validMoves(position);
        var actualMoves = new HashSet<>(generatedMoves);
        Assertions.assertEquals(generatedMoves.size(), actualMoves.size(), "Duplicate move");
        Assertions.assertEquals(validMoves, actualMoves,
                "ChessGame validMoves did not return the correct moves");
    }
}
