package ArrayLista;
import java.util.HashMap;
public class ExercicioHashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> idadeN = new HashMap<>();
        idadeN.put("Ana","23");
        idadeN.put("Maria", "19");
        idadeN.put("Fernanda","27");
        System.out.println(idadeN);
        System.out.println(idadeN.keySet());
        System.out.println(idadeN.get("Ana"));

    }
}
