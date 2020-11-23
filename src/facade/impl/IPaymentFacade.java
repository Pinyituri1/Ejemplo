/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.impl;

/**
 *
 * @author Wilgen
 */
public interface IPaymentFacade {
    public PaymentResponse pay(PaymentRequest paymantRequest ) throws GeneralPaymentError;
}
