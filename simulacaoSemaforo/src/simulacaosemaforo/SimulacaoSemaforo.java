/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacaosemaforo;

import java.util.Random;

/**
 *
 * @author renner
 */
public class SimulacaoSemaforo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Produtor produtor = new Produtor(1);
        Consumidor consumidor = new Consumidor(2);
        Semaforos.init(produtor, consumidor);
        
        Processo cpu = produtor;
         
        for(int i = 1; i < 1000; i++){
            if(cpu.getSituacao().equals(Processo.WAKUP)){
              cpu.executar();
            }
            
            if(cpu.getProcesso() != 0 && cpu.getSituacao().equals(Processo.WAKUP)){
                continue;
            }
            
            int processoEscolhido;
            
            if(randomNumber(100) >= 20){
                processoEscolhido = 1;
                cpu = produtor;
            }else{
                processoEscolhido = 2;
                cpu = consumidor;

            }
                        
            if(cpu.getSituacao().equals(Processo.SLEEP)){
            
                if(processoEscolhido == 1){
                    cpu = consumidor;
                }else{
                    cpu = produtor;
                }
            
            }

        }
        
        Semaforos.print();
        System.out.println("---------------------");

        Buffer.print();
        System.out.println("---------------------");
        System.out.println("produtor= "+ produtor);
        System.out.println("consumidor= " + consumidor);

    }
    
    public static int randomNumber(int maxNumber){
        Random random = new Random();
        return random.nextInt(maxNumber);
    }
}
