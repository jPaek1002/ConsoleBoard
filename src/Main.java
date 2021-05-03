

public class Main {

	public static void main(String[] args) {
		Board board = new Board(8,8);
		System.out.println(board);
		System.out.println(board.spaceString());
		System.out.println(board.labeledString());
		board.set(1, 2, '3');
		board.set(2, 2, 'b');
		board.set(7, 7, 'A');
		System.out.println(board.spaceString());
		System.out.println(board.labeledString());
	}

}
