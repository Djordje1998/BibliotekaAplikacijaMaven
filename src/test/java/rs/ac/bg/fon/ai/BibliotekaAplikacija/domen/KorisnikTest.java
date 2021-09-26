package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KorisnikTest {
	
	Korisnik k;

	@BeforeEach
	void setUp() throws Exception {
		k = new Korisnik();
	}

	@AfterEach
	void tearDown() throws Exception {
		k = null;
	}

	@Test
	void testKorisnik() {
		k = new Korisnik();
		assertNotNull(k);
	}

	@Test
	void testKorisnikWithoutID() {
		k = new Korisnik("Petar", "Peric", "PecaCar", "Petar123", "Petar123");
		assertNotNull(k);
		assertEquals("Petar", k.getIme());
		assertEquals("Peric", k.getPrezime());
		assertEquals("PecaCar", k.getKorisnickoIme());
		assertEquals("Petar123", k.getSifra());
		assertEquals("Petar123", k.getSifraPotvrda());
		
	}

	@Test
	void testKorisnikWithID() {
		k = new Korisnik(3, "Petar", "Peric", "PecaCar", "Petar123");
		assertNotNull(k);
		assertEquals(3, k.getKorisnikId());
		assertEquals("Petar", k.getIme());
		assertEquals("Peric", k.getPrezime());
		assertEquals("PecaCar", k.getKorisnickoIme());
		assertEquals("Petar123", k.getSifra());
	}

	@Test
	void testSetSifra() {
		k.setSifra("12345");
		assertEquals("12345", k.getSifra());
	}
	
	@Test
	void testSetSifraNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> k.setSifra(null));
	}
	
	@Test
	void testSetSifraShortString() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> k.setSifra("tri"));
	}

	@Test
	void testSetIme() {
		k.setIme("");
		assertEquals("", k.getIme());
	}
	
	@Test
	void testSetImeNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> k.setIme(null));
	}

	@Test
	void testSetPrezime() {
		k.setPrezime("qw");
		assertEquals("qw", k.getPrezime());
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> k.setPrezime(null));
	}
	
	@Test
	void testSetPrezimeShortString() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> k.setPrezime("P"));
	}

	@Test
	void testSetKorisnickoIme() {
		k.setKorisnickoIme("qw");
		assertEquals("qw", k.getKorisnickoIme());
	}
	
	@Test
	void testSetKorisnickoImeNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> k.setKorisnickoIme(null));
	}
	
	@Test
	void testSetKorisnickoImeShortString() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> k.setKorisnickoIme("P"));
	}

	@Test
	void testSetKorisnikId() {
		k.setKorisnikId(5);
		assertEquals(5, k.getKorisnikId());
	}
	
	@Test
	void testSetKorisnikIdNegative() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> k.setKorisnikId(-5));
	}

	@Test
	void testSetSifraPotvrda() {
		k.setSifraPotvrda("qw");
		assertEquals("qw", k.getSifraPotvrda());
	}
	
	@Test
	void testSetSifraPotvrdaNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> k.setSifraPotvrda(null));
	}

	@Test
	void testSetSifraPotvrdaShortString() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> k.setSifraPotvrda("P"));
	}

	@Test
	void testToString() {
		k.setIme("Mirko");
		k.setPrezime("Mirkovic");
		String s =  k.toString();
		assertTrue(s.contains("Mirko"));
		assertTrue(s.contains("Mirkovic"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,Pera,Peric,Peca,pera123,1,Pera,Peric,Peca,pera123,true",
		"12,Pera,Peric,Peca,pera123,1,Pera,Peric,Peca,pera123,false",
		"1,Pera2,Peric,Peca,pera123,1,Pera,Peric,Peca,pera123,false",
		"1,Pera,Peric2,Peca,pera123,1,Pera,Peric,Peca,pera123,false",
		"1,Pera,Peric,Peca2,pera123,1,Pera,Peric,Peca,pera123,false",
		"1,Pera,Peric,Peca,pera1232,1,Pera,Peric,Peca,pera123,false",
		"1,Pera,Peric,Peca,pera123,12,Pera,Peric,Peca,pera123,false",
		"1,Pera,Peric,Peca,pera123,1,Pera2,Peric,Peca,pera123,false",
		"1,Pera,Peric,Peca,pera123,1,Pera,Peric2,Peca,pera123,false",
		"1,Pera,Peric,Peca,pera123,1,Pera,Peric,Peca2,pera123,false",
		"1,Pera,Peric,Peca,pera123,1,Pera,Peric,Peca,pera1232,false",
	})
	void testEqualsObject(int id1, String ime1, String prezime1, String korIme1, String sifra1, int id2, String ime2, String prezime2, String korIme2, String sifra2, boolean eq) {
		k.setKorisnikId(id1);
		k.setIme(ime1);
		k.setPrezime(prezime1);
		k.setKorisnickoIme(korIme1);
		k.setSifra(sifra1);
		
		Korisnik n = new Korisnik();
		n.setKorisnikId(id2);
		n.setIme(ime2);
		n.setPrezime(prezime2);
		n.setKorisnickoIme(korIme2);
		n.setSifra(sifra2);
		
		assertEquals(eq, k.equals(n));
	}

}
