package arbitrator;

import java.util.Scanner;

public class InputReader {
	
	private Scanner s;
	
	private boolean scannerClosed;
	
	public InputReader() {
		s = new Scanner(System.in);
		scannerClosed = false;
	}
	
	
	public String[] readLineAsArray(String messageToDisplay) throws InputReaderDeconstructedException {
		
		if (scannerClosed) {
			throw new InputReaderDeconstructedException();
		}
		
		System.out.println(messageToDisplay);
		
		String theLine = s.nextLine();
		
		if (theLine.equals("")) {
			return null;
		}
		
		return theLine.split(" ");
		
	}
	
	public void deconstruct() {
		s.close();
		scannerClosed = true;
	}
	
}
