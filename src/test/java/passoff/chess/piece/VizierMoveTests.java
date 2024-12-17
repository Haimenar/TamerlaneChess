package passoff.chess.piece;

import chess.ChessPosition;
import org.junit.jupiter.api.Test;

import static passoff.chess.TestUtilities.validateMoves;

public class VizierMoveTests {

    @Test
    public void vizierMoveUntilEdge() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | |V| | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(3, 6),
                new int[][]{{4, 6}, {4, 7}, {3, 7}, {2, 7}, {2, 6}, {2, 5}, {3, 5}, {4, 5}}
        );
    }


    @Test
    public void vizierCaptureEnemy() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | |L|l| | | | | | |
                        | | | |v| | | | | | | |
                        | | |O|p|o| | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(3, 4),
                new int[][]{{4, 3}, {4, 4}, {3, 3}, {3,5}, {2,3}}
        );
    }


    @Test
    public void vizierBlocked() {
        validateMoves("""
                        | | | | | | | | | |r|v|
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
