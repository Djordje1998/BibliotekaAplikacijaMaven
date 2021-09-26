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
public class StavkaRacunara implements GenericEntity {

    private Racunar racunar;
    private int redniBroj;
    private Komponenta komponenta;
    private double cena;
    private int kolicina;
    private double ukupnaCena;
    private Date datumKreiranja;
    private Korisnik kreirao;

    public StavkaRacunara() {
    }

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

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
    	if(redniBroj < 0) {
    		throw new RuntimeException("Redni broj stavke mora biti pozitivan broj");
    	}
        this.redniBroj = redniBroj;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
    	if(cena < 0) {
    		throw new RuntimeException("Cena stavke mora biti pozitivan broj");
    	}
        this.cena = cena;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
    	if(datumKreiranja==null) {
    		throw new NullPointerException("Datum kreiranja stavke ne sme biti null");
    	}
        this.datumKreiranja = datumKreiranja;
    }

    public Korisnik getKreirao() {
        return kreirao;
    }

    public void setKreirao(Korisnik kreirao) {
    	if(kreirao==null) {
    		throw new NullPointerException("Korisnik koji kreira stavku ne sme biti null");
    	}
        this.kreirao = kreirao;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
    	if(kolicina < 0) {
    		throw new RuntimeException("Kolicina stavke mora biti pozitivan broj");
    	}
        this.kolicina = kolicina;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
    	if(ukupnaCena < 0) {
    		throw new RuntimeException("Ukupna cena stavke mora biti pozitivan broj");
    	}
        this.ukupnaCena = ukupnaCena;
    }

    public Racunar getRacunar() {
        return racunar;
    }

    public void setRacunar(Racunar racunar) {
    	if(racunar==null) {
    		throw new NullPointerException("Racunar stavke ne sme biti null");
    	}
        this.racunar = racunar;
    }

    public Komponenta getKomponenta() {
        return komponenta;
    }

    public void setKomponenta(Komponenta komponenta) {
    	if(komponenta==null) {
    		throw new NullPointerException("Komponenta stavke ne sme biti null");
    	}
        this.komponenta = komponenta;
    }

    @Override
    public String getTableName() {
        return "stavkeracunara";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "RacunarID,RB,KomponentaID,CenaKomada,Kolicina,UkupnaCena,DatumKreiranja,Kreirao";
    }

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
    }

    @Override
    public GenericEntity getResponse(ResultSet rs) throws Exception {
        TipKomponente tip = new TipKomponente(rs.getInt("TipKomponenteID"), rs.getString("NazivTipa"));
        Komponenta komponenta = new Komponenta(rs.getInt("KomponentaID"), rs.getString("NazivKomponente"), tip, rs.getDouble("Takt"), rs.getString("Opis"), rs.getDouble("Cena"));
        Korisnik kreirao = new Korisnik(rs.getInt("Kreirao"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("KorisnickoIme"), rs.getString("Lozinka"));
        StavkaRacunara stavka = new StavkaRacunara(racunar, rs.getInt("RB"), komponenta, rs.getDouble("CenaKomada"), rs.getInt("Kolicina"), rs.getDouble("UkupnaCena"), new Date(rs.getDate("DatumKreiranja").getTime()), kreirao);
        
        return stavka;
    }

    @Override
    public String getJoinTables() {
        return " s JOIN komponente k ON s.KomponentaID=k.KomponentaID JOIN korisnik kr ON s.Kreirao=kr.KorisnikID JOIN tipkomponente tip ON tip.TipKomponenteID=k.TipKomponenteID ";
    }

    @Override
    public String getWhereCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("WHERE s.RacunarID = ").append(getRacunar().getRacunarID());
        return sb.toString();
    }

    @Override
    public String getLikeCriteria() {
        return "";
    }

    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("RacunarID = ").append(getRacunar().getRacunarID());
        return sb.toString();
    }

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

    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("RacunarID = ").append(getRacunar().getRacunarID())
                .append(" AND RB =").append(getRedniBroj());
        return sb.toString();
    }

}
