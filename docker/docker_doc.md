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

**1.2 Kiến trúc Docker:**

**1.2.1 Docker Engine** 

**1.2.2 Docker Client** 

**1.2.3 Docker Daemon** 

**1.2.4 Docker Registry:**

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

**3.1 Docker basic command**
- docker run: Chạy container từ image ( nếu chưa có image thì nó sẽ tự pull image từ trang web lưu trữ mặc định https://hub.docker.com)
  + NGoài docker bub thì có thể registry riêng như AWS ECR, GitHub Container Registry,Docker Private Registry
  + 
- docker pull
- docker ps
- docker stop
- docker start
- docker rm
- docker rmi
- docker images
- docker exec
- docker port
- docker login
- docker push
- docker build
- Stop Multiple Containers
- docker restart
- docker inspection
- docker commit 

**3.2 Docker Image Command**
***Tham khảo phần 5 Docker Images***

**3.3 Docker Container Command**
**3.3.1 Docker Container Interaction**

**3.4 Docker Volume Command**

**3.5 Docker Network Command**
***Tham khảo phần 8. Docker Networking***

**3.6 Docker Compose Command**





