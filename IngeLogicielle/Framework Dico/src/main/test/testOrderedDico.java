package main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import main.dico.OrderedDictionary;

class testOrderedDico extends TestDico {

	@BeforeEach
	void setUp() throws Exception {
		dico = new OrderedDictionary() ;
	}

	@Disabled
	void test() {
		fail("Not yet implemented");
	}

}
