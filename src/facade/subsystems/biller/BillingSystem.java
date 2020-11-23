/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.subsystems.biller;

import facade.util.Customer;
import facade.util.OnMemoryDataBase;
/**
 *
 * @author Wilgen
 */
public class BillingSystem {
    
    //Método que reresa el saldo del cliente
    public double queryCustomerBalance(Long customerId){
        Customer customer = OnMemoryDataBase.findCustomerById(customerId);
        return customer.getBalance();
    }
    
    // Método que aplica el pago restando el saldo del cliente
    public double pay(BillingPayRequest billingPay){
        Customer customer = OnMemoryDataBase.findCustomerById(billingPay.getCustomerId());
        customer.setBalance(customer.getBalance()-billingPay.getAmount());
        System.out.println("Pago aplicado al cliente" + customer.getName()+","
                + "el nuevo saldo es" + customer.getBalance()+"");
        return customer.getBalance(); // new Balance.
    }
}
