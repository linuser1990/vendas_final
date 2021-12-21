/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.utilitario;

import java.sql.*;
public class Conexao {

    private String url = "jdbc:mysql://localhost:3305/venda_produtos";
    private String user="root";
    private String pass="1234";
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;

    public void executaSql(String sql)
    {
        try
        {
            setPs(getCon().prepareStatement(sql));
            setRs(getPs().executeQuery());
            //setRs2(getPs().executeQuery());
            
           

        }catch(Exception e)
        {

        }
        
    }

    public void executeStatement(String sql)
    {
        try
        {
            setSt(getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY));
            setRs(getSt().executeQuery(sql));
            //setRs2(getSt().executeQuery(sql));
            
          


        }catch(SQLException e)
        {
           // JOptionPane.showMessageDialog(null, e);
        }



    }
    
    

    public ResultSet executeResult(String sql)
    {
        try
        {
            setSt(getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY));
            setRs(getSt().executeQuery(sql));


            return getRs();
        }catch(SQLException e)
        {
           // JOptionPane.showMessageDialog(null, e);
        }
        return getRs();


    }


    public boolean conecta()
    {
        try
        {
            setCon(DriverManager.getConnection(url, user, pass));
           // System.out.print("conectou");
           // getCon().close();
           return true;
            
        }catch(SQLException e)
        {
            javax.swing.JOptionPane.showMessageDialog(null,e);
        }

        return true;
    }
    
    public void fechaConexao()
    {
        try
        {
            getCon().close();
            getPs().close();
            getRs().close();
            
        }catch(Exception e)
        {
            
        }
         
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */


    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the ps
     */
    public PreparedStatement getPs() {
        return ps;
    }

    /**
     * @param ps the ps to set
     */
    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * @return the st
     */
    public Statement getSt() {
        return st;
    }

    /**
     * @param st the st to set
     */
    public void setSt(Statement st) {
        this.st = st;
    }

    /**
     * @return the rs2
     */

}
