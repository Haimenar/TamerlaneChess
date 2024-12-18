package passoff.chess.game;

import chess.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static passoff.chess.TestUtilities.loadBoard;

public class MakeMoveTests {

    @Test
    @DisplayName("Make Valid King Move")
    public void makeValidKingMove() throws InvalidMoveException {
        var game = new ChessGame();
        game.setBoard(loadBoard("""
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                |o| | | | | | |k| | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | |K| | | | | | | | | |
                """));
        game.setTeamTurn(ChessGame.TeamColor.WHITE);

        var kingStartPosition = new ChessPosition(1, 2);
        var kingEndPosition = new ChessPosition(1, 1);
        game.makeMove(new ChessMove(kingStartPosition, kingEndPosition, null));

        Assertions.assertEquals(loadBoard("""
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                |o| | | | | | |k| | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                |K| | | | | | | | | | |
                """), game.getBoard());
    }

    @Test
    @DisplayName("Make Valid Picket Move")
    public void makeValidPicketMove() throws InvalidMoveException {
        var game = new ChessGame();
        game.setBoard(loadBoard("""
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | |r|
                |K| |k| |p| | | | | | |
                """));
        game.setTeamTurn(ChessGame.TeamColor.BLACK);

        var picketStartPosition = new ChessPosition(1, 5);
        var picketEndPosition = new ChessPosition(3, 3);
        game.makeMove(new ChessMove(picketStartPosition, picketEndPosition, null));

        Assertions.assertEquals(loadBoard("""
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | |p| | | | | | | | |
                | | | | | | | | | | |r|
                |K| |k| | | | | | | | |
                """), game.getBoard());
    }

    @Test
    @DisplayName("Make Valid Rook Move")
    public void makeValidRookMove() throws InvalidMoveException {
        var game = new ChessGame();
        game.setBoard(loadBoard("""
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | |k| | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | |R| | | |
                | | | | | | | | | | | |
                |K| | | | | | | | | | |
                """));
        game.setTeamTurn(ChessGame.TeamColor.WHITE);

        var rookStartPosition = new ChessPosition(3, 8);
        var rookEndPosition = new ChessPosition(7, 8);
        game.makeMove(new ChessMove(rookStartPosition, rookEndPosition, null));

        Assertions.assertEquals(loadBoard("""
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | |k| | | | | | |
                | | | | | | | |R| | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                |K| | | | | | | | | | |
                """), game.getBoard());
    }

    @Test
    @DisplayName("Make Valid Knight Move")
    public void makeValidKnightMove() throws InvalidMoveException {
        var game = new ChessGame();
        game.setBoard(loadBoard("""
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | |k| | | | | | |
                | | | | | | | | | | | |
                | | |l| | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | |O| | | |
                | | | | |K| | | | | | |
                """));
        game.setTeamTurn(ChessGame.TeamColor.BLACK);

        var knightStartPosition = new ChessPosition(6, 3);
        var knightEndPosition = new ChessPosition(4, 4);
        game.makeMove(new ChessMove(knightStartPosition, knightEndPosition, null));

        Assertions.assertEquals(loadBoard("""
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | |k| | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | |l| | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | |O| | | |
                | | | | |K| | | | | | |
                """), game.getBoard());
    }

    @Test
    @DisplayName("Make Valid Bishop Move")
    public void makeValidBishopMove() throws InvalidMoveException {
        var game = new ChessGame();
        game.setBoard(loadBoard("""
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | |k| | | | | | |
                |o| | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | |P| |K| | | | | | |
                """));
        game.setTeamTurn(ChessGame.TeamColor.WHITE);

        var bishopStartPosition = new ChessPosition(1, 3);
        var bishopEndPosition = new ChessPosition(6, 8);
        game.makeMove(new ChessMove(bishopStartPosition, bishopEndPosition, null));

        Assertions.assertEquals(loadBoard("""
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | |k| | | | | | |
                |o| | | | | | | | | | |
                | | | | | | | |P| | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | |K| | | | | | |
                """), game.getBoard());
    }

    @Test
    @DisplayName("Make Valid Pawn Move")
    public void makeValidPawnMove() throws InvalidMoveException {
        var game = new ChessGame();
        game.setBoard(loadBoard("""
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | |k| | | | | | | | | |
                | |o| | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | |O| | | | |
                | | | | | | |K| | | | |
                """));
        game.setTeamTurn(ChessGame.TeamColor.BLACK);

        var pawnStartPosition = new ChessPosition(7, 2);
        var pawnEndPosition = new ChessPosition(6, 2);
        game.makeMove(new ChessMove(pawnStartPosition, pawnEndPosition, null));

        Assertions.assertEquals(loadBoard("""
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | |k| | | | | | | | | |
                | | | | | | | | | | | |
                | |o| | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | |O| | | | |
                | | | | | | |K| | | | |
                """), game.getBoard());
    }

