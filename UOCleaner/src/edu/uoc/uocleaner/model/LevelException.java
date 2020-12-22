package edu.uoc.uocleaner.model;

public class LevelException extends java.lang.Exception{
	public static java.lang.String ERROR_NO_DIRT = "[ERROR] There must be one dirt at least!!";
	public static java.lang.String ERROR_NO_DUMPSTERS = "[ERROR] There must be one dumpster at least!!!!";
	public static java.lang.String ERROR_NUM_COLUMNS_INCORRECT = "[ERROR] The number of columns cannot be 0 or smaller!!";
	public static java.lang.String ERROR_NUM_ROWS_INCORRECT = "[ERROR] The number of rows cannot be 0 or smaller!!";
	public static java.lang.String ERROR_NUM_TIME_INCORRECT = "[ERROR] The time cannot be negative!!";
	public static java.lang.String ERROR_NUM_TURNS_INCORRECT = "[ERROR] The turns cannot be negative!!";
	public static java.lang.String ERROR_NUM_VACUUMS = "[ERROR] There must only be one vacuum cleaner!!";
	
	public LevelException() {
	}
	public LevelException(java.lang.String msg) {
		super(msg);
	}
}
