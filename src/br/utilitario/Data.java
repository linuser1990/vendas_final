/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.utilitario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.MaskFormatter;
/**
 *
 * @author M4RCO5
 */
public class Data {
    
    
    public String dataSistema()
    {
        Date data =new Date();
        String aux="";
        

        aux = String.valueOf(data.getDate()+"/"+(data.getMonth()+1)+"/"+(data.getYear()+1900));
        return aux;
    }
    
    public String converteData(String dataoriginal,String mascaraOrigem,String mascaraDestino)
    {
        try
        {
            /*SimpleDateFormat formato1=new SimpleDateFormat("dd/mm/yyyy");
            SimpleDateFormat formato2=new SimpleDateFormat("yyyymmdd");*/
            SimpleDateFormat formato1=new SimpleDateFormat(mascaraOrigem);
            SimpleDateFormat formato2=new SimpleDateFormat(mascaraDestino);
            Date dataformato=new Date();
            SimpleDateFormat formatador1=new SimpleDateFormat(mascaraOrigem);
            Date datapedido=new Date();
            datapedido=formato1.parse(formatador1.format(dataformato));
            datapedido=formato1.parse(dataoriginal);
            String aux=formato2.format(datapedido);
            return aux;
         }catch (ParseException pe)
         {
            return "erro";
        }


        /*Faz a chamada dela dessa forma
converteData("20111023","yyyymmdd","dd/mm/yyyy")
a data entra assim
20111023 e sai assim 23/10/2011*/
    }


     public static MaskFormatter mascara(String s) {
          MaskFormatter    formato =null;
        try {
            if      (s == "codigo")
              formato = new MaskFormatter("####");
            else if (s == "mesano")
                formato = new MaskFormatter("######");
            else if (s == "cnpj")
                formato = new MaskFormatter("##.###.###/####-##");
            else if (s == "data") {
                formato = new MaskFormatter("*#/##/####");
                formato.setValidCharacters("0123456789Hh");
            }
            else if (s == "cep")
                formato = new MaskFormatter("#####-###");
            else if (s == "telefone")
                formato = new MaskFormatter("(##)####-####");
            formato.setPlaceholderCharacter('0');
            formato.setCommitsOnValidEdit(true);
            formato.setValueContainsLiteralCharacters(false);
        } catch (java.text.ParseException e) {

        }
        return formato;
    }

     public String convertedata(String dataoriginal){
        try
        {
            SimpleDateFormat formato1=new SimpleDateFormat("dd/mm/yyyy");
            SimpleDateFormat formato2=new SimpleDateFormat("yyyymmdd");
            Date dataformato=new Date();
            SimpleDateFormat formatador1=new SimpleDateFormat("dd/mm/yyyy");
            Date datapedido=new Date();
            datapedido=formato1.parse(formatador1.format(dataformato));
            datapedido=formato1.parse(dataoriginal);
            String aux=formato2.format(datapedido);
            return aux;
            }catch (ParseException pe){
            return "erro";
        }
}
      public static String retornaMes(int dat)
      {
           String mes="01";
           switch(dat)
            {
           
               case 1:{mes="01";}break;
               case 2:{mes="02";}break;
               case 3:{mes="03";}break;
               case 4:{mes="04";}break;
               case 5:{mes="05";}break;
               case 6:{mes="06";}break;
               case 7:{mes="07";}break;
               case 8:{mes="08";}break;
               case 9:{mes="09";}break;
               case 10:{mes="10";}break;
               case 11:{mes="11";}break;
               case 12:{mes="12";}break;   
               
            }
           return mes;
      }
}
