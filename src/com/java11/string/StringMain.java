package com.java11.string;

import java.io.IOException;
import java.util.stream.Stream;

public class StringMain {
	
	public static void main(String... args) throws IOException, InterruptedException {
		String onlyEmptySpace = "     ";
		
		System.out.println("onlyEmptySpace");
		System.out.println("String is blank: " + onlyEmptySpace.isBlank());
		System.out.println("String is empty: " + onlyEmptySpace.isEmpty());
		
		String name = " Leonardo Narciso ";
		Stream<String> nameStream = name.lines();
		
		System.out.println("");
		System.out.println("name");
		System.out.println("Find first in nameStream: " + nameStream.findFirst().get());
		System.out.println("repeating name: " + name.repeat(5));
		
		System.out.println("stripLeading: " + name.stripLeading());
		System.out.println("stripTrailing: " + name.stripTrailing());
		
	}

}
