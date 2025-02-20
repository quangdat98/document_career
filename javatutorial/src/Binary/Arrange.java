package Binary;

import java.util.Stack;

public class Arrange {
    public static void main(String[] args) {
        BinaryArrange bst = new BinaryArrange();
        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int val : values) {
            bst.insert(val);
        }

        System.out.print("Duyệt trung thứ tự (Đệ quy): ");
        bst.inorderRecursive(bst.root);
        System.out.println();

        System.out.print("Duyệt trung thứ tự (Vòng lặp): ");
        bst.inorderIterative(bst.root);
        System.out.println();
    }
    static class Node {
        int value;
        Node right, left;

        public Node(int value) {
            this.value = value;
            this.right = this.left = null; // khởi tạo ban đầu chưa có 1 cái gì cả
        }
    }

    static class BinaryArrange {
        Node root;

        public void insert(int key) {
            root = insertRec(root, key);
        }
        //áp dụng đệ quy để insert
        private Node insertRec(Node root, int key) {
            if (root == null) return new Node(key);
            if (key < root.value) root.left = insertRec(root.left, key);
            else if (key > root.value) root.right = insertRec(root.right, key);
            return root;
        }

        // Hàm duyệt trung thứ tự (LNR) - Đệ quy
        public void inorderRecursive(Node root) {
            if (root != null) {
                inorderRecursive(root.left);   // L - Trái
                System.out.print(root.value + " "); // N - Gốc
                inorderRecursive(root.right);  // R - Phải
            }
        }

        public void inorderIterative(Node root) {
            Stack<Node> stack = new Stack<>();
            Node current = root;

            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left; // Đi về trái
                }
                current = stack.pop();
                System.out.print(current.value + " "); // In giá trị
                current = current.right; // Chuyển sang cây con phải
            }
        }

    }
}
