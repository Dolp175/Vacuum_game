package edu.uoc.uocleaner.model;

public enum Symbol {
	CORRIDOR (' ', ""),
	DIRT ('·', "dirt.png"),
	DUMPSTER ('D', "dumpster.png"),
	DUSTBALL ('@', "dustball.png"),
	VACUUM ('V', "huocver.png"),
	WALL ('#', "");
	
	private char ascii;
	private java.lang.String image;
	
	private Symbol(char ascii, java.lang.String image) {
		this.ascii = ascii;
		this.image = image;
	}
	
	public static Symbol getName(char ascii) {
		if (ascii == ' ')
			return CORRIDOR;
		else if (ascii == '·')
			return DIRT;
		else if (ascii == 'D')
			return DUMPSTER;
		else if (ascii == '@')
			return DUSTBALL;
		else if (ascii == 'V')
			return VACUUM;
		else
			return WALL;
	}
	
	public char getAscii() {
		return this.ascii;
	}
	
	public java.lang.String getImage() {
		return this.image;
	}
	
	@Override
	public java.lang.String toString() {
		return String.valueOf(this.ascii);
	}
	
}
