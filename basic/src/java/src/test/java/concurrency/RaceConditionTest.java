package concurrency;

import org.junit.jupiter.api.*;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RaceConditionTest {

    @Test
    @DisplayName("경쟁 상태 발생: 예상할 수 없는 공유 자원 값")
    void updateSharedResourceWithoutSync() throws InterruptedException {
        Counter counter = new Counter();

        // Counter 객체의 count 필드의 값을 1천번 증가시키는 작업
        Runnable task = () -> IntStream.range(0, 1000)
                .forEach((i) -> counter.increment());

        // 두 개의 스레드에 작업 할당, 총 2천번의 increment 메서드 호출
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        int result = counter.getCount();

        // 2천번의 increment 메서드를 호출했으면 count 값이 2000으로 변해야 정상이지만
        // 스레드 동기화없이 두 스레드에서 공유 자원을 수정했기 때문에 예상할 수 없는 값이 반환된다
        // 정상적인 값도 반환하여 테스트가 실패할 수도 있다
        Assertions.assertNotEquals(2000, result);

        System.out.println(result);
    }


    @Test
    @DisplayName("경쟁 상태 해결 방안 1. 동기화 키워드 사용")
    void updateSharedResourceWithSynchronizedKeyword() throws InterruptedException {

        // synchronized 동기화 키워드 사용
        // 자바의 synchronized 키워드는 모니터 락을 사용한다
        SynchronizedCounter syncCounter = new SynchronizedCounter();

        // Counter 객체의 count 필드의 값을 1천번 증가시키는 작업
        Runnable task = () -> IntStream.range(0, 1000)
                .forEach((i) -> syncCounter.increment());

        // 두 개의 스레드에 작업 할당, 총 2천번의 increment 메서드 호출
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        int result = syncCounter.getCount();

        // 스레드 동기화 키워드를 선언한 메서드를 통해 공유 자원을 수정했기 때문에 예상할 수 있는 값이 반환된다
        Assertions.assertEquals(2000, result);

        System.out.println(result);
    }

    @Test
    @DisplayName("경쟁 상태 해결 방안 2. ReentrantLock 사용")
    void updateSharedResourceWithReentrantLock() throws InterruptedException {

        // ReentrantLock은 명시적으로 모니터 락을 제어할 수 있다
        // 타임아웃, 공정정 설정 등의 추가적인 기능도 제공한다
        ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter();

        // Counter 객체의 count 필드의 값을 1천번 증가시키는 작업
        Runnable task = () -> IntStream.range(0, 1000)
                .forEach((i) -> reentrantLockCounter.increment());

        // 두 개의 스레드에 작업 할당, 총 2천번의 increment 메서드 호출
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        int result = reentrantLockCounter.getCount();

        // ReentrantLock을 사용하여 공유 자원을 수정했기 때문에 예상할 수 있는 값이 반환된다
        Assertions.assertEquals(2000, result);

        System.out.println(result);
    }

    @Test
    @DisplayName("경쟁 상태 해결 방안 3. Atomic Class 사용")
    void updateSharedResourceWithAtomicClass() throws InterruptedException {

        // Atomic 클래스는 락을 사용하지 않고 CAS(Compare-And-Swap) 알고리즘을 사용하여 낙관적 동시성 제어(Optimistic Concurrency Control)를 수행한다
        // CAS 알고리즘은 하드웨어 수준에서 지원되는 원자적 연산으로 세 가지 값(현재 값, 기대 값, 새로운 값)을 비교하여 기대 값이 현재 값과 같으면 새로운 값으로 교체한다
        // 락을 사용하지 않기 때문에 스레드 대기나 컨텍스트 스위칭이 필요없다 -> 상대적으로 더 좋은 성능
        // 다만 복잡한 상태 관리에는 부적합하고 단순 값의 변경, 증가/감소에 적합하다
        AtomicCounter atomicCounter = new AtomicCounter();

        // Counter 객체의 count 필드의 값을 1천번 증가시키는 작업
        Runnable task = () -> IntStream.range(0, 1000)
                .forEach((i) -> atomicCounter.increment());

        // 두 개의 스레드에 작업 할당, 총 2천번의 increment 메서드 호출
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        int result = atomicCounter.getCount();

        // Atomic 클래스를 사용하여 공유 자원을 수정했기 때문에 예상할 수 있는 값이 반환된다
        Assertions.assertEquals(2000, result);

        System.out.println(result);
    }


    private static class Counter extends AbstractCounter{

        // 필드 수정(동기화 처리 X)
        @Override
        public void increment() {
            this.count++;
        }
    }

    private static class SynchronizedCounter extends AbstractCounter{

        @Override
        public synchronized void increment() {
            this.count++;
        }

    }

    private static class ReentrantLockCounter extends AbstractCounter{

        private final ReentrantLock lock = new ReentrantLock();


        @Override
        public void increment() {
            lock.lock();

            try {
                count++;
            } finally {
                lock.unlock();
            }
        }
    }

    private static class AtomicCounter {

        private final AtomicInteger count = new AtomicInteger(0);

        public void increment() {
            count.incrementAndGet();
        }
        public int getCount() {
            return count.get();
        }

    }

    private static abstract class AbstractCounter {

        protected int count = 0;

        public int getCount() {
            return count;
        }

        abstract public void increment();
    }
}
