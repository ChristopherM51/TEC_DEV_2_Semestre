package ArrayLista;

//
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.*;
//
public class ExemploArrayList {
    public static void main(String[] args) {
        // criar a Arraylista de String com obj de nome carros
        ArrayList<String> carros = new ArrayList<String>();
        // adicionar elemtos
        carros.add(JOptionPane.showInputDialog("Informe o nome de um carro"));
        carros.add("Brasilia");
        carros.add("Chevette");
        carros.add("Monza");
        carros.add("Gol");
        for (int i = 0; i < carros.size(); i++) {
            System.out.println(carros.get(i));
        }
        //ordenar uma lista (sort - Collections)
        Collections.sort(carros);
        Collections.reverse(carros);
        //iterando com o for-each
        for(String i : carros){
            System.out.println(i);
        }
        carros.clear();
        System.out.println(carros);
    }
}
