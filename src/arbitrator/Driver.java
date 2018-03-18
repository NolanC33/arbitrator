package arbitrator;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	private Scanner s = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		
		ArrayList<String[]> listChoices = new ArrayList<String[]>();
		
		String[] choices;
		
		Driver d = new Driver();
		
		choices = d.readList();
		
		while (choices != null) {
			listChoices.add(choices);
			choices = d.readList();
		}
		
		Arbitrator a = new Arbitrator(listChoices);
		

		System.out.print(a.toString());

	}
	
	private String[] readList() {
		
		System.out.println("Input list (or enter to terminate):");
				
		String theLine = s.nextLine();
		
		if (theLine.equals("")) {
			return null;
		}
		
		return theLine.split(" ");
		
		
		
	}
	
	
	
	
	


}
