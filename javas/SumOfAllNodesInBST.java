package javas;

import java.util.Objects;

public class SumOfAllNodesInBST {
    public static void main(String[] args) {

        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
        root.right.left.right = newNode(8);

        printAllLeafNodes(root);
        printSumAllLeafNodes(root, 0);

        int a = printSumAllLeafNodes1(root);
        System.out.println("TotalSum :"+a);


    }

    private static int printSumAllLeafNodes1(Node node) {

        int sum = 0;
        if(Objects.nonNull(node)){
            sum += node.key + printSumAllLeafNodes1(node.left) + printSumAllLeafNodes1(node.right);
        }else {
            // lastNode
            return sum;
        }
        //System.out.println("Sum :"+sum);
        return sum;
    }
    private static int printSumAllLeafNodes(Node node, int sum) {

        if(Objects.nonNull(node)){
            System.out.println("key : "+node.key);
            sum += node.key;

            if(Objects.isNull(node.left) && Objects.isNull(node.right)) {
                System.out.println("Sum "+sum);
                return 0;
            }

            if(Objects.nonNull(node.left)){
                printSumAllLeafNodes(node.left, sum);
            }
            if(Objects.nonNull(node.right)){
                printSumAllLeafNodes(node.right, sum);
            }
        }
        return sum;
    }
    private static void printAllLeafNodes(Node node) {

        if(Objects.nonNull(node)){

            if(Objects.isNull(node.left) && Objects.isNull(node.right)) {
                System.out.println(node.key);
            }
            if(Objects.nonNull(node.left)){
                printAllLeafNodes(node.left);
            }
            if(Objects.nonNull(node.right)){
                printAllLeafNodes(node.right);
            }
        }
    }
    static Node newNode(int key) {
        Node node = new Node();
        node.key = key;
        node.left = node.right = null;
        return (node);
    }
}
