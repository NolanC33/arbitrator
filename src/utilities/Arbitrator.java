package utilities;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Arbitrator {
	
	private int maxCount;
	
	private Hashtable<String, Integer> itemToRank;
	
	Hashtable<Integer, ArrayList<String>> rankToItem;
	
	public Arbitrator(ArrayList<String[]> lists, int maxCount) {
		
		itemToRank = new Hashtable<String, Integer>();
		this.maxCount = maxCount;
		
		this.arbitrate(lists);
	}
	
	private void arbitrate(ArrayList<String[]> lists) {
		
		for (String[] particularList : lists)
			parseList(particularList);
		
		this.invertCountryToRank();
		
	}
	
	
	private void invertCountryToRank() {
		
		this.rankToItem = new Hashtable<Integer, ArrayList<String>>();
		
		for (String item : itemToRank.keySet())
			updateRankToItem(item);
		
		
	}
	
	private void updateRankToItem(String item) {
		
		Integer rank = itemToRank.get(item);
		
		if (this.rankToItem.containsKey(rank)) {
			
			ArrayList<String> countriesOfTheParticularRank = this.rankToItem.get(rank);
			countriesOfTheParticularRank.add(item);
			this.rankToItem.put(rank, countriesOfTheParticularRank);
			
		} else {
			
			ArrayList<String> newList = new ArrayList<String>();
			newList.add(item);
			this.rankToItem.put(rank,  newList);
			
		}
		
	}
	
	private void parseList(String[] particularList) {
				
		for (int i = 0; (i < particularList.length) && (i < maxCount); i++)
			updateScore(particularList[i], i);
		
	}
	
	private void updateScore(String particularCountry, int positionInList) {
		
		int amountToAdd = maxCount - positionInList;
		
		if (itemToRank.containsKey(particularCountry)) {
			
			int oldRank = itemToRank.get(particularCountry);	
			
			itemToRank.put(particularCountry, oldRank + amountToAdd);
			
		} else {
			
			itemToRank.put(particularCountry, amountToAdd);
			
		}
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		Set<Integer> keys = rankToItem.keySet();
		
		ArrayList<Integer> keysList = new ArrayList<Integer>(keys);
		
		java.util.Collections.sort(keysList);
		
		for (int i = keysList.size() - 1; i >= 0; i--) {
			
			Integer index = keysList.get(i);
			
			sb.append(index);
			sb.append(": ");
			
			sb.append(this.rankToItem.get(index));
			
			sb.append('\n');
			
		}
		
		
		return sb.toString();
		
	}
	
}
