package edu.uoc.uocleaner.model;


public abstract class Sprite {
	
	private int row;
	private int column;
	private Symbol symbol;
	
	protected Sprite(int row, int column, Symbol symbol) throws SpriteException{
		setRow(row);
		setColumn(column);
		setSymbol(symbol);
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public void setRow(int row) throws SpriteException{
		if (row < 0)
			throw new SpriteException (SpriteException.ERROR_INDEX_ROW_INCORRECT);
		else this.row = row;
	}
	
	public void setColumn(int column) throws SpriteException{
		if (column < 0)
			throw new SpriteException (SpriteException.ERROR_INDEX_COLUMN_INCORRECT);
		else this.column = column;
	}
	
	public Symbol getSymbol() {
		return this.symbol;
	}
	
	private void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public boolean equals(Object object) {
		Sprite other = (Sprite)object ;
		if (this.symbol == other.symbol && this.row == other.row && this.column == other.column)
			return true;
		return false;
	}
	
	
	public java.lang.String toString() {
		return symbol.toString();
	}

}
