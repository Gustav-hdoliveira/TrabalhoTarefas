/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ListaDeTarefas.controller;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
import com.example.ListaDeTarefas.model.ConexaoSQLite;
import com.example.ListaDeTarefas.model.Tarefa;
import com.example.ListaDeTarefas.model.TarefaDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TarefaController {
    private TarefaDAO tarefaDAO;
    private Connection conexao;

    public TarefaController() {
        this.tarefaDAO = new TarefaDAO();
        conexao = ConexaoSQLite.conectar();
    }

    // Método para adicionar uma nova tarefa
    public String adicionarTarefa(String titulo, String descricao, String dataVencimento, String statusTexto) {
        try {
            boolean status = "concluido".equalsIgnoreCase(statusTexto);
            Tarefa tarefa = new Tarefa(0, titulo, descricao, dataVencimento, status);
            tarefaDAO.adicionarTarefa(conexao, tarefa);
            return "Tarefa adicionada com sucesso!";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    // Método para atualizar o status de uma tarefa
    public String atualizarStatus(int id, String statusTexto) {
        try {
            boolean status = "concluido".equalsIgnoreCase(statusTexto);
            tarefaDAO.atualizarStatus(conexao, id, status);
            return "Status da tarefa atualizado com sucesso!";
        } catch (Exception e) {
            return "Erro ao atualizar status: " + e.getMessage();
        }
    }

    // Método para listar todas as tarefas
    public String listarTarefas(int index) {
        ArrayList<String> tarefas = tarefaDAO.listarTarefas(conexao); // Lista todas as tarefas
        return tarefas.get(index);
      }
    }

    // Método para excluir uma tarefa
    public String excluirTarefa(int id) {
        try {
            tarefaDAO.excluirTarefa(id);
            
        } catch (Exception e) {
            return "Erro ao excluir tarefa: " + e.getMessage();
        }
        return "Tarefa excluída com sucesso!";
    }
}
