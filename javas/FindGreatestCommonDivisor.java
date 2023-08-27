package javas;

public class FindGreatestCommonDivisor {

    public static void main(String[] args) {

        test(12);

    }

    public static void test(int N){
        for(int i=1; i < N; i++){
            for(int j= 1; j< N; j++){
                int gcd = findGCD(i, j);
                if((gcd * gcd) == N -(i*j)){
                    System.out.println(i+" :: "+j);
                }
            }
        }
    }
    public static int findGCD(int a , int b) {
        if(b == 0) {
            return a;
        } else {
            return findGCD(b, a%b);
        }
    }
}
