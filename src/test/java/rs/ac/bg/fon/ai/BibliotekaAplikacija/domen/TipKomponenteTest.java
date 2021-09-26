package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TipKomponenteTest {

	TipKomponente t;
	
	@BeforeEach
	void setUp() throws Exception {
		t = new TipKomponente();
	}

	@AfterEach
	void tearDown() throws Exception {
		t = null;
	}

	@Test
	void testTipKomponente() {
		t = new TipKomponente();
		assertNotNull(t);
	}

	@Test
	void testTipKomponenteIntString() {
		t = new TipKomponente(3, "CPU");
		assertNotNull(t);
		assertEquals(3, t.getTipKomponenteID());
		assertEquals("CPU", t.getNaziv());
	}

	@Test
	void testSetNaziv() {
		t.setNaziv("MB");
		assertEquals("MB", t.getNaziv());
	}
	
	@Test
	void testSetNazivNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> t.setNaziv(null));
	}
	
	@Test
	void testSetNazivShortString() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> t.setNaziv("P"));
	}

	@Test
	void testSetTipKomponenteID() {
		t.setTipKomponenteID(5);
		assertEquals(5, t.getTipKomponenteID());
	}
	
	@Test
	void testSetTipKomponenteIDNegative() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> t.setTipKomponenteID(-5));
	}

	@Test
	void testToString() {
		t.setNaziv("CPU");
		String s = t.toString();
		assertTrue(s.contains("CPU"));
	}

	@ParameterizedTest
	@CsvSource({
		"1,1,true",
		"2,1,false",
		"1,2,false",
		"2,2,true"
		})
	void testEqualsObject(int id1, int id2, boolean eq) {
		t.setTipKomponenteID(id1);
		TipKomponente i = new TipKomponente();
		i.setTipKomponenteID(id2);
		assertEquals(eq,t.equals(i));
	}

}
