package passoff.chess.piece;

import chess.ChessPosition;
import org.junit.jupiter.api.Test;

import static passoff.chess.TestUtilities.validateMoves;

public class ElephantMoveTests {

    @Test
    public void elephantMoveUntilEdge() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | |E| | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(3, 9),
                new int[][]{{1, 11}, {1, 7}, {5, 7}, {5, 11}}
        );
    }


    @Test
    public void elephantCaptureEnemy() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | |L| | | |m| | | | |
                        | | | |P| | | | | | | |
                        | | | | |e| | | | | | |
                        | | | | | |p| | | | | |
                        | | |O| | | |K| | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(6, 5),
                new int[][]{{4, 3}, {4, 7}, {8, 3}}
        );
    }


    @Test
    public void elephantBlocked() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | |o| | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | |e|
                        """,
                new ChessPosition(1, 11),
                new int[][]{}
        );
    }

}
