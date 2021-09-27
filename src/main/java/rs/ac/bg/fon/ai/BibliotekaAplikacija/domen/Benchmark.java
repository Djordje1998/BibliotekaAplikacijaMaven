/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import java.sql.ResultSet;
import java.util.Date;

/**
 * Klasa koja predstavlja ocenu i zakljucak izmedju dva racunara i test kojim se testiraju.
 * Svaki benchmark poseduje jedisvetni ID, datum kreiranja, ocene oba racunara kao racunare i test.
 * 
 * @author Djordje Novakovic
 * @version 1.0
 */
public class Benchmark implements GenericEntity {

	/**
	 * ID benchmarka kao int.
	 */
    private int benchmarkId;
    
    /**
     * Datum kreiranja benchmarka kao Date.
     */
    private Date datumBenchmarka;
    
    /**
     * Bodovi koje je dobio prvi racunar na testu kao double.
     */
    private double bodoviPrvogRacunara;
    
    /**
     * Bodovi koje je dobio drugi racunar na testu kao double.
     */
    private double bodoviDrugogRacunara;
    
    /**
     * Prvi racunar koji se testira kao klasa Racunar.
     */
    private Racunar prviRacunar;
    
    /**
     * Drugi racunar koji se testira kao klasa Racunar.
     */
    private Racunar drugiRacunar;
    
    /**
     * Stress test na osnovu kog se testiraju racunari kao klasa StressTest
     */
    private StressTest stressTest;

    /**
     * Konstruktor bez parametara koji inicijalizuje objekat.
     */
    public Benchmark() {
    }

    /**
     * Konstruktor koji inicijalizuje objekati postavlje vrednost svih atributa benchmarka.
     * 
     * @param benchmarkId ID benchmarka kao int.
     * @param datumBenchmarka Datum kreiranja benchmarka kao Date.
     * @param bodoviPrvogRacunara Bodovi koje je dobio prvi racunar na testu kao double.
     * @param bodoviDrugogRacunara Bodovi koje je dobio drugi racunar na testu kao double.
     * @param prviRacunar Prvi racunar koji se testira kao klasa Racunar.
     * @param drugiRacunar Drugi racunar koji se testira kao klasa Racunar.
     * @param stressTest Stress test na osnovu kog se testiraju racunari kao klasa StressTest
     */
    public Benchmark(int benchmarkId, Date datumBenchmarka, double bodoviPrvogRacunara, double bodoviDrugogRacunara, Racunar prviRacunar, Racunar drugiRacunar, StressTest stressTest) {
        setBenchmarkId(benchmarkId);
        setDatumBenchmarka(datumBenchmarka);
        setBodoviPrvogRacunara(bodoviPrvogRacunara);
        setBodoviDrugogRacunara(bodoviDrugogRacunara);
        setPrviRacunar(prviRacunar);
        setDrugiRacunar(drugiRacunar);
        setStressTest(stressTest);
    }

    /**
     * Vraca stress test na osnovu kog se testiraju racunari.
     * 
     * @return Stress test na osnovu kog se testiraju racunari kao klasa StressTest.
     */
    public StressTest getStressTest() {
        return stressTest;
    }

    /**
     * Postavlja stress test na osnovu kog se testiraju racunari.
     * 
     * @param stressTest Stress test na osnovu kog se testiraju racunari kao klasa StressTest.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     */
    public void setStressTest(StressTest stressTest) {
    	if(stressTest==null) {
    		throw new NullPointerException("Stress test benchmarka ne sme biti null");
    	}
        this.stressTest = stressTest;
    }

    /**
     * Vraca ID benchmarka.
     * 
     * @return ID benchmarka kao int.
     */
    public int getBenchmarkId() {
        return benchmarkId;
    }

    /**
     * Postavlja ID benchmarka.
     * 
     * @param benchmarkId ID benchmarka kao int.
     * 
     * @throws java.lang.RuntimeException Ako je vrednost parametra int koji je manji od nule.
     */
    public void setBenchmarkId(int benchmarkId) {
    	if(benchmarkId < 0) {
    		throw new RuntimeException("Id benchmarka mora biti pozitivan broj");
    	}
        this.benchmarkId = benchmarkId;
    }

    /**
     * Vraca datum kreiranja benchmarka.
     * 
     * @return Datum kreiranja benchmarka kao Date.
     */
    public Date getDatumBenchmarka() {
        return datumBenchmarka;
    }

    /**
     * Postavlja datum kreiranja benchmarka.
     * 
     * @param datumBenchmarka Datum kreiranja benchmarka kao Date.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     */
    public void setDatumBenchmarka(Date datumBenchmarka) {
    	if(datumBenchmarka==null) {
    		throw new NullPointerException("Datum benchmarka ne sme biti null");
    	}
        this.datumBenchmarka = datumBenchmarka;
    }

    /**
     * Vraca bodove kao rezultat testiranja prvog racunara.
     * 
     * @return Rezultat testiranja prvog racunara kao double.
     */
    public double getBodoviPrvogRacunara() {
        return bodoviPrvogRacunara;
    }

    /**
     * Postavlje bodove prvog racunara kao rezultat testiranja.
     * 
     * @param bodoviPrvogRacunara Rezultat testiranja prvog racunara kao double.
     * 
     * @throws java.lang.RuntimeException Ako je vrednost parametra double koji je manji od nule.
     */
    public void setBodoviPrvogRacunara(double bodoviPrvogRacunara) {
    	if(bodoviPrvogRacunara < 0) {
    		throw new RuntimeException("Bodovi prvog racuanra benchmarka moraju biti pozitivan broj");
    	}
        this.bodoviPrvogRacunara = bodoviPrvogRacunara;
    }

