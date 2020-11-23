/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.impl;

import java.util.HashMap;
import facade.subsystems.bank.*;
import facade.subsystems.biller.*;
import facade.subsystems.crm.CRMSystem;
import facade.subsystems.email.EmailSystem;
import facade.util.*;
/**
 *
 * @author Wilgen
 * Aquí se realizan todas las acciones para aplicar el pago en todos los subsistemas
 */
public class OnlinePaymentFacadeImpl implements IPaymentFacade {

    private static final CRMSystem crmSystem = new CRMSystem();
    private static final BillingSystem billingSystem = new BillingSystem();
    private static final BankSystem bankSystem = new BankSystem();
    private static final EmailSystem emailSenderSystem = new EmailSystem();
    
    
    @Override
    public PaymentResponse pay(PaymentRequest request)  throws GeneralPaymentError {
        Customer customer = crmSystem.findCustomer(request.getCustomerId());
        // Validate set
        
        if (customer==null){
            throw new GeneralPaymentError("El cliente con Id: " +
                     request.getCustomerId() + "no existe");
        }else if ("Baja".equals(customer.getStatus())){
            throw new GeneralPaymentError("El cliente con Id: " +
                     request.getCustomerId() + "está dado de baja");
        }else if (request.getAmmount()> billingSystem.queryCustomerBalance(customer.getId())){
            throw new GeneralPaymentError("se está intentando realizar un pago " +
                    "\n\t mayor al saldo del cliente");
        }
        
        // Pagos bancario. Se realiza el cargo a la tarjeta
        TransferRequest transfer = new TransferRequest(
            request.getAmmount(),request.getCardNumber(),
            request.getCardName(),request.getCardExpDate(),
            request.getCardNumber());
        String payReference = bankSystem.transfer(transfer);
        
        //Afectación del saldo en el sistema facturación.
        BillingPayRequest billingRequest = new BillingPayRequest(
            request.getCustomerId(),request.getAmmount());
        double newBalance = billingSystem.pay(billingRequest);
        
        // El cliente se reactiva si el nuevo saldo es menor de 51$
        String newStatus = customer.getStatus();
        if (newBalance<=50){
            OnMemoryDataBase.changeCustomerStatus(request.getCustomerId(),"Activo");
            newStatus = "Activo";
        }
        
        //Envío de la confirmación de pago por Email
        HashMap<String,String> params = new HashMap<>();
        params.put("$name",customer.getName());
        params.put("$ammount", request.getAmmount()+"");
        params.put("$newBalance",newBalance+"");
        String number = request.getCardNumber();
        String subfix = number.substring(number.length()-4,number.length());
        params.put("$cardNumber", subfix);
        params.put("$reference", payReference);
        params.put("$newStatus", newStatus);
        emailSenderSystem.sendEmail(params);
        
        return new PaymentResponse(payReference, newBalance, newStatus);
             
        
    }    
}
