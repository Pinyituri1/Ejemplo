/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.impl;

/**
 *
 * @author Wilgen
 * Será lanzada cuando se presente un error en el servicio de pago
 */
public class GeneralPaymentError extends Exception {
    public GeneralPaymentError(String message){
        super(message);
    }
}
