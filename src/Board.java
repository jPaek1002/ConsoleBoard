import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Author: Jay Paek, Claire Chen, Eddie Li
 * Version: 2.0
 * Date: May 13, 2021
 * This is a 2 dimensional board based on a String
 * \n represents a line break > after line break is a new row
 * not very friendly with boards with 10+ rows
 * but you can still do it.
 * THIS CLASS IS IMMUTABLE (subject to change)
 */
public class Board {

	//Fields
	private String board;
	private int width;
	private int height;
	
	//Constructors
	
	//create an empty board
	public Board() {
		board = "";
	}
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
	//NOTE: DO NOT INVOKE THIS CONSTRUCTOR WITH AN EMPTY STRING
	//No good
	public Board(String board) {
		//set the input string as the board
		this.board = board;
		
		//set the width and height
		width = board.indexOf('\n');
		height = board.length()/width-1;
	}
	
	//instantiate board straight from a text file	 	
	//automatically sets the width and height
	//NOTE: DO NOT INVOKE THIS CONSTRUCTOR WITH AN EMPTY STRING
	//No good
	public Board makeBoardFromFile(String fileName) {
		//create an empty board
		Board b = new Board();
		
		//set up the board by reading from the file
		
		b.readData(fileName);
		System.out.println(b);
		//set the width and height
		b.setWidth(b.getBoard().indexOf('\n'));
		b.setHeight(b.getBoard().length()/width-1);
		return b;
	}
	
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
	
	//reads data from a text file and set the board String to the text file's String
	//DO NOT FORMAT THE TEXT FILE WITH SPACES, or else the board will read spaces as elements of the board.
	public void readData (String filename) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {

			FileReader reader = null;
			Scanner in = null;
			try {
					reader = new FileReader(dataFile);
					in = new Scanner(reader);
					
					while (in.hasNext()) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++) {
								board += line.charAt(i);
						}
						board+="\n";
					}

			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}
			
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}
	
	//accessor methods
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	public String getBoard() {
		return board;
	}
	//mutator methods
	private void setWidth(int width) {
		this.width = width;
	}
	//set the Height
	private void setHeight(int height) {
		this.height = height;
	}
	public void resetBoard(String board) {
		this.board = board;
		width = board.indexOf('\n');
		height = board.length()/width-1;
	}
}
