
public class Board {

	private String board;
	private int width;
	private int height;
	
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		board = "";
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				board+="0";
			}
			board += "\n";
		}
	}
	
	public Board(String board) {
		this.board = board;
		
	}
	
	@Override
	public String toString() {
		return board;
	}
	
	public String spaceString() {
		String s = "";
		for(int i = 0; i < height; i++) {
			for(int j = 0; j <= width; j++) {
				char c = board.charAt((i * (width + 1)) + j);
				s += c; 
				if(c != '\n') {
					s += " ";
				}
			}
		}
		return s;
	}
	
	public void set(int x, int y, char c) {
		
	}
}
