/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacaopaginacao;

import java.util.ArrayList;

/**
 *
 * @author renner
 */
public class NRU {
    private static final int N = 0;
    private static final int I = 1;
    private static final int D = 2;
    private static final int R = 3;
    private static final int M = 4;
    private static int indexClock = 0;
    
    
    public static void execute(int[][] disco, int[][] memoriaRam, ArrayList<Integer> instrucoesMemoria,int instrucao){
//        Resetando R
        if(indexClock == 10){
            resetR(memoriaRam);
            indexClock = 0;
        }
        
//        Classe 0
        for(int i = 0 ; i < 10; i++){
            if(memoriaRam[i][R] == 0 && memoriaRam[i][M] == 0){
                removeInstrucaoMemoria(disco, memoriaRam, instrucoesMemoria, i, instrucao, memoriaRam[i][I]);
                return;
            }
        }
        
//        Classe 1
        for(int i = 0 ; i < 10; i++){
            if(memoriaRam[i][R] == 0 && memoriaRam[i][M] == 1){
                removeInstrucaoMemoria(disco, memoriaRam, instrucoesMemoria, i, instrucao, memoriaRam[i][I]);
                return;
            }
        }
        
//        Classe 2
        for(int i = 0 ; i < 10; i++){
            if(memoriaRam[i][R] == 1 && memoriaRam[i][M] == 0){
                removeInstrucaoMemoria(disco, memoriaRam, instrucoesMemoria, i, instrucao, memoriaRam[i][I]);
                return;
            }
        }
        
//        Classe 3
        for(int i = 0 ; i < 10; i++){
            if(memoriaRam[i][R] == 1 && memoriaRam[i][M] == 1){
                removeInstrucaoMemoria(disco, memoriaRam, instrucoesMemoria, i, instrucao, memoriaRam[i][I]);
                return;
            }
        }
        
        
        System.out.println("Deu erro e passei aqui");
    }
    
    private static void resetR(int[][] memoriaRam){
        for(int i = 0 ; i < 10; i++){
            memoriaRam[i][R] = 0;
        }
    }
    
    private static void removeInstrucaoMemoria(int[][] disco, int[][] memoriaRam, ArrayList<Integer> instrucoesMemoria,int indexOldInstrucao,int newInstrucao, int oldInstrucao){
//        Atualizando da RAM para o disco;
        if(memoriaRam[indexOldInstrucao][M] == 1){
            int index = memoriaRam[indexOldInstrucao][N];
            disco[index][D] = memoriaRam[indexOldInstrucao][D];
        }
        
        int indexInstrucoesMemoria = getIndexByArrayList(instrucoesMemoria, oldInstrucao);
        instrucoesMemoria.set(indexInstrucoesMemoria, newInstrucao);
        
        int indexNewInstrucao = newInstrucao -1;
        
        memoriaRam[indexOldInstrucao][N] = disco[indexNewInstrucao][N];
        memoriaRam[indexOldInstrucao][I] = disco[indexNewInstrucao][I];
        memoriaRam[indexOldInstrucao][D] = disco[indexNewInstrucao][D];
        memoriaRam[indexOldInstrucao][R] = 0;
        memoriaRam[indexOldInstrucao][M] = 0;
    }
    
    private static int getIndexByArrayList(ArrayList<Integer> array,int instrucao){
        for (int i = 0; i < array.size(); i++) {
            if(array.get(i) == instrucao){
                return i;
            }
        }
        return 0;
    }
}
