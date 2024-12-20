package passoff.chess.piece;

import chess.ChessPosition;
import org.junit.jupiter.api.Test;


import static passoff.chess.TestUtilities.*;

public class pawnOfPawnsMoveTests {

    @Test
    public void blackPawnEnd() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | |W| | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | |o| | | | | |
                        """,
                new ChessPosition(1, 6),
                new int[][]{}
        );
    }

    @Test
    public void whitePawnAttacks() {
        validateMoves("""
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | |w| |w| | | | |
                        | | | | | |O| | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(5, 6),
                new int[][]{{6, 5}, {6,6}, {6, 7}}
        );
    }

    @Test
    public void whitePawnEnd() {
        validateMoves("""
                        | | | | | |O| | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | |w| | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        | | | | | | | | | | | |
                        """,
                new ChessPosition(10, 6),
                new int[][]{}
        );
    }

    @Test
    public void blackPawnAttack() {
        validateMoves("""
                    | | | | | | | | | | | |
                    | | | | | | | | | | | |
                    | | | | | | | | | | | |
                    | | | | | | | | | | | |
                    | | | | | | | | | | | |
                    | | | | | | | | | | | |
                    | | | | | | | | | | | |
                    |G| | | | | | | | | |g|
                    | | | | | | | | | | | |
                    |W| |G| | |o| | |g| |w|
                    """,
                new ChessPosition(1, 6),
                new int[][]{{2,2}}
        );
    }

    @Test
    public void whitePawnAttack() {
        validateMoves("""
                    | | | | | |O| | | | |l|
                    | | | | | | | | |o| | |
                    | | | | | | | | | |o| |
                    | | | | | | | | | | | |
                    | | | | | | | | | | | |
                    | | | | | | | | | | | |
                    | | | | | | | | | | | |
                    | | | | | | | | | | | |
                    | | | | | | | | | | | |
                    | | | | | | | | | | | |
                    """,
                new ChessPosition(10, 6),
                new int[][]{{9,10}}
        );
    }
}
