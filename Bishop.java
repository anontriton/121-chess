import java.util.*;

public class Bishop extends Piece {
    public Bishop(Color c) { super(c); }

    @Override
    public String toString() {
        return (color() == Color.WHITE ? "w" : "b") + "b";
    }

    @Override
    public List<String> moves(Board b, String loc) {
        List<String> moves = new ArrayList<>();
        // any number of steps diagonally
        linearMoves(b, loc, moves, 1, 1);
        linearMoves(b, loc, moves, -1, -1);
        linearMoves(b, loc, moves, 1, -1);
        linearMoves(b, loc, moves, -1, 1);
        return moves;
    }
}