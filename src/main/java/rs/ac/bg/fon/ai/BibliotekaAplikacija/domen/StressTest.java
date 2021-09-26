/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import java.sql.ResultSet;

/**
 *
 * @author DarkForce
 */
public class StressTest implements GenericEntity {

    private int stressTestId;
    private String nazivTesta;
    private String opisTesta;

    public StressTest() {
    }

    public StressTest(int stressTestId, String nazivTesta, String opisTesta) {
        setStressTestId(stressTestId);
        setNazivTesta(nazivTesta);
        setOpisTesta(opisTesta);
    }

    public String getOpisTesta() {
        return opisTesta;
    }

    public void setOpisTesta(String opisTesta) {
    	if(opisTesta==null) {
    		throw new NullPointerException("Opis stress testa ne sme biti null");
    	}
    	if(opisTesta.length()<5) {
    		throw new RuntimeException("Opis stress testa mora imati vise od 4 karaktera");
    	}
        this.opisTesta = opisTesta;
    }

    public int getStressTestId() {
        return stressTestId;
    }

    public void setStressTestId(int stressTestId) {
    	if(stressTestId < 0) {
    		throw new RuntimeException("Id stress testa mora biti pozitivan broj");
    	}
        this.stressTestId = stressTestId;
    }

    public String getNazivTesta() {
        return nazivTesta;
    }

    public void setNazivTesta(String nazivTesta) {
    	if(nazivTesta==null) {
    		throw new NullPointerException("Naziv stress testa ne sme biti null");
    	}
    	if(nazivTesta.length()<2) {
    		throw new RuntimeException("Naziv stress testa mora imati vise od 1 karaktera");
    	}
        this.nazivTesta = nazivTesta;
    }

    @Override
    public String toString() {
        return nazivTesta;
    }

    @Override
    public String getTableName() {
        return "stresstest";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "NazivTesta,OpisTesta";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(getNazivTesta()).append("','")
                .append(getOpisTesta()).append("'");
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        setStressTestId(id);
    }

    @Override
    public String getJoinTables() {
        return "";
    }

    @Override
    public String getLikeCriteria() {
        return "";
    }

    @Override
    public String getWhereCriteria() {
        return "";
    }

    @Override
    public GenericEntity getResponse(ResultSet rs) throws Exception {
        StressTest test = new StressTest(rs.getInt("StressTestID"),
                rs.getString("NazivTesta"),
                rs.getString("OpisTesta"));
        return test;
    }

    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("StressTestID = ").append(getStressTestId());
        return sb.toString();
    }

    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("NazivTesta = '").append(getNazivTesta())
                .append("', OpisTesta = '").append(getOpisTesta())
                .append("'");
        return sb.toString();
    }

    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("StressTestID = ").append(getStressTestId());
        return sb.toString();
    }

}
