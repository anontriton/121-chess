import java.util.*;

abstract public class Piece {
    private Color c;

    // stores mappings from pieces to their respective factory instances
    private static final Map<Character, PieceFactory> factories = new HashMap<>();

    public static void registerPiece(PieceFactory pf) {
        factories.put(pf.symbol(), pf);
    }

    public static Piece createPiece(String name) {
        Color color;

        char symbol = name.charAt(1);
        if (name.charAt(0) == 'b') { color = Color.BLACK; }
        else if (name.charAt(0) == 'w') { color = Color.WHITE; }
        else { throw new IllegalArgumentException("invalid color: " + symbol); }

        PieceFactory factory = factories.get(symbol);

        if (factory == null) {
            throw new IllegalArgumentException("invalid piece: " + symbol);
        }

        return factory.create(color);
    }

    // constructor
    public Piece(Color color) {
        this.c = color;
    }

    public Color color() {
        return c;
    }

    @Override
    abstract public String toString();

    abstract public List<String> moves(Board b, String loc);

    protected int[] adjustPos(String loc, int rdelta, int cdelta) {
        int row = loc.charAt(1) - '1';
        int col = loc.charAt(0) - 'a';

        int newRow = row + rdelta;
        int newCol = col + cdelta;

        if (newRow < 0 || newCol < 0 || newRow >= 8 || newCol >= 8) {
            return null;
        }

        return new int[]{newRow, newCol};
    }

    protected void linearMoves(Board b, String loc, List<String> moves, int rdelta, int cdelta) {
        int row = loc.charAt(1) - '1';
        int col = loc.charAt(0) - 'a';

        while (true) {
            row += rdelta;
            col += cdelta;

            if (row < 0 || col < 0 || row >= 8 || col >= 8) { break; }

            String newLoc = (char) ('a' + col) + Integer.toString(row + 1);
            Piece target = b.getPiece(newLoc);

            if (target == null) {
                moves.add(newLoc);
            } else {
                if (target.color() != color()) { moves.add(newLoc); }
                break;
            }
        }
    }
}