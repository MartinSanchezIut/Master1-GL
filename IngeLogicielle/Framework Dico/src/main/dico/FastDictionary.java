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
	
	boolean mustGrow() {
		float i = this.size();
		float j = keys.length;
		if (j == 0)
			return true;
		else
			return ((i / j) > 0.7);
	}

	public void grow() {
		Object[] oldKeys = keys;
		Object[] oldValues = values;
		keys = new Object[oldKeys.length + 5];
		values = new Object[oldKeys.length + 5];
		
		for (int i = 0; i < oldKeys.length; i++) {
			if (oldKeys[i] != null) {
				this.put(oldKeys[i], oldValues[i]);
				//keys[i] = oldKeys[i];
				//values[i] = oldValues[i];
			}
		}
		
		System.out.println("taille du tableau: " + keys.length + "\n");
	}
	
	@Override
	public int indexOf(Object key) {
		if (this.mustGrow()) this.grow();

		int hash = key.hashCode();
		if (hash < 0) hash = -1 * hash;
		int i = hash % keys.length;
		while ((!(key.equals(keys[i]))) && (keys[i] != null)) {
			i = (i + 1) % keys.length;
		}
		if (keys[i] == null) return -1;
		else return i;
	}

	@Override
	public int newIndexOf(Object key) {
		if (this.mustGrow()) this.grow();
		int hash = key.hashCode();
		if (hash < 0) hash = -1 * hash;
		int i = hash % keys.length;
		if (keys[i] == null) return i;
		else {
			do {
				if (i + 1 < keys.length)
					i++;
				else
					i = 0;
			} while (keys[i] != null);
			return i;
		}
	}
}
