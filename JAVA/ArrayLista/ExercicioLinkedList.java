package ArrayLista;
import java.util.LinkedList;
public class ExercicioLinkedList {
    public static void main(String[] args) {
        //criar uma lista usando os elementos do LinkedList
        LinkedList<String> flores = new LinkedList<>();
        flores.add("Rosas");
        flores.add("Margaridas");
        flores.addFirst("Begônias");
        System.out.println(flores.getFirst());
    }
}
