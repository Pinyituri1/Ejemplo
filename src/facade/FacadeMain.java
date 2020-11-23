/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import facade.impl.IPaymentFacade;
import facade.impl.OnlinePaymentFacadeImpl;
import facade.impl.PaymentRequest;

/**
 *
 * @author Wilgen
 */
public class FacadeMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PaymentRequest request = new PaymentRequest();
        request.setAmmount(500);
        request.setCardExpDate("10/2020");
        request.setCardName("Oscar Blancarte");
        request.setCardNumber("1234567890123456");
        request.setCardSecureNum("345");
        request.setCustomerId(1L);
        
        try{
            IPaymentFacade paymentFacade = new OnlinePaymentFacadeImpl();
            paymentFacade.pay(request);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
