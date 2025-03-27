/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaDeTarefas.model;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TarefaDAO {

    // Método público para adicionar uma nova tarefa ao banco de dados
    public void adicionarTarefa(Connection conexao, Tarefa tarefa) {
        // Comando SQL para inserir uma nova tarefa na tabela 'tarefas'
        String sql = "INSERT INTO tarefas (titulo, descricao, data_vencimento, status) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Definindo os parâmetros do comando SQL com os dados da tarefa
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getDataVencimento());
            stmt.setString(4, tarefa.isStatus() ? "concluido" : "pendente");
            
            // Executa a atualização no banco de dados
            stmt.executeUpdate();
            
            // Exibe uma mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso!");
        } catch (SQLException e) {
            // Se ocorrer um erro durante a inserção, exibe uma mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao adicionar tarefa: " + e.getMessage());
        }
    }

    // Método para listar todas as tarefas no banco de dados
    public ArrayList<Tarefa> listarTarefas(Connection conexao) {
        String sql = "SELECT * FROM tarefas";
        ArrayList<Tarefa> lista = new ArrayList<>();
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            // Itera sobre os resultados e exibe as informações de cada tarefa
            while (rs.next()) {
                //int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                String dataVencimento = rs.getString("data_vencimento");
                String status = rs.getString("status");
                Boolean statusBoolean;
                
                if("Concluída".equals(status)){
                    statusBoolean = true;
                } else {
                    statusBoolean = false;
                }
                
                Tarefa novaTarefa = new Tarefa(titulo, descricao, dataVencimento, statusBoolean);
                novaTarefa.setId(rs.getInt("id"));
                lista.add(novaTarefa);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar tarefas: " + e.getMessage());
        }
        return lista;
    }

    // Método para atualizar o status de uma tarefa
    public void atualizarStatus1(Connection conexao, int id, boolean status) {
        String sql = "UPDATE tarefas SET status = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, status ? "concluido" : "pendente");
            stmt.setInt(2, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Status da tarefa atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar status: " + e.getMessage());
        }
    }
    
    public String getStatus(Connection conexao, int id){
        String sql = "SELECT status FROM tarefas WHERE id = ?";
        String status = "";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
        stmt.setInt(1, id);  // Define o ID como parâmetro na consulta
        ResultSet rs = stmt.executeQuery();  // Use executeQuery para consultas SELECT

        if (rs.next()) {  // Verifica se há um resultado
            status = rs.getString("status");  // Recupera o valor da coluna "status"
            JOptionPane.showMessageDialog(null, "Status da tarefa: " + status);
            
        } else {
            JOptionPane.showMessageDialog(null, "Tarefa não encontrada com o ID: " + id);
        }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar status: " + e.getMessage());
        }
        return status;
    }
    
    public void atualizarStatus2(Connection conexao, int id, String status){
        String sql = "UPDATE tarefas SET status WHERE id = ?";
        String indexN = Integer.toString(id);
        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, indexN);
            stmt.executeUpdate();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar status: " + e.getMessage());
        }
    }
    
    public void alterarTarefa(Connection conexao, int index, String tituloAlt, String descricaoAlt, String data_vencimentoAlt, String statusAlt){
        String sql = "UPDATE tarefas SET titulo = " + tituloAlt + ", descricao = " + descricaoAlt + ", data_vencimento = " + data_vencimentoAlt + ", status = " + statusAlt + " WHERE id = ?";
        String indexN = Integer.toString(index);
        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, indexN);
            stmt.executeUpdate();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tarefa: " + e.getMessage());
        }
    }

    // Método para excluir uma tarefa do banco de dados
    public void excluirTarefa(Connection conexao, int id) {
        String sql = "DELETE FROM tarefas WHERE id = ?";
        
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir tarefa: " + e.getMessage());
        }
    }
}