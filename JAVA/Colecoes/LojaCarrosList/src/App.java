package Colecoes.LojaCarrosList.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        // cadastrar novo carro
        // Listar carros
        // consultar carro
        // Excluir carro
        HashMap<String, Carros> placaCarro = new HashMap<>();
        List<Carros> listCarros = new ArrayList<>(0);
        boolean aberto = true;
        while (aberto) {
            int acao1 = (Integer.parseInt(JOptionPane.showInputDialog(
                    "1- Cadastrar novo carro\n" +
                            "2- Listar carro cadastrado\n" +
                            "3- Consultar carro\n" +
                            "4- Excluir carro\n" +
                            "5- Sair")));
            if (acao1 == 1) { // cadastrar carros
                String marcaCar = JOptionPane.showInputDialog("Informe a marca do carro");
                String modeloCar = JOptionPane.showInputDialog("Informe o modelo do carro");
                String anoCar = JOptionPane.showInputDialog("Informe o ano do carro");
                String corCar = JOptionPane.showInputDialog("Informe a cor carro");
                String placaCar = JOptionPane.showInputDialog("Informe a placa carro");
                Carros car = new Carros(marcaCar, modeloCar, anoCar, corCar, placaCar);
                placaCarro.put(placaCar, car);
                listCarros.add(car);
            } else if (acao1 == 2) { // Listar carros
                String listar = "";
                for (String lista : placaCarro.keySet()) {
                    listar += placaCarro.get(lista).ImprimirLN();
                }
                JOptionPane.showMessageDialog(null, listar);
            } else if (acao1 == 3) {
                String consultar = (JOptionPane.showInputDialog("Informe a placa do carro"));
                JOptionPane.showMessageDialog(null, placaCarro.get(consultar).ImprimirLN());
            } else if (acao1 == 4) {
                String consultar = (JOptionPane.showInputDialog("Informe a placa do que deseja apagar carro"));
                JOptionPane.showMessageDialog(null, placaCarro.get(consultar).ImprimirLN());
                placaCarro.remove(consultar);
            }
        }
    }
}

