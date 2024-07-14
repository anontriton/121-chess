import java.util.*;

public class Board {

    private Piece[][] pieces = new Piece[8][8];
    private List<BoardListener> listeners = new ArrayList<>();
    private static Board instance = new Board(); // ensures one instance of "board" exists

    private Board() { }
    
    public static Board theBoard() { return instance; } // singleton pattern

    // Returns piece at given loc or null if no such piece exists
    public Piece getPiece(String loc) {
        int[] coords = convertLoc(loc);
        return pieces[coords[0]][coords[1]];
    }

    public void addPiece(Piece p, String loc) {
        int[] coords = convertLoc(loc);
        if (pieces[coords[0]][coords[1]] != null) {
            throw new IllegalArgumentException("location already occupied");
        }
        pieces[coords[0]][coords[1]] = p;
    }

    public void movePiece(String from, String to) {
        int[] fromCoords = convertLoc(from);
        int[] toCoords = convertLoc(to);
        Piece piece = pieces[fromCoords[0]][fromCoords[1]];
        if (piece == null) {
            throw new IllegalArgumentException("no piece at " + from);
        }

        List<String> validMoves = piece.moves(this, from);
        if (!validMoves.contains(to)) {
            throw new IllegalArgumentException("invalid move");
        }

        Piece captured = pieces[toCoords[0]][toCoords[1]];
        if (captured != null) {
            for (BoardListener listener : listeners) {
                listener.onCapture(piece, captured);
            }
        }

        pieces[toCoords[0]][toCoords[1]] = piece;
        pieces[fromCoords[0]][fromCoords[1]] = null;

        for (BoardListener listener : listeners) {
            listener.onMove(from, to, piece);
        }
    }

    public void clear() {
	    pieces = new Piece[8][8];
    }

    public void registerListener(BoardListener bl) {
        listeners.add(bl);
    }

    public void removeListener(BoardListener bl) {
        listeners.remove(bl);
    }

    public void removeAllListeners() {
        listeners.clear();
    }

    public void iterate(BoardInternalIterator bi) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                String loc = (char) ('a' + col) + Integer.toString(row + 1);
                bi.visit(loc, pieces[row][col]);
            }
        }
    }

    // helper method to convert location string type to row and col indices
    private int[] convertLoc(String loc) {
        int col = loc.charAt(0) - 'a';
        int row = loc.charAt(1) - '1';

        if (row < 0 || col < 0 || row >= 8 || col >= 8) {
            throw new IllegalArgumentException("invalid location: " + loc);
        }

        return new int[]{row, col};
    }
}