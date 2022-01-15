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
            System.out.println("instrucao" + instrucao);
            int indexDisco = instrucao - 1;
           
            memoriaRam[i][N] = disco[indexDisco][N];
            memoriaRam[i][I] = disco[indexDisco][I];
            memoriaRam[i][D] = disco[indexDisco][D];
            memoriaRam[i][R] = disco[indexDisco][R];
            memoriaRam[i][M] = disco[indexDisco][M];
        }
        
        System.out.println(memoriaRam[0][N]);
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
}
