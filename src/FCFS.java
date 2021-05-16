import java.util.ArrayList;

public class FCFS
{
    public Object[] executar (Processo[] processo_array){
        long start_time = System.currentTimeMillis();
        ArrayList<Long> tempos_execucao = new ArrayList<Long>();

        //Executa cada processo e grava o tempo total de execucao de cada um.
        for (int i = 0; i < processo_array.length; i++){
            processo_array[i].executarProcesso();

            long end_time = System.currentTimeMillis();
            tempos_execucao.add(end_time - start_time);
        }

        return new Object[] {tempos_execucao, (System.currentTimeMillis() - start_time)};
    }
}
