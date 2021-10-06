package testCroise;


public abstract class AbstractDictionary implements Idico {

	protected Object[] keys;
	protected Object[] values;
	
	protected AbstractDictionary(int n) {
		keys = new Object[n];
		values = new Object[n];
	}

	public int size() {
		return keys.length;
	}

	abstract int newIndexOf(Object key);

	abstract int indexOf(Object key);

	public Object get(Object key) throws Exception {
		int i = this.indexOf(key);
		if (i != -1)
			return values[i];
		else
			throw 
			new Exception("Cette clŽ n'est pas dans le dictionnaire: " + key);
	}

	public Object put(Object key, Object value) {
		int j = indexOf(key);
		if (j == -1) {
			int i = this.newIndexOf(key);
			keys[i] = key;
			values[i] = value;
		} else values[j] = value;
		return this;
	}

	public boolean isEmpty() {
		return (this.size() == 0);
	}

	public boolean containsKey(Object key) {
		return (indexOf(key) != -1); // Bug trouvé
	}

	public String toString() {
		String s = "taille du tableau: " + keys.length + "\n";
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null) {
				s = s + keys[i].toString() + " -> " + values[i].toString()
						+ "\n";
			}
		}
		return s;
	}

	public static void main(String[] args) throws Exception {

		//un jeu de test ˆ l'ancienne, ˆ remplacer par les votres.
		
		AbstractDictionary OD = new OrderedDictionary();
		//AbstractDictionary OD = new FastDictionary();
		// AbstractDictionary OD = new SortedDictionary();

		OD.put("Lavoisier", "Chimiste fran<E7>ais ...");
		System.out.println(OD.get("Lavoisier"));

		System.out.println("size " + OD.size());

		OD.put("Autre", "Autre Chimiste ...");
		System.out.println(OD.get("Autre"));

// ...
		
		System.out
				.println("*************************************************************");
		System.out.println(OD);

	}

}
