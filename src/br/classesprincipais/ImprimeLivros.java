package br.classesprincipais;


import br.utilitario.Conexao;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.io.*;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

//import utilitarios.conexao;



public class ImprimeLivros {
    Conexao aux = new Conexao();
    
public ImprimeLivros() {
try
{
    aux.conecta();
    aux.executeStatement("select * from livro ");
    JRResultSetDataSource jrRS = new JRResultSetDataSource(aux.getRs());
    JasperPrint jasperPrint = JasperFillManager.fillReport(
    "RelLivros.jasper", new HashMap(), jrRS);
    JasperViewer.viewReport(jasperPrint,false);


}catch (Exception erro){
    JOptionPane.showMessageDialog(null,"deu erro ="+erro);
}
 }
    
public ImprimeLivros(String codigo) {
try
{
    aux.conecta();
    aux.executeStatement("select * from livro l"
        +" inner join autor a on (a.codAutor = l.autor_codAutor )"
        +" inner join editora e on (l.editora_codEditora = e.codEditora)"
        +" inner join categoria c on (l.categoria_codCategoria = c.codcategoria) where codLivro =  "+codigo);
    JRResultSetDataSource jrRS = new JRResultSetDataSource(aux.getRs());
    JasperPrint jasperPrint = JasperFillManager.fillReport(
    "RelLivroUnico.jasper", new HashMap(), jrRS);
    JasperViewer.viewReport(jasperPrint,false);


}catch (Exception erro){
    JOptionPane.showMessageDialog(null,"deu erro ="+erro);
}
 }


public ImprimeLivros(int senha) {
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
public ImprimeLivros (String query,String x)
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