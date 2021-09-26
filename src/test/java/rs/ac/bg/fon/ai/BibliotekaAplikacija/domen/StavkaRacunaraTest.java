package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StavkaRacunaraTest {

	StavkaRacunara s;
	
	@BeforeEach
	void setUp() throws Exception {
		s = new StavkaRacunara();
	}

	@AfterEach
	void tearDown() throws Exception {
		s = null;
	}

	@Test
	void testStavkaRacunara() {
		s = new StavkaRacunara();
		assertNotNull(s);
	}

	@Test
	void testStavkaRacunaraRacunarIntKomponentaDoubleIntDoubleDateKorisnik() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try {
			Date d = sdf.parse("05.05.2025");
			Racunar r = new Racunar(3, "FusionMaX", "Za zahtevne igre", d, 156000.36);
			TipKomponente t = new TipKomponente(3, "CPU");
			Komponenta k = new Komponenta(4, "Procesor", t, 500.5, "Prosecan procesor", 14500.99);
			Korisnik kr = new Korisnik(1, "pera", "peric", "Peca22", "Pera123");
			s = new StavkaRacunara(r, 1, k, 55, 1, 55, d, kr);
			
			assertNotNull(s);
			assertEquals(r, s.getRacunar());
			assertEquals(3, s.getRacunar().getRacunarID());
			assertEquals("FusionMaX", s.getRacunar().getNazivRacunara());
			assertEquals("Za zahtevne igre", s.getRacunar().getNamena());
			assertEquals("05.05.2025", sdf.format(s.getRacunar().getGarancija()));
			assertEquals(d, s.getRacunar().getGarancija());
			assertEquals(156000.36, s.getRacunar().getUkupnaCena());
			assertEquals(k, s.getKomponenta());
			assertEquals(t, s.getKomponenta().getTipKomponente());
			assertEquals(4, s.getKomponenta().getKomponentaId());
			assertEquals("Procesor", s.getKomponenta().getNazivKomponente());
			assertEquals(3, s.getKomponenta().getTipKomponente().getTipKomponenteID());
			assertEquals("CPU", s.getKomponenta().getTipKomponente().getNaziv());
			assertEquals(500.5, s.getKomponenta().getTakt());
			assertEquals("Prosecan procesor", s.getKomponenta().getOpis());
			assertEquals(14500.99, s.getKomponenta().getCena());
			assertEquals(kr, s.getKreirao());
			assertEquals(1, s.getKreirao().getKorisnikId());
			assertEquals("pera", s.getKreirao().getIme());
			assertEquals("peric", s.getKreirao().getPrezime());
			assertEquals("Peca22", s.getKreirao().getKorisnickoIme());
			assertEquals("Pera123", s.getKreirao().getSifra());
			assertEquals(1, s.getRedniBroj());
			assertEquals(55, s.getCena());
			assertEquals(1, s.getKolicina());
			assertEquals(55, s.getUkupnaCena());
			
		} catch (ParseException e) {
			fail("ParseException");
			e.printStackTrace();
		}
	}

	@Test
	void testSetRedniBroj() {
		s.setRedniBroj(11);
		assertEquals(11, s.getRedniBroj());
	}
	
	@Test
	void testSetRedniBrojNegative() {
		assertThrows(java.lang.RuntimeException.class,
				() -> s.setRedniBroj(-11));
	}

	@Test
	void testSetCena() {
		s.setCena(11);
		assertEquals(11, s.getCena());
	}
	
	@Test
	void testSetCenaNegative() {
		assertThrows(java.lang.RuntimeException.class,
				() -> s.setCena(-11));
	}

	@Test
	void testSetDatumKreiranja() {
		Date d = new Date();
		s.setDatumKreiranja(d);
		assertEquals(d, s.getDatumKreiranja());
	}
	
	@Test
	void testSetDatumKreiranjaNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> s.setDatumKreiranja(null));
	}

	@Test
	void testSetKreirao() {
		Korisnik k = new Korisnik(1, "pera", "peric", "Peca22", "Pera123");
		s.setKreirao(k);
		assertEquals(k, s.getKreirao());
		assertEquals(1, s.getKreirao().getKorisnikId());
		assertEquals("pera", s.getKreirao().getIme());
		assertEquals("peric", s.getKreirao().getPrezime());
		assertEquals("Peca22", s.getKreirao().getKorisnickoIme());
		assertEquals("Pera123", s.getKreirao().getSifra());
	}
	
	@Test
	void testSetKreiraoNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> s.setKreirao(null));
	}

	@Test
	void testSetKolicina() {
		s.setKolicina(5);
		assertEquals(5, s.getKolicina());
	}
	
	@Test
	void testSetKolicinaNegative() {
		assertThrows(java.lang.RuntimeException.class,
				() -> s.setKolicina(-5));
	}

	@Test
	void testSetUkupnaCena() {
		s.setUkupnaCena(555);
		assertEquals(555, s.getUkupnaCena());
	}
	
	@Test
	void testSetUkupnaCenaNegative() {
		assertThrows(java.lang.RuntimeException.class,
				() -> s.setUkupnaCena(-5));
	}

	@Test
	void testSetRacunar() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try {
			Date d = sdf.parse("05.05.2025");
			Racunar r = new Racunar(3, "FusionMaX", "Za zahtevne igre", d, 156000.36);
			s.setRacunar(r);
			assertEquals(r, s.getRacunar());
			assertEquals(3, s.getRacunar().getRacunarID());
			assertEquals("FusionMaX", s.getRacunar().getNazivRacunara());
			assertEquals("Za zahtevne igre", s.getRacunar().getNamena());
			assertEquals("05.05.2025", sdf.format(s.getRacunar().getGarancija()));
			assertEquals(d, s.getRacunar().getGarancija());
			assertEquals(156000.36, s.getRacunar().getUkupnaCena());
		} catch (ParseException e) {
			fail("ParseException");
			e.printStackTrace();
		}
	}
	
	@Test
	void testSetRacunarNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> s.setRacunar(null));
	}

	@Test
	void testSetKomponenta() {
		TipKomponente t = new TipKomponente(3, "CPU");
		Komponenta k = new Komponenta(4, "Procesor", t, 500.5, "Prosecan procesor", 14500.99);
		s.setKomponenta(k);
		assertEquals(k, s.getKomponenta());
		assertEquals(t, s.getKomponenta().getTipKomponente());
		assertEquals(4, s.getKomponenta().getKomponentaId());
		assertEquals("Procesor", s.getKomponenta().getNazivKomponente());
		assertEquals(3, s.getKomponenta().getTipKomponente().getTipKomponenteID());
		assertEquals("CPU", s.getKomponenta().getTipKomponente().getNaziv());
		assertEquals(500.5, s.getKomponenta().getTakt());
		assertEquals("Prosecan procesor", s.getKomponenta().getOpis());
		assertEquals(14500.99, s.getKomponenta().getCena());
	}
	
	@Test
	void testSetKomponentaNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> s.setKomponenta(null));
	}

}
