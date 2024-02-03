## Sync, Async

task 수행(execution) 후 결과를 어떻게 처리하는지에 따른 구분  
-> 결과 처리에 주안

**Synchronous(동기 처리)**  
다른 task의 결과가 반환될 때까지 기다리는 방식

task A가 task B의 작업이 완료되어 결과를 응답할 때까지 기다린다

이어달리기에서 달리기 선수 간 바통 터치를 통해 주자를 넘기는 것과 유사함 

**Asynchronous(비동기 처리)**  
다른 task의 결과를 기다리지 않고 작업을 진행하는 방식  

task A가 task B를 호출한 뒤 자체 작업을 진행한다

task B의 작업이 완료되어 task A에게 결과를 응답하더라도 그 즉시 처리되지 않고, 나중에 처리할 수 있다(task A 자신의 작업을 계속 진행할 수 있다)  

비동기 처리는 MultiTasking이 가능하다(MultiThreading, MultiProcessing) 

## Blocking, Non-Blocking

실행 컨텍스트의 제어권을 어떻게 관리하는지에 따른 구분  
-> 제어권에 주안

**Blocking**  
발신자는 수신자에게 제어권을 넘기고, 수신자가 완료하고 제어권을 반환할 때까지 기다리는 방식

**Non-Blocking**
발신자는 수신자의 함수가 완료되길 기다리지 않으며, 제어권을 넘겨주지 않고 다른 task를 수행하는 방식

## 조합

**Sync Blocking**  
작업 요청과 결과 처리를 순차적으로 진행   

task는 다른 task의 작업이 완료될 때까지 기다리며, 다른 작업을 수행할 수 없음(blocking)  

다른 task의 결과를 순차적으로 처리함(synchronous)

task의 결과가 다른 task에 바로 영향을 미칠 때 유용함

**Async Non-Blocking**  
작업 요청과 결과 처리를 병렬로 진행

task들은 다른 task들을 기다리지 않고 자신의 작업을 진행함(non-blocking)  

task의 결과를 즉시 처리하지 않음(asynchronous) -> 순차적인 순서 유지를 하지 않음

task의 결과가 다른 task에 영향을 미치지 않을 때 유용함

**Sync Non-Blocking**  
task들은 다른 task들을 기다리지 않고 자신의 작업을 진행함(non-blocking)  

다른 task의 결과를 순차적으로 처리함(synchronous)  

I/O 작업에서 사용된다  

파일을 읽는 작업을 요청하고 다른 작업을 진행하다가, 파일을 읽기 작업이 완료되면 그 결과를 처리함  

**Async Blocking**  
task는 다른 task의 작업이 완료될 때까지 기다리며, 다른 작업을 수행할 수 없음(blocking)

task의 결과를 즉시 처리하지 않음(asynchronous)  

**참고 문서**
- [understanding-synchronous-vs-asynchronous-execution-and-blocking-vs-non-blocking-operations](https://blog.function12.io/tag/insight/understanding-synchronous-vs-asynchronous-execution-and-blocking-vs-non-blocking-operations/)

