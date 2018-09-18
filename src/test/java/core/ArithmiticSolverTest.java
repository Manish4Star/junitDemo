package core;

import junit.framework.TestCase;

public class ArithmiticSolverTest extends TestCase {
	
	public void testAdd() {
		ArithmiticSolver solver = new ArithmiticSolver();
		assertEquals(4, solver.add(2,2));
	}
	
	public void testSubtract() {
		ArithmiticSolver solver = new ArithmiticSolver();
		assertEquals(2, solver.subtract(4,2));
	}
	
	public void testMultiply() {
		ArithmiticSolver solver = new ArithmiticSolver();
		assertEquals(16, solver.multiply(8,2));
	}
	
	public void testDivide() {
		ArithmiticSolver solver = new ArithmiticSolver();
		assertEquals(3, solver.divide(9,3));
	}
	
	public void testModulus() {
		ArithmiticSolver solver = new ArithmiticSolver();
		assertEquals(1, solver.modulus(5,2));
	}

}
