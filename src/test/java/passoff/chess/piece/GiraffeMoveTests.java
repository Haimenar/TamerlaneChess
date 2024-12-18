package passoff.chess.piece;

import chess.ChessPosition;
import org.junit.jupiter.api.Test;

import static passoff.chess.TestUtilities.validateMoves;

public class GiraffeMoveTests {

    @Test
    public void giraffeMoveUntilEdge() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | |G| | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(6, 6),
                new int[][]{
                        {10, 5}, {10, 7},
                        {7, 10}, {7, 11},
                        {5,10}, {5, 11},
                        {2, 7}, {1, 7}, {2, 5}, {1, 5},
                        {5, 2}, {5, 1}, {7, 2}, {7, 1}
                }
        );
    }


    @Test
    public void giraffeCaptureEnemy() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | |O| |o| | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | |O| | | | | |M| |
                        | | | | | |g| | | | | |
                        """,
                new ChessPosition(1, 6),
                new int[][]{
                        {2, 10},
                        {5, 7},
                        {5, 5}, {6, 5}
                }
        );
    }

    @Test
    public void giraffeLongCapture() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | |L| | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        |l| | | | | | | | | | |
                        | | | | | | | | | |P|P|
                        | |g|O| | | | | | | | |
                        | | | | | | | | | | |O|
                        """,
                new ChessPosition(2, 2),
                new int[][]{
                        {6, 3}, {7, 3}, {8, 3}, {9, 3},
                        {3, 6}, {3, 7}, {3, 8}, {3, 9}, {3, 10},
                        {1, 6}, {1, 7}, {1, 8}, {1, 9}, {1, 10}, {1, 11}
                }
        );
    }


    @Test
    public void giraffeBlockedCorners() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | |o| |o| | | | |
                        | | | | | |G| | | | | |
                        | | | | |o| |o| | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(6, 6),
                new int[][]{}
        );
    }

    @Test
    public void giraffeBlockedAdjacent() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | |k| |o| | | | | |
                        | | | | | |G|o| | | | |
                        | | | |p| |o| | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(6, 6),
                new int[][]{
                        {10, 5}, {2, 5}, {1, 5}
                }
        );
    }

    @Test
    public void giraffeFullyBlockedAdjacent() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | |o| | | | | |
                        | | | | |o|G|o| | | | |
                        | | | | | |o| | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(6, 6),
                new int[][]{}
        );
    }


}
