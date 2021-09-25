/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import java.sql.ResultSet;
import java.util.Objects;

/**
 *
 * @author DarkForce
 */
public class Korisnik implements GenericEntity {

    private int korisnikId;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String sifra;
    private String sifraPotvrda;

    public Korisnik() {
    }

    public Korisnik(String ime, String prezime, String korisnickoIme, String sifra, String sifraPotvrda) {
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.sifraPotvrda = sifraPotvrda;
    }

    public Korisnik(int korisnikId, String ime, String prezime, String korisnickoIme, String sifra) {
        this.korisnikId = korisnikId;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getSifraPotvrda() {
        return sifraPotvrda;
    }

    public void setSifraPotvrda(String sifraPotvrda) {
        this.sifraPotvrda = sifraPotvrda;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.sifra);
        return hash;
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
        final Korisnik other = (Korisnik) obj;
        if (this.korisnikId != other.korisnikId) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.sifra, other.sifra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getTableName() {
        return "korisnik";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "Ime,Prezime,KorisnickoIme,Lozinka";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(getIme()).append("','")
                .append(getPrezime()).append("','")
                .append(getKorisnickoIme()).append("','")
                .append(String.valueOf(getSifra().hashCode())).append("'");
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        setKorisnikId(id);
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
        if (getKorisnickoIme() == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(" WHERE KorisnickoIme = '").append(getKorisnickoIme())
                .append("' AND Lozinka = '").append(String.valueOf(getSifra().hashCode()))
                .append("'");
        return sb.toString();

    }

    @Override
    public GenericEntity getResponse(ResultSet rs) throws Exception {
        Korisnik korisnik = new Korisnik(rs.getInt("KorisnikID"),
                rs.getString("Ime"),
                rs.getString("Prezime"),
                rs.getString("KorisnickoIme"),
                rs.getString("Lozinka"));
        return korisnik;
    }

    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("KorisnikID = ").append(getKorisnikId());
        return sb.toString();
    }

    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ime = '").append(getIme())
                .append("', Prezime = '").append(getPrezime())
                .append("', KorisnickoIme = '").append(getKorisnickoIme())
                .append("', Lozinka = '").append(String.valueOf(getSifra().hashCode())).append("'");
        return sb.toString();
    }

    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("KorisnikID = ").append(getKorisnikId());
        return sb.toString();
    }

}
