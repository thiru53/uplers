package javas;

import java.util.stream.IntStream;

public class CheckPrimeNumber {

    public static void main(String[] args) {

        for(int i = 1; i< 100; i++) {
            //System.out.println(i+" - "+ isPrimeUsingLoop(i));
            System.out.println(i+" - "+ isPrimeUsingLoop(i));
        }
    }
    private static boolean isPrimeUsingStrem(int number) {
       long count = IntStream.rangeClosed(2, number).filter(i -> (number%i == 0)).count();
       return count == 1;
    }

    private static boolean isPrimeUsingLoop(int number) {
        int factor = 0;
        for(int i=2; i < number; i++) {
            if(number%i == 0){
                factor++;
            }
        }
        return factor == 0;
    }
}
