package loop;

public class label {
    public static void main(String[] args) {
        outerLoop: // Nhãn của vòng lặp ngoài
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 1) {
                    break outerLoop; // Dừng cả 2 vòng lặp
                }
                System.out.println("i = " + i + ", j = " + j);
            }
        }
    }
}
