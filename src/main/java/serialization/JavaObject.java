package serialization;

import java.io.ObjectStreamClass;
import java.io.Serializable;

public class JavaObject implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 100L;

	public static void main(String[] args)
	{
		ObjectStreamClass osc = ObjectStreamClass.lookup(JavaObject.class);
		osc.getFields();
		System.out.println("class name =" + osc.getName() + ",serialVersionUID = " + osc.getSerialVersionUID());
	}
}
