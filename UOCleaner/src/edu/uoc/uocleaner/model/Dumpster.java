package edu.uoc.uocleaner.model;

public class Dumpster extends Sprite{
	private int load = 0;

	public Dumpster(int row, int column) throws SpriteException{
		super(row, column, Symbol.DUMPSTER);
	}
	
	public int getLoad() {
		return load;
	}

	private void setLoad(int load) throws DumpsterException{
		if (load < 0)
			throw new DumpsterException (DumpsterException.ERROR_LOAD_NEGATIVE_VALUE);
		this.load = load;
	}
	
	public void addLoad(int load) throws DumpsterException{
		if (load < 0)
			throw new DumpsterException (DumpsterException.ERROR_LOAD_NEGATIVE_VALUE);
		this.load += load;
	}

}
