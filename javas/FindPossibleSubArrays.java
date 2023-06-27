package javas;

import java.util.Arrays;

public class FindPossibleSubArrays {


    public static void main(String[] args) {
        //System.out.println("Welcome");

        int[] inputArr = {1, 2, 3, 4};
        for(int i=0; i< inputArr.length; i++){
            for(int j=i; j<inputArr.length; j++){
                int[] subArray = getSubArrayUsingLoop(inputArr, i, j);
                System.out.println("After : "+Arrays.toString(subArray));
            }
        }
        getSubArrayUsingArrayCopy();
        getSubArrayUsingCopyOfRange();
    }

    private static int[] getSubArrayUsingLoop(int[] inputArr, int start, int end) {
        int[] arr = new int[end -start];
        int index = 0;
        for(int i=start; i < end; i++){
            arr[index++] = inputArr[i];
        }
        return arr;
    }

    private static void getSubArrayUsingArrayCopy() {
        int[] sourceArr = {1, 2, 3, 4};
        int[] destArr = {1, 2, 3, 4};

        System.out.println("Before ; "+Arrays.toString(destArr));
        System.arraycopy(sourceArr, 0, destArr, 1, 2);
        System.out.println("After ; "+Arrays.toString(destArr));

    }

    private static void getSubArrayUsingCopyOfRange() {
        int[] sourceArr = {1, 2, 3, 4};

        int[] resArr = Arrays.copyOfRange(sourceArr, 0, 2);
        System.out.println("After ; "+Arrays.toString(resArr));

    }
}
