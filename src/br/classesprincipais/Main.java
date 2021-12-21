/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.classesprincipais;

import br.utilitario.Conexao;


/**
 *
 * @author M4RCO5
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) {
        Conexao con = new Conexao();
        try
        {
          //con.conecta();
          JFlogin aux = new JFlogin();
          aux.setVisible(true);
         
        }catch(Exception e)
        {

        }
      
    }

}
