package CompletableFutureClass;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureMain {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Hello World";
        });

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> "world"));

        System.out.println(future1.join()); // hello world
    }
}
