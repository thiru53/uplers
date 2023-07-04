package javas;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6,7};
        // is rotated to [5,6,7,1,2,3,4].
        int noOfElements = 29;
        rotateArrayRightUsingLoops1(array, noOfElements);
        rotateArrayRightUsingLoops2(array, noOfElements);
        rotateArrayLeft(array, noOfElements);
    }

    private static void rotateArrayRightUsingLoops1(int[] actual, int noOfElements) {

        if( noOfElements > actual.length) {
            noOfElements = noOfElements % actual.length;
        }

        int[] newArray = new int[actual.length];

        for(int i= 0; i < noOfElements; i++){
            newArray[i] = actual[actual.length-noOfElements+i];
        }
        int j=0;
        for(int i= noOfElements; i < actual.length; i++){
            newArray[i] = actual[j++];
        }
        System.out.println("Response-1 : "+ Arrays.toString(newArray));
    }

    private static void rotateArrayRightUsingLoops2(int[] actual, int noOfElements) {

        noOfElements = ( noOfElements > actual.length) ? noOfElements % actual.length : noOfElements;

        int[] newArray = new int[actual.length];

        int i=0;
        for(int j= actual.length-noOfElements; j < actual.length; j++){
            newArray[i++]=actual[j];
        }
        for(int j= 0; j < noOfElements-1; j++){
            newArray[i++]=actual[j];
        }
        System.out.println("Response-2 : "+ Arrays.toString(newArray));
    }


    private static void rotateArrayLeft(int[] actual , int noOfElements) {

        noOfElements = ( noOfElements > actual.length) ? noOfElements % actual.length : noOfElements;

        int[] newArray = new int[actual.length];

        int i = 0;
        for (int j = noOfElements; j < actual.length; j++){
            newArray[i++]=actual[j];
        }
        for (int j = 0; j < noOfElements; j++){
            newArray[i++]=actual[j];
        }
        System.out.println("Response-3 : "+ Arrays.toString(newArray));

    }
}
