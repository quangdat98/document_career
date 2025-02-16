# ** ------ Tóm Tắt ------ **

## I. Java Collections Framework (JCF)
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
- Mảng: Thao tác với mảng nhanh nhưng lại có quá ít các hàm để thao tác với dữ liệu, phải khai báo trước số lượng phần tử -> Collection được sinh ra để khắc phục các mặt hạn chế đó.
- **Một Java Collections Framework là một tập hợp các lớp (class) và các interface dùng để hỗ trợ việc thao tác trên tập các đối tượng**
- ![image](https://github.com/user-attachments/assets/3638192d-c746-4551-831e-ff892fb7b09c)
- ![image](https://github.com/user-attachments/assets/5366c357-41f2-4c0b-ab26-157a98c29fa3)

## ***Tài liệu tham khảo***
- https://docs.oracle.com/javase/tutorial/collections/TOC.html
- https://www.geeksforgeeks.org/java-collection-tutorial/?ref=lbp
- https://www.digitalocean.com/community/tutorials/collections-in-java-tutorial

### 1. Iterable interface
**1.1 Khái niệm**
- https://www.geeksforgeeks.org/iterable-interface-in-java/
- Iterable<T> là một interface trong java.lang, giúp một đối tượng có thể được duyệt bằng vòng lặp for-each.
- **Là nền tảng của nhiều collection như List, Set, Queue** : Collectoin extends Iterable
- ![image](https://github.com/user-attachments/assets/5b346ae1-c1b1-453f-8eb7-f1b2f31c7cb1) Chúng ta dùng được forEach trong các collection khác là do chúng đã extend iterable.
- Cho phép sử dụng for-each để duyệt collection mà không cần gọi trực tiếp iterator()
- Trong Iterable có Interface: Iterator<T> iterator(); => Tất cả các Collection (List, Set, Queue,...) trong Java đều sử dụng Iterator<T> để duyệt phần tử.
- **Khi sử dụng Iterator<T>, ta có thể xóa phần tử trong quá trình duyệt (remove()).**

### 2. Cursors
**2.1 khái niện**
- **Cursor là một khái niệm dùng để duyệt và thao tác với phần tử của Collection trong Java.**
- Java cúng cấp 3 loại Cursor để duyệt Collection:
  + **Iterator** (Cơ bản, dùng được cho tất cả Collection, được tạo ra bởi Iterable thông qua phương thức iterator()) ![image](https://github.com/user-attachments/assets/82e9001e-7e0f-4c3a-a077-4828465b61ec)
  + **ListIterator** (Chỉ dùng cho List, duyệt hai chiều) ![image](https://github.com/user-attachments/assets/2774c0b4-a3c4-4496-8d32-8da174f8ca90)
  + **Enumeration** (Cũ, chủ yếu dùng với Vector và Hashtable) ![image](https://github.com/user-attachments/assets/20074574-0c79-4a9f-b489-c511bab5298e)

### 3. Collections Utility class
**3.1 Khái niện**
- https://www.javaguides.net/2018/07/java-util-collections-class-methods-guide.html
- Collections là một utility class trong java.util cung cấp các phương thức tĩnh để làm việc với Collection (List, Set, Queue, Map).
- Collections.sort(List<T>): dùng để sắp xếp theo thức tự tăng dần.
- Collections.reverse(List<t>): Đảo ngược danh sách.
- Collections.binarySearch(list, key) = index : tìm kiếm phân tử trong list.
- Collections.fill(List<T>, value): thay thế toàn bộ phần tử trong list thành value.
- Collections.max(), Collections.min().
- **Collections.unmodifiableList(list)**: Tạo ra 1 danh sách chỉ đọc
- **Collections.synchronizedList(list), Collections.synchronizedSet(list)**: Tạo ra 1 list an toàn cho nhiều luồng(thread-safe).
- shuffle: trộn ngẫy nhiên phần tử.

### 4. Collection interface
**4.1 Khái niệm**
- Collection là interface gốc trong thư viện Collections Framework. Các interface khác như List, Set, và Queue đều kế thừa từ Collection. Collection thì lại kế thừa từ thằng Iterable.
- Mỗi interface mở rộng chức năng của Collection để phục vụ các mục đích cụ thể khác nhau trong việc quản lý tập hợp dữ liệu.
- ![image](https://github.com/user-attachments/assets/88e20cea-4544-44f0-a441-344339e9524c)

### 5. List interface
- Thứ tự các phần tử trong danh sách có thử tự chèn vào, phần tử có thẻ trùng lặp và null.
- Hỗ trợ Iterator, ListIterator để duyệt danh sách.
- Trong một số trường hợp thực tiễn nếu insert dữ liệu bị ghi đè cùng 1 giá trị của item thì lúc add chúng ta nên sử dụng new object. VD list.add(new Qrcode(....)). làm như thế thì bắt buộc list  phải thêm 1 phần tử mới.
### 6. Set interface
- là một interface trong Java thuộc gói java.util, kế thừa từ Collection<E>. Set không cho phép phần tử trùng lặp và không đảm bảo thứ tự chèn vào (trừ LinkedHashSet và TreeSet).
- Nếu cố thêm phần tử đã tồn tại, nó sẽ bị bỏ qua.
- **Không có chỉ mục, không thỉ truy xuất bằng index**
- Có thể chứa null, nhưng chỉ 1 giá trị null
- Các Implementations của set
  + HashSet
  + LinkedHashSet
  + TreeSet
  + EnumSet

### 7. SortedSet interface
- **Là một interface** trong Java thuộc gói java.util, kế thừa từ Set<E>.
- Nó đảm bảo thứ tự sắp xếp tự nhiên hoặc theo một Comparator được cung cấp.
- Triểu khai nổi tiếng  là TreeSet.
- ![image](https://github.com/user-attachments/assets/cd4f8018-a699-4af5-b48c-6bbfc1ae474b)
- Ví dụ sử dụng với comparator: ![image](https://github.com/user-attachments/assets/adfbbf17-b38e-4453-ba1b-d8da5e676a59)
- **so sánh SortedSet và set**: ![image](https://github.com/user-attachments/assets/47101836-3196-412e-9735-13cb1cb24f85)

### 8. Map interface
- Map<K, V> là một interface trong Java thuộc gói java.util, dùng để lưu trữ các cặp key-value. Key không được trùng lặp, nhưng value có thể trùng lặp.
- Không cho phép key trùng lặp, nếu thêm key trùng, value cũ bị ghi đè.
- Có thể chứa nhiều giá trị giống nhau (values), nhưng keys phải duy nhất.
- Không kế thừa từ Collection, nên không thể duyệt như List hoặc Set.
- Hỗ trợ ba loại tập hợp: keySet(), values(), entrySet(). ![image](https://github.com/user-attachments/assets/cf01c789-be37-4162-952c-acaef5bf09b8)
- Các loại implemention
  + HaspMap: Sử dụng bảng băm (HashTable), không đảm bảo thứ tự, truy xuất nhanh (O(1))
  + LinkedHashMap: 	Giữ thứ tự chèn vào, hiệu suất gần bằng HashMap
  + TreeMap: Sắp xếp theo key (mặc định tăng dần), sử dụng cây đỏ-đen (O(log n))
  + Hashtable: Tương tự HashMap, nhưng đồng bộ (synchronized), chậm hơn
  + ConcurrentHashMap: Phiên bản HashMap hỗ trợ đa luồng, an toàn khi truy cập đồng thời
- ![image](https://github.com/user-attachments/assets/9e00e65d-0bca-4991-866d-d3d9a83e4ada)

### 9. SortedMap interface
- Nó là dạng riêng của map interface, tính vượt trội của nó là các entry trong SortedMap được sắp xếp tăng dần theo key
- Các tính năng tương tự sortedSet

### 9. Queue interface
- đại diện cho cấu trúc dữ liệu hàng đợi (FIFO – First In, First Out).
- Nó cung cấp chức năng của cấu trúc dữ liệu hàng đợi:Hàng đợi sẽ chèn các phần tử vào cuối hàng đợi và xóa khỏi đầu hàng đợi. -> đây là điểm khác biệt nhất giữa quene và các collection khác.
- Không cho phép null (trừ LinkedList).
- Có thể giới hạn kích thước (bounded queue) hoặc không (unbounded queue).
- Vì nó là interface nên chúng ta cần các class để triển khai nó: ArrayDeque, LinkedList,  priorityQueue, Dqueue, BlockingQueue, BlockingDeque
- Các phương thức quan trọng: ![image](https://github.com/user-attachments/assets/4491b300-6b97-4573-8296-703086576b19)

### 10. Class ArrayList
-
13. Class LinkedList
14. Class HashSet
15. Lớp LinkedHashSet
  



