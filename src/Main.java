//Trabalho problema dos filosofos - Sistemas Operacionais
//Gabriel Braz e Santos - 260569

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int qtd_processos;
        int i;
        long total_fcfs = 0;
        long total_sjf = 0;
        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();

        //Precisamos decidir quantos processos ter.
        do
        {
            System.out.println("Insira a quantidade de processos para usar neste problema: (Ex. 6)");
            System.out.println("-> Pelo menos 1! <-");
            qtd_processos = scan.nextInt();
        } while(qtd_processos < 1);

        Processo[] processos_array = new Processo[qtd_processos];

        //Obter os dados de cada processo com o usuario.
        for (i = 0; i < qtd_processos; i++)
        {
            System.out.println("\n----");
            System.out.println("Processo ID #" + i + "!");
            processos_array[i] = new Processo();
            processos_array[i].construirProcesso(i, scan);
        }

        //Executar algoritmo FCFS
        System.out.println("\n----");
        System.out.println("Executando processos com algoritmo FCFS!");
        Object[] fcfs_return = fcfs.executar(processos_array);

        ArrayList<Long> tempos_execucao_fcfs = (ArrayList<Long>)fcfs_return[0];
        long overall_time_fcfs = (Long)fcfs_return[1];

        //Executar algoritmo SJF
        System.out.println("\n\n----");
        System.out.println("Executando processos com algoritmo SJF!");
        Object[] sjf_return = sjf.executar(processos_array);

        ArrayList<Long> tempos_execucao_sjf = (ArrayList<Long>)sjf_return[0];
        long overall_time_sjf = (Long)sjf_return[1];
        Integer[] ordem_processos_sjf = (Integer[])sjf_return[2];

        // -------------------- // --------------------

        System.out.println("\n--------------------");
        System.out.println("Tempo total de cada processo no algoritmo FCFS:");

        for (i = 0; i < qtd_processos ; i++){
            System.out.println("PID #"+ i + " - " + tempos_execucao_fcfs.get(i) + " ms");
            total_fcfs += tempos_execucao_fcfs.get(i);
        }

        System.out.println("\nMedia dos tempos de execucao FCFS:");
        System.out.println((total_fcfs/qtd_processos) + " ms");
        System.out.println("\nTempo total de execucao FCFS:");
        System.out.println(overall_time_fcfs + " ms");

        // -------------------- // --------------------

        System.out.println("\n--------------------");
        System.out.println("Tempo total de cada processo no algoritmo SJF, na ordem de execucao:");

        for (i = 0; i < qtd_processos ; i++){
            System.out.println("PID #"+ ordem_processos_sjf[i] + " - " + tempos_execucao_sjf.get(i) + " ms");
            total_sjf += tempos_execucao_sjf.get(i);
        }

        System.out.println("\nMedia dos tempos de execucao SJF:");
        System.out.println((total_sjf/qtd_processos) + " ms");
        System.out.println("\nTempo total de execucao SJF:");
        System.out.println(overall_time_sjf + " ms");
    }
}
