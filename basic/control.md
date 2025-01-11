[제어권 (Control)](#제어권-control)

[함수 호출 모델에서의 제어권](#함수-호출-모델에서의-제어권)
- [직접 호출](#직접-호출)
- [콜백](#콜백)
- [Promise/Future](#promisefuture)
- [코루틴](#코루틴)

## 제어권 (Control)

프로그램 실행 중 흐름을 결정하고 제어하는 권한으로 **프로그램의 특정 코드 블록이 실행될 시점과 순서를 제어**한다

제어권은 호출자(Caller)와 호출 대상(Callee) 간의 관계에서 나타난다

어떤 코드(호출자)가 다른 코드(호출 대상)에 실행 흐름의 일부를 맡기는 과정을 **제어권 위임**이라고 한다

이후 호출 대상이 실행을 마치면 호출자에게 다시 제어권을 되돌려준다

## 함수 호출 모델에서의 제어권

### 직접 호출

호출자가 명시적으로 특정 함수를 호출하는 방식으로 **제어권은 호출된 함수로 전달된 후 반환**된다

```java
main () {
    printGreeting(); // 제어권을 printGreeting으로 넘긴다
    printGoodBye(); // 제어권을 반환받고 다음 코드를 실행한다
}

void printGreeting() {
    System.out.println("Hello"); // 로직 실행 후 제어권 반환
}
```

### 콜백

코드 실행 흐름을 제어하기 위해 다른 코드에 특정 동작(함수/메서드)을 위임하는 방식이다

**호출 대상이 콜백 실행 시점을 결정**하며 제어권의 소유자가 된다

#### 콜백에서의 제어권 흐름

1. 콜백 전달
   - 호출자가 실행할 동작(콜백 함수)을 호출 대상에게 전달한다
   - 호출 대상은 전달받은 콜백 함수를 실행 시점까지 유지한다
2. 콜백 함수 실행: 제어권 위임
   - 호출 대상이 콜백 함수를 실행하면서 제어권은 콜백 함수로 넘어간다 
3. 콜백 함수 종료: 제어권 반환
    - 콜백 함수의 실행이 끝난 후 제어권은 호출 대상에게 반환된다
    - 호출 대상의 실행도 끝나면 호출자에게 제어권을 반환한다

#### 동기 콜백

호출 대상이 콜백을 동기적으로 실행하는 방식

콜백 함수의 실행이 끝날 때까지 호출 대상의 코드는 실행되지 않는다

```java
void main() {
    int result = add(() -> System.out.println("add 1 + 2 ?"), // 콜백 함수
                            1, 2);
    
    System.out.println(result);
}

int add(Runnable callback, int a, int b) {
    callback.run(); // 콜백 함수가 끝날 때 까지 대기 상태(block)에 놓인다
    System.out.println("execute add method");
    return a + b;
}
```

```text
출력값

add 1 + 2 ?
execute add method
3
```

제어권 흐름
- main -> add 메서드를 호출하며 제어권 전달
- add -> callback.run 콜백 메서드를 호출하며 제어권 전달
- 콜백 실행 후 add 메서드에게 제어권 반환
- add 메서드 실행 후 main 메서드로 제어권 반환

#### 비동기 콜백

호출 대상이 콜백을 비동기로 실행하는 방식

콜백 함수에 제어권을 전달하지 않기 때문에 기다리지 않고 호출 대상의 코드를 실행할 수 있다

```java
void main() {
    int result = addAsynchronously(() -> System.out.println("add 1 + 2 ?"), // 콜백 함수
                            1, 2);
    
    System.out.println(result);
}

int addAsynchronously(Runnable callback, int a, int b) {
    new Thread(() -> {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
        }
        callback.run(); // 콜백 함수 실행
    }).start();
    
    System.out.println("execute add method");
    return a + b;
}
```

```text
출력값

execute add method
add 1 + 2 ?
3
```

제어권 흐름
- main -> addAsynchronously 메서드를 호출하며 제어권 전달
- addAsynchronously가 새로운 스레드에서 콜백을 실행 예약하고 자신의 코드를 실행한다
- addAsynchronously 코드 실행 후 main 메서드로 제어권 반환
- 콜백은 비동기 작업(1초 대기) 이후 실행되며 제어권을 해당 스레드로 반환한다

### Promise/Future

### 코루틴









