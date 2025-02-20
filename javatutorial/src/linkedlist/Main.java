package linkedlist;

import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.printForward();  // 10 ⇄ 20 ⇄ 30 ⇄ null

        list.prepend(5);
        list.printForward();  // 5 ⇄ 10 ⇄ 20 ⇄ 30 ⇄ null

        list.delete(20);
        list.printForward();  // 5 ⇄ 10 ⇄ 30 ⇄ null

        list.printBackward(); // 30 ⇄ 10 ⇄ 5 ⇄ null
    }

    static class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        Node head; // phan tu dau
        private Node tail; // phan tu cuoi

        public void append(int data) {
            Node newNode = new Node(data);
            if (head == null) { // trường hợp head == null tức mảng chưa có phần tử thì cả head và tail = node mới (phần tử đầu tiên và duy nhất ).
                head = tail = newNode;  //Từ lần 2 head sẽ khác null và ko vào if nữa
                return;
            }
            // thêm tiếp 1 phần tử vào list
            tail.next = newNode; // Node cuối cùng trỏ tới node mới
            newNode.prev = tail; // Node mới trỏ ngược lại node cuối
            tail = newNode; // Cập nhật tail là node mới
        }

        public void prepend(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head; // Node mới trỏ tới node cũ đầu tiên
            head.prev = newNode; // Node đầu tiên trỏ ngược lại node mới
            head = newNode; // Cập nhật head là node mới
        }
        public void delete(int data) {
            if (head == null) {
                return;
            }
            Node current = head;
            // Nếu xóa node đầu tiên
            if (head.data == data) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null;
                }
                return;
            }

            // Duyệt tìm node cần xóa
            while (current != null && current.data != data) {
                current = current.next;
            }

            // Nếu không tìm thấy node cần xóa
            if (current == null) return;

            // Nếu xóa node cuối
            if (current == tail) {
                tail = tail.prev;
                tail.next = null;
                return;
            }

            // Nếu xóa node ở giữa
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        // In danh sách từ đầu đến cuối
        public void printForward() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ⇄ ");
                current = current.next;
            }
            System.out.println("null");
        }

        // In danh sách từ cuối về đầu
        public void printBackward() {
            Node current = tail;
            while (current != null) {
                System.out.print(current.data + " ⇄ ");
                current = current.prev;
            }
            System.out.println("null");
        }
    }
}

