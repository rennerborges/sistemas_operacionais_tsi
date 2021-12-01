/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacaosemaforo;

/**
 *
 * @author renner
 */
public class Consumidor extends Processo {

    public Consumidor(int pid) {
        super(pid);
    }

    
    @Override
    public void executar(){
        System.out.println("Produtor");
    }    
}
