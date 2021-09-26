package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacunarTest {
	
	Racunar r;

	@BeforeEach
	void setUp() throws Exception {
		r = new Racunar();
	}

	@AfterEach
	void tearDown() throws Exception {
		r = null;
	}

	@Test
	void testRacunar() {
		r = new Racunar();
		assertNotNull(r);
	}

	@Test
	void testRacunarIntStringStringDateDouble() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try {
			Date d = sdf.parse("05.05.2025");
			Racunar r = new Racunar(3, "FusionMaX", "Za zahtevne igre", d, 156000.36);
			assertNotNull(r);
			assertEquals(3, r.getRacunarID());
			assertEquals("FusionMaX", r.getNazivRacunara());
			assertEquals("Za zahtevne igre", r.getNamena());
			assertEquals("05.05.2025", sdf.format(r.getGarancija()));
			assertEquals(d, r.getGarancija());
			assertEquals(156000.36, r.getUkupnaCena());
		} catch (ParseException e) {
			fail("ParseException");
			e.printStackTrace();
		}
	}

	@Test
	void testSetGarancija() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try {
			Date d = sdf.parse("05.05.2025");
			r.setGarancija(d);
			assertEquals("05.05.2025", sdf.format(r.getGarancija()));
		} catch (ParseException e) {
			fail("ParseException");
			e.printStackTrace();
		}
	}
	
	@Test
	void testSetGarancijaNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> r.setGarancija(null));
	}
	
	@Test
	void testSetGarancijaBeforeNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try {
			Date d = sdf.parse("25.09.2021");
			assertThrows(java.lang.RuntimeException.class, 
					() -> r.setGarancija(d));
		} catch (ParseException e) {
			fail("ParseException");
			e.printStackTrace();
		}
	}

	@Test
	void testSetRacunarID() {
		r.setRacunarID(5);
		assertEquals(5, r.getRacunarID());
	}
	
	@Test
	void testSetRacunarIDNegative() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> r.setRacunarID(-5));
	}

	@Test
	void testSetNazivRacunara() {
		r.setNazivRacunara("GlacialBlue");
		assertEquals("GlacialBlue", r.getNazivRacunara());
	}
	
	@Test
	void testSetNazivRacunaraNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> r.setNazivRacunara(null));
	}

	@Test
	void testSetNamena() {
		r.setNamena("12345");
		assertEquals("12345", r.getNamena());
	}
	
	@Test
	void testSetNamenaNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> r.setNamena(null));
	}
	
	@Test
	void testSetNamenaShortString() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> r.setNamena("1234"));
	}

	@Test
	void testToString() {
		r.setNazivRacunara("LavaGreen");
		String s = r.toString();
		assertTrue(s.contains("LavaGreen"));
	}

	@Test
	void testSetStavke() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		ArrayList<StavkaRacunara> stavke = new ArrayList<>();
		try {
			Date d = sdf.parse("05.05.2025");
			Racunar r = new Racunar(3, "FusionMaX", "Za zahtevne igre", d, 156000.36);
			TipKomponente t = new TipKomponente(3, "CPU");
			Komponenta k = new Komponenta(4, "Procesor", t, 500.5, "Prosecan procesor", 14500.99);
			Korisnik kr = new Korisnik(1, "pera", "peric", "Peca22", "Pera123");
			StavkaRacunara s = new StavkaRacunara(r, 1, k, 55, 1, 55, d, kr);
			stavke.add(s);
			r.setStavke(stavke);
			
			assertEquals(1, r.getStavke().size());
			assertEquals(s, r.getStavke().get(0));
			assertEquals(r, r.getStavke().get(0).getRacunar());
			assertEquals(3, r.getStavke().get(0).getRacunar().getRacunarID());
			assertEquals("FusionMaX", r.getStavke().get(0).getRacunar().getNazivRacunara());
			assertEquals("Za zahtevne igre", r.getStavke().get(0).getRacunar().getNamena());
			assertEquals("05.05.2025", sdf.format(r.getStavke().get(0).getRacunar().getGarancija()));
			assertEquals(d, r.getStavke().get(0).getRacunar().getGarancija());
			assertEquals(156000.36, r.getStavke().get(0).getRacunar().getUkupnaCena());
			assertEquals(k, r.getStavke().get(0).getKomponenta());
			assertEquals(t, r.getStavke().get(0).getKomponenta().getTipKomponente());
			assertEquals(4, r.getStavke().get(0).getKomponenta().getKomponentaId());
			assertEquals("Procesor", r.getStavke().get(0).getKomponenta().getNazivKomponente());
			assertEquals(3, r.getStavke().get(0).getKomponenta().getTipKomponente().getTipKomponenteID());
			assertEquals("CPU", r.getStavke().get(0).getKomponenta().getTipKomponente().getNaziv());
			assertEquals(500.5, r.getStavke().get(0).getKomponenta().getTakt());
			assertEquals("Prosecan procesor", r.getStavke().get(0).getKomponenta().getOpis());
			assertEquals(14500.99, r.getStavke().get(0).getKomponenta().getCena());
			assertEquals(kr, r.getStavke().get(0).getKreirao());
			assertEquals(1, r.getStavke().get(0).getKreirao().getKorisnikId());
			assertEquals("pera", r.getStavke().get(0).getKreirao().getIme());
			assertEquals("peric", r.getStavke().get(0).getKreirao().getPrezime());
			assertEquals("Peca22", r.getStavke().get(0).getKreirao().getKorisnickoIme());
			assertEquals("Pera123", r.getStavke().get(0).getKreirao().getSifra());
			assertEquals(1, r.getStavke().get(0).getRedniBroj());
			assertEquals(55, r.getStavke().get(0).getCena());
			assertEquals(1, r.getStavke().get(0).getKolicina());
			assertEquals(55, r.getStavke().get(0).getUkupnaCena());
			
		} catch (ParseException e) {
			fail("ParseException");
			e.printStackTrace();
		}
	}
	
	@Test
	void testSetStavkeNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> r.setStavke(null));
	}

	@Test
	void testSetUkupnaCena() {
		r.setUkupnaCena(55);
		assertEquals(55, r.getUkupnaCena());
	}
	
	@Test
	void testSetUkupnaCenaNegative() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> r.setUkupnaCena(-5));
	}

	@ParameterizedTest
	@CsvSource({
		"1,1,true",
		"1,2,false",
		"2,1,false",
		"2,2,true"
	})
	void testEqualsObject(int a, int b, boolean eq) {
		Racunar r1 = new Racunar();
		Racunar r2 = new Racunar();
		r1.setRacunarID(a);
		r2.setRacunarID(b);
		assertEquals(eq, r1.equals(r2));
	}

	@Test
	void testOceni() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		ArrayList<StavkaRacunara> stavke = new ArrayList<>();
		try {
			Date d = sdf.parse("05.05.2025");
			Racunar r = new Racunar(3, "FusionMaX", "Za zahtevne igre", d, 156000.36);
			TipKomponente t1 = new TipKomponente(1, "RAM");
			TipKomponente t2 = new TipKomponente(2, "CPU");
			TipKomponente t3 = new TipKomponente(3, "GPU");
			Komponenta k1 = new Komponenta(1, "Procesor", t1, 500.5, "Prosecan procesor", 14500.99);
			Komponenta k2 = new Komponenta(2, "Procesor", t2, 500.5, "Prosecan procesor", 14500.99);
			Komponenta k3 = new Komponenta(3, "Procesor", t3, 500.5, "Prosecan procesor", 14500.99);
			Korisnik kr = new Korisnik(1, "pera", "peric", "Peca22", "Pera123");
			StavkaRacunara s1 = new StavkaRacunara(r, 1, k1, 100, 1, 100, d, kr);
			StavkaRacunara s2 = new StavkaRacunara(r, 2, k2, 200, 2, 400, d, kr);
			StavkaRacunara s3 = new StavkaRacunara(r, 3, k3, 300, 3, 900, d, kr);
			stavke.add(s1);
			stavke.add(s2);
			stavke.add(s3);
			r.setStavke(stavke);
			
			StressTest st = new StressTest(1, "Superpossiton", "Test za cpu, gpu i ram");
			assertEquals(6885, r.oceni(st));
			int suma = 0;
			for (StavkaRacunara stavka : r.getStavke()) {
		            suma += stavka.getKomponenta().oceni(st);
		    }
			assertEquals(suma, r.oceni(st));
			
		} catch (ParseException e) {
			fail("ParseException");
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@CsvSource({
		"2,1,Komponente prvog racunara su jace od komponenti drugog racunara.,true",
		"1,2,Komponente drugog racunara su jace od komponenti prvog racunara.,true",
		"2,2,Komponente racunara su jednake jacine.,true",
		"2,3,Komponente prvog racunara su jace od komponenti drugog racunara.,false",
		"3,2,Komponente drugog racunara su jace od komponenti prvog racunara.,false",
		"2,3,Komponente racunara su jednake jacine.,false",
	})
	void testVratiZakljucak(int a, int b, String zakljucak, boolean eq) {
		assertEquals(eq, zakljucak.equals(Racunar.vratiZakljucak(a, b)));
	}

}
