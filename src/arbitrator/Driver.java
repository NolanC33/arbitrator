package arbitrator;

import java.util.ArrayList;

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
