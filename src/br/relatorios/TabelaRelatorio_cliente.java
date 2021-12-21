/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TabelaRelatorio.java
 *
 * Created on 13/10/2011, 09:38:51
 */

package br.relatorios;

import br.utilitario.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import br.classesprincipais.JFCliente;
import br.classesprincipais.JFLivros;

/**
 *
 * @author Tarcisio
 */
public class TabelaRelatorio_cliente extends javax.swing.JFrame {
    private  Statement smt;
    ResultSet rs;
    Conexao con = new Conexao();

    /** Creates new form TabelaRelatorio */
    public TabelaRelatorio_cliente(String query) throws SQLException  {
        //Conexao c = new Conexao("localhost/LTPB"); //Conecta no Banco de dados
       // java.sql.Connection conn=c.getConexao();      //Variável que irá pegar o bd aberto

        //Criando uma instância de conexão
        try {
           // smt = conn.createStatement(); //Reservando espaço na memória
        } catch (Exception e) {
            System.out.println("Erro ao criar uma instância");
        }

        //Criando um result set
        rs=null;
        try{
            con.conecta();
            rs = con.executeResult(query);
            //rs=smt.executeQuery(query); //Equivale a uma tabela
        }
        catch(Exception e)
        {
            System.out.println("erro ao realizar consulta");
        }

        initComponents();
        jgrid.setModel(new TabelaModel(rs)); //Mostra esta tabela no Grid
        setLocationRelativeTo(null);
    }

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jgrid = new javax.swing.JTable();

        setTitle("Relatório");

        jgrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jgrid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jgridMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jgrid);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

      private void jgridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jgridMouseClicked

          try
          {
             String i =  String.valueOf(jgrid.getValueAt(jgrid.getSelectedRow(), 0));
             //JOptionPane.showMessageDialog(null, "Testando"+jgrid.getValueAt(jgrid.getSelectedRow(), 0));
             JFCliente aux = new JFCliente(i);
             aux.setVisible(true);
          }catch(Exception e)
          {
                //javax.swing.JOptionPane.showMessageDialog(null, e);
          }

      }//GEN-LAST:event_jgridMouseClicked

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jgrid;
    // End of variables declaration//GEN-END:variables
 }
