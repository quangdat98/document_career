package Binary;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // Chèn các giá trị vào BST
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            bst.insert(val);
        }

        // 🔍 Kiểm tra tìm kiếm
        int key = 40;
        System.out.println("Tìm " + key + " (đệ quy): " + bst.search(key)); //Tìm 40 (đệ quy): true

    }

    static class Node {
        int value;
        Node right, left;

        public Node(int value) {
            this.value = value;
            this.right = this.left = null; // khởi tạo ban đầu chưa có 1 cái gì cả
        }
    }

    static class BinarySearchTree{
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

        public boolean search(int key) {
            return searchRec(root, key);
        }
        private boolean searchRec(Node root, int key) {
            if (root == null) return false;
            if (root.value == key) return true;
            return (key < root.value) ? searchRec(root.left, key) : searchRec(root.right, key);
        }
    }
}
