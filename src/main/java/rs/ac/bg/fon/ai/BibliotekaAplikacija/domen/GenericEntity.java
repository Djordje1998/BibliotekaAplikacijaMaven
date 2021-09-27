/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import java.io.Serializable;
import java.sql.ResultSet;

/**
 * Interfejs koji nasledjuje svaka domenska klasa.
 * Poseduje metode koje sluze za komunikaciju sa bazom.
 * Svaka domenska klasa implementira za sebe metode u zavisnosti za njenom tabelom u bazi.
 * Intefejs nasledjuje intefjes Serializable kako bi se uspostavila komunikacija, slanje i primanje objekata.
 * 
 * @author Djordje Novakovic
 * @version 1.0
 */
public interface GenericEntity extends Serializable {

	/**
	 * Vraca String ime tabele koje se nalazi u bazi podataka i koje odgovara klasi.
	 * 
     * @return String ime tabele koje se nalazi u bazi podataka i koje odgovara klasi.
     */
    String getTableName();

    /**
     * Vraca String imena kolona u odgovarajucoj tabeli za dodavanje objekta u bazu.
     * 
     * @return String imena kolona u odgovarajucoj tabeli za dodavanje objekta u bazu.
     */
    String getColumnNamesForInsert();

    /**
     * Vraca String koji predstavlja SQL kod za unos konkretnih vrednosti objekta u bazu.
     * 
     * @return String koji predstavlja SQL kod za unos konkretnih vrednosti objekta u bazu.
     */
    String getInsertValues();

    /**
     * Postavlja ID domenske klase koju implementira.
     * 
     * @param id ID domenske klase koju implementira kao int.
     */
    void setId(int id);

    /**
     * Vraca String koji predstavlja SQL kod koji spaja vise tabela iz baze.
     * 
     * @return String koji predstavlja SQL kod koji spaja vise tabela iz baze.
     */
    String getJoinTables();

    /**
     * Vraca String koji predstavlja kriterijum pretrage koji se dobija u query-ju od baze.
     * 
     * @return String koji predstavlja kriterijum pretrage koji se dobija u query-ju od baze.
     */
    String getLikeCriteria();

    /**
     * Vraca String koji predstavlja kriterijum pretrage postojecih vrednosti u bazi.
     * 
     * @return String koji predstavlja kriterijum pretrage postojecih vrednosti u bazi.
     */
    String getWhereCriteria();

    /**
     * Vraca neku od domenski klasa koje implelemtiraju interfejs koju dobije kao odgovor od baze.
     * Pretvara odgovor baze u objekat domenske klase.
     * 
     * @param rs ResultSet koji se dobija kao odgovor od baze.
     * @return GenericEntity u kome se nalaze vrednosti kao odgovor query-ja iz baze.
     * 
     * @throws java.lang.Exception Ukoliko nastane problem pri konverziji odgovora u objekat.
     */
    GenericEntity getResponse(ResultSet rs) throws Exception;

    /**
     * Vraca String koji predstavlja kriterijum brisanja postojecih vrednosti u bazi.
     * 
     * @return String koji predstavlja kriterijum brisanja postojecih vrednosti u bazi.
     */
    String getDeleteCriteria();
    
    /**
     * Vraca String koji predstavlja nove vrednosti koje ce biti zamenjene starim koje se vec nalaze u bazi.
     * 
     * @return String koji predstavlja nove vrednosti koje ce biti zamenjene starim koje se vec nalaze u bazi.
     */
    String getEditValues();

    /**
     * Vraca String koji predstavlja kriterijum izmene postojecih vrednosti u bazi.
     * 
     * @return String koji predstavlja kriterijum izmene postojecih vrednosti u bazi.
     */
    String getEditCriteria();

}
