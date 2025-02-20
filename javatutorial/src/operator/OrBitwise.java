package operator;

public class OrBitwise {
    // Define permission flags
    public static final int READ = 1;    // 001
    public static final int WRITE = 2;   // 010
    public static final int DELETE = 4;  // 100

    public static void main(String[] args) {
        // Assign permissions to users
        int user1Permissions = READ | WRITE;  // User 1 có quyền đọc và ghi
        int user2Permissions = READ | DELETE; // User 2 có quyền đọc và xóa

        // Check if a user has a specific permission
        if ((user1Permissions & WRITE) != 0) {
            System.out.println("User 1 có quyền ghi.");
        } else {
            System.out.println("User 1 không có quyền ghi.");
        }

        if ((user2Permissions & WRITE) != 0) {
            System.out.println("User 2 có quyền ghi.");
        } else {
            System.out.println(user2Permissions);
            System.out.println("User 2 không có quyền ghi.");
        }
    }
}
