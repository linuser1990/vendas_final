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



public class RelVendasMes {
    Conexao con = new Conexao();
public RelVendasMes(String codigo) {
try
{
    con.conecta();
    //aux.executeStatement("SELECT * FROM ordemservico ORDER BY cod_os DESC  ;");
    //aux.executeStatement("SELECT * FROM ordemservico, where cod_os = "+codigo);
    con.executeStatement("select * from view_venda");
    JRResultSetDataSource jrRS = new JRResultSetDataSource(con.getRs());
    JasperPrint jasperPrint = JasperFillManager.fillReport(
    "relatorios/OS_ENTRADA.jasper", new HashMap(), jrRS);
    JasperViewer.viewReport(jasperPrint,false);


}catch (Exception erro){
    JOptionPane.showMessageDialog(null,"deu erro ="+erro);
}
 }
public static void main (String ags[]){
    new RelVendasMes("");

}
}