package javas;

import java.util.Arrays;

public class CombinationsOfBalancedParentheses {

    public static void main(String[] args) {

        int n = 3;
        char[] arr = new char[2*n];
        printParenthesis(arr, 0, n, 0, 0);
    }

    static void printParenthesis(char str[], int pos, int n, int open, int close)
    {
        if (close == n) {
            // print the possible combinations
            for (int i = 0; i < str.length; i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        }
        else {
            if (open > close) {
                str[pos] = '}';
                printParenthesis(str, pos + 1, n, open, close + 1);
            }
            if (open < n) {
                str[pos] = '{';
                printParenthesis(str, pos + 1, n, open + 1, close);
            }
        }
    }

}
