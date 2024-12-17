package passoff.chess.piece;

import chess.ChessPosition;
import org.junit.jupiter.api.Test;

import static passoff.chess.TestUtilities.validateMoves;

public class PicketMoveTests {

    @Test
    public void picketMoveUntilEdge() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | |P| | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(3, 6),
                new int[][]{
                        {1, 8},
                        {1, 4},
                        {5, 8}, {6, 9}, {7, 10}, {8, 11},
                        {5, 4}, {6, 3}, {7, 2}, {8, 1}
                }
        );
    }


    @Test
    public void picketCaptureEnemy() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | |V| | | |
                        | | | | | | | | | | | |
                        | |C| | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | |p| | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        |O| | | | | |M| | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(5, 4),
                new int[][]{
                        {3,2}, {2, 1},
                        {7, 2},
                        {3, 6}, {2, 7},
                        {7, 6}, {8, 7}, {9, 8}
                }
        );
    }


    @Test
    public void picketBlocked() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | |r| | | |v| | | |
                        | | | | | | | | | | | |
                        | | | | | |p| | | | | |
                        | | | | | | |c| | | | |
                        | | | |m| | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(5, 6),
                new int[][]{}
        );
    }

}
