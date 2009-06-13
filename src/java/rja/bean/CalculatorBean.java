package rja.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * The CalculatorBean EJB.
 *
 *
 * Created: Thu Mar  5 01:14:27 2009
 *
 * @version 1.0
 */
@Stateless
@Local(rja.bean.Calculator.class)
public class CalculatorBean implements Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}
}
