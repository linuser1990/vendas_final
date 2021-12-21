package br.relatorios;


import java.util.HashMap;
import javax.swing.JOptionPane;
import java.io.*;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import br.utilitario.Conexao;
import javax.swing.JTextField;

//import utilitarios.conexao;



public class RelMaisComprou {
    Conexao con = new Conexao();
public RelMaisComprou()
{
    

}
public RelMaisComprou(String de,String ate) {
try
{
    String sql = "select cliente.codCliente,cliente.nome_cliente ,sum(itens_venda.quantidade) as Quantidade  from venda"
              +" inner join cliente on cliente.codCliente = venda.cliente_CodCliente "
              +" inner join itens_venda on venda.codVenda = itens_venda.venda_CodVenda"
              +" where venda.data_venda BETWEEN '"+de+"' and '"+ate+"'"
              +" group by cliente.nome_cliente order by   Quantidade desc ";
        
        con.conecta();
        con.executeStatement(sql);
        JRResultSetDataSource jrRS = new JRResultSetDataSource(con.getRs());
        JasperPrint jasperPrint = JasperFillManager.fillReport(
        "Relatorio_Cliente_Mais_Comprou_porData.jasper", new HashMap(), jrRS);
        JasperViewer.viewReport(jasperPrint,false);

}catch (Exception erro){
    JOptionPane.showMessageDialog(null,"deu erro ="+erro);
}
 }
public static void main (String ags[]){
    new RelMaisVendido();

}
}