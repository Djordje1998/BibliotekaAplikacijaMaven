/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import java.sql.ResultSet;
import java.util.Objects;

/**
 * Klasa koja predstavlja komponentu i sadrzi ID koji je jedinstven za svaku komponentu.
 * Svaka komponenta poseduje naziv kompoente, takt, opis, cenu i tip komponente kao referenca klase TipKOmponente.
 *
 * @author Djordje Novakovic
 * @version 1.0
 */
public class Komponenta implements GenericEntity {

	/**
	 * ID komponenta kao int.
	 */
    private int komponentaId;

    /**
     * Naziv komponente kao String.
     */
    private String nazivKomponente;
    
    /**
     * Tip komponente kao klasa TipKomponente.
     */
    private TipKomponente tipKomponente;
    
    /**
     * Takt komponente kao double.
     */
    private double takt;
    
    /**
     * Opis komponente kao String.
     */
    private String opis;
    
    /**
     * Cena komponente kao double.
     */
    private double cena;

    /**
     * Konstruktor bez parametara koji inicijalizuje objekat.
     */
    public Komponenta() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa komponente.
     * 
     * @param komponentaId ID komponenta kao int.
     * @param nazivKomponente Naziv komponente kao String.
     * @param tipKomponente Tip komponente kao klasa TipKomponente.
     * @param takt Takt komponente kao double.
     * @param opis Opis komponente kao String.
     * @param cena Cena komponente kao double.
     */
    public Komponenta(int komponentaId, String nazivKomponente, TipKomponente tipKomponente, double takt, String opis, double cena) {
        setKomponentaId(komponentaId);
        setNazivKomponente(nazivKomponente);
        setTipKomponente(tipKomponente);
        setTakt(takt);
        setOpis(opis);
        setCena(cena);
    }

    /**
     * Vraca takt komponente.
     *  
     * @return Takt komponente kao double.
     */
    public double getTakt() {
        return takt;
    }

    /**
     * Postavlja takt komponente.
     * 
     * @param takt Takt komponente kao double.
     * 
     * @throws lava.lang.RuntimeException AKo je parametar double vrednost koja je manja od nule.
     */
    public void setTakt(double takt) {
    	if(takt < 0) {
    		throw new RuntimeException("Takt mora biti pozitivan broj");
    	}
        this.takt = takt;
    }

    /**
     * Vraca ID komponente.
     * 
     * @return ID komponente kao int.
     */
    public int getKomponentaId() {
        return komponentaId;
    }

    /**
     * Postavlja ID komponente.
     * 
     * @param komponentaId ID komponente kao int.
     * 
     * @throws lava.lang.RuntimeException AKo je parametar int vrednost koja je manja od nule.
     */
    public void setKomponentaId(int komponentaId) {
    	if(komponentaId < 0) {
    		throw new RuntimeException("Id komponente mora biti pozitivan broj");
    	}
        this.komponentaId = komponentaId;
    }

    /**
     * Vraca naziv komponente. 
     * 
     * @return Naziv komponente kao String.
     */
    public String getNazivKomponente() {
        return nazivKomponente;
    }

    /**
     * Postavlja naziv komponente.
     * 
     * @param nazivKomponente Naziv komponente kao String.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     */
    public void setNazivKomponente(String nazivKomponente) {
    	if(nazivKomponente==null) {
    		throw new NullPointerException("Naziv komponente ne sme biti null");
    	}
        this.nazivKomponente = nazivKomponente;
    }

    /**
     * Vraca koji tip predstavlja komponenta.
     * 
     * @return Tip komponente kao klasa TipKomponenta.
     */
    public TipKomponente getTipKomponente() {
        return tipKomponente;
    }

    /**
     * Postavlja tip koji predstavlja komponenta. 
     * 
     * @param tipKomponente Tip komponente kao klasa TipKomponenta.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     */
    public void setTipKomponente(TipKomponente tipKomponente) {
    	if(tipKomponente==null) {
    		throw new NullPointerException("Tip komponente ne sme biti null");
    	}
        this.tipKomponente = tipKomponente;
    }

    /**
     * Vraca opis komponente.
     * 
     * @return Opis komponente kao String.
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Postavlja opis komponente.
     * 
     * @param opis Opis komponente kao String.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     * @throws lava.lang.RuntimeException Ako je parametar String kraci od 5 karaktera.
     */
    public void setOpis(String opis) {
    	if(opis==null) {
    		throw new NullPointerException("Opis komponente ne sme biti null");
    	}
    	if(opis.length()<5) {
    		throw new RuntimeException("Opis komponente mora imati vise od 4 karaktera ");
    	}
        this.opis = opis;
    }

    /**
     * Vraca cenu komponente.
     * 
     * @return Cena komponente kao double.
     */
    public double getCena() {
        return cena;
    }

    /**
     * Postavlja cenu komponente.
     * 
     * @param cena Cena komponente kao double.
     * 
     * @throws lava.lang.RuntimeException Ako je parametar double manji od nule.
     */
    public void setCena(double cena) {
    	if(cena < 0) {
    		throw new RuntimeException("Cena komponente mora biti pozitivan broj");
    	}
        this.cena = cena;
    }

