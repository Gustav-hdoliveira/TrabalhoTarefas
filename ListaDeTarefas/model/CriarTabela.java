/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaDeTarefas.model;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class CriarTabela {
    public static void criarTabelaTarefas(Connection conexao){
        String sqlt = "CREATE TABLE IF NOT EXISTS tarefas (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "titulo VARCHAR(255) NOT NULL," +
            "descricao TEXT," +
            "data_vencimento DATE," +
            "status varchar(100));";
        
        try (Statement stmt = conexao.createStatement()) { 
            stmt.execute(sqlt); // Executa o comando SQL para criar a tabela
            System.out.println("Tabela 'tarefas' criada ou já existente."); // Exibe mensagem de sucesso
        } catch (Exception e) { // Captura exceções que possam ocorrer durante a execução
            System.out.println("Erro ao criar tabela: " + e.getMessage()); // Exibe mensagem de erro
        }
    }
}
