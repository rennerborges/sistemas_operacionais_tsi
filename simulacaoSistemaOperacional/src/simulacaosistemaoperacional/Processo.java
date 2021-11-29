/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacaosistemaoperacional;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author renner
 */
public class Processo {
    public static final String PRONTO = "PRONTO";
    public static final String BLOQUEADO = "BLOQUEADO";
    public static final String EXECUTANDO = "EXECUTANDO";
    
    private String ep = PRONTO;
    private int pid;
    private int tp;
    private int cp;
    private int nes;
    private int nCpu;
    private int qtdCiclos;
    private boolean isFinish = false;
    
    public void executar(){
 
        if(this.tp == this.qtdCiclos){
            return;
        }
        
        if(this.ep.equals(BLOQUEADO)){
            
            if(randomNumber(100) <= 30){
                this.setEp(PRONTO);
                return;
            }else{
                return;
            }
            
        }
        
        setEp(EXECUTANDO);
        this.nCpu++;

        for(int i=0; i < 1000; i++){
           
            if(this.tp == this.qtdCiclos){
                this.isFinish = true;
                System.out.println(this);
                setEp(PRONTO);

                return;
            }
            
            if(randomNumber(100) <= 5){
                setEp(BLOQUEADO);
                this.nes++;
                return;
            }
            
            ++this.tp;
            this.cp = this.tp+1;
            
        }

        setEp(PRONTO);

    }
    
    public int randomNumber(int maxNumber){
        Random random = new Random();
        return random.nextInt(maxNumber);
    }
    
    public Processo(int pid, int qtdCiclos) {
        this.pid = pid;
        this.qtdCiclos = qtdCiclos;
    }
    
    public boolean isFinish(){
        return this.isFinish;
    }
    
    public String getEp() {
        return ep;
    }

    public void setEp(String ep) {
        System.out.println(this);
        System.out.println(this.ep + " >>>> " + ep);
        TabelaProcessos.add(this);
        this.ep = ep;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getNes() {
        return nes;
    }

    public void setNes(int nes) {
        this.nes = nes;
    }

    public int getnCpu() {
        return nCpu;
    }

    public void setnCpu(int nCpu) {
        this.nCpu = nCpu;
    }

    public int getQtdCiclos() {
        return qtdCiclos;
    }

    public void setQtdCiclos(int qtdCiclos) {
        this.qtdCiclos = qtdCiclos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.ep);
        hash = 59 * hash + this.pid;
        hash = 59 * hash + this.tp;
        hash = 59 * hash + this.cp;
        hash = 59 * hash + this.nes;
        hash = 59 * hash + this.nCpu;
        hash = 59 * hash + this.qtdCiclos;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Processo other = (Processo) obj;
        if (this.pid != other.pid) {
            return false;
        }
        if (this.tp != other.tp) {
            return false;
        }
        if (this.cp != other.cp) {
            return false;
        }
        if (this.nes != other.nes) {
            return false;
        }
        if (this.nCpu != other.nCpu) {
            return false;
        }
        if (this.qtdCiclos != other.qtdCiclos) {
            return false;
        }
        if (!Objects.equals(this.ep, other.ep)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Processo{" + "ep=" + ep + ", pid=" + pid + ", tp=" + tp + ", cp=" + cp + ", nes=" + nes + ", nCpu=" + nCpu + ", qtdCiclos=" + qtdCiclos + '}';
    }

    
}
