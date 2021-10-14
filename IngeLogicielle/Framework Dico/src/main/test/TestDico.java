package main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.dico.AbstractDictionary;


class TestDico {

	
	AbstractDictionary dico;
	
	@BeforeEach
	void setUp() throws Exception {
		// Subclass
	}

	
	
	@Test
	void testAddOneElementToEmptyDico() throws Exception {
		dico.put(new String("a"), new String("b"));
		assertEquals(1, dico.size());
	}

	@Test
	void testDicoContainsAddedKey() {
		dico.put(new String("a"), new String("b"));
		assertEquals(true, dico.containsKey("a")) ;
	}
	
	@Test
	void testElementInDico() throws Exception {
		dico.put(new String("a"), new String("b"));
		assertEquals("b", dico.get("a")) ;
	}
	
	@Test
	void testEmptyDicoIsEmpty() throws Exception {
		assertEquals(true, dico.isEmpty()) ;
	}	
}
