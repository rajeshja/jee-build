package rja.bean;

import javax.annotation.security.PermitAll;
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
@PermitAll
@Stateless
@Local(rja.bean.Calculator.class)
public class CalculatorBean implements Calculator {

	@PermitAll
	public int add(int a, int b) {
		return a + b;
	}

	@PermitAll
	public int subtract(int a, int b) {
		return a - b;
	}
}
