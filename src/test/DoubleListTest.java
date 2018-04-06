package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.DoubleList;

class DoubleListTest {
	
	private DoubleList<Integer> list;

	@BeforeEach
	void setUp() throws Exception {
		list = new DoubleList<>();
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
