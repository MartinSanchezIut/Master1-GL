package hai704i.tp2.demo.main;

import java.io.BufferedReader;

public class IntegerInputProcessor extends ComplexUserInputProcessor<Integer> {

	public IntegerInputProcessor(BufferedReader inputReader) {
		super(inputReader);
	}

	@Override
	protected void setMessage() {
		message = "Please enter an integer:";
	}

	@Override
	protected void setValidityCriterion() {
		isValid = str -> {
			try {
				Integer value = Integer.parseInt(str);
				return value instanceof Integer;
			} catch (NumberFormatException e) {
				return false;
			}
		};
	}

	@Override
	protected void setParser() {
		try {
			parser = Integer.class.getMethod("parseInt", String.class);
		} catch (SecurityException | NoSuchMethodException e) {
			
			e.printStackTrace();
		}
	}
}
