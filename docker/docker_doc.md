- flow by website: https://www.geeksforgeeks.org/docker-tutorial/

# 0. Memo
1. Docker Introduction
2. Docker Installation
3. Docker Commands
4. Docker Run and Dockerfile
5. Docker Images
6. Docker Compose
7. Docker Engine and Storage
8. Docker Networking
9. Docker Registry
10. Docker Containers and Managing Containers
11. Docker Swarm
12. Kubernetes
13. Miscellaneous

----------------------------------------------------------------------------------------------------------------------------
## 1. Docker Introduction

**1.1 Cơ chế hoạt động:**
- Container: Là một môi trường nhẹ, độc lập, chứa mọi thứ cần thiết để chạy ứng dụng (mã nguồn, thư viện, cấu hình, hệ điều hành rút gọn). Container khác với máy ảo (VM) ở chỗ nó không bao gồm toàn bộ hệ điều hành mà chia sẻ kernel của hệ điều hành host, giúp tiết kiệm tài nguyên.
- Image: Là bản mẫu tĩnh dùng để tạo container. Image giống như một snapshot của ứng dụng và môi trường của nó.
  
**1.2 Kiến trúc Docker:**
- Docker Client gửi lệnh đến Docker Daemon.
- Docker Daemon xử lý lệnh, quản lý container/image, và tương tác với Docker Registry để lấy/gửi image.
- Docker Engine là hệ thống tổng thể bao gồm Daemon, Client, và các công cụ khác để container hóa.
- Docker Registry cung cấp nơi lưu trữ và phân phối image.
- STDIN: Standard Input (đầu vào chuẩn). Nó cho phép bạn gửi dữ liệu (nhập vào) từ bàn phím hoặc từ một lệnh shell tới bên trong container.Khi bật --interactive (hay -i), Docker sẽ giữ STDIN mở, cho phép bạn nhập lệnh hoặc dữ liệu thủ công vào container. 
- TTY: Viết tắt của: Teletypewriter.Nó tạo ra một terminal giả lập bên trong container, giúp bạn tương tác với container giống như một terminal thật.. Khi bật --tty (hay -t), Docker cấp cho container một giao diện đầu ra kiểu terminal (có màu, có prompt...).
- Kết hợp STDIN và TTY:
  + -i: giữ STDIN mở → bạn nhập lệnh được.
  + -t: tạo TTY → bạn nhìn thấy terminal (giao diện đẹp).
  + =>  Bạn có thể gõ lệnh trực tiếp trong container như một shell thật.
**1.2.1 Docker Engine** 
- Docker Engine là nền tảng cốt lõi của Docker, chịu trách nhiệm chạy và quản lý các container. Nó là một ứng dụng client-server, bao gồm các thành phần như Docker Daemon, Docker Client và API để tương tác.
**1.2.2 Docker Client** 
- Docker Client là công cụ giao diện người dùng (thường là CLI - Command Line Interface) để tương tác với Docker Engine.
**1.2.3 Docker Daemon** 
- Docker Daemon (dockerd) là một tiến trình chạy nền trên máy chủ, chịu trách nhiệm quản lý các đối tượng Docker như container, image, network, và volume.
**1.2.4 Docker Registry:**
- Docker Registry là kho lưu trữ để lưu và phân phối các Docker image. Docker Hub là registry công cộng phổ biến nhất, nhưng bạn cũng có thể thiết lập registry riêng.
## 2. Docker Installation

