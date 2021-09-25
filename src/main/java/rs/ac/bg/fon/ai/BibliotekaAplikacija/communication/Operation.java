/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.communication;

/**
 *
 * @author DarkForce
 */
public enum Operation {
    LOGOVANJE,
    UGASI,
    
    VRATI_TIPOVE_KOMPONENTI,
    VRATI_STRESS_TESTOVE,
    
    KREIRAJ_KOMPONENTU,
    PRETRAZI_KOMPONENTU,
    IZMENI_KOMPONENTU,
    OBRISI_KOMPONENTU,
    
    KREIRAJ_RACUNAR,
    PRETRAZI_RACUNAR,
    IZMENI_RACUNAR,
    OBRISI_RACUNAR,
    
    KREIRAJ_BENCHMARK,
    KREIRAJ_OCENU,
    
    OCENI_KOMPONENTU,
    OCENI_RACUNAR,
    VRATI_ZAKLJUCAK_KOMPONENTI,
    VRATI_ZAKLJUCAK_RACUNARA

}
