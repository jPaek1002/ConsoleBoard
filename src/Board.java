/*
 * Author: Jay Paek, Claire Chen, Eddie Li
 * Version: 1.0
 * Date: May 03, 2021
 * This is a 2 dimensional board based on a String
 * \n represents a line break > after line break is a new row
 * not very friendly with boards with 10+ rows
 * but you can still do it.
 * THIS CLASS IS IMMUTABLE (subject to change)
 */
public class Board {

	//Fields
	private String board;
	public int width;
	public int height;
	
	//Constructors
	
	//instantiate an empty board with given width and height
	public Board(int width, int height) {
		
		//set width and height of Board
		this.width = width;
		this.height = height;
		
		//instantiate board
		board = "";
		
		//set all elements of board to 0
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				board+="0";
			}
			board += "\n";
		}
	}
	
	//instantiate board straight from a text file
	//automatically sets the width and height
	public Board(String board) {
		//set the input string as the board
		this.board = board;
		
		//set the width and height
		width = board.indexOf('\n');
		height = board.length()/width-1;
	}
	//Constructors
	
	//method to get index of board element at specified position (x,y)
	public int getIndex(int x, int y) {
		return (y * (width + 1)) + x;
	}
		
	//return raw string
	@Override
	public String toString() {
		return board;
	}
	
	//returns the board formatted with spaces
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
	
	//returns the board formatted with spaces and x, y coordinate labels
	public String labeledString() {
		String s = "  ";
		for(int x = 0; x < width; x++) {
			s+=x%10;
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
	
	
	//set value of character at (x,y) to parameter character 'c'
	public void set(int x, int y, char c) {
		int i = getIndex(x,y);
		String s1 = board.substring(0,i);
		String s2 = board.substring(i+1);
		board = s1 + c + s2;
	}
	
	//accessor methods
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
