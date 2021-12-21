package br.classesprincipais;


import br.utilitario.Conexao;
import java.awt.HeadlessException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.io.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

//import utilitarios.conexao;



public class ImprimeProduto{
    Conexao aux = new Conexao();
    
public ImprimeProduto() {
try
{
    aux.conecta();
    aux.executeStatement("select * from livro ");
    JRResultSetDataSource jrRS = new JRResultSetDataSource(aux.getRs());
    JasperPrint jasperPrint = JasperFillManager.fillReport(
    "reportPro.jasper", new HashMap(), jrRS);
    JasperViewer.viewReport(jasperPrint,false);


}catch (Exception erro){
    JOptionPane.showMessageDialog(null,"deu errrrro ="+erro);
}
 }
    
public ImprimeProduto(String codigo) {
try
{
    aux.conecta();
    aux.executeStatement("select * from produto where codProduto =  "+codigo);
    JRResultSetDataSource jrRS = new JRResultSetDataSource(aux.getRs());
    JasperPrint jasperPrint = JasperFillManager.fillReport("reportPro.jasper", new HashMap(), jrRS);
    JasperViewer.viewReport(jasperPrint,false);

     JOptionPane.showMessageDialog(null,"xxxxxxxxx" );

}catch (JRException erro){
    JOptionPane.showMessageDialog(null,"deu erro2 ="+erro);
}       catch (HeadlessException erro) {
    JOptionPane.showMessageDialog(null,"deu erro2 ="+erro);
        }
 }


public ImprimeProduto(int senha) {
try
{

    
    String sql="";
    if (senha==2)
    {
        //Livros com estoque abaixo do livro
        sql = "select * from livro where estoque_atual < estoque_minimo";
    }
    
    
    aux.conecta();
    aux.executeStatement(sql);
    JRResultSetDataSource jrRS = new JRResultSetDataSource(aux.getRs());
    JasperPrint jasperPrint = JasperFillManager.fillReport(
    "RelLivrosEstoqueAbaixo.jasper", new HashMap(), jrRS);
    JasperViewer.viewReport(jasperPrint,false);


}catch (Exception erro){
    JOptionPane.showMessageDialog(null,"deu erro ="+erro);
}
 }

//Imprime detalhes do livro selecionado
public ImprimeProduto (String query,String x)
{
    try
    {
         aux.conecta();
        aux.executeStatement(query);
        JRResultSetDataSource jrRS = new JRResultSetDataSource(aux.getRs());
        JasperPrint jasperPrint = JasperFillManager.fillReport(
        "RelLivros.jasper", new HashMap(), jrRS);
        JasperViewer.viewReport(jasperPrint,false);

        
    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
    
}


public static void main (String ags[]){
    new ImprimeLivros("");

}
}
