import java.util.*;

public class Queen extends Piece {
    public Queen(Color c) { super(c); }

    @Override
    public String toString() {
        return (color() == Color.WHITE ? "w" : "b") + "q";
    }

    @Override
    public List<String> moves(Board b, String loc) {
        List<String> moves = new ArrayList<>();
        // any number of steps in any direction)
        linearMoves(b, loc, moves, 1, 0);
        linearMoves(b, loc, moves, -1, 0);
        linearMoves(b, loc, moves, 0, 1);
        linearMoves(b, loc, moves, 0, -1);
        linearMoves(b, loc, moves, 1, 1);
        linearMoves(b, loc, moves, -1, -1);
        linearMoves(b, loc, moves, 1, -1);
        linearMoves(b, loc, moves, -1, 1);
        return moves;
    }
}