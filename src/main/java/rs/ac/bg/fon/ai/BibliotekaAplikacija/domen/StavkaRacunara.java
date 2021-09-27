/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import java.sql.ResultSet;
import java.util.Date;

/**
 *Klasa koja predstavlja slab objekat racunara, u kojoj su polja racunar i redni broj sluzeni kljuc.
 *Klasa sadrzi reference racunara, komponente i korisnika koji ju je kreirao.
 *Svaka stavka pored referenci ima datum, cenu i kolicinu i ukupnu cenu kao proizvod te dve vrednosti.
 *
 * @author Djordje Novakovic
 * @version 1.0
 */
public class StavkaRacunara implements GenericEntity {

	/**
	 * Racunar kom pripada stavka kao tip domenske klase Racunar.
	 */
    private Racunar racunar;
    
    /**
     * Redni broj stavke u racunaru kao int.
     */
    private int redniBroj;
    
    /**
     * Komponenta koju predstavlja stavka racuanra kao tip domenske klase Komponenta.
     */
    private Komponenta komponenta;
    
    /**
     * Cena stavke racunara kao double.
     */
    private double cena;
    
    /**
     * Kolicina stavki kao int.
     */
    private int kolicina;
    
    /**
     * Ukupna cena stavke, proizvod cene i klicine, kao double.
     */
    private double ukupnaCena;
    
    /**
     * Datum kreranja stavke racuinara kao Date.
     */
    private Date datumKreiranja;
    
    /**
     * Korisnik koji je kreirao stavku kao tip domenske klase Korisnik.
     */
    private Korisnik kreirao;

    /**
     * Konstruktor bez parametara koji inicijalizuje objekat.
     */
    public StavkaRacunara() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat i potavlja vrednosti svih polja klase.
     * 
     * @param racunar Racuanar kom pripada stavka kao domenska klasa Racunar.
     * @param redniBroj Redni broj stavke u racunaru kao int.
     * @param komponenta Komponenta stavke kao domenska klasa Komponenta.
     * @param cena Cena stavke racunara kao double.
     * @param kolicina Kolicina stavke kao int.
     * @param ukupnaCena Ukupna cena stavke kao double.
     * @param datumKreiranja Datum kreiranje stavke kao Date.
     * @param kreirao Korisnik koji je kreirao stavku kao domenska klasa Korisnik.
     */
    public StavkaRacunara(Racunar racunar, int redniBroj, Komponenta komponenta, double cena, int kolicina, double ukupnaCena, Date datumKreiranja, Korisnik kreirao) {
        setRacunar(racunar);
        setRedniBroj(redniBroj);
        setKomponenta(komponenta);
        setCena(cena);
        setKolicina(kolicina);
        setUkupnaCena(ukupnaCena);
        setDatumKreiranja(datumKreiranja);
        setKreirao(kreirao);
    }

    /**
     * Vraca redni broj stavke racunara.
     * 
     * @return Redni broj kao int.
     */
    public int getRedniBroj() {
        return redniBroj;
    }

    /**
     * Postavlja novu vrednost rednog broja stavke.
     * 
     * @param redniBroj Redni broj kao int.
     * 
     * @throws java.lang.RuntimeException Ako je redni broj vrednost int manja od nule.
     */
    public void setRedniBroj(int redniBroj) {
    	if(redniBroj < 0) {
    		throw new RuntimeException("Redni broj stavke mora biti pozitivan broj");
    	}
        this.redniBroj = redniBroj;
    }

    /**
     * Vraca cenu stavke racunara
     * 
     * @return Cena stavke racunara kao double.
     */
    public double getCena() {
        return cena;
    }

    /**
     * Postavlja novu vrednost cene stavke racunara.
     * 
     * @param cena Cena stavke racunara kao double.
     * 
     * @throws java.lang.RuntimeException Ako je parametar vrednost int manja od nule.
     */
    public void setCena(double cena) {
    	if(cena < 0) {
    		throw new RuntimeException("Cena stavke mora biti pozitivan broj");
    	}
        this.cena = cena;
    }

