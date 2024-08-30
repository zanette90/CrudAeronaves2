package br.com.alan.model;

import java.util.ArrayList;
import java.util.List;

public class Aviao implements Comparable<Aviao>{
    private int registro;
    private String modelo;
    private int capacidade;
    public static List<Aviao> aviaoList = new ArrayList<>();
    public static int proximoReg = 1;
    public Aviao(String modelo, int capacidade) {
        this.registro = proximoReg++;
        this.modelo = modelo;
        this.capacidade = capacidade;
    }
    public int getRegistro() {
        return registro;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public static void addList(Aviao aviao) {
        aviaoList.add(aviao);
    }

    public static void removeList(Aviao aviao) {
        aviaoList.remove(aviao);
   }

    public static List<Aviao> getAviaoList() {
        return aviaoList;
    }

    @Override
    public String toString() {
        return "Aeronave: " +
                "registro: " + registro +
                " modelo: " + modelo +
                " capacidade: " + capacidade;
    }

    @Override
    public int compareTo(Aviao outroAviao) {
        return this.modelo.compareTo(outroAviao.modelo);
    }
}
