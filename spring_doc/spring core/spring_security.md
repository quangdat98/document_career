# **------ Tóm Tắt ------**
1. Khái niệm
2. Use Case of Spring Security
3. Spring Security - Core
4. Spring Security - Registration, Login & Logout
5. Spring Security - Authentication and Authorization
6. Spring Security - JWT
7. Spring Security - Method Level Security
8. Spring Security - CSRF and CORS



10. Cấu hình Spring Security
11. Xác thực (Authentication)
12. Ủy quyền (Authorization)
13. Xác thực API với JWT
14. Tùy chỉnh UserDetailsService
15. OAuth2 & OpenID Connect (OIDC)
16. Rate Limiting & API Key Authentication

# **------ Nội dung chi tiết ------**
- https://200lab.io/blog/co-che-hoat-dong-cua-spring-security
- https://www.baeldung.com/security-spring
- ![image](https://github.com/user-attachments/assets/0c6f6e88-5a31-44e1-b7b5-e0aa9b8c7bb6)
- https://www.geeksforgeeks.org/spring-security-tutorial/

## 1. Khái niện
- Cơ chế hoạt động của Spring Security dựa trên cơ chế lọc (filter) và sự kiện (event) để can thiệp vào quá trình xử lý yêu cầu (request) và phản hồi (response) của ứng dụng web, tức là khi một yêu cầu được gửi đến ứng dụng web, nó sẽ được chuyển qua một chuỗi các bộ lọc (filter chain) do Spring Security quản lý.
- Mỗi bộ lọc có một nhiệm vụ cụ thể, như kiểm tra xác thực, kiểm tra phân quyền, điều hướng đến trang đăng nhập hoặc đăng xuất, xử lý các lỗi bảo mật.
- ![image](https://github.com/user-attachments/assets/eee398df-0241-4898-9073-971d26cab000)
**1.1 Các thành phần chính**
- Authentication
- Authorization
- Authentication Provider

## 2. Use Case of Spring Security
**2.1 Các trường hợp nào sử dụng spring security**
- Cần xác thực và phân quyền
- Bảo vệ các ứng dụng khỏi các mối đe dọa phổ biến như tấn cong xuyên trang (xss) hay làm giả yêu cầu trang (csrf)
- Hỗ trợ sso, xác thực một lần truy cập nhiều ứng dụng.
- Cho phép dev thảo thích cấu hình.
- Auditing and Logging

## 3.  Spring Security - Core

**3.1 Features**
- Authorization
- Single sign-on: cho phép người dùng sử dụng 1 tài khoản duy nhất để truy cập nhiều ứng dụng khác nhau
- Software Localization
- Remember-me
- LDAP (Lightweight Directory Access Protocol)
- JAAS (Java Authentication and Authorization Service) LoginModule
- Web Form Authentication
- Digest Access Authentication
- HTTP Authorization
- Basic Access Authentication
Features Added in Spring Security 6.0
- OAuth 2.0 Login
- Reactive Support
- Modernized Password Encoding

**3.2 spring security architecture**
- 








-----------------------------------------------------------------------------------------------------------------------------------------------------------
**1.2 SecurityFilterChain**



## 2. Authentication
**2.1 Khái niện**
- là quá trình xác thực xem người dùng có quyền truy cập vào ứng dụng hay không.
- Authentication thường dựa trên các thông tin nhận dạng (identifier) và thông tin bí mật (credential) của người dùng hoặc ứng dụng, ví dụ như tên đăng nhập và mật khẩu, mã token, vân tay, khuôn mặt tùy theo cách tiếp cận của ứng dụng đó.
**2.2 Trạng thái (stateful) và phi trạng thái (stateless)
- Trạng thái (Stateful) :  là một cách tiếp cận xác thực trong đó hệ thống sẽ lưu trữ thông tin xác thực của người dùng hoặc ứng dụng trong một phiên (session) trên máy chủ
- Phi trạng thái (Stateless) : là một cách tiếp cận khác với Stateful, khi đó hệ thống không lưu trữ thông tin xác thực của người dùng hoặc ứng dụng trên máy chủ, mà chỉ sử dụng các mã token đã được ký số để xác thực thông tin
- Một số chủ đề ứng dụng spring security:
   + **Spring Security Form Login (popular)**: Cung cấp cơ chế đăng nhập bằng form HTML (https://www.baeldung.com/spring-security-login)
   + **Spring Security Basic Authentication (popular)**: Sử dụng Basic Authentication với Authorization: Basic base64(username:password). Trình duyệt hoặc client API sẽ gửi username/password trong Header. (https://www.baeldung.com/spring-security-basic-authentication)
   + **Spring Security Authentication Provider (popular)**: Cung cấp cơ chế xác thực tùy chỉnh bằng cách tạo một class Custom AuthenticationProvider để xác thực người dùng theo logic riêng (CSDL, LDAP, JWT, OAuth2...). (https://www.baeldung.com/spring-security-authentication-provider)
   + **How to Manually Authenticate User with Spring Security**: Cho phép đăng nhập thủ công bằng cách gọi SecurityContextHolder và tự tạo UsernamePasswordAuthenticationToken.
   + **Spring Security Custom AuthenticationFailureHandler**: Xử lý trường hợp xác thực thất bại (password sai, tài khoản bị khóa...). Cho phép tuỳ chỉnh thông báo lỗi, chuyển hướng trang, hoặc ghi log chi tiết.
   + **Securing Spring Boot API With API Key and Secret (popular)**: Bảo mật API bằng API Key thay vì username/password hoặc OAuth2. Thường sử dụng X-API-KEY trong HTTP headers.
   + **Securing Spring Boot Applications With SSL Bundles (popular)**: Cấu hình Spring Boot với SSL/TLS để mã hóa kết nối HTTP thành HTTPS. (https://www.baeldung.com/spring-boot-security-ssl-bundles)
   + **Authenticating Users with AzureAD in Spring Boot (popular)**: Tích hợp Azure Active Directory (Azure AD) vào Spring Security để xác thực người dùng thông qua OAuth2 & OpenID Connect. (https://www.baeldung.com/spring-security-login)
  
