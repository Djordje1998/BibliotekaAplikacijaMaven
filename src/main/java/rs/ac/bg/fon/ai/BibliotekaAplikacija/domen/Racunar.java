/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DarkForce
 */
public class Racunar implements GenericEntity {

    private int racunarID;
    private String nazivRacunara;
    private String namena;
    private Date garancija;
    private double ukupnaCena;
    private ArrayList<StavkaRacunara> stavke;

    public Racunar() {
        this.stavke = new ArrayList<>();
    }

    public Racunar(int racunarID, String nazivRacunara, String namena, Date garancija, double ukupnaCena) {
        this.racunarID = racunarID;
        this.nazivRacunara = nazivRacunara;
        this.namena = namena;
        this.garancija = garancija;
        this.ukupnaCena = ukupnaCena;
        this.stavke = new ArrayList<>();
    }

    public Date getGarancija() {
        return garancija;
    }

    public void setGarancija(Date garancija) {
        this.garancija = garancija;
    }

    public int getRacunarID() {
        return racunarID;
    }

    public void setRacunarID(int racunarID) {
        this.racunarID = racunarID;
    }

    public String getNazivRacunara() {
        return nazivRacunara;
    }

    public void setNazivRacunara(String nazivRacunara) {
        this.nazivRacunara = nazivRacunara;
    }

    public String getNamena() {
        return namena;
    }

    public void setNamena(String namena) {
        this.namena = namena;
    }

    @Override
    public String toString() {
        return nazivRacunara;
    }

    public ArrayList<StavkaRacunara> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<StavkaRacunara> stavke) {
        this.stavke = stavke;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Racunar other = (Racunar) obj;
        if (this.racunarID != other.racunarID) {
            return false;
        }
        return true;
    }

    public int oceni(StressTest test) {
        int suma = 0;
        for (StavkaRacunara stavka : getStavke()) {
            suma += stavka.getKomponenta().oceni(test);
        }
        return suma;
    }

    public static String vratiZakljucak(int prva, int druga) {
        if (prva > druga) {
            return "Komponente prvog racunara su jace od komponenti drugog racunara.";
        }
        if (druga > prva) {
            return "Komponente drugog racunara su jace od komponenti prvog racunara.";
        }
        return "Komponente racunara su jednake jacine.";
    }

    @Override
    public String getTableName() {
        return "racunar ";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "NazivRacunara,Namena,Garancija,UkupnaCena";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(getNazivRacunara()).append("','")
                .append(getNamena()).append("','")
                .append(new java.sql.Date(getGarancija().getTime())).append("',")
                .append(getUkupnaCena());
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        setRacunarID(id);
    }

    @Override
    public GenericEntity getResponse(ResultSet rs) throws Exception {
        Racunar racunar = new Racunar(rs.getInt("RacunarID"),
                rs.getString("NazivRacunara"),
                rs.getString("Namena"),
                new Date(rs.getDate("Garancija").getTime()),
                rs.getDouble("UkupnaCena"));
        return racunar;
    }

    @Override
    public String getJoinTables() {
        return "";
    }

    @Override
    public String getWhereCriteria() {
        return "WHERE NazivRacunara";
    }

    @Override
    public String getLikeCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append(" LIKE '%").append(getNazivRacunara()).append("%'");
        return sb.toString();
    }

    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("RacunarID = ").append(getRacunarID());
        return sb.toString();
    }

    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("NazivRacunara = '").append(getNazivRacunara())
                .append("', Namena = '").append(getNamena())
                .append("', Garancija = '").append(new java.sql.Date(getGarancija().getTime()))
                .append("', UkupnaCena = ").append(getUkupnaCena());
        return sb.toString();
    }

    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("RacunarID = ").append(getRacunarID());
        return sb.toString();
    }

}
