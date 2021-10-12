package main.dico;

public class SortedDictionary<T> extends AbstractDictionary<Comparable<T>>{
	
	
	public SortedDictionary() {
		keys = new Comparable<T>[0];
		values = new Object[0];
	}
	
	@Override
	public int indexOf(Object key) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i].equals(key)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int newIndexOf(Object key) {
		Object[] newKeys = new Object[keys.length+1] ; 
		Object[] newValues = new Object[values.length+1] ; 

		for (int i = 0; i < keys.length; i++) {
			newKeys[i] = keys[i];
		}
		for (int i = 0; i < values.length; i++) {
			newValues[i] = values[i];
		}
			
		keys = newKeys;
		values = newValues;
		
		keys[keys.length -1] = key ;
		
		return values.length -1;
	}

	@Override
	public int indexOf(Comparable key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int newIndexOf(Comparable key) {
		// TODO Auto-generated method stub
		return 0;
	}

}