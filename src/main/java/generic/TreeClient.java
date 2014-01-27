package generic;

public class TreeClient {

	public static <T> String toString(Tree<T> t) {
		return t.visit(new Tree.Visitor<T, String>() {
			public String leaf(T e) {
				return e.toString();
			}

			public String branch(final String l, final String r) {
				return "(" + l + "^" + r + ")";
			}

		});
	}
	
	public static <N extends Number> double sum(Tree<N> t)
	{
		return t.visit(new Tree.Visitor<N, Double>() {
			public Double leaf(N n)
			{
				return n.doubleValue();
			}
			
			public Double branch(final Double l, final Double r)
			{
				return l + r;
			}
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree<Integer> t = Tree.branch(Tree.branch(Tree.leaf(1), Tree.leaf(2)),
				Tree.leaf(3));
		assert toString(t).equals("((1^2)^3)");
		assert sum(t) == 6;
	}

}
