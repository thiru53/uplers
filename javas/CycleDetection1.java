package javas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CycleDetection1 {

    public static void main(String[] args) {

        int[] A1 = {1, 3, 2, 4};
        int[] A2 = {4, 1, 3, 2};

        System.out.println("A : isCycle : " + solution1(A1, A2));

        int[] B1 = {1, 2, 3, 4};
        int[] B2 = {2, 1, 4, 3};
        System.out.println("B : isCycle : "+solution1(B1, B2));

        int[] C1 = {3, 1, 2};
        int[] C2 = {2, 3, 1};
        System.out.println("C : isCycle : "+solution1(C1, C2));

        int[] D1 = {1, 2, 3, 4};
        int[] D2 = {2, 1, 4, 3};
        System.out.println("D : isCycle : "+solution1(D1, D2));

        int[] E1 = {1, 2, 2, 3, 3};
        int[] E2 = {2, 3, 3, 4, 5};
        System.out.println("E : isCycle : "+solution1(E1, E2));

        int[] F1 = {1,2,1};
        int[] F2 = {2, 3, 3};
        System.out.println("E : isCycle : "+solution1(F1, F2));

        int[] G1 = {1, 2, 3, 4};
        int[] G2 = {2, 1, 4, 4};
        System.out.println("D : isCycle : "+solution1(G1, G2));


    }

    public static boolean solution(int[] A, int[] B) {

        int length = A.length;

        Map<Integer, Integer> paths = new HashMap<>();
        for (int i = 0; i < length; ++i){
            if (paths.put(A[i], B[i]) != null){
                return false;
            }
        }

        Set<Integer> visited = new HashSet<>();
        int node = A[0];
        while(visited.add(node)) {
            node = paths.get(node);
        }

        return visited.size() == length;

    }

    public static boolean solution1(int[] A, int[] B) {

        if(A[A.length-1] != B[0]) {
            return false;
        }
        for(int i=0; i < A.length-1; i++) {
            if(A[i] != B[i+1]) {
                return false;
            }
        }
        return true;
    }

}
