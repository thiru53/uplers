package javas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CycleDetection1 {

    public static void main(String[] args) {

        int[] A1 = {1, 3, 2, 4};
        int[] A2 = {4, 1, 3, 2};

        System.out.println("A : isCycle : " + solution(A1, A2));

        int[] B1 = {1, 2, 3, 4};
        int[] B2 = {2, 1, 4, 3};
        System.out.println("B : isCycle : "+solution(B1, B2));

        int[] C1 = {3, 1, 2};
        int[] C2 = {2, 3, 1};
        System.out.println("C : isCycle : "+solution(C1, C2));

        int[] D1 = {1, 2, 3, 4};
        int[] D2 = {2, 1, 4, 3};
        System.out.println("D : isCycle : "+solution(D1, D2));

        int[] E1 = {1, 2, 2, 3, 3};
        int[] E2 = {2, 3, 3, 4, 5};
        System.out.println("E : isCycle : "+solution(E1, E2));

        int[] F1 = {1,2,1};
        int[] F2 = {2, 3, 3};
        System.out.println("E : isCycle : "+solution(F1, F2));

        int[] G1 = {1, 2, 3, 4};
        int[] G2 = {2, 1, 4, 4};
        System.out.println("D : isCycle : "+solution(G1, G2));


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

}
