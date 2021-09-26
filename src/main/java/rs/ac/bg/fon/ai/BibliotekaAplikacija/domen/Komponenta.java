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
public class Komponenta implements GenericEntity {

    private int komponentaId;
    private String nazivKomponente;
    private TipKomponente tipKomponente;
    private double takt;
    private String opis;
    private double cena;

    public Komponenta() {
    }

    public Komponenta(int komponentaId, String nazivKomponente, TipKomponente tipKomponente, double takt, String opis, double cena) {
        setKomponentaId(komponentaId);
        setNazivKomponente(nazivKomponente);
        setTipKomponente(tipKomponente);
        setTakt(takt);
        setOpis(opis);
        setCena(cena);
    }

    public double getTakt() {
        return takt;
    }

    public void setTakt(double takt) {
    	if(takt < 0) {
    		throw new RuntimeException("Takt mora biti pozitivan broj");
    	}
        this.takt = takt;
    }

    public int getKomponentaId() {
        return komponentaId;
    }

    public void setKomponentaId(int komponentaId) {
    	if(komponentaId < 0) {
    		throw new RuntimeException("Id komponente mora biti pozitivan broj");
    	}
        this.komponentaId = komponentaId;
    }

    public String getNazivKomponente() {
        return nazivKomponente;
    }

    public void setNazivKomponente(String nazivKomponente) {
    	if(nazivKomponente==null) {
    		throw new NullPointerException("Naziv komponente ne sme biti null");
    	}
        this.nazivKomponente = nazivKomponente;
    }

    public TipKomponente getTipKomponente() {
        return tipKomponente;
    }

    public void setTipKomponente(TipKomponente tipKomponente) {
    	if(tipKomponente==null) {
    		throw new NullPointerException("Tip komponente ne sme biti null");
    	}
        this.tipKomponente = tipKomponente;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
    	if(nazivKomponente==null) {
    		throw new NullPointerException("Opis komponente ne sme biti null");
    	}
    	if(nazivKomponente.length()<5) {
    		throw new RuntimeException("Opis komponente mora imati vise od 4 karaktera ");
    	}
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
    	if(cena < 0) {
    		throw new RuntimeException("Cena komponente mora biti pozitivan broj");
    	}
        this.cena = cena;
    }

    @Override
    public String toString() {
        return nazivKomponente;
    }

    public int oceni(StressTest test) {
        return (int) (takt * 1.33 * test.getNazivTesta().length() / 3.77);
    }

    @Override
    public int hashCode() {
        int hash = 7;
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

    public static String vratiZakljucak(int prva, int druga) {
        if (prva > druga) {
            return "Prva komponenta je jaca od druge.";
        }
        if (druga > prva) {
            return "Druga komponenta je jaca od prve.";
        }
        return "Komponente su jednake jacine.";
    }

    @Override
    public String getTableName() {
        return "komponente";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "NazivKomponente,TipKomponenteID,Takt,Opis,Cena";
    }

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

    @Override
    public void setId(int id) {
        setKomponentaId(id);
    }

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

    @Override
    public String getJoinTables() {
        return " k JOIN tipkomponente t ON t.TipKomponenteID = k.TipKomponenteID ";
    }

    @Override
    public String getWhereCriteria() {
        return "WHERE k.NazivKomponente";
    }

    @Override
    public String getLikeCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append(" LIKE '%").append(getNazivKomponente()).append("%'");
        return sb.toString();
    }

    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("KomponentaID = ").append(getKomponentaId());
        return sb.toString();
    }

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

    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("KomponentaID = ").append(getKomponentaId());
        return sb.toString();
    }

}
