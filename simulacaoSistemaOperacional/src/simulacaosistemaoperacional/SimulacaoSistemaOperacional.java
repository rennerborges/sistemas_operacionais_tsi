/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacaosistemaoperacional;

import java.util.ArrayList;

/**
 *
 * @author renner
 */
public class SimulacaoSistemaOperacional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Processo> processos = new ArrayList<>();
        
        Processo processo0 = new Processo(0,10000);
        processos.add(processo0);
        
        Processo processo1 = new Processo(1,5000);
        processos.add(processo1);
        
        Processo processo2 = new Processo(2,7000);
        processos.add(processo2);
        
        Processo processo3 = new Processo(3,3000);
        processos.add(processo3);
        
        Processo processo4 = new Processo(4,3000);
        processos.add(processo4);
        
        Processo processo5 = new Processo(5,8000);
        processos.add(processo5);
        
        Processo processo6 = new Processo(6,2000);
        processos.add(processo6);
        
        Processo processo7 = new Processo(7,5000);
        processos.add(processo7);
        
        Processo processo8 = new Processo(8,4000);
        processos.add(processo8);
        
        Processo processo9 = new Processo(9,10000);
        processos.add(processo9);
        
        ArrayList<Integer> processosFinalizados = new ArrayList<>();
        int contador = 0;

        while(processosFinalizados.size() != processos.size()){
            
            Processo processo = processos.get(contador);
            
//            Vefica se o processo já terminou
            if(!processo.isFinish()){
                processo.executar();
                
//                Verificar se após o método executar rodar ele terminou sua operação
                if(processo.isFinish()){
                    processosFinalizados.add(processo.getPid());
                }

            }
            
           
            if(contador == processos.size()-1){
                contador = 0;
            }else{
                contador ++;
            }

        }
        
        System.out.println("----------------------------");
        for(Processo processo: processos){
            System.out.println(processo);
        }
        
        System.out.println("---------------------------");
        System.out.println("Ordem em que os processos foram finalizados: ");
        System.out.println(processosFinalizados);
        
    }
    
}
