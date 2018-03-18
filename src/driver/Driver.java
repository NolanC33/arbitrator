package driver;


import java.util.ArrayList;

import exceptions.InputEmptyException;
import exceptions.InputReaderDeconstructedException;
import utilities.Arbitrator;
import utilities.InputReader;

public class Driver {
	
	
	public static void main(String[] args) {
		
		
		ArrayList<String[]> listChoices = new ArrayList<String[]>();
		
		String[] choices;
		
		InputReader ir = new InputReader();
		
		try {
			while (true) {
				choices = ir.readLineAsArray("Input list (Input nothing to cancel)");
				listChoices.add(choices);
			}
		} catch (InputReaderDeconstructedException e) {
			ir.deconstruct();
		} catch (InputEmptyException e) {
			ir.deconstruct();
		}
		
		Arbitrator a = new Arbitrator(listChoices);

		System.out.print(a.toString());

	}	
		


}
