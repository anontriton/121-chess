import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Chess {
    public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java Chess layout moves");
		}
		Piece.registerPiece(new KingFactory());
		Piece.registerPiece(new QueenFactory());
		Piece.registerPiece(new KnightFactory());
		Piece.registerPiece(new BishopFactory());
		Piece.registerPiece(new RookFactory());
		Piece.registerPiece(new PawnFactory());
		Board.theBoard().registerListener(new Logger());
		// args[0] is the layout file name
		// args[1] is the moves file name
		// Put your code to read the layout file and moves files
		// here.

		try {
			List<String> layout = readFile(args[0]);
			List<String> moves = readFile(args[1]);

			processLayout(layout);
			processMoves(moves);

		} catch (IOException e) {
			e.printStackTrace(); // TODO: add more robust logging
		} catch (IllegalArgumentException e) {
			System.err.println("error in file: " + e.getMessage());
		}

		// Leave the following code at the end of the simulation:
		System.out.println("Final board:");
		Board.theBoard().iterate(new BoardPrinter());
    }

	private static List<String> readFile(String fileName) throws IOException {
		return Files.readAllLines(Paths.get(fileName));
	}

	public static void processLayout(List<String> lines) {
		Board b = Board.theBoard();
		b.clear();

		Set<String> occupiedPos = new HashSet<>();

		for (String line : lines) {
			if (line.startsWith("#")) continue;
			if (!line.matches("[a-h][1-8]=[bw][kqnbpr]")) {
				throw new IllegalArgumentException("invalid layout format: " + line);
			}

			String[] parts = line.split("=");
			String position = parts[0];
			String pieceInfo = parts[1];

			if (!occupiedPos.add(position)) {
				throw new IllegalArgumentException("multiple pieces occupying space: " + position);
			}

            Piece p = Piece.createPiece(pieceInfo);
			b.addPiece(p, position);
		}
	}

	public static void processMoves(List<String> lines) {
		Board b = Board.theBoard();

		for (String line : lines) {
			if (line.startsWith("#")) continue;
			if (!line.matches("[a-h][1-8]-[a-h][1-8]")) {
				throw new IllegalArgumentException("invalid move format: " + line);
			}

			String[] parts = line.split("-");
			String from = parts[0];
			String to = parts[1];

			b.movePiece(from, to);
		}
	}
}

