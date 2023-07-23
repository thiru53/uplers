package javas;

public class NthFibonacci {
    public static void main(String[] args) {

        int index = 15;
        int res = getNthFibonacciUsingLoops(index);
        System.out.println("Test for "+index+", Res : "+res);

        int res1 = getNthFibonacciUsingRecursive(index);
        System.out.println("Test for "+index+", Res-1 : "+res1);
    }

    public static int getNthFibonacciUsingLoops(int n) {

        if(n < 2){
            return n-1;
        }

        int a = 0;
        int b = 1;
        int c = 0;

        for(int i=2; i<=n; i++){
            c = a+b;
            a=b;
            b=c;
            //System.out.println(i+"-"+c);
        }
        return c;
    }

    public static int getNthFibonacciUsingRecursive(int n) {
        if(n <= 1){
            return n;
        }
        return  getNthFibonacciUsingRecursive(n-1)+getNthFibonacciUsingRecursive(n-2);
    }
}
