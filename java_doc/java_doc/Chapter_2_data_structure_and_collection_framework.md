![image](https://github.com/user-attachments/assets/ec568f0d-67c4-45b8-9b2f-02ce70700d42)# ** ------ Tóm Tắt ------ **

## I. Cấu trúc dữ liệu.
1. Array (Mảng).
2. Linked List.
3. Stack (Ngăn xếp). 
4. Queue (Hàng đợi). 
5. Priority Queue
6. Hash Table (Bảng băm).
7. Tree (Cây).
8. Cây nhị phân
9. Heap. 
10. Graph (Đồ thị).
11. Trie (Prefix Tree) – Cây tiền tố, dùng trong tìm kiếm chuỗi nhanh.
12. Disjoint Set (Union-Find) – Dùng để quản lý các tập hợp rời rạc, ứng dụng trong Kruskal’s Algorithm.
13. Segment Tree (Cây đoạn) – Dùng để xử lý truy vấn khoảng liên tục trong mảng.
14. Fenwick Tree (Binary Indexed Tree - BIT) – Dùng để cập nhật và truy vấn tổng khoảng nhanh hơn mảng thông thường.
15. Skip List – Danh sách liên kết mở rộng để hỗ trợ tìm kiếm nhanh hơn O(log n).
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
- https://howkteam.vn/course/cau-truc-du-lieu-va-giai-thuat-75
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
- Linked List là một cấu trúc dữ liệu dạng danh sách liên kết gồm các Node, mỗi Node chứa: Dữ liệu (Data) và Con trỏ (Pointer) trỏ đến Node tiếp theo (hoặc cả Node trước đó trong danh sách đôi).
  
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
- ![image](https://github.com/user-attachments/assets/a1041954-a650-424b-a0c6-03ed95d2bb5c)
- ![image](https://github.com/user-attachments/assets/092f05b1-5c50-4be3-a7ae-7ca54a46e59d)
- Như ta thấy là linked có nhiều tài nguyên để lư trữ => **nếu dùng để lưu phần tử thì ko dùng linked list, chỉ dùng linked list để thao tác với dữ liệu**
- Còn khi muốn chèn phần tử bất kỳ: ![image](https://github.com/user-attachments/assets/f4b8bf34-eade-44a2-84d0-76cb33a0c156)
- Với array thường thì khi chèn phần tử đồng nghĩa phải thay đổi index của các phần tử sau đó => hiệu suất ko bằng linked list.
- java.util.LinkedList cũng dùng cơ chế gần tương tự trên.
### 3. Stack (Ngăn xếp)
- https://www.geeksforgeeks.org/introduction-to-stack-data-structure-and-algorithm-tutorials/

**3.1 Cấu trúc của stack**
- Stack (ngăn xếp) là một cấu trúc dữ liệu hoạt động theo nguyên tắc LIFO (Last In, First Out) – phần tử được thêm vào sau cùng sẽ được lấy ra đầu tiên.
- ![image](https://github.com/user-attachments/assets/a7e20c04-c57d-4012-ba9e-0852bb41155e)
- ![image](https://github.com/user-attachments/assets/e575e048-cddb-4e1c-8f6c-8716bb0c0f7c) ![image](https://github.com/user-attachments/assets/1bc11dbf-da2b-4a7f-a091-4243bb5d0f0e)
- Các thao tác cơ bản của stack:![image](https://github.com/user-attachments/assets/6f3162b4-ebad-4e82-a349-e3bd6726787a)
- Ta có thể sử dụng stack trong hệ thống call back.. 
- Trong java chúng ta có thể sử dụng java.util.Stack. Lớp java.util.Stack trong Java thực chất là một lớp con của Vector<E>, tức là nó dựa trên mảng động (Array) để quản lý dữ liệu.

### 4. Queue (Hàng đợi), Deque (Hàng đợi 2 đầu)
- https://www.geeksforgeeks.org/queue-data-structure/

**4.1 Cấu trúc queue**
- Trái ngược với stack thì queue lại là cấu trúc dữ liệu dạng FIFO- vào trước ra trước.
- ![image](https://github.com/user-attachments/assets/a8f710c3-ef50-42b0-9209-8cf2211b4c8e)
- quene có 2 đầu: **front: phần tử đầu tiên - sẽ bị lấy ra trước** và **Rear: phần tử cuối cùng- phần tử mới thêm**
- Các Thao tác chính của quene: ![image](https://github.com/user-attachments/assets/86b03ec5-487c-4d26-ab00-fe7e765d9f71)
- Nếu bạn bảo nếu duyệt lấy vào xóa phần tử đk thêm đâu tiên thì dùng list cũng dk. Nhưng list ko tối ưu, khi xóa trong list cần dịch chuyển toàn bộ phần tử còn lại.

**4.2 Cấu trúc deque**
- Deque (Double-ended queue - Hàng đợi hai đầu) là một hàng đợi mở rộng, cho phép thêm/xóa phần tử từ cả hai đầu (đầu và cuối).
- Các thao tác chính: ![image](https://github.com/user-attachments/assets/aa527d6d-e9f1-48d4-8ce1-a0dfbe971bec)
- ![image](https://github.com/user-attachments/assets/3c04df3c-7e3c-446e-a5a9-b7bd636fe3d5)
  
### 5. Priority Queue
- Là hàng đợi ưu tiên
### 6. Hash Table (Bảng băm)
- https://www.geeksforgeeks.org/hashing-data-structure/
- Hashing là một kỹ thuật chuyển đổi dữ liệu đầu vào (key) thành một giá trị băm (hash value) thông qua một hàm băm (hash function).
- Hashing giúp tìm kiếm và lưu trữ dữ liệu nhanh hơn trong các cấu trúc như Hash Table, HashMap, HashSet,... 🚀.
- Ví dụ Nhập vào "apple", hàm băm trả về 12345.
  
**6.1 Cấu trúc hasing**
- Component of hashing:
  + **Key**: Dữ liệu đầu vào cần lưu trữ hoặc tìm kiếm. Khi 2 key có trùng giá trị băm thì đó là **va chạm collision**. Java dùng Chaining (Danh sách liên kết) hoặc Open Addressing (Linear Probing).
  + **Hàm băm**: chuyển đổi key thành một số giá trị cố định (hash code / hash value). Giá trị này xác định vị trí index trong bảng băm nơi dữ liệu sẽ được lưu trữ. Có nhiều cách để tính mã băm.
     + Hàm băm đơn giản: Sử dụng các phép toán cơ bản như cộng, nhân, hoặc phép mod với một số nguyên.
     + Hàm băm tốt: Sử dụng các thuật toán phức tạp hơn để giảm thiểu xung đột (collision - trùng giá trị băm) và phân bố đều các giá trị băm.
  + **Bảng băm**: Một mảng hoặc danh sách liên kết, nơi lưu trữ giá trị dựa trên hash value.
     + ![image](https://github.com/user-attachments/assets/4eeb5d8a-6075-4f53-aa77-b6ab012fb10d)
  
**6.2 Va chạm collision**
- Collision (xung đột) xảy ra khi nhiều key có cùng hash value và trỏ đến cùng một vị trí trong bảng băm. Có nhiều cách để xử lý.
- Chaining (Danh sách liên kết): Mỗi ô trong bảng chứa một danh sách liên kết để lưu nhiều giá trị cùng hash. Khi collision xảy ra, dữ liệu mới được thêm vào danh sách tại ô đó.:  ![image](https://github.com/user-attachments/assets/f2170e01-7a76-46a4-ad9b-116ea999c04e)
- Tree-based Collision Handling (Từ Java 8+):  Nếu số lượng phần tử trong một bucket > 8 (Bucket là một vị trí trong bảng băm (Hash Table), Java sẽ chuyển từ danh sách liên kết sang cây đỏ đen (Red-Black Tree).
  + Khi chèn 8 phần tử, bucket sẽ như sau: ![image](https://github.com/user-attachments/assets/563e53d0-8d37-422e-b174-e53b4c3f34df)
  + ![image](https://github.com/user-attachments/assets/40d49b51-5333-46d5-a3d5-a50d898b42b8)
  + HashMap dùng hashCode() của key để làm key trong TreeMap. ![image](https://github.com/user-attachments/assets/d64a2565-dc12-4f9d-8504-d551aba900be)
- Open Addressing (Tìm vị trí khác trong bảng)

**6.3 Triểu khai 1 cấu trúc hasing trong java**
- Tạo 1 class đại diện cho bảng băm (mọi xử lý chỉ trong  class này). Có 2 biến là Size(kích thước bảng băm) và 1 mảng LinkedList chứa dữ liệu Key và value ![image](https://github.com/user-attachments/assets/79c753c2-2579-4bac-8b98-9f7412cb2e51)
- Khởi tạo kích thươc của bảng băm, cụ thể là số lượng bucket: ![image](https://github.com/user-attachments/assets/324b5b26-ccb0-4c88-91cd-e15a784e3709). Đến bước này ta đã tạo 1 bảng băm (chưa có dữ liệu) : ![image](https://github.com/user-attachments/assets/6d7e3858-3aa5-4776-bf73-008753325a20)
- Tạo 1 class entry để lưu dữ liệu key-value. Và mỗi 1 bucket là 1 list các entry này. ![image](https://github.com/user-attachments/assets/320f823b-5518-4abc-826f-9f2a1cd4f80a)
- Hàm tạo mã hash ![image](https://github.com/user-attachments/assets/275de70a-7412-44e5-9cba-ff0883a7bef0). Mã hash này luôn nằm trong phạp vi size (0-9) do phần dư (%10) luôn nằm trong khoảng đó.
- Hàm Thêm hoặc cập nhật giá trị: ![image](https://github.com/user-attachments/assets/4c52576a-052a-4725-ae9c-cf9335780f5e).
  + index chính bằng giá trị lấy từ hash đã tính. Trường hợp value ko trùng thì thêm mới giá trị. Với các vị trí index mà ko có mã băm nào trùng thì sẽ là null.
  + ![image](https://github.com/user-attachments/assets/ace5d227-e73c-4587-be36-45aa956a2762)
- Hàm lấy giá trị theo key: ![image](https://github.com/user-attachments/assets/b03c7587-075b-4fb4-aecc-dd548237441e) . Dựa bào key thay vào hàm băm lấy ra giá trị index. Từ mã băm ta lấy được list linked list. => for và equals tìm đúng giá trị
- Hàm xóa: ![image](https://github.com/user-attachments/assets/77a24e79-5806-4a54-bc53-df317f42d710)
- Hiển thị: ![image](https://github.com/user-attachments/assets/602fdf08-b1e6-41e1-8fa3-21239b254b2b)
- Hàm main: ![image](https://github.com/user-attachments/assets/446b42be-d6d5-40e3-850e-fb17943ceac4)










### 7. Tree (Cây)
- Cây cơ bản
- Cây nhị phân
- Cây nhị phân tìm kiếm
- Đống (Heap)
- Cây AVL
- Cây đỏ đen

### 8. Binary Tree (cây nhị phân)
- https://viblo.asia/p/chuong-6-trees-1-tree-la-gi-ly-thuyet-ve-binary-tree-obA46PM9LKv
**8.1 Cấu trúc cây nhị phân**
- Cây nhị phân (Binary Tree) là một cấu trúc dữ liệu dạng cây, trong đó mỗi node có tối đa hai node con: Node trái (Left Child) và Node phải (Right Child).
- Một số loại cây nhị phân:
  + Cây Nhị Phân Đầy Đủ (Full Binary Tree) ![image](https://github.com/user-attachments/assets/54a37bd3-488c-475c-a6c0-3848a55df63c)
  + Cây Nhị Phân Hoàn Chỉnh (Complete Binary Tree)
  + Cây Nhị Phân Cân Bằng (Balanced Binary Tree)
  + Cây Nhị Phân Tìm Kiếm (Binary Search Tree - BST) ![image](https://github.com/user-attachments/assets/adebdce5-ffd2-4677-b66a-8824cb2b464e)
**8.2 Cấu trúc cây nhị phân tìm kiếm BST**

### 9. Heap
### 10. Graph (Đồ thị)

