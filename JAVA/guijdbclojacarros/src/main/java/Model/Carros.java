package Model;

public class Carros {
    // atributos
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private double valor;
     // construtor
    public Carros(String marca, String placa, String modelo, int ano, double valor) {
        this.marca = marca;
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
    }
    // getters and setters
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
