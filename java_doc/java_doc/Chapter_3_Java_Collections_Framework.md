# ** ------ Tóm Tắt ------ **

## I. Java Collections Framework (JCF)
1. Iterable interface
2. Cursors
3. Collections Utility
4. Collection interface
5. List interface
5.1 ArrayList
5.2 LinkedList
6. Set interface
6.1 HashSet
6.2 LinkedHashSet
6.3 TreeSet
6.4 EnumSet
7. SortedSet interface
8. Map interface
8.1 HashMap & ConcurrentHashMap
8.2 TreeMap
8.3 EnumMap
9. SortedMap interface
10. Queue interface
11. Khai báo  
12. Lớp Vector
13. Comparable
14. Comparator
15. Lớp properties
16. NavigableMap
17. NavigableSet
18. WeakHashMap

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
- Collectors.counting(): Đếm số phần tử trong mỗi nhóm. (thường kết hợp với groupingBy -để đếm số phần tử trong 1 list)
- Collectors.groupingBy : nhóm các phần tử theo một tiêu chí nào đó. ![image](https://github.com/user-attachments/assets/a4c80261-67ed-4495-8806-7467bd379d80) ![image](https://github.com/user-attachments/assets/e11bd8c6-3cdd-4e97-902c-ba291136c749)
  + Nhóm + đếm: Thêm Collector thứ 2 ![image](https://github.com/user-attachments/assets/83374967-660e-4092-80f7-c2258177394f)
  + Nhóm + xử lý nâng cao: groupingBy(e -> key, collector)




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

#### 5.1 ArrayList Class
- ArrayList<E> là một implementation của List<E>
- Lưu trữ phần tử theo thứ tự chèn (Indexed Collection), truy cập phần tử nhanh nhưng thêm xóa phần tử chậm.
- Tự động tăng kích thước khi đầy (1.5x kích thước hiện tại).
- Không đồng bộ (nếu cần đồng bộ, hãy dùng Collections.synchronizedList()).
- ensureCapacity(): tăng kích thước trước: do mặc địch arrayList tăng 1,5x lần khi đầy => có thể gây tốn tài nguyên nếu thêm nhiều phần tử liên tục.
- trimToSize(): Giải phóng bộ nhớ nếu không cần mở rộng thêm.

#### 5.2 LinkedList Class
- là một implementation của cả List<E> và Deque<E>,Queue => nó triển khai cả các interface của list và queue, Queue sử dụng danh sách liên kết đôi (Doubly Linked List) để lưu trữ dữ liệu.
- Cho phép phần tử trùng lặp và null.
- Truy cập phần tử chậm hơn ArrayList (O(n)).
- LinkedList có thể hoạt động như:
  + List<E> → Vì nó hỗ trợ truy cập phần tử theo chỉ mục (index-based), duy trì thứ tự chèn và cho phép các thao tác thêm, xóa, sửa phần tử tại bất kỳ vị trí nào trong danh sách.
  + Queue<E> → Vì nó hỗ trợ hàng đợi (FIFO - First In First Out), giúp quản lý dữ liệu theo kiểu hàng đợi như offer(), poll(), peek().
  + Deque<E> → Vì nó hỗ trợ hàng đợi hai đầu (Double-Ended Queue), có thể thêm/xóa phần tử từ cả hai đầu của danh sách (đầu và cuối) với các phương thức như addFirst(), addLast(), removeFirst(), removeLast().
  + Hỗ trợ cả FIFO (Queue) và LIFO (Stack).
  + LinkedList có thể dùng làm Stack<E> ![image](https://github.com/user-attachments/assets/b26a719f-9b08-410f-bb2b-10faa2f15b80)
  + Nếu cần truy cập phần tử thường liên tục và khi bộ nhớ quan trọng thì không nên dùng LinkedList.

### 6. Set interface
- là một interface trong Java thuộc gói java.util, kế thừa từ Collection<E>. Set không cho phép phần tử trùng lặp và không đảm bảo thứ tự chèn vào (trừ LinkedHashSet và TreeSet).
- Nếu cố thêm phần tử đã tồn tại, nó sẽ bị bỏ qua.
- **Không có chỉ mục, không thỉ truy xuất bằng index**
- Có thể chứa null, nhưng chỉ 1 giá trị null

#### 6.1 HashSet Class
- Thứ tự các phần tử trong HashSet không dựa theo thứ tự lúc thêm vào và giá trị của các phần tử này là duy nhất khác với array
- Một hash table lưu giữ thông tin bởi sử dụng một kỹ thuật được gọi là hashing (băm)
#### 6.2 LinkedHashSet Class
- Giống như HashSet, LinkedHashSet cũng không cho phép phần tử trùng lặp
- LinkedHashSet duy trì thứ tự của các phần tử theo cách chúng được chèn vào. Điều này có nghĩa là khi duyệt qua LinkedHashSet, các phần tử sẽ được trả về theo đúng thứ tự chèn ban đầu.
- Sử dụng HashMap và LinkedList: Bên trong, LinkedHashSet sử dụng một HashMap để lưu trữ các phần tử, nhưng cũng có một danh sách liên kết (LinkedList) để duy trì thứ tự chèn.
#### 6.3 TreeSet Class
- Tương tự như HashSet, TreeSet không cho phép phần tử trùng lặp.
- TreeSet duy trì phần tử trong một thứ tự tự nhiên (natural ordering) hoặc theo một comparator (nếu được cung cấp).
- Sử dụng TreeMap bên trong: TreeSet được triển khai dựa trên TreeMap, đảm bảo rằng các phần tử sẽ được lưu trữ theo thứ tự sắp xếp.
#### 6.4 EnumSet Class
- Triển khai Set: EnumSet là một triển khai đặc biệt của Set chỉ dành cho các enum types (kiểu dữ liệu enum).
- Hiệu suất cao: EnumSet rất hiệu quả về mặt bộ nhớ và thời gian vì nó sử dụng một mảng bit để lưu trữ các giá trị enum.
- ![image](https://github.com/user-attachments/assets/76ea8490-3134-4e3d-a7fd-771afada8b20)
- enum không tự sử dụng bit để biểu diễn, nhưng EnumSet (một lớp chuyên biệt cho các tập hợp enum) sử dụng mảng bit (bit vector) để lưu trữ các giá trị enum một cách hiệu quả và nhanh chóng.
- todo..
- ![image](https://github.com/user-attachments/assets/c0208c4e-5387-499d-9b55-2d9fcf9257f0)
- ![image](https://github.com/user-attachments/assets/41cdc6f4-7630-488f-9351-e5652f09733c)

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
- Một số phương thức:
  + V getOrDefault(Object key, V defaultValue): trả ra value theo key, nếu ko có thì trả về defaultValue => phù hợp với bài toán liệt kê số lần suất hiện của phần tử:  ![image](https://github.com/user-attachments/assets/3d0d284c-0c7b-4319-bf25-3fff7a588337)


#### 8.1 HashMap Class
- Không bảo toàn thứ tự phần  tử được thêm vào
- Key ko trùng lặp, có cả key và value null. Chỉ 1 key null
- Không đồng bộ hóa. Muốn đồng bộ hóa dùng Collections.synchronizedMap(). hoặc class ConcurrentHashMap
#### 8.1.1 ConcurrentHashMap Class
- Hỗ trợ đồng bộ
- Cung cấp hiệu suất cao trong môi trường đa luồng.
#### 8.2 TreeMap Class
- Bảo toàn thứ tự: Các phần tử trong TreeMap luôn được sắp xếp theo thứ tự tăng dần của các keys. Bạn có thể sử dụng các Comparator để thay đổi thứ tự sắp xếp.
- Không hỗ trợ null key nhưng value null thì dược
- Không đồng bộ hóa.
#### 8.3 EnumMap Class
- Khóa phải là enum: EnumMap chỉ cho phép sử dụng enum làm key. Không thể sử dụng bất kỳ kiểu dữ liệu nào khác làm khóa.
- Hiệu suất cao: EnumMap sử dụng một mảng để lưu trữ các cặp key-value, giúp tối ưu về mặt hiệu suất và bộ nhớ khi làm việc với enum.
- Bảo toàn thứ tự: Các phần tử trong EnumMap sẽ được lưu trữ theo thứ tự khai báo của các giá trị trong enum.
- ![image](https://github.com/user-attachments/assets/583f8c93-2562-413a-9005-010bd0ec7d45)

#### 8.4 Hashtable Class
- Giống HashMap nhưng khác biệt là HashTable là đồng bộ.
- Không cho phép khóa và giá trị null.
- Hashtable đã cũ ko tối ưu hiệu suất => dùng ConcurrentHashMap.

### 9. SortedMap interface
- Nó là dạng riêng của map interface, tính vượt trội của nó là các entry trong SortedMap được sắp xếp tăng dần theo key
- Các tính năng tương tự sortedSet

### 10. Queue interface
- đại diện cho cấu trúc dữ liệu hàng đợi (FIFO – First In, First Out).
- Nó cung cấp chức năng của cấu trúc dữ liệu hàng đợi:Hàng đợi sẽ chèn các phần tử vào cuối hàng đợi và xóa khỏi đầu hàng đợi. -> đây là điểm khác biệt nhất giữa quene và các collection khác.
- Không cho phép null (trừ LinkedList).
- Có thể giới hạn kích thước (bounded queue) hoặc không (unbounded queue).
- Vì nó là interface nên chúng ta cần các class để triển khai nó: ArrayDeque, LinkedList,  priorityQueue, Dqueue, BlockingQueue, BlockingDeque
- Các phương thức quan trọng: ![image](https://github.com/user-attachments/assets/4491b300-6b97-4573-8296-703086576b19)
### 11. Khai báo 
- VD List<String> list = new ArrayList<>(); và ArrayList<String> list1 = new ArrayList<>();
- Nhận thấy Đây là kiểu dữ liệu interface, nghĩa là List là một giao diện mà các lớp như ArrayList hoặc LinkedList triển khai. Chúng ta có thể đổi ArryList sang LinkedList mà không cần phải sửa mã nguồn
### 12. Lớp Vector
- Nó giống ArrayList nhưng có thêm đồng bộ
- Khi Vector đạt đến giới hạn của kích thước hiện tại, nó sẽ tự động tăng kích thước lên gấp đôi kích thước hiện tại. => tốn bộ nhớ
- Giờ không còn dùng vector nữa
- ![image](https://github.com/user-attachments/assets/e46ac086-f22f-4c1b-837c-193d51b9d4c7)

### 13. Comparable Interface - so sánh cùng loại (phải implements Comparable)
- Mục đích: Dùng để so sánh các đối tượng trong cùng một lớp. Cung cấp một phương thức mặc định cho phép đối tượng tự so sánh với các đối tượng khác của cùng loại.
- Giao diện Comparable chứa phương thức so sánhTo để quyết định thứ tự của các phần tử.
- Override the compareTo method trong class object cần compare
- Sử dụng hàm Arrays.sort() hoặc Collections.sort() để sắp xếp mảng.
- ![image](https://github.com/user-attachments/assets/c0f40d45-5df8-424f-b6fd-5421913609bc)
- ![image](https://github.com/user-attachments/assets/23833e61-24de-4c3c-af33-2bc25a26cf56)
- ![image](https://github.com/user-attachments/assets/83d885af-4ce8-47f2-b427-581434aaa58a)

### 14. Comparator Interface - so sánh tùy chỉnh
- **Comparator tạo ra các so sánh tùy chỉnh**
- ![image](https://github.com/user-attachments/assets/d9cdf222-d9a4-4229-8837-8e3fe657ac4d)

### 15. Lớp properties
- Lớp Properties trong java được sử dụng để tạo ra đối tượng chứa cặp khóa (key) và giá trị (value) như một chuỗi. Lớp java.util.Properties là một lớp con của Hashtable.
- Lớp Properties cung cấp các phương thức lấy dữ liệu từ các file .properties và lưu trữ dữ liệu vào file .properties. Hơn nữa, nó có thể được sử dụng để có được properties của hệ thống.
- ![image](https://github.com/user-attachments/assets/44044f6d-97b6-437d-a209-5867d3a50cd6)

### 16. NavigableMap interface
- NavigableMap là một phần mở rộng của SortedMap
- Bạn có thể sử dụng các phương thức bổ sung như lower(), floor(), ceiling(), higher() để lấy phần tử gần nhất theo thứ tự của bản đồ.
- TreeMap là một trong những lớp cài đặt phổ biến của NavigableMap.
- ![image](https://github.com/user-attachments/assets/8afa550e-cd7d-4d8c-8807-372dd8e73dbe)
- ![image](https://github.com/user-attachments/assets/078a88ec-68d5-4eb3-b69d-84531b34c14c)

### 17. NavigableSet interface
- là một interface trong Java, mở rộng từ SortedSet, cung cấp các phương thức để làm việc với một tập hợp (set) theo thứ tự tự nhiên hoặc tùy chỉnh, đồng thời hỗ trợ thao tác điều hướng (navigable).
- NavigableSet hỗ trợ việc tìm kiếm phần tử gần nhất theo thứ tự tăng dần hoặc giảm dần.
- TreeSet là một trong những lớp cài đặt phổ biến của NavigableSet.
- ![image](https://github.com/user-attachments/assets/0f62e436-8e92-4349-a216-abe43705f179)

### 18. WeakHashMap Class
- là một lớp trong Java cài đặt Map, trong đó các khóa được lưu trữ dưới dạng weak reference (tham chiếu yếu). Điều này có nghĩa là các khóa trong WeakHashMap sẽ không ngăn cản bộ thu gom rác (garbage collector) thu gom chúng nếu không còn tham chiếu mạnh đến chúng từ các phần khác trong ứng dụng.
- WeakHashMap rất hữu ích trong các tình huống như lưu trữ cache, nơi bạn muốn cho phép các đối tượng bị thu gom khi chúng không còn cần thiết nữa.
- WeakHashMap không đảm bảo thứ tự của các phần tử, giống như các lớp Map khác.
- ![image](https://github.com/user-attachments/assets/162e1395-c26c-42d3-a664-f31bed319e48)
- 




