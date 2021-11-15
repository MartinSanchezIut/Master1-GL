package useCambio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import gt.gob.banguat.variables.ws.TipoCambio;
import gt.gob.banguat.variables.ws.TipoCambioSoap;

public class MathServiceClientCLI extends AbstractMain {
	public static IntegerInputProcessor inputProcessor;
	
	public static void main(String[] args) {
		
		MathServiceClientCLI main = new MathServiceClientCLI();
		TipoCambioSoap proxy = null;
		BufferedReader inputReader;
		String userInput = "";
		
		try {
			inputReader = new BufferedReader(
					new InputStreamReader(System.in));
			main.setTestServiceWSDLUrl(inputReader);
			proxy = getProxy();
			
			do {
				main.menu();
				userInput = inputReader.readLine();
				main.processUserInput(inputReader, userInput, proxy);
				Thread.sleep(3000);
				
			} while(!userInput.equals(QUIT));
		} catch (MalformedURLException e) {
			System.err.println(SERVICE_WSDL_URL+" isn't a valid WSDL URL");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected boolean validServiceWSDLUrl() {
		return SERVICE_WSDL_URL.equals(
				"http://localhost:8080/mathservice?wsdl");
	}
	
	private static TipoCambioSoap getProxy() 
			throws MalformedURLException {
		return new TipoCambio(new URL(SERVICE_WSDL_URL))
				.getTipoCambioSoap();
	}
	
	@Override
	public void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit.");
		builder.append("\n1. Add two integers: a + b.");
		builder.append("\n2. Subtract two integers: a - b.");
		builder.append("\n3. Multiply two integers: a * b");
		builder.append("\n4. Divide two integers: a / b");
		
		System.out.println(builder);
	}
	
	private void processUserInput(BufferedReader reader, 
			String userInput, TipoCambioSoap proxy) {
		try {
			switch(userInput) {
				case "1":
					invokeServiceOperation(
							new IntegerInputProcessor(reader),
							new IntegerInputProcessor(reader),
							proxy,
							"add");
					break;
				
				case "2":
					invokeServiceOperation(
							new IntegerInputProcessor(reader),
							new IntegerInputProcessor(reader),
							proxy,
							"subtract");
					break;
					
				case "3":
					invokeServiceOperation(
							new IntegerInputProcessor(reader),
							new IntegerInputProcessor(reader),
							proxy,
							"multiply");
					break;
					
				case "4":
					invokeServiceOperation(
							new IntegerInputProcessor(reader),
							new NonZeroIntegerInputProcessor(reader),
							proxy,
							"divide");
					break;
					
				case QUIT:
					System.out.println("Bye...");
					return;
				
				default:
					System.err.println("Sorry, wrong input. Please try again.");
					return;
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void invokeServiceOperation(IntegerInputProcessor 
			param1Processor, IntegerInputProcessor param2Processor, 
			TipoCambioSoap proxy, String operationName) throws IOException {
		inputProcessor = param1Processor;
		int a = inputProcessor.process();
		
		inputProcessor = param2Processor;
		int b = inputProcessor.process();
		
		switch(operationName) {
			case "add":
				System.out.println(" "+(proxy.tipoCambioDiaString()));
				System.out.println();
				break;
				
		
		}
	}
}
