# DDD(Domain Driven Design)

* 비즈니스 도메인이 가지고 있는 복잡한 문제들에 집중하여 모델링하는 소프트웨어 설계 방법  
-> 도메인이 해결해야 할 문제를 소프트웨어 제품에 명확하게 반영 

* 비즈니스 도메인 전문가와 개발자 간의 쌍방향 소통(유비쿼터스 언어)을 통한 맞춤 설계

Eric Evans의 Domain-Driven Design 책에서 소개하는 객체 개념(Entities, Value Objects, Service Object 등)들은  
프로그래밍 언어나 다이어그램 표기법처럼 특정 수단을 떠나 객체에 대한 생각을 할 수 있게 함 

## Domain

도메인은 아래와 같이 설명할 수 있음
* 비즈니스 도메인(비즈니스 지식, 활동 영역 - 마케팅, 할인 등)
* 소프트웨어에서 해결할 문제 영역(Problem Space) 또는 다루는 대상(target)

문제 영역에서 도메인은 그 성격에 따라 몇 가지 종류(Sub Domain)로 분류할 수 있음
* Core Domain : 차별화된 비즈니스의 핵심 도메인
* Supporting Domain : Core Domain을 지원하는 도메인 - 사내 구현 또는 아웃 소싱 선택
* Generic Domain : 공통 도메인(보안, 인증, 로깅 등) - 구현된 솔루션 사용 권장

## 설계 종류

전략적 설계(Strategic Design) : 개념 설계

기술적 설계(Tactical Design)  : 프로그래밍 기술적 설계

### 전략적 설계

전략적 설계에서 중요한 개념은 [Bounded Context](https://martinfowler.com/bliki/BoundedContext.html)임

Bounded Context는 비즈니스 도메인을 컨텍스트(상황)에 맞게 설계하는 방법으로 비즈니스 목적 별로 서비스를 그룹화함




### Domain Model

비즈니스 도메인의 개념과 규칙, 그리고 도메인 간의 관계를 표현하는 추상화된 모델  
비즈니스 로직을 담고 있음  

```
은행이라는 비즈니스 도메인에서 계좌, 거래, 고객 등이 도메인 모델이 될 수 있음

고객 : 이름, 주소 - 정보  
계좌 : 잔액, 계좌번호 - 정보  
거래 : 입금, 출금 - 도메인 로직  
```

DDD의 Domain Model을 아래와 같이 정의할 수 있다
* 도메인의 문제를 해결하는 영역(solution space)
* 특정 도메인에 적용되는 프로그래밍 모델(problem area)

도메인 모델은 개발자와 도메인 전문가 사이의 커뮤니케이션을 도와주는 [유비쿼터스](https://martinfowler.com/bliki/UbiquitousLanguage.html)  언어로써 동작한다  

또한 소프트웨어가 어떻게 객체나 기능으로 분류되는지 개념적 토대 역할도 한다

### Bounded Context

도메인 모델이 적용되는 경계를 나타냄

각 도메인 모델의 독립성을 보장한다

Bounded Context마다 독립적인 언어, 모델, 데이터베이스 스키마를 가질 수 있다

**왜 필요할까?**

비즈니스 시나리오에서 동일한 용어나 개념이 문맥이나 사용자에 따라 다른 의미를 가질 수 있음  

그래서 도메인 모델이 복잡해지고 관리하기 어려워짐

Bounded Context는 논리적인 경계를 통해 도메인 모델을 분리함으로써 일관성을 유지할 수 있음

**독립성을 보장한다?**  
동일한 도메인은 Bounded Context 마다 별도의 규칙과 로직을 가지며, 다른 Bounded Context로부터 영향을 받지 않음 

```
예시

도메인 모델 : 주문
Bounded Context : 배송, 결제
```

배송 Bounded Context에서의 주문 : 배송 관련 규칙과 로직(주문 상태, 배송 정보 등)  

결제 Bounded Context에서의 주문 : 결제 관련 규칙과 로직(주문 결제 금액, 결제 방식)

-> 동일한 도메인 모델이 각자의 bounded context에서 독립적인 의미와 역할로 해석되어 사용됨

### Entity

### Value Object

### Service

### Repository

### Aggregate

### Domain Event


**참고**  
[github:ddd crew](https://github.com/ddd-crew)  
[Wikipedia:DDD](https://en.wikipedia.org/wiki/Domain-driven_design)  
[Wikipedia:Domain](https://en.wikipedia.org/wiki/Domain_(software_engineering))  
[domain driven design overview](https://developer.axoniq.io/domain-driven-design/overview)    
[An Introduction to Domain Driven Design](https://www.methodsandtools.com/archive/archive.php?id=97)  
[Martinfowler-DomainDrivenDesign](https://martinfowler.com/bliki/DomainDrivenDesign.html)  
[StackOverflow:subdomain](https://stackoverflow.com/questions/73077578/what-actually-is-a-subdomain-in-domain-driven-design)  
뤼튼 GPT4
