/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.util;

/**
 *
 * @author Wilgen
 */
public class Card {
    private String prefix;
    private String company;
    private String cardType; // {Credit\Debit

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Card(String prefix, String company, String cardType){
        this.prefix = prefix;
        this.company = company;
        this.cardType = cardType;         

    }
}
