package main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import main.dico.FastDictionary;

class testFastDico extends TestDico {

	@BeforeEach
	void setUp() throws Exception {
		dico = new FastDictionary() ;
	}

	@Disabled
	void test() {
		fail("Not yet implemented");
	}

}
