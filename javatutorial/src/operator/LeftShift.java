package operator;

public class LeftShift {
    public static void main(String[] args) {
        System.out.println(4<<1); //8

        System.out.println(0b1000);
        System.out.println(012); // 1* 8^1 + 2 * 8 ^0 = 10
        System.out.println(0x12); // 1* 16^1 + 2 * 16^0 = 18
    }
}
