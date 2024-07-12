package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }


    public void adicionarEvento(LocalDate data, String nome, String atracao){
        eventosMap.put(data, new Evento(nome, atracao));
    }


    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap); // Por já estender de comparable, treemap já ordena por ordem crescente. Daí basta
        // criar um novo Treemap e passar nosso atributo eventosMap como parâmetro
        System.out.println(eventosTreeMap);
    }


    public void obterProximoEvento(){
        /* 1o metodo:
        > Temos aqui duas variaveis, uma recebe todas as keys e outra recebe todos os valores mas uma não se comunica com a outra:
            Set<LocalDate> dataSet = eventosMap.keySet();
            Collection<Evento> value = eventosMap.values();
        > Mas como precisamos pegar uma key e retornar um evento, esse metodo não satisfaz a situação*/

        /* 2o metodo:
        > Esse proximo metodo retorna o evento que está pedindo a partir de uma key, mas ele não sabe qual é o próximo evento
            eventosMap.get();
        > Mas esse metodo exige que voce ponha a key do proximo evento, que não sabemos ainda */

        // 3o metodo:
        // primeiro de tudo, precisamos fazer um sistema para que ele sempre dê a data atual. Para isso usaremos uma funcionalidade da class LocalDate:
        LocalDate dataAtual = LocalDate.now();
        // Agora precisamo fazer uma forma de que possamos navegar dentro do nosso map  para sabermos se o proximo evento é o da data atual ou de depois da
        // data atual. Para isso, vamos ordenar o eventosmap em uma TreeMap:
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        //Agora vamos usar o metodo Entry, de Map, para percorrer um laço em eventosMap:
        for (Map.Entry<LocalDate, Evento> entry : eventosMap.entrySet()) { // o metodo entrySet retorna um Set que em cada elemento dele contém um obj que
            // aponta para a key e para o value
            LocalDate proximaData = null;
            Evento proximoEvento = null;
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) { // Se o valor da key(data) for igual a atual ou a uma data futura,
                // ele mosttrará qual é o evento
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O próximo evento: " + proximoEvento + " Acontecerá na data " + proximaData);
                break;
            }
        }
    }






    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        //Para mostrar a data de hoje
        System.out.println(LocalDate.now());

        // Adiciona eventos à agenda
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
        agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JULY, 11), "Hackathon de Inovação", "Competição de soluções criativas");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 20), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");

        // Exibe a agenda completa de eventos
        agendaEventos.exibirAgenda();

        // Obtém e exibe o próximo evento na agenda
        agendaEventos.obterProximoEvento();
    }
}
