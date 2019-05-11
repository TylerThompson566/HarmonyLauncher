package com.tylert.harmony.error;

/**
 * Custom Exception
 * 
 * @author tyler
 *
 */
public class CustomHarmonyException extends Exception {

	/** Serial UID */
	private static final long serialVersionUID = -3542482701937914571L;

	public CustomHarmonyException(String errorMessage) {
        super(errorMessage);
    }
}
