/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacaosistemaoperacional;

import java.util.ArrayList;

/**
 *
 * @author renner
 */
public class TabelaProcessos {
    private static ArrayList<String> registros = new ArrayList<>();
    
    public static void add(Processo processo){
        int index = processo.getPid();
        
        try {
            registros.get(index);
            
            registros.set(index, processo.toString());
        } catch (Exception e) {
            registros.add(processo.toString());
        }

    }
    
    public static void list(){
        for(String registro : registros){
            System.out.println(registro);
        }
    }
    
}
