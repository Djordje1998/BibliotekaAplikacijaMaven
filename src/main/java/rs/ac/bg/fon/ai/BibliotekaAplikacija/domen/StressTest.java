/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import java.sql.ResultSet;

/**
 * Klasa koje predstasvlja stres testove za komponente i racunara.
 * Svaki test ima jedinstvenog ID-a, naziva testa i detaljnih opisa testa.
 *
 * @author Djordje Novakovic
 * @version 1.0
 */
public class StressTest implements GenericEntity {

	/**
	 * ID stress testa kao int.
	 */
    private int stressTestId;
    
    /**
     * Naziv stress testa kao String.
     */
    private String nazivTesta;
    
    /**
     * Opis stress testa kao String.
     */
    private String opisTesta;

    /**
     * Konstruktor bez parametara koji inicijalizuje objekat.
     */
    public StressTest() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednosti za ID, naziv i opis testa.
     * 
     * @param stressTestId ID stress testa kao int.
     * @param nazivTesta Naziv stress testa kao String.
     * @param opisTesta Opis stress testa kao String.
     */
    public StressTest(int stressTestId, String nazivTesta, String opisTesta) {
        setStressTestId(stressTestId);
        setNazivTesta(nazivTesta);
        setOpisTesta(opisTesta);
    }

    /**
     * Vraca opis stress testa.
     * 
     * @return Opis stress testa kao String.
     */
    public String getOpisTesta() {
        return opisTesta;
    }

    /**
     * Postavlja novu vrednost za opis stress testa.
     * 
     * @param opisTesta Opis stress testa kao String.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     * @throws lava.lang.RuntimeException Ako je vrednost parametra String koji je kraci od 5 karaktera.
     */
    public void setOpisTesta(String opisTesta) {
    	if(opisTesta==null) {
    		throw new NullPointerException("Opis stress testa ne sme biti null");
    	}
    	if(opisTesta.length()<5) {
    		throw new RuntimeException("Opis stress testa mora imati vise od 4 karaktera");
    	}
        this.opisTesta = opisTesta;
    }

    /**
     * Vraca ID stress testa kao int.
     * 
     * @return ID stress testa kao int.
     */
    public int getStressTestId() {
        return stressTestId;
    }

    /**
     * Postavlja novu vrednost za ID stress testa.
     * 
     * @param stressTestId ID stress testa kao int.
     * 
     * @throws lava.lang.RuntimeException Ako je vrednost parametra int koji je negativan broj.
     */
    public void setStressTestId(int stressTestId) {
    	if(stressTestId < 0) {
    		throw new RuntimeException("Id stress testa mora biti pozitivan broj");
    	}
        this.stressTestId = stressTestId;
    }

    /**
     * Vraca naziv stress testa.
     * 
     * @return Naziv stress testa kao String.
     */
    public String getNazivTesta() {
        return nazivTesta;
    }

    /**
     * Postavlja novu vrednost za naziv stress testa.
     * 
     * @param nazivTesta Naziv stress testa kao String.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     * @throws lava.lang.RuntimeException Ako je vrednost parametra String koji je kraci od 2 karaktera.
     */
    public void setNazivTesta(String nazivTesta) {
    	if(nazivTesta==null) {
    		throw new NullPointerException("Naziv stress testa ne sme biti null");
    	}
    	if(nazivTesta.length()<2) {
    		throw new RuntimeException("Naziv stress testa mora imati vise od 1 karaktera");
    	}
        this.nazivTesta = nazivTesta;
    }

    /**
     * @return Vraca String sa nazivom stress testa.
     */
    @Override
    public String toString() {
        return nazivTesta;
    }

    /**
     * @return Vraca String ime tabele koje se nalazi u bazi podataka i koje odgovara klasi.
     */
    @Override
    public String getTableName() {
        return "stresstest";
    }

    /**
     * @return Vraca String imena kolona u odgovarajucoj tabeli za dodavanje objekta u bazu.
     */
    @Override
    public String getColumnNamesForInsert() {
        return "NazivTesta,OpisTesta";
    }

    /**
     * @return Vraca String koji predstavlja SQL kod za unos konkretnih vrednosti objekta u bazu.
     */
    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(getNazivTesta()).append("','")
                .append(getOpisTesta()).append("'");
        return sb.toString();
    }

    /**
     * Postavlja ID stress testa.
     * 
     * @param id ID stress testa kao int.
     */
    @Override
    public void setId(int id) {
        setStressTestId(id);
    }

    /**
     * @return Vraca String koji predstavlja SQL kod koji spaja vise tabela iz baze.
     */
    @Override
    public String getJoinTables() {
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
        StressTest test = new StressTest(rs.getInt("StressTestID"),
                rs.getString("NazivTesta"),
                rs.getString("OpisTesta"));
        return test;
    }

    /**
     * @return Vraca String koji predstavlja kriterijum brisanja postojecih vrednosti u bazi.
     */
    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("StressTestID = ").append(getStressTestId());
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja nove vrednosti koje ce biti zamenjene starim koje se vec nalaze u bazi.
     */
    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("NazivTesta = '").append(getNazivTesta())
                .append("', OpisTesta = '").append(getOpisTesta())
                .append("'");
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja kriterijum izmene postojecih vrednosti u bazi.
     */
    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("StressTestID = ").append(getStressTestId());
        return sb.toString();
    }

}
