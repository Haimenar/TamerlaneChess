package passoff.chess.game;

import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;
import chess.InvalidMoveException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FullGameTest {
    @Test
    @DisplayName("Full Game Checkmate")
    public void quickCheckMate() throws InvalidMoveException {
        var game = new ChessGame();
        game.makeMove(new ChessMove(new ChessPosition(3, 1), new ChessPosition(4, 1), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v|k|c|g|p|l|r|
        |o|o|o|o|o|o|o|o|o|o|o|
        | | | | | | | | | | | |
        | | | | | | | | | | | |
        | | | | | | | | | | | |
        |O| | | | | | | | | | |
        | |O|O|O|O|O|O|O|O|O|O|
        |R|L|P|G|C|K|V|G|P|L|R|
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(8, 6), new ChessPosition(7, 6), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v|k|c|g|p|l|r|
        |o|o|o|o|o| |o|o|o|o|o|
        | | | | | |o| | | | | |
        | | | | | | | | | | | |
        | | | | | | | | | | | |
        |O| | | | | | | | | | |
        | |O|O|O|O|O|O|O|O|O|O|
        |R|L|P|G|C|K|V|G|P|L|R|
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(4, 1), new ChessPosition(5, 1), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v|k|c|g|p|l|r|
        |o|o|o|o|o| |o|o|o|o|o|
        | | | | | |o| | | | | |
        | | | | | | | | | | | |
        |O| | | | | | | | | | |
        | | | | | | | | | | | |
        | |O|O|O|O|O|O|O|O|O|O|
        |R|L|P|G|C|K|V|G|P|L|R|
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(7, 6), new ChessPosition(6, 6), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v|k|c|g|p|l|r|
        |o|o|o|o|o| |o|o|o|o|o|
        | | | | | | | | | | | |
        | | | | | |o| | | | | |
        |O| | | | | | | | | | |
        | | | | | | | | | | | |
        | |O|O|O|O|O|O|O|O|O|O|
        |R|L|P|G|C|K|V|G|P|L|R|
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(2, 1), new ChessPosition(4, 1), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v|k|c|g|p|l|r|
        |o|o|o|o|o| |o|o|o|o|o|
        | | | | | | | | | | | |
        | | | | | |o| | | | | |
        |O| | | | | | | | | | |
        |R| | | | | | | | | | |
        | |O|O|O|O|O|O|O|O|O|O|
        | |L|P|G|C|K|V|G|P|L|R|
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(6, 6), new ChessPosition(5, 6), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v|k|c|g|p|l|r|
        |o|o|o|o|o| |o|o|o|o|o|
        | | | | | | | | | | | |
        | | | | | | | | | | | |
        |O| | | | |o| | | | | |
        |R| | | | | | | | | | |
        | |O|O|O|O|O|O|O|O|O|O|
        | |L|P|G|C|K|V|G|P|L|R|
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(4, 1), new ChessPosition(4, 2), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v|k|c|g|p|l|r|
        |o|o|o|o|o| |o|o|o|o|o|
        | | | | | | | | | | | |
        | | | | | | | | | | | |
        |O| | | | |o| | | | | |
        | |R| | | | | | | | | |
        | |O|O|O|O|O|O|O|O|O|O|
        | |L|P|G|C|K|V|G|P|L|R|
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(9, 6), new ChessPosition(8, 6), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v| |c|g|p|l|r|
        |o|o|o|o|o|k|o|o|o|o|o|
        | | | | | | | | | | | |
        | | | | | | | | | | | |
        |O| | | | |o| | | | | |
        | |R| | | | | | | | | |
        | |O|O|O|O|O|O|O|O|O|O|
        | |L|P|G|C|K|V|G|P|L|R|
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(3, 11), new ChessPosition(4, 11), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v| |c|g|p|l|r|
        |o|o|o|o|o|k|o|o|o|o|o|
        | | | | | | | | | | | |
        | | | | | | | | | | | |
        |O| | | | |o| | | | | |
        | |R| | | | | | | | |O|
        | |O|O|O|O|O|O|O|O|O| |
        | |L|P|G|C|K|V|G|P|L|R|
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(8, 6), new ChessPosition(7, 6), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v| |c|g|p|l|r|
        |o|o|o|o|o| |o|o|o|o|o|
        | | | | | |k| | | | | |
        | | | | | | | | | | | |
        |O| | | | |o| | | | | |
        | |R| | | | | | | | |O|
        | |O|O|O|O|O|O|O|O|O| |
        | |L|P|G|C|K|V|G|P|L|R|
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(4, 11), new ChessPosition(5, 11), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v| |c|g|p|l|r|
        |o|o|o|o|o| |o|o|o|o|o|
        | | | | | |k| | | | | |
        | | | | | | | | | | | |
        |O| | | | |o| | | | |O|
        | |R| | | | | | | | | |
        | |O|O|O|O|O|O|O|O|O| |
        | |L|P|G|C|K|V|G|P|L|R|
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(7, 6), new ChessPosition(6, 6), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v| |c|g|p|l|r|
        |o|o|o|o|o| |o|o|o|o|o|
        | | | | | | | | | | | |
        | | | | | |k| | | | | |
        |O| | | | |o| | | | |O|
        | |R| | | | | | | | | |
        | |O|O|O|O|O|O|O|O|O| |
        | |L|P|G|C|K|V|G|P|L|R|
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(2, 11), new ChessPosition(4, 11), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v| |c|g|p|l|r|
        |o|o|o|o|o| |o|o|o|o|o|
        | | | | | | | | | | | |
        | | | | | |k| | | | | |
        |O| | | | |o| | | | |O|
        | |R| | | | | | | | |R|
        | |O|O|O|O|O|O|O|O|O| |
        | |L|P|G|C|K|V|G|P|L| |
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(6, 6), new ChessPosition(5, 7), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v| |c|g|p|l|r|
        |o|o|o|o|o| |o|o|o|o|o|
        | | | | | | | | | | | |
        | | | | | | | | | | | |
        |O| | | | |o|k| | | |O|
        | |R| | | | | | | | |R|
        | |O|O|O|O|O|O|O|O|O| |
        | |L|P|G|C|K|V|G|P|L| |
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(4, 11), new ChessPosition(4, 10), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v| |c|g|p|l|r|
        |o|o|o|o|o| |o|o|o|o|o|
        | | | | | | | | | | | |
        | | | | | | | | | | | |
        |O| | | | |o|k| | | |O|
        | |R| | | | | | | |R| |
        | |O|O|O|O|O|O|O|O|O| |
        | |L|P|G|C|K|V|G|P|L| |
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(8, 1), new ChessPosition(7, 1), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v| |c|g|p|l|r|
        | |o|o|o|o| |o|o|o|o|o|
        |o| | | | | | | | | | |
        | | | | | | | | | | | |
        |O| | | | |o|k| | | |O|
        | |R| | | | | | | |R| |
        | |O|O|O|O|O|O|O|O|O| |
        | |L|P|G|C|K|V|G|P|L| |
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(4, 2), new ChessPosition(6, 2), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v| |c|g|p|l|r|
        | |o|o|o|o| |o|o|o|o|o|
        |o| | | | | | | | | | |
        | |R| | | | | | | | | |
        |O| | | | |o|k| | | |O|
        | | | | | | | | | |R| |
        | |O|O|O|O|O|O|O|O|O| |
        | |L|P|G|C|K|V|G|P|L| |
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(7, 1), new ChessPosition(6, 1), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v| |c|g|p|l|r|
        | |o|o|o|o| |o|o|o|o|o|
        | | | | | | | | | | | |
        |o|R| | | | | | | | | |
        |O| | | | |o|k| | | |O|
        | | | | | | | | | |R| |
        | |O|O|O|O|O|O|O|O|O| |
        | |L|P|G|C|K|V|G|P|L| |
        |E| |M| |W| |W| |M| |E|
         */
        game.makeMove(new ChessMove(new ChessPosition(4, 10), new ChessPosition(5, 10), null));
        /*
        |e| |m| |w| |w| |m| |e|
        |r|l|p|g|v| |c|g|p|l|r|
        | |o|o|o|o| |o|o|o|o|o|
        | | | | | | | | | | | |
        |o|R| | | | | | | | | |
        |O| | | | |o|k| | |R|O|
        | | | | | | | | | | | |
        | |O|O|O|O|O|O|O|O|O| |
        | |L|P|G|C|K|V|G|P|L| |
        |E| |M| |W| |W| |M| |E|
         */
        Assertions.assertTrue(game.isInCheck(ChessGame.TeamColor.BLACK),
                "Black is in check but isInCheck returned false");
        Assertions.assertFalse(game.isInCheck(ChessGame.TeamColor.WHITE),
                "White is not in check but isInCheck returned true");
        Assertions.assertTrue(game.isInCheckmate(ChessGame.TeamColor.BLACK),
                "Black is in checkmate but isInCheckmate returned false");
        Assertions.assertFalse(game.isInCheckmate(ChessGame.TeamColor.WHITE),
                "White is not in checkmate but isInCheckmate returned true");
        Assertions.assertFalse(game.isInStalemate(ChessGame.TeamColor.BLACK),
                "Black is not in stalemate but isInStalemate returned true");
        Assertions.assertFalse(game.isInStalemate(ChessGame.TeamColor.WHITE),
                "White is not in stalemate but isInStalemate returned true");
    }
}
