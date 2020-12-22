package edu.uoc.uocleaner.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 
 * Level/Room class. 
 * @author David Garc�a Sol�rzano
 * @version 1.0 
 */
public class Level{
	/**
	 * Number of rows of the board.
	 */
	private int numRows;
	/**
	 * Number of columns of the board.
	 */
	private int numColumns;
	/**
	 * Representation of the 2D board.
	 */
	private Sprite[][] board;
	/**
	 * Name of the background image for the GUI app.
	 */
	private String imageBackground;
	/**
	 * Number of turns which the player has in order to beat the level.
	 */
	private int turns;	
	/**
	 * Maximum time which the player has in order to beat the level.
	 */
	private int time;
		
	/**
	 * Constructor 
	 * @param fileName Name of the configuration file which has all the information of the level.
	 * @throws FileNotFoundException When it is impossible to open the configuration file.
	 * @throws LevelException When the number of rows or columns are zero or negative; 
	 * when the number of turns or time is negative; when there is not only one vacuum cleaner; when there are not dumpsters; 
	 * when there are not dirts or dustballs.
	 * @throws VacuumException When the value for the vacuum cleaner's capacity is zero or negative.
	 * @throws SpriteException When the index of either the row or the column is incorrect.
	 */
	public Level(String fileName) throws FileNotFoundException, LevelException, VacuumException, SpriteException {
		char[] line = null;
		boolean isDumpster = false, isDirt = false;
		int numVacuums = 0;		
		
		Scanner sc = new Scanner(new File(fileName));

		// find the number of rows and columns       
        setNumRows(Integer.parseInt(sc.nextLine()));
        setNumColumns(Integer.parseInt(sc.nextLine()));
        setImageBackground(sc.nextLine());
        setTurns(Integer.parseInt(sc.nextLine()));
        setTime(Integer.parseInt(sc.nextLine()));
        
        board = new Sprite[numRows][numColumns];           
        for (int row = 0; row < numRows; row++) {
        	line = sc.nextLine().toCharArray();        	
			for (int column = 0; column < numColumns; column++) {				
				board[row][column] = SpriteFactory.getSprite(row,column,Symbol.getName(line[column]));				
				if(board[row][column] instanceof Dirt) isDirt = true;
				if(board[row][column] instanceof Vacuum) numVacuums++;
				if(board[row][column] instanceof Dumpster) isDumpster = true;								
			}			
        }        
        
        sc.close();       
                
        if(numVacuums!=1) {
        	throw new LevelException(LevelException.ERROR_NUM_VACUUMS);
        }
        
        if(!isDumpster) {
        	throw new LevelException(LevelException.ERROR_NO_DUMPSTERS);
        }
        
        if(!isDirt) {
        	throw new LevelException(LevelException.ERROR_NO_DIRT);
        }        
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumColumns() {
		return numColumns;
	}

	public String getImageBackground() {
		return imageBackground;
	}

	private void setImageBackground(String imageBackground) {
		this.imageBackground = imageBackground;
	}

	public int getTurns() {
		return turns;
	}

	private void setTurns(int turns) throws LevelException{
		if (turns < 0)
			throw new LevelException (LevelException.ERROR_NUM_TURNS_INCORRECT);
		this.turns = turns;
	}

	public int getTime() {
		return time;
	}

	private void setTime(int time) throws LevelException{
		if (time < 0)
			throw new LevelException (LevelException.ERROR_NUM_TIME_INCORRECT);
		this.time = time;
	}

	private void setNumRows(int numRows) throws LevelException{
		if (numRows <= 0)
			throw new LevelException (LevelException.ERROR_NUM_ROWS_INCORRECT);
		this.numRows = numRows;
	}

	private void setNumColumns(int numColumns) throws LevelException{
		if (numColumns <= 0)
			throw new LevelException (LevelException.ERROR_NUM_COLUMNS_INCORRECT);
		this.numColumns = numColumns;
	}
	
	public void decTurns() throws LevelException{
		if (this.turns <= 0)
			throw new LevelException (LevelException.ERROR_NUM_TURNS_INCORRECT);
		this.turns -= 1;
	}
	
	public void decTime() throws LevelException{
		if (this.time <= 0)
			throw new LevelException (LevelException.ERROR_NUM_TIME_INCORRECT);
		this.time -= 1;
	}
	
	public java.util.List<Sprite> get1DBoard(){
		
		List<Sprite> list = new ArrayList<Sprite>();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				list.add(board[i][j]);
			}
		}
		return list;
	}
	
	public Sprite getCell (int row, int column) {
		return this.board[putRowInRange(row)][putColumnInRange(column)];
	}
	
	public void setCell (Sprite sprite) throws SpriteException{
		if (sprite.getRow() < 0)
			throw new SpriteException (SpriteException.ERROR_INDEX_ROW_INCORRECT);
		else if (sprite.getColumn() < 0)
			throw new SpriteException (SpriteException.ERROR_INDEX_COLUMN_INCORRECT);
		board[sprite.getRow()][sprite.getColumn()] = sprite;
	}
	
	public void setCell (int row, int column, Sprite sprite) throws SpriteException{
		if (row < 0)
			throw new SpriteException (SpriteException.ERROR_INDEX_ROW_INCORRECT);
		else if (column < 0)
			throw new SpriteException (SpriteException.ERROR_INDEX_COLUMN_INCORRECT);
		sprite.setRow(putRowInRange(row));
		sprite.setColumn(putRowInRange(column));
		board[putRowInRange(row)][putColumnInRange(column)] = sprite;
	}
	
	private int putRowInRange(int row) {
		if (row < 0)
			return 0;
		else if (row > this.numRows)
			return this.numRows -1;
		return row;
	}
	
	private int putColumnInRange(int column) {
		if (column < 0)
			return 0;
		else if (column > this.numColumns)
			return this.numColumns -1;
		return column;
	}
	
	public java.lang.String toString() {
		String res = "";
		for (int i = 0; i < numRows; i++) {
			if (i > 0)
				res = res + "\n";
			for (int j = 0; j < numColumns; j++) {
				res =res + board[i][j].toString();
			}
			}
		res = res + "\n";
		return res;
		}	
}