package passoff.chess.piece;

import chess.ChessPosition;
import org.junit.jupiter.api.Test;

import static passoff.chess.TestUtilities.validateMoves;

public class CamelMoveTests {

    @Test
    public void camelMiddleOfBoard() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | |M| | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(5, 5),
                new int[][]{
                        {8, 6}, {6, 8}, {4, 8}, {2, 6}, {2, 4}, {4, 2}, {6, 2}, {8, 4},
                }
        );
    }


    @Test
    public void camelEdgeOfBoard() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        |M| | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(4, 1),
                new int[][]{{1, 2}, {7, 2}, {3, 4}, {5, 4}}
        );
    }

    @Test
    public void camelCaptureEnemy() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | |V| | | | |
                        | | | | | | | | | | | |
                        | | | | | | | |O| | | |
                        | | | | |m| | | | | | |
                        | |o| | | | | |O| | | |
                        | | | | | | | | | | | |
                        | | | |K| |L| | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(5, 5),
                new int[][]{
                        {8, 6}, {6, 8}, {4, 8}, {2, 6}, {2, 4}, {6, 2}, {8, 4},
                }
        );
    }

    @Test
    public void camelBlocked() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | |k| |l| | | | | |
                        | | | | | | | | | | | |
                        | |v| | | | | |l| | | |
                        | | | | |m| | | | | | |
                        | |v| | | | | |r| | | |
                        | | | | | | | | | | | |
                        | | | |m| |o| | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(5, 5),
                new int[][]{}
        );
    }

}