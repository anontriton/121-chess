import java.util.*;

public class Knight extends Piece {
    public Knight(Color c) { super(c); }

    @Override
    public String toString() {
        return (color() == Color.WHITE ? "w" : "b") + "n";
    }

    @Override
    public List<String> moves(Board b, String loc) {
        List<String> moves = new ArrayList<>();
        // moves in L-shape
        int[][] deltas = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
        for (int[] d : deltas) {
            int[] newPos = adjustPos(loc, d[0], d[1]);
            if (newPos != null) {
                String newLoc = posToString(newPos);
                Piece target = b.getPiece(newLoc);
                if (target == null || target.color() != color()) {
                    moves.add(newLoc);
                }
            }
        }
        return moves;
    }

    private String posToString(int[] pos) {
        return (char) ('a' + pos[1]) + Integer.toString(pos[0] + 1);
    }
}