    /**
     * Vraca datum kreiranja stavke racunara.
     * 
     * @return Datum kreiranja stavke racunara kao Date.
     */
    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    /**
     * Postavlja novu vrednost datuma kreiranja stavke racunara.
     * 
     * @param datumKreiranja Datum kreiranja stavke kao Date.
     * 
     * @throws java.lang.NullPointerException Ako je parametar null vrednost.
     */
    public void setDatumKreiranja(Date datumKreiranja) {
    	if(datumKreiranja==null) {
    		throw new NullPointerException("Datum kreiranja stavke ne sme biti null");
    	}
        this.datumKreiranja = datumKreiranja;
    }

    /**
     * Vraca korisnika koji je krirao stavku racunara.
     * 
     * @return Korisnik koji je kreirao stavku racunara kao klasa Kornisk.
     */
    public Korisnik getKreirao() {
        return kreirao;
    }

    /**
     * Poistavlja novog korisnika koji je kreirao stavku racunara.
     * 
     * @param kreirao Korisnik koji je kreirao stavku kao klasa Korisnik.
     * 
     * @throws java.lang.NullPointerException Ako je parametar null vrednost.
     */
    public void setKreirao(Korisnik kreirao) {
    	if(kreirao==null) {
    		throw new NullPointerException("Korisnik koji kreira stavku ne sme biti null");
    	}
        this.kreirao = kreirao;
    }

    /**
     * Vraca kolicnu stavke racunara. 
     * 
     * @return Kolicnu stavke racunara kao int.
     */
    public int getKolicina() {
        return kolicina;
    }

    /**
     * Postavlja kolicinu stavke racunara.
     * 
     * @param kolicina Kolicina stavke racunara kao int.
     * 
     * @throws java.lang.RuntimeException Ako je parametar int vrednost manaj od nula.
     */
    public void setKolicina(int kolicina) {
    	if(kolicina < 0) {
    		throw new RuntimeException("Kolicina stavke mora biti pozitivan broj");
    	}
        this.kolicina = kolicina;
    }

    /**
     * Vraca ukupnu cenu stavke racunara.
     * 
     * @return Ukupna cena stavke racunara kao double.
     */
    public double getUkupnaCena() {
        return ukupnaCena;
    }

    /**
     * Postavlja vrednost ukupne cene stavke racunara.
     * 
     * @param ukupnaCena Ukupna cena stasvke racunara kao double.
     * 
     * @throws java.lang.RuntimeException Ako je paremtar double vrednost manja od nula.
     */
    public void setUkupnaCena(double ukupnaCena) {
    	if(ukupnaCena < 0) {
    		throw new RuntimeException("Ukupna cena stavke mora biti pozitivan broj");
    	}
        this.ukupnaCena = ukupnaCena;
    }

    /**
     * Vraca racunar na koji se odnosi stavka racunara.
     * 
     * @return Racunar stavke racunara kao klasa Racunar.
     */
    public Racunar getRacunar() {
        return racunar;
    }

    /**
     * Potavlja racunar stavke racunara.
     * 
     * @param racunar Racunar stavke racuanra kao klasa Racunar.
     * 
     * @throws java.lang.NullPointerException Ako je parametar null vrednost.
     */
    public void setRacunar(Racunar racunar) {
    	if(racunar==null) {
    		throw new NullPointerException("Racunar stavke ne sme biti null");
    	}
        this.racunar = racunar;
    }

    /**
     * Vraca komponentu stavke racunara.
     * 
     * @return Komponenta stavke racuanra kao klasa Komponenta.
     */
    public Komponenta getKomponenta() {
        return komponenta;
    }

    /**
     * Postavlja komponetu stavke racunara.
     * 
     * @param komponenta Komponenta stavke racunara koa klasa Komponenta.
     * 
     * @throws java.lang.NullPointerException Ako je parametar null vrednost.
     */
    public void setKomponenta(Komponenta komponenta) {
    	if(komponenta==null) {
    		throw new NullPointerException("Komponenta stavke ne sme biti null");
    	}
        this.komponenta = komponenta;
    }

