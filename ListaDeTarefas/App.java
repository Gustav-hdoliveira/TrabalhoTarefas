/*
 * This source file was generated by the Gradle 'init' task
 */
package ListaDeTarefas;

import ListaDeTarefas.model.ConexaoSQLite;
import ListaDeTarefas.model.CriarTabela;
import ListaDeTarefas.model.TarefaDAO;
import ListaDeTarefas.view.MainView;
import java.sql.Connection;

public class App {

    public static void main(String[] args) {
        Connection conexao = ConexaoSQLite.conectar();
        
        CriarTabela.criarTabelaTarefas(conexao);
        TarefaDAO tdao = new TarefaDAO();
        
        new MainView().setVisible(true);
    }
}
