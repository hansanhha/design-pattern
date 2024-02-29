## Functional Programming

함수형 프로그래밍

함수를 적용하고 구성하여 프로그램을 작성하는 패러다임으로 명령형(imperative) 프로그래밍 패러다임의 일종이다

함수가 프로그램의 상태를 업데이트하는 명령문의 순서가 아니라 값에서 다른 값으로 매핑하는 표현식의 트리로서 사용된다

함수 기반 계산 시스템인 람다 미적분학에서 발전함

## First-class citizens

함수형 프로그래밍에서는 함수가 일급 시민(first-class citizen)으로 다뤄진다 

따라서 함수가 data type처럼 취급되므로 다양한 용도로 사용할 수 있음

* 이름 바인딩
* 함수의 인자
* 함수의 return 값

이름 바인딩이란 함수의 이름을 특정 값이나 함수에 연결하는 것을 의미함 

아래의 경우 add 함수를 sum에 바인딩함

```python
def add(x ,y):
    return x + y;

sum = add;
```

## Pure Function

순수함수는 동일한 입력에 대해 동일한 출력을 반환하는 함수로서 변경 가능한 상태(mutable state)에 영향을 받거나 부작용(side effect)이 없는 함수를 말한다

순수함수를 통해 프로그램의 상태를 변경하지 않고도 데이터를 처리할 수 있다

## Languages 

Clojure

Erlang

Elixir

Haskell


