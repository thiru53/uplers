package javas;

public class NthFibonacci {
    public static void main(String[] args) {

        int index = 15;
        int res = getNthFibonacciUsingLoops(index);
        System.out.println("Test for "+index+", Res : "+res);
    }

    public static int getNthFibonacciUsingLoops(int n) {

        if(n < 3){
            return n-1;
        }

        int a = 0;
        int b = 1;
        int c = 0;

        for(int i=3; i<=n; i++){
            c = a+b;
            a=b;
            b=c;
            //System.out.println(i+"-"+c);
        }
        return c;
    }
}
