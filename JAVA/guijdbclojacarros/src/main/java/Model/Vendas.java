package Model;

public class Vendas {
    //atributos
    String comprador;
    String carroVendido;
    String metodoPagamento;
    //constructor
    public Vendas(String comprador, String carroVendido, String metodoPagamento ){
        this.comprador = comprador;
        this.carroVendido = carroVendido;
        this.metodoPagamento = metodoPagamento;
    //getters and setters
    
    }
    public String getComprador() {
        return comprador;
    }
    public void setComprador(String comprador) {
        this.comprador = comprador;
    }
    public String getCarroVendido() {
        return carroVendido;
    }
    public void setCarroVendido(String carroVendido) {
        this.carroVendido = carroVendido;
    }
    public String getMetodoPagamento() {
        return metodoPagamento;
    }
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
