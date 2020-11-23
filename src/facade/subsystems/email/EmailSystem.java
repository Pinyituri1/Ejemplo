/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.subsystems.email;

import java.util.Map;
/**
 *
 * @author Wilgen
 * Representa al modulo de envío de correos electrónicos
 */

//simula enviar un correo electrónico al cliente con los datos del 
// pago, su nuevo saldo y estatus.
public class EmailSystem {
    public void sendEmail(Map<String,String> values){
        String templete = "\n*********************************\n"
                + "|To: $name\n"
                + "|from:FacadeSystem\n"
                + "|\n"
                + "|Muchas gracias por utilizar el servicio en \n"
                + "|línea para realizar sus pagos\n"
                + "|\n"
                + "|Hace un momento acabamos de recibir un pago:\n"
                + "|\n"
                + "|Monto del pago: $ammount\n"
                + "|Nuevo saldo: $newBalance.\n"
                + "|Tarjeta terminación: $cardNumber\n"
                + "|Referencia de pago: $reference\n"
                + "|Nuevos status: $newStatus\n"
                + "|\n"
                + "|Gracias por su preferencia.\n"
                + "|\n"
                + "|Este correo no deberá ser contestado ya que \n"
                + "|ha sido enviado por un proceso automático\n"
                + "|*****************************************\n";
                
        for (String str:values.keySet()){
            templete = templete.replace(str, values.get(str));
        }
    System.out.println(templete);
    }
}
