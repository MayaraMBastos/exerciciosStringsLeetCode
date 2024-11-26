import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String s = sc.next();
        //String t = sc.next();
        // anagrama(s, t);
        //findTheDifference(s, t);
        //char s[] = {'h', 'e', 'l', 'l', 'o' };
        //reverseString(s);

//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] banned = {"hit"};
//        mostCommonWord(paragraph, banned);
//        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
//        findRepeatedDnaSequences(s);
        String s = "bcabc";
        removeDuplicateLetters(s);
    }

    //metodo para descobrir se uma string é um anagrama de outra
//    public static boolean anagrama(String s, String t) {
//        // Convertendo as Strings em listas ordenadas
//        List<Character> sortedListS = s.chars()
//                .mapToObj(c -> (char) c)
//                .sorted()
//                .collect(Collectors.toList());
//
//        List<Character> sortedListT = t.chars()
//                .mapToObj(c -> (char) c)
//                .sorted()
//                .collect(Collectors.toList());
//        // Se a ListS for igual a ListT então elas contem os mesmos caracteres e sao um anagrama
//        if (sortedListS.equals(sortedListT)) {
//            System.out.println("true");
//            return true;
//        }
//        return false;
//    }




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

    //metodo para imprimir a string ao contrario
    public static void reverseString(char[] s) {

        char t[] = new char[s.length];

        for (int i = 0; i < s.length; i++) {
            t[i] = s[(s.length - 1) - i]; // Copia os elementos em ordem inversa
        }
        System.out.println(Arrays.toString(t));
    }

    //metodo para achar a palavra mais usada, exeto palavras banidas
    public static String mostCommonWord(String paragraph, String[] banned) {
        // se contem a palavra banida
        int contagem = 1;

        //separar a string em arrey com cada palavra
        String[] paraArray = paragraph.split(" ");
        String ban = banned[0];

        // Percorrendo o array e contando as ocorrências
        for (String palavra : paraArray) {
            if (palavra.equals(ban)) {
                contagem++;
                // deletar palavra
            }
        }
        System.out.println(contagem);


        return "resultado";
    }

    //metodo para achar sequencias de DNA repetidas
    public static List<String> findRepeatedDnaSequences(String s) {

        //sao sequencias de 10 chars ,dividir em strings com ate 10 chars
        Set dna = new HashSet(), repeatidas = new HashSet();

        for (int i = 0; i + 9 < s.length(); i++) {
            String dez = s.substring(i, i + 10);
            if (!dna.add(dez))
                repeatidas.add(dez);
        }
        System.out.println(repeatidas);
        return new ArrayList(repeatidas);

    }

    //metodos paa remover letras duplicadas
    public static String removeDuplicateLetters(String s) {
        Set<Character> setString = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        String resultado = setString.stream()
                .map(String::valueOf) // Converte cada Character para String
                .collect(Collectors.joining());
        System.out.println(resultado);
        return resultado;
    }
}