**2.1 Install with Ubuntu**
- Step 1 Update Software: sudo apt update
- Step 2 Install docker: sudo apt install docker.io -y
- Step 3 Enable and start the docker service: sudo systemctl enable docker --now (không cần vì có thể khởi động thủ công sudo docker)
- Check docker verson: docker --version
- Kiểm tra trạng thái của docker: ps aux | grep dockerd
  + ![image](https://github.com/user-attachments/assets/925e9c63-5f61-4b17-942d-5144c94193b2)
  + S là đang hoạt động, T thì đang trong trạng thái stopping -> kill nó đi sudo kill -9 830 852 863 866 867

**2.2 Executing the Docker Command Without Sudo**
- Việc bạn phải dùng sudo để chạy Docker lệnh như sudo docker ps là do quyền truy cập vào socket /var/run/docker.sock bị giới hạn cho user root hoặc nhóm docker.
- ![image](https://github.com/user-attachments/assets/68dd26d5-a07d-4acf-b9eb-0ff188234fff)
- Thêm user hiện tại vào group docker: sudo usermod -aG docker $USER
- Kiểm tra tất cả các group mà user có quyền truy cập: groups ![image](https://github.com/user-attachments/assets/d61b9a6b-a4d8-4838-9b89-afb3c073b826)
- Hoàn tất thì chúng ta có thể chạy docker mà ko cần sudo: ![image](https://github.com/user-attachments/assets/e5e3d651-6d52-4cb9-b3ff-bcb36a290850)

## 3. Docker command
- Link refer: https://docs.docker.com/reference/cli/docker/#environment-variables
- Cấu trúc tổng quát: **docker [OPTIONS] COMMAND [ARGUMENTS...]**
  + docker: câu lệnh chính để gọi docker cli
  + [OPTIONS]: Các tùy chọn đi kèm (ví dụ -d, -p, --name)
  + COMMAND: Hành động muốn thực hiện (ví dụ: run, ps, build..)
  + [ARGUMENTS...]: Các đối tượng hoặc tham số cụ thể đi kèm (ví dụ: tên image, container, file, v.v.)
- Check thông tinL https://docs.docker.com/engine/containers/run/
**3.1 Docker basic command**
- docker run: Chạy container từ image ( nếu chưa có image thì nó sẽ tự pull image từ trang web lưu trữ mặc định https://hub.docker.com)
  + Ngoài docker bub thì có thể registry riêng như AWS ECR, GitHub Container Registry,Docker Private Registry
  + -d: Chạy container ở chế độ nền.
  + -it: Chạy container tương tác với shell (rất hữu ích khi cần debug hoặc khám phá).
  + -p: Ánh xạ cổng (host:container, ví dụ: -p 8080:80).
  + -v: Gắn thư mục/volume từ host vào container.
  + --name: Đặt tên cho container.
  + --rm: Tự xóa container sau khi dừng.
  + VD: docker run -d -p 8080:80 --name my-web nginx

- docker pull: Lệnh docker pull được sử dụng để tải một image từ một registry Docker (mặc định là Docker Hub) về máy cục bộ
  + --platform: Chỉ định nền tảng của image (ví dụ: linux/amd64, linux/arm64). VD --platform linux/amd64
  + -q, --quiet: Giảm output, chỉ hiển thị tiến trình tải tối thiểu. VD: -q
  + Tham số Arguments: NAME[:TAG|@DIGEST] (bắt buộc): Tên image và tag hoặc digest cụ thể. Ví dụ: nginx: Tải image nginx với tag mặc định là latest. nginx:1.21: Tải image nginx phiên bản 1.21.
  + VD: docker pull ubuntu:20.04 hoặc  docker pull nginx
- docker ps
- docker stop: Dừng một hoặc nhiều container đang chạy bằng cách gửi tín hiệu SIGTERM (hoặc SIGKILL nếu cần).
  + --time, -t: Số giây chờ trước khi buộc dừng (ví dụ: -t 5 cho 5 giây).
  + VD docker stop my-nginx hoặc docker stop -t 2 container1 container2
- docker start: Khởi động lại một hoặc nhiều container đã dừng.
  + -i: Chạy ở chế độ tương tác (hữu ích nếu container có TTY hoặc cần tương tác).
  + docker start my-nginx
  + docker start -i my-ubuntu

 
**3.1.1 docker build**
- Cú pháp: docker build [OPTIONS] PATH | URL | - .
  + [OPTIONS]: Tùy chọn để tùy chỉnh build.
  + PATH | URL | -: Đường dẫn thư mục chứa Dockerfile (thường là .), URL đến repository, hoặc - để đọc từ STDIN.
- docker build: Xây dựng image Docker từ một Dockerfile trong thư mục được chỉ định. Hỗ trợ tạo image tùy chỉnh cho ứng dụng.
  + **-t, --tag: Đặt tên và tag cho image (ví dụ: -t my-app:latest)**
  + -f, --file: Chỉ định đường dẫn đến Dockerfile (mặc định là ./Dockerfile).
  + --build-arg: Truyền biến môi trường build-time (KEY=value). VD: --build-arg ENV=prod
  + --target:Chọn stage/profile trong multi-stage build.--target production
  + --no-cache: Không sử dụng cache khi build.
  + --pull: Luôn kéo image cơ sở mới nhất từ registry.
- VD truyền biến môi trường:
  + FIle docker: ![image](https://github.com/user-attachments/assets/17fcdb03-965b-4c2b-b3b2-efd69e6be342)
  + docker build --target dev --build-arg ENV=development -t my-app:dev .
  + VD file docker ![image](https://github.com/user-attachments/assets/d97a8e0a-63a5-494c-923a-0e6ea17ebc46)



**3.2 Docker Image Command**
***Tham khảo phần 5 Docker Images***

**3.3 Docker Container Command**
**3.3.1 Docker Container Interaction**

**3.4 Docker Volume Command**

**3.5 Docker Network Command**
***Tham khảo phần 8. Docker Networking***

**3.6 Docker Compose Command**





