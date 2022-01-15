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
public class FIFOSC {
    private static final int N = 0;
    private static final int I = 1;
    private static final int D = 2;
    private static final int R = 3;
    private static final int M = 4;
    
    
     public static void execute(int[][] disco, int[][] memoriaRam, ArrayList<Integer> instrucoesMemoria,int instrucao){
        for(int i = 0; i < instrucoesMemoria.size(); i++){
            int oldInstrucao = instrucoesMemoria.get(i);
            int indexMemoriaRam = getIndexMemoriaRam(memoriaRam, oldInstrucao);
            
            
            int indexDisco = instrucao -1;
            
//            Verifica se o R está 1
            if(memoriaRam[indexMemoriaRam][R] == 1){
                memoriaRam[indexMemoriaRam][R] = 0;
                instrucoesMemoria.remove(i);
                instrucoesMemoria.add(memoriaRam[indexMemoriaRam][I]);
                continue;
            }
            
            if(memoriaRam[indexMemoriaRam][M] == 1){
                int index = memoriaRam[indexMemoriaRam][N];
                disco[index][D] = memoriaRam[indexMemoriaRam][D];
            }

            instrucoesMemoria.remove(i);

            memoriaRam[indexMemoriaRam][N] = disco[indexDisco][N];
            memoriaRam[indexMemoriaRam][I] = disco[indexDisco][I];
            memoriaRam[indexMemoriaRam][D] = disco[indexDisco][D];
            memoriaRam[indexMemoriaRam][R] = 0;
            memoriaRam[indexMemoriaRam][M] = 0;

            instrucoesMemoria.add(instrucao);
            break;
        }
        
     }
     
     private static int getIndexMemoriaRam(int [][] memoriaRam, int instrucao){
        for(int i = 0 ; i < memoriaRam.length; i++){
            if(memoriaRam[i][I] == instrucao){
                return i;
            }
        }
        
        return -1;
     }

}
