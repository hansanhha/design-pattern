# DDD(Domain Driven Design)

비즈니스 도메인이 가지고 있는 복잡한 문제들에 집중하여 모델링하는 소프트웨어 설계 방법    
-> 도메인이 해결해야 할 문제를 소프트웨어 제품에 명확하게 반영 

비즈니스 도메인 전문가와 개발자 간의 쌍방향 소통(유비쿼터스 언어)을 통한 해결할 문제에 대한 이해도가 높은 설계

## Domain

도메인은 아래와 같이 설명할 수 있음
* 프로젝트가 제공할 서비스 또는 다루는 대상(target)
* 소프트웨어에서 해결할 문제 영역(Problem Space)

문제 영역에서 도메인은 그 성격에 따라 몇 가지 종류(Sub Domain)로 분류함
* Core Domain : 차별화된 비즈니스의 핵심 도메인
* Supporting Domain : Core Domain을 지원하는 도메인 - 사내 구현 또는 아웃 소싱 선택
* Generic Domain : 공통 도메인(보안, 인증, 로깅 등) - 구현된 솔루션 사용 권장

## 설계 종류

전략적 설계(Strategic Design) : 프로젝트 개념적 설계

기술적 설계(Tactical Design)  : 프로그래밍 기술적 설계

### 전략적 설계

유비쿼터스 언어, 도메인 모델, Bounded Context를 설계하는 단계

#### Ubiquitous Language

[Ubiquitous Language](https://martinfowler.com/bliki/UbiquitousLanguage.html) : 도메인 전문가, 아키텍트, 개발자 등 프로젝트를 수행하는 조직 내부에서 공유되는 언어

유비쿼터스 언어를 통해 도메인 모델을 만들고, 도메인 모델을 기반으로 Bounded Context를 만듦

유비쿼터스 언어는 다음과 같은 곳에서 사용됨
- 구성원 간 의사소통
- 설계 모델링, UML
- 애플리케이션 코드(클래스, 메서드 명)

#### Domain Model

도메인 모델은 비즈니스 도메인의 개념과 규칙, 그리고 도메인 간의 관계를 표현하는 추상화된 모델임 

도메인 모델을 통해 프로젝트 참여자들이 도메인을 이해하고 문제 자체에 집중할 수 있음

여러 가지 방법으로 모델을 표현할 수 있음
- 객체 기반
- 상태 다이어그램 등

#### Bounded Context

[Bounded Context](https://martinfowler.com/bliki/BoundedContext.html): 비즈니스 도메인을 컨텍스트(상황)에 맞게 설계하는 방법, 비즈니스 목적 별로 서비스들을 그룹화

구성원은 각 Bounded Context에서 사용하는 유비쿼터스 언어를 통해 소통 혼란을 줄임
1개의 Bounded Context는 최소 1개 이상의 마이크로 서비스로 구성됨

Context Map : Bounded Context간의 관계를 나타내는 다이어그램

#### Event Storming

비즈니스 도메인

### 기술적 설계

전략적 설계 단계에서 만든 도메인 모델을 기반으로 프로그래밍 설계를 하는 단계

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
[DDD 핵심만 빠르게 이해하기](ttps://happycloud-lee.tistory.com/94)
[MSA 에서 유비쿼터스 언어(보편 언어)의 중요성](https://medium.com/dtevangelist/msa-%EC%97%90%EC%84%9C-%EC%9C%A0%EB%B9%84%EC%BF%BC%ED%84%B0%EC%8A%A4-%EC%96%B8%EC%96%B4-%EB%B3%B4%ED%8E%B8-%EC%96%B8%EC%96%B4-%EC%9D%98-%EC%A4%91%EC%9A%94%EC%84%B1-ca22b96aaeea)
[모두를 위한 DDD](https://blog.doctor-cha.com/introduction-to-domain-driven-design-for-everyone)
뤼튼 GPT4
