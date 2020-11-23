/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.subsystems.crm;


import facade.util.Customer;
import facade.util.OnMemoryDataBase;

/**
 *
 * @author Wilgen
 */
public class CRMSystem {
    
    // Busca el cliente por medio del ID
    public Customer findCustomer(Long customerId){
        return OnMemoryDataBase.findCustomerById(customerId);
    }
    
}
