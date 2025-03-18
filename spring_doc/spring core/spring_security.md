# **------ Tóm Tắt ------**
1. Khái niệm
2. Cấu hình Spring Security
3. Xác thực (Authentication)
4. Ủy quyền (Authorization)
5. Xác thực API với JWT
6. Tùy chỉnh UserDetailsService
7. OAuth2 & OpenID Connect (OIDC)
8. Rate Limiting & API Key Authentication

# **------ Nội dung chi tiết ------**
- https://200lab.io/blog/co-che-hoat-dong-cua-spring-security

## 1. Khái niện
- Cơ chế hoạt động của Spring Security dựa trên cơ chế lọc (filter) và sự kiện (event) để can thiệp vào quá trình xử lý yêu cầu (request) và phản hồi (response) của ứng dụng web, tức là khi một yêu cầu được gửi đến ứng dụng web, nó sẽ được chuyển qua một chuỗi các bộ lọc (filter chain) do Spring Security quản lý.
- Mỗi bộ lọc có một nhiệm vụ cụ thể, như kiểm tra xác thực, kiểm tra phân quyền, điều hướng đến trang đăng nhập hoặc đăng xuất, xử lý các lỗi bảo mật.
- ![image](https://github.com/user-attachments/assets/eee398df-0241-4898-9073-971d26cab000)
**1.1 Các thành phần chính**
- Authentication
- Authorization
- Authentication Provider

**1.2 SecurityFilterChain**


## 2. Authentication
**2.1 Khái niện**
- là quá trình xác thực xem người dùng có quyền truy cập vào ứng dụng hay không.
- Authentication thường dựa trên các thông tin nhận dạng (identifier) và thông tin bí mật (credential) của người dùng hoặc ứng dụng, ví dụ như tên đăng nhập và mật khẩu, mã token, vân tay, khuôn mặt tùy theo cách tiếp cận của ứng dụng đó.
**2.2 Trạng thái (stateful) và phi trạng thái (stateless)
- Trạng thái (Stateful) :  là một cách tiếp cận xác thực trong đó hệ thống sẽ lưu trữ thông tin xác thực của người dùng hoặc ứng dụng trong một phiên (session) trên máy chủ
- Phi trạng thái (Stateless) : là một cách tiếp cận khác với Stateful, khi đó hệ thống không lưu trữ thông tin xác thực của người dùng hoặc ứng dụng trên máy chủ, mà chỉ sử dụng các mã token đã được ký số để xác thực thông tin
- 
