import java.util.*;

public class Rook extends Piece {
    public Rook(Color c) { super(c); }

    @Override
    public String toString() {
        return (color() == Color.WHITE ? "w" : "b") + "r";
    }

    @Override
    public List<String> moves(Board b, String loc) {
        List<String> moves = new ArrayList<>();
        // move any number of steps vertically or horizontally
        linearMoves(b, loc, moves, 1, 0);
        linearMoves(b, loc, moves, -1, 0);
        linearMoves(b, loc, moves, 0, 1);
        linearMoves(b, loc, moves, 0, -1);
        return moves;
    }
}