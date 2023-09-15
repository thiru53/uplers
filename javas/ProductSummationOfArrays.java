package javas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductSummationOfArrays {

    /**
     * Write a function that takes a 'special' array as input and returns its product sum.
     *
     * A 'special' array is a non-empty array that can contain integers or other 'special' arrays. The product sum of a 'special' array is calculated as follows: the elements of the array are summed, and any 'special' arrays inside are recursively summed themselves and then multiplied by their respective depth level.
     *
     * The depth of a 'special' array represents how deeply nested it is. For example, an empty array [] has a depth of 1, an inner array in [[]] has a depth of 2, and the innermost array in [[[]]] has a depth of 3.
     *
     * As a result, the product sum of a 'special' array [x, y] is equal to x + y, the product sum of [x, [y, z]] is equal to x + 2 * (y + z), and the product sum of [x, [y, [z]]] is equal to x + 2 * (y + 3 * z).
     *
     * Sample Input
     * array = [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
     *
     * Sample Output
     * 12 // calculated as: 5 + 2 + 2 * (7 - 1) + 3 + 2 * (6 + 3 * (-13 + 8) + 4)
     *
     */
    public static void main(String[] args) {

        List<Object> subList1 = List.of(7, -1);
        List<Object> subList3 = List.of(-13,8);
        List<Object> subList2 = List.of(6,subList3,4);
        List<Object> list = List.of(5, 2, subList1, 3, subList2);
        System.out.print("Res : "+ productSum(list, 1));

    }
    public static int productSum(List<Object> array, int level) {

        int sum = 0;
        for (int i=0; i< array.size(); i++) {

            Object o = array.get(i);
            if(o instanceof List){
                System.out.println(" "+o);
                sum+=productSum((List)array.get(i), level+1);
            } else {
                System.out.println(" "+o);
                Integer v = (Integer)array.get(i);
                sum+= (v)*level;
            }

        }
        return sum;
    }

    public static int productSum(List<Object> array) {

        int sum = 0;
        int level = 1;
        for (int i=0; i< array.size(); i++) {
            Object o = array.get(i);

            if(o instanceof List){
                sum+=productSum((List)array.get(i), level+1);
            } else {
                System.out.println(" "+o);
                Integer v = (Integer)array.get(i);
                sum+= (v)*level;
            }
        }

        return 0;
    }

}
