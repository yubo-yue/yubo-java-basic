package effectivev2.commonmethod;

import java.math.BigDecimal;
import static java.lang.System.out;

public class CompareToTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigDecimal oneZero = new BigDecimal("1.0");
		BigDecimal oneZeroZero = new BigDecimal("1.00");
		out.println("oneZero equals to oneZeroZero " + oneZero.equals(oneZeroZero));
		out.println("oneZero compares to oneZeroZero " + oneZero.compareTo(oneZeroZero));
	}

}
