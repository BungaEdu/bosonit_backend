import java.util.List;
import java.util.stream.Stream;

public class apuntes {
    public static void main(String[] args) {
        List<String> lista = List.of("Hola", "", "Java", "", "Concurrente", "Streams", "", "Java11", "Java12");
        Stream<String> stream = lista.stream(); //Convertimos la lista
        long conteo = stream.filter(perro -> perro.equals(""))
                .count();
        System.out.println(conteo); //5
    }
}
