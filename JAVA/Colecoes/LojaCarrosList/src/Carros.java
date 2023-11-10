package Colecoes.LojaCarrosList.src;

import javax.swing.JOptionPane;

public class Carros {
    //atributos (Marca, Modelo, Ano, Cor)
    String marca;
    String modelo;
    String ano;
    String cor;
    String placa;
    //construtor cheio
    public Carros(String marca, String modelo, String ano, String cor,String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
    }
    //construtor vazio
    public Carros() {
    }
    //métodos
    //getters and setters
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
     public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String ImprimirLN() {
        String imprimir = marca+""+modelo+""+ano+""+cor+""+placa+"\n";
        return imprimir;
    }
    public void imprimir(){
        JOptionPane.showMessageDialog(null, marca+modelo+ano+cor+ placa);
    }
}