    @Test
    @DisplayName("Invalid Make Move Too Far")
    public void invalidMakeMoveTooFar() {
        var game = new ChessGame();
        Assertions.assertThrows(InvalidMoveException.class,
                () -> game.makeMove(new ChessMove(new ChessPosition(2, 1), new ChessPosition(5, 1), null)));
    }

    @Test
    @DisplayName("Invalid Make Move Pawn Diagonal No Capture")
    public void invalidMakeMovePawnDiagonalNoCapture() {
        var game = new ChessGame();
        Assertions.assertThrows(InvalidMoveException.class,
                () -> game.makeMove(new ChessMove(new ChessPosition(2, 1), new ChessPosition(3, 2), null)));
    }

    @Test
    @DisplayName("Invalid Make Move Out Of Turn")
    public void invalidMakeMoveOutOfTurn() {
        var game = new ChessGame();
        Assertions.assertThrows(InvalidMoveException.class,
                () -> game.makeMove(new ChessMove(new ChessPosition(7, 5), new ChessPosition(6, 5), null)));
    }

    @Test
    @DisplayName("Invalid Make Move Through Piece")
    public void invalidMakeMoveThroughPiece() {
        var game = new ChessGame();
        Assertions.assertThrows(InvalidMoveException.class,
                () -> game.makeMove(new ChessMove(new ChessPosition(1, 1), new ChessPosition(4, 1), null)));
    }

    @Test
    @DisplayName("Invalid Make Move No Piece")
    public void invalidMakeMoveNoPiece() {
        var game = new ChessGame();
        //starting position does not have a piece
        Assertions.assertThrows(InvalidMoveException.class,
                () -> game.makeMove(new ChessMove(new ChessPosition(4, 4), new ChessPosition(4, 5), null)));
    }

    @Test
    @DisplayName("Invalid Make Move Invalid Move")
    public void invalidMakeMoveInvalidMove() {
        var game = new ChessGame();
        //not a move the piece can ever take
        Assertions.assertThrows(InvalidMoveException.class,
                () -> game.makeMove(new ChessMove(new ChessPosition(8, 7), new ChessPosition(5, 5), null)));
    }

    @Test
    @DisplayName("Invalid Make Move Take Own Piece")
    public void invalidMakeMoveTakeOwnPiece() {
        var game = new ChessGame();
        Assertions.assertThrows(InvalidMoveException.class,
                () -> game.makeMove(new ChessMove(new ChessPosition(1, 3), new ChessPosition(2, 4), null)));
    }

    @Test
    @DisplayName("Invalid Make Move Captured Piece")
    public void invalidMakeMoveCapturedPiece() throws InvalidMoveException {
        var game = new ChessGame();
        game.setBoard(loadBoard("""
            |e| |m| |w|k|w| |m| |e|
            |r|l|p|g|v| |c|g|p|l|r|
            | |o|o|o|o| |o|o|o|o|o|
            |o| | | | | | | | | | |
            | | | | | | | | | | | |
            |O| | | | |R| | | | | |
            |P|O| | | | | | | | | |
            | | |O|O|O|O|O|O|O|O|O|
            | |L| |G|C|K|V|G|P|L|R|
            |E| |M| |W| |W| |M| |E|
            """));
        game.setTeamTurn(ChessGame.TeamColor.WHITE);
        game.makeMove(new ChessMove(new ChessPosition(4, 1), new ChessPosition(8, 5), null));
        Assertions.assertThrows(InvalidMoveException.class,
                () -> game.makeMove(new ChessMove(new ChessPosition(8, 5), new ChessPosition(7, 5), null)));
    }

    @Test
    @DisplayName("Invalid Make Move Jump Enemy")
    public void invalidMakeMoveJumpEnemy() {
        var game = new ChessGame();
        game.setBoard(loadBoard("""
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | |k| | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                |R| |r| | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | | | | | | | | |
                | | | | |K| | | | | | |
                """));
        Assertions.assertThrows(InvalidMoveException.class,
                () -> game.makeMove(new ChessMove(new ChessPosition(5, 1), new ChessPosition(5, 5), null)));
    }

    @Test
    @DisplayName("Invalid Make Move In Check")
    public void invalidMakeMoveInCheck() {
        var game = new ChessGame();
        game.setBoard(loadBoard("""
            |e| |m| |w|k|w| |m| |e|
            |r|l|p|g|v| |c|g|p|l|r|
            | |o|o|o| | |o|o|o|o|o|
            |o| | | |o| | | | | | |
            | | | | | | | | | | | |
            |O| | | | |R| | | | | |
            |P|O| | | | | | | | | |
            | | |O|O|O|O|O|O|O|O|O|
            | |L| |G|C|K|V|G|P|L|R|
            |E| |M| |W| |W| |M| |E|
            """));
        //try to make an otherwise valid move that doesn't remove check
        Assertions.assertThrows(InvalidMoveException.class,
                () -> game.makeMove(new ChessMove(new ChessPosition(7, 1), new ChessPosition(6, 1), null)));
    }
}
