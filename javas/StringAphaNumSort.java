package javas;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a String of size N containing different alpha-numeric chars,
 * sort the given String in a special way.
 * If the ASCII value of the character is even, then add 20 to its ASCII value, keeping the character the same.
 * If the ASCII value of the character is odd, then double its ASCII value, keeping the character the same.
 *
 * Sort the string according to the updated ASCII values of the characters and print them
 * The give string will contain only numeric or uppercase letters
 *
 * Sample input
 * 10
 * 5ASD12ASDA
 *
 * Output
 * FXXbj¦¦
 *
 */
public class StringAphaNumSort {

    public static void main(String[] args) {
        String s = "5ASD12ASDA";
        String res = getResultsByUsingJava8(s);
        System.out.println(res);
    }

    private static String getResultsByUsingJava8(String str){

        String res = str.chars().map(num -> (num%2==0) ? num+20 : 2*num)
                .sorted()
                .peek(c -> System.out.print(c +" "))
                .mapToObj(num -> (char)num)
                .map(String::valueOf)
                .collect(Collectors.joining());
       return res;
    }
}
