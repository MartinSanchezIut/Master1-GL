package hai704i.tp2.demo.main;

import java.io.BufferedReader;

public class NonZeroIntegerInputProcessor extends IntegerInputProcessor {

	public NonZeroIntegerInputProcessor(BufferedReader inputReader) {
		super(inputReader);
	}
	
	@Override
	protected void setMessage() {
		message = "Please enter a non-zero integer:";
	}
	
	@Override
	protected void setValidityCriterion() {
		isValid = str -> {
			try {
				int value = Integer.parseInt(str);
				return value != 0;
			} catch (NumberFormatException e) {
				return false;
			}
		};
	}

}
