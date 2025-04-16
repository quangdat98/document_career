# **------ Tóm Tắt ------**
1. Tài liệu tham khảo
2. Giới thiệu


# **------ Nội dung chi tiết ------**

## ***1. Tài liệu tham khảo***
- https://docs.spring.io/spring-boot/index.html
- https://www.geeksforgeeks.org/spring-boot/?ref=ml_lbp

## 2. Giới thiệu
**2.1 Spring Boot là gì?**
- Auto-Configuration
- Modular Architecture & Separation of Concerns
  + Modular Architecture: Mỗi module là một khối độc lập về chức năng (feature-based), có thể phát triển riêng, build riêng, thậm chí deploy riêng. ![image](https://github.com/user-attachments/assets/d405782c-74dc-4494-b440-6f00a680cc9e)

  + Separation of Concerns (SoC): Là nguyên lý lập trình cơ bản, **"Mỗi module/class/folder/… nên chỉ quan tâm đến một mối lo duy nhất."**
  + Như là là Nhận request => controller, Xử lý logic => service...
- Hiểu rõ Spring Boot lifecycle & Bean Scopes
- Spring Profiles – Cấu hình theo môi trường
- Dependency Management – Starter vs Custom
- Packaging & Deployment – DevOps friendly
- Microservice & Cloud-Native Readiness
  + Hiểu pattern: Service Discovery, Circuit Breaker, Rate Limiting, Retry, Timeout.
  + Tích hợp với các tool như: Spring Cloud (Eureka, Config Server, Gateway), Resilience4j, AWS/GCP integrations.
