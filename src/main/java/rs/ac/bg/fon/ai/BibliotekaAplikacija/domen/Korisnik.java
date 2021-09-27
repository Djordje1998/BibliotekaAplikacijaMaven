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
 * Klasa koja predstavlja korisnika i sadrzi ID koji je jedinstven za svakog korisnika.
 * Svaki korisnik sadrzi atribute ime, prezime, korisnicko ime, sifra i sifra potvrda.
 *
 * @author DarkForce
 * @version 1.0
 */
public class Korisnik implements GenericEntity {

	/**
	 * ID korisnika kao int.
	 */
    private int korisnikId;
    
    /**
     * Ime korisnika kao String.
     */
    private String ime;
    
    /**
     * Prezime korisnika kao String.
     */
    private String prezime;
    
    /**
     * Korisnicko ime korisnika kao String.
     */
    private String korisnickoIme;
    
    /**
     * Sifra korisnika kao String.
     */
    private String sifra;
    
    /**
     * Ponovljena sifra korisnika kao String.
     */
    private String sifraPotvrda;

    /**
     * Konstruktor bez parametara koji inicijalizuje objekat.
     */
    public Korisnik() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa.
     * 
     * @param ime Ime korisnika kao String.
     * @param prezime Prezime korisnika kao String.
     * @param korisnickoIme Korisnicko ime kao String.
     * @param sifra Sifra korisnika kao String.
     * @param sifraPotvrda Potvrdjena sifra korisnika kao String.
     */
    public Korisnik(String ime, String prezime, String korisnickoIme, String sifra, String sifraPotvrda) {
        setIme(ime);
        setPrezime(prezime);
        setKorisnickoIme(korisnickoIme);
        setSifra(sifra);
        setSifraPotvrda(sifraPotvrda);
    }

    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa osim atributa sifraPotvrda.
     * 
     * @param ime Ime korisnika kao String.
     * @param prezime Prezime korisnika kao String.
     * @param korisnickoIme Korisnicko ime kao String.
     * @param sifra Sifra korisnika kao String.
     */
    public Korisnik(int korisnikId, String ime, String prezime, String korisnickoIme, String sifra) {
        setKorisnikId(korisnikId);
        setIme(ime);
        setPrezime(prezime);
        setKorisnickoIme(korisnickoIme);
        setSifra(sifra);
    }

    /**
     * Vraca sifru korisnika.
     * 
     * @return Sifra korisnika kao String.
     */
    public String getSifra() {
        return sifra;
    }

    /**
     * Postavlja sifru korisnika.
     * 
     * @param sifra Sifra korisnika kao String.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     * @throws lava.lang.RuntimeException Ako je parametar String sa manje od 5 karaktera.
     */
    public void setSifra(String sifra) {
    	if(sifra==null) {
    		throw new NullPointerException("Sifra ne sme biti null");
    	}
    	if(sifra.length()<5) {
    		throw new RuntimeException("Sifra mora imati vise od 4 karaktera radi bezbednosti");
    	}
        this.sifra = sifra;
    }

    /**
     * Vraca ime korisnika.
     * 
     * @return Ime korisnika kao String.
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime korisnika.
     * 
     * @param ime Ime korisnika kao String.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     */
    public void setIme(String ime) {
    	if(ime==null) {
    		throw new NullPointerException("Ime ne sme biti null");
    	}
        this.ime = ime;
    }

    /**
     * Vraca prezime korisnika.
     * 
     * @return Prezime korisnika kao String.
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja prezime korisnika.
     * 
     * @param prezimePrezime korisnika kao String.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     * @throws lava.lang.RuntimeException Ako je vrednost parametra String sa manje od 2 karaktera.
     */
    public void setPrezime(String prezime) {
    	if(prezime==null) {
    		throw new NullPointerException("Prezime ne sme biti null");
    	}
    	if(prezime.length()<2) {
    		throw new RuntimeException("Prezime mora imati vise od 2 karaktera");
    	}
        this.prezime = prezime;
    }

    /**
     * Vraca korisnicko ime korisnika.
     * 
     * @return Korisnicko ime korisnika kao String.
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * Postavlja korisnicko ime korisnika.
     * 
     * @param korisnickoIme Korisnicko ime korisnika kao String.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     * @throws lava.lang.RuntimeException Ako je vrednost parametra String sa manje od 2 karaktera.
     */
    public void setKorisnickoIme(String korisnickoIme) {
    	if(korisnickoIme==null) {
    		throw new NullPointerException("Korisnicko ime ne sme biti null");
    	}
    	if(korisnickoIme.length()<2) {
    		throw new RuntimeException("Korisnicko ime mora imati vise od 2 karaktera");
    	}
        this.korisnickoIme = korisnickoIme;
    }

