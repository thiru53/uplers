package javas;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Create a function that accepts a non-empty array of integers sorted in ascending order. The function should return a new array of the same length, containing the squares of the original integers, also sorted in ascending order
 *
 * NOTE : the output array should be of same length of input arrat
 *
 * Sample Input
 * array = [1, 2, 3, 5, 6, 8, 9]
 *
 * Sample Output
 * [1, 4, 9, 25, 36, 64, 81]
 */
public class SquareOfSortedArray {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 4, 9, 25, 36, 64, 81};
        int[] result1 = sortedSquaredArrayUsingLoops(arr);
        System.out.println("Approach-1-Res : "+Arrays.toString(result1));

        int[] result2 = sortedSquaredArrayUsingStreams(arr);
        System.out.println("Approach-2-Res : "+Arrays.toString(result2));
    }

    public static int[] sortedSquaredArrayUsingLoops(int[] array) {

        int[] resp = new int[array.length];
        for(int i=0 ; i < array.length; i++) {
            resp[i] = array[i]*array[i];
        }
        for(int i=0 ; i < resp.length; i++) {
            for(int j=i+1 ; j < resp.length; j++) {
                if(resp[i] > resp[j]) {
                    int tmp = resp[i];
                    resp[i] = resp[j];
                    resp[j] = tmp;
                }
            }
        }
        return resp;
    }

    public static int[] sortedSquaredArrayUsingStreams(int[] array) {
       return  IntStream.of(array).map(n -> n*n).sorted().toArray();
    }
}
