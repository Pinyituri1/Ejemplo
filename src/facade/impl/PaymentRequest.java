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
public class PaymentRequest {
    
    private Long customerId;
    private double ammount;
    private String cardNumber;
    private String cardName;
    private String cardExpDate;
    private String cardSecureNum;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

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
    
    public PaymentRequest(){
    }
}
