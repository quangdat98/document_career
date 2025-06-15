# 1. Memo
1. React Cốt lõi (Fundamentals)
2. Hooks quan trọng
3. Routing
4. Giao tiếp với API
5. State Management
6. Forms và Validation
7. Performance và Optimization
8. Error Handling & Testing
9. UI/UX & Styling
10. Cấu trúc và tổ chức code

# context

## 2
- Là các hàm đã được viết sẵn được dùng cho reactjs
- Hook là các hàm đặc biệt trong React cho phép bạn sử dụng state, lifecycle, và logic React mà không cần dùng class component.
- Trước đây (trước React 16.8), bạn phải dùng class để có state hoặc componentDidMount.
- Từ React 16.8, bạn có thể dùng function component + hook để làm mọi thứ.
- **Component Mount**  Là khoảnh khắc mà component được tạo ra và hiển thị lần đầu tiên trên giao diện (DOM).
- **Component Unmount**  Là khi component bị xoá khỏi DOM (không còn được hiển thị).

## 2.1 useContext
- https://viblo.asia/p/context-api-trong-react-XL6lAovJKek
- thi bạn muốn chuyển 1 giá trị props thông qua nhiều component.

**2.1. các thành phần**
- Context API bao gồm một số khối xây dựng quan trọng:
  + createContext() Tạo ra một context object (ống chia sẻ dữ liệu toàn cục). VD const MyContext = createContext();
  + Provider (MyContext.Provider) Là component dùng để truyền dữ liệu xuống toàn bộ cây component con. ![image](https://github.com/user-attachments/assets/52d063d2-5f85-445c-95b2-a511936c1381)
  + useContext() (hook) Giúp lấy dữ liệu từ context trong một component. ![image](https://github.com/user-attachments/assets/12616c5d-52c7-4ffe-8efd-55fb815ff435)
  +  Consumer (ít dùng) Một cách khác để lấy dữ liệu từ context, dùng trước khi có useContext.

- VD:
  + ![image](https://github.com/user-attachments/assets/b13f12cf-5714-43e1-b6a2-b9693bd32eed)
  + ![image](https://github.com/user-attachments/assets/a26834c7-4fa4-4884-96f4-ea47db54290a)
  + ![image](https://github.com/user-attachments/assets/8010b12b-7d94-4ea3-a905-b22ab953f253)

## 2.2 useState hook
- Các dùng const [state, setState] = useState(initialValue);
  + state 	Giá trị hiện tại
  + setState Hàm dùng để cập nhật state -> nó chỉ đk dùng 1 lần render đâu tiên
  + initialValue Giá trị khởi tạo ban đầu
- ![image](https://github.com/user-attachments/assets/209c4d7d-e709-4930-a668-cd1db10eb129)
- Không gọi useState trong if/for/function -> lỗi
- Mỗi lần bạn gọi setState(...), React mặc định sẽ re-render component, ngay cả khi giá trị mới = giá trị cũ.Nếu giá trị mới (newState) giống hệt giá trị cũ (prev), thì không cần gọi setState nữa → tránh re-render.
  + ![image](https://github.com/user-attachments/assets/3b232d09-a3d1-4c76-9fe5-208e57f30112)

- Two-way binding = Khi UI thay đổi, dữ liệu cũng thay đổi, và ngược lại: dữ liệu thay đổi, UI cũng cập nhật.
- 

## 2.3 useEffect
- sẽ chạy sau render
- Cú pháp ![image](https://github.com/user-attachments/assets/a9a9358b-aa48-4629-a7d8-3f08a5bb75a8)
  + useEffect(...) Hàm hook được React gọi sau khi render
  + return () => {...} Hàm dọn dẹp, chạy trước khi re-run hoặc khi component unmount
  + [dependencies] 	Danh sách phụ thuộc, điều khiển khi nào useEffect chạy lại
- [dependencies] rỗng 	Chạy 1 lần sau lần render đầu tiên (giống componentDidMount)
- Không có [] Chạy sau mỗi lần render, kể cả nhỏ nhất
- VD
  + ![image](https://github.com/user-attachments/assets/9210f0ec-27c8-4276-bc88-f2640b7c528f)
  + ![image](https://github.com/user-attachments/assets/08600a40-af47-4b0f-a5a7-9a4dbd3cf83c)
  + ![image](https://github.com/user-attachments/assets/4781c39c-fa54-4818-b0fa-02ecdb142f9c)

- ![image](https://github.com/user-attachments/assets/3ab2b071-94c0-43bf-b0be-32d4ac78886c)

## 2.4 useRef Tham chiếu DOM hoặc giữ giá trị không trigger re-render
- const myRef = useRef(initialValue);
- useRef trả về một object: { current: initialValue }
  + **Giá trị trong ref.current không bị mất sau mỗi lần render**
  + Thay đổi ref.current sẽ không gây re-render
  + chỉ dùng initialValue ở lần đâu tiên mount
  + 

VD: 
  + ![image](https://github.com/user-attachments/assets/93f5f856-1551-4315-a5b6-0a042307df12)
  + Không stop được là do useState chạy render lại => biến timerId vị reset về undefine
  + Cách 1 đưa biên đó ra ngoài function ![image](https://github.com/user-attachments/assets/4c84c854-be25-4175-ac6b-da5e01879d95)
  + => cách 2 dùng useRef thì giá trị của nó sẽ ko mất đi ![image](https://github.com/user-attachments/assets/83ce96a6-c778-41d9-bf98-01c408921c95)

## 2.5 useMemo Tối ưu performance khi tính toán nặng
- React.memo -> higher order component
- xử lý 1 component trách bị re-render trong cac tình huống không cần thiết
- Khi cha render mà thằng con ko cần
- Chúng ta dùng React.memo ở thằng con ![image](https://github.com/user-attachments/assets/e047cfe2-2c00-40db-85cf-1d5050ef3f93)
- Nếu dùng React.memo thì phải dùng userCallback(): lỹ do là Ract.memo kiểm tra là xem props có bị thay đổi hay ko nếu ko thì nó sẽ ko render -> dùng useCallback nếu mà các function giống nhau thì nó sẽ đẩy ra 1 biên chung và tham chiếu vào (giống như kiểu string pool)

- **useMemo giúp ghi nhớ (memoize) kết quả của một biểu thức/hàm tính toán tốn kém** Chỉ tính lại khi dependencies thay đổi.
- ![image](https://github.com/user-attachments/assets/292da1c5-b351-4a0a-8eeb-9076e46e914d)
= > nó dùng để  **Tối ưu tính toán**

## 2.6 Tối ưu hàm callback (đặc biệt khi truyền xuống props)
- Sinh ra để trách tạo các hàm không cần thiết trong hàm callback 
- Callback là một hàm được truyền vào hàm khác như một đối số, và sẽ được gọi lại sau khi hành động nào đó xảy ra.
- ![image](https://github.com/user-attachments/assets/6d6fdca9-7850-496c-8931-99f7bd2bdb45)
- Khi chúng ta viết 1 function trong 1 file react thì nếu hàm đó bị render và các hàm con ko có thay đổi gì những vẫn bị render lại => dùng useCallback để nó ko bị thay đổi.
