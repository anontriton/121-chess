import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Test {
    public static void test1() {
		Board b = Board.theBoard();
		Piece.registerPiece(new PawnFactory());
		Piece p = Piece.createPiece("bp");
		b.addPiece(p, "a3");
		assert b.getPiece("a3") == p;
    }

	public static void test2() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new KingFactory());
		Piece p = Piece.createPiece("wk");
		b.addPiece(p, "e1");

		assert b.getPiece("e1") == p : "failed to add white king to e1";

		System.out.println("test2 passed");
	}

	public static void test3() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new QueenFactory());
		Piece p = Piece.createPiece("bq");
		b.addPiece(p, "d8");

		assert b.getPiece("d8") == p : "failed to add black queen to d8";

		System.out.println("test3 passed");
	}

	public static void test4() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new RookFactory());
		Piece p = Piece.createPiece("wr");
		b.addPiece(p, "a1");

		assert b.getPiece("a1") == p : "failed to add white rook to a1";

		System.out.println("test4 passed");
	}

	public static void test5() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new KnightFactory());
		Piece p = Piece.createPiece("bn");
		b.addPiece(p, "g8");

		assert b.getPiece("g8") == p : "failed to add black knight to g8";

		System.out.println("test5 passed");
	}

	public static void test6() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new BishopFactory());
		Piece p = Piece.createPiece("wb");
		b.addPiece(p, "c1");

		assert b.getPiece("c1") == p : "failed to add white bishop to c1";

		System.out.println("test6 passed");
	}

	public static void testMovePiece1() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new PawnFactory());
		Piece p = Piece.createPiece("wp");
		b.addPiece(p, "a2");
		b.movePiece("a2", "a3");

		assert b.getPiece("a2") == null : "failed to move white pawn from a2";
		assert b.getPiece("a3") == p : "failed to move white pawn to a3";

		System.out.println("testMovePiece1 passed");
	}

	public static void testMovePiece2() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new PawnFactory());
		Piece p = Piece.createPiece("wq");
		b.addPiece(p, "a2");
		b.movePiece("a2", "a8");

		assert b.getPiece("a2") == null : "failed to move white queen from a2";
		assert b.getPiece("a8") == p : "failed to move white queen to 8";

		System.out.println("testMovePiece2 passed");
	}

	public static void testMovePiece3() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new PawnFactory());
		Piece p = Piece.createPiece("bn");
		b.addPiece(p, "c1");
		b.movePiece("c1", "e2");

		assert b.getPiece("c1") == null : "failed to move black knight from c1";
		assert b.getPiece("e2") == p : "failed to move black knight to e2";

		System.out.println("testMovePiece3 passed");
	}

	public static void testMovePiece4() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new PawnFactory());
		Piece p = Piece.createPiece("wb");
		b.addPiece(p, "a1");
		b.movePiece("a1", "h8");

		assert b.getPiece("a1") == null : "failed to move white bishop from a1";
		assert b.getPiece("h8") == p : "failed to move white bishop to h8";

		System.out.println("testMovePiece4 passed");
	}

	public static void testInvalidMove1() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new PawnFactory());
		Piece p = Piece.createPiece("wp");
		b.addPiece(p, "a2");

		boolean exceptionThrown = false;
		try {
			b.movePiece("a2", "a5");
		} catch (IllegalArgumentException e) {
			exceptionThrown = true;
		}

		assert exceptionThrown : "failed to throw exception for invalid move";

		System.out.println("testInvalidMove1 passed");
	}

	public static void testInvalidMove2() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new PawnFactory());
		Piece p = Piece.createPiece("wp");
		b.addPiece(p, "b2");

		boolean exceptionThrown = false;
		try {
			b.movePiece("b2", "c4");
		} catch (IllegalArgumentException e) {
			exceptionThrown = true;
		}

		assert exceptionThrown : "failed to throw exception for invalid move";

		System.out.println("testInvalidMove2 passed");
	}

	public static void testInvalidMove3() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new PawnFactory());
		Piece p = Piece.createPiece("wp");
		b.addPiece(p, "b2");

		boolean exceptionThrown = false;
		try {
			b.movePiece("b2", "c4");
		} catch (IllegalArgumentException e) {
			exceptionThrown = true;
		}

		assert exceptionThrown : "failed to throw exception for invalid move";

		System.out.println("testInvalidMove3 passed");
	}

	public static void testInvalidMove4() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new PawnFactory());
		Piece p = Piece.createPiece("wp");
		b.addPiece(p, "b2");

		boolean exceptionThrown = false;
		try {
			b.movePiece("b2", "c4");
		} catch (IllegalArgumentException e) {
			exceptionThrown = true;
		}

		assert exceptionThrown : "failed to throw exception for invalid move";

		System.out.println("testInvalidMove4 passed");
	}

	public static void testInvalidMove5() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new PawnFactory());
		Piece p = Piece.createPiece("wp");
		b.addPiece(p, "b2");

		boolean exceptionThrown = false;
		try {
			b.movePiece("b2", "c4");
		} catch (IllegalArgumentException e) {
			exceptionThrown = true;
		}

		assert exceptionThrown : "failed to throw exception for invalid move";

		System.out.println("testInvalidMove5 passed");
	}

	public static void testCapturePiece1() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new PawnFactory());
		Piece p1 = Piece.createPiece("wp");
		Piece p2 = Piece.createPiece("bp");
		b.addPiece(p1, "a2");
		b.addPiece(p2, "b3");
		b.movePiece("a2", "b3");  // white pawn captures black pawn

		assert b.getPiece("a2") == null : "Failed to move white pawn from a2";
		assert b.getPiece("b3") == p1 : "Failed to capture black pawn on b3";

		System.out.println("testCapturePiece1 passed");
	}

	public static void testCapturePiece2() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new PawnFactory());
		Piece p1 = Piece.createPiece("wr");
		Piece p2 = Piece.createPiece("bb");
		b.addPiece(p1, "h4");
		b.addPiece(p2, "h7");
		b.movePiece("h4", "h7");  // white rook captures black bishop

		assert b.getPiece("h4") == null : "Failed to move white rook from h4";
		assert b.getPiece("h7") == p1 : "Failed to capture black bishop on h7";

		System.out.println("testCapturePiece2 passed");
	}

	public static void testCapturePiece3() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new PawnFactory());
		Piece p1 = Piece.createPiece("bk");
		Piece p2 = Piece.createPiece("wp");
		b.addPiece(p1, "e8");
		b.addPiece(p2, "e7");
		b.movePiece("e8", "e7");  // white pawn captures black pawn

		assert b.getPiece("e8") == null : "Failed to move black king from e8";
		assert b.getPiece("e7") == p1 : "Failed to capture white pawn on e7";

		System.out.println("testCapturePiece3 passed");
	}

	public static void testInvalidCapture1() {
		Board b = Board.theBoard();
		b.clear();

		Piece.registerPiece(new PawnFactory());
		Piece p1 = Piece.createPiece("wp");
		Piece p2 = Piece.createPiece("bp");
		b.addPiece(p1, "d2");
		b.addPiece(p2, "d3");

		boolean exceptionThrown = false;
		try {
			b.movePiece("d2", "d3");
		} catch (IllegalArgumentException e) {
			exceptionThrown = true;
		}

		assert exceptionThrown : "failed to throw exception for invalid capture";

		System.out.println("testInvalidCapture1 passed");
	}

	public static void testLayoutFile() {
		try {
			List<String> layout = Files.readAllLines(Paths.get("layout1"));

			Chess.processLayout(layout);

			Board b = Board.theBoard();

			assert b.getPiece("a1").toString().equals("wr") : "Failed to load white rook at a1";
			assert b.getPiece("e1").toString().equals("wk") : "Failed to load white king at e1";
			assert b.getPiece("d8").toString().equals("bq") : "Failed to load black queen at d8";
			assert b.getPiece("h8").toString().equals("br") : "Failed to load black rook at h8";
			assert b.getPiece("a2").toString().equals("wp") : "Failed to load white pawn at a2";
			assert b.getPiece("a7").toString().equals("bp") : "Failed to load black pawn at a7";

			System.out.println("testLayoutFile passed");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void testMovesFile() {
		try {
			List<String> layout = Files.readAllLines(Paths.get("layout1"));
			List<String> moves = Files.readAllLines(Paths.get("moves1"));

			Chess.processLayout(layout);
			Chess.processMoves(moves);

			Board b = Board.theBoard();

			assert b.getPiece("e4").toString().equals("wp") : "Failed to move white pawn to e4";
			assert b.getPiece("e5").toString().equals("bp") : "Failed to move black pawn to e5";
			assert b.getPiece("f3").toString().equals("wn") : "Failed to move white knight to f3";
			assert b.getPiece("e2") == null : "Failed to remove white pawn from e2";
			assert b.getPiece("e7") == null : "Failed to remove black pawn from e7";
			assert b.getPiece("g1") == null : "Failed to remove white knight from g1";

			System.out.println("testMovesFile passed");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();

		testMovePiece1();
		testMovePiece2();
		testMovePiece3();
		testMovePiece4();

		testInvalidMove1();
		testInvalidMove2();
		testInvalidMove3();
		testInvalidMove4();
		testInvalidMove5();

		testCapturePiece1();
		testCapturePiece2();
		testCapturePiece3();

		testInvalidCapture1();

		testLayoutFile();
		testMovesFile();

		System.out.println("*** all tests passed! ***");
	}

}