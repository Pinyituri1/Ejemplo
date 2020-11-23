/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.util;

import java.util.HashMap;
/**
 *
 * @author Wilgen
 */
public class OnMemoryDataBase {
    
    private static final HashMap<Long,Customer> CUSTOMER_MAP = new HashMap<>();
    private static final HashMap<String, Card> CARD_BINS = new HashMap<>();

  static {
      CUSTOMER_MAP.put(1L, new Customer(1L, "Juan Trujillo",500,"Suspendido"));
      CUSTOMER_MAP.put(2L, new Customer(2L, "Juanito",300,"Suspendido"));
      CUSTOMER_MAP.put(3L, new Customer(3L, "Pinyituri",100,"Activo"));
      CUSTOMER_MAP.put(4L, new Customer(4L, "Fercho",100,"Baja"));
      
      CARD_BINS.put("123",new Card("123","VISA OwO","Credit"));
      CARD_BINS.put("234",new Card("234","MASTERCARD UwU","Debit"));
      CARD_BINS.put("345",new Card("345","AMEX UwU","Credit"));
  } 
  
  public static Customer findCustomerById(Long id){
      return CUSTOMER_MAP.get(id);
  }
  
  public static void changeCustomerStatus(Long id, String newStatus){
      Customer customer = findCustomerById(id);
      customer.setStatus(newStatus);
      System.out.println("Cambio de status del cliente " + customer.getName()
            + "" + newStatus);
  }
  
  public static boolean validateCardBins(String creditCardPrefix){
      if (CARD_BINS.containsKey(creditCardPrefix)){
          String company = CARD_BINS.get(creditCardPrefix).getCompany();
          System.out.println("Tarjeta VALIDA >" + creditCardPrefix + ","
               + company + "\n");
          return true;
      }else {
          System.out.println("Tarjeta DISCAPACITADA >\n");
          return false;
      }
  }
  
  public static String getCardCompany(String creditCardPrefix){
      if (CARD_BINS.containsKey(creditCardPrefix)){
          return CARD_BINS.get(creditCardPrefix).getCompany();
      }
      throw new RuntimeException("Tarjeta no existe");
  }  
}
