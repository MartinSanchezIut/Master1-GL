package main.dico;

public class FastDictionary extends AbstractDictionary{

	public FastDictionary() {
		keys = new Object[0];
		values = new Object[0];
	}
	public FastDictionary(int n) {
		keys = new Object[n];
		values = new Object[n];
	}
	
	@Override
	public int size() {
		int taille = 0;
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null) {
				taille++;
			}
		}
		return taille;
	}
	
	public boolean mustGrow() {
		float i = this.size();
		float j = keys.length ;
		if (j == 0) { return true; }
	
		if (i > (3/4) * j) {
			return true;
		}
		
		return false;
	}
	
	public void grow() {
		while(mustGrow()) {
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
		}
	}
	
	
	@Override
	int indexOf(Object key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int newIndexOf(Object key) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
