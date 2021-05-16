import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SJF
{
    public Object[] executar (Processo[] processo_array){
        long start_time = System.currentTimeMillis();

        Integer[] id_processos = new Integer[processo_array.length];
        ArrayList<Integer[]> lista_processo_tempo = new ArrayList<Integer[]>();
        ArrayList<Long> tempos_execucao = new ArrayList<Long>();
        int i;

        System.out.println("\nVerificando ordem dos processos, baseados no tempo de execucao...");

        //Cria uma ArrayList com uma lista de arrays
        //Os arrays sao a ID do processo, e seu tempo de execucao
        // Arraylist =
        // {ID, tempo},
        // {ID, tempo},
        // {ID, tempo},
        for (i = 0; i < processo_array.length; i++){
            lista_processo_tempo.add(new Integer[] {processo_array[i].getNome(), processo_array[i].getTempo_execucao_total()});
        }

        //Agora podemos usar Collections.sort, com uma regra customisada para ordenar nosso arraylist
        //Ordenaremos baseado no segundo valor de cada array dentro do arraylist,
        //Para ter uma lista ordenada baseado no tempo, de menor para maior.
        Collections.sort(lista_processo_tempo, new Comparator<Integer[]>() {
            public int compare(Integer[] first, Integer[] second) {
                return first[1].compareTo(second[1]);
            }
        });

        //Pega somente as IDs desta lista, para poder ter a ordem de execucao destes processos.
        for (i = 0; i < processo_array.length; i++){
            id_processos[i] = lista_processo_tempo.get(i)[0];
        }

        //Executa cada processo e grava o tempo total de execucao de cada um.
        for (i = 0; i < processo_array.length; i++){
            processo_array[id_processos[i]].executarProcesso();

            long end_time = System.currentTimeMillis();
            tempos_execucao.add(end_time - start_time);
        }

        return new Object[] {tempos_execucao, (System.currentTimeMillis() - start_time), id_processos};
    }


}
