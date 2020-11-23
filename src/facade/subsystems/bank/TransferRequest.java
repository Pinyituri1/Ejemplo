/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.subsystems.bank;
/**
 *
 * @author Wilgen
 * clase representa el request para el sistema bancario, 
 * es la que recibe los datos de la tarjeta y el monto del cargo.
 */
public class TransferRequest {

private double ammount;
private String cardNumber;
private String cardName;
private String cardExpDate;
private String cardSecureNum;

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardExpDate() {
        return cardExpDate;
    }

    public void setCardExpDate(String cardExpDate) {
        this.cardExpDate = cardExpDate;
    }

    public String getCardSecureNum() {
        return cardSecureNum;
    }

    public void setCardSecureNum(String cardSecureNum) {
        this.cardSecureNum = cardSecureNum;
    }


public TransferRequest(double ammount, String cardNumber,
    String cardName, String cardExpDate, String cardSecureNum)  {

    this.ammount = ammount;
    this.cardNumber = cardNumber;
    this.cardName = cardName;
    this.cardExpDate = cardExpDate;
    this.cardSecureNum = cardSecureNum;
            
}  
}