    /**
     * @return Vraca String ime tabele koje se nalazi u bazi podataka i koje odgovara klasi.
     */
    @Override
    public String getTableName() {
        return "stavkeracunara";
    }

    /**
     * @return Vraca String imena kolona u odgovarajucoj tabeli za dodavanje objekta u bazu.
     */
    @Override
    public String getColumnNamesForInsert() {
        return "RacunarID,RB,KomponentaID,CenaKomada,Kolicina,UkupnaCena,DatumKreiranja,Kreirao";
    }

    /**
     * @return Vraca String koji predstavlja SQL kod za unos konkretnih vrednosti objekta u bazu.
     */
    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(getRacunar().getRacunarID()).append(",")
                .append(getRedniBroj()).append(",")
                .append(getKomponenta().getKomponentaId()).append(",")
                .append(getCena()).append(",")
                .append(getKolicina()).append(",")
                .append(getUkupnaCena()).append(",'")
                .append(new java.sql.Date(getDatumKreiranja().getTime())).append("',")
                .append(getKreirao().getKorisnikId());
        return sb.toString();
    }

 
    @Override
    public void setId(int id) {
    	// nije potrebno jer se dobija preko racunara koji je jak objeka
    }

    /**
     * @return Vraca String koji predstavlja SQL kod koji spaja vise tabela iz baze.
     */
    @Override
    public GenericEntity getResponse(ResultSet rs) throws Exception {
        TipKomponente tip = new TipKomponente(rs.getInt("TipKomponenteID"), rs.getString("NazivTipa"));
        Komponenta komponenta = new Komponenta(rs.getInt("KomponentaID"), rs.getString("NazivKomponente"), tip, rs.getDouble("Takt"), rs.getString("Opis"), rs.getDouble("Cena"));
        Korisnik kreirao = new Korisnik(rs.getInt("Kreirao"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("KorisnickoIme"), rs.getString("Lozinka"));
        StavkaRacunara stavka = new StavkaRacunara(racunar, rs.getInt("RB"), komponenta, rs.getDouble("CenaKomada"), rs.getInt("Kolicina"), rs.getDouble("UkupnaCena"), new Date(rs.getDate("DatumKreiranja").getTime()), kreirao);
        
        return stavka;
    }

    /**
     * @return Vraca String koji predstavlja kriterijum pretrage koji se dobija u query-ju od baze.
     */
    @Override
    public String getJoinTables() {
        return " s JOIN komponente k ON s.KomponentaID=k.KomponentaID JOIN korisnik kr ON s.Kreirao=kr.KorisnikID JOIN tipkomponente tip ON tip.TipKomponenteID=k.TipKomponenteID ";
    }

    /**
     * @return Vraca String koji predstavlja kriterijum pretrage postojecih vrednosti u bazi.
     */
    @Override
    public String getWhereCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("WHERE s.RacunarID = ").append(getRacunar().getRacunarID());
        return sb.toString();
    }

    /**
     * @return GenericEntity u kome se nalaze vrednosti kao odgovor query-ja iz baze.
     */
    @Override
    public String getLikeCriteria() {
        return "";
    }

    /**
     * @return Vraca String koji predstavlja kriterijum brisanja postojecih vrednosti u bazi.
     */
    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("RacunarID = ").append(getRacunar().getRacunarID());
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja nove vrednosti koje ce biti zamenjene starim koje se vec nalaze u bazi.
     */
    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("RacunarID = ").append(getRacunar().getRacunarID())
                .append(", RB = ").append(getRedniBroj())
                .append(", KomponentaID = ").append(getKomponenta().getKomponentaId())
                .append(", CenaKomada = ").append(getCena())
                .append(", Kolicina = ").append(getKolicina())
                .append(", UkupnaCena = ").append(getUkupnaCena())
                .append(", DatumKreiranja = '").append(new java.sql.Date(getDatumKreiranja().getTime()))
                .append("', Kreirao = ").append(getKreirao().getKorisnikId());
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja kriterijum izmene postojecih vrednosti u bazi.
     */
    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("RacunarID = ").append(getRacunar().getRacunarID())
                .append(" AND RB =").append(getRedniBroj());
        return sb.toString();
    }

}
