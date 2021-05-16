import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Processo
{
    private int nome;
    private int tempo_execucao_total = 0;

    public int getNome()
    {
        return nome;
    }

    public int getTempo_execucao_total()
    {
        return tempo_execucao_total;
    }

    //Funcao para construir o processo atual.
    public void construirProcesso(int id, Scanner scan){
        this.nome = id;

        do
        {
            System.out.println("Insira o tempo de execucao total deste processo em segundos:");
            System.out.println("-> Pelo menos um segundo! <-");
            tempo_execucao_total = scan.nextInt();
        } while (tempo_execucao_total == 0);
    }

    //Executa o processo baseado no tempo de execucao inserido.
    public void executarProcesso(){
        System.out.print("\nExecutando processo ID #" + this.nome);
        try
        {
            Thread.sleep(tempo_execucao_total * 1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.print(" - Fim!");
    }
}
