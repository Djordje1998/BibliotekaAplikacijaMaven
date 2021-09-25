/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.domen;

import java.io.Serializable;
import java.sql.ResultSet;

/**
 *
 * @author DarkForce
 */
public interface GenericEntity extends Serializable {

    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues();

    void setId(int id);

    String getJoinTables();

    String getLikeCriteria();

    String getWhereCriteria();

    GenericEntity getResponse(ResultSet rs) throws Exception;

    String getDeleteCriteria();
    
    String getEditValues();

    String getEditCriteria();

}
