/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enlace;

/**
 *
 * @author Wanderson
 */
public class Principal {
      public static void main(String[] args) {
    
    String teste = "Cas@####@#@@@#@#@2so";
          System.out.println("A String digitada foi: "+teste);
    Tools tl = new Tools();
    
    String teste2= tl.S2B(teste);
    
   String teste3 =tl.B2S(teste2);
   
   String teste4 =tl.BYSTF(teste2);
    
   String teste5 =tl.BYSTFR(teste4);
   
     String teste6 =tl.B2S(teste5);
     String teste7 =tl.BISTF(teste2);
     
     String teste8 = tl.BISTFR(teste7);
             
             
             
             
         

 }
}