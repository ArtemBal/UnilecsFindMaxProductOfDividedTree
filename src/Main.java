public class Main {
    private static long max = 0;

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static long findTotal(Node root) {
        if(root == null)
            return 0;
        return findTotal(root.left) + findTotal(root.right) + root.value;
    }

    private static long findMax(Node root, long sum) {
        if(root == null)
            return 0;
        long localSum = findMax(root.left, sum) + findMax(root.right, sum) + root.value;
        max = Math.max(max, localSum * (sum - localSum));
        return localSum;
    }

    private static int findMaxProduct(Node root) {
        long totalSum = findTotal(root);
        findMax(root, totalSum);
        return (int)max;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        System.out.println("110 expected");
        System.out.println(findMaxProduct(root));
    }
}