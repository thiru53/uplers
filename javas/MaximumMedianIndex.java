package javas;

import java.util.Arrays;

public class MaximumMedianIndex {

    public static void main(String[] args) {


        int[] arr = {3, 0, 2, 1, 10, -1};
        int[][] subArr = getSubArray(arr);
        int[] posRes = new int[arr.length];
        int[] negRes = new int[arr.length];

        int index = 0;
        for(int i=0; i < subArr.length-1; i++){
            int[] arr1 = subArr[i];
            for (int j= 0; j < arr1.length; j++){
                System.out.println(j);
                int k = arr1[j];
                if(k < 0) {
                    k = -1*k;
                    negRes[k] = negRes[k]+1;
                } else if(posRes[k] == i) {
                   posRes[k]=posRes[k]+1;
                }
            }
        }
        System.out.print(Arrays.toString(posRes));
        System.out.print(Arrays.toString(negRes));
    }
    public static int[][] getSubArray(int[] arr){

        int[][] subArr = new int[arr.length][];
        int gIndex = 0;
        for (int i=0; i< arr.length; i++){
            for (int j=i+1; j< arr.length; j++){
                for (int k=j+1; k< arr.length; k++){
                    if(arr[i] > arr[j]  && arr[j] > arr[k]) {
                        int[] arr1 = { arr[i], arr[j], arr[k] };
                        subArr[gIndex] = arr1;
                        gIndex++;
                        System.out.println(Arrays.toString(arr1));
                    }
                }
            }
        }
        return subArr;
    }
}
