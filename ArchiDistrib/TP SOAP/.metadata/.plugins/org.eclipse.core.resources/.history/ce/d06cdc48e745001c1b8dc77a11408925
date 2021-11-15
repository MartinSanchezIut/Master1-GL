package hai704i.tp2.exo2.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="hai704i.tp2.exo2.server.MathService")
public class MathServiceImpl implements MathService {

	@WebMethod
	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@WebMethod
	@Override
	public int subtract(int a, int b) {
		return a - b;
	}

	@WebMethod
	@Override
	public int multiply(int a, int b) {
		return a * b;
	}

	@WebMethod
	@Override
	public int divide(int a, int b) throws IllegalArgumentException {
		if (b == 0)
			throw new IllegalArgumentException("Error: Cannot divide by zero");
		return a / b;
	}
}
