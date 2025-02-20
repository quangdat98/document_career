package operator;

public class XOR {
    public static void main(String[] args) {
        String secretMessage = "Hello, World!";
        int key = 25; // Key for XOR encryption

        // Encrypt the message
        String encryptedMessage = xorEncrypt(secretMessage, key);
        System.out.println("Encrypted message: " + encryptedMessage);

        // Decrypt the message
        String decryptedMessage = xorEncrypt(encryptedMessage, key);
        System.out.println("Decrypted message: " + decryptedMessage);
    }

    public static String xorEncrypt(String message, int key) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ key);
        }
        return new String(chars);
    }
}

class XOR2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7, 56};

        int xorSum = 0;
        for (int num : arr1) {
            xorSum ^= num;
        }
        for (int num : arr2) {
            xorSum ^= num;
        }

        System.out.println("Các phần tử khác nhau trong hai mảng: " + xorSum); // 2
    }
}
