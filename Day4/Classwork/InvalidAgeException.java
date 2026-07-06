package com.coforge.day4;

public class InvalidAgeException extends Exception {
	 @Override
	    public String toString() {
	        return "InvalidAgeException: Age must be 18 or above to vote.";
	    }
}
