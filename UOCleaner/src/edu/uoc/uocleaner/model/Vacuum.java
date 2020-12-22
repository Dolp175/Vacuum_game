package edu.uoc.uocleaner.model;

public class Vacuum extends Sprite implements Movable{
	
	private int MAX_CAPACITY;
	private int capacity = 0;
	private Sprite under;
	
	public Vacuum(int row, int column, int maxCapacity) throws SpriteException, VacuumException {
		super(row, column, Symbol.VACUUM);
		if (maxCapacity <= 0) 
			throw new VacuumException (VacuumException.ERROR_MAX_CAPACITY_VALUE);
		this.MAX_CAPACITY = maxCapacity;
		setUnder(new Corridor(row,column));
	}

	public int getCapacity() {
		return capacity;
	}

	private void setCapacity(int capacity) throws VacuumException{
		if (capacity < 0 || capacity > MAX_CAPACITY)
			throw new VacuumException (VacuumException.ERROR_CAPACITY_NEGATIVE_VALUE);
		this.capacity = capacity;
	}
	
	public void incCapacity (int increment) throws VacuumException{
		if (increment < 0)
			throw new VacuumException (VacuumException.ERROR_INC_CAPACITY_NEGATIVE_VALUE);
		else if (this.capacity + increment > MAX_CAPACITY)
			throw new VacuumException (VacuumException.ERROR_OVERFLOW_MAX_CAPACITY);
		this.capacity += increment;
	}
	
	public Sprite getUnder() {
		return this.under;
	}
	
	public void setUnder(Sprite under) {
		this.under = under;
	}
	
	public void empty() throws VacuumException {
		if (this.capacity < 0 || this.capacity > MAX_CAPACITY)
			throw new VacuumException (VacuumException.ERROR_CAPACITY_NEGATIVE_VALUE);
		setCapacity(0);
	}
	
	public int getMaxCapacity() {
		return MAX_CAPACITY;
	}
	
	public void moveTo (int row, int column) throws SpriteException {
		this.setRow(row);
		this.setColumn(column);
	}

}
