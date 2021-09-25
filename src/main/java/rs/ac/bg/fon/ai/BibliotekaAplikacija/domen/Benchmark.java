/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author DarkForce
 */
public class Benchmark implements GenericEntity {

    private int benchmarkId;
    private Date datumBenchmarka;
    private double bodoviPrvogRacunara;
    private double bodoviDrugogRacunara;
    private Racunar prviRacunar;
    private Racunar drugiRacunar;
    private StressTest stressTest;

    public Benchmark() {
    }

    public Benchmark(int benchmarkId, Date datumBenchmarka, double bodoviPrvogRacunara, double bodoviDrugogRacunara, Racunar prviRacunar, Racunar drugiRacunar, StressTest stressTest) {
        this.benchmarkId = benchmarkId;
        this.datumBenchmarka = datumBenchmarka;
        this.bodoviPrvogRacunara = bodoviPrvogRacunara;
        this.bodoviDrugogRacunara = bodoviDrugogRacunara;
        this.prviRacunar = prviRacunar;
        this.drugiRacunar = drugiRacunar;
        this.stressTest = stressTest;
    }

    public StressTest getStressTest() {
        return stressTest;
    }

    public void setStressTest(StressTest stressTest) {
        this.stressTest = stressTest;
    }

    public int getBenchmarkId() {
        return benchmarkId;
    }

    public void setBenchmarkId(int benchmarkId) {
        this.benchmarkId = benchmarkId;
    }

    public Date getDatumBenchmarka() {
        return datumBenchmarka;
    }

    public void setDatumBenchmarka(Date datumBenchmarka) {
        this.datumBenchmarka = datumBenchmarka;
    }

    public double getBodoviPrvogRacunara() {
        return bodoviPrvogRacunara;
    }

    public void setBodoviPrvogRacunara(double bodoviPrvogRacunara) {
        this.bodoviPrvogRacunara = bodoviPrvogRacunara;
    }

    public double getBodoviDrugogRacunara() {
        return bodoviDrugogRacunara;
    }

    public void setBodoviDrugogRacunara(double bodoviDrugogRacunara) {
        this.bodoviDrugogRacunara = bodoviDrugogRacunara;
    }

    public Racunar getPrviRacunar() {
        return prviRacunar;
    }

    public void setPrviRacunar(Racunar prviRacunar) {
        this.prviRacunar = prviRacunar;
    }

    public Racunar getDrugiRacunar() {
        return drugiRacunar;
    }

    public void setDrugiRacunar(Racunar drugiRacunar) {
        this.drugiRacunar = drugiRacunar;
    }

    @Override
    public String getTableName() {
        return "benchmark";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "DatumBenchmarka,BodoviPrvogRacunara,BodoviDrugogRacunara,RacunarID1,RacunarID2,StressTestID";
    }

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

    @Override
    public void setId(int id) {
        setBenchmarkId(id);
    }

    @Override
    public String getJoinTables() {
        // to do
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
        // to do
        return null;
    }

    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("BenchmarkID = ").append(getBenchmarkId());
        return sb.toString();
    }

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

    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("BenchmarkID = ").append(getBenchmarkId());
        return sb.toString();
    }

}
