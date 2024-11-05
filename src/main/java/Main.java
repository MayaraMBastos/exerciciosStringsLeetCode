import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        anagrama(s,t);

    }

    public static boolean anagrama(String s , String t) {
        // Convertendo as Strings em listas ordenadas
        List<Character> sortedListS = s.chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .collect(Collectors.toList());

        List<Character> sortedListT = t.chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .collect(Collectors.toList());
        // Se a ListS for igual a ListT então elas contem os mesmos caracteres e sao um anagrama
        if (sortedListS.equals(sortedListT)) {
            return true;
        }
        return false;
    }

}
