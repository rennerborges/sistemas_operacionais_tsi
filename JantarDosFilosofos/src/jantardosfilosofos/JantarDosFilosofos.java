/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jantardosfilosofos;

import java.io.IOException;
import java.util.concurrent.Semaphore;

/**
 *
 * @author renner
 */
public class JantarDosFilosofos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Semaphore[] garfos = new Semaphore[5];

        for (int i = 0; i < garfos.length; i++) {
                garfos[i] = new Semaphore(1);
        }

        // Criação dos filósofos
        FilosofoFuncional fil0 = new FilosofoFuncional("Aristóteles", "O sábio nunca diz tudo o que pensa, mas pensa sempre tudo o que diz", garfos[0], garfos[4]);
        FilosofoFuncional fil1 = new FilosofoFuncional("Platão", "De todos os animais selvagens, o homem jovem é o mais difícil de domar", garfos[1], garfos[0]);
        FilosofoFuncional fil2 = new FilosofoFuncional("Nietzsche", "A vantagem de ter péssima memória é divertir-se muitas vezes com as mesmas coisas boas como se fosse a primeira vez", garfos[2], garfos[1]);
        FilosofoFuncional fil3 = new FilosofoFuncional("Wittgenstein", "As fronteiras da minha linguagem são as fronteiras do meu universo.", garfos[3], garfos[2]);
        FilosofoFuncional fil4 = new FilosofoFuncional("Descartes", "“Penso, logo existo", garfos[4], garfos[3]);

        // Execução dos filósofos
        fil0.start();
        fil1.start();
        fil2.start();
        fil3.start();
        fil4.start();

        // Aguardar o usuario pressionar qualquer tecla
        System.in.read();

        // Desativar os filósofos
        fil0.desativar();
        fil1.desativar();
        fil2.desativar();
        fil3.desativar();
        fil4.desativar();

        // Aguardar todos os filósofos finalizarem
        fil0.join();
        fil1.join();
        fil2.join();
        fil3.join();
        fil4.join();

        // Imprimir quantas porções cada filósofo comeu durante o jantar
        System.out.println("\n");
        System.out.println("Porções comidas pelos filosofos:");
        System.out.println("Filosofo "+ fil0.getNome() +". Porções comidas até agora: " + fil0.getPorcoesComidas());
        System.out.println("Filosofo "+ fil1.getNome() +". Porções comidas até agora: " + fil1.getPorcoesComidas());
        System.out.println("Filosofo "+ fil2.getNome() +". Porções comidas até agora: " + fil2.getPorcoesComidas());
        System.out.println("Filosofo "+ fil3.getNome() +". Porções comidas até agora: " + fil3.getPorcoesComidas());
        System.out.println("Filosofo "+ fil4.getNome() +". Porções comidas até agora: " + fil4.getPorcoesComidas());
    }
    
}
