package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KomponentaTest {

	Komponenta k;
	
	@BeforeEach
	void setUp() throws Exception {
		k = new Komponenta();
	}

	@AfterEach
	void tearDown() throws Exception {
		k = null;
	}

	@Test
	void testKomponenta() {
		k = new Komponenta();
		assertNotNull(k);
	}

	@Test
	void testKomponentaIntStringTipKomponenteDoubleStringDouble() {
		TipKomponente t = new TipKomponente(3, "CPU");
		k = new Komponenta(4, "Procesor", t, 500.5, "Prosecan procesor", 14500.99);
		assertNotNull(k);
		assertEquals(4, k.getKomponentaId());
		assertEquals("Procesor", k.getNazivKomponente());
		assertEquals(3, k.getTipKomponente().getTipKomponenteID());
		assertEquals("CPU", k.getTipKomponente().getNaziv());
		assertEquals(500.5, k.getTakt());
		assertEquals("Prosecan procesor", k.getOpis());
		assertEquals(14500.99, k.getCena());
	}

	@Test
	void testSetTakt() {
		k.setTakt(3);
		assertEquals(3, k.getTakt());
	}
	
	@Test
	void testSetTaktNegative() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> k.setTakt(-3));
	}

	@Test
	void testSetKomponentaId() {
		k.setKomponentaId(3);
		assertEquals(3, k.getKomponentaId());
	}
	
	@Test
	void testSetKomponentaIdNegative() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> k.setKomponentaId(-3));
	}

	@Test
	void testSetNazivKomponente() {
		k.setNazivKomponente("");
		assertEquals("", k.getNazivKomponente());
	}
	
	@Test
	void testSetNazivKomponenteNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> k.setNazivKomponente(null));
	}

	@Test
	void testSetTipKomponente() {
		TipKomponente t = new TipKomponente(3, "CPU");
		k.setTipKomponente(t);
		assertEquals(t, k.getTipKomponente());
	}
	
	@Test
	void testSetTipKomponenteNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> k.setTipKomponente(null));
	}

	@Test
	void testSetOpis() {
		k.setOpis("12345");
		assertEquals("12345", k.getOpis());
	}
	
	@Test
	void testSetOpisNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> k.setOpis(null));
	}
	
	@Test
	void testSetOpisShortString() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> k.setOpis("1234"));
	}

	@Test
	void testSetCena() {
		k.setCena(2);
		assertEquals(2, k.getCena());
	}
	
	@Test
	void testSetCenaNegative() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> k.setCena(-1));
	}

	@Test
	void testToString() {
		k.setNazivKomponente("GTX1080ti");
		String s = k.toString();
		assertTrue(s.contains("GTX1080ti"));
	}

	@ParameterizedTest
	@CsvSource({
		"300,Superpossition,1481",
		"4000,Superpossition,19755",
		"300,Heaven,635",
	})
	void testOceni(double takt,String nazivTesta, int ocena) {
		k.setTakt(takt);
		StressTest t = new StressTest();
		t.setNazivTesta(nazivTesta);
		assertEquals(ocena, k.oceni(t));
	}

	@ParameterizedTest
	@CsvSource({
		"1,CPU,2,300,CPU,2,300,CPU,true",
		"2,CPU,2,300,CPU,2,300,CPU,true",
		"1,CPU2,2,300,CPU,2,300,CPU,true",
		"1,CPU,21,300,CPU,2,300,CPU,false",
		"1,CPU,2,3001,CPU,2,300,CPU,false",
		"1,CPU,2,300,CPU1,2,300,CPU,false",
		"1,CPU,2,300,CPU,21,300,CPU,false",
		"1,CPU,2,300,CPU,2,3001,CPU,false",
		"1,CPU,2,300,CPU,2,300,CPU1,false",
	})
	void testEqualsObject(int tip, String nazivTipa, int id1, double takt1, String naziv1, int id2, double takt2, String naziv2, boolean eq) {
		TipKomponente t = new TipKomponente(tip, nazivTipa);
		k.setKomponentaId(id1);
		k.setTakt(takt1);
		k.setNazivKomponente(naziv1);
		k.setTipKomponente(t);
		
		Komponenta n = new Komponenta();
		n.setKomponentaId(id2);
		n.setTakt(takt2);
		n.setNazivKomponente(naziv2);
		n.setTipKomponente(t);
		
		assertEquals(eq, k.equals(n));
		
	}

	@ParameterizedTest
	@CsvSource({
		"3,2,Prva komponenta je jaca od druge.",
		"1,2,Druga komponenta je jaca od prve.",
		"3,3,Komponente su jednake jacine."
	})
	void testVratiZakljucak(int a, int b, String odgovor) {
		assertEquals(odgovor, Komponenta.vratiZakljucak(a, b));
	}

}
