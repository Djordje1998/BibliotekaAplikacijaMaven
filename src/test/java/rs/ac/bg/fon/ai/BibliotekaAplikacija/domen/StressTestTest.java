package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StressTestTest {

	StressTest t;
	
	@BeforeEach
	void setUp() throws Exception {
		t=new StressTest();
	}

	@AfterEach
	void tearDown() throws Exception {
		t=null;
	}

	@Test
	void testStressTest() {
		t = new StressTest();
		assertNotNull(t);
	}

	@Test
	void testStressTestIntStringString() {
		t = new StressTest(3, "Furmark", "Test za CPU");
		assertNotNull(t);
		assertEquals(3, t.getStressTestId());
		assertEquals("Furmark", t.getNazivTesta());
		assertEquals("Test za CPU", t.getOpisTesta());
	}

	@Test
	void testSetOpisTesta() {
		t.setOpisTesta("12345");
		assertEquals("12345", t.getOpisTesta());
	}
	
	@Test
	void testSetOpisTestaNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> t.setOpisTesta(null));
	}
	
	@Test
	void testSetOpisTestaShortString() {
		assertThrows(java.lang.RuntimeException.class,
				() -> t.setOpisTesta("1234"));
	}

	@Test
	void testSetStressTestId() {
		t.setStressTestId(3);
		assertEquals(3, t.getStressTestId());
	}
	
	@Test
	void testSetStressTestIdNegative() {
		assertThrows(java.lang.RuntimeException.class,
				() -> t.setStressTestId(-3));
	}

	@Test
	void testSetNazivTesta() {
		t.setNazivTesta("XR");
		assertEquals("XR", t.getNazivTesta());
	}
	
	@Test
	void testSetNazivTestaNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> t.setNazivTesta(null));
	}
	
	@Test
	void testSetNazivTestaShortString() {
		assertThrows(java.lang.RuntimeException.class,
				() -> t.setNazivTesta("A"));
	}

	@Test
	void testToString() {
		t.setNazivTesta("Superposition");
		String s = t.toString();
		assertTrue(s.contains("Superposition"));
	}

}
