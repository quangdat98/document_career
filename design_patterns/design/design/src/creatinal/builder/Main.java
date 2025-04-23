package creatinal.builder;

public class Main {
    public static void main(String[] args) {
        User user = new User.Builder("id1", "dat")
                .password("0987654321")
                .build();
        System.out.println(user);
    }
}
