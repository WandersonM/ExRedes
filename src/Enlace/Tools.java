/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enlace;

/**
 *
 * @author Wanderson Martins.
 */
public class Tools {
    
    //Este metodo converte uma String para binario.
    
  public String S2B (String palavra){
      String temp ="";
      String resultado = "";
      
      for(int i=0; i< palavra.length(); i++){
          
          temp= Integer.toBinaryString(palavra.charAt(i));
          for(int j = temp.length(); j<8;j++){
              
              temp="0"+temp+" ";
              
          }
          
          
          resultado+=temp;
      }
      
      String correcao = resultado.replace("  ", " ");
      
      System.out.println("A palavra digitada em binario e: "+correcao);
      
      return correcao;
      
      
  }
    
 // Este metodo converte o binarario para String.
 // Aceita conjuntos de 8 bits separados por espaço.
  
  public String B2S (String palavra){
      
      String[]bin = palavra.split(" ");
      String resultado = "";
      
      for(int i=0; i< bin.length;i++){
          
          resultado+= (char)Integer.parseInt(bin[i],2);
          
          
      }
      System.out.println("Conversão para String: "+resultado);
      return resultado;

  }
    
// Esté metodo implementa o ByteStuff
// Aceita conjuntos de 8 bits separados por espaço.
  
  public String BYSTF (String palavra){
      
      String[] bin = palavra.split(" ");
      int temp =2;
      String flag ="00100011";
      String escape="01000000";
      int j=1;
      
      for(int i=0; i< bin.length;i++){
          
          if(flag.equals(bin[i]) || escape.equals(bin[i])){
               temp++;
          }
          temp++;
      }
      
      String[] frame = new String[temp];
      
     frame[0]=flag;
     for(int k=0;k<bin.length;k++){
         
        if(flag.equals(bin[k]) || escape.equals(bin[k])){
               frame[j++]=escape;
              
          }   
         frame[j++]= bin[k];
     }
      
     frame[j++]=flag;

      String resultado ="";
      
      for (String frame1 : frame) {
          resultado += frame1 + " ";
      }
      
      System.out.println("Dados empacotados usando ByteStuff: "+resultado );
      
     return resultado; 
     
  }
    
// Este metodo converte os dados em ByteStuff para String
 
 public String BYSTFR (String palavra){
     

     String flag ="00100011";
     String escape="01000000";
     String [] bin = palavra.split(" ");
     int temp = bin.length-2;
     int j =0;
     
      for(int i=1; i< bin.length-1;i++){
          
          if(escape.equals(bin[i])){
             
               if(flag.equals(bin[i+1]) || escape.equals(bin[i+1])){
                   temp--;
                   i++;
               }
          }   
      }
     String[] frame = new String [temp];
     
     for(int q= 1; q< bin.length-1;q++){
            
             if (flag.equals(bin[q]) || escape.equals(bin[q])){
                
                q++;
            }
            frame[j]=bin[q];
          
            j++;
            
        }
      
     String resultado ="";
     
     for(int k=0; k< frame.length; k++){
         
         resultado+= frame[k]+" ";
         
     }
     System.out.println("Conversão do ByteStuff para Binario: "+resultado);
     return resultado;
     
 }  
    
 // Este metodo faz o enquadramento de pacotes usando BitStuff
 
 public String BISTF (String palavra){
     
 
    int cont= 0;
    
    String res = new String();
    
     for(int i=0;i<palavra.length();i++)
                {

                   if(palavra.charAt(i) == '1')
                        {
                            cont++;
                            res = res + palavra.charAt(i);
                        }
                   else
                        {
                            res = res + palavra.charAt(i);
                            cont = 0;
                        }
                   if(cont == 5)
                        {
                            res = res + '0';
                            cont = 0;
                        }
                }
    
        System.out.println("Dados empacotados usando BitStuff: "+res);
    return res;
     
     
 }
 
 //Esta metodo desenquadra os dados enquadrados pelo metodo anterior.
 public String BISTFR (String palavra){
     
      int cont= 0;
    
    String res = new String();
    
     for(int i=0;i<palavra.length();i++)
                {

                   if(palavra.charAt(i) == '1')
                        {
                            cont++;
                            res = res + palavra.charAt(i);
                        }
                   else 
                        {
                            res = res + palavra.charAt(i);
                            cont = 0;
                        }
                      if(cont == 5)
                        {
                              if((i+2)!=res.length())
                              res= res + palavra.charAt(i+2);
                              else
                              res=res + '1';
                              i=i+2;
                              cont = 1;

                }

 }
 System.out.println("Dados desempacotados usando BitStuff: "+res);
    return res;
    
 }
 
}
 

