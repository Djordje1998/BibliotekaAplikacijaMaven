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
public class Ocena implements GenericEntity {

    private Komponenta komponenta;
    private StressTest stressTest;
    private double vrednostOcene;

    public Ocena() {
    }

    public Ocena(Komponenta komponenta, StressTest stressTest, double vrednostOcene) {
        setKomponenta(komponenta);
        setStressTest(stressTest);
        setVrednostOcene(vrednostOcene);
    }

    public double getVrednostOcene() {
        return vrednostOcene;
    }

    public void setVrednostOcene(double vrednostOcene) {
    	if(vrednostOcene<0) {
    		throw new RuntimeException("Vrednost ocene mora biti pozitivan broj");
    	}
        this.vrednostOcene = vrednostOcene;
    }

    public Komponenta getKomponenta() {
        return komponenta;
    }

    public void setKomponenta(Komponenta komponenta) {
    	if(komponenta==null) {
    		throw new NullPointerException("Komponenta ima null vrednost");
    	}
        this.komponenta = komponenta;
    }

    public StressTest getStressTest() {
        return stressTest;
    }

    public void setStressTest(StressTest stressTest) {
    	if(stressTest==null) {
    		throw new NullPointerException("Stress test ima null vrednost");
    	}
        this.stressTest = stressTest;
    }

    @Override
    public String getTableName() {
        return "ocena";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "KomponentaID,StressTestID,VrednostOcene";
    }

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
    }

    @Override
    public String getJoinTables() {
        // ne treba
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
        // ne treba
        return null;
    }

    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("KomponentaID = ").append(getKomponenta().getKomponentaId())
                .append(" AND StressTestID = ").append(getStressTest().getStressTestId());
        return sb.toString();
    }

    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("VrednostOcene = ").append(getVrednostOcene());
        return sb.toString();
    }

    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("KomponentaID = ").append(getKomponenta().getKomponentaId())
                .append(" AND StressTestID = ").append(getStressTest().getStressTestId());
        return sb.toString();
    }

}
