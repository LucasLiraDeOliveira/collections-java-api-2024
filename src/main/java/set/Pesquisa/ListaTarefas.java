package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }


    //Adiciona uma nova tarefa ao Set.
    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao, false));
    }


    //Remove uma tarefa do Set de acordo com a descrição, se estiver presente.
    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet){
                if (t.getDescricao().equalsIgnoreCase(descricao))
                    tarefaParaRemover = t;
                break;
            }
            tarefaSet.remove(tarefaParaRemover);
        } else
            System.out.println("A lista de tarefas está vazia");

        if(tarefaParaRemover == null) {
            System.out.println("Tarefa não encontrada!");
        }
    }


    //Exibe todas as tarefas da lista de tarefas.
    public void exibirTarefas(){
        if(!tarefaSet.isEmpty()){
            System.out.println(tarefaSet);
        } else
            System.out.println("Não há tarefas na lista");
    }


    //Conta o número total de tarefas na lista de tarefas.
    public int contarTarefas(){
        return tarefaSet.size();
    }


    //Retorna um Set com as tarefas concluídas.
    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();

        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet){
                if (t.isConcluido() == true)
                    tarefasConcluidas.add(t);
            }
            return tarefasConcluidas;
        } else
            throw new RuntimeException("Não há tarefas concluídas!");
    }


    //Retorna um Set com as tarefas pendentes.
    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();

        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet){
                if (t.isConcluido() == false)
                    tarefasPendentes.add(t);
            }
            return tarefasPendentes;
        } else
            throw new RuntimeException("Não há tarefas pendentes!");
    }


    //Marca uma tarefa como concluída de acordo com a descrição.
    public void marcarTarefaConcluida(String descricao){
        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet){
                if (t.getDescricao().equalsIgnoreCase(descricao))
                    t.setConcluido(true);
                break;
            }
        } else
            System.out.println("A lista de tarefas está vazia");
    }


    //Marca uma tarefa como pendente de acordo com a descrição.
    public void marcarTarefaPendente(String descricao){
        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet){
                if (t.getDescricao().equalsIgnoreCase(descricao))
                    t.setConcluido(false);
                break;
            }
        } else
            System.out.println("A lista de tarefas está vazia");
    }


    public void limparListaTarefas() {
        if(tarefaSet.isEmpty()) {
            System.out.println("A lista já está vazia!");
        } else {
            tarefaSet.clear();
        }
    }


    public static void main(String[] args) {
        // Criando uma instância da classe ListaTarefas
        ListaTarefas listaTarefas = new ListaTarefas();

        System.out.println("A lista inicialmente tem " + listaTarefas.contarTarefas() + " tarefa(s)");
        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");


        // Exibindo as tarefas na lista
        listaTarefas.exibirTarefas();

        // Removendo uma tarefa
        listaTarefas.removerTarefa("Fazer exercícios físicos");
        listaTarefas.exibirTarefas();

        // Contando o número de tarefas na lista
        System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

        // Obtendo tarefas pendentes
        System.out.println(listaTarefas.obterTarefasPendentes());

        // Marcando tarefas como concluídas
        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        // Obtendo tarefas concluídas
        System.out.println(listaTarefas.obterTarefasConcluidas());

        // Marcando tarefas como pendentes
        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        // Limpando a lista de tarefas
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
