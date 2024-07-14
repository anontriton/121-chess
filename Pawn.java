import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color c) { super(c); }

    @Override
    public String toString() {
        return (color() == Color.WHITE ? "w" : "b") + "p";
    }

    @Override
    public List<String> moves(Board b, String loc) {
        List<String> moves = new ArrayList<>();
        int dir = (color() == Color.WHITE) ? 1 : -1;
        int startRow = (color() == Color.WHITE) ? 1 : 6;

        // move forward one step
        pawnMove(b, loc, moves, dir, 0);
        if (loc.charAt(1) - '1' == startRow) {
            pawnMove(b, loc, moves, 2 * dir, 0);
        }

        // capture diagonally
        pawnCapture(b, loc, moves, dir, 1);
        pawnCapture(b, loc, moves, dir, -1);

        return moves;
    }

    private void pawnMove(Board b, String loc, List<String> moves, int rdelta, int cdelta) {
        int[] newPos = adjustPos(loc, rdelta, cdelta);
        if (newPos != null) {
            String newLoc = positionToString(newPos);
            if (b.getPiece(newLoc) == null) { moves.add(newLoc); }
        }
    }

    private void pawnCapture(Board b, String loc, List<String> moves, int rdelta, int cdelta) {
        int[] newPos = adjustPos(loc, rdelta, cdelta);
        if (newPos != null) {
            String newLoc = positionToString(newPos);
            Piece target = b.getPiece(newLoc);
            if (target != null && target.color() != color()) { moves.add(newLoc); }
        }
    }

    private String positionToString(int[] pos) {
        return (char) ('a' + pos[1]) + Integer.toString(pos[0] + 1);
    }
}