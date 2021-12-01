/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacaosemaforo;

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
        
        for(int i = 0; i < 25; i++){
              produtor.executar();
//            Verificar se o processo está em wackup;
//            cpu.executar();
//            70% de chances de ser um processo produtor se o mesmo estiver em sleep chama o consumidor a mesma coisa no contrário
        }
        System.out.println(produtor);
    }
    
}
