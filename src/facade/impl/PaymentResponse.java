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
public class PaymentResponse {
    
    private String paymentConfirmNumber;
    private double newBalance;
    private String customerStatus;

    public String getPaymentConfirmNumber() {
        return paymentConfirmNumber;
    }

    public void setPaymentConfirmNumber(String paymentConfirmNumber) {
        this.paymentConfirmNumber = paymentConfirmNumber;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
    
    public PaymentResponse(String paymentConfirmNumber,
            double newBalance, String customerStatus){
    
        this.paymentConfirmNumber = paymentConfirmNumber;
        this.newBalance = newBalance;
        this.customerStatus = customerStatus;
    }    
}
