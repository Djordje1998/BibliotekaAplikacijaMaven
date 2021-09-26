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
public class TipKomponente implements GenericEntity {

    private int tipKomponenteID;
    private String naziv;

    public TipKomponente() {
    }

    public TipKomponente(int tipKomponenteID, String naziv) {
        setTipKomponenteID(tipKomponenteID);
        setNaziv(naziv);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
    	if(naziv==null) {
    		throw new NullPointerException("Naziv tipa komponente ne sme biti null");
    	}
    	if(naziv.length()<2) {
    		throw new RuntimeException("Naziv tipa komponente mora imati vise od 1 karaktera");
    	}
        this.naziv = naziv;
    }

    public int getTipKomponenteID() {
        return tipKomponenteID;
    }

    public void setTipKomponenteID(int tipKomponenteID) {
    	if(tipKomponenteID < 0) {
    		throw new RuntimeException("Id tipa komponente mora biti pozitivan broj");
    	}
        this.tipKomponenteID = tipKomponenteID;
    }

    @Override
    public String toString() {
        return naziv;
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
        final TipKomponente other = (TipKomponente) obj;
        if (this.tipKomponenteID != other.tipKomponenteID) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "tipkomponente";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "NazivTipa";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(getNaziv()).append("'");
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        setTipKomponenteID(id);
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
        return "";
    }

    @Override
    public GenericEntity getResponse(ResultSet rs) throws Exception {
        TipKomponente tip = new TipKomponente(rs.getInt("TipKomponenteID"),
                rs.getString("NazivTipa"));;
        return tip;
    }

    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("TipKomponenteID = ").append(getTipKomponenteID());
        return sb.toString();
    }

    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("NazivTipa = '").append(getNaziv())
                .append("'");
        return sb.toString();
    }

    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("TipKomponenteID = ").append(getTipKomponenteID());
        return sb.toString();
    }

}
