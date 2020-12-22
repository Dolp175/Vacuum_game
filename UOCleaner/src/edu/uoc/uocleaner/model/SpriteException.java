package edu.uoc.uocleaner.model;

public class SpriteException extends java.lang.Exception{
	public static String ERROR_INDEX_ROW_INCORRECT = "[ERROR] The index of row cannot be negative!!";
	public static String ERROR_INDEX_COLUMN_INCORRECT = "[ERROR] The index of column cannot be negative!!";
	
	public SpriteException() {
	}
	public SpriteException(java.lang.String msg) {
		super(msg);
	}
}
