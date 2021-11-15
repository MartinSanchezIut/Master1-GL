package hai704i.tp2.demo.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import hai704i.tp2.demo.client.EmployeeService;
import hai704i.tp2.demo.client.EmployeeServiceImplService;
import hai704i.tp2.demo.client.Employee;
import hai704i.tp2.demo.client.EmployeeAlreadyExistsException_Exception;
import hai704i.tp2.demo.client.EmployeeNotFoundException_Exception;

public class EmployeeServiceClientCLI extends AbstractMain {
	
	public static IntegerInputProcessor inputProcessor;

	public static void main(String[] args) {
		EmployeeServiceClientCLI main = new EmployeeServiceClientCLI();
		EmployeeService proxy = null;
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
				"http://localhost:8080/employeeservice?wsdl");
	}
	
	private static EmployeeService getProxy() 
			throws MalformedURLException {
		return new EmployeeServiceImplService(new URL(SERVICE_WSDL_URL))
				.getEmployeeServiceImplPort();
	}

	@Override
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit.");
		builder.append("\n1. Get number of employees.");
		builder.append("\n2. Display all employees.");
		builder.append("\n3. Get employee by ID");
		builder.append("\n4. Add new employee");
		builder.append("\n5. Remove employee by ID");
		builder.append("\n6. Update existing employee");
		
		System.out.println(builder);
		
	}
	
	private void processUserInput(BufferedReader reader, 
			String userInput, EmployeeService proxy) {
		try {
			switch(userInput) {
				case "1":
					System.out.println("There are "+proxy.count()+" employees");
					break;
				
				case "2":
					proxy
					.getEmployees()
					.forEach(e -> displayEmployee(e));
					break;
					
				case "3":
					inputProcessor = new IntegerInputProcessor(reader);
					int id = inputProcessor.process();
					Employee employee = proxy.getEmployee(id);
					displayEmployee(employee);
					break;
					
				case "4":
					System.out.println("Employee ID: ");
					inputProcessor = new IntegerInputProcessor(reader);
					id = inputProcessor.process();
					System.out.println();
					
					System.out.println("Employee Name: ");
					String name = reader.readLine();
					System.out.println();
					
					proxy.addEmployee(id, name);
					System.out.println("Successfully added employee.");
					break;
					
				case "5":
					System.out.println("Employee ID: ");
					inputProcessor = new IntegerInputProcessor(reader);
					id = inputProcessor.process();
					System.out.println();
					
					if(proxy.deleteEmployee(id))
						System.out.println("Successfully removed employee with ID "+id+".");
					else
						System.err.println("Failed to remove employee with ID "+id+".");
					
					break;
					
				case "6":
					System.out.println("Employee ID: ");
					inputProcessor = new IntegerInputProcessor(reader);
					id = inputProcessor.process();
					System.out.println();
					
					System.out.println("Employee Name: ");
					name = reader.readLine();
					System.out.println();
					
					proxy.updateEmployee(id, name);
					System.out.println("Successfully updated employee with ID "+id+".");
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
		} catch (EmployeeNotFoundException_Exception e) {
			System.err.println(e.getMessage());
		} catch (EmployeeAlreadyExistsException_Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static void displayEmployee(Employee employee) {
		System.out.println("ID: "+employee.getId()+ 
				", Name: "+employee.getName());
	}
}
