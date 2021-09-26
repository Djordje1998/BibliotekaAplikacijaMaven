package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BenchmarkTest {
	
	Benchmark b;

	@BeforeEach
	void setUp() throws Exception {
		b = new Benchmark();
	}

	@AfterEach
	void tearDown() throws Exception {
		b = null;
	}

	@Test
	void testBenchmark() {
		b = new Benchmark();
		assertNotNull(b);
	}

	@Test
	void testBenchmarkIntDateDoubleDoubleRacunarRacunarStressTest() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try {
			Date now = new Date();
			Date d1 = sdf.parse("05.05.2025");
			Racunar r1 = new Racunar(1, "FusionMaX", "Za zahtevne igre", d1, 156000.36);
			Date d2 = sdf.parse("07.07.2025");
			Racunar r2 = new Racunar(2, "FusionX", "Za igre", d2, 136000.36);
			StressTest st = new StressTest(3, "CinebenchR19", "Test za procesorska jezgra");
			Benchmark b = new Benchmark(5, now, 55, 66, r1, r2, st);
			
			assertEquals(5, b.getBenchmarkId());
			assertEquals(now, b.getDatumBenchmarka());
			assertEquals(55, b.getBodoviPrvogRacunara());
			assertEquals(66, b.getBodoviDrugogRacunara());
			assertEquals(r1, b.getPrviRacunar());
			assertEquals(1, b.getPrviRacunar().getRacunarID());
			assertEquals("FusionMaX", b.getPrviRacunar().getNazivRacunara());
			assertEquals("Za zahtevne igre", b.getPrviRacunar().getNamena());
			assertEquals(d1, b.getPrviRacunar().getGarancija());
			assertEquals("05.05.2025", sdf.format(b.getPrviRacunar().getGarancija()));
			assertEquals(156000.36, b.getPrviRacunar().getUkupnaCena());
			assertEquals(r2, b.getDrugiRacunar());
			assertEquals(2, b.getDrugiRacunar().getRacunarID());
			assertEquals("FusionX", b.getDrugiRacunar().getNazivRacunara());
			assertEquals("Za igre", b.getDrugiRacunar().getNamena());
			assertEquals(d2, b.getDrugiRacunar().getGarancija());
			assertEquals("07.07.2025", sdf.format(b.getDrugiRacunar().getGarancija()));
			assertEquals(136000.36, b.getDrugiRacunar().getUkupnaCena());
			assertEquals(st, b.getStressTest());
			assertEquals(3, b.getStressTest().getStressTestId());
			assertEquals("CinebenchR19", b.getStressTest().getNazivTesta());
			assertEquals("Test za procesorska jezgra", b.getStressTest().getOpisTesta());
			
		} catch (ParseException e) {
			fail("ParseException");
			e.printStackTrace();
		}
	}

	@Test
	void testSetStressTest() {
		StressTest t = new StressTest(3, "Furmark", "Test za GPU");
		b.setStressTest(t);
		assertEquals(t, b.getStressTest());
		assertEquals(3, b.getStressTest().getStressTestId());
		assertEquals("Furmark", b.getStressTest().getNazivTesta());
		assertEquals("Test za GPU", b.getStressTest().getOpisTesta());
	}
	
	@Test
	void testSetStressTestNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> b.setStressTest(null));
	}

	@Test
	void testSetBenchmarkId() {
		b.setBenchmarkId(5);
		assertEquals(5, b.getBenchmarkId());
	}
	
	@Test
	void testSetBenchmarkIdNegative() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> b.setBenchmarkId(-5));
	}

	@Test
	void testSetDatumBenchmarka() {
		Date d = new Date();
		b.setDatumBenchmarka(d);
		assertEquals(d, b.getDatumBenchmarka());
	}
	
	@Test
	void testSetDatumBenchmarkaNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> b.setDatumBenchmarka(null));
	}

	@Test
	void testSetBodoviPrvogRacunara() {
		b.setBodoviPrvogRacunara(5);
		assertEquals(5, b.getBodoviPrvogRacunara());
	}
	
	@Test
	void testSetBodoviPrvogRacunaraNegative() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> b.setBodoviPrvogRacunara(-5));
	}

	@Test
	void testSetBodoviDrugogRacunara() {
		b.setBodoviDrugogRacunara(5);
		assertEquals(5, b.getBodoviDrugogRacunara());
	}
	
	@Test
	void testSetBodoviDrugogRacunaraNegative() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> b.setBodoviDrugogRacunara(-5));
	}

	@Test
	void testSetPrviRacunar(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try {
			Date d = sdf.parse("05.05.2025");
			Racunar r = new Racunar(3, "FusionMaX", "Za zahtevne igre", d, 156000.36);
			b.setPrviRacunar(r);
			assertEquals(r, b.getPrviRacunar());
			assertEquals(3, b.getPrviRacunar().getRacunarID());
			assertEquals("FusionMaX", b.getPrviRacunar().getNazivRacunara());
			assertEquals("Za zahtevne igre", b.getPrviRacunar().getNamena());
			assertEquals("05.05.2025", sdf.format(b.getPrviRacunar().getGarancija()));
			assertEquals(d, b.getPrviRacunar().getGarancija());
			assertEquals(156000.36, b.getPrviRacunar().getUkupnaCena());
		} catch (ParseException e) {
			fail("ParseException");
			e.printStackTrace();
		}
	}
	
	@Test
	void testSetPrviRacunarNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> b.setPrviRacunar(null));
	}

	@Test
	void testSetDrugiRacunar() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date d=null;
		try {
			d = sdf.parse("7.7.2027");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Racunar r = new Racunar(4, "FusionMax", "Za igre", d, 156000.46);
		b.setPrviRacunar(r);
		assertEquals(r, b.getPrviRacunar());
		assertEquals(4, b.getPrviRacunar().getRacunarID());
		assertEquals("FusionMax", b.getPrviRacunar().getNazivRacunara());
		assertEquals("Za igre", b.getPrviRacunar().getNamena());
		assertEquals("07.07.2027", sdf.format(b.getPrviRacunar().getGarancija()));
		assertEquals(d, b.getPrviRacunar().getGarancija());
		assertEquals(156000.46, b.getPrviRacunar().getUkupnaCena());
	}
	
	@Test
	void testSetDrugiRacunarNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> b.setDrugiRacunar(null));
	}

}
