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
				choices = ir.readLineAsArray("Input prefList (Input nothing to finish inputting of prefLists)");
				listChoices.add(choices);
			}
		} catch (InputReaderDeconstructedException e) {
			ir.deconstruct();
		} catch (InputEmptyException e) {
			ir.deconstruct();
		}
		
		int numCountries = 7;
		
		Arbitrator a = new Arbitrator(listChoices, numCountries);

		System.out.print(a.toString());

	}	
		


}
