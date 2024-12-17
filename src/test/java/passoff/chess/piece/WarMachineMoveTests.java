package passoff.chess.piece;

import chess.ChessPosition;
import org.junit.jupiter.api.Test;

import static passoff.chess.TestUtilities.validateMoves;

public class WarMachineMoveTests {

    @Test
    public void warMachineMoveUntilEdge() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | |w| | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(7, 5),
                new int[][]{{9, 5}, {5, 5}, {7, 3}, {7, 7}}
        );
    }


    @Test
    public void warMachineCaptureEnemy() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | |o| | | | | | | |
                        | | | |P| | | | | | | |
                        | |O| |W|l|l| | | | | |
                        | | | | | | | | | | | |
                        | | | |p| | | | | | | |
                        """,
                new ChessPosition(3, 4),
                new int[][]{{5, 4}, {3, 6}, {1, 4}}
        );
    }


    @Test
    public void warMachineBlocked() {
        validateMoves("""
                        | | | | | | | | |r| |w|
                        | | | | | | | | | | | |
                        | | | | | | | | | | |o|
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
