package edu.uoc.uocleaner.model;

public class DumpsterException extends java.lang.Exception{
	public static final java.lang.String ERROR_LOAD_NEGATIVE_VALUE = "[ERROR] Load cannoot be negative!!";
	
	public DumpsterException() {
	}
	public DumpsterException(java.lang.String msg) {
		super(msg);
	}
}
