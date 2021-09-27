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
 * @author DarkForce
 * @version 1.0
 */
public interface GenericEntity extends Serializable {

	/**
     * @return Vraca String ime tabele koje se nalazi u bazi podataka i koje odgovara klasi.
     */
    String getTableName();

    /**
     * @return Vraca String imena kolona u odgovarajucoj tabeli za dodavanje objekta u bazu.
     */
    String getColumnNamesForInsert();

    /**
     * @return Vraca String koji predstavlja SQL kod za unos konkretnih vrednosti objekta u bazu.
     */
    String getInsertValues();

    /**
     * Postavlja ID stress testa.
     * 
     * @param id ID stress testa kao int.
     */
    void setId(int id);

    /**
     * @return Vraca String koji predstavlja SQL kod koji spaja vise tabela iz baze.
     */
    String getJoinTables();

    /**
     * @return Vraca String koji predstavlja kriterijum pretrage koji se dobija u query-ju od baze.
     */
    String getLikeCriteria();

    /**
     * @return Vraca String koji predstavlja kriterijum pretrage postojecih vrednosti u bazi.
     */
    String getWhereCriteria();

    /**
     * @return GenericEntity u kome se nalaze vrednosti kao odgovor query-ja iz baze.
     */
    GenericEntity getResponse(ResultSet rs) throws Exception;

    /**
     * @return Vraca String koji predstavlja kriterijum brisanja postojecih vrednosti u bazi.
     */
    String getDeleteCriteria();
    
    /**
     * @return Vraca String koji predstavlja nove vrednosti koje ce biti zamenjene starim koje se vec nalaze u bazi.
     */
    String getEditValues();

    /**
     * @return Vraca String koji predstavlja kriterijum izmene postojecih vrednosti u bazi.
     */
    String getEditCriteria();

}
