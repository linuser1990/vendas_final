/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFcomprasFeitas.java
 *
 * Created on 21/Jan/2012, 9:24:02
 */
package br.classesprincipais;

import br.utilitario.Conexao;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author M4RCO5
 */
public class JFComprasFeitas extends javax.swing.JFrame {
    private String selecionado="";
    private Conexao con = new Conexao();
    private String ordem="codcompra";
    public JFComprasFeitas() {
        initComponents();
        preenchejTable();
        setLocationRelativeTo(null);
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupOrdem = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jTdata = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTquantidade = new javax.swing.JTextField();
        jTcod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTcli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTvalortotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTValorRecebido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTtipoPagamento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDetalhes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setTitle("Histórico de compras");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Ordenação")));

        buttonGroupOrdem.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Data");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroupOrdem.add(jRadioButton2);
        jRadioButton2.setText("Código");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroupOrdem.add(jRadioButton3);
        jRadioButton3.setText("Valor");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes da compra"));

        jTdata.setEditable(false);

        jLabel5.setText("Data:");

        jLabel4.setText("Quantidade :");

        jTcod.setEditable(false);

        jLabel1.setText("Código da compra :");

        jLabel3.setText("Fornecedor :");

        jLabel6.setText("Valor total :");

        jLabel7.setText("Valor Recebido :");

        jLabel9.setText("Tipo de Pagamento:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTcod, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTcli, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTdata, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTtipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTvalortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTtipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel5)
                        .addComponent(jTdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTvalortotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código da Venda", "Cliente", "Quantidade de Livros", "Data ", "Valor Recebido", "Valor Total"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jTableDetalhes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cod Livro", "Titulo", "Quantidade", "Valor unitário"
            }
        ));
        jScrollPane3.setViewportView(jTableDetalhes);

