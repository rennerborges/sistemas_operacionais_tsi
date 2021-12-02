/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacaosemaforo;

/**
 *
 * @author renner
 */
public class Produtor extends Processo {
    
    public Produtor(int pid) {
        super(pid);
    }
    
    @Override
    public void executar(){
        if(super.getSituacao().equals(SLEEP)){
            throw new RuntimeException("Esse processo está dormindo");
        }
        
        try {
            int processo = super.getProcesso();
            
            if(processo == 0){
                Semaforos.downEmpty();
                super.setEstado(EXECUTANDO);
            }
            
            if(processo == 1){
                Semaforos.alterMutex();
            }
            
            if(processo == 2){
                Buffer.add("D"+ Buffer.getIdentificador());
            }
            
            if(processo == 3){
                Semaforos.alterMutex();
            }
            
            if(processo == 4){
                Semaforos.addFull();
                super.setEstado(PRONTO);

                setProcesso(0);
                
                return;
                
            }
             
            super.setProcesso(++processo);
            
        } catch (Exception e) {
            this.setSleep();
        }
    }
    
}
