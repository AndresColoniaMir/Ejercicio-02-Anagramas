import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la primera palabra: ");
        String palabra1 = scanner.next();

        System.out.print("Ingrese la segunda palabra: ");
        String palabra2 = scanner.next();

        String resultado = sonAnagramas(palabra1, palabra2) ? "¡Son Anagramas!" : "No son Anagramas.";
        System.out.print(resultado);

        scanner.close();
    }

    public static boolean sonAnagramas(String palabra1, String palabra2) {
        if (palabra1.trim().toLowerCase().equals(palabra2) || palabra1.trim().toLowerCase().length() != palabra2.trim().toLowerCase().length())
            return false;
        return mismasLetras(palabra1, palabra2);
    }

    public static boolean mismasLetras(String palabra1, String palabra2) {
        Map<Character, Integer> frecuenciaPalabra1 = new HashMap<>();
        Map<Character, Integer> frecuenciaPalabra2 = new HashMap<>();
        String[] palabras = { palabra1.trim().toLowerCase(), palabra2.trim().toLowerCase() };

        for (int i = 0; i < 2; i++) {
            for (char letra : palabras[i].toCharArray()) {
                if (i == 0) {
                    frecuenciaPalabra1.put(letra, frecuenciaPalabra1.getOrDefault(letra, 0) + 1);
                } else if (i == 1) {
                    frecuenciaPalabra2.put(letra, frecuenciaPalabra2.getOrDefault(letra, 0) + 1);
                }
            }
        }

        return frecuenciaPalabra1.equals(frecuenciaPalabra2);
    }
}
