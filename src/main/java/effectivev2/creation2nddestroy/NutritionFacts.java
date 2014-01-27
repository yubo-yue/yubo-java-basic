package effectivev2.creation2nddestroy;

/**
 * Builder pattern for class whose constructor has many parameters
 * @author yubo
 *
 */
public class NutritionFacts {

	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
	public static class Builder {
		//required parameters
		private final int servingSize;
		private final int servings;
		//optional parameters
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;
		
		public Builder(int servingSize, int servings)
		{
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val)
		{
			calories = val;
			return this;
		}
		
		public Builder fat(int val)
		{
			fat = val;
			return this;
		}
		
		public Builder carbohydrate(int val)
		{
			carbohydrate = val;
			return this;
		}
		
		public Builder sodium(int val)
		{
			sodium = val;
			return this;
		}
		
		public NutritionFacts build()
		{
			return new NutritionFacts(this);
		}
	}
	
	private NutritionFacts(Builder builder)
	{
		servingSize = builder.servingSize;
		servings = builder.servings;
		fat = builder.fat;
		calories = builder.calories;
		carbohydrate = builder.carbohydrate;
		sodium = builder.sodium;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NutritionFacts nf = new NutritionFacts.Builder(10, 10).calories(100).build();
	}

}
