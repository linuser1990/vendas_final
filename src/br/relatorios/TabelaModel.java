/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.relatorios;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Tarcisio
 */
public class TabelaModel extends AbstractTableModel{
    private int linhas, colunas;
    private ResultSet rs;
    private ResultSetMetaData rsm;

    public TabelaModel (ResultSet rs) throws SQLException{
        this.rs=rs;
        rsm=rs.getMetaData();

        //Contando a quantidade de linhas de um result set
        rs.last();
        linhas = rs.getRow();

        //Notifica o JTable das alterações. Como se fosse um refresh para o JTable
        fireTableStructureChanged();
    }

    public int getRowCount() {
        return linhas;
    }

    public int getColumnCount() {
        //Determina o número de colunas
        try{
            return rsm.getColumnCount();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        //Se houver problemas, retorna o número de colunas = 0
        return 0;

    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        try{
            rs.absolute(rowIndex + 1);
            return rs.getObject(columnIndex + 1);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        //Se ocorrer erro, retorna vazio
        return "";
    }

    public String getColumnName(int column){
        //Descobre o nome da coluna
        try{
            return rsm.getColumnName(column + 1);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        //Se ocorrer erro, retorna uma string vazia
        return "";
    }
}
