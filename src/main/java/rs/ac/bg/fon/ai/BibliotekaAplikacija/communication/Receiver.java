/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.communication;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author DarkForce
 */
public class Receiver {

    private final Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }

    public Object recieve() throws Exception {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error recieving object. " + ex.getMessage());
        }
    }

}
