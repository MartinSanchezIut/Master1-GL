package ex2.server;

import javax.jws.WebService;

@WebService(endpointInterface="ex2.server.MathService")
public class MathServiceImpl implements MathService {

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a-b;
	}

	public int multiply(int a, int b) {
		return a*b;
	}

	public int divide(int a, int b) throws IllegalArgumentException {
		if (b == 0)
			throw new IllegalArgumentException("Error: Cannot divide by zero");
		return a / b;
	}

	
}
