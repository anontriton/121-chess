import java.util.*;

public class King extends Piece {
    public King(Color c) { super(c); }

    @Override
    public String toString() {
        return (color() == Color.WHITE ? "w" : "b") + "k";
    }

    @Override
    public List<String> moves(Board b, String loc) {
        List<String> moves = new ArrayList<>();
        // one step in any direction
        int[] directions = {-1, 0, 1};
        for (int rdelta : directions) {
            for (int cdelta : directions) {
                if (rdelta == 0 && cdelta == 0) continue;
                int[] newPos = adjustPos(loc, rdelta, cdelta);
                if (newPos != null) {
                    String newLoc = posToString(newPos);
                    Piece target = b.getPiece(newLoc);
                    if (target == null || target.color() != color()) { moves.add(newLoc); }
                }
            }
        }

        return moves;
    }

    private String posToString(int[] pos) {
        return (char) ('a' + pos[1]) + Integer.toString(pos[0] + 1);
    }
}