    /**
     * Vraca ID korisnika.
     * 
     * @return ID korisnika kao int.
     */
    public int getKorisnikId() {
        return korisnikId;
    }

    /**
     * Postavlja ID korisnika.
     * 
     * @param korisnikId ID korisnika kao int.
     * 
     * @throws lava.lang.RuntimeException Ako je vrednost parametra int manji od nule.
     */
    public void setKorisnikId(int korisnikId) {
    	if(korisnikId<0) {
    		throw new RuntimeException("Id korisnika mora biti pozitivan broj");
    	}
        this.korisnikId = korisnikId;
    }

    /**
     * Vraca potvrdjenu sifru korisnika.
     * 
     * @return Potvrdjena sifra korisnika kao String.
     */
    public String getSifraPotvrda() {
        return sifraPotvrda;
    }

    /**
     * Postavlja potvrdjenu sifru korisnika.
     * 
     * @param sifraPotvrda Potvrdjena sifra korisnika kao String.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     * @throws lava.lang.RuntimeException Ako je vrednost parametra String kraci od dva karaktera.
     */
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

    /**
     * Poredi dva korisnika i vraca true ako su isti, u suprotnom vraca false.
     * Poredjenje se vrsi po ID, ime, prezime, koriscniko ime i sifra korisnika.
     * 
     * @return 
     * <ul>
     * 	<li>true Ako su oba objekta tipa klase Korisnik i ako imaju iste vrednosti atributa ID, ime, prezime, koriscniko ime i sifra.</li>
     * 	<li>false U svi ostalim slucajevima.</li>
     * </ul> 
     */
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

    /**
     * @return Vraca String sa imenom i prezimenom korisnika.
     */
    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    /**
     * @return Vraca String ime tabele koje se nalazi u bazi podataka i koje odgovara klasi.
     */
    @Override
    public String getTableName() {
        return "korisnik";
    }

    /**
     * @return Vraca String imena kolona u odgovarajucoj tabeli za dodavanje objekta u bazu.
     */
    @Override
    public String getColumnNamesForInsert() {
        return "Ime,Prezime,KorisnickoIme,Lozinka";
    }

    /**
     * @return Vraca String koji predstavlja SQL kod za unos konkretnih vrednosti objekta u bazu.
     */
    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(getIme()).append("','")
                .append(getPrezime()).append("','")
                .append(getKorisnickoIme()).append("','")
                .append(String.valueOf(getSifra().hashCode())).append("'");
        return sb.toString();
    }

    /**
     * Postavlja ID korisnika.
     * 
     * @param id ID korisnika kao int.
     */
    @Override
    public void setId(int id) {
        setKorisnikId(id);
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
        if (getKorisnickoIme() == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(" WHERE KorisnickoIme = '").append(getKorisnickoIme())
                .append("' AND Lozinka = '").append(String.valueOf(getSifra().hashCode()))
                .append("'");
        return sb.toString();

    }

    /**
     * @return GenericEntity u kome se nalaze vrednosti kao odgovor query-ja iz baze.
     */
    @Override
    public GenericEntity getResponse(ResultSet rs) throws Exception {
        Korisnik korisnik = new Korisnik(rs.getInt("KorisnikID"),
                rs.getString("Ime"),
                rs.getString("Prezime"),
                rs.getString("KorisnickoIme"),
                rs.getString("Lozinka"));
        return korisnik;
    }

    /**
     * @return Vraca String koji predstavlja kriterijum brisanja postojecih vrednosti u bazi.
     */
    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("KorisnikID = ").append(getKorisnikId());
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja nove vrednosti koje ce biti zamenjene starim koje se vec nalaze u bazi.
     */
    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ime = '").append(getIme())
                .append("', Prezime = '").append(getPrezime())
                .append("', KorisnickoIme = '").append(getKorisnickoIme())
                .append("', Lozinka = '").append(String.valueOf(getSifra().hashCode())).append("'");
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja kriterijum izmene postojecih vrednosti u bazi.
     */
    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("KorisnikID = ").append(getKorisnikId());
        return sb.toString();
    }

}
