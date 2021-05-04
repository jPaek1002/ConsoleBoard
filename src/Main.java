

public class Main {

	public static void main(String[] args) {
		
		//instantiate 8 by 8 Board
		Board board = new Board(8,8);
		
		//print raw string of the Board
		System.out.println(board);
		
		//print formatted Board
		System.out.println(board.spaceString());
		
		//print formatted Board with labels
		System.out.println(board.labeledString());
		
		//set values for Board
		board.set(1, 2, '3');
		board.set(2, 2, 'b');
		board.set(7, 7, 'A');
		
		//print Board again
		System.out.println(board.spaceString());
		System.out.println(board.labeledString());
		
		//set Board to a new Board with predetermined values
		String b = "abcd\n"
				+ "1234\n"
				+ "abcd\n"
				+ "1234\n";
		//then print the String
		System.out.println("Entered	 string:");
		System.out.println(b);
		
		//instantiate the board with String b
		board = new Board(b);
		//then print the board
		System.out.println("Board string:");
		System.out.println(board);


		//print board again
		System.out.println(board.spaceString());
		System.out.println(board.labeledString());
	}

}
