/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacaopaginacao;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author renner
 */
public class SimulacaoPaginacao {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    
    public static final int N = 0;
    public static final int I = 1;
    public static final int D = 2;
    public static final int R = 3;
    public static final int M = 4;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
//        Declarando as matrizes;
        int disco[][] = new int[100][5];
        int memoriaRam[][] = new int[10][5];
        
//        Inserindo os dados do disco;
        for(int i = 0; i < 100; i++){
            disco[i][N] = i;
            disco[i][I] = i+1;
            disco[i][D] = randomNumber(50);
            disco[i][R] = 0;
            disco[i][M] = 0;
        }
        
//        Inserindo na memoria ram;
        ArrayList<Integer> instrucoesMemoria = new ArrayList<>();
        
        while(instrucoesMemoria.size() < 10){
            int instrucao = randomNumber(100);
            
//            Verifico se a instrução já está na memória
            if(getValueByArrayList(instrucoesMemoria,instrucao) == 0){
                instrucoesMemoria.add(instrucao);
            }
        }
        
        for (int i = 0; i < instrucoesMemoria.size(); i++) {
            int instrucao = instrucoesMemoria.get(i);
            int indexDisco = instrucao - 1;
           
            memoriaRam[i][N] = disco[indexDisco][N];
            memoriaRam[i][I] = disco[indexDisco][I];
            memoriaRam[i][D] = disco[indexDisco][D];
            memoriaRam[i][R] = disco[indexDisco][R];
            memoriaRam[i][M] = disco[indexDisco][M];
        }
        
        for(int i = 0; i < 500; i++){
//             Gerando uma instrução aleatória
            int instrucao = randomNumber(100);
            int indexDisco = instrucao - 1;

//            Verificando se ela está na memória
            if(getValueByArrayList(instrucoesMemoria,instrucao) == 0){
                System.out.println(ANSI_YELLOW + "A instrução " + instrucao +" não está na memória!" + ANSI_RESET + " " + i);
                System.out.println("Instruções na memória: " + instrucoesMemoria);
                System.out.println("-------------"); 
               
//                Execução do NRU
                  NRU.execute(disco, memoriaRam, instrucoesMemoria, instrucao);
                  
////              Execução do FIFO
//                  FIFO.execute(disco, memoriaRam, instrucoesMemoria, instrucao);


//                Execução do FIFO-SC
                  FIFOSC.execute(disco, memoriaRam, instrucoesMemoria, instrucao);

//                Execução do FIFO-SC
//                  Relogio.execute(disco, memoriaRam, instrucoesMemoria, instrucao);


            }else{
                System.out.println(ANSI_GREEN + "A instrução " + instrucao + " está na memória!"  + ANSI_RESET + " " + i);
                System.out.println("Instruções na memória: " + instrucoesMemoria);
                System.out.println("-------------");

                int index = getIndexByInstrucao(memoriaRam, instrucao);

                memoriaRam[index][R] = 1;

                if(randomNumber(100) <= 30){
                    memoriaRam[index][M] = 1;
                    memoriaRam[index][D] += 1;
                }
            }
        }
        
    
       
    }
    
    public static int randomNumber(int maxNumber){
        Random random = new Random();
        
        int numberRandom = random.nextInt(maxNumber);
        
        if(numberRandom == 0){
            return randomNumber(maxNumber);
        }
        
        return numberRandom;
    }
    
    public static int getValueByArrayList(ArrayList<Integer> array,int instrucao){
        for (int i = 0; i < array.size(); i++) {
            if(array.get(i) == instrucao){
                return array.get(i);
            }
        }
        return 0;
    }

    public static int getIndexByInstrucao(int [][] memoriaRam ,int instrucao){
        for (int i = 0; i < memoriaRam.length; i++) {
            if(memoriaRam[i][I] == instrucao){
                return i;
            }
        }
        return 0;
    }

}
