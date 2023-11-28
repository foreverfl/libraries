package default_library;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class java_util_concurrent_CompletableFuture_supplyAsync {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 비동기적으로 작업을 수행하고 결과를 반환
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // 시간이 걸리는 작업을 가정
            try {
                Thread.sleep(3000); // 3초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "결과 값";
        });

        // 결과가 준비될 때까지 기다린 후 결과 출력
        System.out.println("계산 결과: " + future.get()); // 비동기 작업의 결과가 준비될 때까지 현재 스레드를 차단
    }
}
