package effectivev2.creation2nddestroy;
/**
 * Implementing singleton pattern with Enum class.
 * @author yubo
 *
 */
public enum SingltenByEnum {
	
	INSTANCE;
	
	public void doSth()
	{
		//
	}
	
	public static SingltenByEnum getInstance()
	{
		return INSTANCE;
	}
}
