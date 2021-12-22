package com.example.tripadvisor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Predicate;
import java.io.BufferedReader;
import java.io.IOException;

public abstract class ComplexUserInputProcessor<T> {
	/* ATTRIBUTES */
	protected String message;
	protected BufferedReader inputReader;
	protected Method parser;
	protected Predicate<String> isValid;
	protected T parameter;
	
	/* CONSTRUCTOR */
	public ComplexUserInputProcessor(BufferedReader inputReader) {
		this.inputReader = inputReader;
		setMessage();
		setParser();
		setValidityCriterion();
	}
	
	/* METHODS */
	protected abstract void setMessage();
	protected abstract void setValidityCriterion();
	protected abstract void setParser();
	
	@SuppressWarnings("unchecked")
	public T process() throws IOException {
		System.out.println(message);
		String userInput = inputReader.readLine();
		
		while (!isValid.test(userInput)) {
			System.err.println("Sorry, wrong input. Please try again.");
			System.out.println();
			System.out.println(message);
			userInput = inputReader.readLine();
		}
		try {
			parameter = (T) parser.invoke(null, userInput);
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return parameter;
	}
}
