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
 * Klasa koja predstavlja racunar sa jedinstvenim ID-em, nazivom, namenom, datumom garancije.
 * Poseduje listu svih stavke racunara i ukupnu cenu koja je zbir svih cena stavki racunara.
 * Predstavlja jaki objekat.
 *
 * @author Djordje Novakovic
 * @version 1.0
 */
public class Racunar implements GenericEntity {

	/**
	 * Id racunara kao int.
	 */
    private int racunarID;
    
    /**
     * Naziv racunara kao String.
     */
    private String nazivRacunara;
    
    /**
     * Namena racunara kao String.
     */
    private String namena;
    
    /**
     * Datum do kada vazi garancija racunara kao Date.
     */
    private Date garancija;
    
    /**
     * Ukupna cena racunara kao double koja predstavlja zbir svih stavki racuanra koje poseduje racunar.
     */
    private double ukupnaCena;
    
    /**
     * Stavke racunara koje poseduje racunara kao lista klasa StavkeRacunara.
     */
    private ArrayList<StavkaRacunara> stavke;

    /**
     * Konstruktor bez parametara koji inicijalizuje objekat.
     */
    public Racunar() {
        this.stavke = new ArrayList<>();
    }

    /**
     * Konstruktor koji inicijalzuje objekat i postavlja vrednosti svih atributa.
     * 
     * @param racunarID ID racunara kao int.
     * @param nazivRacunara Naziv racuanra kao String.
     * @param namena Namena racunara kao String.
     * @param garancija Garancija racunara kao Date.
     * @param ukupnaCena Ukupna cena racunara kao double
     */
    public Racunar(int racunarID, String nazivRacunara, String namena, Date garancija, double ukupnaCena) {
        setRacunarID(racunarID);
        setNazivRacunara(nazivRacunara);
        setNamena(namena);
        setGarancija(garancija);
        setUkupnaCena(ukupnaCena);
        setStavke(new ArrayList<StavkaRacunara>());
    }

    /**
     * Vraca datum vazenja garancije racunara.
     * 
     * @return Datum vazenja garancije racunara kao Date.
     */
    public Date getGarancija() {
        return garancija;
    }

    /**
     * Postavlja datum vazenja garancije racunara.
     * 
     * @param garancija Datum garancije racunara kao Date.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     * @throws lava.lang.RuntimeException Ako je vrednost parametra datum u proslosti.
     */
    public void setGarancija(Date garancija) {
    	if(garancija==null) {
    		throw new NullPointerException("Garancija racunara ne sme biti null");
    	}
    	if(garancija.before(new Date())) {
    		throw new RuntimeException("Garancija racunara mora biti datum u buducnosti");
    	}
        this.garancija = garancija;
    }

    /**
     * Vraca ID racunara.
     * 
     * @return ID racunara kao int.
     */
    public int getRacunarID() {
        return racunarID;
    }

    /**
     * Postavlja ID racunara.
     * 
     * @param racunarID ID racunara kao int.
     * 
     * @throws lava.lang.RuntimeException Ako je paremtar int manji od nula.
     */
    public void setRacunarID(int racunarID) {
    	if(racunarID < 0) {
    		throw new RuntimeException("Id racunara mora biti pozitivan broj");
    	}
        this.racunarID = racunarID;
    }

    /**
     * Vraca naziv racunara.
     * 
     * @return Naziv racunara kao String.
     */
    public String getNazivRacunara() {
        return nazivRacunara;
    }

    /**
     * Postavlja naziv racunara.
     * 
     * @param nazivRacunara Naziv racuanra kao String.
     * 
     *  * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     */
    public void setNazivRacunara(String nazivRacunara) {
    	if(nazivRacunara==null) {
    		throw new NullPointerException("Naziv racunara ne sme biti null");
    	}
        this.nazivRacunara = nazivRacunara;
    }

    /**
     * Vraca namenu racunara
     * 
     * @return Namena racuanra kao String.
     */
    public String getNamena() {
        return namena;
    }

    /**
     * Postavlja namenu racunara. 
     * 
     * @param namena Namena racunara kao String.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     * @throws lava.lang.RuntimeException Ako je vrednost parematara String sa manje od 5 karaktera.
     */
    public void setNamena(String namena) {
    	if(namena==null) {
    		throw new NullPointerException("Namena racunara ne sme biti null");
    	}
    	if(namena.length()<5) {
    		throw new RuntimeException("Namena racunara mora imati vise od 4 karaktera");
    	}
        this.namena = namena;
    }

    /*
     * @return Vraca naziv racunara kao String.
     */
    @Override
    public String toString() {
        return nazivRacunara;
    }
    
    /**
     * Vraca listu svih stavki racunara. 
     * 
     * @return Lisa stavki racunara kao lista klasa StavkeRacuanra.
     */
    public ArrayList<StavkaRacunara> getStavke() {
        return stavke;
    }

    /*
     * Postavlja listu stavke racunara.
     * 
     * @parametar Lista stavki racunara kao lista klase StavkaRacuanra.
     * 
     * @throws java.lang.NullPointerException Ako je vrednost parametra null.
     */
    public void setStavke(ArrayList<StavkaRacunara> stavke) {
    	if(stavke==null) {
    		throw new NullPointerException("Stavke racunara ne smeju biti null");
    	}
        this.stavke = stavke;
    }
    
