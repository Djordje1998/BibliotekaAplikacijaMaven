/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DarkForce
 */
public class PropertyRead {
    
    private Properties read;

    public PropertyRead() {
        initProperty();
    }

    private void initProperty() {
        FileInputStream fis = null;
        try {
            read = new Properties();
            fis = new FileInputStream(PropertyConst.FILE);
            read.load(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertyRead.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertyRead.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(PropertyRead.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String getString(String key) {
        return read.getProperty(key);
    }

    public int getInteger(String key) {
        return Integer.parseInt(read.getProperty(key));
    }

}
