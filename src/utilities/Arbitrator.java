package utilities;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Arbitrator {
	
	private final int numCountries = 7;
	
	private Hashtable<String, Integer> countryToRank;
	
	Hashtable<Integer, ArrayList<String>> rankToCountry;
	
	public Arbitrator(ArrayList<String[]> lists) {
		countryToRank = new Hashtable<String, Integer>();
		
		this.arbitrate(lists);
	}
	
	private void arbitrate(ArrayList<String[]> lists) {
		
		for (String[] particularList : lists) {
			updateScores(particularList);
		}
		
		this.invertCountryToRank();
		
	}
	
	
	private void invertCountryToRank() {
		
		this.rankToCountry = new Hashtable<Integer, ArrayList<String>>();
		
		for (String country : countryToRank.keySet()) {
			
			Integer rank = countryToRank.get(country);
			
			if (this.rankToCountry.containsKey(rank)) {
				ArrayList<String> countriesOfTheParticularRank = this.rankToCountry.get(rank);
				countriesOfTheParticularRank.add(country);
				this.rankToCountry.put(rank, countriesOfTheParticularRank);
				
			} else {
				
				ArrayList<String> newList = new ArrayList<String>();
				newList.add(country);
				this.rankToCountry.put(rank,  newList);
				
			}
			
		}
		
		
	}
	
	private void updateScores(String[] particularList) {
		
		String particularCountry;
		
		for (int i = 0; (i < particularList.length) && (i < numCountries); i++) {

			particularCountry = particularList[i];
			
			int amountToAdd = numCountries - i;
			
			if (countryToRank.containsKey(particularCountry)) {
				
				int oldRank = countryToRank.get(particularCountry);	
				
				countryToRank.put(particularCountry, oldRank + amountToAdd);
				
			} else {
				
				countryToRank.put(particularCountry, amountToAdd);
				
			}
		}
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		
		Set<Integer> keys = rankToCountry.keySet();
		
		
		ArrayList<Integer> keysList = new ArrayList<Integer>(keys);
		
		
		java.util.Collections.sort(keysList);
		
		for (int i = keysList.size() - 1; i >= 0; i--) {
			Integer index = keysList.get(i);
			
			sb.append(index);
			sb.append(": ");
			
			sb.append(this.rankToCountry.get(index));
			
			sb.append('\n');
			
		}
		
		
		return sb.toString();
		
	}
	
}
