/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacaosemaforo;

import java.util.ArrayList;

/**
 *
 * @author renner
 */
public class Buffer {
    private static int MAX_SIZE_BUFFER = 3;
    private static ArrayList<String> buffers = new ArrayList<>();
    private static int identificador = 1;
    
    public static void add(String dado){
        if(buffers.size() == MAX_SIZE_BUFFER){
            throw new RuntimeException("O Buffer já está cheio"); 
        }

        ++identificador;
        buffers.add(dado);
        
    }
    
    public static void remove(String dado){
        if(buffers.size() == 0){
            throw new RuntimeException("O Buffer já está vazio"); 
        }

        buffers.remove(dado);
        
    }
    
    public static int getIdentificador(){
        return identificador;
    }
}