        jLabel2.setText("Detalhes do(s) livro(s)");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/icones/Recycling_Bin.jpg"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/icones/btn_alter.jpg"))); // NOI18N
        jButton1.setToolTipText("Alterar");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/icones/porta.gif"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        ordem = "data_compra";
        preenchejTable();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        ordem = "codcompra";
        preenchejTable();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        ordem = "valor_total";
        preenchejTable();
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
      exibeDados();
    }//GEN-LAST:event_jTableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       try
       {
           if(jTcod.getText().equalsIgnoreCase(""))
           {
               JOptionPane.showMessageDialog(null,"Nenhum item foi selecionado !");
           }else
           {

               int i = JOptionPane.showConfirmDialog(null,"Deseja excluir esta compra ?","Confirmação",1);
               if(i==0)
               {
                  
                   
                   //Neste momento é executada atrigger que deleta as parcelas dependentes
                   // con.conecta();
                    CallableStatement call = con.getCon().prepareCall(" call pr_delete_contas_receber("+selecionado+")");
                    call.execute();
                   
                   /*é executada a procedure*/
                   
                   //Neste momento é executada atrigger que deleta os itens da compra(itens_compra) dependentes
                   
                   con.executaSql("delete from compra where codcompra = "+selecionado);
                   con.getPs().execute();

                   preenchejTable();
                   JOptionPane.showMessageDialog(null,"Excluido com sucesso");
               }
           }
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,"1  "+ e);
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableKeyReleased
        exibeDados();
    }//GEN-LAST:event_jTableKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con.fechaConexao();
        JFComprasFeitas aux = new JFComprasFeitas();  
         JFComprasFeitas p1 = aux;  
        p1= null;  
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JFComprasFeitas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOrdem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTValorRecebido;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTableDetalhes;
    private javax.swing.JTextField jTcli;
    private javax.swing.JTextField jTcod;
    private javax.swing.JTextField jTdata;
    private javax.swing.JTextField jTquantidade;
    private javax.swing.JTextField jTtipoPagamento;
    private javax.swing.JTextField jTvalortotal;
    // End of variables declaration//GEN-END:variables

    public void exibeDados()
    {
           try
          {
             selecionado =  String.valueOf(jTable.getValueAt(jTable.getSelectedRow(), 0));
             jTcli.setText(String.valueOf(jTable.getValueAt(jTable.getSelectedRow(), 1)));
             jTcod.setText(selecionado);
             jTquantidade.setText(String.valueOf(jTable.getValueAt(jTable.getSelectedRow(),2)));
             jTdata.setText(String.valueOf(jTable.getValueAt(jTable.getSelectedRow(),3)));
             jTvalortotal.setText(String.valueOf(jTable.getValueAt(jTable.getSelectedRow(),5)));
             jTValorRecebido.setText(String.valueOf(jTable.getValueAt(jTable.getSelectedRow(),4)));
            String aux="";
            con.conecta();
            con.executaSql("select livro.titulo,quantidade from itens_compra "
                 +" inner join livro on livro.codLivro = itens_compra.livro_codLivro"
                  +" where compra_Codcompra = "+selecionado);
            while(con.getRs().next())
            {
                aux+=con.getRs().getString("titulo")+"  \t  "+ con.getRs().getString("quantidade")+"\n";
                //System.out.println(con.getRs().getString("titulo")+ con.getRs().getString("quantidade"));
            }
            con.getRs().first();
            
          /*  con.conecta();
            con.executaSql("select tipo from forma_pg where compra_codcompra = "+selecionado);
            con.getRs().next();
            jTtipoPagamento.setText(con.getRs().getString("tipo"));
           */
          }catch(Exception e)
          {
              //javax.swing.JOptionPane.showMessageDialog(null, e);
          }
           
           try
           {
               System.out.println("entrou fase 2");
               con.conecta();
               con.getRs().first();
                    
            DefaultTableModel modelo = (DefaultTableModel) jTableDetalhes.getModel();
            con.executeStatement("select * from itens_compra "+
                " inner join livro on livro.codLivro = itens_compra.livro_codLivro"+
                " where itens_compra.compra_Codcompra =  "+jTcod.getText());
     
            modelo.setRowCount(0);
            
            while(con.getRs().next())
            {
                modelo.addRow(new Object[]{con.getRs().getString("codLivro"), con.getRs().getString("titulo"),
                        con.getRs().getString("quantidade"),con.getRs().getString("preco_venda")
                });


            }
            con.getRs().first();
            
            
               
               
               
              /* con.executaSql("select * from cliente");
               while(con.getRs().next())
               {
                   System.out.println(con.getRs().getString("nome_cliente"));

               }*/
           }catch(Exception e)
           {
               System.out.println(e);
           }
    }
    
    public void preenchejTable()
    {
        try
        {
            con.conecta();
            
            DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
            con.executeStatement("select sum(sub_total) as valor_total_geral, sum(quantidade) as quantidade_total,codcompra,data_compra,nome_fornecedor,preco_total,valor_recebido from compra "+
                    " inner join itens_compra on compra.codcompra = itens_compra.compra_Codcompra" +
                    " inner join livro on livro.codLivro = itens_compra.livro_codLivro"+
                    " inner join fornecedor on compra.fornecedor_CodFornecedor = fornecedor.codFornecedor"+
                    " group by compra.codcompra order by "+ordem+" desc ");

            modelo.setRowCount(0);
            
            while(con.getRs().next())
            {
                modelo.addRow(new Object[]{con.getRs().getString("codcompra"), con.getRs().getString("nome_fornecedor"),
                        con.getRs().getString("quantidade_total"),con.getRs().getString("data_compra"),con.getRs().getString("valor_recebido"),con.getRs().getString("valor_total_geral")
                });


            }
            con.getRs().first();
         

        }catch(SQLException e)
        {
           javax.swing.JOptionPane.showMessageDialog(null,"1  2  "+  e);
        }
        
    }
}
