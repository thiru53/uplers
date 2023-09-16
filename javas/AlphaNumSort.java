package javas;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a string of size N containing different alpha-numeric characters, sort the given string in a
 * special way.
 * If the ASCII value of the character is even, then add 20 to its ASCII value, keeping the character the
 * same.
 * If it is odd, then double its ASCII value, and keep the character the same.
 * Sort the string according to the updated ASCII values of the characters and print them.
 * The given string will contain only numeric values or uppercase letters.
 * Function Description
 * In the provided code snippet, implement the provided Alpha_Num_Sort()... method using the
 * variables to print the string according to given conditions.
 * You can write your code in the space below the phrase “WRITE YOUR LOGIC HERE”.
 * There will be multiple test cases running so the Input and Output should match exactly as
 * provided.
 * The base Output variable result is set to a default value of -404 which can be modified. Additionally,
 * you can add or remove these output variable
 * Sample Input
 * 10 -- denotes size of string N.
 * 5ASD12ASDA -- denotes string.
 * Output Format
 * The output contains original elements of the string sorted in a special way.
 * Sample Output
 * 2DD15AAASS
 * Explanation
 * N=10
 * Character of string 5 A S D 1 2 A S D A
 * ASCII Value of string 53 65 83 68 49 50 65 83 68 65
 * Updated ASCII value as said above 106 130 166 88 98 70 130 166 88 130
 *
 * Sort the ASCII values present in the updated row and print the respective character corresponding
 * to the sorted ASCII values.
 * Sorted ASCII values 70 88 88 98 106 130 130 130 166 166
 * Characters corresponding the given ASCII values 2 D D 1 5 A A A S S
 * So, the output will be 2DD15AAAS
 */
public class AlphaNumSort {
    public static void main(String[] args) {

        System.out.println("RES : "+Alpha_Num_Sort("5ASD12ASDA"));
        System.out.println("RES : "+Alpha_Num_Sort("D1W4DF2URM"));
        System.out.println("RES : "+Alpha_Num_Sort("MVTP6QQP7R1WQWAA"));
        System.out.println("RES : "+Alpha_Num_Sort("0Y"));
        System.out.println("RES : "+Alpha_Num_Sort("OS4SVHDFYEYN2ORB"));
        System.out.println("RES : "+Alpha_Num_Sort("2NE2RQT5B0H18ZD5B3LSXIN74C8OUCOD4W"));

    }

    public static String Alpha_Num_Sort(String str){

        System.out.println("---------------------------------------------------------------------------------------------");

        Map<String,Long> uniqueCount = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("UniqueCount : "+uniqueCount);
        Map<Integer, String> map = Arrays.stream(str.split("")).collect(Collectors.toMap(AlphaNumSort::getASCIValue, s->s,  (oV, nV) -> nV));
        System.out.println("Map : "+map);
        Map<Integer, String> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("SortedMap : "+sortedMap);

        String res = sortedMap.entrySet().stream().map(me -> {
            String val = me.getValue();
            String str1 ="";
            if(uniqueCount.containsKey(val)) {
                for(int i=0; i < uniqueCount.get(val); i++) {
                    str1+= val;
                }
            }
            return str1;
        }).collect(Collectors.joining());

        return res;
    }


    private static Integer getASCIValue(Object o) {
        if(Objects.nonNull(o)) {
            int ascii = ((String)o).charAt(0);
            return (ascii %2 == 0) ? ascii+20 : ascii * 2;
        }
        return null;
    }
}
