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
    public static final int MAX_SIZE_BUFFER = 3;
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
    
    public static void removeLastPosition(){
        if(buffers.size() == 0){
            throw new RuntimeException("O Buffer já está vazio"); 
        }
        
        int index = buffers.size() - 1;
        buffers.remove(index);
    }
    
    public static int getIdentificador(){
        return identificador;
    }
    
    public static void list(){
        System.out.println(buffers);
    }
    
    public static void print(){
        System.out.println("buffers= " + buffers +", size = " + buffers.size());
    }
}
