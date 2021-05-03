

public class Main {

	public static void main(String[] args) {
		Board board = new Board(3,4);
		System.out.println(board);
		System.out.println(board.spaceString());
		System.out.println(board.labeledString());
		board.set(1, 2, '3');
		System.out.println(board.spaceString());

	}

}
