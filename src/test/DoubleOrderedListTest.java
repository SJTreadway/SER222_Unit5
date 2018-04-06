package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.DoubleOrderedList;

class DoubleOrderedListTest {
	
	private DoubleOrderedList<Integer> list;

	@BeforeEach
	void setUp() throws Exception {
		list = new DoubleOrderedList<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
