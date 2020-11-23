/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.subsystems.bank;


import java.util.UUID;
import facade.impl.GeneralPaymentError;
import facade.util.OnMemoryDataBase;
/**
 *
 * @author Wilgen
 * Clase que representa el sistema bancario, éste ofrece un método llamado 
 * transfer que recibe los datos para realizar el cargo a la tarjeta.
 */
public class BankSystem {
    
    public String transfer(TransferRequest request) throws GeneralPaymentError {
        String cardNumerPrefix = request.getCardNumber().substring(0,3);
        if (!OnMemoryDataBase.validateCardBins(cardNumerPrefix)){
            throw new GeneralPaymentError("Tarjeta Invalida");
        }
        String cardCompany = OnMemoryDataBase.getCardCompany(cardNumerPrefix);
        if ("AMEX".equals(cardCompany)&& request.getCardNumber().length()!=15){
            throw new GeneralPaymentError("El número de tarjeta es inválido");
        }else if (("VISA".equals(cardCompany)) || "MASTERCARD".equals(cardCompany)
            && request.getCardNumber().length()!=16){
            throw new GeneralPaymentError("El número de la tarjeta es inválido");
        }            
        String number = request.getCardNumber();
        String cardNumerSubfix = number.substring(number.length()-4,number.length());
        System.out.println("Se ha realizado un cargo al cliente" 
                + request.getCardName()+"\n"
                + "\tpor el monto de" + request.getAmmount()+" a la tarjeta"
                + "terminación" + cardNumerSubfix + "\n");
    return UUID.randomUUID().toString();
    }
}
