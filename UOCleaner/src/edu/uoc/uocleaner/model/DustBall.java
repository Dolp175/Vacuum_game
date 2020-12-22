package edu.uoc.uocleaner.model;

import java.util.ArrayList;

public class DustBall extends Dirt implements Movable{

	public DustBall(int row, int column) throws SpriteException {
		super(row, column, Symbol.DUSTBALL, 5);
	}
	
	public void moveTo (int row, int column) throws SpriteException {
		this.setRow(row);
		this.setColumn(column);
	}
	
	private boolean validMove(Level level, int row, int column ) {
		if (row < 0 || row >= level.getNumRows() || column < 0 || column >= level.getNumColumns())
			return false;
		Sprite obj = level.getCell(row, column);
		if ((obj.getSymbol().getAscii() == '·') || (obj.getSymbol().getAscii() == ' '))
			return true;
		return false;
	}
	
	public java.util.ArrayList<int[]> moveRandomly(Level level) {
		int nextRow = 0;
		int nextColumn = 0;
		ArrayList<int[]> al = new ArrayList<int[]>();
		
		if (validMove(level, this.getRow(),this.getColumn() - this.SPEED) == true)
			al.add(new int[]{this.getRow(),this.getColumn()- this.SPEED});
		if (validMove(level, this.getRow(),this.getColumn() + this.SPEED) == true)
			al.add(new int[]{this.getRow(),this.getColumn()+ this.SPEED});
		if (validMove(level, this.getRow()- this.SPEED,this.getColumn()) == true)
			al.add(new int[]{this.getRow()- this.SPEED,this.getColumn()});
		if (validMove(level, this.getRow()+ this.SPEED,this.getColumn()) == true)
			al.add(new int[]{this.getRow()+ this.SPEED,this.getColumn()});
		if (level.getCell(this.getRow(), this.getColumn()).getSymbol().getAscii() == 'V')
			return al;
		if (al.size() > 0 &&  Math.random()*1 >= 0.75) {
			int i = (int) Math.floor(Math.random()*al.size());
			nextRow = al.get(i)[0];
			nextColumn = al.get(i)[1];
			try {
				level.setCell(new Dirt(this.getRow(), this.getColumn()));
				this.setRow(nextRow);
				this.setColumn(nextColumn);
				level.setCell(this);
			} catch (SpriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return al;
	}
}
