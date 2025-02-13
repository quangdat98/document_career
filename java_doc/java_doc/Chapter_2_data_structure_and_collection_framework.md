# ** ------ Tóm Tắt ------ **

## I. Cấu trúc dữ liệu.
1. Array (Mảng).
2. Linked List.
3. Stack (Ngăn xếp). 
4. Queue (Hàng đợi). 
5. Priority Queue
6. Hash Table (Bảng băm). 
7. Heap. 
8. Tree (Cây). 
9. Graph (Đồ thị).
10. Binary Tree (cây nhị phân). 
## II. Java Collections Framework (JCF)
1. Iterable interface
2. Cursors
3. Collections Utility
4. Collection interface
5. List interface
6. Set interface
7. SortedSet interface
8. Map interface
9. SortedMap interface
10. Queue interface
11. Class ArrayList
12. Class LinkedList
13. Class HashSet
14. Lớp LinkedHashSet
15. Lớp TreeSet
16. Lớp EnumSet
17. Lớp HashMap
18. Lớp TreeMap
19. Lớp EnumMap
20. Lớp HashTable
21. Lớp Vector
22. Comparable
23. Comparator
24. Lớp properties
25. NavigableMap
26. NavigableSet
27. WeakHashMap

# **  ------ Nội dung chi tiết ------ **

## ***Tài liệu tham khảo***
- https://tek4.vn/top/10-cau-truc-du-lieu-ma-moi-lap-trinh-vien-java-nhat-dinh-phai-biet
- https://www.geeksforgeeks.org/data-structures/
## I. Cấu trúc dữ liệu.
- Cấu trúc dữ liệu là bộ nhớ được sử dụng để lưu trữ và sắp xếp dữ liệu. Đây là cách sắp xếp dữ liệu trên máy tính để có thể truy cập và cập nhật hiệu quả.
- ![image](https://github.com/user-attachments/assets/ac9b5cc8-3488-41fe-88b7-a2eda1b419ca)
- **Linear Data Structure**:(Cấu trúc dữ liệu tuyến tính) là loại cấu trúc dữ liệu trong đó các phần tử được sắp xếp theo một trình tự cụ thể, nghĩa là mỗi phần tử chỉ có một phần tử trước và một phần tử sau nó (ngoại trừ phần tử đầu và cuối). Example: Array  stack, queue, linked list.
- **Static data structure**: Static data structure has a fixed memory size. Việc truy cập các phần tử trong cấu trúc dữ liệu tĩnh dễ dàng hơn.
- **Dynamic data structure**: the size is not fixed. Có thể mở rộng thu nhỏ bộ nhớ theo nhu cầu. Quản lý bộ nhớ hiệu quả -> chỉ cấp phát bộ nhớ khi cần thiết.
- ![image](https://github.com/user-attachments/assets/79bbf8d7-1aba-48a4-b156-cce8a2b87c60)
- **Non-Linear Data Structure**:(Cấu trúc dữ liệu phi tuyến tính) là loại cấu trúc dữ liệu trong đó các phần tử không được sắp xếp theo một trình tự tuyến tính. Một phần tử có thể liên kết với nhiều phần tử khác, tạo thành các cấu trúc như cây (Tree) hoặc đồ thị (Graph).
### 1. Array
- 
### 2. Linked List
- https://howkteam.vn/course/cau-truc-du-lieu-va-giai-thuat/linked-list-4273
- https://uet.vnu.edu.vn/~tqlong/2018ltnc/Support-Lec9&10-LinkedLists.pdf
- Linked List là một cấu trúc dữ liệu dạng danh sách liên kết gồm các Node, mỗi Node chứa: Dữ liệu (Data) và Con trỏ (Pointer) trỏ đến Node tiếp theo (hoặc cả Node trước đó trong danh sách đôi)
**2.1 Cấu trúc của Linked List**
- Singly Linked List (Danh sách liên kết đơn)
- Doubly Linked List (Danh sách liên kết đôi)
- Circular Linked List (Danh sách liên kết vòng)
**Doubly Linked List (Danh sách liên kết đôi)**
- Đây là cấu trúc mà java đang dùng
- ![image](https://github.com/user-attachments/assets/c341c982-b4c1-438d-b77a-64ac9bebd0be)
- ![image](https://github.com/user-attachments/assets/8b17b77e-9129-45d6-84d4-d54d95888208)
- Node mở đầu gọi là head - nhận biết vị trí bắt đầu của dãy. Mỗi node có 2 con trỏ, **Prev: Trỏ đến node trước đó. Next: Trỏ đến node kế tiếp.Data: Dữ liệu của node.**
- Với head ( phần tử đầu tiên) prev trỏ đến null.
**2.2 Triển khai Doubly Linked List với code**
- Tạo class node -> chứa thông tin node ![image](https://github.com/user-attachments/assets/623eb824-18da-473e-818c-8370ca966b26)
- Tạo lớp DoublyLinkedList. Chứa head -> phần từ đầu. tail phần tử cuối.
- Hàm append để thêm phần tử vào cuối list, hàm prepend thêm phần tử vào đầu list.
- ![image](https://github.com/user-attachments/assets/cf861982-89e7-452a-a3be-3b0bec6a9904)
- ![image](https://github.com/user-attachments/assets/092f05b1-5c50-4be3-a7ae-7ca54a46e59d)
- Như ta thấy là linked có nhiều tài nguyên để lư trữ => **nếu dùng để lưu phần tử thì ko dùng linked list, chỉ dùng linked list để thao tác với dữ liệu**
- Còn khi muốn chèn phần tử bất kỳ: ![image](https://github.com/user-attachments/assets/f4b8bf34-eade-44a2-84d0-76cb33a0c156)
- Với array thường thì khi chèn phần tử đồng nghĩa phải thay đổi index của các phần tử sau đó => hiệu suất ko bằng linked list.
- java.util.LinkedList cũng dùng cơ chế gần tương tự trên.
### 3. Stack (Ngăn xếp)
### 4. Queue (Hàng đợi)
### 5. Priority Queue
### 6. Hash Table (Bảng băm)
### 7. Heap
### 8. Tree (Cây)
### 9. Graph (Đồ thị)
### 10. Binary Tree (cây nhị phân)
