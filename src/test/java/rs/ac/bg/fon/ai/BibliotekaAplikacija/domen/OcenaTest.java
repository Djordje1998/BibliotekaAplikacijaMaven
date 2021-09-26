package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OcenaTest {

	Ocena o;
	
	@BeforeEach
	void setUp() throws Exception {
		o = new Ocena();
	}

	@AfterEach
	void tearDown() throws Exception {
		o = null;
	}

	@Test
	void testOcena() {
		o = new Ocena();
		assertNotNull(o);
	}

	@Test
	void testOcenaKomponentaStressTestDouble() {
		TipKomponente t = new TipKomponente(1, "CPU");
		Komponenta k = new Komponenta(2, "Procesor", t, 400.2, "Procesor dobar", 14888.99);
		StressTest st = new StressTest(3, "Heaven", "Test za procesor i gpu");
		o = new Ocena(k, st, 600.88);
		assertNotNull(o);
		assertEquals(2, o.getKomponenta().getKomponentaId());
		assertEquals("Procesor", o.getKomponenta().getNazivKomponente());
		assertEquals(1, o.getKomponenta().getTipKomponente().getTipKomponenteID());
		assertEquals("CPU", o.getKomponenta().getTipKomponente().getNaziv());
		assertEquals(400.2, o.getKomponenta().getTakt());
		assertEquals("Procesor dobar", o.getKomponenta().getOpis());
		assertEquals(14888.99, o.getKomponenta().getCena());
		assertEquals(3, o.getStressTest().getStressTestId());
		assertEquals("Heaven", o.getStressTest().getNazivTesta());
		assertEquals("Test za procesor i gpu", o.getStressTest().getOpisTesta());
		assertEquals(600.88, o.getVrednostOcene());
	}

	@Test
	void testSetVrednostOcene() {
		o.setVrednostOcene(555.55);
		assertEquals(555.55, o.getVrednostOcene());
	}
	
	@Test
	void testSetVrednostOceneNegative() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> o.setVrednostOcene(-55.55));
	}

	@Test
	void testSetKomponenta() {
		TipKomponente t = new TipKomponente(1, "CPU");
		Komponenta k = new Komponenta(2, "Procesor", t, 400.2, "Procesor dobar", 14888.99);
		o.setKomponenta(k);
		assertEquals(t, o.getKomponenta().getTipKomponente());
		assertEquals(k, o.getKomponenta());
		assertEquals(2, o.getKomponenta().getKomponentaId());
		assertEquals("Procesor", o.getKomponenta().getNazivKomponente());
		assertEquals(1, o.getKomponenta().getTipKomponente().getTipKomponenteID());
		assertEquals("CPU", o.getKomponenta().getTipKomponente().getNaziv());
		assertEquals(400.2, o.getKomponenta().getTakt());
		assertEquals("Procesor dobar", o.getKomponenta().getOpis());
		assertEquals(14888.99, o.getKomponenta().getCena());
	}
	
	@Test
	void testSetKomponentaNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> o.setKomponenta(null));
	}

	@Test
	void testSetStressTest() {
		StressTest st = new StressTest(3, "Heaven", "Test za procesor i gpu");
		o.setStressTest(st);
		assertEquals(3, o.getStressTest().getStressTestId());
		assertEquals("Heaven", o.getStressTest().getNazivTesta());
		assertEquals("Test za procesor i gpu", o.getStressTest().getOpisTesta());
	}
	
	@Test
	void testSetStressTestNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> o.setStressTest(null));
	}

}
