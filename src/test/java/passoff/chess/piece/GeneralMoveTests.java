package passoff.chess.piece;

import chess.ChessPosition;
import org.junit.jupiter.api.Test;

import static passoff.chess.TestUtilities.validateMoves;

public class GeneralMoveTests {

    @Test
    public void generalMoveUntilEdge() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | |C| | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(3, 6),
                new int[][]{{4, 7}, {2, 7}, {2, 5}, {4, 5}}
        );
    }


    @Test
    public void generalCaptureEnemy() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | |k|c| | | | | |
                        | | | | |m|C|L| | | | |
                        | | | | |L|o|l| | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(3, 6),
                new int[][]{{4, 5}, {4, 7}, {2,7}}
        );
    }


    @Test
    public void generalBlocked() {
        validateMoves("""
                        | | | | | | | | | |r|c|
                        | | | | | | | | | |o|o|
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(10, 11),
                new int[][]{}
        );
    }

}
