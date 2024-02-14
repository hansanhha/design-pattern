# DDD(Domain Driven Design)

* 비즈니스 도메인이 가지고 있는 복잡한 문제들에 집중하여 해당 도메인에 맞게 모델링하는 소프트웨어 설계 방법  
-> 소프트웨어에 도메인이 해결해야 할 문제를 명확하게 반영할 수 있어야 함

* 소프트웨어의 주요 복잡성이 비즈니스 도메인에서 비롯된다는 전제하에, 비즈니스 도메인과 해당 도메인의 로직을 중심으로 소프트웨어를 설계하고 개발하는 접근 방식

* 해당 비즈니스를 잘 알고 있는 전문가와 개발자가 함께 일해야 하기 때문에 소프트웨어 시스템에 비즈니스 도메인 용어와 매치되는 유비쿼터스(Ubiquitous) 언어를 적용

Eric Evans의 Domain-Driven Design 책에서 소개하는 객체 개념(Entities, Value Objects, Service Object 등)들은  
프로그래밍 언어나 다이어그램 표기법처럼 특정 수단을 떠나 객체에 대한 생각을 할 수 있게 함 

DDD에서 특히 중요한 부분은 전략적 설계(Strategic Design)라는 개념이며, 이는 대규모 도메인을 [Bounded Context](https://martinfowler.com/bliki/BoundedContext.html) Network로 구성하는 방법이다


## DDD의 핵심 요소

### Domain

DDD의 Domain을 아래와 같이 정의할 수 있다
* 소프트웨어가 해결해야 할 문제 영역(problem space)
* 소프트웨어가 대상(target)으로 하는 주제(좁은 의미, 넓은 의미를 가리지 않고)
* 유저와 상호작용을 이루는 부분(온라인 쇼핑몰 시스템-주문, 결제, 배송 등이 도메인이 될 수 있음)
* 비즈니스의 지식, 활동 등의 영역

도메인은 문제 영역(problem space)을 나타냄  
프로그래밍 영역에서 비즈니스 문제를 해결하기 위해 구성된 모든 프로그램에 대해 공통 요구사항, 용어 및 기능을 설명하여 도메인을 정의함  

#### subDomain

도메인이 꽤나 복잡해질 경우 서브 도메인으로 나눔

서브 도메인은 3가지의 종류로 구분지을 수 있음

* Core Domain : 비즈니스 특화(차별화) 도메인
* Supporting Domain : 코어 도메인을 지원하는 도메인(비즈니스와 관련이 있지만 차별화된 도메인은 아님) - 사내에서 구현 또는 아웃소싱
* Generic Domain : 공통적인 문제를 다루는 도메인(보안, 인증, 로깅 등) - 보통적인 경우 구현된 솔루션 사용

각 서브 도메인은 그 자체로 완전하고 일관된 비즈니스 모델을 가짐

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
Bounded Context 내에서 도메인 모델은 자신만의 규칙과 로직을 가지며, 다른 Bounded Context로부터 영향을 받지 않음 

다음과 같은 상황이 있음  
도메인 모델 : 주문
Bounded Context : 배송, 결제

배송 Bounded Context에서의 주문 모델은 배송 관련 규칙과 로직을 가짐(주문의 상태와 배송 정보 등)
결제 Bounded Context에서의 주문 모델은 결제 관련 규칙과 로직을 가짐(주문의 결제 금액과 방식)

동일한 도메인 모델이 각자의 bounded context에서 독립적인 의미와 역할로 해석되어 사용됨

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
