package edu.uoc.uocleaner.model;

public class VacuumException extends java.lang.Exception{
	public static java.lang.String ERROR_CAPACITY_NEGATIVE_VALUE = "[ERROR] The capacity cannot be negative!!";
	public static java.lang.String ERROR_INC_CAPACITY_NEGATIVE_VALUE = "[ERROR] The increment of the capacity cannot be a negative value!!";
	public static java.lang.String ERROR_MAX_CAPACITY_VALUE = "[ERROR] The maximum capacity of the vacuum cleaner cannot be 0 or a negative value!!";
	public static java.lang.String ERROR_OVERFLOW_MAX_CAPACITY = "[ERROR] You are trying to overflow the maximum capacity of the vacuum";
	
	
	public VacuumException() {
	}
	public VacuumException(java.lang.String msg) {
		super(msg);
	}
}
