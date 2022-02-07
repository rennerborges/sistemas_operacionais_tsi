/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jantardosfilosofos;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author renner
 */
public class FilosofoFuncional extends Filosofo {
	private Semaphore garfoEsquerdo;
	private Semaphore garfoDireito;

	public FilosofoFuncional(String nome, String pensamento, Semaphore garfoEsq, Semaphore garfoDir) {
            super(nome, pensamento);
            this.garfoEsquerdo = garfoEsq;
            this.garfoDireito = garfoDir;
	}

	@Override
	public void run() {
            Random rand = new Random();
            try {
                while (super.getIsAtivo()) {
                    pensar();
                    boolean comeu = false;
                    do {
                        garfoEsquerdo.acquire();
                        
                        // Aqui ele ganha um tempo para adquirir o garfo;
                        boolean pegou = garfoDireito.tryAcquire(1000, TimeUnit.MILLISECONDS);
                        
                        //Se o filosofo não conseguir pegar o 2° garfo ele libera o primeiro
                        if (pegou) {
                            comer();
                            comeu = true;
                            // libera os 2 garfos
                            garfoDireito.release();
                            garfoEsquerdo.release();
                        } else {
                            // libera o garfo que havia tomado posse e aguarda
                            garfoEsquerdo.release();
                            sleep(500 + rand.nextInt(500));
                        }
                    } while (!comeu);
                }
            } catch (InterruptedException e) {
                System.out.println("Filosofo " + super.getName() + " interrompido. Abortando.");
                e.printStackTrace();
            }
	}
}