    /**
     * @return Vraca String sa nazivom komponente.
     */
    @Override
    public String toString() {
        return nazivKomponente;
    }

    /**
     * Ocenjuje komponentu u zavisnosti od stress testa koji prima kao parametar
     * 
     * @param test Stress test kao klasa StressTest
     * @return Vraca ocenu koju je komponenta dobijla za dati test kao int.
     */
    public int oceni(StressTest test) {
        return (int) (takt * 1.33 * test.getNazivTesta().length() / 3.77);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Poredi dve komponente i vraca true ako su isti, u suprotnom vraca false.
     * Poredjenje se vrsi po atributima ID, takt, naziv komponente i tip komponente.
     * 
     * @return 
     * <ul>
     * 	<li>true Ako su oba objekta tipa klase Komponenta i ako imaju isti vrednosti naosnovu kojih se porede.</li>
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
        final Komponenta other = (Komponenta) obj;
        if (this.komponentaId != other.komponentaId) {
            return false;
        }
        if (Double.doubleToLongBits(this.takt) != Double.doubleToLongBits(other.takt)) {
            return false;
        }
        if (!Objects.equals(this.nazivKomponente, other.nazivKomponente)) {
            return false;
        }
        if (!Objects.equals(this.tipKomponente, other.tipKomponente)) {
            return false;
        }
        return true;
    }

    /**
     * Static metoda koja vraca zakljucak kao String u zavisnosti od prve i druge ocene.
     * 
     * @param prva Ocena prve komponente kao int.
     * @param druga Ocena druge komponente kao int.
     * @return Zakljucak kao String.
     */
    public static String vratiZakljucak(int prva, int druga) {
        if (prva > druga) {
            return "Prva komponenta je jaca od druge.";
        }
        if (druga > prva) {
            return "Druga komponenta je jaca od prve.";
        }
        return "Komponente su jednake jacine.";
    }

    /**
     * @return Vraca String ime tabele koje se nalazi u bazi podataka i koje odgovara klasi.
     */
    @Override
    public String getTableName() {
        return "komponente";
    }

    /**
     * @return Vraca String imena kolona u odgovarajucoj tabeli za dodavanje objekta u bazu.
     */
    @Override
    public String getColumnNamesForInsert() {
        return "NazivKomponente,TipKomponenteID,Takt,Opis,Cena";
    }

    /**
     * @return Vraca String koji predstavlja SQL kod za unos konkretnih vrednosti objekta u bazu.
     */
    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(getNazivKomponente()).append("',")
                .append(getTipKomponente().getTipKomponenteID()).append(",")
                .append(getTakt()).append(",'")
                .append(getOpis()).append("',")
                .append(getCena()).append("");
        return sb.toString();
    }

    /**
     * Postavlja ID komponente.
     * 
     * @param id ID komponente kao int.
     */
    @Override
    public void setId(int id) {
        setKomponentaId(id);
    }

    /**
     * @return GenericEntity u kome se nalaze vrednosti kao odgovor query-ja iz baze.
     */
    @Override
    public GenericEntity getResponse(ResultSet rs) throws Exception {
        TipKomponente tip = new TipKomponente(rs.getInt("TipKomponenteID"),
                rs.getString("NazivTipa"));
        Komponenta k = new Komponenta(rs.getInt("KomponentaID"),
                rs.getString("NazivKomponente"),
                tip,
                rs.getDouble("Takt"),
                rs.getString("Opis"),
                rs.getDouble("Cena"));
        return k;
    }

    /**
     * @return Vraca String koji predstavlja SQL kod koji spaja vise tabela iz baze.
     */
    @Override
    public String getJoinTables() {
        return " k JOIN tipkomponente t ON t.TipKomponenteID = k.TipKomponenteID ";
    }

    /**
     * @return Vraca String koji predstavlja kriterijum pretrage postojecih vrednosti u bazi.
     */
    @Override
    public String getWhereCriteria() {
        return "WHERE k.NazivKomponente";
    }

    /**
     * @return Vraca String koji predstavlja kriterijum pretrage koji se dobija u query-ju od baze.
     */
    @Override
    public String getLikeCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append(" LIKE '%").append(getNazivKomponente()).append("%'");
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja kriterijum brisanja postojecih vrednosti u bazi.
     */
    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("KomponentaID = ").append(getKomponentaId());
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja nove vrednosti koje ce biti zamenjene starim koje se vec nalaze u bazi.
     */
    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("NazivKomponente = '").append(getNazivKomponente())
                .append("', TipKomponenteID = ").append(getTipKomponente().getTipKomponenteID())
                .append(", Takt = ").append(getTakt())
                .append(", Opis = '").append(getOpis())
                .append("', Cena = ").append(getCena());
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja kriterijum izmene postojecih vrednosti u bazi.
     */
    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("KomponentaID = ").append(getKomponentaId());
        return sb.toString();
    }

}
