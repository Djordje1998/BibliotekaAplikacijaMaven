/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DarkForce
 */
public class PropertyWrite {
    
    private final Properties write;

    public PropertyWrite() {
        write = new Properties();
    }

    public void setValues(String key, String value) {
        write.setProperty(key, value);
    }

    public void writeProperty() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(PropertyConst.FILE);
            write.store(fos, null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertyRead.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertyRead.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(PropertyRead.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

}