    /**
     * Vraca ukupnu cenu racunara.
     * 
     * @return Ukupna cena racunara kao double.
     */
    public double getUkupnaCena() {
        return ukupnaCena;
    }

    /**
     * Postavlja ukupnu vrednost racuanra.
     * 
     * @param ukupnaCena Ukupna vrednost racunara kao double.
     * 
     * @throws lava.lang.RuntimeException Ako je parematar double vredniost manja od nule.
     */
    public void setUkupnaCena(double ukupnaCena) {
    	if(ukupnaCena < 0) {
    		throw new RuntimeException("Ukupna cena racunara mora biti pozitivan broj");
    	}
        this.ukupnaCena = ukupnaCena;
    }

    /**
     * Poredi dva racunara i vraca true ako su isti, u suprotnom vraca false.
     * Poredjenje se vrsi po ID-u dva racunara.
     * 
     * @return 
     * <ul>
     * 	<li>true Ako su oba objekta tipa klase Racunar i ako imaju isti ID vrednosti.</li>
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
        final Racunar other = (Racunar) obj;
        if (this.racunarID != other.racunarID) {
            return false;
        }
        return true;
    }

    /**
     * Ocenjuje racunar preko sabiranja svih vrednosti stavki racunara na osnovu testa.
     * 
     * @param test Stress test na osnovu kog se racunaju ocene kao klasa StressTest.
     * @return Vraca ocenu kao int.
     */
    public int oceni(StressTest test) {
        int suma = 0;
        for (StavkaRacunara stavka : getStavke()) {
            suma += stavka.getKomponenta().oceni(test);
        }
        return suma;
    }

    /**
     * Staticka metoda koja vraca zakljucak na osnovu vrednost dva int parametra.
     * 
     * @param prva Ocena prvog racunara kao int.
     * @param druga Ocena drugog racunara kao int.
     * @return Zakljucak poredjenja racunara kao String.
     */
    public static String vratiZakljucak(int prva, int druga) {
        if (prva > druga) {
            return "Komponente prvog racunara su jace od komponenti drugog racunara.";
        }
        if (druga > prva) {
            return "Komponente drugog racunara su jace od komponenti prvog racunara.";
        }
        return "Komponente racunara su jednake jacine.";
    }

    /**
     * @return Vraca String ime tabele koje se nalazi u bazi podataka i koje odgovara klasi.
     */
    @Override
    public String getTableName() {
        return "racunar ";
    }

    /**
     * @return Vraca String imena kolona u odgovarajucoj tabeli za dodavanje objekta u bazu.
     */
    @Override
    public String getColumnNamesForInsert() {
        return "NazivRacunara,Namena,Garancija,UkupnaCena";
    }

    /**
     * @return Vraca String koji predstavlja SQL kod za unos konkretnih vrednosti objekta u bazu.
     */
    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(getNazivRacunara()).append("','")
                .append(getNamena()).append("','")
                .append(new java.sql.Date(getGarancija().getTime())).append("',")
                .append(getUkupnaCena());
        return sb.toString();
    }

    /**
     * Postavlja ID racunara.
     * 
     * @param id ID racunara kao int.
     */
    @Override
    public void setId(int id) {
        setRacunarID(id);
    }

    /**
     * @return Vraca String koji predstavlja SQL kod koji spaja vise tabela iz baze.
     */
    @Override
    public GenericEntity getResponse(ResultSet rs) throws Exception {
        Racunar racunar = new Racunar(rs.getInt("RacunarID"),
                rs.getString("NazivRacunara"),
                rs.getString("Namena"),
                new Date(rs.getDate("Garancija").getTime()),
                rs.getDouble("UkupnaCena"));
        return racunar;
    }

    /**
     * @return Vraca String koji predstavlja kriterijum pretrage koji se dobija u query-ju od baze.
     */
    @Override
    public String getJoinTables() {
        return "";
    }

    /**
     * @return Vraca String koji predstavlja kriterijum pretrage postojecih vrednosti u bazi.
     */
    @Override
    public String getWhereCriteria() {
        return "WHERE NazivRacunara";
    }

    /**
     * @return GenericEntity u kome se nalaze vrednosti kao odgovor query-ja iz baze.
     */
    @Override
    public String getLikeCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append(" LIKE '%").append(getNazivRacunara()).append("%'");
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja kriterijum brisanja postojecih vrednosti u bazi.
     */
    @Override
    public String getDeleteCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("RacunarID = ").append(getRacunarID());
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja nove vrednosti koje ce biti zamenjene starim koje se vec nalaze u bazi.
     */
    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("NazivRacunara = '").append(getNazivRacunara())
                .append("', Namena = '").append(getNamena())
                .append("', Garancija = '").append(new java.sql.Date(getGarancija().getTime()))
                .append("', UkupnaCena = ").append(getUkupnaCena());
        return sb.toString();
    }

    /**
     * @return Vraca String koji predstavlja kriterijum izmene postojecih vrednosti u bazi.
     */
    @Override
    public String getEditCriteria() {
        StringBuilder sb = new StringBuilder();
        sb.append("RacunarID = ").append(getRacunarID());
        return sb.toString();
    }

}
