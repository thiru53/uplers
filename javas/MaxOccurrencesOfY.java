package javas;

import java.util.HashMap;
import java.util.Map;

public class MaxOccurrencesOfY {
    public static void main(String[] args) {
        //int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Replace with your array
        //int[] array = { 3, 0, 2, 1, 10, -1};
        //int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        //int[] array = {5, 5, 4, 3, 3};
        int[] array = {10, 9, 9, 9, 9, 5, 4, 8, 8, 8};

        int maxOccurrencesIndex = findMaxOccurrencesOfY(array);

        System.out.println("Index y with Maximum Occurrences: " + maxOccurrencesIndex);
    }

    public static int findMaxOccurrencesOfY(int[] arr) {
        int n = arr.length;
        int maxOccurrences = 0;
        int maxOccurrencesIndex = -1;

        for (int y = 1; y < n - 1; y++) {
            int occurrences = 0;

            for (int x = y + 1; x < n; x++) {
                for (int z = y - 1; z >= 0; z--) {
                    if (arr[x] < arr[y] && arr[y] < arr[z]) {
                        if(x > y && y > z ) {
                            occurrences++;
                        }
                    }
                }
            }

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                maxOccurrencesIndex = y;
            }
        }

        return maxOccurrencesIndex;
    }
}

