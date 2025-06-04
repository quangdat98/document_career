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
12. Miscellaneous

----------------------------------------------------------------------------------------------------------------------------
## 1. Docker Introduction

## 2. Docker Installation

**2.1 Install with Ubuntu**
- Step 1 Update Software: sudo apt update
- Step 2 Install docker: sudo apt install docker.io -y
- Step 3 Enable and start the docker service: sudo systemctl enable docker --now (không cần vì có thể khởi động thủ công sudo docker)
- Check docker verson: docker --version
- Kiểm tra trạng thái của docker: ps aux | grep dockerd
  + ![image](https://github.com/user-attachments/assets/925e9c63-5f61-4b17-942d-5144c94193b2)
  + S là đang hoạt động, T thì đang trong trạng thái stopping -> kill nó đi sudo kill -9 830 852 863 866 867

