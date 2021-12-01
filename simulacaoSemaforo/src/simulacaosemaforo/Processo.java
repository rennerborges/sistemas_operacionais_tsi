/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacaosemaforo;

import java.util.Objects;

/**
 *
 * @author renner
 */
public abstract class Processo {
    public static final String PRONTO = "PRONTO";
    public static final String EXECUTANDO = "EXECUTANDO";
    
    public static final String SLEEP = "SLEEP";
    public static final String WAKUP = "WAKUP";

    private String estado = PRONTO;
    private String situacao = WAKUP;
    private int pid;
    private int processo = 0;

    public Processo(int pid) {
        this.pid = pid;
    }
    
    public abstract void executar();

    public String getEstado() {
        return estado;
    }

    public void setSleep(){
        this.situacao = SLEEP;
    }
    
    public void setWakup(){
        this.situacao = WAKUP;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getProcesso() {
        return processo;
    }

    public void setProcesso(int processo) {
        this.processo = processo;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.estado);
        hash = 53 * hash + Objects.hashCode(this.situacao);
        hash = 53 * hash + this.pid;
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
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.situacao, other.situacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Processo{" + "estado=" + estado + ", situacao=" + situacao + ", pid=" + pid + '}';
    }
    
}