    /**
     * Vraca bodove kao rezultat testiranja drugog racunara.
     * 
     * @return Rezultat testiranja drugog racunara kao double.
     */
    public double getBodoviDrugogRacunara() {
        return bodoviDrugogRacunara;
    }

    /**
     * Postavlje bodove drugog racunara kao rezultat testiranja.
     * 
     * @param bodoviDrugogRacunara Rezultat testiranja drugog racunara kao double.
     * 
     * @throws java.lang.RuntimeException Ako je vrednost parametra double koji je manji od nule.
     */
    public void setBodoviDrugogRacunara(double bodoviDrugogRacunara) {
    	if(bodoviDrugogRacunara < 0) {
    		throw new RuntimeException("Bodovi drugog racuanra benchmarka moraju biti pozitivan broj");
    	}
        this.bodoviDrugogRacunara = bodoviDrugogRacunara;
    }

    /**
     * Vraca prvi racunar benchmarka.
     * 
     * @return Prvi racunar benchmarka kao klasa Racunar.
     */
    public Racunar getPrviRacunar() {
        return prviRacunar;
    }

    /**
     * Postavlja prvi racunar benchmarka.
     * 
     * @param prviRacunar Prvi racunar benchmarka kao klasa Racunar.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     */
    public void setPrviRacunar(Racunar prviRacunar) {
    	if(prviRacunar==null) {
    		throw new NullPointerException("Prvi racunar benchmarka ne sme biti null");
    	}
        this.prviRacunar = prviRacunar;
    }

    /**
     * Vraca drugi racunar benchmarka.
     * 
     * @return Drugi racunar benchmarka kao klasa Racunar.
     */
    public Racunar getDrugiRacunar() {
        return drugiRacunar;
    }

    /**
     * Postavlja drugi racunar benchmarka.
     * 
     * @param drugiRacunar Drugi racunar benchmarka kao klasa Racunar.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     */
    public void setDrugiRacunar(Racunar drugiRacunar) {
    	if(drugiRacunar==null) {
    		throw new NullPointerException("Drugi racunar benchmarka ne sme biti null");
    	}
        this.drugiRacunar = drugiRacunar;
    }

    /**
     * @return Vraca String ime tabele koje se nalazi u bazi podataka i koje odgovara klasi.
     */
    @Override
    public String getTableName() {
        return "benchmark";
    }

    /**
     * @return Vraca String imena kolona u odgovarajucoj tabeli za dodavanje objekta u bazu.
     */
    @Override
    public String getColumnNamesForInsert() {
        return "DatumBenchmarka,BodoviPrvogRacunara,BodoviDrugogRacunara,RacunarID1,RacunarID2,StressTestID";
    }

    /**
     * @return Vraca String koji predstavlja SQL kod za unos konkretnih vrednosti objekta u bazu.
     */
    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(new java.sql.Date(getDatumBenchmarka().getTime())).append("',")
                .append(getBodoviPrvogRacunara()).append(",")
                .append(getBodoviDrugogRacunara()).append(",")
                .append(getPrviRacunar().getRacunarID()).append(",")
                .append(getDrugiRacunar().getRacunarID()).append(",")
                .append(getStressTest().getStressTestId());
        return sb.toString();
    }

    /**
     * Postavlja ID Benchmarka.
     * 
     * @param id ID Benchmarka kao int.
     */
    @Override
    public void setId(int id) {
        setBenchmarkId(id);
    }

    /**
     * @return Vraca String koji predstavlja SQL kod koji spaja vise tabela iz baze.
     */
    @Override
    public String getJoinTables() {
        // to do
        return "";
    }

    /**
     * @return Vraca String koji predstavlja kriterijum pretrage koji se dobija u query-ju od baze.
     */
    @Override
    public String getLikeCriteria() {
        return "";
    }

    /**
     * @return Vraca String koji predstavlja kriterijum pretrage postojecih vrednosti u bazi.
     */
    @Override
    public String getWhereCriteria() {
        return "";
    }

    /**
     * @return GenericEntity u kome se nalaze vrednosti kao odgovor query-ja iz baze.
     */
    @Override
    public GenericEntity getResponse(ResultSet rs) throws Exception {
        // to do
        return null;
    }

    /**
     * @return Vraca String koji predstavlja kriterijum brisanja postojecih vrednosti u bazi.
     */
    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("BenchmarkID = ").append(getBenchmarkId());
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja nove vrednosti koje ce biti zamenjene starim koje se vec nalaze u bazi.
     */
    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("DatumBenchmarka = '").append(getDatumBenchmarka())
                .append("', BodoviPrvogRacunara = ").append(getBodoviPrvogRacunara())
                .append(", BodoviDrugogRacunara = ").append(getBodoviDrugogRacunara())
                .append(", RacunarID1 = ").append(getPrviRacunar().getRacunarID())
                .append(", RacunarID2 = ").append(getDrugiRacunar().getRacunarID())
                .append(", StressTestID = ").append(getStressTest().getStressTestId());
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja kriterijum izmene postojecih vrednosti u bazi.
     */
    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("BenchmarkID = ").append(getBenchmarkId());
        return sb.toString();
    }

}
