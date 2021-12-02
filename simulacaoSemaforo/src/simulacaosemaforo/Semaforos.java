/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacaosemaforo;

/**
 *
 * @author renner
 */
public class Semaforos {
    private static int full = 0;
    private static int empty = Buffer.MAX_SIZE_BUFFER;
    private static boolean mutex = false;

    private static Produtor produtor;
    private static Consumidor consumidor;

    public static void init(Produtor p, Consumidor c) {
       produtor = p;
       consumidor = c;
    }

    static void init(Processo produtor, Processo consumidor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void downFull(){
        if(full == 0){          
            throw new RuntimeException("O semafóro full já está vazio");
        }
         
        --full;
    }
    
    public static void addFull(){
        if(full == Buffer.MAX_SIZE_BUFFER){
            throw new RuntimeException("O semafóro full já está cheio");
        }
  
        if(consumidor.getSituacao().equals(Processo.SLEEP)){
            consumidor.setWakup();
        }
        
        ++full;
    }

    public static void downEmpty(){
        if(empty == 0){
            throw new RuntimeException("O semafóro empty já está vazio");
        }
        
        --empty;
    }
    
    public static void addEmpty(){
        if(empty == Buffer.MAX_SIZE_BUFFER){
            throw new RuntimeException("O semafóro empty já está cheio");
        }
          
        if(produtor.getSituacao().equals(Processo.SLEEP)){
            produtor.setWakup();
        }
        
        ++empty;
    }
    
    public static void alterMutex(){
        mutex = !mutex;
    }
    
    public static void print(){
        System.out.println("------- Semafóros -------");
        System.out.println("full = " + full);
        System.out.println("empty = " + empty);
        System.out.println("mutex = " + mutex);

    }

}
