package main.dico;

public class SortedDictionary extends OrderedDictionary{
	
	
	public SortedDictionary() {
		super();
	}

	@Override
	public int newIndexOf(Object key) {
		Object[] newKeys = new Object[keys.length+1] ; 
		Object[] newValues = new Object[values.length+1] ; 

		
		int index = -1;
		for (int i = 0; i < keys.length; i++) {
			Comparable test = (Comparable) key ;
			// Si key est plus petit que tab[i]
			//    index = i
			// Sinon (key est plus grand ou incomparable
			//    newKey[i = keys [i] de meme pour values
			newKeys[i] = keys[i];
			newValues[i] = values[i];
		}

		//keys[keys.length -1] = key ;
		newKeys[newKeys.length -1] = key ;
		
		keys = newKeys;
		values = newValues;		
		return values.length -1;
	}
}
