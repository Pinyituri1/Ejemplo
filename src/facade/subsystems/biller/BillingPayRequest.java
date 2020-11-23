/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.subsystems.biller;

/**
 *
 * @author Wilgen
 */
public class BillingPayRequest {

    private Long customerId;
    private double amount;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public BillingPayRequest(Long customerId, double amount){
        this.customerId = customerId;
        this.amount = amount;        
    }
}
