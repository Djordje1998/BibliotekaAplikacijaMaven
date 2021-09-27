/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import java.sql.ResultSet;

/**
 * Klasa koja predstavlja ocene komponente za odredjeni test.
 * Svaka ocena sadrzi referencu ka postojecoj komponenti i stres testu kao i vrednost ocene
 *
 * @author Djordje Novakovic
 * @version 1.0
 */
public class Ocena implements GenericEntity {

	/**
	 * Komponenta koja se ocenjuje kao klasa Komponenta.
	 */
    private Komponenta komponenta;
    
    /**
     * Stress test na osnovu koga se vrsi ocena kao StressTest.
     */
    private StressTest stressTest;
    
    /**
     * Vrednost ocene kao double vrednost.
     */
    private double vrednostOcene;

    /**
     * Konstruktor bez parametara koji inicijalizuje objekat.
     */
    public Ocena() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednosti za komponentu, test i vrednost ocene.
     * 
     * @param komponenta Komponenta koja je ocenjena kao klasa Komponenta.
     * @param stressTest Stress test na osnovu koga se vrsi ocena kao StressTest.
     * @param vrednostOcene Vrednost ocene kao double vrednost.
     */
    public Ocena(Komponenta komponenta, StressTest stressTest, double vrednostOcene) {
        setKomponenta(komponenta);
        setStressTest(stressTest);
        setVrednostOcene(vrednostOcene);
    }

    /**
     * Vraca vrednost ocene.
     * 
     * @return Vrednost ocene kao double.
     */
    public double getVrednostOcene() {
        return vrednostOcene;
    }

    /**
     * Postavlja vrednost ocene.
     * 
     * @param vrednostOcene Vrednost ocene kao double.
     * 
     * @throws lava.lang.RuntimeException Ako je vrednost atributa double vrednost manja od nule.
     */
    public void setVrednostOcene(double vrednostOcene) {
    	if(vrednostOcene<0) {
    		throw new RuntimeException("Vrednost ocene mora biti pozitivan broj");
    	}
        this.vrednostOcene = vrednostOcene;
    }

    /**
     * Vraca komponentu koja se ocenjuje.
     * 
     * @return Komponenta koja se ocenjuje kao klasa Komponenta.
     */
    public Komponenta getKomponenta() {
        return komponenta;
    }

    /**
     * Postavlja komponentu koja se ocenjuje.
     * 
     * @param komponenta Komponenta koja se ocenjuje kao klasa Komponenta.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     */
    public void setKomponenta(Komponenta komponenta) {
    	if(komponenta==null) {
    		throw new NullPointerException("Komponenta ima null vrednost");
    	}
        this.komponenta = komponenta;
    }

    /**
     * Vraca stress test na osnovu koga se vrsi ocena komponente.
     * 
     * @return Stress test kao klasa StressTest.
     */
    public StressTest getStressTest() {
        return stressTest;
    }

    /**
     * Postavlja vrednost stress testa na osnovu koga se vrsi ocena komponente.
     * 
     * @param stressTest Stress test kao klasa StressTest.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     */
    public void setStressTest(StressTest stressTest) {
    	if(stressTest==null) {
    		throw new NullPointerException("Stress test ima null vrednost");
    	}
        this.stressTest = stressTest;
    }

    /**
     * @return Vraca String ime tabele koje se nalazi u bazi podataka i koje odgovara klasi.
     */
    @Override
    public String getTableName() {
        return "ocena";
    }

    /**
     * @return Vraca String imena kolona u odgovarajucoj tabeli za dodavanje objekta u bazu.
     */
    @Override
    public String getColumnNamesForInsert() {
        return "KomponentaID,StressTestID,VrednostOcene";
    }

    /**
     * @return Vraca String koji predstavlja SQL kod za unos konkretnih vrednosti objekta u bazu.
     */
    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(getKomponenta().getKomponentaId()).append(",")
                .append(getStressTest().getStressTestId()).append(",")
                .append(getVrednostOcene());
        return sb.toString();
    }

    @Override
    public void setId(int id) {
    	// nije potrebno jer se primarni kljuc dobija preko Komponente i StressTest-a.
    }

    /**
     * @return Vraca String koji predstavlja SQL kod koji spaja vise tabela iz baze.
     */
    @Override
    public String getJoinTables() {
        // ne treba
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
        // ne treba
        return null;
    }

    /**
     * @return Vraca String koji predstavlja kriterijum brisanja postojecih vrednosti u bazi.
     */
    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("KomponentaID = ").append(getKomponenta().getKomponentaId())
                .append(" AND StressTestID = ").append(getStressTest().getStressTestId());
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja nove vrednosti koje ce biti zamenjene starim koje se vec nalaze u bazi.
     */
    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("VrednostOcene = ").append(getVrednostOcene());
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja kriterijum izmene postojecih vrednosti u bazi.
     */
    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("KomponentaID = ").append(getKomponenta().getKomponentaId())
                .append(" AND StressTestID = ").append(getStressTest().getStressTestId());
        return sb.toString();
    }

}
