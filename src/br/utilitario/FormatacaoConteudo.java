/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utilitario;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

//Classe que insere cor nas celulas da jtable
public class FormatacaoConteudo extends DefaultTableCellRenderer implements TableCellRenderer {  
        @Override  
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {  
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  
            //Aqui você escreve o código que faz o setBackground para a cor desejada. Note que vc tem o valor da célula e a linha e coluna dela.  
            
            return this;  
        }  
    }  