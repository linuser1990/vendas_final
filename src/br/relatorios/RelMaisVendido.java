package br.relatorios;


import java.util.HashMap;
import javax.swing.JOptionPane;
import java.io.*;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import br.utilitario.Conexao;

//import utilitarios.conexao;



public class RelMaisVendido {
    Conexao con = new Conexao();
public RelMaisVendido()
{

}
public RelMaisVendido(String de,String ate) {
try
{
    con.conecta();
    //aux.executeStatement("SELECT * FROM ordemservico ORDER BY cod_os DESC  ;");
    //aux.executeStatement("SELECT * FROM ordemservico, where cod_os = "+codigo);
    
   // de ="2012-10-01";
   // ate="2012-12-25";
    
    con.executeStatement(""+
                   " select livro.codLivro as Codigo, livro.titulo as Titulo , sum(itens_venda.quantidade) as Quantidade  from itens_venda"
                   + " inner join livro on livro.codLivro = itens_venda.livro_codLivro"
                   +" inner join venda on venda.codVenda = itens_venda.venda_CodVenda"
                   +" where venda.data_venda BETWEEN '"+de+"' and '"+ate+"' "
                   +" group by livro.titulo order by Quantidade desc ");
                  
            
    
    /*con.executeStatement(""+
                   " select min(venda.data_venda)as de ,max(venda.data_venda)as ate,livro.codLivro as Codigo, livro.titulo as Titulo , sum(itens_venda.quantidade) as Quantidade  from itens_venda"
                   + " inner join livro on livro.codLivro = itens_venda.livro_codLivro "
                   +" inner join venda on venda.codVenda = itens_venda.venda_CodVenda "
                  
                  +" where venda.data_venda BETWEEN '1111-11-11' and '2012-12-12'"
                   +" group by livro.titulo order by Quantidade desc ");*/
    JRResultSetDataSource jrRS = new JRResultSetDataSource(con.getRs());
    JasperPrint jasperPrint = JasperFillManager.fillReport(
    "Relatorio_Livros_Mais_Vendido_Por_Data.jasper", new HashMap(), jrRS);
    JasperViewer.viewReport(jasperPrint,false);


}catch (Exception erro){
    JOptionPane.showMessageDialog(null,"deu erro ="+erro);
}
 }
public static void main (String ags[]){
    new RelMaisVendido();

}
}