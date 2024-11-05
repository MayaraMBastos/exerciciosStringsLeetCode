import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
       // anagrama(s, t);
findTheDifference(s,t);
    }

    //metodo para descobrir se uma string é um anagrama de outra
    public static boolean anagrama(String s, String t) {
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
            System.out.println("true");
            return true;
        }
        return false;
    }

    //metodo para achar qual caractere foi adicionado a uma string
    public static char findTheDifference(String s, String t) {
        List<Character> listS = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        List<Character> listT = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        for (Character lt : listT) {
            if (!listS.contains(lt)) {
                System.out.println(lt);
                return lt;
            } else {
                // Remove the character from listS to account for duplicate occurrences
                listS.remove(lt);
            }
        }

        return 'A';
    }
}
