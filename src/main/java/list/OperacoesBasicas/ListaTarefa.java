package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    //Atributo
    private List<Tarefa> tarefaList; // tarefaList é um atributo List do tipo
    // Tarefa

    //esse constructor serve para que sempre que criar um objeto do tipo
    // ListaTarefas, ele criará com um atributo tarefaList que conterá nele
    // um Arraylist vazio
    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        List<Tarefa> tarefasParaRemover = new ArrayList<>(); // essa função
        // criará essa variavel que possui uma lista vazia
        for (Tarefa t : tarefaList){ // faremos um laço para conseguir
            // percorrer Toodo o array
            if(t.getDescricao().equalsIgnoreCase(descricao)){ // Esse if irá
                // ver se a descrição da tarefa atual do laço é igual a da
                // descricao
                tarefasParaRemover.add(t);  // Caso seja, ele adicionará a o
                // objeto para sser removido de uma vez depois
            }
        }
        tarefaList.removeAll(tarefasParaRemover); // Com isso removeremos
        // todos objetos que contém a descrição pedida, de tarefaList
    }

    public int obterNumeroTotalTarefas(){
        return tarefaList.size();
    }

    public void obterDescricoesTarefas(){
        System.out.println(tarefaList);
    }


    public static void main(String[] args) { // metodo main criado para
        // testar tudo do ListaTarefa
        ListaTarefa listaTarefa = new ListaTarefa();

        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas()); // Para checar se o novo objeto ListaTarefa realmente inicializa vazio

        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas()); // Para checar se o objeto ListaTarefa teve tarefas adicionadas

        // Agora faremos o teste para mostrar a descrição das tarefas:
        //Para que ele mostra o valor corretamente, precisamos por um método
        // ToString em Tarefa.java para que ele converta o valor
        listaTarefa.obterDescricoesTarefas();

        //Agora faremos o teste para remover tarefas:
        listaTarefa.removerTarefa("Tarefa 1");
        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas()); // Para checar se o objeto ListaTarefa teve tarefas removidas


    }
}
