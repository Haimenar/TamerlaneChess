package passoff.chess.piece;

import chess.ChessPosition;
import org.junit.jupiter.api.Test;

import static passoff.chess.TestUtilities.validateMoves;

public class CounsellorMoveTests {

    @Test
    public void counsellorMoveUntilEdge() {
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
                new int[][]{{4, 6}, {3, 7}, {2, 6}, {3, 5}}
        );
    }


    @Test
    public void counsellorCaptureEnemy() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | |c| | | | | |
                        | | | | |m|C|L| | | | |
                        | | | | | |o| | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(3, 6),
                new int[][]{{4, 6}, {3, 5}, {2,6}}
        );
    }


    @Test
    public void counsellorBlocked() {
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
