package utilities;


import java.util.Scanner;

import exceptions.InputEmptyException;
import exceptions.InputReaderDeconstructedException;

public class InputReader {
	
	private Scanner s;
	
	private boolean scannerClosed;
	
	public InputReader() {
		s = new Scanner(System.in);
		scannerClosed = false;
	}
	
	
	public String[] readLineAsArray(String messageToDisplay) throws InputReaderDeconstructedException, InputEmptyException {
		
		if (scannerClosed) {
			throw new InputReaderDeconstructedException();
		}
		
		System.out.println(messageToDisplay);
		
		String theLine = s.nextLine();
		
		if (theLine.equals("")) {
			throw new InputEmptyException();
		}
		
		return theLine.split(" ");
		
	}
	
	public void deconstruct() {
		s.close();
		scannerClosed = true;
	}
	
}
