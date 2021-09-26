/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import java.sql.ResultSet;

/**
 * Klasa koja predstavlja postojece tipove komponenti.
 * Svaki tip komponente ima naziv i jedistveni ID.
 *
 * @author Djordje Novakovic
 * @version 1.0
 */
public class TipKomponente implements GenericEntity {

	/**
	 * ID tipa komponente kao int.
	 */
    private int tipKomponenteID;
    
    /**
     * Naziv tipa komponente kao String.
     */
    private String naziv;

    /**
     * Konstruktor bez parametara koji inicijalizuje objekat.
     */
    public TipKomponente() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednost za ID i naziv tipa komponente.
     * 
     * @param tipKomponenteID ID komponente kao int.
     * @param naziv Naziv komponente kao String.
     */
    public TipKomponente(int tipKomponenteID, String naziv) {
        setTipKomponenteID(tipKomponenteID);
        setNaziv(naziv);
    }
    
    /**
     * Vraca naziv tipa komponente.
     * 
     * @return Naziv komponente kao String.
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja naziv tipa komponente na novu vrednost.
     * 
     * @param naziv Naziv komponente kao String.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     * @throws lava.lang.RuntimeException Ako je vrednost parametra String koji je kraci od 2 karaktera.
     */
    public void setNaziv(String naziv) {
    	if(naziv==null) {
    		throw new NullPointerException("Naziv tipa komponente ne sme biti null");
    	}
    	if(naziv.length()<2) {
    		throw new RuntimeException("Naziv tipa komponente mora imati vise od 1 karaktera");
    	}
        this.naziv = naziv;
    }

    /**
     * Vraca ID tipa komponente.
     * 
     * @return ID komponente kao int.
     */
    public int getTipKomponenteID() {
        return tipKomponenteID;
    }

    /**
     * Postavlja ID tipa komponente na novu vrednost.
     * 
     * @param tipKomponenteID ID komponente kao int.
     * 
     * @throws lava.langRuntimeException Ako je vrednost parametra int koji je negativan.
     */
    public void setTipKomponenteID(int tipKomponenteID) {
    	if(tipKomponenteID < 0) {
    		throw new RuntimeException("Id tipa komponente mora biti pozitivan broj");
    	}
        this.tipKomponenteID = tipKomponenteID;
    }

    /**
     * @return Vraca String sa nazivom tipa komponente.
     */
    @Override
    public String toString() {
        return naziv;
    }

    /**
     * Poredi dva tipa komponente i vraca true ako su isti, u suprotnom vraca false.
     * Poredjenje se vrsi po ID-u tipa komponente.
     * 
     * @return 
     * <ul>
     * 	<li>true Ako su oba objekta tipa klase TipKomponente i ako imaju isti ID vrednosti.</li>
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
        final TipKomponente other = (TipKomponente) obj;
        if (this.tipKomponenteID != other.tipKomponenteID) {
            return false;
        }
        return true;
    }

    /**
     * @return Vraca ime tabele za klasu TipKomponente u bazi podataka.
     */
    @Override
    public String getTableName() {
        return "tipkomponente";
    }

    /**
     * @return Vraca String imena kolona u odgovarajucoj tabeli za dodavanje objekta u bazu.
     */
    @Override
    public String getColumnNamesForInsert() {
        return "NazivTipa";
    }

    /**
     * @return Vraca String koji predstavlja SQL kod za unos konkretnih vrednosti objekta u bazu.
     */
    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(getNaziv()).append("'");
        return sb.toString();
    }

    /**
     * Postavlja ID tipa komponente.
     * 
     * @param id ID komponente kao int.
     */
    @Override
    public void setId(int id) {
        setTipKomponenteID(id);
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
        return "";
    }

    /**
     * @return GenericEntity Koji predstavlja odgovor query-ja iz baze.
     */
    @Override
    public GenericEntity getResponse(ResultSet rs) throws Exception {
        TipKomponente tip = new TipKomponente(rs.getInt("TipKomponenteID"),
                rs.getString("NazivTipa"));;
        return tip;
    }

    /**
     * @return Vraca String koji predstavlja kriterijum brisanja postojecih vrednosti u bazi.
     */
    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("TipKomponenteID = ").append(getTipKomponenteID());
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja nove vrednosti koje ce biti zamenjene starim koje se vec nalaze u bazi.
     */
    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("NazivTipa = '").append(getNaziv())
                .append("'");
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja kriterijum izmene postojecih vrednosti u bazi.
     */
    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("TipKomponenteID = ").append(getTipKomponenteID());
        return sb.toString();
    }

}
