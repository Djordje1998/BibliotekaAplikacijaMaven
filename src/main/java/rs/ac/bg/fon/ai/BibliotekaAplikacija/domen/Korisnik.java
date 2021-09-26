/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import java.sql.ResultSet;
import java.util.Objects;

import javax.management.RuntimeErrorException;

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
        setIme(ime);
        setPrezime(prezime);
        setKorisnickoIme(korisnickoIme);
        setSifra(sifra);
        setSifraPotvrda(sifraPotvrda);
    }

    public Korisnik(int korisnikId, String ime, String prezime, String korisnickoIme, String sifra) {
        setKorisnikId(korisnikId);
        setIme(ime);
        setPrezime(prezime);
        setKorisnickoIme(korisnickoIme);
        setSifra(sifra);
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
    	if(sifra==null) {
    		throw new NullPointerException("Sifra ne sme biti null");
    	}
    	if(sifra.length()<5) {
    		throw new RuntimeException("Sifra mora imati vise od 5 karaktera radi bezbednosti");
    	}
        this.sifra = sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
    	if(ime==null) {
    		throw new NullPointerException("Ime ne sme biti null");
    	}
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
    	if(prezime==null) {
    		throw new NullPointerException("Prezime ne sme biti null");
    	}
    	if(prezime.length()<2) {
    		throw new RuntimeException("Prezime mora imati vise od 2 karaktera");
    	}
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
    	if(korisnickoIme==null) {
    		throw new NullPointerException("Korisnicko ime ne sme biti null");
    	}
    	if(korisnickoIme.length()<2) {
    		throw new RuntimeException("Korisnicko ime mora imati vise od 2 karaktera");
    	}
        this.korisnickoIme = korisnickoIme;
    }

    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
    	if(korisnikId<0) {
    		throw new RuntimeException("Id korisnika mora biti pozitivan broj");
    	}
        this.korisnikId = korisnikId;
    }

    public String getSifraPotvrda() {
        return sifraPotvrda;
    }

    public void setSifraPotvrda(String sifraPotvrda) {
    	if(sifraPotvrda==null) {
    		throw new NullPointerException("Sifra ne sme biti null");
    	}
    	if(sifraPotvrda.length()<2) {
    		throw new RuntimeException("Sifra mora imati vise od 2 karaktera");
    	}
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
