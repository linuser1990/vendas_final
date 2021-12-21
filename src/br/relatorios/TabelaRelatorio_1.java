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

import br.classesprincipais.ImprimeLivros;
import br.utilitario.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import br.classesprincipais.JFLivros;

/**
 *
 * @author Tarcisio
 */
public class TabelaRelatorio_1 extends javax.swing.JFrame {
    private  Statement smt;
    ResultSet rs;
    Conexao con = new Conexao();

    /** Creates new form TabelaRelatorio */
    public TabelaRelatorio_1(String query) throws SQLException  {
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
        jButton1 = new javax.swing.JButton();

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

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
             JFLivros aux = new JFLivros(i);
             aux.setVisible(true);
          }catch(Exception e)
          {
                //javax.swing.JOptionPane.showMessageDialog(null, e);
          }
          
          /*  // TODO add your handling code here:
          JOptionPane.showMessageDialog(null, "Testando"+jgrid.getValueAt(jgrid.getSelectedRow(), 0));
          try{
              rs=smt.executeQuery("SELECT * FROM Clientes WHERE codcli = " +
              jgrid.getValueAt(jgrid.getSelectedRow(), 0));

              //Exibe finalmente os dados na tela de cadastro/alteração
              ExemploCadastro ex = new ExemploCadastro();
               ex.setExibir(rs);
               ex.setVisible(true);
          }
          catch(SQLException e){
            System.out.println("Erro ao no click desta tabela");
          }*/
      }//GEN-LAST:event_jgridMouseClicked

      private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     ImprimeLivros imprime = new ImprimeLivros(2);

      }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jgrid;
    // End of variables declaration//GEN-END:variables
 }
