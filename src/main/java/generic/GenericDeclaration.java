package generic;

public class GenericDeclaration {

	public static class Pair<T, U> {
		private final T first;
		private final U second;
		
		public Pair(T f, U s)
		{
			this.first = f;
			this.second = s;
		}
		public T getFirst() { return first; }
		public U getSecond() { return second; }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair<String, Integer> pair = new Pair<String, Integer>("a", 1);
		Pair<String, Integer> crazyPair = new Pair("a", 2);
	}

}
