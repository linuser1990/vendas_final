/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utilitario;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Semp
 */
public class Util {
    
    public boolean confirmaAdministrador(String usuario)
    {
       if(usuario.equalsIgnoreCase("admin") || usuario.equalsIgnoreCase("a"))
       {
           return true;
       }
       
       return false;
        
    }
    
    public String verificaNumeros2(String campo)
    {
        String aux="",antes="";
        aux=campo;
        antes=campo;
        
        
           if (Character.isDigit(campo.charAt(0))==true)
          {
              System.out.println("Possui numeros");
              
          }else
        {
            JOptionPane.showMessageDialog(null,"Só são permitidos numeros!");
            return campo;
        }
        
        return aux;
 
    }
        
   public boolean verificaInteiro(String text) {
      try {
         Integer.parseInt(text);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }
        
   public String ValidaNumero(JTextField Numero,String texto) {
        int valor;
        String aux=texto;
        if (Numero.getText().length() != 0){
        try {
             valor = Integer.parseInt(Numero.getText());
        }catch(NumberFormatException ex){
            
            JOptionPane.showMessageDialog(null, "Esse Campo só aceita números" ,"Informação",JOptionPane.INFORMATION_MESSAGE);
            Numero.grabFocus();
            return aux;
        }
        }
        return texto;
}
    
    
    public String verificaNumeros(KeyEvent evento,String campo)
    {
        String aux="",antes="";
        aux=campo;
        antes=campo;
        
        int tecla = evento.getKeyCode();
        if((tecla >47 && tecla <58)|| (tecla==8 || tecla==0 ))
        {
          
        }else
        {
            JOptionPane.showMessageDialog(null,"Só são permitidos numeros!");
            return campo;
        }
        
        return aux;
    }
    
}
