package javas;

public class FindPossibleSubArraysV1 {


    public static void main(String[] args) {
        //System.out.println("Welcome");

        int[] inputArr = {1, 2, 3, 4};
        for(int i=0; i< inputArr.length; i++){
            for(int j=i; j<inputArr.length; j++){
                int[] subArray = getSubArray(inputArr, i, j);
                for(int v : subArray) {
                    System.out.print(v+" ");
                }
                System.out.println();
            }
        }
    }

    private static int[] getSubArray(int[] inputArr, int start, int end) {
        int[] arr = new int[end -start];
        int index = 0;
        for(int i=start; i < end; i++){
            arr[index++] = inputArr[i];
        }
        return arr;
    }
}
