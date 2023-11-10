package ArrayLista;
import java.util.*;
import javax.swing.JOptionPane;
import java.lang.Integer;
public class ExercicioArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        for (int i = 0 ; i<5; i++ ) {
        numeros.add(Integer.parseInt(JOptionPane.showInputDialog("Informe um numero")));
        }
        for(Integer i : numeros){
        System.out.println(i);
        }
        Collections.sort(numeros);
        for(Integer i : numeros){
            System.out.println(i);
        }
        Collections.reverse(numeros);
        for(Integer i : numeros){
            System.out.println(i);
        }
    }
}
