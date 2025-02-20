package Hasing;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.put("Alice", 85);
        hashTable.put("Bob", 90);
        hashTable.put("Charlie", 78);
        hashTable.put("David", 92);

        System.out.println("Điểm của Alice: " + hashTable.get("Alice"));
        hashTable.display();

        hashTable.remove("Bob");
        System.out.println("\nSau khi xóa Bob:");
        hashTable.display();
    }

    //Khai báo bảng băm
    static class HashTable<K, V> {
        private static final int SIZE = 10; // Kích thước bảng băm
        private LinkedList<Entry<K, V>>[] table;

        //Entry lưu key-value
        static class Entry<K, V> {
            private K key;
            private V value;
            public Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        @SuppressWarnings("unchecked")
        public HashTable() { //contructor dung
            table = new LinkedList[SIZE]; // Khởi tạo mảng danh sách liên kết
            for (int i = 0; i < SIZE; i++) {
                table[i] = new LinkedList<>();
            }
        }

        //Hàm băm
        private int hash(K key) {
            return Math.abs(key.hashCode()) % SIZE;
        }

        // Thêm hoặc cập nhật giá trị
        public void put(K key, V value) {
            int index = hash(key);
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    entry.value = value; // Cập nhật giá trị nếu key đã tồn tại
                    return;
                }
            }
            table[index].add(new Entry<>(key, value));
        }

        // Lấy giá trị từ key
        public V get(K key) {
            int index = hash(key);
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
            return null; // Không tìm thấy
        }

        // Xóa một phần tử theo key
        public void remove(K key) {
            int index = hash(key);
            table[index].removeIf(entry -> entry.key.equals(key));
        }

        public void display() {
            for (int i = 0; i < SIZE; i++) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : table[i]) {
                    System.out.print("[" + entry.key + " : " + entry.value + "] -> ");
                }
                System.out.println("null");
            }
        }
    }

}
