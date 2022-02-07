/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jantardosfilosofos;

/**
 *
 * @author renner
 */
public abstract class Filosofo extends Thread {
    private boolean ativo = true;
    private int numero;
    private int porcoesComidas;
    private String nome;
    private String pensamento; 

    protected Filosofo(String nome, String pensamento) {
        this.nome = nome;
        this.pensamento = pensamento;
    }

    public void desativar() {
        this.ativo = false;
    }

    public int getPorcoesComidas() {
        return this.porcoesComidas;
    }

    protected void pensar() {
        System.out.println("Filosofo " + this.nome + " pensou: " + this.pensamento + " .");
    }

    protected void comer() {
        System.out.println("Filosofo " + this.nome + " comeu.");
        this.porcoesComidas++;
    }
    
    protected boolean getIsAtivo(){
        return this.ativo;
    }
    
    public String getNome(){
        return this.nome;
    }
}
