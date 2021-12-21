/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFMaisVendido.java
 *
 * Created on 19/Nov/2011, 21:53:50
 */

package br.relatorios;

import br.utilitario.Data;
import java.awt.TextField;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JFormattedTextField;

/**
 *
 * @author M4RCO5
 */
public class JFMaisVendido extends javax.swing.JFrame {

    Date data = new Date();
     private JFormattedTextField jFde = new JFormattedTextField();
     private JFormattedTextField jFate = new JFormattedTextField();
    public JFMaisVendido() {
          initComponents();
         try{

           javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("##/##/####");

           jFde = new javax.swing.JFormattedTextField(format_textField3);
           jFate = new javax.swing.JFormattedTextField(format_textField3);

        }catch (Exception e){}
       jFde.setText((data.getDate()-1)+"/"+(data.getMonth()+1)+"/"+(data.getYear()+1900));
       jFate.setText((data.getDate())+"/"+(data.getMonth()+1)+"/"+(data.getYear()+1900));

       jFde.setBounds(50, 45,90,25);
       jFate.setBounds(50,110,90,25);
       jPanel1.add( jFde);
       jPanel1.add(jFate);

       setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informe as datas"));

        jLabel1.setText("De:");

        jLabel2.setText("Até: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(43, 43, 43))
        );

        jButton1.setText("Exibir ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Data data = new Data();
        String de = data.convertedata(jFde.getText());
        String ate = data.convertedata(jFate.getText());
        try {
            TabelaRelatorio_1 aux = new TabelaRelatorio_1(""+
                   " select livro.codLivro as Codigo, livro.titulo as Titulo , sum(itens_venda.quantidade) as Quantidade  from itens_venda"
                   + " inner join livro on livro.codLivro = itens_venda.livro_codLivro"
                   +" inner join venda on venda.codVenda = itens_venda.venda_CodVenda"
                   +" where venda.data_venda BETWEEN '"+de+"' and '"+ate+"'"
                   +" group by livro.titulo order by Quantidade desc  limit 10");

            //TabelaRelatorio_1 aux =  new TabelaRelatorio_1("select codLivro as Codigo,titulo as Titulo,qtde_vendido as Quantidade_Vendido from livro where data_lanc BETWEEN '"+de+"' and '"+ate+"'  order by qtde_vendido desc  limit 10 ");
            aux.setVisible(true);


        }catch(SQLException  e) {
            javax.swing.JOptionPane.showMessageDialog(null, e);
        }
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
}//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMaisVendido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
