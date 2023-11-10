package ArrayLista;

import java.util.HashMap;

public class ExemploHashMap {
    // criar HashMap de cidades
    public static void main(String[] args) {
        HashMap<String, String> capitaisCidades = new HashMap<>();
        capitaisCidades.put("SP", "São Paulo");
        capitaisCidades.put("RJ", "Rio de Janeiro");
        capitaisCidades.put("MG", "Belo Horizonte");
        capitaisCidades.put("ES", "Vitória");
        //imprime valor correspondente a chave
        System.out.println(capitaisCidades.get("ES"));
        // imprimir cidades
        System.out.println(capitaisCidades);
        // imprimir chaves
        System.out.println(capitaisCidades.keySet());
        //imprimir somente valores
        for (String i : capitaisCidades.keySet()) {
            System.out.println(capitaisCidades.get(i));
        }
    }
}
