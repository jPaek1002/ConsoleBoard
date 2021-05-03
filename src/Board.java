
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
		for(int y = 0; y < height; y++) {
			for(int x = 0; x <= width; x++) {
				char c = board.charAt(getIndex(x,y));
				s += c; 
				if(c != '\n') {
					s += " ";
				}
			}
		}
		return s;
	}
	
	public String labeledString() {
		String s = "  ";
		for(int x = 0; x < width; x++) {
			s+=x;
			s+=" ";
		}
		s+='\n';
		for(int y = 0; y < height; y++) {
			s+=y;
			s+=" ";
			for(int x = 0; x <= width; x++) {
				char c = board.charAt(getIndex(x,y));
				s += c; 
				if(c != '\n') {
					s += " ";
				}
			}
		}
		return s;
	}
	
	public int getIndex(int x, int y) {
		return (y * (width + 1)) + x;
	}
	
	public void set(int x, int y, char c) {
		int i = getIndex(x,y);
		String s1 = board.substring(0,i);
		String s2 = board.substring(i+1);
		board = s1 + c + s2;
	}
	
}
