/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.BibliotekaAplikacija.communication.object;

import rs.ac.bg.fon.ai.BibliotekaAplikacija.communication.Operation;
import java.io.Serializable;

/**
 *
 * @author DarkForce
 */
public class Request implements Serializable {

    private Operation operation;
    private Object paket;

    public Request() {
    }

    public Request(Operation operation, Object paket) {
        this.operation = operation;
        this.paket = paket;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getPaket() {
        return paket;
    }

    public void setPaket(Object paket) {
        this.paket = paket;
    }

}
