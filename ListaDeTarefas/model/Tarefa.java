/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaDeTarefas.model;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class Tarefa {
    private int id;               // Identificador único da tarefa
    private String titulo;        // Nome da tarefa
    private String descricao;     // Detalhes sobre a tarefa
    private String dataVencimento; // Prazo para concluir a tarefa (em formato String)
    private boolean status;       // Status da tarefa (false para pendente, true para concluída)

    // Construtor da classe
    public Tarefa(String titulo, String descricao, String dataVencimento, boolean status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.status = status;
    }

    // Getters e Setters para acessar e modificar os atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Método para exibir os detalhes da tarefa
    public void exibirTarefa() {
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data de Vencimento: " + dataVencimento);
        System.out.println("Status: " + (status ? "Concluída" : "Pendente"));
    }
}
